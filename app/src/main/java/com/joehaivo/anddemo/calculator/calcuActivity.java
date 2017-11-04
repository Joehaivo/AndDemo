package com.joehaivo.anddemo.calculator;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.joehaivo.anddemo.R;

public class calcuActivity extends AppCompatActivity {
    TextView num1, chachar, num2, resultText;
    boolean isFourClicked = false;
    boolean isDot1Clicked = false;
    boolean isDot2Clicked = false;
    boolean isEqualClicked = false;

    double num11 = 0, num22 = 0, result = 0;
    String charChar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calcu);

        num1 = (TextView) findViewById(R.id.num1);
        chachar = (TextView) findViewById(R.id.charchar);
        num2 = (TextView) findViewById(R.id.num2);
        resultText = (TextView) findViewById(R.id.resultText);
    }

    public void buttonNumClick(View v) {
        if (!isFourClicked) {
            switch (v.getId()) {
                case R.id.button20:
                    num1.append("0");
                    break;
                case R.id.button21:
                    num1.append("1");
                    break;
                case R.id.button22:
                    num1.append("2");
                    break;
                case R.id.button23:
                    num1.append("3");
                    break;
                case R.id.button24:
                    num1.append("4");
                    break;
                case R.id.button25:
                    num1.append("5");
                    break;
                case R.id.button26:
                    num1.append("6");
                    break;
                case R.id.button27:
                    num1.append("7");
                    break;
                case R.id.button8:
                    num1.append("8");
                    break;
                case R.id.button29:
                    num1.append("9");
                    break;
                case R.id.button2Dot:
                    if (!isDot1Clicked) {
                        num1.append(".");
                        isDot1Clicked = true;
                    }
                    break;
            }
        } else if (!isEqualClicked) {
            switch (v.getId()) {
                case R.id.button20:
                    num2.append("0");
                    break;
                case R.id.button21:
                    num2.append("1");
                    break;
                case R.id.button22:
                    num2.append("2");
                    break;
                case R.id.button23:
                    num2.append("3");
                    break;
                case R.id.button24:
                    num2.append("4");
                    break;
                case R.id.button25:
                    num2.append("5");
                    break;
                case R.id.button26:
                    num2.append("6");
                    break;
                case R.id.button27:
                    num2.append("7");
                    break;
                case R.id.button8:
                    num2.append("8");
                    break;
                case R.id.button29:
                    num2.append("9");
                    break;
                case R.id.button2Dot:
                    if (!isDot2Clicked) {
                        num2.append(".");
                        isDot2Clicked = true;
                    }
                    break;
            }
        }
    }

    public void buttonFourClick(View v) {
        if (!isFourClicked) {
            switch (v.getId()) {
                case R.id.buttonAdd:
                    chachar.setText("+");
                    charChar = "+";
                    break;
                case R.id.buttonSub:
                    chachar.setText("-");
                    charChar = "-";
                    break;
                case R.id.buttonMul:
                    chachar.setText("x");
                    charChar = "*";
                    break;
                case R.id.buttonDiv:
                    chachar.setText("÷");
                    charChar = "/";
                    break;
            }
        }
        isFourClicked = true;
    }

    public void equalBtnClick(View v) {
        if (num1.getText().toString().equals("") || num2.getText().toString().equals("") || num1.getText().toString().equals(".") || num2.getText().toString().equals(".")) {
            resultText.setText(" >_< ");
        } else {
            num11 = Double.valueOf(num1.getText().toString());
            num22 = Double.valueOf(num2.getText().toString());
            switch (charChar) {
                case "+":
                    result = num11 + num22;
                    resultText.setText(String.valueOf(result));
                    break;
                case "-":
                    result = num11 - num22;
                    resultText.setText(String.valueOf(result));
                    break;
                case "*":
                    result = num11 * num22;
                    resultText.setText(String.valueOf(result));
                    break;
                case "/":
                    result = num11 / num22;
                    resultText.setText(String.valueOf(result));
                    break;
            }
        }
        isEqualClicked = true;
    }

    public void cBtnClick(View v) {
        num1.setText("");
        num2.setText("");
        chachar.setText("");
        resultText.setText("");
        isFourClicked = false;
        isDot1Clicked = false;
        isDot2Clicked = false;
        isEqualClicked = false;
    }

    public void btnCheckNetClick(View view) {


    }


}
