package com.sie.app.newsdk.test.model;

import com.sie.snest.engine.model.Bool;
import com.sie.snest.sdk.BaseModel;
import com.sie.snest.sdk.annotation.meta.Model;

/**
 * @author lijun10
 * @date 2023/2/9 14:08
 */
@Model(isAbstract = Bool.True)
public class DemoNotInheirt extends BaseModel {

    private String name;


}
