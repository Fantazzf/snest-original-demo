package com.sie.app.demo.model;

import cn.hutool.core.date.DateUtil;
import com.sie.snest.engine.api.jsonrpc.JsonRpcServiceResponse;
import com.sie.snest.engine.data.RecordSet;
import com.sie.snest.engine.model.Bool;
import com.sie.snest.engine.rule.Filter;
import com.sie.snest.sdk.BaseModel;
import com.sie.snest.sdk.annotation.Dict;
import com.sie.snest.sdk.annotation.meta.MethodService;
import com.sie.snest.sdk.annotation.meta.Model;
import com.sie.snest.sdk.annotation.meta.Property;
import com.sie.snest.sdk.annotation.orm.JoinColumn;
import com.sie.snest.sdk.annotation.orm.ManyToOne;
import com.sie.snest.sdk.annotation.orm.Option;
import com.sie.snest.sdk.annotation.orm.Selection;
import com.sie.snest.sdk.annotation.validate.Validate;
import org.luaj.vm2.ast.Str;

import java.io.FilterReader;
import java.util.*;
import java.util.stream.Collectors;


@Model(name = "material",displayName = "物料",isAutoLog = Bool.True)
public class Material extends BaseModel<Material> {
    @Property(displayName = "名称",displayForModel = true)
    @Validate.NotBlank
    private  String name;

    @Property(displayName = "编码")
    private String code;

    @Selection(values = {
            @Option(label = "半成品", value = "1"),
            @Option(label = "成品", value = "2")
    })

    @Property(displayName = "类型")
    private String type;

    @Property(displayName = "日期")
    private Date date;



    @ManyToOne(displayName = "产品")
    @JoinColumn
    private  Product product;

    @Property(displayName = "产品编码",related = "product.code",store=false)
    private  String productCode;

    @Property(displayName = "天数",computeMethod = "calDays")
    private  Integer days;

//    public  Integer calDays(){
//        return 1;
//    }

    @Property(displayName = "单位")
    @Dict(typeCode = "unit")
    private String unit;

    public Material setName(String name) {
        this.set("name", name);
        return this;
    }

    public String getName() {
        return getStr("name");
    }

    public Material setCode(String code) {
        this.set("code", code);
        return this;
    }

    public String getCode() {
        return getStr("code");
    }

    public Material setType(String type) {
        this.set("type", type);
        return this;
    }

    public String getType() {
        return getStr("type");
    }

    public Material setDate(Date date) {
        this.set("date", date);
        return this;
    }

    public Date getDate() {
        return getDate("date");
    }

    public Material setUnit(String unit) {
        this.set("unit", unit);
        return this;
    }

    public String getUnit() {
        return getStr("unit");
    }

//    public List<Material>search(Filter filter,List<String> properties,Integer limit,Integer offset,String order){
//        //拼接
//        filter=filter.and(Filter.in("code",Arrays.asList("001","003")));
//        //callSuper调用search方法访问的是List<Map<String,Object>>
//        @SuppressWarnings("unchecked")
//        List<Map<String,Object>>result=(List<Map<String,Object>>) getMeta().get("material")
//                .callSuper(Material.class,"search",filter,getAllProperties(),0,0,null);
//        //需要重新转成Material类
//        List<Material>materials=result.stream().map(r->{
//            Material material=new Material();
//            material.putAll(r);
//            return  material;
//        }).collect(Collectors.toList());
//        return materials;
//    }

    public RecordSet create(List<Material>valuesList){
        valuesList.forEach(m->m.setDate(new Date()));
        RecordSet rs=(RecordSet) getMeta().get("material")
                .callSuper(Material.class,"create",valuesList);
        System.out.println(rs.getId());
        return  rs;
    }

    @MethodService(name="hello",auth = "hello",description = "你好")
    public String  hello(){
       System.out.println("Hello");
       return "Hello";
    }

}
