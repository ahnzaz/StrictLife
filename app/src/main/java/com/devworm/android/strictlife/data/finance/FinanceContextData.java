package com.devworm.android.strictlife.data.finance;

import java.util.Arrays;
import java.util.List;

/**
 * Created by SDS on 2015-11-09.
 */
public final class FinanceContextData {
    private final static FinanceContextData instance;

    private final int types     = 4;
    private final int ways      = 4;

    private final List<String> typeNames    = Arrays.asList(new String[]{"적금", "생활비", "통신비", "식비"});
    private final List<String> wayNames     = Arrays.asList(new String[]{"현금", "체크카드", "신용카드"});

    static {
        instance = new FinanceContextData();
    }

    public static FinanceContextData getInstance() {
        return instance;
    }

    public int getTypes() {
        return types;
    }

    public int getWays() {
        return ways;
    }

    public List<String> getTypeNames() {
        return typeNames;
    }

    public List<String> getWayNames() {
        return wayNames;
    }
}
