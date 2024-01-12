package com.sie.app.demo.model;

import com.sie.snest.engine.model.Bool;
import com.sie.snest.sdk.BaseModel;
import com.sie.snest.sdk.annotation.meta.Model;
import com.sie.snest.sdk.annotation.meta.Property;
import com.sie.snest.sdk.annotation.orm.JoinColumn;
import com.sie.snest.sdk.annotation.orm.ManyToOne;

@Model(name = "product_bom",displayName = "产品BOM",isAutoLog = Bool.True)
public class ProductBom extends BaseModel<ProductBom> {
    @ManyToOne(displayName = "产品")
    @JoinColumn
    private  Product product;

    @ManyToOne(displayName = "物料")
    @JoinColumn
    private  Material material;

    @Property(displayName = "数量")
    private  Double amount;
}
