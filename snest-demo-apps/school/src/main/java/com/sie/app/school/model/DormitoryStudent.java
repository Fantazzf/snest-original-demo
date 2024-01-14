package com.sie.app.school.model;

import com.sie.snest.engine.model.Bool;
import com.sie.snest.sdk.BaseModel;
import com.sie.snest.sdk.annotation.meta.Model;
import com.sie.snest.sdk.annotation.meta.Property;
import com.sie.snest.sdk.annotation.orm.JoinColumn;
import com.sie.snest.sdk.annotation.orm.ManyToOne;

@Model(name = "dormitoryStudent",displayName = "dormitoryStudent",isAutoLog = Bool.True)
public class DormitoryStudent extends BaseModel<DormitoryStudent> {
    @ManyToOne(displayName = "宿舍")
    @JoinColumn
    private  Dormitory dormitory;

    @ManyToOne(displayName = "学生")
    @JoinColumn
    private  Student student;

}
