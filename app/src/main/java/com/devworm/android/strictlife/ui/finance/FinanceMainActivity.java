package com.devworm.android.strictlife.ui.finance;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
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

public class FinanceMainActivity extends AppCompatActivity{

    private ViewPager pager = null;

    // Adapter
    private PagerAdapter pagerAdapter = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finance_main);
        
        connectView();
        initView();
    }

    private void initView() {
        this.pagerAdapter = new FragmentStatePagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                switch(position){

                }
                return null;
            }

            @Override
            public int getCount() {
                return 3;
            }
        };
    }

    private void connectView() {
        pager = (ViewPager) findViewById(R.id.vpgFinanceMain);
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
