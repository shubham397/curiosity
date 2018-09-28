package com.example.shubh.curiosity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class AnswerActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_answer);

        TextView textView=(TextView)findViewById(R.id.answer_txt);
        TextView textView1=(TextView)findViewById(R.id.question_txt);

        Button exitBtn,tryBtn;

        exitBtn=(Button) findViewById(R.id.exit_btn);
        tryBtn=(Button) findViewById(R.id.try_again_btn);

        Bundle bundle = getIntent().getExtras();
        String message = bundle.getString("message");

        String[] got=message.split(":");

        textView.setText(got[1]);
        textView1.setText(got[0]+"?");

        exitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(AnswerActivity.this);
                alertDialogBuilder.setMessage("Are you sure,You want to Exit");
                alertDialogBuilder.setCancelable(false);
                alertDialogBuilder.setPositiveButton("yes",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface arg0, int arg1) {
                                System.exit(0);
                            }
                        });

                alertDialogBuilder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override

                    public void onClick(DialogInterface dialog, int which) {

                    }
                });

                AlertDialog alertDialog = alertDialogBuilder.create();
                alertDialog.show();
            }
        });

        tryBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(AnswerActivity.this,QuestionActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    @Override
    public void onBackPressed() {
    }
}
