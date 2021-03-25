package com.example.lab02_tranminhnghia_18037141;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    TextView txtPassword;
    Button btnGenerate;
    EditText edtLen;
    CheckBox checkLow;
    CheckBox checkUp;
    CheckBox checkNum;
    CheckBox checkSym;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bai_d);

        txtPassword=(TextView)findViewById(R.id.txtPassword);
        btnGenerate=(Button)findViewById(R.id.btnGenerate);
        edtLen=(EditText)findViewById(R.id.edtLeng);
        checkLow=(CheckBox)findViewById(R.id.cbLower);
        checkUp=(CheckBox)findViewById(R.id.cbUpcase);
        checkNum=(CheckBox)findViewById(R.id.cbNumber);
        checkSym=(CheckBox)findViewById(R.id.cbSymbol);

        btnGenerate.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                int lenPassword;
                try
                {
                    lenPassword=Integer.parseInt(edtLen.getText().toString());
                }
                catch (NumberFormatException e)
                {
                   lenPassword=0;
                }

                txtPassword.setText(resultPassword(lenPassword,(Boolean)checkLow.isChecked(),(Boolean)checkUp.isChecked(),(Boolean)checkNum.isChecked(),(Boolean)checkSym.isChecked()));
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