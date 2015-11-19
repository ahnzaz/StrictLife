package com.devworm.android.strictlife.ui.finance;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.devworm.android.strictlife.R;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link FinanceSettingFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link FinanceSettingFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FinanceSettingFragment extends Fragment {

    public static FinanceSettingFragment newInstance() {
        FinanceSettingFragment fragment = new FinanceSettingFragment();
        return fragment;
    }

    public FinanceSettingFragment() {
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
        return inflater.inflate(R.layout.fragment_finance_setting, container, false);
    }

}
