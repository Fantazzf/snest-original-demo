package com.sie.app.newsdk.test.vm;

import com.sie.snest.sdk.BaseModel;
import com.sie.snest.sdk.annotation.meta.Model;
import com.sie.snest.sdk.annotation.vm.View;

/**
 * @author chun
 * @date 2023/3/9 14:32
 */
@Model(type = Model.ModelType.View)
@View.From("rbac_user")
public class UserVm extends BaseModel<UserVm> {
    private String login;

    private String email;

    @View.MapProperty("name")
    private String userName;

    private Object org_id;

    private Object role_ids;
}
