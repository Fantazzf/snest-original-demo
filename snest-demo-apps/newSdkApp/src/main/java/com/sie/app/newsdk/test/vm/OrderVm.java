package com.sie.app.newsdk.test.vm;

import com.sie.snest.sdk.BaseModel;
import com.sie.snest.sdk.annotation.meta.Model;
import com.sie.snest.sdk.annotation.vm.View;

import java.util.Date;

/**
 * @Author chun
 * @Date 2023/05/08/16:00
 */
@Model(name = "demo_order_vm", type = Model.ModelType.View, orderBy = "name")
@View.From("demo_order")
public class OrderVm extends BaseModel<OrderVm> {
    private String name;
    private Date date;

    @View.MapProperty("customer")
    private String customer;

    @View.MapProperty("customer2")
    private String customer2;

    private String customer3;

    private String customer4;

    private String customer5;

    private int price;
}
