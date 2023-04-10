package com.hr.employee.model;

import com.sie.snest.sdk.BaseModel;
import com.sie.snest.sdk.annotation.meta.Model;
import com.sie.snest.sdk.annotation.meta.Property;
import com.sie.snest.sdk.annotation.orm.JoinColumn;
import com.sie.snest.sdk.annotation.orm.ManyToOne;

import java.util.Date;

/**
 * 教育经历
 * @author lijun10
 * @date 2023/3/15 15:15
 */
@Model(name="hr_edu_exp",displayName = "教育经历")
public class EduExperience extends BaseModel<EduExperience> {

    @ManyToOne(displayName = "员工")
    @JoinColumn(name = "emp_id")
    private Employee employee;

    @Property(displayName = "学校")
    private String school;

    @Property(displayName = "工作开始时间")
    private Date startDate;

    @Property(displayName = "工作结束时间")
    private Date endDate;

    @Property(displayName = "学历")
    private String degree;
}
