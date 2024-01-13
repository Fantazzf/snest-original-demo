package com.sie.app.demo.model;

import com.sie.snest.engine.rule.Filter;
import com.sie.snest.sdk.BaseModel;
import com.sie.snest.sdk.annotation.meta.MethodService;
import com.sie.snest.sdk.annotation.meta.Model;
import com.sie.snest.sdk.annotation.meta.Property;
import org.apache.commons.collections.CollectionUtils;

import java.util.List;

@Model(name = "barcode_rule",tableName = "barcode_rule")
public class BarcodeRule extends BaseModel<BarcodeRule> {
    @Property(displayName = "编码")
    private String code;

    @Property(displayName = "前缀")
    private String prefix;

    @Property(displayName = "流水号长度")
    private Integer seqlength;

    @MethodService(name = "generateCode",description = "生成流水号",auth = "generateCode")
    public  String generateCode(String code){
        List<BarcodeRule>barcodeRules =search(Filter.equal("code",code),getAllProperties(),1,0,null);
        if(CollectionUtils.isEmpty(barcodeRules)){
            throw new IllegalArgumentException("找不到编码规则："+code);
        }
        BarcodeRule barcodeRule=barcodeRules.get(0);
        //当前流水号
        Integer curSeq=new BarcodeDetail().queryCurSeq(code);
        return  String.format("%s%0"+barcodeRule.getSeqlength()+"d",barcodeRule.getPrefix(),curSeq);
    }

    public BarcodeRule setCode(String code) {
        this.set("code", code);
        return this;
    }

    public String getCode() {
        return getStr("code");
    }

    public BarcodeRule setPrefix(String prefix) {
        this.set("prefix", prefix);
        return this;
    }

    public String getPrefix() {
        return getStr("prefix");
    }

    public BarcodeRule setSeqlength(Integer seqlength) {
        this.set("seqlength", seqlength);
        return this;
    }

    public Integer getSeqlength() {
        return getInt("seqlength");
    }
}
