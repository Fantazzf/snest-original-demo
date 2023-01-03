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
 * @author lijun10
 * @date 2022/11/28 16:50
 */
@Model
public class TestRole extends BaseModel {

    @Property(columnName = "role_name", displayName = "角色名称")
    private String roleName;

    @Property(columnName = "remark", displayName = "备注")
    private String remark;

    @ManyToMany
    @JoinTable(name = "role_user", joinColumns = @JoinColumn(name = "role_id", nullable = false),
            inverseJoinColumns = @JoinColumn(name = "user_id", nullable = false))
    private List<TestUser> userList;


    public List<TestUser> getUserList() {
        return getList("userList", TestUser.class);
    }

    public TestRole setUserList(List<TestUser> userList) {
        this.set("userList", userList);
        return this;
    }

    @MethodService(name = "listUsers",auth = "read")
    public List<TestUser> listUsers(String roleId){
        TestRole testRole = new TestRole();
        TestRole role = testRole.selectById(roleId);
        return role.getUserList();
    }
}
