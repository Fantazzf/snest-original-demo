package com.sie.app.school.model;

import com.sie.snest.engine.model.Bool;
import com.sie.snest.sdk.BaseModel;
import com.sie.snest.sdk.annotation.meta.Model;
import com.sie.snest.sdk.annotation.meta.Property;
import com.sie.snest.sdk.annotation.orm.OneToMany;
import com.sie.snest.sdk.annotation.orm.Option;
import com.sie.snest.sdk.annotation.orm.Selection;
import com.sie.snest.sdk.annotation.validate.Validate;

import java.util.List;

@Model(name = "dormitory",displayName = "宿舍基本信息",isAutoLog = Bool.True)
public class Dormitory extends BaseModel<Dormitory> {

    @Selection(values = {
            @Option(label = "A栋", value = "1"),
            @Option(label = "B栋", value = "2"),
            @Option(label = "C栋", value = "3"),
            @Option(label = "D栋", value = "4"),
            @Option(label = "E栋", value = "5"),
            @Option(label = "F栋", value = "5"),
            @Option(label = "D栋", value = "6"),
    })
    @Property(displayName = "宿舍楼栋",displayForModel = true)
    @Validate.NotBlank
    private String DormitoryBulid;

    @Selection(values = {
            @Option(label = "100", value = "1"),
            @Option(label = "101", value = "2"),
            @Option(label = "200", value = "3"),
            @Option(label = "201", value = "4"),
            @Option(label = "300", value = "5"),
            @Option(label = "301", value = "5"),
            @Option(label = "302", value = "6"),
    })
    @Property(displayName = "宿舍号")
    @Validate.Unique
    private String DormitoryNo;

    @Property(displayName = "宿舍人数")
    private  Integer DormitoryMan;

    @OneToMany
    private List<DormitoryStudent> dormitoryStudentList;


}