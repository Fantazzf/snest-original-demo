package com.sie.app.newsdk.test.model;

import com.sie.snest.engine.rule.model.type.ResourceType;
import com.sie.snest.engine.rule.model.type.ScopeEnum;
import com.sie.snest.sdk.BaseModel;
import com.sie.snest.sdk.annotation.meta.Model;
import com.sie.snest.sdk.annotation.meta.Property;
import com.sie.snest.sdk.annotation.rule.Rules;

@Model
@Rules.Condition(scope = ScopeEnum.USER, object = "02hej7bkhto1t", name = "r01")
@Rules.Action(
        name = "r11",
        condition = "r01",
        resources = @Rules.Resource(
                name = "r02",
                type = ResourceType.MENU,
                resource = "base_developer_center"
        )
)
public class TestRule extends BaseModel {
    @Property
    private String test;
}
