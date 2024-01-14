package com.sie.app.school.model;

import cn.hutool.core.date.DateUtil;
import com.sie.snest.engine.model.Bool;
import com.sie.snest.sdk.BaseModel;
import com.sie.snest.sdk.annotation.meta.MethodService;
import com.sie.snest.sdk.annotation.meta.Model;
import com.sie.snest.sdk.annotation.meta.Property;
import com.sie.snest.sdk.annotation.orm.Option;
import com.sie.snest.sdk.annotation.orm.Selection;
import com.sie.snest.sdk.annotation.validate.Validate;
import com.sie.snest.sdk.utils.TypeKit;

import java.util.Date;
import java.util.Map;

@Model(name = "teacher",displayName = "教师基本信息",isAutoLog = Bool.True)
public class Teacher extends BaseModel<Teacher> {
    @Property(displayName = "教师姓名",displayForModel = true)
    @Validate.NotBlank
    private String  TeacherName;

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

    @MethodService(name="calAge",description = "计算年龄",auth = "calAge")
    public Long calAge(Map<String, Object> value){
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

    @Property(displayName = "入职日期")
    @Validate.NotBlank
    private Date joined_date;


    @Property(displayName = "工龄",computeMethod = "calJoinAge")
    private  Long JoinAge;

    @MethodService(name="calJoinAge",description = "计算工龄",auth = "calJoinAge")
    public Long calJoinAge(Map<String, Object> value){
        //如果没有查询日期这个属性，不计算年龄
        if(!value.containsKey("birth_date")){
            return 0L;
        }
        //获取当前模型实例数据的日期
        Date date= TypeKit.toDate(value.get("joined_date"));
        //计算出生日期到当前日期的年份
        return DateUtil.betweenYear(date,new Date(),true);
    }

    public Teacher setTeacherName(String teacherName) {
        set("TeacherName", teacherName);
        return this;
    }

    public String getTeacherName() {
        return getStr("TeacherName");
    }

    public Teacher setSex(String sex) {
        this.set("sex", sex);
        return this;
    }

    public String getSex() {
        return getStr("sex");
    }

    public Teacher setBirth_date(Date birth_date) {
        this.set("birth_date", birth_date);
        return this;
    }

    public Date getBirth_date() {
        return getDate("birth_date");
    }

    public Teacher setAge(Long age) {
        this.set("age", age);
        return this;
    }

    public Long getAge() {
        return getLong("age");
    }

    public Teacher setNative_place(String native_place) {
        this.set("native_place", native_place);
        return this;
    }

    public String getNative_place() {
        return getStr("native_place");
    }

    public Teacher setCollege(String college) {
        this.set("college", college);
        return this;
    }

    public String getCollege() {
        return getStr("college");
    }

    public Teacher setJoined_date(Date joined_date) {
        this.set("joined_date", joined_date);
        return this;
    }

    public Date getJoined_date() {
        return getDate("joined_date");
    }

    public Teacher setJoinAge(Long joinAge) {
        set("JoinAge", joinAge);
        return this;
    }

    public Long getJoinAge() {
        return getLong("JoinAge");
    }
}
