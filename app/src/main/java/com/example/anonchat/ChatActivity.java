package com.example.anonchat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import java.io.File;
import java.io.IOException;

public class ChatActivity extends AppCompatActivity {

    private TextView tvChatNickname;
    private TextView tvGroupName;

    private LinearLayout linearLayout;
    private ScrollView scrollView;

    private Button btnSend;
    private EditText edtMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        Context context = getApplicationContext();

        displayChatName();
        configureScrollView();
//        configureButtonSend();
//        configureEditTextMessage();
        scrollToBottom();
    }

    private void configureScrollView() {
        scrollView = findViewById(R.id.scrollView);
        linearLayout = findViewById(R.id.chatLayout);
    }

    public void displayChatName() {
        tvGroupName = findViewById(R.id.tvGroupName);
        String chatUsername = getIntent().getStringExtra("groupName");
        if (chatUsername != null) {
            tvGroupName.setText(chatUsername);
        } else {
            tvGroupName.setText(R.string.unknown_group);
        }
    }

    public void scrollToBottom() {
        scrollView.post(new Runnable() {
            @Override
            public void run() {
                scrollView.fullScroll(View.FOCUS_DOWN);
            }
        });
    }

}