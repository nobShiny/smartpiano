package com.lsj.smartpiano.module.video.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.lsj.smartpiano.R;
import com.lsj.smartpiano.module.video.adapter.VideoBaseListAdapater;
import com.lsj.smartpiano.module.video.bean.BaseListBean;
import com.lsj.smartpiano.module.video.customui.TimeLineLayout;
import com.lsj.smartpiano.module.video.net.SmartPianoApiInterface;
import com.lsj.smartpiano.common.net.SmartPianoRestClient;
import com.squareup.picasso.Picasso;

import butterknife.Bind;
import butterknife.ButterKnife;
import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;

/**
 * Created by shiny_jia
 * on 2016-05-18 11:26.
 * 基础教程fragment
 */
public class BaseVideoFragment extends Fragment {

    public static final String ARG_PAGE = "BASE_PAGE";
    @Bind(R.id.timeline_layout)
    TimeLineLayout timelineLayout;
    private VideoBaseListAdapater adapter;

    private int mPage;

    public static BaseVideoFragment newInstance(int page) {
        Bundle args = new Bundle();
        args.putInt(ARG_PAGE, page);
        BaseVideoFragment fragment = new BaseVideoFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPage = getArguments().getInt(ARG_PAGE);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.base_fragment_page, container, false);
        ButterKnife.bind(this, view);
        TextView headerView = new TextView(getActivity());
        headerView.setText("适用于接触钢琴0-3个月学习");
        headerView.setPadding(100, 20, 0, 0);
        timelineLayout.addView(headerView);
        initList();
        return view;

    }

    private void initList() {
        getServerData();


    }

    private void getServerData() {
        SmartPianoApiInterface service = SmartPianoRestClient.getClient();
        Call<BaseListBean> call = service.getBaseList("1000", "2.4.5", "android", "1tai", "1", "0", "0", "zh_CN");
        call.enqueue(new Callback<BaseListBean>() {
            @Override
            public void onResponse(Response<BaseListBean> response) {
                if (response.isSuccess()) {
                    BaseListBean result = response.body();
                    BaseListBean.DataEntity list = result.getData();
                    addItem(list);
                } else {
                    Toast.makeText(getActivity(), "没有更多的数据", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Throwable t) {
                Toast.makeText(getActivity(), "接口请求失败,错误信息：" + t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }

    private void addItem(BaseListBean.DataEntity list) {
        for (int i = 0; i < list.getSm().getList().size(); i++) {
            View v = LayoutInflater.from(getActivity()).inflate(R.layout.item_video_base_list, timelineLayout, false);
            ((TextView)v.findViewById(R.id.tv_content)).setText(list.getSm().getList().get(i).getName());
            ((TextView)v.findViewById(R.id.tv_count)).setText(list.getSm().getList().get(i).getLessonCount()+"课");
            Picasso.with(getActivity())
                    .load(list.getSm().getList().get(i).getPic())
                    .into((ImageView) v.findViewById(R.id.ic_list_pic));
            v.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(getActivity(), "haha"+v.getX(), Toast.LENGTH_SHORT).show();
                }
            });
            timelineLayout.addView(v);
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
