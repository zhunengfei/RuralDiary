package com.tianyuan.ruraldiary.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.tianyuan.ruraldiary.R;
import com.tianyuan.ruraldiary.presenter.CreateDiaryPresenter;
import com.tianyuan.ruraldiary.presenter.CreateDiaryPresenterImpl;
import com.tianyuan.ruraldiary.presenter.iview.ICreateDiaryView;

/**
 *创建日记
 */
public class CreateDiaryActivity extends AppCompatActivity implements ICreateDiaryView {
    private CreateDiaryPresenter createDiaryPresenter=null;
    private EditText etDiaryTitle;
    private EditText etDiaryContent;
    @Override  protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_diary);
        if (createDiaryPresenter==null){
            createDiaryPresenter=new CreateDiaryPresenterImpl(this);
        }
        createDiaryPresenter.onInitView();

    }

    @Override
    public void showToast(String msg) {
        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void initViews() {
        etDiaryTitle=(EditText)findViewById(R.id.et_diary_title);
        etDiaryContent=(EditText)findViewById(R.id.et_diary_content);
        //Toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //设置up button
        toolbar.setNavigationIcon(R.drawable.ic_action_back);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //与按下back键效果相同
                CreateDiaryActivity.this.finish();
            }
        });
    }

    @Override
    public EditText getEtDiaryTitle() {
        return etDiaryTitle;
    }

    @Override
    public EditText getetEtDiaryContent() {
        return etDiaryContent;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.adddiary_menu, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_done) {
            //完成create
            createDiaryPresenter.getEditTextInfo();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


}
