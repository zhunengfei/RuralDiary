package com.tianyuan.ruraldiary.ui;

import android.app.Dialog;
import android.app.SearchManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.tianyuan.ruraldiary.R;
import com.tianyuan.ruraldiary.bean.Diary;
import com.tianyuan.ruraldiary.presenter.HomePresenter;
import com.tianyuan.ruraldiary.presenter.HomePresenterImpl;
import com.tianyuan.ruraldiary.presenter.iview.IHomeView;
import com.tianyuan.ruraldiary.ui.adapter.DiaryAdapter;
import com.tianyuan.ruraldiary.ui.adapter.IonItemClickLister;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity implements IHomeView{
    private HomePresenter homePresenter;//控制层接口

    private RecyclerView recyclerView;
    private DiaryAdapter diaryAdapter;

    private FloatingActionButton flb_add;

    private List<Diary> datas=new ArrayList<Diary>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        setHomePresenter();
        homePresenter.initDataBase();
        homePresenter.initViews();
    }
    @Override
    protected void onResume(){
        super.onResume();

    }
    @Override
    protected void onRestart(){
        super.onRestart();
        homePresenter.notifyData();
    }
    public void setHomePresenter(){
        homePresenter=new HomePresenterImpl(this,this);
    }

    @Override
    public void showToast(String msg) {
        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void initViews() {
        //设置toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //浮动按钮
        flb_add=(FloatingActionButton)findViewById(R.id.flb_add);
        flb_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //创建日记
                homePresenter.createDiary(HomeActivity.this);
            }
        });
    }

    @Override
    public void setData() {
        //获取适配器数据
        if (homePresenter.getAllDiary()!=null){
            datas=homePresenter.getAllDiary();
        }else{
            Log.v("log","获取数据为空");
        }
    }

    @Override
    public void showRemoveDialog(final int position) {
        Dialog dialog=new AlertDialog.Builder(this)
                .setTitle("删除日记？")//设置标题
                .setMessage("确定删除此条吗？")//设置提示内容
                //确定按钮
                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if (datas.size()>=1){
                            homePresenter.deleteDiary(datas.get(position));
                            datas.remove(position);
                            diaryAdapter.notifyItemRemoved(position);
                        }
                    }
                })
                //取消按钮
                .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                })
                .create();//创建对话框
        dialog.show();//显示对话框
    }

    @Override
    public void setRecycleView() {
        recyclerView=(RecyclerView)findViewById(R.id.rv_diarylist);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        diaryAdapter=new DiaryAdapter(this,datas);
        recyclerView.setAdapter(diaryAdapter);

        diaryAdapter.setIonItemClickLister(new IonItemClickLister() {
            @Override
            public void onItemClick(View view, int position) {
                homePresenter.readDiary(HomeActivity.this,datas.get(position));
            }

            @Override
            public void onItemLongClick(View view, int position) {
                showRemoveDialog(position);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.home_menu, menu);

        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        SearchView searchView = (SearchView)menu.findItem(R.id.action_search).getActionView();
        ComponentName cn = new ComponentName(this, ShowResultActivity.class);
        searchView.setSearchableInfo(searchManager.getSearchableInfo(cn));

        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
