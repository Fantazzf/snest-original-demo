package com.sie.app.newsdk.test.model.excel;

import com.sie.snest.engine.data.RecordSet;
import com.sie.snest.engine.rule.Filter;
import com.sie.snest.sdk.BaseModel;
import com.sie.snest.sdk.annotation.meta.MethodService;
import com.sie.snest.sdk.annotation.meta.Model;
import com.sie.snest.sdk.annotation.meta.Property;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Model(name = "base_user", parent = "base_excel", displayName = "基本用户")
public class ExcelTest extends BaseModel<ExcelTest> {
    @Property(displayName = "用户名")
    private String username;
    @Property(displayName = "昵称")
    private String nickname;
    @Property(displayName = "真实姓名")
    private String realname;
    @Property(defaultMethod = "性别")
    private String sex;
    @Property(displayName = "公司")
    private String co;

    @MethodService(description = "excel导出")
    public void excelExport(RecordSet rs, Filter filter, List<String> properties) {
        Map<String, List<Map<String, Object>>> exportDatas = new LinkedHashMap<>();
        List<Map<String, Object>> result = new ArrayList<>();
        List<ExcelTest> baseUsers = this.search(filter, properties, 0, 0, null);
        for (ExcelTest baseUser : baseUsers) {
            result.add(baseUser);
        }
        exportDatas.put("Sheet1", result);
        rs.getMeta().get("base_excel").call("fileExport", exportDatas, System.currentTimeMillis() +
                ".xlsx");
    }

    @MethodService(description = "excel导入")
    public boolean excelImport(RecordSet rs, String fileId) {
        Map<String, List<Map<String, Object>>> fileMap = (Map<String, List<Map<String, Object>>>) rs.getMeta().get(
                "base_excel").call("fileImport", fileId);
        List<Map<String, Object>> sheet1 = fileMap.get("Sheet1");
        for (Map<String, Object> r : sheet1) {
            r.remove("id");
            rs.create(r);
        }
        return true;
    }
}
