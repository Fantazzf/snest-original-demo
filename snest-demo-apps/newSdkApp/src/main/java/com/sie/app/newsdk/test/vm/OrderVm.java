package com.sie.app.newsdk.test.vm;

import com.sie.snest.sdk.BaseModel;
import com.sie.snest.sdk.annotation.meta.Model;
import com.sie.snest.sdk.annotation.vm.View;

import java.util.Date;

/**
 * @Author chun
 * @Date 2023/05/08/16:00
 */
@Model(name = "demo_order_vm", type = Model.ModelType.View)
@View.From("demo_order")
public class OrderVm extends BaseModel<OrderVm> {
    private Date date;

    @View.MapProperty("customer.name")
    private String customer;

    @View.MapProperty("customer2.name")
    private Customer customer2;

    private int price;
}
