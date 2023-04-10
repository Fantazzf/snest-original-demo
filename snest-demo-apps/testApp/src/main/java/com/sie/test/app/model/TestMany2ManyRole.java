package com.sie.test.app.model;

import com.sie.snest.engine.model.Bool;
import com.sie.snest.sdk.BaseModel;
import com.sie.snest.sdk.annotation.meta.Model;
import com.sie.snest.sdk.annotation.orm.JoinColumn;
import com.sie.snest.sdk.annotation.orm.JoinTable;
import com.sie.snest.sdk.annotation.orm.ManyToMany;

import java.util.List;

/**
 * @author lijun10
 * @date 2023/3/13 9:51
 */
@Model(parent = "people")
public class TestMany2ManyRole extends BaseModel<TestMany2ManyRole> {

    @ManyToMany
    @JoinTable(name = "role_user", joinColumns = @JoinColumn(name = "role_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id"))
    private List<ManyTestModel> userList;
}
