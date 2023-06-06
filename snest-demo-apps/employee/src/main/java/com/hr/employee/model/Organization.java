package com.hr.employee.model;

import com.sie.snest.sdk.BaseModel;
import com.sie.snest.sdk.annotation.meta.Model;
import com.sie.snest.sdk.annotation.meta.Property;
import com.sie.snest.sdk.annotation.orm.JoinColumn;
import com.sie.snest.sdk.annotation.orm.ManyToOne;
import com.sie.snest.sdk.annotation.validate.Validate;

/**
 * 组织
 * @author lijun10
 * @date 2023/3/15 15:18
 */
@Model(name="hr_organization",displayName = "组织")
public class Organization extends BaseModel<Organization> {

    @Property(displayName = "组织名称",displayForModel = true)
    @Validate.NotBlank(message = "组织名称不能为空!")
    private String name;

    @ManyToOne(displayName = "父组织")
    @JoinColumn(name = "p_id")
    private Organization organization;


}
