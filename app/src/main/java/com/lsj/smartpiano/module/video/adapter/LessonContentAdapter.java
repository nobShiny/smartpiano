package com.lsj.smartpiano.module.video.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.lsj.smartpiano.R;
import com.lsj.smartpiano.module.video.bean.LessonContentBean;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by shiny_jia
 * on 2016-06-04 22:33.
 */
public class LessonContentAdapter extends RecyclerView.Adapter<LessonContentAdapter.ViewHolder> {

    private Context mContext;
    private List<LessonContentBean.DataEntity.LessonsEntity.ListEntity> dataList;
    private OnRecyclerViewItemClickListener mOnItemClickListener = null;

    public LessonContentAdapter(Context context, List<LessonContentBean.DataEntity.LessonsEntity.ListEntity> dataList) {
        this.dataList = dataList;
        mContext = context;
    }

    public void setOnItemClickListener(OnRecyclerViewItemClickListener listener) {
        this.mOnItemClickListener = listener;
    }

    public interface OnRecyclerViewItemClickListener {
        void onItemClick(View view, int position);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.lesson_content_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        Picasso.with(mContext)
                .load(R.drawable.ic_lesson_score)
                .into(holder.icListPic);
        holder.tvName.setText(dataList.get(position).getTitle());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mOnItemClickListener != null)
                    mOnItemClickListener.onItemClick(holder.itemView, position);
            }
        });
        Log.d("LessonContentAdapter", "111111::"+dataList.get(position).getTitle());
//        if(!dataList.get(position).getMovieUrl().equals("")){
//            Log.d("LessonContentAdapter", "下载中：" + dataList.get(position).getMovieUrl());
//        }else{
//            Toast.makeText(mContext, "服务器繁忙，请稍后再试", Toast.LENGTH_SHORT).show();
//        }

    }

    @Override
    public int getItemCount() {
        return dataList == null ? 0 : dataList.size();
    }

    static

    public class ViewHolder extends RecyclerView.ViewHolder {

        @Bind(R.id.ic_list_pic)
        ImageView icListPic;
        @Bind(R.id.tv_name)
        TextView tvName;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
