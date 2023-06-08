package com.sie.app.newsdk.test.vm;

import com.sie.snest.sdk.BaseModel;
import com.sie.snest.sdk.DataType;
import com.sie.snest.sdk.annotation.meta.Model;
import com.sie.snest.sdk.annotation.meta.Property;
import com.sie.snest.sdk.annotation.orm.JoinColumn;
import com.sie.snest.sdk.annotation.orm.ManyToOne;
import com.sie.snest.sdk.annotation.orm.Selection;

import java.util.Date;

/**
 * @Author chun
 * @Date 2023/05/08/15:09
 */
@Model(name = "demo_order")
public class Order extends BaseModel<Order> {
    @Property
    private String name;
    @Property(dataType = DataType.DATE_TIME)
    private Date date;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "customer2_id")
    private Customer customer2;

    @Property(columnName = "customer3_id")
    @Selection(model = "demo_customer", properties = "name")
    private String customer3;

    @ManyToOne
    @JoinColumn(name = "customer4_id", referencedProperty = "name")
    private Customer customer4;

    @ManyToOne
    @JoinColumn(name = "customer5_id", referencedProperty = "name", length = 40)
    private Customer customer5;

    @Property
    private int price;
}
