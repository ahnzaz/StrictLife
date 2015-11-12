package com.devworm.android.strictlife.ui.finance;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.devworm.android.strictlife.R;
import com.devworm.android.strictlife.data.finance.FinanceContextData;
import com.devworm.android.strictlife.data.finance.FinanceDailyData;
import com.devworm.android.strictlife.data.finance.FinanceUnitData;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * A placeholder fragment containing a simple view.
 */
public class FinanceMainActivityFragment extends Fragment implements View.OnClickListener {

    // Child views.
    private Button btnAddBreakDown = null;
    private ListView lstgDataList = null;

    private AlertDialog diagAddItem = null;

    // Data.
//    private FinanceContext financeContext = null;
    private List<FinanceDailyData> financeDataList;

    public FinanceMainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_finance_main, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        connectView();
    }

    LayoutInflater layoutInflator = null;

    private void connectView() {
        this.layoutInflator = (LayoutInflater) getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        this.btnAddBreakDown = (Button) getActivity().findViewById(R.id.btnFinanceMainAdd);
        this.lstgDataList = (ListView) getActivity().findViewById(R.id.lstgFinanceMainList);

        btnAddBreakDown.setOnClickListener(this);
    }

    private void loadData() {
        // Load finance data from storage module on thread.
        this.financeDataList = new ArrayList<>();
    }

    private void updateFinanceList() {
        // Update ui.

        if (dataAdapter == null) {
            dataAdapter = new ArrayAdapter<FinanceDailyData>(getActivity(), R.layout.item_finance_daily, this.financeDataList) {

                @Override
                public View getView(int position, View convertView, ViewGroup parent) {
                    View view = convertView;

                    if (view == null) {
                        view = layoutInflator.inflate(R.layout.item_finance_daily, null);
                    }

                    FinanceDailyData dailyData = getItem(position);

                    Calendar date = dailyData.getDate();
                    ((TextView) view.findViewById(R.id.txtFinanceListDate)).setText(date.get(Calendar.YEAR) + "-" + (date.get(Calendar.MONTH)+1) + "-" + date.get(Calendar.DAY_OF_MONTH));
                    LinearLayout financeUnitList = ((LinearLayout) view.findViewById(R.id.lingFinanceUnitList));
                    financeUnitList.removeAllViews();

                    // Unit data injection
                    for (FinanceUnitData unitData : dailyData.getDataList()) {
                        LinearLayout unitDataView = (LinearLayout) layoutInflator.inflate(R.layout.item_finance_unit, null);
                        ((TextView) unitDataView.findViewById(R.id.txtFinanceUnitTag)).setText(unitData.getTag());
                        ((TextView) unitDataView.findViewById(R.id.txtFinanceUnitType)).setText(unitData.getType() + "");
                        ((TextView) unitDataView.findViewById(R.id.txtFinanceUnitWay)).setText(unitData.getWay() + "");
                        ((TextView) unitDataView.findViewById(R.id.txtFinanceUnitValue)).setText(unitData.getSum() + "");

                        financeUnitList.addView(unitDataView);
                    }
                    return view;
                }
            };
            ((ListView) getActivity().findViewById(R.id.lstgFinanceMainList)).setAdapter(this.dataAdapter);
        }else{
            dataAdapter.notifyDataSetChanged();
        }
    }

    private ArrayAdapter<FinanceDailyData> dataAdapter = null;

    private void saveData() {
        // Store data via Storage module on thead.

        // Callback function
    }

    private void addFinanceItem(FinanceUnitData unitData, boolean update) {
        // Determine today's data is inserted already or not.
        Calendar today = Calendar.getInstance();

        FinanceDailyData lastDateData = this.financeDataList.size() > 0 ? this.financeDataList.get(0) : null;
        if (lastDateData != null
                && today.get(Calendar.YEAR) == lastDateData.getDate().get(Calendar.YEAR)
                && today.get(Calendar.MONTH) == lastDateData.getDate().get(Calendar.MONTH)
                && today.get(Calendar.DAY_OF_MONTH) == lastDateData.getDate().get(Calendar.DAY_OF_MONTH)) {

            //Last day is today.
            lastDateData.getDataList().add(unitData);
        } else {
            FinanceDailyData todayData = new FinanceDailyData();
            todayData.setDate(today);
            todayData.getDataList().add(unitData);
            financeDataList.add(todayData);
        }

        // Refresh UI.
        if(update){
            updateFinanceList();
        }
    }

    private void showAddItemDialog() {
        if (this.diagAddItem == null) {
            AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
            View dialogView = getActivity().getLayoutInflater().inflate(R.layout.diag_finance_additem, null);
            ((Spinner)dialogView.findViewById(R.id.spnFinanceDiagType)).setAdapter(new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_dropdown_item, FinanceContextData.getInstance().getTypeNames()));
            ((Spinner)dialogView.findViewById(R.id.spnFinanceDiagWay)).setAdapter(new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_dropdown_item, FinanceContextData.getInstance().getWayNames()));
            builder.setView(dialogView)
                    .setPositiveButton(android.R.string.ok, null)
                    .setNegativeButton(android.R.string.cancel, null);
            this.diagAddItem = builder.create();

            // Button click listener alter.
            this.diagAddItem.setOnShowListener(new DialogInterface.OnShowListener() {
                @Override
                public void onShow(DialogInterface dialogInterface) {
                    diagAddItem.getButton(AlertDialog.BUTTON_POSITIVE).setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            // Validation

                            Spinner spnType = (Spinner) diagAddItem.findViewById(R.id.spnFinanceDiagType);
                            int typeValue = spnType.getSelectedItemPosition();
                            if (typeValue < 0) {
                                Toast.makeText(getContext(), "유형을 선택해 주세요.", Toast.LENGTH_SHORT).show();
                                diagAddItem.findViewById(R.id.spnFinanceDiagType).requestFocus();
                                return;
                            }

                            Spinner spnWay = (Spinner) diagAddItem.findViewById(R.id.spnFinanceDiagWay);
                            int wayValue = spnWay.getSelectedItemPosition();
                            if (wayValue < 0) {
                                Toast.makeText(getContext(), "결제방식을 선택해 주세요.", Toast.LENGTH_SHORT).show();
                                diagAddItem.findViewById(R.id.spnFinanceDiagWay).requestFocus();
                                return;
                            }

                            EditText etxTag = (EditText) FinanceMainActivityFragment.this.diagAddItem.findViewById(R.id.etxFinanceDiagTag);
                            if (etxTag.getEditableText() == null || "".equals(etxTag.getEditableText().toString())) {
                                Toast.makeText(getContext(), "내역을 입력해 주세요.", Toast.LENGTH_SHORT).show();
                                diagAddItem.findViewById(R.id.etxFinanceDiagTag).requestFocus();
                                return;
                            }

                            EditText etxValue = (EditText) FinanceMainActivityFragment.this.diagAddItem.findViewById(R.id.etxFinanceDiagValue);
                            if (etxValue.getEditableText() == null || "".equals(etxValue.getEditableText().toString())) {
                                Toast.makeText(getContext(), "금액 입력해 주세요.", Toast.LENGTH_SHORT).show();
                                diagAddItem.findViewById(R.id.etxFinanceDiagValue).requestFocus();
                                return;
                            }

                            FinanceUnitData unitData = new FinanceUnitData();
                            unitData.setType(typeValue);
                            unitData.setWay(wayValue);
                            unitData.setTag(etxTag.getEditableText().toString());
                            unitData.setSum(Integer.parseInt(etxValue.getEditableText().toString()));

                            diagAddItem.dismiss();

                            spnType.setSelection(0);
                            spnWay.setSelection(0);
                            etxTag.setText("");
                            etxValue.setText("");


                            // Update data list
                            addFinanceItem(unitData, true);
                        }
                    });
                }
            });
        }
        this.diagAddItem.show();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnFinanceMainAdd: {
                // Show add item dialog.
                showAddItemDialog();
                break;
            }
            default: {

            }
        }
    }

}
