package com.sie.app.newsdk.test.model;

import com.sie.snest.sdk.BaseModel;
import com.sie.snest.sdk.annotation.meta.MethodService;
import com.sie.snest.sdk.annotation.meta.Model;
import com.sie.snest.sdk.annotation.meta.Property;
import com.sie.snest.sdk.annotation.orm.JoinColumn;
import com.sie.snest.sdk.annotation.orm.JoinTable;
import com.sie.snest.sdk.annotation.orm.ManyToMany;

import java.util.List;

/**
 * 测试角色
 * @author sie
 * @date 2022/11/28 16:50
 */
@Model
public class TestRole extends BaseModel {

    @Property(columnName = "role_name", displayName = "角色名称")
    private String roleName;

    @Property(columnName = "remark", displayName = "备注")
    private String remark;


    public String getRoleName(){
        return (String) get("roleName");
    }

    public void setRoleName(String roleName){
        set("roleName",roleName);
    }


    @ManyToMany
    @JoinTable(name = "role_user", joinColumns = @JoinColumn(name = "role_id", nullable = false),
            inverseJoinColumns = @JoinColumn(name = "user_id", nullable = false))
    private List<TestUser> userList;


    public List<TestUser> getUserList() {
        return (List<TestUser>) get("userList");
    }

    public TestRole setUserList(List<TestUser> userList) {
        this.set("user_id", userList);
        return this;
    }

    @MethodService(name = "listUsers",auth = "read")
    public List<TestUser> listUsers(String roleId){
        TestRole testRole = new TestRole();
        TestRole role = testRole.selectById(roleId);
        return role.getUserList();
    }


    @MethodService(description = "测试级联删除")
    public void testDelete(String id){
        TestRole testRole = new TestRole();
        testRole.setId(id);


        testRole.getUserList();

        testRole.delete();
    }

    public String getRemark() {
        return (String) this.get("remark");
    }

    public TestRole setRemark(String remark) {
        this.set("remark", remark);
        return this;
    }
}
