package com.sie.app.newsdk.test.model;

import com.sie.snest.engine.data.service.BaseService;
import com.sie.snest.engine.utils.Options;
import com.sie.snest.sdk.BaseModel;
import com.sie.snest.sdk.CascadeType;
import com.sie.snest.sdk.DataType;
import com.sie.snest.sdk.annotation.meta.MethodService;
import com.sie.snest.sdk.annotation.meta.Model;
import com.sie.snest.sdk.annotation.meta.Property;
import com.sie.snest.sdk.annotation.orm.*;
import com.sie.snest.sdk.annotation.validate.Validate;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;


/**
 * 测试用户
 *
 * @author sie
 */
@Model
public class TestUser extends BaseModel {

    @Property(columnName = "name", displayName = "名称",displayForModel = true)
    //@Validate.NotBlank
    private String name;

    @Validate.Email(message = "邮箱格式不正确")
    @Property(columnName = "email", displayName = "邮箱")
    private String email;


    @Property(columnName = "status", displayName = "状态", dataType = DataType.ENUM, values = {
            @ModelEnum(label = "启用", value = "1"),
            @ModelEnum(label = "禁用", value = "0")}, defaultValue = "1")
    private Boolean status;

    @Property(columnName = "phone", displayName = "电话号码")
    @Validate.Phone(message = "手机号格式不正确")
    private String phone;

    @Validate.Max(110)
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

    @ManyToOne(displayName = "组织机构", cascade = {CascadeType.DEL_SET_NULL})
    @JoinColumn(name = "org_id", referencedColumnName = "id")
    private TestOrg org;


	@Property(displayName = "selectStatus", defaultValue = "1")
	@Selection(values = { @Option(label = "启用", value = "1"), @Option(label = "禁用", value = "2"), @Option(label = "已删除", value = "3") })
	private String selectStatus;

	@Property(displayName = "selectMetod")
	@Selection(method = "selectMetod")
	private String selectMetod;

	@Property(displayName = "selectModel")
	@Selection(model = "TestOrg", properties = "name", orderBy = "name desc")
	private String selectModel;

    @ManyToMany
    @JoinTable(name = "role_user", joinColumns = @JoinColumn(name = "role_id", nullable = false),
            inverseJoinColumns = @JoinColumn(name = "user_id", nullable = false))
    private List<TestUser> userList;


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

    @MethodService(description = "更新用户")
    public int update(@BaseService.Spec(doc = "k v") Map<String, Object> values) {
        this.putAll(values);
        this.update();
        return 0;
    }

    /**
     * 创建用户服务
     *
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

        TestRole role = new TestRole();
        role.setRoleName("test");
        role.set("remark", "测试");
        role.create();
    }



	/**
	 * 创建用户服务
	 */
	@MethodService(description = "selectMetod")
	public List<Options> selectMetod() {
		List<Options> options = new ArrayList<Options>();
		options.add(Options.of("001", "北京市"));
		options.add(Options.of("002", "深圳市"));
		options.add(Options.of("003", "上海市"));

		return options;
	}

    /**
     * 计算属性指定的方法
     *
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


    @MethodService(name = "getOrgByUserId", auth = "read")
    public TestUser getOrgByUserId(String id) {
        TestUser testUser = new TestUser();
        testUser.setId(id);
        TestOrg testOrg = testUser.getOrg();
        System.out.println(testOrg);
        return testUser.selectById(id);
    }

}
