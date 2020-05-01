package chapter.android.aweme.ss.com.homework;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import chapter.android.aweme.ss.com.homework.R;

/**
 * 作业2：一个抖音笔试题：统计页面所有view的个数
 * Tips：ViewGroup有两个API
 * {@link android.view.ViewGroup #getChildAt(int) #getChildCount()}
 * 用一个TextView展示出来
 */
public class Exercises2 extends AppCompatActivity {



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_relativelayout);
        TextView tv;
        tv = findViewById(R.id.tv_center);
        String s = String.valueOf(getAllChildViewCount(getWindow().getDecorView()));
        tv.setText(s);
    }

    public int getAllChildViewCount(View view) {
        if(view == null)
            return 0;
        if(view instanceof ViewGroup){
            int all = 0;
            ViewGroup viewgroup = (ViewGroup) view;
            int count = viewgroup.getChildCount();
            for(int i=0;i<count;i++){
                View v = viewgroup.getChildAt(i);
                if(v instanceof ViewGroup){
                    all += getAllChildViewCount(v);
                }
                else{
                    all++;
                }
            }
            return all;
        }
        return 1;
    }
}
