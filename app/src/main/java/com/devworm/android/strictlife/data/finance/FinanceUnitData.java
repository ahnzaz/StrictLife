package com.devworm.android.strictlife.data.finance;

import com.devworm.android.strictlife.data.AbstractUnitData;

/**
 * Unit data for finanace. <br />
 * @since 1.0
 * @created 2015-10-07
 */
public class FinanceUnitData extends AbstractUnitData{

    /**
     * 사용 유형
     */
    private int type;

    /**
     * 태그
     */
    private String tag;

    /**
     * 금액
     */
    private int sum;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    public int getWay() {
        return way;
    }

    public void setWay(int way) {
        this.way = way;
    }

    /**
     * 결제 수단
     */
    private int way;
}
