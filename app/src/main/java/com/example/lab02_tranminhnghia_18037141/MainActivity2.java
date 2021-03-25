package com.example.lab02_tranminhnghia_18037141;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class MainActivity2 extends AppCompatActivity {

    TextView txtPassword;
    Button btnGenerate;
    int lenPassword;
    Boolean bLower=false;
    Boolean bUpcase=false;
    Boolean bNumber=false;
    Boolean bSymbol=false;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bai_d);

        txtPassword=(TextView)findViewById(R.id.txtPassword);
        btnGenerate=(Button)findViewById(R.id.btnGenerate);
        lenPassword=Integer.parseInt(findViewById(R.id.edtLeng).toString());
        bLower=false;
        bUpcase=false;
        bNumber=false;
        bSymbol=false;
        CheckBox checkLow=(CheckBox)findViewById(R.id.cbLower);
        CheckBox checkUp=(CheckBox)findViewById(R.id.cbUpcase);
        CheckBox checkNum=(CheckBox)findViewById(R.id.cbNumber);
        CheckBox checkSym=(CheckBox)findViewById(R.id.cbSymbol);

        if (checkLow.isChecked()) {
            bLower=true;
        }
        if (checkUp.isChecked()) {
            bUpcase=true;
        }
        if (checkNum.isChecked()) {
            bNumber=true;
        }
        if (checkSym.isChecked()) {
            bSymbol=true;
        }
        
        btnGenerate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtPassword.setText(resultPassword(lenPassword,bLower,bUpcase,bNumber,bSymbol));

            }
        });
    }
    private String resultPassword(int length, Boolean low, Boolean up, Boolean num, Boolean sym){
        String strLow = "abcdefghijklmnopqrstvwxyz";
        String strUp = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String strNum = "0123456789";
        String strSym =" !\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~";
        StringBuilder s0= new StringBuilder();
        s0.append("");
        if (low){
            s0.append(strLow);
        }
        if (up){
            s0.append(strUp);
        }
        if (num){
            s0.append(strNum);
        }
        if (sym) {
            s0.append(strSym);
        }
        char[] chars = s0.toString().toCharArray();
        Random r =new Random();
        StringBuilder sb=new StringBuilder();
        for (int i =0; i<length;i++){
            char c = chars[r.nextInt(chars.length)];
            sb.append(c);
        }
        return sb.toString();
    }
}