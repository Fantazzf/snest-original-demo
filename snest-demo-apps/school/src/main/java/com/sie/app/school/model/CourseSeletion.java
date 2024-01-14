package com.sie.app.school.model;

import com.sie.snest.engine.model.Bool;
import com.sie.snest.sdk.BaseModel;
import com.sie.snest.sdk.annotation.meta.Model;
import com.sie.snest.sdk.annotation.meta.Property;
import com.sie.snest.sdk.annotation.orm.JoinColumn;
import com.sie.snest.sdk.annotation.orm.ManyToOne;
import com.sie.snest.sdk.annotation.validate.Validate;
import groovy.transform.PackageScope;

@Model(name = "course_selection",displayName = "选课明细",isAutoLog = Bool.True)
public class CourseSeletion extends BaseModel<CourseSeletion> {

    @ManyToOne(displayName = "课程信息")
    @JoinColumn
    private Course course;

    @ManyToOne(displayName = "上课编号")
    @JoinColumn
    @Validate.NotBlank
    private ClassInf classInf;

    @Property(displayName = "学生姓名")
    @Validate.NotBlank
    private String StudentName;

    @Property(displayName = "学号")
    @Validate.NotBlank
    private String StudentNo;

    @Property(displayName = "成绩")
    private Integer mark;
}
