package com.devworm.android.strictlife.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.devworm.android.strictlife.R;
import com.devworm.android.strictlife.ui.finance.FinanceMainActivity;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnSchedule = null;
    private Button btnWorkout = null;
    private Button btnFinance = null;
    private Button btnMeal = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        initChildView();
        loadData();
    }

    private void loadData() {
    }

    private void initChildView() {
        btnSchedule     = (Button) findViewById(R.id.btnHomeSchedule);
        btnWorkout      = (Button) findViewById(R.id.btnHomeWorkout);
        btnFinance      = (Button) findViewById(R.id.btnHomeFinance);
        btnMeal         = (Button) findViewById(R.id.btnHomeMeal);

        btnSchedule.setOnClickListener(this);
        btnWorkout.setOnClickListener(this);
        btnFinance.setOnClickListener(this);
        btnMeal.setOnClickListener(this);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_home, menu);
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
        switch (view.getId()){
            case R.id.btnHomeFinance : {
                Intent intent = new Intent(HomeActivity.this, FinanceMainActivity.class);
                startActivity(intent);
                break;
            }

            case R.id.btnHomeMeal :{
                break;
            }

            case R.id.btnHomeSchedule :{

                break;
            }

            case R.id.btnHomeWorkout:{

            }
        }
    }
}
