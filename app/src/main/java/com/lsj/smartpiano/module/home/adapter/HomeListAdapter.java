package com.lsj.smartpiano.module.home.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.lsj.smartpiano.R;
import com.lsj.smartpiano.common.utils.CircleTransformation;
import com.squareup.picasso.Picasso;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by shiny_jia
 * on 2016-05-16 17:02.
 */
public class HomeListAdapter extends RecyclerView.Adapter<HomeListViewHolder> {

    private Context mContext;
    private LayoutInflater mInflater;
    private int[] str_title;
    private int[] str_content;
    private int[] pic;
    private int[] bgColor;

    public HomeListAdapter(Context context, int[] str_title, int[] str_content, int[] pic, int[] color) {
        this.mContext = context;
        this.str_title = str_title;
        this.str_content = str_content;
        this.pic = pic;
        this.bgColor = color;
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public HomeListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.home_list_item, parent, false);
        HomeListViewHolder viewHolder = new HomeListViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(HomeListViewHolder holder, int position) {
        Picasso.with(mContext)
                .load(pic[position])
                .resize(mContext.getResources().getDimensionPixelSize(R.dimen.home_icon_size),
                        mContext.getResources().getDimensionPixelSize(R.dimen.home_icon_size))
                .centerCrop()
                .transform(new CircleTransformation())
                .into(holder.ivPic);
        holder.tvTitle.setText(str_title[position]);
        holder.tvContent.setText(str_content[position]);
        holder.llBg.setBackgroundColor(mContext.getResources().getColor(bgColor[position]));
    }

    @Override
    public int getItemCount() {
        return str_title.length;
    }
}

class HomeListViewHolder extends RecyclerView.ViewHolder {

    @Bind(R.id.iv_pic)
    ImageView ivPic;
    @Bind(R.id.tv_title)
    TextView tvTitle;
    @Bind(R.id.tv_content)
    TextView tvContent;
    @Bind(R.id.ll_bg)
    LinearLayout llBg;

    public HomeListViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }
}