package com.sie.app.newsdk.test.vm;

import com.sie.snest.sdk.BaseModel;
import com.sie.snest.sdk.annotation.meta.Model;
import com.sie.snest.sdk.annotation.meta.Property;
import com.sie.snest.sdk.annotation.vm.SQLFunction;
import com.sie.snest.sdk.annotation.vm.View;

/**
 * @Author chun
 * @Date 2023/05/08/15:48
 */
@Model(name = "demo_customer_vm", type = Model.ModelType.View)
@View.From("demo_customer")
public class CustomerVm extends BaseModel<CustomerVm> {
    @View.MapProperty("name")
    private String customer;
    private String streetAddress;
    private String city;
    private String province;
    private String phone;
    @View.MapProperty("orders.name")
    @View.MapFunction(value = SQLFunction.JOIN,args = ", ")
    private String orders;
    @View.MapProperty("orders.price")
    @View.MapFunction(value = SQLFunction.SUM)
    private String allPrice;

    @Property
    private String time;
}
