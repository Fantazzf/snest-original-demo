package com.sie.app.school.model;

import cn.hutool.core.date.DateUnit;
import cn.hutool.core.date.DateUtil;
import com.sie.snest.engine.model.Bool;
import com.sie.snest.sdk.BaseModel;
import com.sie.snest.sdk.annotation.meta.MethodService;
import com.sie.snest.sdk.annotation.meta.Model;
import com.sie.snest.sdk.annotation.meta.Property;
import com.sie.snest.sdk.annotation.orm.JoinColumn;
import com.sie.snest.sdk.annotation.orm.ManyToOne;
import com.sie.snest.sdk.annotation.orm.Option;
import com.sie.snest.sdk.annotation.orm.Selection;
import com.sie.snest.sdk.annotation.validate.Validate;
import com.sie.snest.sdk.utils.TypeKit;

import java.util.Date;
import java.util.Map;
import java.util.Objects;

@Model(name = "student",displayName = "学生基本信息",isAutoLog = Bool.True)
public class Student extends BaseModel<Student> {
    @Property(displayName = "学号",displayForModel = true)
    @Validate.NotBlank
    private String StudentNo;

    @Property(displayName = "学生姓名")
    @Validate.NotBlank
    private  String StuedentName;

    @Selection(values = {
            @Option(label = "女", value = "1"),
            @Option(label = "男", value = "2")
    })
    @Property(displayName = "性别")
    @Validate.NotBlank
    private String sex;

    @Property(displayName = "出生日期")
    @Validate.NotBlank
    private Date birth_date;

    @Property(displayName = "年龄",computeMethod = "calAge")
    private  Long age;

    @MethodService(name="caAge",description = "计算年龄",auth = "calAge")
    public Long calAge(Map<String, Object>value){
        //如果没有查询日期这个属性，不计算年龄
        if(!value.containsKey("birth_date")){
            return 0L;
        }
        //获取当前模型实例数据的日期
        Date date= TypeKit.toDate(value.get("birth_date"));
        //计算出生日期到当前日期的年份
        return DateUtil.betweenYear(date,new Date(),true);
    }

    @Property(displayName = "籍贯")
    private String native_place;

    @Property(displayName = "入学日期")
    @Validate.NotBlank
    private Date come_date;

    @Selection(values = {
            @Option(label = "软件学院", value = "1"),
            @Option(label = "计算机学院", value = "2"),
            @Option(label = "心理学院", value = "3"),
            @Option(label = "马克思主义学院", value = "4"),
            @Option(label = "开放学院", value = "5")
    })
    @Property(displayName = "学院")
    @Validate.NotBlank
    private String college;

    public Student setStudentNo(String studentNo) {
        set("StudentNo", studentNo);
        return this;
    }

    public String getStudentNo() {
        return getStr("StudentNo");
    }

    public Student setStuedentName(String stuedentName) {
        set("StuedentName", stuedentName);
        return this;
    }

    public String getStuedentName() {
        return getStr("StuedentName");
    }

    public Student setSex(String sex) {
        this.set("sex", sex);
        return this;
    }

    public String getSex() {
        return getStr("sex");
    }

    public Student setBirth_date(Date birth_date) {
        this.set("birth_date", birth_date);
        return this;
    }

    public Date getBirth_date() {
        return getDate("birth_date");
    }

    public Student setAge(Long age) {
        this.set("age", age);
        return this;
    }

    public Long getAge() {
        return getLong("age");
    }

    public Student setNative_place(String native_place) {
        this.set("native_place", native_place);
        return this;
    }

    public String getNative_place() {
        return getStr("native_place");
    }

    public Student setCome_date(Date come_date) {
        this.set("come_date", come_date);
        return this;
    }

    public Date getCome_date() {
        return getDate("come_date");
    }

    public Student setCollege(String college) {
        this.set("college", college);
        return this;
    }

    public String getCollege() {
        return getStr("college");
    }
}
