package com.sie.app.newsdk.other.model;

import com.sie.snest.sdk.BaseModel;
import com.sie.snest.sdk.annotation.meta.Model;
import com.sie.snest.sdk.annotation.orm.JoinColumn;
import com.sie.snest.sdk.annotation.orm.JoinTable;
import com.sie.snest.sdk.annotation.orm.ManyToMany;

import java.util.List;
import java.util.Map;

/**
 * @author sie
 * @date 2023/1/5 17:53
 */
@Model(name = "test_permission")
public class TestPermission extends BaseModel<TestPermission> {

    private String name;

    private String type;

    @ManyToMany(targetModel = "TestRole")
    @JoinTable(name = "test_role_permission", joinColumns = @JoinColumn(name = "permission_id", nullable = false),
            inverseJoinColumns = @JoinColumn(name = "role_id", nullable = false))
    private List<Map<String,Object>> roleList;

    public String getName() {
        return (String) this.get("name");
    }

    public TestPermission setName(String name) {
        this.set("name", name);
        return this;
    }

    public String getType() {
        return (String) this.get("type");
    }

    public TestPermission setType(String type) {
        this.set("type", type);
        return this;
    }

    public List<Map<String, Object>> getRoleList() {
        return (List<Map<String, Object>>) this.get("roleList");
    }

    public TestPermission setRoleList(List<Map<String, Object>> roleList) {
        this.set("roleList", roleList);
        return this;
    }
}
