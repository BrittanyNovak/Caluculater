package com.example.student.caluculater;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends ActionBarActivity {

    private String total= "";
    private String firstNum = "";
    private String secondNum = "";
    private String oper;
    private boolean isFirstNum = true;

    public void onButtonClick(View v) {
        Button btn = (Button)v;
        String value = btn.getText().toString();


        EditText etTotal = (EditText)findViewById(R.id.etTotal);

        if(isFirstNum){
            firstNum = firstNum + value;
            etTotal.setText(firstNum);
        } else{
            secondNum = secondNum + value;
            etTotal.setText(secondNum);
        }

    }

    public void onClearClick(View v){
        total = "";
        firstNum = "";
        secondNum = "";
        isFirstNum = true;

        EditText etTotal = (EditText)findViewById(R.id.etTotal);
        etTotal.setText(total);
    }

    public void onOperatorClick(View v){
        Button btn = (Button)v;
        oper = btn.getText().toString();
        isFirstNum = false;
    }

    public void onEqualsClick(View v){
        int fNum = Integer.parseInt(firstNum);
        int sNum = Integer.parseInt(secondNum);
        int fTotal = 0;
        switch(oper) {
            case "+":
                fTotal = fNum + sNum;
                break;
            case "-":
                fTotal = fNum - sNum;
                break;
            case "*":
                fTotal = fNum * sNum;
                break;

        }

        EditText etTotal = (EditText)findViewById(R.id.etTotal);
        firstNum = Integer.toString(fTotal);
        etTotal.setText(firstNum);

        total = "";
        secondNum = "";
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
