package chapter.android.aweme.ss.com.homework;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;
import chapter.android.aweme.ss.com.homework.R;

public class ChatRoom extends AppCompatActivity {
    private final String tag = "chatroom";
    private TextView content;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chatroom);
        content = findViewById(R.id.tv_content_info);
        Intent intent = getIntent();
        if(intent!=null){
            int temp = intent.getIntExtra(Exercises3.tag, 0);
            Log.d(tag, "Item: " + String.valueOf(temp));
            content.setText("Item: " + String.valueOf(temp));
        }
    }
}
