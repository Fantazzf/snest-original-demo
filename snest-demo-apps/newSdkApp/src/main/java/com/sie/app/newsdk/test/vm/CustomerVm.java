package com.sie.app.newsdk.test.vm;

import com.sie.snest.engine.rule.Filter;
import com.sie.snest.sdk.BaseModel;
import com.sie.snest.sdk.annotation.meta.MethodService;
import com.sie.snest.sdk.annotation.meta.Model;
import com.sie.snest.sdk.annotation.meta.Property;
import com.sie.snest.sdk.annotation.vm.SQLFunction;
import com.sie.snest.sdk.annotation.vm.View;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

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

    public String getTime() {
        return (String) this.get("time");
    }

    public void setTime(String time) {
        this.set("time", time);
    }

    /**
     * 只添加@Property属性，代表不映射
     * 可重写search方法，自由赋值
     */
    @Property
    private String time;

    @Override
    public List<CustomerVm> search(Filter filter, List<String> properties, Integer limit, Integer offset, String order) {
        List<CustomerVm> result = super.search(filter, properties, limit, offset, order);
        String timeStr = LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
        for (CustomerVm customerVm : result) {
            customerVm.set("time", timeStr);
        }
        return result;
    }



    @MethodService
    public Object test1() {
        return "demo_customer test1";
    }
}
