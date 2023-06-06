package com.sie.test.app.model;

import com.sie.snest.engine.model.Bool;
import com.sie.snest.sdk.BaseModel;
import com.sie.snest.sdk.annotation.meta.Model;

/**
 * @author lijun10
 * @date 2023/3/13 9:52
 */
@Model(name = "people",isAbstract = Bool.True,displayName = "角色父类")
public class Person extends BaseModel<Person> {

    private String name;
}
