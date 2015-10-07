package com.devworm.android.strictlife.ui.finance;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.devworm.android.strictlife.R;

/**
 * A placeholder fragment containing a simple view.
 */
public class FinanceMainActivityFragment extends Fragment {

    public FinanceMainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_finance_main, container, false);
    }
}
