package com.sie.test.app.model;

import com.sie.snest.sdk.BaseModel;
import com.sie.snest.sdk.CascadeType;
import com.sie.snest.sdk.annotation.meta.Model;
import com.sie.snest.sdk.annotation.orm.JoinColumn;
import com.sie.snest.sdk.annotation.orm.JoinTable;
import com.sie.snest.sdk.annotation.orm.ManyToMany;
import com.sie.snest.sdk.annotation.orm.ManyToOne;

import java.util.List;

/**
 * @author lijun10
 * @date 2023/3/13 9:23
 */
@Model(displayName = "用户")
public class ManyTestModel extends BaseModel<ManyTestModel> {

    private String name;

    @ManyToOne(displayName = "组织",cascade = CascadeType.DEL_SET_NULL)
    @JoinColumn(name = "org_id")
    private TestModel testModel;

    @ManyToMany
    @JoinTable(name = "role_user", joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private List<TestMany2ManyRole> roleList;
}
