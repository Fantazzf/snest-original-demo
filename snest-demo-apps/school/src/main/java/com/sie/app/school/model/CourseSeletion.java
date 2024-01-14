package com.sie.app.school.model;

import com.sie.snest.engine.model.Bool;
import com.sie.snest.sdk.BaseModel;
import com.sie.snest.sdk.annotation.meta.Model;
import com.sie.snest.sdk.annotation.meta.Property;
import com.sie.snest.sdk.annotation.orm.JoinColumn;
import com.sie.snest.sdk.annotation.orm.ManyToOne;
import com.sie.snest.sdk.annotation.validate.Validate;
import groovy.transform.PackageScope;

import java.util.List;

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

    @ManyToOne(displayName = "学号")
    @JoinColumn
    private Student student;

    @Property(displayName = "成绩")
    private Integer mark;

    public CourseSeletion setCourse(Course course) {
        this.set("course", course);
        return this;
    }

    public Course getCourse() {
        return (Course) this.get("course");
    }

    public CourseSeletion setClassInf(ClassInf classInf) {
        this.set("classInf", classInf);
        return this;
    }

    public ClassInf getClassInf() {
        return (ClassInf) this.get("classInf");
    }

    public CourseSeletion setStudentName(String studentName) {
        set("StudentName", studentName);
        return this;
    }

    public String getStudentName() {
        return getStr("StudentName");
    }

    public CourseSeletion setStudent(Student student) {
        this.set("student", student);
        return this;
    }

    public Student getStudent() {
        return (Student) this.get("student");
    }

    public CourseSeletion setMark(Integer mark) {
        this.set("mark", mark);
        return this;
    }

    public Integer getMark() {
        return getInt("mark");
    }




}
