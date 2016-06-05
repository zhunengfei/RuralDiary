package com.tianyuan.ruraldiary.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.tianyuan.ruraldiary.R;
import com.tianyuan.ruraldiary.bean.Diary;
import com.tianyuan.ruraldiary.presenter.DetailPresenter;
import com.tianyuan.ruraldiary.presenter.DetailPresenterImpl;
import com.tianyuan.ruraldiary.presenter.iview.IDetailView;
import com.tianyuan.ruraldiary.util.DateFormatUtil;
import com.tianyuan.ruraldiary.util.WeekFormatUtil;

/**
 * 日记详情
 */
public class DiaryDetailActivity extends AppCompatActivity implements IDetailView {
    private DetailPresenter detailPresenter=null;
    private TextView tvTitle;
    private TextView tvData;
    private TextView tvTime;
    private TextView tvContent;
    private Diary diary=null;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.diary_detail);
        if (detailPresenter==null){
            detailPresenter=new DetailPresenterImpl(this);
        }
        detailPresenter.onInitView();
        detailPresenter.onSetData();
    }

    @Override
    public void initViews() {
        //初始化控件
        tvTitle=(TextView)findViewById(R.id.tv_title);
        tvData=(TextView)findViewById(R.id.tv_date);
        tvTime=(TextView)findViewById(R.id.tv_time);
        tvContent=(TextView)findViewById(R.id.tv_content);
        //Toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //设置up button
        toolbar.setNavigationIcon(R.drawable.ic_action_back);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //与按下back键效果相同
               DiaryDetailActivity.this.finish();
            }
        });
    }

    @Override
    public void initDataForComponent() {
        Intent intent=getIntent();
        diary=(Diary) intent.getSerializableExtra("diaryItem");
        tvTitle.setText(diary.getTitle());
        tvContent.setText(diary.getContent());
        tvData.setText(DateFormatUtil.getFormatDate(diary.getCreatetime()));
        tvTime.setText(WeekFormatUtil.getFormatWeekAndTime(diary.getWeek()));
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.detail_menu, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_update) {
            //修改操作
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
