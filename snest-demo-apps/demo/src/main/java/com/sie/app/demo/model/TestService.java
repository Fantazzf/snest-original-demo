//package com.sie.app.demo.model;
//
//import com.sie.app.demo.dto.TestReq;
//import com.sie.snest.sdk.BaseModel;
//import com.sie.snest.sdk.annotation.meta.MethodService;
//import com.sie.snest.sdk.annotation.meta.Model;
//
//@Model(name="test_service",displayName = "测试服务")
//public class TestService extends BaseModel<TestService> {
//    @MethodService(name="hello",description = "你好",auth = "hello")
//    public String hello(String name,Integer age){
//        return "Hello,"+name+","+age;
//    }
//
//    @MethodService(name="hello2",description = "测试服务2",auth = "hello2")
//    public  String hello2(TestReq req){
//        if(req!=null){
//            return "Hello,"+req.getName()+","+req.getDate();
//        }
//        throw  new IllegalArgumentException("请输入参数");
//    }
//}
