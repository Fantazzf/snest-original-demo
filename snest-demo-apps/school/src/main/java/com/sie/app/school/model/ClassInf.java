package com.sie.app.school.model;

import cn.hutool.core.date.DateTime;
import com.sie.snest.engine.model.Bool;
import com.sie.snest.sdk.BaseModel;
import com.sie.snest.sdk.annotation.meta.Model;
import com.sie.snest.sdk.annotation.meta.Property;
import com.sie.snest.sdk.annotation.orm.JoinColumn;
import com.sie.snest.sdk.annotation.orm.ManyToOne;
import com.sie.snest.sdk.annotation.validate.Validate;
import groovy.transform.PackageScope;
import org.omg.PortableInterceptor.DISCARDING;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;

@Model(name = "class_inf",displayName = "上课信息",isAutoLog = Bool.True)
public class ClassInf extends BaseModel<ClassInf> {
    @ManyToOne(displayName = "课程信息")
    @JoinColumn
    private Course course;

    @Property(displayName = "上课编号",displayForModel = true)
    @Validate.NotBlank
    private String ClassCode;

    @Property(displayName = "上课地点")
    private String ClassLocation;

    @Property(displayName = "上课老师")
    private String TeacherName;

    @Property(displayName = "上课日期")
    private Date ClassDate;

    @Property(displayName = "上课时间")
    private Calendar ClassStartTime;

    @Property(displayName = "下课时间")
    private Calendar ClassEndTime;

    @Property(displayName = "考试时间")
    private Time ExamTime;



}
