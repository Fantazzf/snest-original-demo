package com.hr.employee.model;

import com.sie.snest.sdk.BaseModel;
import com.sie.snest.sdk.annotation.meta.Model;
import com.sie.snest.sdk.annotation.meta.Property;
import com.sie.snest.sdk.annotation.orm.JoinColumn;
import com.sie.snest.sdk.annotation.orm.JoinTable;
import com.sie.snest.sdk.annotation.orm.ManyToMany;
import com.sie.snest.sdk.annotation.validate.Validate;

import java.util.List;

/**
 * 协会
 * @author lijun10
 * @date 2023/3/15 15:17
 */
@Model(name="hr_society",displayName = "协会")
public class Society extends BaseModel<Society> {
    @Property(displayName = "名称")
    @Validate.NotBlank(message = "协会名称不能为空!")
    private String name;

    @Property(displayName = "联系人")
    private String contact;

    @Property(displayName = "联系电话")
    private String tel;

    @Property(displayName = "描述")
    private String description;

    @ManyToMany
    @JoinTable(name = "employee_society", joinColumns = @JoinColumn(name = "society_id"),
            inverseJoinColumns = @JoinColumn(name = "emp_id"))
    private List<Employee> employeeList;
}
