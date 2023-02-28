package com.sie.app.feigndemo.model;

import com.sie.app.feigndemo.client.SpringApp;
import com.sie.snest.sdk.BaseModel;
import com.sie.snest.sdk.annotation.meta.MethodService;
import com.sie.snest.sdk.annotation.meta.Model;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author chun
 */
@Model(name = "feigndemo_remoteproxy", type = Model.ModelType.Data)
public class RemoteProxy extends BaseModel<RemoteProxy> {
    private final static Logger logger = LoggerFactory.getLogger(RemoteProxy.class);
    /**
     * 启动 可以在app.json的启动事件里配置
     */
    public void start() {
        logger.info("启动feign客户端");
        SpringApp.start(new String[0], RemoteProxy.class.getClassLoader());
    }

    @MethodService
    public Object query() {
        String s = SpringApp.getSpringApp().getStoreClient().checkHealth();
        return s;
    }

    /**
     * 停止 可以在app.json的启动事件里配置
     */
    public void stop() {
        logger.info("停止feign客户端");
        SpringApp.stop();
    }
}
