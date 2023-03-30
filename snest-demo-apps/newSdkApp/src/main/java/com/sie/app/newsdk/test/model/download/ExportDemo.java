package com.sie.app.newsdk.test.model.download;

import com.sie.snest.engine.data.RecordSet;
import com.sie.snest.sdk.BaseModel;
import com.sie.snest.sdk.annotation.meta.MethodService;
import com.sie.snest.sdk.annotation.meta.Model;
import com.sie.snest.sdk.annotation.meta.Property;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @author Kris
 */
@Model(displayName = "导出示例")
public class ExportDemo extends BaseModel<ExportDemo> {

    @Property(displayName = "名称", displayForModel = true)
    private String name;

    @MethodService
    public void importTemplate(RecordSet rs) {
        Map<String, List<Map<String, Object>>> exportData = new LinkedHashMap<>();
        List<Map<String, Object>> sheetDate = new LinkedList<>();
        Map<String, Object> data = new HashMap<>(1);
        data.put("名称", "1");
        sheetDate.add(data);
        exportData.put("Sheet1", sheetDate);
        rs.getMeta().get("base_excel").call("fileExport", exportData, System.currentTimeMillis() +
            ".xlsx");
    }
}
