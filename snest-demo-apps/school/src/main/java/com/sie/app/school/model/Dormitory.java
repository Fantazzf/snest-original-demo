package com.sie.app.school.model;

import com.sie.snest.engine.model.Bool;
import com.sie.snest.engine.rule.Filter;
import com.sie.snest.sdk.BaseModel;
import com.sie.snest.sdk.annotation.meta.MethodService;
import com.sie.snest.sdk.annotation.meta.Model;
import com.sie.snest.sdk.annotation.meta.Property;
import com.sie.snest.sdk.annotation.orm.OneToMany;
import com.sie.snest.sdk.annotation.orm.Option;
import com.sie.snest.sdk.annotation.orm.Selection;
import com.sie.snest.sdk.annotation.validate.Validate;

import java.util.Collections;
import java.util.List;

@Model(name = "dormitory",displayName = "宿舍基本信息",isAutoLog = Bool.True)
public class Dormitory extends BaseModel<Dormitory> {
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
    @Validate.NotBlank
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
    @Validate.NotBlank
    private String DormitoryNo;

    @Selection(values = {
            @Option(label = "四人寝", value = "1"),
            @Option(label = "五人寝", value = "2"),
            @Option(label = "六人寝", value = "3")
    })
    @Property(displayName = "宿舍类型")
    @Validate.NotBlank
    private String DormitoryType;

    @Selection(values = {
            @Option(label = "男寝", value = "1"),
            @Option(label = "女寝", value = "2")
    })
    @Property(displayName = "宿舍性质")
    @Validate.NotBlank
    private String DormitorySex;

    @OneToMany
    @Validate.Unique
    private List<DormitoryStudent> dormitoryStudentList;

    @OneToMany
    private List<UtilitiesBill> utilitiesBillList;

    public Dormitory setDormitoryBulid(String dormitoryBulid) {
        set("DormitoryBulid", dormitoryBulid);
        return this;
    }

    public String getDormitoryBulid() {
        return getStr("DormitoryBulid");
    }

    public Dormitory setDormitoryNo(String dormitoryNo) {
        set("DormitoryNo", dormitoryNo);
        return this;
    }

    public String getDormitoryNo() {
        return getStr("DormitoryNo");
    }

    public Dormitory setDormitoryType(String dormitoryType) {
        set("DormitoryType", dormitoryType);
        return this;
    }

    public String getDormitoryType() {
        return getStr("DormitoryType");
    }

    public Dormitory setDormitorySex(String dormitorySex) {
        set("DormitorySex", dormitorySex);
        return this;
    }

    public String getDormitorySex() {
        return getStr("DormitorySex");
    }

    public Dormitory setDormitoryStudentList(List<DormitoryStudent> dormitoryStudentList) {
        this.set("dormitoryStudentList", dormitoryStudentList);
        return this;
    }

    public List<DormitoryStudent> getDormitoryStudentList() {
        return (List<DormitoryStudent>) this.get("dormitoryStudentList");
    }

    public Dormitory setUtilitiesBillList(List<UtilitiesBill> utilitiesBillList) {
        this.set("utilitiesBillList", utilitiesBillList);
        return this;
    }

    public List<UtilitiesBill> getUtilitiesBillList() {
        return (List<UtilitiesBill>) this.get("utilitiesBillList");
    }

}
