package com.sie.app.school.model;

import com.sie.snest.engine.model.Bool;
import com.sie.snest.sdk.BaseModel;
import com.sie.snest.sdk.DataType;
import com.sie.snest.sdk.annotation.Dict;
import com.sie.snest.sdk.annotation.meta.Model;
import com.sie.snest.sdk.annotation.meta.Property;
import com.sie.snest.sdk.annotation.orm.JoinColumn;
import com.sie.snest.sdk.annotation.orm.ManyToOne;
import com.sie.snest.sdk.annotation.orm.Option;
import com.sie.snest.sdk.annotation.orm.Selection;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.*;

import com.sie.snest.sdk.annotation.validate.Validate;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.DatePicker;
import javafx.scene.layout.VBox;
import javafx.util.StringConverter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

@Model(name="utilities_bill",displayName = "水电费",isAutoLog = Bool.True)
public class UtilitiesBill extends BaseModel<UtilitiesBill> {
    //编号，月份，类型，数量，单位

    @ManyToOne(displayName = "宿舍")
    @JoinColumn
    private  Dormitory dormitory;

    @Property(displayName = "年-月",dataType = DataType.DATE,dateFormat = "yyyy-MM")
    @Validate.NotBlank
    private Date yearmonth;
    @Property(displayName = "类型")
    @Validate.NotBlank
    @Selection(multiple = false,
        values = {
            @Option(label = "水费",value = "1"),
            @Option(label = "电费", value="2")
        }
    )
    private List<String> type;

    @Property(displayName = "数额")
    @Validate.NotBlank
    private Double money;

    @Property(displayName = "单位")
    @Validate.NotBlank
    @Selection(multiple = false,
        values = {
            @Option(label = "元",value = "1"),
        }
    )
    private String unit;

//    @Property(displayName = "时间")
//    private Timestamp text;

//    @Property(displayName = "日期")
//    private Date date;

//    public void pickYM(Stage primaryStage){
//        DatePicker dataPicker = new DatePicker();
//        dataPicker.setConverter(new StringConverter<LocalDate>() {
//            private DateTimeFormatter dateFormatter = DataTimeFormatter.ofPattern("yyyy年MM月");
//            @Override
//            public String toString(LocalDate object) {
//                if(date!=null)
//            }
//
//            @Override
//            public LocalDate fromString(String string) {
//                return null;
//            }
//        });
//    }


}
