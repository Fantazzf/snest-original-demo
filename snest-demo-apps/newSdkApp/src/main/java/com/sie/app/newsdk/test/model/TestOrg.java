package com.sie.app.newsdk.test.model;

import com.sie.snest.sdk.BaseModel;
import com.sie.snest.sdk.annotation.meta.MethodService;
import com.sie.snest.sdk.annotation.meta.Model;
import com.sie.snest.sdk.annotation.meta.Property;
import com.sie.snest.sdk.annotation.orm.JoinColumn;
import com.sie.snest.sdk.annotation.orm.ManyToOne;
import com.sie.snest.sdk.annotation.orm.OneToMany;

import java.util.List;

/**
 * 测试组织
 * @author sie
 */
@Model(name = "TestOrg",description = "测试组织")
public class TestOrg extends BaseModel {

	@Property(displayName = "名称")
	private String name;

	@ManyToOne
	@JoinColumn(name = "parent_id")
	private TestOrg parent;

    /**
     * mappedBy如果双方不写，表示要建中间表了
     * orphanRemoval表示每次维护时，需要清空中间表记录，有中间表才起作用，默认为false
     */
    @OneToMany
    private List<TestUser> userList;

    
	@MethodService(description = "获取部门")
	public TestOrg getOrg(String id) {
		TestOrg org=new TestOrg();
		return org.selectById(id);
	}


    @MethodService(description = "获取指定部门的用户清单")
    public List<TestUser> listUsers(String orgId) {
        TestOrg org=new TestOrg();
        TestOrg testOrg = org.selectById(orgId);
        return testOrg.getUserList();
    }

    public String getName() {
        return (String) this.get("name");
    }

    public TestOrg setName(String name) {
        this.set("name", name);
        return this;
    }



    public TestOrg getParent() {
        return (TestOrg) this.get("parent");
    }

    public TestOrg setParent(TestOrg parent) {
        this.set("parent", parent);
        return this;
    }

    public List<TestUser> getUserList() {
        return getList("userList", TestUser.class);
    }

    public TestOrg setUserList(List<TestUser> userList) {
        this.set("userList", userList);
        return this;
    }

}
