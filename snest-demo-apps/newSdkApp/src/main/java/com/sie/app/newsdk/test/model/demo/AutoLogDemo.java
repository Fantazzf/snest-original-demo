package com.sie.app.newsdk.test.model.demo;

import com.sie.snest.engine.model.Bool;
import com.sie.snest.sdk.BaseModel;
import com.sie.snest.sdk.annotation.meta.Model;
import com.sie.snest.sdk.annotation.meta.Property;

/**
 * @author Kris
 */
@Model(isAutoLog = Bool.True)
public class AutoLogDemo extends BaseModel<AutoLogDemo> {

    @Property(displayName = "名称")
    private String name;
}
