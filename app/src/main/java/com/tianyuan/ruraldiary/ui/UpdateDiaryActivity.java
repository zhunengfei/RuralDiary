package com.tianyuan.ruraldiary.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.tianyuan.ruraldiary.R;
import com.tianyuan.ruraldiary.bean.Diary;
import com.tianyuan.ruraldiary.presenter.UpdateDiaryPreImpl;
import com.tianyuan.ruraldiary.presenter.UpdateDiaryPresenter;
import com.tianyuan.ruraldiary.presenter.iview.IUpdateDiaryView;

/**
 *更新日记
 */
public class UpdateDiaryActivity extends AppCompatActivity implements IUpdateDiaryView {
    //控件
    private EditText etTitle;
    private EditText etContent;

    private UpdateDiaryPresenter updateDiaryPresenter=null;

    @Override  protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.update_diary);
        if (updateDiaryPresenter==null){
            updateDiaryPresenter=new UpdateDiaryPreImpl(this);
        }
        //initView
        updateDiaryPresenter.onInitView();
        //initData
        updateDiaryPresenter.onSetData();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.updatediary_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();

        if (id == R.id.action_done) {
            //完成update
            updateDiaryPresenter.onSaveData(this);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void showToast(String msg) {
        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void initViews() {
        etTitle=(EditText)findViewById(R.id.et_title);
        etContent=(EditText)findViewById(R.id.et_content);
        //Toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //设置up button
        toolbar.setNavigationIcon(R.drawable.ic_action_back);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //与按下back键效果相同
                UpdateDiaryActivity.this.finish();
            }
        });
    }

    @Override
    public Diary getDiaryData() {
        Intent intent=getIntent();
        Diary diary =(Diary) intent.getSerializableExtra("updatediary");
        return diary;
    }

    @Override
    public EditText getEtTitle() {
        return etTitle;
    }

    @Override
    public EditText getEtContent() {
        return etContent;
    }
}
