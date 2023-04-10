package com.hr.employee.model;

import com.sie.snest.sdk.BaseModel;
import com.sie.snest.sdk.annotation.meta.Model;
import com.sie.snest.sdk.annotation.meta.Property;
import com.sie.snest.sdk.annotation.orm.JoinColumn;
import com.sie.snest.sdk.annotation.orm.ManyToOne;

import java.util.Date;

/**
 * 工作经历
 * @author lijun10
 * @date 2023/3/15 15:17
 */
@Model(name="hr_work_expr",displayName = "工作经历")
public class WorkExperience extends BaseModel<WorkExperience> {
    @ManyToOne(displayName = "员工")
    @JoinColumn(name = "emp_id")
    private Employee employee;

    @Property(displayName = "工作单位")
    private String company;

    @Property(displayName = "工作开始时间")
    private Date startDate;

    @Property(displayName = "工作结束时间")
    private Date endDate;

    @Property(displayName = "证明人")
    private String authenticator;

    @Property(displayName = "证明人电话")
    private String getAuthenticatorTel;


}
