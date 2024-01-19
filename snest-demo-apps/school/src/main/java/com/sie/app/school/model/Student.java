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

@Model(name = "student",displayName = "学生基本信息",isAutoLog = Bool.True)
public class Student extends BaseModel<Student> {
    @Selection(values = {
            @Option(label = "软件学院", value = "1"),
            @Option(label = "计算机学院", value = "2"),
            @Option(label = "心理学院", value = "3"),
            @Option(label = "马克思主义学院", value = "4"),
            @Option(label = "开放学院", value = "5")
    })
    @Property(displayName = "所在学院")
    @Validate.NotBlank
    private String College;

    @Property(displayName = "学生姓名")
    @Validate.NotBlank
    private  String StudentName;

    @Property(displayName = "学号",displayForModel = true)
    @Validate.NotBlank
    private String StudentNo;

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
    public int calAge(Map<String, Object>value){
        //如果没有查询日期这个属性，不计算年龄
        if(!value.containsKey("BirthDate")){
            return 0;
        }
        //获取当前模型实例数据的日期
        Date date= TypeKit.toDate(value.get("BirthDate"));
        //计算出生日期到当前日期的年份
        return DateUtil.age(date,new Date());
    }

    @Selection(values = {
            @Option(label = "A栋", value = "1"),
            @Option(label = "B栋", value = "2"),
            @Option(label = "C栋", value = "3"),
            @Option(label = "D栋", value = "4"),
            @Option(label = "E栋", value = "5"),
            @Option(label = "F栋", value = "6"),
            @Option(label = "G栋", value = "7"),
    })
    @Property(displayName = "宿舍楼栋")
    private String DormitoryBulid;

    @Selection(values = {
            @Option(label = "100", value = "1"),
            @Option(label = "101", value = "2"),
            @Option(label = "200", value = "3"),
            @Option(label = "201", value = "4"),
            @Option(label = "300", value = "5"),
            @Option(label = "301", value = "6"),
            @Option(label = "302", value = "7"),
    })
    @Property(displayName = "宿舍号")
    private String DormitoryNo;

    @Property(displayName = "籍贯")
    private String NativePlace;

    @Property(displayName = "入学日期")
    @Validate.NotBlank
    private Date ComeDate;


}
