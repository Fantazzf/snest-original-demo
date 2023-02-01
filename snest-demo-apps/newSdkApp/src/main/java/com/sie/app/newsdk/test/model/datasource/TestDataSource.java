package com.sie.app.newsdk.test.model.datasource;

import com.sie.snest.sdk.BaseModel;
import com.sie.snest.sdk.annotation.meta.Model;
import com.sie.snest.sdk.annotation.meta.Property;
import com.sie.snest.sdk.annotation.orm.Option;
import com.sie.snest.sdk.annotation.orm.Selection;

@Model(name = "TestDataSource", description = "数据源")
public class TestDataSource extends BaseModel {

    @Property(displayName = "数据源类型", widget = "radio-group")
    @Selection(values = {@Option(label = "DB/SQL", value = "DB", groups = Db.class), @Option(label = "API", value = "API", groups = Api.class),
            @Option(label = "Excel", value = "Excel"), @Option(label = "IIOT", value = "IIOT", groups = Iiot.class)})
    private String type;


    interface Db {
    }

    interface Api {
    }

    interface Iiot {

    }
}
