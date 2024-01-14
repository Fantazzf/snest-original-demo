package com.sie.app.school.model;

import com.sie.snest.engine.model.Bool;
import com.sie.snest.sdk.BaseModel;
import com.sie.snest.sdk.annotation.meta.Model;
import com.sie.snest.sdk.annotation.meta.Property;
import com.sie.snest.sdk.annotation.orm.OneToMany;
import com.sie.snest.sdk.annotation.validate.Validate;
import org.checkerframework.checker.units.qual.C;

import javax.xml.crypto.Data;
import java.util.Date;
import java.util.List;

@Model(name = "course",displayName = "课程信息",isAutoLog = Bool.True)
public class Course extends BaseModel<Course> {

    @Property(displayName = "课程名称",displayForModel = true)
    @Validate.NotBlank
    private String CourseName;

    @Property(displayName = "课程编号")
    @Validate.Unique
    @Validate.NotBlank
    private String CourseCode;

    @Property(displayName = "课程开始日期")
    private Date CourseStartDate;

    @Property(displayName = "课程结束日期")
    private Date CourseEndDate;

    @OneToMany
    private List<ClassInf> classInfList;

    @OneToMany
    private List<CourseSeletion> courseSeletionList;

}
