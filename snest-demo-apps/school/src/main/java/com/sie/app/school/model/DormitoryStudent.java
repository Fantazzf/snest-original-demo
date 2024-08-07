package com.sie.app.school.model;

import com.sie.snest.engine.model.Bool;
import com.sie.snest.sdk.BaseModel;
import com.sie.snest.sdk.annotation.meta.Model;
import com.sie.snest.sdk.annotation.meta.Property;
import com.sie.snest.sdk.annotation.orm.JoinColumn;
import com.sie.snest.sdk.annotation.orm.ManyToOne;
import com.sie.snest.sdk.annotation.validate.Validate;

@Model(name = "dormitoryStudent",displayName = "入住学生信息",isAutoLog = Bool.True)
public class DormitoryStudent extends BaseModel<DormitoryStudent> {
    @ManyToOne(displayName = "宿舍")
    @JoinColumn
    private  Dormitory dormitory;

    @ManyToOne(displayName = "学号")
    @JoinColumn
    @Validate.NotBlank
    private  Student student;

    @Property(displayName = "姓名",related = "student.StudentName",store=false)
    private  String StudentName;

    @Property(displayName = "籍贯",related = "student.NativePlace",store=false)
    private  String NativePlace;

    public DormitoryStudent setDormitory(Dormitory dormitory) {
        this.set("dormitory", dormitory);
        return this;
    }

    public Dormitory getDormitory() {
        return (Dormitory) this.get("dormitory");
    }

    public DormitoryStudent setStudent(Student student) {
        this.set("student", student);
        return this;
    }

    public Student getStudent() {
        return (Student) this.get("student");
    }

    public DormitoryStudent setStudentName(String studentName) {
        set("StudentName", studentName);
        return this;
    }

    public String getStudentName() {
        return getStr("StudentName");
    }

    public DormitoryStudent setNativePlace(String nativePlace) {
        set("NativePlace", nativePlace);
        return this;
    }

    public String getNativePlace() {
        return getStr("NativePlace");
    }
}
