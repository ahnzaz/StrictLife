package com.devworm.android.strictlife.data.workout;

import com.devworm.android.strictlife.data.AbstractDailyData;

import java.util.Calendar;
import java.util.List;

/**
 * Daily work log data. <br />
 * @since 1.0
 * @create 2015-10-05
 */
public class WorkOutDailyData extends AbstractDailyData {
    private Calendar date;
    private List<WorkOutUnitData> dataList;

    public WorkOutDailyData(Calendar date){
        this.date = date;
    }

    public WorkOutDailyData(){
        this.date = Calendar.getInstance();
    }

    public WorkOutDailyData(Calendar date, List<WorkOutUnitData> dataList){
        this.date = date;
        this.dataList = dataList;
    }
}
