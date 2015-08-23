package com.xp.note;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.getbase.floatingactionbutton.FloatingActionButton;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 保存Note
 */
public class EditNote extends Activity implements View.OnClickListener {
    private EditText titleEt;
    private EditText contentEt;
    private FloatingActionButton saveBtn;
    private int noteID = -1;
    private DBManager dbManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit_text);

        dbManager=new DBManager(this);
        titleEt= (EditText) findViewById(R.id.note_title);
        contentEt= (EditText) findViewById(R.id.note_content);
        saveBtn= (FloatingActionButton) findViewById(R.id.save);
        saveBtn.setOnClickListener(this);

        noteID = getIntent().getIntExtra("id", -1);
        if (noteID!=-1) {
            showNoteData(noteID);
        }
   }

    /**
     * 查看Note详情，从数据库中读取数据
     * @param id
     */
    private void showNoteData(int id){
        Note note = dbManager.readData(id);
        titleEt.setText(note.getTitle());
        contentEt.setText(note.getContent());
    }

    @Override
    public void onClick(View view) {
        String title=titleEt.getText().toString();
        String content=contentEt.getText().toString();
        String time=getTime();
        if( title.equals("") ) {
            Toast.makeText( EditNote.this , "请输入至少一个标题！" , Toast.LENGTH_LONG ).show() ;
        }else {
            if (noteID == -1) {
                dbManager.addToDB(title,content,time);
            } else {
                dbManager.updateNote(noteID, title,content,time);
            }
            Intent i=new Intent(EditNote.this,MainActivity.class);
            startActivity(i);
            i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            this.finish();
        }
    }

    private String getTime() {
        SimpleDateFormat format = new SimpleDateFormat("MM-dd HH:mm E");
        Date curDate = new Date();
        String str = format.format(curDate);
        return str;
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_about:
                new AlertDialog.Builder(this).setTitle("关于")
                        .setMessage("Created By Gavin")
                        .setPositiveButton("关闭", null).show();
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }


    /**
     * 返回按钮操作
     */
    @Override
    public void onBackPressed() {
        Intent intent = new Intent(EditNote.this, MainActivity.class);
        startActivity(intent);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        this.finish();
    }


}
