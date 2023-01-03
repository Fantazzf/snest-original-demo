package com.sie.app.newsdk.test.model;

import com.sie.snest.engine.model.Bool;
import com.sie.snest.sdk.BaseModel;
import com.sie.snest.sdk.DataType;
import com.sie.snest.sdk.annotation.meta.MethodService;
import com.sie.snest.sdk.annotation.meta.Model;
import com.sie.snest.sdk.annotation.meta.Property;
import com.sie.snest.sdk.annotation.orm.JoinColumn;
import com.sie.snest.sdk.annotation.orm.ManyToOne;
import com.sie.snest.sdk.annotation.orm.ModelEnum;
import com.sie.snest.sdk.annotation.validate.Validate;

import java.util.Date;


/**
 * 测试用户
 * @author sie
 */
@Model
public class TestUser extends BaseModel {

    @Property(columnName = "name", displayName = "名称")
    @Validate.NotBlank
    private String name;

    @Validate.Email(message = "邮箱格式不正确")
    @Property(columnName = "email", displayName = "邮箱")
    private String email;


	@Property(columnName = "status", displayName = "状态", dataType = DataType.ENUM, values = { @ModelEnum(label = "启用", value = "1"),
			@ModelEnum(label = "禁用", value = "0") }, defaultValue = "1")
    private Boolean status;

    @Property(columnName = "phone", displayName = "电话号码")
    @Validate.Phone(message = "手机号格式不正确")
    private String phone;

    @Validate.Size(max = 100, min = 0)
    @Property(columnName = "age", displayName = "年龄")
    private Integer age;

    @Validate.NotBlank
    @Property(columnName = "password", displayName = "密码")
    private String password;

    @Property(columnName = "test", displayName = "测试")
    private String test;

    @Property(columnName = "method", computeMethod = "method", displayName = "计算方法")
    private String method;

    @Property(columnName = "script", computeScript = "3+100", displayName = "计算脚本")
    private String script;


    @ManyToOne(displayName = "组织机构")
    @JoinColumn(name = "org_id", referencedColumnName = "id")
    private TestOrg org;


    public Date getCreate() {
        return (Date) this.get("create");
    }

    public void setCreate(Date create) {
        this.set("create", create);
    }

    public String getPhone() {
        return (String) this.get("phone");
    }

    public void setPhone(String phone) {
        this.set("phone", phone);
    }

    public String getEmail() {
        return (String) this.get("email");
    }

    public void setEmail(String email) {
        this.set("email", email);
    }

    public void setPassword(String password) {
        this.set("password", password);
    }

    public String getPassword() {
        return (String) this.get("password");
    }


    public String getName() {
        return (String) this.get("name");
    }

    public void setName(String name) {
        this.set("name", name);
    }

    public Integer getAge() {
        return (Integer) this.get("age");
    }

    public void setAge(Integer age) {
        this.set("age", age);
    }

    public TestOrg getOrg() {
        return (TestOrg) this.get("org");
    }

    public TestUser setOrg(TestOrg org) {
        this.set("org", org);
        return this;
    }

    /**
     * 创建用户服务
     * @param user
     */
    @MethodService(description = "创建用户")
    public void createUser(TestUser user) {
        user.setName("111");
        user.setAge(32);
        user.setEmail("2222222222211@qq.com");
        user.setPhone("18767176707");
        user.setPassword("123456");
        user.create();
    }


    /**
     * 计算属性指定的方法
     * @param str 传入属性值
     * @return 返回计算后的值
     */
    public String method(String str) {
        return str + " computer";
    }


    @MethodService(name = "getById", auth = "read")
    public TestUser getById(String id) {
        TestUser testUser = new TestUser();
        testUser.setId(id);
        return testUser.selectById(id);
    }

}
