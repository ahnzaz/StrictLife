package com.devworm.android.strictlife.data.finance;

import com.devworm.android.strictlife.data.AbstractDailyData;

import java.util.Calendar;
import java.util.List;

/**
 * Daily finance data implementation class. <br />
 *
 * @created 2015-15-07
 * @since 1.0
 */
public class FinanceDailyData extends AbstractDailyData {
    private Calendar date;
    private List<FinanceUnitData> dataList;

    public List<FinanceUnitData> getDataList() {
        return dataList;
    }

    public void setDataList(List<FinanceUnitData> dataList) {
        this.dataList = dataList;
    }

    public Calendar getDate() {
        return date;
    }

    public void setDate(Calendar date) {
        this.date = date;
    }
}
