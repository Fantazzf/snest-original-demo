package com.sie.app.newsdk.test.model.download;

import com.sie.snest.engine.data.RecordSet;
import com.sie.snest.engine.utils.ConfigUtils;
import com.sie.snest.engine.utils.MinioTemplate;
import com.sie.snest.engine.utils.OssProperties;
import com.sie.snest.sdk.BaseModel;
import com.sie.snest.sdk.annotation.meta.MethodService;
import com.sie.snest.sdk.annotation.meta.Model;
import com.sie.snest.sdk.annotation.orm.Ignore;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.InputStream;

@Model
public class TestFile extends BaseModel<TestFile> {
    @Ignore
    private final static Logger logger = LoggerFactory.getLogger(TestFile.class);

    @MethodService
    public void download(RecordSet rs, String fileName) {
        getMeta().getArguments().put("@file_return", "@file_return");

        getMeta().getResponse().setCharacterEncoding("utf-8");
        getMeta().getResponse().setHeader("Content-disposition", "attachment;filename*=utf-8''" + fileName);
        getMeta().getResponse().setHeader("download-filename", fileName);

        String minioEndpoint = ConfigUtils.get("minio.endpoint");
        String minioAccessKey = ConfigUtils.get("minio.accessKey");
        String minioSecretKey = ConfigUtils.get("minio.secretKey");
        String minioBucketName = ConfigUtils.get("minio.bucketName");

        OssProperties ossProperties = new OssProperties(minioEndpoint, minioAccessKey, minioSecretKey, minioBucketName);
        MinioTemplate minioTemplate = MinioTemplate.getInstance(ossProperties);
        InputStream is = minioTemplate.getObject(minioBucketName, fileName);
        getMeta().getResponse().setContentType("application/octet-stream");

        byte[] buf = new byte[1024];
        int len;
        try {
            while ((len = is.read(buf)) != -1) {
                getMeta().getResponse().getByteArrayoutputStream().write(buf, 0, len);
            }
            getMeta().getResponse().getByteArrayoutputStream().flush();
        } catch (Exception e) {
            logger.info("文件下载失败.bucketName:{}, objectName:{}, msg:{}", minioBucketName, fileName, e.getMessage());
        }
    }
}
