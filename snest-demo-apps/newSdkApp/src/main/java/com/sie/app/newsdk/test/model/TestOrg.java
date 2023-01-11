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

	@Property(displayName = "名称",displayForModel=true )
	private String name;

	@ManyToOne
	@JoinColumn(name = "parent_id")
	private TestOrg parent;


    public TestOrg getParent() {
        return (TestOrg) this.get("parent");
    }

    public TestOrg setParent(TestOrg parent) {
        this.set("parent", parent);
        return this;
    }

    @OneToMany
    private List<TestUser> userList;

    public List<TestUser> getUserList() {
        return (List<TestUser>) this.get("userList");
    }

    public TestOrg setUserList(List<TestUser> userList) {
        this.set("userList", userList);
        return this;
    }

    @MethodService(description = "获取部门")
	public TestOrg getOrg(String id) {
		TestOrg org=new TestOrg();
		return org.selectById(id);
	}

    @MethodService(description = "测试级联删除")
    public void testDelete(String id){
        TestOrg org=new TestOrg();
        org.setId(id);
        org.delete();
    }


    @MethodService(description = "获取指定部门的用户清单")
    public List<TestUser> listUsers(String orgId) {
        TestOrg org=new TestOrg();
        TestOrg testOrg = org.selectById(orgId);
        List<TestUser> userList = testOrg.getUserList();
        System.out.println(userList);
        return userList;
    }

    public String getName() {
        return (String) this.get("name");
    }

    public TestOrg setName(String name) {
        this.set("name", name);
        return this;
    }


}
