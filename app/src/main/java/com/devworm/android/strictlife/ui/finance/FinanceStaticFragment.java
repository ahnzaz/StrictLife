package com.devworm.android.strictlife.ui.finance;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.devworm.android.strictlife.R;

public class FinanceStaticFragment extends Fragment {
    public static FinanceStaticFragment newInstance(String param1, String param2) {
        FinanceStaticFragment fragment = new FinanceStaticFragment();
        return fragment;
    }

    public FinanceStaticFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_finance_static, container, false);
    }
}
