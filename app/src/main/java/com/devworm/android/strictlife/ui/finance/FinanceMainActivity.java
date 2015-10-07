package com.devworm.android.strictlife.ui.finance;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

import com.devworm.android.strictlife.R;
import com.devworm.android.strictlife.data.finance.FinanceDailyData;

import java.util.List;

public class FinanceMainActivity extends AppCompatActivity {

    private List<FinanceDailyData> financeDataList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finance_main);

        loadData();
    }

    private void loadData(){
        // Load finance data from storage module on thread.

        // Update ui.
    }

    private void saveData(){
        // Store data via Storage module on thead.

        // Callback function
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
}
