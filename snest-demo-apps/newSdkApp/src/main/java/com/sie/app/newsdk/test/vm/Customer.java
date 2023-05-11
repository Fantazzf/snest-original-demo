package com.sie.app.newsdk.test.vm;

import com.sie.snest.sdk.BaseModel;
import com.sie.snest.sdk.annotation.meta.Model;
import com.sie.snest.sdk.annotation.meta.Property;
import com.sie.snest.sdk.annotation.orm.OneToMany;

import java.util.List;
import java.util.Map;

/**
 * @Author chun
 * @Date 2023/05/08/15:07
 */
@Model(name = "demo_customer")
public class Customer extends BaseModel<Customer> {


    @Property
    private String name;
    @Property
    private String streetAddress;
    @Property
    private String city;
    @Property
    private String province;
    @Property
    private String phone;
    @OneToMany
    private List<Order> orders;

    @Property(computeMethod = "computeDesc")
    private String desc;

    public String computeDesc(Map<String, Object> map) {
        return "ff";
    }

    public String getName() {
        return (String) this.get("name");
    }

    public void setName(String name) {
        this.set("name", name);
    }

    public String getStreetAddress() {
        return (String) this.get("streetAddress");
    }

    public void setStreetAddress(String streetAddress) {
        this.set("streetAddress", streetAddress);
    }

    public String getCity() {
        return (String) this.get("city");
    }

    public void setCity(String city) {
        this.set("city", city);
    }

    public String getProvince() {
        return (String) get("province");
    }

    public void setProvince(String province) {
        this.set("province", province);
    }

    public String getPhone() {
        return (String) this.get("phone");
    }

    public void setPhone(String phone) {
        this.set("phone", phone);
    }

    public List<Order> getOrders() {
        return (List<Order>) this.get("orders");
    }

    public void setOrders(List<Order> orders) {
        this.set("orders", orders);
    }

//    @Cache(name = "C1", key = "s{1}.value {1} {2} {3} {4} {5}")
//    @Override
//    public List<Customer> search(Filter filter, List<String> properties, Integer limit, Integer offset, String order) {
//        return super.search(filter, properties, limit, offset, order);
//    }
//
//    @Cache(name = "C1")
//    public String[] create(List<Map<String, Object>> valuesList) {
//
//    }
//
//    public String update(Map<String, Object> values) {
//
//    }
//
//    public boolean delete(String id) {
//
//    }

}
