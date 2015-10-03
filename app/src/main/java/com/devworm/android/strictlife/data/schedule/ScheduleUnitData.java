package com.devworm.android.strictlife.data.schedule;

import com.devworm.android.strictlife.data.AbstractDataEntity;

import java.util.List;

/**
 * Created by SDS on 2015-10-03.
 */
public class ScheduleUnitData extends AbstractDataEntity {
    private String[] scheduleUnit = new String[3];
    private String startTime = null;

    public ScheduleUnitData(String plan) {
        this.scheduleUnit[0] = plan;
    }
}
