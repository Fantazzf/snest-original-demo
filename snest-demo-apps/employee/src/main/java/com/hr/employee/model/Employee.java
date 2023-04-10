package com.hr.employee.model;

import com.sie.snest.sdk.BaseModel;
import com.sie.snest.sdk.annotation.meta.Model;
import com.sie.snest.sdk.annotation.meta.Property;
import com.sie.snest.sdk.annotation.orm.*;
import com.sie.snest.sdk.annotation.validate.Validate;

import java.util.List;

/**
 * 员工信息
 * @author lijun10
 * @date 2023/3/15 15:16
 */
@Model(name="hr_employee",displayName = "员工")
public class Employee extends BaseModel<Employee> {


    @Property(displayName = "名称",displayForModel = true)
    @Validate.NotBlank(message = "员工名称不能为空!")
    private String name;


    @ManyToOne(displayName = "所属组织")
    @JoinColumn(name="org_id")
    private Organization organization;


    @Property(displayName = "用工类型")
    @Selection(values = {@Option(label = "正式员工", value = "ZS"), @Option(label = "劳务派遣", value = "LW")})
    private String type;

    @OneToMany
    private List<EduExperience> eduExperienceList;

    @OneToMany
    private List<WorkExperience> workExperienceList;


    @ManyToMany
    @JoinTable(name = "employee_society", joinColumns = @JoinColumn(name = "emp_id"),
            inverseJoinColumns = @JoinColumn(name = "society_id"))
    private List<Society> societyList;

}
