package com.byted.camp.todolist;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.byted.camp.todolist.beans.Note;
import com.byted.camp.todolist.db.TodoDatabase;
import com.byted.camp.todolist.ui.NoteViewHolder;

import java.text.SimpleDateFormat;
import java.util.Date;

public class NoteActivity extends AppCompatActivity {

    private EditText editText;
    private Button addBtn;
    private RadioButton radioButton[];
    private TodoDatabase todoDatabase;
    private final String tag = "note";
//    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note);
        setTitle(R.string.take_a_note);

        todoDatabase = TodoDatabase.getInstance(getApplicationContext());

        editText = findViewById(R.id.edit_text);
        editText.setFocusable(true);
        editText.requestFocus();
        InputMethodManager inputManager = (InputMethodManager)
                getSystemService(Context.INPUT_METHOD_SERVICE);
        if (inputManager != null) {
            inputManager.showSoftInput(editText, 0);
        }

        radioButton = new RadioButton[4];
        radioButton[0] = findViewById(R.id.radioButton0);
        radioButton[1] = findViewById(R.id.radioButton1);
        radioButton[2] = findViewById(R.id.radioButton2);
        radioButton[3] = findViewById(R.id.radioButton3);

        addBtn = findViewById(R.id.btn_add);

        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Note note = new Note();
                CharSequence content = editText.getText();
                if (TextUtils.isEmpty(content)) {
                    Toast.makeText(NoteActivity.this,
                            "No content to add", Toast.LENGTH_SHORT).show();
                    return;
                }
                note.setContent(content.toString().trim());

                int priority = 0;
                for(int i=0;i<4;i++){
                    if(radioButton[i].isChecked()){
                        priority = i;
                        break;
                    }
                }

                note.setPriority(priority);
                note.setState(0);
                note.setDate(NoteViewHolder.SIMPLE_DATE_FORMAT.format(new Date()));
//                note.setDate(sdf.format(new Date()));

                Log.d(tag, content.toString().trim());
                Log.d(tag, String.valueOf(priority));
                Log.d(tag, NoteViewHolder.SIMPLE_DATE_FORMAT.format(new Date()));
                try {
                    todoDatabase.noteOperator().insertAll(note);
                    Toast.makeText(NoteActivity.this,
                            "Note added", Toast.LENGTH_SHORT).show();
                    setResult(Activity.RESULT_OK);
                } catch (Exception e) {
                    Toast.makeText(NoteActivity.this,
                            "Error", Toast.LENGTH_SHORT).show();
                }
                finish();

            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

//    private boolean saveNote2Database(String content) {
//        //  插入一条新数据，返回是否插入成功
//        return false;
//    }
}
