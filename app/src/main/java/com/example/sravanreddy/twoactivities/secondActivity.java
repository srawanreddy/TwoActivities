package com.example.sravanreddy.twoactivities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class secondActivity extends AppCompatActivity {
EditText messager;
TextView header;
TextView message;
Button sendMessage;
public static final String REPLYKEY="com.example.sravanreddy.twoactivities.extra.Reply";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        header=findViewById(R.id.messageheader_textview2);
        message=findViewById(R.id.message_textview2);
        message.setText(getIntent().getExtras().getString(MainActivity.SENDKEY));
        messager=findViewById(R.id.message_edittext2);
        sendMessage=findViewById(R.id.send_button2);
        sendMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String messageStr=messager.getText().toString();
                Intent replyIntent=new Intent();
                replyIntent.putExtra(REPLYKEY, messageStr);
                setResult(RESULT_OK, replyIntent);
                finish();
            }
        });

    }
}
