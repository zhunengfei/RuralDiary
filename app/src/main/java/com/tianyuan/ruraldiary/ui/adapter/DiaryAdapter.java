package com.tianyuan.ruraldiary.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.tianyuan.ruraldiary.R;
import com.tianyuan.ruraldiary.bean.Diary;

import java.util.List;

/**
 * 首页RecycleView数据适配器
 * E为bean
 */
public class DiaryAdapter extends RecyclerView.Adapter<DiaryAdapter.DiaryViewHolder>{
    private List<Diary> mDatas;
    private Context mContext;
    private IonItemClickLister ionItemClickLister;

    public DiaryAdapter(Context context,List<Diary> datas){
        mDatas=datas;
        mContext=context;
    }

    /**
     * 注册事件监听器
     * @param ionItemClickLister
     */
    public void setIonItemClickLister(IonItemClickLister ionItemClickLister){
        this.ionItemClickLister=ionItemClickLister;
    }
    //创建ViewHolder
    @Override
    public DiaryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        DiaryViewHolder holder=new DiaryViewHolder(LayoutInflater.from(
                mContext).inflate(R.layout.home_list_item,parent,false));
        return holder;
    }
    //绑定ViewHolder
    @Override
    public void onBindViewHolder(final DiaryViewHolder holder, int position) {
        if (mDatas!=null) {
            holder.mTitletext.setText(mDatas.get(position).getTitle());
            holder.mContenttext.setText(mDatas.get(position).getContent());
            holder.mDiaryDate.setText(mDatas.get(position).getCreatetime());
        }

        //回调事件
        if(ionItemClickLister!=null){
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //获取位置
                    int layoutpos=holder.getLayoutPosition();
                    ionItemClickLister.onItemClick(holder.itemView,layoutpos);
                }
            });
            holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View view) {
                    int layoutpos=holder.getLayoutPosition();
                    ionItemClickLister.onItemLongClick(holder.itemView,layoutpos);
                    return true;
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        if (mDatas!=null)
            return mDatas.size();
        else
            return 0;
    }
    class DiaryViewHolder extends RecyclerView.ViewHolder{
        //日记标题
        TextView mTitletext;
        //日记内容(概要)
        TextView mContenttext;
        //日记发表时间
        TextView mDiaryDate;
        public DiaryViewHolder(View itemView) {
            super(itemView);
            mTitletext=(TextView)itemView.findViewById(R.id.tv_diarytitle);
            mContenttext=(TextView)itemView.findViewById(R.id.tv_diarycontent);
            mDiaryDate=(TextView)itemView.findViewById(R.id.tv_diarydate);
        }
    }
}
