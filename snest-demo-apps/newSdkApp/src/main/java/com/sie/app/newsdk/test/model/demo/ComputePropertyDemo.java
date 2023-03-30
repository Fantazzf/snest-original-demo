package com.sie.app.newsdk.test.model.demo;

import cn.hutool.core.date.DateUtil;
import com.sie.snest.sdk.BaseModel;
import com.sie.snest.sdk.DataType;
import com.sie.snest.sdk.annotation.meta.MethodService;
import com.sie.snest.sdk.annotation.meta.Model;
import com.sie.snest.sdk.annotation.meta.Property;
import java.util.Date;

/**
 * @author Kris
 */
@Model(displayName = "计算属性示例")
public class ComputePropertyDemo extends BaseModel<ComputePropertyDemo> {


    @Property(displayName = "姓名", computeMethod = "hello")
    private String name;

    @Property(displayName = "出生日期", dataType = DataType.DATE)
    private Date birthday;

    @Property(displayName = "年龄", computeMethod = "calAge")
    private Integer age;

    /**
     * 如果参数是 String，那么参数是当前字段 name 的值
     * @param name
     * @return
     */
    @MethodService
    public String hello(String name) {
        return "hello" + name;
    }

    /**
     * 如果参数不是 String
     * 不能跟 setter、getter 方法重名！！！
     * 方法一定是要 public
     *
     * @param model 当前模型
     * @return 年龄
     */
    @MethodService
    public Integer calAge(BaseModel<?> model) {
        Date birthday = model.getDate("birthday");
        if (birthday == null) {
            return null;
        }
        return DateUtil.age(birthday, DateUtil.date());
    }
}
