package com.sie.app.newsdk.test.vm;

import com.sie.snest.sdk.BaseModel;
import com.sie.snest.sdk.annotation.meta.Model;
import com.sie.snest.sdk.annotation.vm.View;

import java.util.List;

/**
 * @Author chun
 * @Date 2023/06/04/20:16
 */
@Model(name = "demo_order_detail_vm", type = Model.ModelType.View, orderBy = "name")
@View.From("demo_order_detail")
public class OrderDetailVm extends BaseModel<OrderDetailVm> {
    private String name;

    private String dishName;

    @View.MapProperty("order.customer")
    private String customer;

    @View.MapProperty("order.customer.name")
    private String customer1;
}
