package com.devworm.android.strictlife.ui.finance;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import com.devworm.android.strictlife.R;
import com.devworm.android.strictlife.data.finance.FinanceDailyData;
import com.devworm.android.strictlife.data.finance.FinanceUnitData;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class FinanceMainActivity extends AppCompatActivity implements View.OnClickListener {

    // Child views.
    private Button btnAddBreakDown = null;
    private ListView lstgDataList = null;

    private AlertDialog diagAddItem = null;

    // Data.
    private List<FinanceDailyData> financeDataList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finance_main);

        loadData();

        connectView();
    }

    private void connectView() {
        this.btnAddBreakDown = (Button) findViewById(R.id.btnFinanceMainAdd);
        this.lstgDataList = (ListView) findViewById(R.id.lstgFinanceMainList);

        btnAddBreakDown.setOnClickListener(this);
    }

    private void loadData() {
        // Load finance data from storage module on thread.
        this.financeDataList = new ArrayList<>();
    }

    private void updateFinanceList(){
        // Update ui.
        ArrayAdapter<FinanceDailyData> adapter = new ArrayAdapter<FinanceDailyData>(getApplicationContext(), );
        this.lstgDataList.setAdapter(new ArrayAdapter<FinanceDailyData>(this, -1, -1, this.financeDataList){
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                return super.getView(position, convertView, parent);
            }
        });
        adapter.notifyDataSetChanged();
    }

    private void saveData() {
        // Store data via Storage module on thead.

        // Callback function
    }

    private void addFinanceItem(FinanceUnitData unitData){
        // Determine today's data is inserted already or not.
        Calendar today = Calendar.getInstance();

        FinanceDailyData lastDateData = this.financeDataList.get(0);
        if(today.get(Calendar.YEAR) == lastDateData.getDate().get(Calendar.YEAR)
                &&today.get(Calendar.MONTH) == lastDateData.getDate().get(Calendar.MONTH)
                &&today.get(Calendar.DAY_OF_MONTH) == lastDateData.getDate().get(Calendar.DAY_OF_MONTH)){
            //Last day is today.
            lastDateData.getDataList().add(unitData);
        }else{
            FinanceDailyData todayData = new FinanceDailyData();
            todayData.setDate(today);
            todayData.getDataList().add(unitData);
        }

        // Refresh UI.
        updateFinanceList();
    }

    private void showAddItemDialog() {
        if (this.diagAddItem == null) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setView(FinanceMainActivity.this.getLayoutInflater().inflate(R.layout.diag_finance_additem, null))
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

                            int typeValue = ((Spinner)diagAddItem.findViewById(R.id.spnFinanceDiagType)).getSelectedItemPosition();
                            if(typeValue <=0){
                                Toast.makeText(FinanceMainActivity.this, "유형을 선택해 주세요.", Toast.LENGTH_SHORT).show();
                                diagAddItem.findViewById(R.id.spnFinanceDiagType).requestFocus();
                                return;
                            }

                            int wayValue = ((Spinner)diagAddItem.findViewById(R.id.spnFinanceDiagWay)).getSelectedItemPosition();
                            if(wayValue <= 0){
                                Toast.makeText(FinanceMainActivity.this, "결제방식을 선택해 주세요.", Toast.LENGTH_SHORT).show();
                                diagAddItem.findViewById(R.id.spnFinanceDiagWay).requestFocus();
                                return;
                            }

                            Editable tagValue = ((EditText) FinanceMainActivity.this.diagAddItem.findViewById(R.id.etxFinanceDiagTag)).getEditableText();
                            if(tagValue == null || "".equals(tagValue.toString())){
                                Toast.makeText(FinanceMainActivity.this, "내역을 입력해 주세요.", Toast.LENGTH_SHORT).show();
                                diagAddItem.findViewById(R.id.etxFinanceDiagTag).requestFocus();
                                return;
                            }

                            Editable sumValue = ((EditText) FinanceMainActivity.this.diagAddItem.findViewById(R.id.etxFinanceDiagValue)).getEditableText();
                            if(sumValue == null || "".equals(sumValue.toString())){
                                Toast.makeText(FinanceMainActivity.this, "금액 입력해 주세요.", Toast.LENGTH_SHORT).show();
                                diagAddItem.findViewById(R.id.etxFinanceDiagValue).requestFocus();
                                return;
                            }

                            FinanceUnitData unitData = new FinanceUnitData();
                            unitData.setType(typeValue);
                            unitData.setWay(wayValue);
                            unitData.setTag(tagValue.toString());
                            unitData.setSum(Integer.parseInt(sumValue.toString()));

                            diagAddItem.dismiss();

                            // Update data list
                            addFinanceItem(unitData);
                        }
                    });
                }
            });
        }
        this.diagAddItem.show();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_finance_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
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
