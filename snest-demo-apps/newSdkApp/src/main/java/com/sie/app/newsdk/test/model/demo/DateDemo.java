package com.sie.app.newsdk.test.model.demo;

import com.sie.snest.sdk.BaseModel;
import com.sie.snest.sdk.DataType;
import com.sie.snest.sdk.annotation.meta.Model;
import com.sie.snest.sdk.annotation.meta.Property;
import java.sql.Timestamp;
import java.util.Date;

/**
 * @author Kris
 */
@Model(displayName = "日期Demo")
public class DateDemo extends BaseModel<DateDemo> {

    @Property(displayName = "年", dataType = DataType.DATE, dateFormat = "yyyy")
    private Date year;

    @Property(displayName = "月", dataType = DataType.DATE, dateFormat = "yyyy-MM")
    private Date month;

    @Property(displayName = "月范围", dataType = DataType.DATE, dateFormat = "yyyy-MM")
    private Date monthRange;

    @Property(displayName = "日", dataType = DataType.DATE)
    private Date date;

    @Property(displayName = "日范围", dataType = DataType.DATE)
    private Date dateRange;

    @Property(displayName = "时间", dataType = DataType.DATE_TIME, dateFormat = "yyyy-MM-dd HH:mm:ss")
    private Timestamp datetime;

    @Property(displayName = "时间范围", dataType = DataType.DATE_TIME, dateFormat = "yyyy-MM-dd "
        + "HH:mm:ss")
    private Timestamp datetimeRange;

    public Date getYear() {
        return getDate("year");
    }

    public Date getMonth() {
        return getDate("month");
    }

    public Date getDate() {
        return getDate("date");
    }

    public Timestamp getDatetime() {
        return getTimestamp("datetime");
    }
}
