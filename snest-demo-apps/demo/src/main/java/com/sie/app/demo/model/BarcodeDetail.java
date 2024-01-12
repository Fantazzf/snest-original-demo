package com.sie.app.demo.model;

import com.sie.snest.engine.rule.Filter;
import com.sie.snest.sdk.BaseModel;
import com.sie.snest.sdk.annotation.meta.MethodService;
import com.sie.snest.sdk.annotation.meta.Model;
import com.sie.snest.sdk.annotation.meta.Property;
import org.apache.commons.collections.CollectionUtils;

import java.util.List;

@Model(name = "barcode_detail",tableName = "barcode_detail")
public class BarcodeDetail extends BaseModel<BarcodeDetail> {
    @Property(displayName = "编码")
    private  String code;

    @Property(displayName = "当前流水号")
    private Integer curSeq;

    @MethodService(name = "queryCurSeq",description = "查询当前流水号",auth = "queryCurseq")
    public Integer queryCurSeq(String code){
        List<BarcodeDetail>details=search(Filter.equal("code",code),getAllProperties(),1,0,null);
        if(CollectionUtils.isEmpty(details)){
            BarcodeDetail detail=new BarcodeDetail();
            detail.setCode(code);
            detail.setCurSeq(1);
            detail.create();
            return detail.getCurSeq();
        }else{
            BarcodeDetail detail=details.get(0);
            detail.setCurSeq(detail.getCurSeq()+1);
            detail.update();
            return  detail.getCurSeq();
        }
    }

    public BarcodeDetail setCode(String code) {
        this.set("code", code);
        return this;
    }

    public String getCode() {
        return getStr("code");
    }

    public BarcodeDetail setCurSeq(Integer curSeq) {
        this.set("curSeq", curSeq);
        return this;
    }

    public Integer getCurSeq() {
        return getInt("curSeq");
    }
}
