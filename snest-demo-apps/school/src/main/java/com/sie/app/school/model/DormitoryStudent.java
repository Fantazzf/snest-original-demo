package com.sie.app.school.model;

import com.sie.snest.engine.model.Bool;
import com.sie.snest.sdk.BaseModel;
import com.sie.snest.sdk.annotation.meta.Model;
import com.sie.snest.sdk.annotation.meta.Property;
import com.sie.snest.sdk.annotation.orm.JoinColumn;
import com.sie.snest.sdk.annotation.orm.ManyToOne;
import com.sie.snest.sdk.annotation.validate.Validate;

@Model(name = "dormitoryStudent",displayName = "入住学生",isAutoLog = Bool.True)
public class DormitoryStudent extends BaseModel<DormitoryStudent> {
    @ManyToOne(displayName = "宿舍")
    @JoinColumn
    private  Dormitory dormitory;

    @ManyToOne(displayName = "学生")
    @JoinColumn
    private  Student student;

    @Property(displayName = "学号",related = "student.StudentNo",store = false)
    private String StudentNo;

    @Property(displayName = "学院",related = "student.college",store = false)
    private String college;

    @Property(displayName = "年龄",related = "student.age",store = false)
    private  Long age;

    
}
