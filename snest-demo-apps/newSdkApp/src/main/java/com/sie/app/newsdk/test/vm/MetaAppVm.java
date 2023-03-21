package com.sie.app.newsdk.test.vm;

import com.sie.snest.sdk.BaseModel;
import com.sie.snest.sdk.annotation.meta.Model;
import com.sie.snest.sdk.annotation.vm.SQLFunction;
import com.sie.snest.sdk.annotation.vm.View;

/**
 * @author chun
 * @date 2023/3/9 11:29
 */
@Model(type = Model.ModelType.View)
@View.From("meta_app")
public class MetaAppVm extends BaseModel<MetaAppVm> {
    /**
     * 映射meta_app模型的name属性，字符串类型
     */
    private String name;

    private String display_name;

    private String summary;

    /**
     * 映射meta_app模型的source属性，字符串类型
     */
    @View.MapProperty(value = "source", filter = "[[\"source\", \"=\", \"'base'\"]]")
    private String app_source;

    @View.MapProperty(value = "category_ids.name")
    private String categoryName;

    @View.MapProperty(value = "category_ids.description")
    private String categoryDescription;

    /**
     * 映射meta_app模型的dependency_ids属性，OneToMany
     */
    @View.MapProperty("dependency_ids")
    private String dependency;

    /**
     * 映射meta_app模型的product属性，ManyToOne
     */
    private String product;


    @View.MapProperty("model_ids.name")
    @View.MapFunction(value = SQLFunction.JOIN, args = ",")
    private String modelNames;
}
