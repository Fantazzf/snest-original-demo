package com.sie.app.newsdk.test.model;

import com.sie.snest.engine.data.RecordSet;
import com.sie.snest.engine.data.service.BaseService;
import com.sie.snest.engine.rule.Filter;
import com.sie.snest.sdk.BaseModel;
import com.sie.snest.sdk.DataType;
import com.sie.snest.sdk.annotation.meta.MethodService;
import com.sie.snest.sdk.annotation.meta.Model;
import com.sie.snest.sdk.annotation.meta.Property;
import com.sie.snest.sdk.annotation.orm.OneToMany;
import com.sie.snest.sdk.annotation.validate.Validate;
import com.sie.snest.sdk.db.DbUtils;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author lijun10
 * @date 2023/2/8 15:32
 */
@Model(name = "test_teacher",displayName = "老师")
public class Teacher extends BaseModel<Teacher> {

    @Property(displayName = "名字",length = 100,displayForModel = true)
    @Validate.NotBlank
    private String name;

    @Property(dataType = DataType.DATE_TIME)
    private Date testDate;

    @OneToMany
    private List<Student> studentList;


    @MethodService
    public String sayHello(String str){
        return "hello " + str;
    }


    public void create(List<Map<String, Object>> valuesList) {
        this.getMeta().get("test_teacher").callSuper(Teacher.class,"create",valuesList);
        System.out.println("1234");
    }



    public void createByName(String name) {
        Teacher teacher = new Teacher() ;
        teacher.setName(name);
        teacher.create();

        Teacher teacher1 = this.selectById("123");
        teacher1.delete();

        teacher.update();


        System.out.println("1234");
    }

    public String getName() {
        return (String) this.get("name");
    }

    public Teacher setName(String name) {
        this.set("name", name);
        return this;
    }
}
