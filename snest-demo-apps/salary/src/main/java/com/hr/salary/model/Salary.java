package com.hr.salary.model;

import com.sie.snest.sdk.BaseModel;
import com.sie.snest.sdk.annotation.meta.Model;
import com.sie.snest.sdk.annotation.meta.Property;
import com.sie.snest.sdk.annotation.orm.JoinColumn;
import com.sie.snest.sdk.annotation.orm.ManyToOne;

import java.util.Date;
import java.util.Map;

/**
 * @author lijun10
 * @date 2023/3/15 15:14
 */
@Model(name="hr_salary",displayName = "薪酬")
public class Salary extends BaseModel<Salary> {

    @ManyToOne(targetModel = "hr_employee",displayName = "员工")
    @JoinColumn(name="emp_id")
    private Map<String,Object> employee;

    @Property(displayName = "发放时间")
    private Date date;

    @Property(displayName = "RMB")
    private Float money;
}
