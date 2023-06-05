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
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "customer2_id", referencedColumnName = "id")
    private Customer customer2;

    @Property
    private int price;
}
