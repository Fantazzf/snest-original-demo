package com.sie.app.newsdk.test.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.sie.snest.engine.utils.Options;
import com.sie.snest.sdk.BaseModel;
import com.sie.snest.sdk.CascadeType;
import com.sie.snest.sdk.annotation.meta.MethodService;
import com.sie.snest.sdk.annotation.meta.Model;
import com.sie.snest.sdk.annotation.meta.Property;
import com.sie.snest.sdk.annotation.orm.Index;
import com.sie.snest.sdk.annotation.orm.JoinColumn;
import com.sie.snest.sdk.annotation.orm.JoinTable;
import com.sie.snest.sdk.annotation.orm.ManyToMany;
import com.sie.snest.sdk.annotation.orm.ManyToOne;
import com.sie.snest.sdk.annotation.orm.Option;
import com.sie.snest.sdk.annotation.orm.Selection;
import com.sie.snest.sdk.annotation.validate.Validate;


/**
 * 测试用户
 *
 * @author sie
 */
@Model(indexes = { @Index(name = "name_index", columnList = { "name", "email" }, unique = true),
		@Index(columnList = { "phone" })})
public class TestUser extends BaseModel<TestUser> {

    @Property(columnName = "name", displayName = "名称",displayForModel = true)
    //@Validate.NotBlank
    private String name;

    @Validate.Email(message = "邮箱格式不正确")
    @Property(columnName = "email", displayName = "邮箱")
    private String email;

    @Property(columnName = "phone", displayName = "电话号码")
    @Validate.Phone(message = "手机号格式不正确")
    private String phone;

    @Validate.NotBlank(message = "不能为空")
    @Validate.Max(110)
    @Property(columnName = "age", displayName = "年龄")
    private Integer age;
    
    
	@Validate.Max(110)
	@Property(columnName = "age_int", displayName = "年龄Int")
	private int ageInt;
	
	
	@Validate.Max(110)
	@Property(columnName = "salary_double", displayName = "salaryDouble")
	private double salaryDouble;

    @Validate.NotBlank
    @Property(columnName = "password", displayName = "密码",password = true)
    private String password;

    @Property(columnName = "test", displayName = "测试")
    private String test;

    @Property(columnName = "method", computeMethod = "method", displayName = "计算方法")
    private String method;

    @Property(columnName = "script", computeScript = "3+100", displayName = "计算脚本")
    private String script;

    @Property(displayName = "1单选常量", defaultValue = "1", widget = "select",length = 256)
	@Selection(values = { @Option(label = "状态1", value = "1"), @Option(label = "禁用", value = "2"), @Option(label = "已删除", value = "3") })
	private String status;
    
    @ManyToOne(displayName = "2单选异步获取Many2one", cascade = {CascadeType.DEL_SET_NULL})
    @JoinColumn(name = "org_id", referencedColumnName = "id")
    private TestOrg org;

    

	@Property(displayName = "3单选异步获取方法",length = 256)
	@Selection(method = "selectMetod")
	private String selectMetod;

	@Property(displayName = "4单选异步获取模型")
	@Selection(model = "TestOrg", properties = "name", orderBy = "name desc")
	private String selectModel;
	
	@Property(displayName = "statusInt", defaultValue = "1", widget = "select")
	@Selection(values = { @Option(label = "状态2", value = "1"), @Option(label = "禁用", value = "2"), @Option(label = "已删除", value = "3") })
	private int statusInt;
    
    

	@Property(displayName = "5多选常量", defaultValue = "1", multiple = true, widget = "select")
	@Selection(values = { @Option(label = "启用", value = "1"), @Option(label = "禁用", value = "2"),
			@Option(label = "已删除", value = "3") }, multiple = true)
	private String selectStatus;
	
	

	@ManyToMany
	@JoinTable(name = "role_user", joinColumns = @JoinColumn(name = "user_id", nullable = false), inverseJoinColumns = @JoinColumn(name = "role_id", nullable = false))
	@Selection(multiple = true,properties = "roleName")
	private List<TestRole> roleList;
	
	
	@Property(displayName = "7多选异步获取方法")
	@Selection(method = "selectMultipleProvince", multiple = true)
	private String[] selectMultipleProvince;
	

	@Property(displayName = "8多选异步获取模型")
	@Selection(model = "TestOrg", properties = "name", multiple = true)
	private String[] selectMultipleModel;
	
	@Property(displayName = "9-联动-省", toolTips = "请选择")
	@Selection(method = "selectProvince", linkageFields = {"city", "area" })
	private String province;

	@Property(displayName = "9-联动-市", toolTips = "请选择",linkageFields = { "area" })
	@Selection(method = "selectCity")
	private String city;

	@Property(displayName = "9-联动-区", toolTips = "请选择")
	@Selection(method = "selectArea")
	private String area;
	
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
	public List<Options> selectMetod(Object value) {
		String json = "[{\"code\":\"110101\",\"value\":\"东城区\"},{\"code\":\"110102\",\"value\":\"西城区\"},{\"code\":\"110105\",\"value\":\"朝阳区\"},{\"code\":\"110106\",\"value\":\"丰台区\"},{\"code\":\"110107\",\"value\":\"石景山区\"},{\"code\":\"110108\",\"value\":\"海淀区\"},{\"code\":\"110109\",\"value\":\"门头沟区\"},{\"code\":\"110111\",\"value\":\"房山区\"},{\"code\":\"110112\",\"value\":\"通州区\"},{\"code\":\"110113\",\"value\":\"顺义区\"},{\"code\":\"110114\",\"value\":\"昌平区\"},{\"code\":\"110115\",\"value\":\"大兴区\"},{\"code\":\"110116\",\"value\":\"怀柔区\"},{\"code\":\"110117\",\"value\":\"平谷区\"},{\"code\":\"110118\",\"value\":\"密云区\"},{\"code\":\"110119\",\"value\":\"延庆区\"}]";
		List<Options> options = new ArrayList<Options>();
		List<Options> provinceList = new ArrayList<Options>();

		JSONArray proviceArray = JSONObject.parseArray(json);
		for (int i = 0; i < proviceArray.size(); i++) {
			JSONObject proviceObj = proviceArray.getJSONObject(i);
			provinceList.add(Options.of(proviceObj.getString("value"), proviceObj.getString("code")));
		}

		String valueStr=Objects.toString(value, null);
		// 处理回显,也可以不处理
		if (StringUtils.isNotBlank(valueStr)) {
			Optional<Options> optional = provinceList.stream().filter(p -> p.getValue().equals(valueStr)).findFirst();
			if (optional.isPresent()) {
				options.add(optional.get());
			}

			return options;
		}
		options.addAll(provinceList);
		return options;
	}
	
	
	
	@MethodService(description = "selectProvince")
	public List<Options> selectProvince(Object  value) {

		String json = "[{\"code\":\"110000\",\"value\":\"北京市\",\"children\":[{\"code\":\"110100\",\"value\":\"北京市\",\"children\":[{\"code\":\"110101\",\"value\":\"东城区\"},{\"code\":\"110102\",\"value\":\"西城区\"},{\"code\":\"110105\",\"value\":\"朝阳区\"},{\"code\":\"110106\",\"value\":\"丰台区\"},{\"code\":\"110107\",\"value\":\"石景山区\"},{\"code\":\"110108\",\"value\":\"海淀区\"},{\"code\":\"110109\",\"value\":\"门头沟区\"},{\"code\":\"110111\",\"value\":\"房山区\"},{\"code\":\"110112\",\"value\":\"通州区\"},{\"code\":\"110113\",\"value\":\"顺义区\"},{\"code\":\"110114\",\"value\":\"昌平区\"},{\"code\":\"110115\",\"value\":\"大兴区\"},{\"code\":\"110116\",\"value\":\"怀柔区\"},{\"code\":\"110117\",\"value\":\"平谷区\"},{\"code\":\"110118\",\"value\":\"密云区\"},{\"code\":\"110119\",\"value\":\"延庆区\"}]}]},{\"code\":\"120000\",\"value\":\"天津市\",\"children\":[{\"code\":\"120100\",\"value\":\"天津市\",\"children\":[{\"code\":\"120101\",\"value\":\"和平区\"},{\"code\":\"120102\",\"value\":\"河东区\"},{\"code\":\"120103\",\"value\":\"河西区\"},{\"code\":\"120104\",\"value\":\"南开区\"},{\"code\":\"120105\",\"value\":\"河北区\"},{\"code\":\"120106\",\"value\":\"红桥区\"},{\"code\":\"120110\",\"value\":\"东丽区\"},{\"code\":\"120111\",\"value\":\"西青区\"},{\"code\":\"120112\",\"value\":\"津南区\"},{\"code\":\"120113\",\"value\":\"北辰区\"},{\"code\":\"120114\",\"value\":\"武清区\"},{\"code\":\"120115\",\"value\":\"宝坻区\"},{\"code\":\"120116\",\"value\":\"滨海新区\"},{\"code\":\"120117\",\"value\":\"宁河区\"},{\"code\":\"120118\",\"value\":\"静海区\"},{\"code\":\"120119\",\"value\":\"蓟州区\"}]}]}]";
		List<Options> options = new ArrayList<Options>();
		List<Options> provinceList = new ArrayList<Options>();

		JSONArray proviceArray = JSONObject.parseArray(json);
		for (int i = 0; i < proviceArray.size(); i++) {
			JSONObject proviceObj = proviceArray.getJSONObject(i);
			provinceList.add(Options.of(proviceObj.getString("value"), proviceObj.getString("code")));
		}

		String valueStr=Objects.toString(value, null);
		// 处理回显,也可以不处理
		if (StringUtils.isNotBlank(valueStr)) {
			Optional<Options> optional = provinceList.stream().filter(p -> p.getValue().equals(valueStr)).findFirst();
			if (optional.isPresent()) {
				options.add(optional.get());
			}

			return options;
		}
		options.addAll(provinceList);
		return options;
	}
	

	
	
	/**
	 * 多选选择省
	 */
	@MethodService(description = "selectMultipleProvince")
	public List<Options> selectMultipleProvince(Object[] value) {

		String json = "[{\"code\":\"110101\",\"value\":\"东城区\"},{\"code\":\"110102\",\"value\":\"西城区\"},{\"code\":\"110105\",\"value\":\"朝阳区\"},{\"code\":\"110106\",\"value\":\"丰台区\"},{\"code\":\"110107\",\"value\":\"石景山区\"},{\"code\":\"110108\",\"value\":\"海淀区\"},{\"code\":\"110109\",\"value\":\"门头沟区\"},{\"code\":\"110111\",\"value\":\"房山区\"},{\"code\":\"110112\",\"value\":\"通州区\"},{\"code\":\"110113\",\"value\":\"顺义区\"},{\"code\":\"110114\",\"value\":\"昌平区\"},{\"code\":\"110115\",\"value\":\"大兴区\"},{\"code\":\"110116\",\"value\":\"怀柔区\"},{\"code\":\"110117\",\"value\":\"平谷区\"},{\"code\":\"110118\",\"value\":\"密云区\"},{\"code\":\"110119\",\"value\":\"延庆区\"}]";
		List<Options> options = new ArrayList<Options>();
		List<Options> provinceList = new ArrayList<Options>();

		JSONArray proviceArray = JSONObject.parseArray(json);
		for (int i = 0; i < proviceArray.size(); i++) {
			JSONObject proviceObj = proviceArray.getJSONObject(i);
			provinceList.add(Options.of(proviceObj.getString("value"), proviceObj.getString("code")));
		}

		// 处理回显,也可以不处理
		if (value != null && value.length > 0) {
			options = provinceList.stream().filter(p -> ArrayUtils.contains(value, p.getValue())).collect(Collectors.toList());
			return options;
		}
		options.addAll(provinceList);
		return options;
	}
	
	
	/**
	 * 选择省
	 */
	@MethodService(description = "selectCity")
	public List<Options> selectCity(String provinceId, String value) {

		String json = "[{\"code\":\"110000\",\"value\":\"北京市\",\"children\":[{\"code\":\"110100\",\"value\":\"北京市\",\"children\":[{\"code\":\"110101\",\"value\":\"东城区\"},{\"code\":\"110102\",\"value\":\"西城区\"},{\"code\":\"110105\",\"value\":\"朝阳区\"},{\"code\":\"110106\",\"value\":\"丰台区\"},{\"code\":\"110107\",\"value\":\"石景山区\"},{\"code\":\"110108\",\"value\":\"海淀区\"},{\"code\":\"110109\",\"value\":\"门头沟区\"},{\"code\":\"110111\",\"value\":\"房山区\"},{\"code\":\"110112\",\"value\":\"通州区\"},{\"code\":\"110113\",\"value\":\"顺义区\"},{\"code\":\"110114\",\"value\":\"昌平区\"},{\"code\":\"110115\",\"value\":\"大兴区\"},{\"code\":\"110116\",\"value\":\"怀柔区\"},{\"code\":\"110117\",\"value\":\"平谷区\"},{\"code\":\"110118\",\"value\":\"密云区\"},{\"code\":\"110119\",\"value\":\"延庆区\"}]}]},{\"code\":\"120000\",\"value\":\"天津市\",\"children\":[{\"code\":\"120100\",\"value\":\"天津市\",\"children\":[{\"code\":\"120101\",\"value\":\"和平区\"},{\"code\":\"120102\",\"value\":\"河东区\"},{\"code\":\"120103\",\"value\":\"河西区\"},{\"code\":\"120104\",\"value\":\"南开区\"},{\"code\":\"120105\",\"value\":\"河北区\"},{\"code\":\"120106\",\"value\":\"红桥区\"},{\"code\":\"120110\",\"value\":\"东丽区\"},{\"code\":\"120111\",\"value\":\"西青区\"},{\"code\":\"120112\",\"value\":\"津南区\"},{\"code\":\"120113\",\"value\":\"北辰区\"},{\"code\":\"120114\",\"value\":\"武清区\"},{\"code\":\"120115\",\"value\":\"宝坻区\"},{\"code\":\"120116\",\"value\":\"滨海新区\"},{\"code\":\"120117\",\"value\":\"宁河区\"},{\"code\":\"120118\",\"value\":\"静海区\"},{\"code\":\"120119\",\"value\":\"蓟州区\"}]}]}]";
		List<Options> options = new ArrayList<Options>();
		List<Options> cityList = new ArrayList<Options>();
		
		//1.出来回显
		if (StringUtils.isNotBlank(value)) {
			JSONArray proviceArray = JSONObject.parseArray(json);
			for (int i = 0; i < proviceArray.size(); i++) {
				JSONObject proviceObj = proviceArray.getJSONObject(i);
				JSONArray children = proviceObj.getJSONArray("children");
				for (int j = 0; j < children.size(); j++) {
					JSONObject cityObj = children.getJSONObject(j);
					String cityCode = cityObj.getString("code");
					String cityName = cityObj.getString("value");
					// 处理回显,也可以不处理
					if (cityCode.equals(value)) {
						cityList.add(Options.of(cityName, cityCode));
					}

				}
			}

			options.addAll(cityList);
			return options;
		}

	//2.查询列表
		JSONArray proviceArray = JSONObject.parseArray(json);
		for (int i = 0; i < proviceArray.size(); i++) {
			JSONObject proviceObj = proviceArray.getJSONObject(i);
			String provinceCode = proviceObj.getString("code");
			JSONArray children = proviceObj.getJSONArray("children");
			if (!provinceCode.equals(provinceId)) {
				continue;
			}

			for (int j = 0; j < children.size(); j++) {
				JSONObject cityObj = children.getJSONObject(j);
				String cityCode = cityObj.getString("code");
				String cityName = cityObj.getString("value");
				// 处理回显,也可以不处理
				if (StringUtils.isNotBlank(value)) {
					if (cityCode.equals(value)) {
						cityList.add(Options.of(cityName, cityCode));
					}
				} else {
					cityList.add(Options.of(cityName, cityCode));
				}

			}
		}

		options.addAll(cityList);
		return options;

	}
	
	
	/**
	 * 选择省
	 */
	@MethodService(description = "selectArea")
	public List<Options> selectArea(String provinceId, String cityId, String value) {

		String json = "[{\"code\":\"110000\",\"value\":\"北京市\",\"children\":[{\"code\":\"110100\",\"value\":\"北京市\",\"children\":[{\"code\":\"110101\",\"value\":\"东城区\"},{\"code\":\"110102\",\"value\":\"西城区\"},{\"code\":\"110105\",\"value\":\"朝阳区\"},{\"code\":\"110106\",\"value\":\"丰台区\"},{\"code\":\"110107\",\"value\":\"石景山区\"},{\"code\":\"110108\",\"value\":\"海淀区\"},{\"code\":\"110109\",\"value\":\"门头沟区\"},{\"code\":\"110111\",\"value\":\"房山区\"},{\"code\":\"110112\",\"value\":\"通州区\"},{\"code\":\"110113\",\"value\":\"顺义区\"},{\"code\":\"110114\",\"value\":\"昌平区\"},{\"code\":\"110115\",\"value\":\"大兴区\"},{\"code\":\"110116\",\"value\":\"怀柔区\"},{\"code\":\"110117\",\"value\":\"平谷区\"},{\"code\":\"110118\",\"value\":\"密云区\"},{\"code\":\"110119\",\"value\":\"延庆区\"}]}]},{\"code\":\"120000\",\"value\":\"天津市\",\"children\":[{\"code\":\"120100\",\"value\":\"天津市\",\"children\":[{\"code\":\"120101\",\"value\":\"和平区\"},{\"code\":\"120102\",\"value\":\"河东区\"},{\"code\":\"120103\",\"value\":\"河西区\"},{\"code\":\"120104\",\"value\":\"南开区\"},{\"code\":\"120105\",\"value\":\"河北区\"},{\"code\":\"120106\",\"value\":\"红桥区\"},{\"code\":\"120110\",\"value\":\"东丽区\"},{\"code\":\"120111\",\"value\":\"西青区\"},{\"code\":\"120112\",\"value\":\"津南区\"},{\"code\":\"120113\",\"value\":\"北辰区\"},{\"code\":\"120114\",\"value\":\"武清区\"},{\"code\":\"120115\",\"value\":\"宝坻区\"},{\"code\":\"120116\",\"value\":\"滨海新区\"},{\"code\":\"120117\",\"value\":\"宁河区\"},{\"code\":\"120118\",\"value\":\"静海区\"},{\"code\":\"120119\",\"value\":\"蓟州区\"}]}]}]";
		List<Options> options = new ArrayList<Options>();
		List<Options> areaList = new ArrayList<Options>();
		JSONArray proviceArray = JSONObject.parseArray(json);
		
		// 1.出来回显
		if (StringUtils.isNotBlank(value)) {
			for (int i = 0; i < proviceArray.size(); i++) {
				JSONObject proviceObj = proviceArray.getJSONObject(i);
				JSONArray provinceChildren = proviceObj.getJSONArray("children");
				for (int j = 0; j < provinceChildren.size(); j++) {
					JSONObject cityObj = provinceChildren.getJSONObject(j);
					JSONArray cityChildren = cityObj.getJSONArray("children");
					for (int k = 0; k < cityChildren.size(); k++) {
						JSONObject areaObj = cityChildren.getJSONObject(k);
						String areaCode = areaObj.getString("code");
						String areaName = areaObj.getString("value");

						// 处理回显
						if (areaCode.equals(value)) {
							areaList.add(Options.of(areaName, areaCode));
						}

					}

				}
			}

			options.addAll(areaList);
			return options;
		}

		//2.返回列表
		for (int i = 0; i < proviceArray.size(); i++) {
			JSONObject proviceObj = proviceArray.getJSONObject(i);
			String provinceCode = proviceObj.getString("code");
			JSONArray provinceChildren = proviceObj.getJSONArray("children");
			if (!provinceCode.equals(provinceId)) {
				continue;
			}

			for (int j = 0; j < provinceChildren.size(); j++) {
				JSONObject cityObj = provinceChildren.getJSONObject(j);
				JSONArray cityChildren = cityObj.getJSONArray("children");
				String cityCode = cityObj.getString("code");
				if (!cityCode.equals(cityId)) {
					continue;
				}

				for (int k = 0; k < cityChildren.size(); k++) {
					JSONObject areaObj = cityChildren.getJSONObject(k);
					String areaCode = areaObj.getString("code");
					String areaName = areaObj.getString("value");

					// 处理回显
					if (StringUtils.isNotBlank(value)) {
						if (areaCode.equals(value)) {
							areaList.add(Options.of(areaName, areaCode));
						}
					} else {
						areaList.add(Options.of(areaName, areaCode));
					}

				}

			}
		}

		options.addAll(areaList);
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
