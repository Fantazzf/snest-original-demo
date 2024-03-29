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
    @Selection(values = {
            @Option(label = "软件学院", value = "1"),
            @Option(label = "计算机学院", value = "2"),
            @Option(label = "心理学院", value = "3"),
            @Option(label = "马克思主义学院", value = "4"),
            @Option(label = "开放学院", value = "5")
    })
    @Property(displayName = "所属学院")
    @Validate.NotBlank
    private String College;

    @Property(displayName = "教师姓名",displayForModel = true)
    @Validate.NotBlank
    private String  TeacherName;

    @Selection(values = {
            @Option(label = "女", value = "1"),
            @Option(label = "男", value = "2")
    })
    @Property(displayName = "性别")
    @Validate.NotBlank
    private String Sex;

    @Property(displayName = "出生日期")
    @Validate.NotBlank
    private Date BirthDate;

    @Property(displayName = "年龄",computeMethod = "calAge")
    private  Long Age;

    @MethodService(name="calAge",description = "计算年龄",auth = "calAge")
    public int calAge(Map<String, Object> value){
        //如果没有查询日期这个属性，不计算年龄
        if(!value.containsKey("BirthDate")){
            return 0;
        }
        //获取当前模型实例数据的日期
        Date date= TypeKit.toDate(value.get("BirthDate"));
        //计算年龄
        return  DateUtil.age(date,new Date());
    }

    @Property(displayName = "籍贯")
    private String NativePlace;

    @Property(displayName = "入职日期")
    @Validate.NotBlank
    private Date JoinedDate;

    @Property(displayName = "工龄",computeMethod = "calJoinedAge")
    private  Long JoinedAge;

    @MethodService(name="calJoinedAge",description = "计算工龄",auth = "calJoinedAge")
    public int calJoinedAge(Map<String, Object> value){
        //如果没有查询日期这个属性，不计算工龄
        if(!value.containsKey("JoinedDate")){
            return 0;
        }
        //获取当前模型实例数据的日期
        Date date= TypeKit.toDate(value.get("JoinedDate"));
        //计算工龄
        return DateUtil.age(date,new Date());
    }
}
