package com.example.andi.android_playground;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText editFirstNumber;
    private EditText editSecondNumber;
    private EditText editResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editFirstNumber = (EditText) findViewById(R.id.editFirstNumber);
        editSecondNumber = (EditText) findViewById(R.id.editSecondNumber);
        editResult = (EditText) findViewById(R.id.editResult);

        editResult.setKeyListener(null);

        editFirstNumber.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                computeAndSetResult();
            }
        });

        editSecondNumber.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                computeAndSetResult();
            }
        });

    }

    public void onClickAbout(View view) {
        Intent intent = new Intent(this, AboutActivity.class);
        startActivity(intent);
    }

    public long calculate(int first, int second){
        return (long) first + second;
    }

    public void computeAndSetResult(){
        int first = 0;
        int second = 0;

        editFirstNumber.getText().toString().isEmpty();


        if(editFirstNumber.getText().toString().isEmpty() || editSecondNumber.getText().toString().isEmpty()){
            editResult.setText("0");
            return;
        }

        try {
            first = Integer.valueOf(editFirstNumber.getText().toString());
            second = Integer.valueOf(editSecondNumber.getText().toString());

        } catch (NumberFormatException ex) {
            System.out.println("ERROR: NumberFormatException");
            editResult.setText("0");
            return;
        }


        long result = calculate(first, second);
        editResult.setText(String.valueOf(result));
    }

    public String ping() {
        return "pong";
    }
}
