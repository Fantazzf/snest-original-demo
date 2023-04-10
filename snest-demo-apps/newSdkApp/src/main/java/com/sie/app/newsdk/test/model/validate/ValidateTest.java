package com.sie.app.newsdk.test.model.validate;

import com.sie.snest.sdk.BaseModel;
import com.sie.snest.sdk.annotation.meta.Model;
import com.sie.snest.sdk.annotation.validate.Validate;

/**
 * 校验demo
 */
public class ValidateTest extends BaseModel<ValidateTest> {

    @Validate.Email(message = "邮箱有误")
    private String email;

    @Validate.NotBlank(message = "名称不能为空")
    private String name;
}
