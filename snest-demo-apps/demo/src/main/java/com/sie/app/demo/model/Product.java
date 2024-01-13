package com.sie.app.demo.model;

import com.sie.snest.engine.model.Bool;
import com.sie.snest.sdk.BaseModel;
import com.sie.snest.sdk.annotation.meta.Model;
import com.sie.snest.sdk.annotation.meta.Property;
import com.sie.snest.sdk.annotation.orm.OneToMany;
import com.sie.snest.sdk.annotation.validate.Validate;

import java.util.List;

@Model(name = "product",displayName = "产品",isAutoLog = Bool.True)
public class Product extends BaseModel<Product> {
    @Property(displayName = "名称",displayForModel = true)
    @Validate.NotBlank
    private String name;

    @Property(displayName = "编码")
    @Validate.Unique
    private String code;

    @OneToMany
    private List<ProductBom> productBomList;
}
