package com.devworm.android.strictlife.data.schedule;

import com.devworm.android.strictlife.data.AbstractUnitData;

/**
 * Daily schedule data. <br />
 *
 * @created 2015-10-03
 * @since 1.0
 */
public class ScheduleUnitData extends AbstractUnitData {

    /**
     * Schedule data.
     * data[0] = Planned.
     * data[1] = Scheduled.
     * data[2] = Done.
     */
    private String[] scheduleUnit = new String[3];

    /**
     * Time of unit schedule. <br />
     */
    private int startTimeMinute;

    /**
     * Offset duration from start time. <br />
     */
    private int offsetMinutes = 0;

    public ScheduleUnitData(int startTime, String plan) {
        this.scheduleUnit[0] = plan;
    }

    public int getStartTimeMinute() {
        return startTimeMinute;
    }

    public void setStartTimeMinute(int startTimeMinute) {
        this.startTimeMinute = startTimeMinute;
    }

    public int getOffsetMinutes() {
        return offsetMinutes;
    }

    public void setOffsetMinutes(int offsetMinutes) {
        this.offsetMinutes = offsetMinutes;
    }

    public String[] getScheduleUnit() {
        return scheduleUnit;
    }

    public void setScheduleUnit(String[] scheduleUnit) {
        this.scheduleUnit = scheduleUnit;
    }
}
