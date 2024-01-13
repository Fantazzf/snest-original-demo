//package com.sie.app.demo.model;
//
//import com.sie.snest.engine.api.jsonrpc.JsonRpcServiceResponse;
//import com.sie.snest.sdk.BaseModel;
//import com.sie.snest.sdk.annotation.meta.MethodService;
//import com.sie.snest.sdk.annotation.meta.Model;
//import com.sie.snest.sdk.annotation.meta.Property;
//
//@Model(name = "material",parent = "material")
//public class MaterialExt extends BaseModel<MaterialExt> {
//    @Property(displayName = "状态")
//    private  String status;//新增属性
//    @MethodService(name = "hello",auth = "hello",description = "你好")
//    public JsonRpcServiceResponse hello(){//重写方法
//        System.out.println("hi");
//        return JsonRpcServiceResponse.message("这是扩展后的方法");
//    }
//    @MethodService(name = "hello2",auth = "hello2",description = "测试方法2")
//    public  void hello2(){//新增服务
//    }
//}
