package com.sie.app.newsdk.test.vm;

import com.sie.snest.sdk.BaseModel;
import com.sie.snest.sdk.annotation.meta.Model;
import com.sie.snest.sdk.annotation.vm.View;

/**
 * @author chun
 * @date 2023/3/15 10:34
 */
@Model(type = Model.ModelType.View)
@View.From("meta_model_property")
public class MetaPropertyVm extends BaseModel<MetaPropertyVm> {
    private String name;

    @View.MapProperty("model_ids")
    private String model;

    @View.MapProperty("model_ids.app_ids")
    private String app;
}
