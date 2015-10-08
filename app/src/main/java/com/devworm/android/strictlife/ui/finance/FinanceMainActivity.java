package com.devworm.android.strictlife.ui.finance;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.devworm.android.strictlife.R;
import com.devworm.android.strictlife.data.finance.FinanceDailyData;
import com.devworm.android.strictlife.data.finance.FinanceUnitData;

import java.util.List;

public class FinanceMainActivity extends AppCompatActivity implements View.OnClickListener {

    // Child views.
    private Button btnAddBreakDown = null;
    private ListView lstgDataList = null;

    private Dialog diagAddItem = null;

    // Data.
    private List<FinanceDailyData> financeDataList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finance_main);

        loadData();
    }

    private void connectView() {
        this.btnAddBreakDown = (Button) findViewById(R.id.btnFinanceMainAdd);
        this.lstgDataList = (ListView) findViewById(R.id.lstgFinanceMainList);

        btnAddBreakDown.setOnClickListener(this);
    }

    private void loadData() {
        // Load finance data from storage module on thread.

        // Update ui.
    }

    private void saveData() {
        // Store data via Storage module on thead.

        // Callback function
    }

    private void showAddItemDialog() {
        if (this.diagAddItem == null) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setView(FinanceMainActivity.this.getLayoutInflater().inflate(R.layout.diag_finance_additem, null))
                    .setPositiveButton(-1, new DialogInterface.OnClickListener() {

                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            FinanceUnitData unitData = new FinanceUnitData();
                            unitData.setTag(((EditText)findViewById(R.id.etxFinanceDiagTag)).getEditableText().toString());
                            unitData.setSum(Integer.parseInt(((EditText)findViewById(R.id.etxFinanceDiagTag)).getEditableText().toString()));
                        }
                    })
                    .setNegativeButton(-1, new DialogInterface.OnClickListener() {

                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            // Do nothing.
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
                break;
            }
            default: {

            }
        }
    }
}
