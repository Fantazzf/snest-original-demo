package com.sie.app.newsdk.test.vm;

import com.sie.snest.sdk.BaseModel;
import com.sie.snest.sdk.DataType;
import com.sie.snest.sdk.annotation.meta.Model;
import com.sie.snest.sdk.annotation.meta.Property;
import com.sie.snest.sdk.annotation.orm.JoinColumn;
import com.sie.snest.sdk.annotation.orm.ManyToOne;

import java.util.List;

/**
 * @Author chun
 * @Date 2023/06/04/20:11
 */
@Model(name = "demo_order_detail")
public class OrderDetail extends BaseModel<OrderDetail> {
    @Property
    private String name;
    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    @Property(columnName = "dish_name", dataType = DataType.LIST)
    private List<String> dishName;
}
