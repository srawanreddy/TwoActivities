package com.example.sravanreddy.twoactivities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
EditText messager;
TextView message;
TextView header;
Button sendMessage;
public static final String SENDKEY="com.example.sravanreddy.twoactivities.extra.Message";
private static final int CODE=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        header=findViewById(R.id.messageheader_textview);
        header.setVisibility(View.INVISIBLE);
        messager=findViewById(R.id.message_edittext);
        message=findViewById(R.id.message_textview);
        sendMessage=findViewById(R.id.send_button);
        sendMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String messageStr=messager.getText().toString();
                Intent sendIntent=new Intent(MainActivity.this, secondActivity.class);
                sendIntent.putExtra(SENDKEY, messageStr);
                startActivityForResult(sendIntent, CODE);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==CODE){
            if(resultCode==RESULT_OK){
                header.setVisibility(View.VISIBLE);
                message.setText(data.getExtras().getString(secondActivity.REPLYKEY));
            }
        }
    }
}
