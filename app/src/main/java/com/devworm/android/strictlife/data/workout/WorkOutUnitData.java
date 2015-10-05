package com.devworm.android.strictlife.data.workout;

import com.devworm.android.strictlife.data.AbstractDailyData;

/**
 * Unit workout data. <br />
 * @since 1.0
 * @created 2015-10-03
 */
public class WorkOutUnitData extends AbstractDailyData {

    /**
     * Name of workout. <br />
     */
    private String type;

    /**
     * Workout data. <br />
     * data[0] = Weight. <br />
     * data[1] = reps. <br />
     * data[2] = sets. <br />
     */
    private int[] data = new int[3];
}
