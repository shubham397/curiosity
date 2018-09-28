package com.example.shubh.curiosity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;
import java.util.function.Function;

public class QuestionActivity extends Activity {

    int count=0;
    String str;
    String mainsequence="";

    EditText editText;

    String j;

    long count_attempts=0;

    long time,time1,time2;

    float threshold;

    public void check(char a)
    {
        if(count<3)
        {
            if(count==1)
            {
               time1=(System.currentTimeMillis())/1000;
            }
            count++;
            str=editText.getText().toString();
            str=str+a;
            editText.setText(str);
        }
        else
        {
            Toast.makeText(QuestionActivity.this,"Press Submit Button",Toast.LENGTH_SHORT).show();
        }
    }

    Button btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,submit_Btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);

        TextView txt1=(TextView)findViewById(R.id.textView1);

        editText=(EditText)findViewById(R.id.editText);



        btn1=(Button)findViewById(R.id.image_btn1);
        btn2=(Button)findViewById(R.id.image_btn2);
        btn3=(Button)findViewById(R.id.image_btn3);
        btn4=(Button)findViewById(R.id.image_btn4);
        btn5=(Button)findViewById(R.id.image_btn5);
        btn6=(Button)findViewById(R.id.image_btn6);
        btn7=(Button)findViewById(R.id.image_btn7);
        btn8=(Button)findViewById(R.id.image_btn8);
        btn9=(Button)findViewById(R.id.image_btn9);

        submit_Btn=(Button)findViewById(R.id.submit_btn);

        String[] j1;

        int random;

        threshold=new Random().nextInt(10);

        threshold=threshold/10;

//        Toast.makeText(QuestionActivity.this,""+threshold,Toast.LENGTH_SHORT).show();

        random=new Random().nextInt(5);

        switch (random)
        {
            case 0:
                j=getString(R.string.joke1);
                j1=getString(R.string.joke1).split(":");
                txt1.setText(j1[0]+"?");
                break;

            case 1:
                j=getString(R.string.joke2);
                j1=getString(R.string.joke2).split(":");
                txt1.setText(j1[0]+"?");
                break;

            case 2:
                j=getString(R.string.joke3);
                j1=getString(R.string.joke3).split(":");
                txt1.setText(j1[0]+"?");
                break;

            case 3:
                j=getString(R.string.joke4);
                j1=getString(R.string.joke4).split(":");
                txt1.setText(j1[0]+"?");
                break;

            case 4:
                j=getString(R.string.joke5);
                j1=getString(R.string.joke5).split(":");
                txt1.setText(j1[0]+"?");
                break;
        }





        for(int i=0;i<3;i++)
        {
            random = new Random().nextInt(9);
            switch(random) {
                case 0:
                    mainsequence = mainsequence + "A";
                    break;

                case 1:
                    mainsequence = mainsequence + "B";
                    break;

                case 2:
                    mainsequence = mainsequence + "C";
                    break;

                case 3:
                    mainsequence = mainsequence + "D";
                    break;

                case 4:
                    mainsequence = mainsequence + "E";
                    break;

                case 5:
                    mainsequence = mainsequence + "F";
                    break;

                case 6:
                    mainsequence = mainsequence + "G";
                    break;

                case 7:
                    mainsequence = mainsequence + "H";
                    break;

                case 8:
                    mainsequence = mainsequence + "I";
                    break;
            }
        }

        //txt1.append(mainsequence);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                check('A');
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                check('B');
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                check('C');
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                check('D');
            }
        });

        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                check('E');
            }
        });

        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                check('F');
            }
        });

        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                check('G');
            }
        });

        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                check('H');
            }
        });

        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                check('I');
            }
        });

        submit_Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(editText.getText().toString().length()==3) {
                    count = 0;
                    editText.setText("");
                    count_attempts++;
                    time2 = (System.currentTimeMillis()) / 1000;
                    time = time2 - time1;
                    double curiosity = (count_attempts * time);
                    curiosity = curiosity / 100;
                    if(curiosity<threshold/4)
                    {
                        btn1.setBackgroundColor(Color.rgb(219,219 ,219));
                        btn2.setBackgroundColor(Color.rgb(219,219 ,219));
                        btn3.setBackgroundColor(Color.rgb(219,219 ,219));
                        btn4.setBackgroundColor(Color.rgb(219,219 ,219));
                        btn5.setBackgroundColor(Color.rgb(219,219 ,219));
                        btn6.setBackgroundColor(Color.rgb(219,219 ,219));
                        btn7.setBackgroundColor(Color.rgb(219,219 ,219));
                        btn8.setBackgroundColor(Color.rgb(219,219 ,219));
                        btn9.setBackgroundColor(Color.rgb(219,219 ,219));
                    }
                    else if(curiosity<threshold/3&&curiosity>threshold/4)
                    {
                        btn1.setBackgroundColor(Color.rgb(140,140 ,140));
                        btn2.setBackgroundColor(Color.rgb(140,140 ,140));
                        btn3.setBackgroundColor(Color.rgb(140,140 ,140));
                        btn4.setBackgroundColor(Color.rgb(140,140 ,140));
                        btn5.setBackgroundColor(Color.rgb(140,140 ,140));
                        btn6.setBackgroundColor(Color.rgb(140,140 ,140));
                        btn7.setBackgroundColor(Color.rgb(140,140 ,140));
                        btn8.setBackgroundColor(Color.rgb(140,140 ,140));
                        btn9.setBackgroundColor(Color.rgb(140,140 ,140));
                    }
                    else if(curiosity<threshold/2&&curiosity>threshold/3)
                    {
                        btn1.setBackgroundColor(Color.rgb(94,94 ,94));
                        btn2.setBackgroundColor(Color.rgb(94,94 ,94));
                        btn3.setBackgroundColor(Color.rgb(94,94 ,94));
                        btn4.setBackgroundColor(Color.rgb(94,94 ,94));
                        btn5.setBackgroundColor(Color.rgb(94,94 ,94));
                        btn6.setBackgroundColor(Color.rgb(94,94 ,94));
                        btn7.setBackgroundColor(Color.rgb(94,94 ,94));
                        btn8.setBackgroundColor(Color.rgb(94,94 ,94));
                        btn9.setBackgroundColor(Color.rgb(94,94 ,94));
                    }
                    else
                    {
                        btn1.setBackgroundColor(Color.rgb(50,50 ,50));
                        btn2.setBackgroundColor(Color.rgb(50,50 ,50));
                        btn3.setBackgroundColor(Color.rgb(50,50 ,50));
                        btn4.setBackgroundColor(Color.rgb(50,50 ,50));
                        btn5.setBackgroundColor(Color.rgb(50,50 ,50));
                        btn6.setBackgroundColor(Color.rgb(50,50 ,50));
                        btn7.setBackgroundColor(Color.rgb(50,50 ,50));
                        btn8.setBackgroundColor(Color.rgb(50,50 ,50));
                        btn9.setBackgroundColor(Color.rgb(50,50 ,50));
                    }
//                    Toast.makeText(QuestionActivity.this, "" + curiosity, Toast.LENGTH_SHORT).show();
                    if ((mainsequence.equals(str)) || (curiosity >= threshold)) {
                        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(QuestionActivity.this);
                        alertDialogBuilder.setMessage("Got the Sequence, Do you want to see the joke:");
                        alertDialogBuilder.setCancelable(false);
                        alertDialogBuilder.setPositiveButton("yes",
                                new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface arg0, int arg1) {
                                        Intent intent = new Intent(QuestionActivity.this, AnswerActivity.class);
                                        intent.putExtra("message", j);
                                        startActivity(intent);
                                        finish();
                                    }
                                });

                        AlertDialog alertDialog = alertDialogBuilder.create();
                        alertDialog.show();
                    } else {
                        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(QuestionActivity.this);
                        alertDialogBuilder.setMessage("Sorry, Not the correct sequence");
                        alertDialogBuilder.setCancelable(false);
                        alertDialogBuilder.setPositiveButton("Try again",
                                new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface arg0, int arg1) {
                                    }
                                });

                        AlertDialog alertDialog = alertDialogBuilder.create();
                        alertDialog.show();
                    }
                }
                else
                {
                    Toast.makeText(QuestionActivity.this, "Please try some sequence... ", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    boolean doubleBackToExitPressedOnce = false;

    @Override
    public void onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            Intent intent=new Intent(QuestionActivity.this,MainActivity.class);
            startActivity(intent);
            finish();
        }

        this.doubleBackToExitPressedOnce = true;
        Toast.makeText(this, "Please click BACK again to go back", Toast.LENGTH_SHORT).show();

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                doubleBackToExitPressedOnce=false;
            }
        }, 2000);
    }
}
