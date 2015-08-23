package com.xp.note;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * @Description: 计算机界面
 * User: Gavin章华隽
 * Date: 2015-03-21
 * Time: 13:16
 */
public class SCalculatorMain extends Activity implements View.OnClickListener {

    private Button btnBackspace , btnCE , btn7 , btn8 ,
            btn9 , btnDiv , btn4 , btn5 , btn6 ,
            btnMul , btn1 , btn2 , btn3 , btnAdd ,
            btn0 , btnPoint , btnEqu , btnSub ;
    private TextView showResult , showInput ;
    double result ;
    double num1 , num2 ;
    int op = 0 ;
    boolean isClickPoint = false ;
    boolean isClickEqu = false ;
    String[] myStrAndPiont = { "0" , "0" } ;
    String myStr ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.scalculator);
        DisplayMetrics dm = new DisplayMetrics();

        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int screenHeight = dm.heightPixels;

        showResult = (TextView) findViewById( R.id.showResult ) ;
        showInput = (TextView) findViewById( R.id.showInput ) ;
        btnBackspace = (Button) findViewById( R.id.btnBackSpace ) ;
        btnCE = (Button) findViewById( R.id.btnCE ) ;
        btn7 = (Button) findViewById( R.id.btn7 ) ;
        btn8 = (Button) findViewById( R.id.btn8 ) ;
        btn9 = (Button) findViewById( R.id.btn9 ) ;
        btnDiv = (Button) findViewById( R.id.btnDiv ) ;
        btn4 = (Button) findViewById( R.id.btn4 ) ;
        btn5 = (Button) findViewById( R.id.btn5 ) ;
        btn6 = (Button) findViewById( R.id.btn6 ) ;
        btnMul = (Button) findViewById( R.id.btnMul ) ;
        btn1 = (Button) findViewById( R.id.btn1 ) ;
        btn2 = (Button) findViewById( R.id.btn2 ) ;
        btn3 = (Button) findViewById( R.id.btn3 ) ;
        btnAdd = (Button) findViewById( R.id.btnAdd ) ;
        btn0 = (Button) findViewById( R.id.btn0 ) ;
        btnPoint = (Button) findViewById( R.id.btnPoint ) ;
        btnEqu = (Button) findViewById( R.id.btnEqu ) ;
        btnSub = (Button) findViewById( R.id.btnSub ) ;

        btnBackspace.setHeight( screenHeight/8 ) ;
        btnCE.setHeight( screenHeight/8 ) ;
        btn7.setHeight( screenHeight/8 ) ;
        btn8.setHeight( screenHeight/8 ) ;
        btn9.setHeight( screenHeight/8 ) ;
        btnDiv.setHeight( screenHeight/8 ) ;
        btn4.setHeight( screenHeight/8 ) ;
        btn5.setHeight( screenHeight/8 ) ;
        btn6.setHeight( screenHeight/8 ) ;
        btnMul.setHeight( screenHeight/8 ) ;
        btn1.setHeight( screenHeight/8 ) ;
        btn2.setHeight( screenHeight/8 ) ;
        btn3.setHeight( screenHeight/8 ) ;
        btnAdd.setHeight( screenHeight/8 ) ;
        btn0.setHeight( screenHeight/8 ) ;
        btnPoint.setHeight( screenHeight/8 ) ;
        btnEqu.setHeight( screenHeight/8 ) ;
        btnSub.setHeight(screenHeight / 8) ;

        btnBackspace.setOnClickListener( this ) ;
        btnCE.setOnClickListener( this ) ;
        btn7.setOnClickListener( this ) ;
        btn8.setOnClickListener( this ) ;
        btn9.setOnClickListener( this ) ;
        btnDiv.setOnClickListener( this ) ;
        btn4.setOnClickListener( this ) ;
        btn5.setOnClickListener( this ) ;
        btn6.setOnClickListener( this ) ;
        btnMul.setOnClickListener( this ) ;
        btn1.setOnClickListener( this ) ;
        btn2.setOnClickListener( this ) ;
        btn3.setOnClickListener( this ) ;
        btnAdd.setOnClickListener( this ) ;
        btn0.setOnClickListener( this ) ;
        btnPoint.setOnClickListener( this ) ;
        btnEqu.setOnClickListener( this ) ;
        btnSub.setOnClickListener( this ) ;

        showInput.setText( "0.0" ) ;
        showResult.setText( "0" ) ;
    }


    @Override
    public void onClick ( View view ) {

        if ( showResult.getText().toString().equals("327.0") && view.getId() == R.id.btnDiv ) {
            Intent intent = new Intent(SCalculatorMain.this, MainActivity.class);
            startActivity(intent);
        } else {
            switch (view.getId()) {

                //退格键和清空键
                case R.id.btnBackSpace:
                    myStrAndPiont = showInput.getText().toString().split("\\.");
                    if (myStrAndPiont[1].equals("0")) {
                        isClickPoint = false;
                        try {
                            myStrAndPiont[0] = myStrAndPiont[0].substring(0, myStrAndPiont[0].length() - 1);
                        } catch (Exception e) {
                            myStrAndPiont[0] = "0";
                        }
                        if (myStrAndPiont[0].equals("") || myStrAndPiont[0] == null) {
                            myStrAndPiont[0] = "0";
                        }
                    } else {
                        try {
                            myStrAndPiont[1] = myStrAndPiont[1].substring(0, myStrAndPiont[1].length() - 1);
                        } catch (Exception e) {
                            myStrAndPiont[1] = "0";
                            isClickPoint = false;
                        }
                        if (myStrAndPiont[1].equals("") || myStrAndPiont[1] == null) {
                            myStrAndPiont[1] = "0";
                            isClickPoint = false;
                        }
                    }
                    showInput.setText(myStrAndPiont[0] + "." + myStrAndPiont[1]);
                    break;

                case R.id.btnCE:
                    showInput.setText("0.0");
                    showResult.setText("0");
                    num1 = 0.0;
                    num2 = 0.0;
                    result = 0.0;
                    isClickEqu = false;
                    isClickPoint = false;
                    break;

                //数字键0-9的贡呢
                case R.id.btn0:
                    if (isClickEqu) {
                        showInput.setText("0.0");
                        isClickEqu = false;
                    }
                    myStrAndPiont = showInput.getText().toString().split("\\.");
                    if (!isClickPoint) {
                        if (myStrAndPiont[0].equals("0")) {
                            myStrAndPiont[0] = "";
                        }
                        myStrAndPiont[0] += "0";
                    } else {
                        if (myStrAndPiont[1].equals("0")) {
                            myStrAndPiont[1] = "";
                        }
                        myStrAndPiont[1] += "0";
                    }
                    showInput.setText(myStrAndPiont[0] + "." + myStrAndPiont[1]);
                    break;

                case R.id.btn1:
                    Log.i("Test", "输入了数字1");
                    Log.i("Test", "试试输出小数点...,这是第二次输出\\.\\.\\.\\.！");
                    if (isClickEqu) {
                        showInput.setText("0.0");
                        isClickEqu = false;
                    }
                    myStrAndPiont = showInput.getText().toString().split("\\.");
                    if (!isClickPoint) {
                        if (myStrAndPiont[0].equals("0")) {
                            myStrAndPiont[0] = "";
                        }
                        myStrAndPiont[0] += "1";
                    } else {
                        if (myStrAndPiont[1].equals("0")) {
                            myStrAndPiont[1] = "";
                        }
                        myStrAndPiont[1] += "1";
                    }
                    showInput.setText(myStrAndPiont[0] + "." + myStrAndPiont[1]);
                    break;

                case R.id.btn2:
                    Log.i("Test", "输入了数字2");
                    if (isClickEqu) {
                        showInput.setText("0.0");
                        isClickEqu = false;
                    }
                    myStrAndPiont = showInput.getText().toString().split("\\.");
                    if (!isClickPoint) {
                        if (myStrAndPiont[0].equals("0")) {
                            myStrAndPiont[0] = "";
                        }
                        myStrAndPiont[0] += "2";
                    } else {
                        if (myStrAndPiont[1].equals("0")) {
                            myStrAndPiont[1] = "";
                        }
                        myStrAndPiont[1] += "2";
                    }
                    showInput.setText(myStrAndPiont[0] + "." + myStrAndPiont[1]);
                    break;

                case R.id.btn3:
                    if (isClickEqu) {
                        showInput.setText("0.0");
                        isClickEqu = false;
                    }
                    myStrAndPiont = showInput.getText().toString().split("\\.");
                    if (!isClickPoint) {
                        if (myStrAndPiont[0].equals("0")) {
                            myStrAndPiont[0] = "";
                        }
                        myStrAndPiont[0] += "3";
                    } else {
                        if (myStrAndPiont[1].equals("0")) {
                            myStrAndPiont[1] = "";
                        }
                        myStrAndPiont[1] += "3";
                    }
                    showInput.setText(myStrAndPiont[0] + "." + myStrAndPiont[1]);
                    break;

                case R.id.btn4:
                    if (isClickEqu) {
                        showInput.setText("0.0");
                        isClickEqu = false;
                    }
                    myStrAndPiont = showInput.getText().toString().split("\\.");
                    if (!isClickPoint) {
                        if (myStrAndPiont[0].equals("0")) {
                            myStrAndPiont[0] = "";
                        }
                        myStrAndPiont[0] += "4";
                    } else {
                        if (myStrAndPiont[1].equals("0")) {
                            myStrAndPiont[1] = "";
                        }
                        myStrAndPiont[1] += "4";
                    }
                    showInput.setText(myStrAndPiont[0] + "." + myStrAndPiont[1]);
                    break;

                case R.id.btn5:
                    if (isClickEqu) {
                        showInput.setText("0.0");
                        isClickEqu = false;
                    }
                    myStrAndPiont = showInput.getText().toString().split("\\.");
                    if (!isClickPoint) {
                        if (myStrAndPiont[0].equals("0")) {
                            myStrAndPiont[0] = "";
                        }
                        myStrAndPiont[0] += "5";
                    } else {
                        if (myStrAndPiont[1].equals("0")) {
                            myStrAndPiont[1] = "";
                        }
                        myStrAndPiont[1] += "5";
                    }
                    showInput.setText(myStrAndPiont[0] + "." + myStrAndPiont[1]);
                    break;

                case R.id.btn6:
                    if (isClickEqu) {
                        showInput.setText("0.0");
                        isClickEqu = false;
                    }
                    myStrAndPiont = showInput.getText().toString().split("\\.");
                    if (!isClickPoint) {
                        if (myStrAndPiont[0].equals("0")) {
                            myStrAndPiont[0] = "";
                        }
                        myStrAndPiont[0] += "6";
                    } else {
                        if (myStrAndPiont[1].equals("0")) {
                            myStrAndPiont[1] = "";
                        }
                        myStrAndPiont[1] += "6";
                    }
                    showInput.setText(myStrAndPiont[0] + "." + myStrAndPiont[1]);
                    break;

                case R.id.btn7:
                    if (isClickEqu) {
                        showInput.setText("0.0");
                        isClickEqu = false;
                    }
                    myStrAndPiont = showInput.getText().toString().split("\\.");
                    if (!isClickPoint) {
                        if (myStrAndPiont[0].equals("0")) {
                            myStrAndPiont[0] = "";
                        }
                        myStrAndPiont[0] += "7";
                    } else {
                        if (myStrAndPiont[1].equals("0")) {
                            myStrAndPiont[1] = "";
                        }
                        myStrAndPiont[1] += "7";
                    }
                    showInput.setText(myStrAndPiont[0] + "." + myStrAndPiont[1]);
                    break;

                case R.id.btn8:
                    if (isClickEqu) {
                        showInput.setText("0.0");
                        isClickEqu = false;
                    }
                    myStrAndPiont = showInput.getText().toString().split("\\.");
                    if (!isClickPoint) {
                        if (myStrAndPiont[0].equals("0")) {
                            myStrAndPiont[0] = "";
                        }
                        myStrAndPiont[0] += "8";
                    } else {
                        if (myStrAndPiont[1].equals("0")) {
                            myStrAndPiont[1] = "";
                        }
                        myStrAndPiont[1] += "8";
                    }
                    showInput.setText(myStrAndPiont[0] + "." + myStrAndPiont[1]);
                    break;

                case R.id.btn9:
                    if (isClickEqu) {
                        showInput.setText("0.0");
                        isClickEqu = false;
                    }
                    myStrAndPiont = showInput.getText().toString().split("\\.");
                    if (!isClickPoint) {
                        if (myStrAndPiont[0].equals("0")) {
                            myStrAndPiont[0] = "";
                        }
                        myStrAndPiont[0] += "9";
                    } else {
                        if (myStrAndPiont[1].equals("0")) {
                            myStrAndPiont[1] = "";
                        }
                        myStrAndPiont[1] += "9";
                    }
                    showInput.setText(myStrAndPiont[0] + "." + myStrAndPiont[1]);
                    break;

                //小数点功能键
                case R.id.btnPoint:
                    isClickPoint = true;
                    break;

                //加减乘除运算符功能

                case R.id.btnAdd:
                    myStr = showInput.getText().toString();
                    showInput.setText( "0.0" ) ;
                    if (num1 == 0.0) {
                        num1 = Double.valueOf(myStr) ;
                        isClickEqu = false ;
                        isClickPoint = false ;
                        showResult.setText("" + num1);
                    } else {
                        num2 = Double.valueOf(myStr);
                        isClickEqu = false;
                        isClickPoint = false;
                        switch (op) {
                            case 0:
                                result = num1;
                                break;
                            case 1:
                                result = num1 + num2;
                                break;
                            case 2:
                                result = num1 - num2;
                                break;
                            case 3:
                                result = num1 * num2;
                                break;
                            case 4:
                                result = num1 / num2;
                                break;
                            default:
                                break;
                        }
                        myStr = "" + result;
                        showResult.setText(myStr);
                        num1 = result;
                        num2 = 0.0;
                    }
                    op = 1;
                    break;

                case R.id.btnSub:
                    myStr = showInput.getText().toString();
                    showInput.setText( "0.0" ) ;
                    if (num1 == 0.0) {
                        num1 = Double.valueOf(myStr);
                        isClickEqu = false;
                        isClickPoint = false;
                        showResult.setText("" + num1);
                    } else {
                        num2 = Double.valueOf(myStr);
                        isClickEqu = false;
                        isClickPoint = false;
                        switch (op) {
                            case 0:
                                result = num1;
                                break;
                            case 1:
                                result = num1 + num2;
                                break;
                            case 2:
                                result = num1 - num2;
                                break;
                            case 3:
                                result = num1 * num2;
                                break;
                            case 4:
                                result = num1 / num2;
                                break;
                            default:
                                break;
                        }
                        myStr = "" + result;
                        showResult.setText(myStr);
                        num1 = result;
                        num2 = 0.0;
                    }
                    op = 2;
                    break;

                case R.id.btnMul:
                    myStr = showInput.getText().toString();
                    showInput.setText( "0.0" ) ;
                    if (num1 == 0.0) {
                        num1 = Double.valueOf(myStr);
                        isClickEqu = false;
                        isClickPoint = false;
                        showResult.setText("" + num1);
                    } else {
                        num2 = Double.valueOf(myStr);
                        isClickEqu = false;
                        isClickPoint = false;
                        switch (op) {
                            case 0:
                                result = num1;
                                break;
                            case 1:
                                result = num1 + num2;
                                break;
                            case 2:
                                result = num1 - num2;
                                break;
                            case 3:
                                result = num1 * num2;
                                break;
                            case 4:
                                result = num1 / num2;
                                break;
                            default:
                                break;
                        }
                        myStr = "" + result;
                        showResult.setText(myStr);
                        num1 = result;
                        num2 = 0.0;
                    }
                    op = 3;
                    break;

                case R.id.btnDiv:
                    myStr = showInput.getText().toString();
                    showInput.setText( "0.0" ) ;
                    if (num1 == 0.0) {
                        num1 = Double.valueOf(myStr);
                        isClickEqu = false;
                        isClickPoint = false;
                        showResult.setText("" + num1);
                    } else {
                        num2 = Double.valueOf(myStr);
                        isClickEqu = false;
                        isClickPoint = false;
                        switch (op) {
                            case 0:
                                result = num1;
                                break;
                            case 1:
                                result = num1 + num2;
                                break;
                            case 2:
                                result = num1 - num2;
                                break;
                            case 3:
                                result = num1 * num2;
                                break;
                            case 4:
                                result = num1 / num2;
                                break;
                            default:
                                break;
                        }
                        myStr = "" + result;
                        showResult.setText(myStr);
                        num1 = result;
                        num2 = 0.0;
                    }
                    op = 4;
                    break;

                //等于键
                case R.id.btnEqu:
                    myStr = showInput.getText().toString();
                    showInput.setText( "0.0" ) ;
                    num2 = Double.valueOf(myStr);
                    isClickPoint = false;
                    switch (op) {
                        case 0:
                            result = num2;
                            break;
                        case 1:
                            result = num1 + num2;
                            break;
                        case 2:
                            result = num1 - num2;
                            break;
                        case 3:
                            result = num1 * num2;
                            break;
                        case 4:
                            result = num1 / num2;
                            break;
                        default:
                            break;
                    }
                    myStr = "" + result;
                    showResult.setText(myStr);
                    op = 0;
                    num1 = result;
                    num2 = 0.0;
                    isClickEqu = true;
                    break;

                default:
                    break;
            }
        }
    }

}  