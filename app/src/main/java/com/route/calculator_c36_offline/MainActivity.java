package com.route.calculator_c36_offline;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    TextView resultTv;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        resultTv = findViewById(R.id.resultTv);

    }


    public void onDigitClick(View v){
        Button button =(Button) v;
       resultTv.append(button.getText());
    }
    String operator ="";
    String LHS = "";
    public void  onOperatorClick (View v){
        Button clickedOperator = (Button) v;
        if(operator.isEmpty()){
            operator = clickedOperator.getText().toString();
            LHS = resultTv.getText().toString();
            resultTv.setText(null);
            Log.e("MainActivity", "operator: "+ operator+ " , LHS: "+LHS);
        }else {
            String RHS = resultTv.getText().toString();
            double res = calculate(LHS,operator, RHS);
            Log.e("Main-onOperatorClick", "result: "+ res);
            LHS = res+"";
            operator = clickedOperator.getText().toString();
            resultTv.setText("");
        }
    }

    public void onEqualClick(View v){
        String RHS = resultTv.getText().toString();
        double res = calculate(LHS, operator, RHS);
        resultTv.setText(res+"");
        LHS = "";
        operator = "";
    }

    public double calculate(String LHS, String operator, String RHS){
        double lhs =  Double.valueOf(LHS);
        double rhs = new Double(RHS);
        if(operator.equals("+")){
            return lhs+rhs;
        }else if(operator.equals("-")){
            return lhs - rhs;
        }else if(operator.equals("*")){
            return lhs * rhs;
        }else {
            return lhs / rhs;
        }
    }
}