package com.hr.salary.model;

import com.sie.snest.sdk.BaseModel;
import com.sie.snest.sdk.annotation.meta.Model;
import com.sie.snest.sdk.annotation.orm.OneToMany;

import java.util.List;

/**
 * @author lijun10
 * @date 2023/3/15 16:15
 */
@Model(name = "hr_employee",parent = "hr_employee")
public class EmployeeExtensionSalary extends BaseModel<EmployeeExtensionSalary> {

    @OneToMany
    private List<Salary> salaryList;

}
