package com.lsj.smartpiano.module.video.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.lsj.smartpiano.R;
import com.lsj.smartpiano.module.video.adapter.AdvanceListAdapter;
import com.lsj.smartpiano.module.video.bean.AdvanceListBean;
import com.lsj.smartpiano.module.video.customui.PullLoadMoreRecyclerView;
import com.lsj.smartpiano.module.video.net.VideoListInterface;
import com.lsj.smartpiano.module.video.net.VideoListRest;
import com.lsj.smartpiano.module.video.ui.AdvanceContentActivity;
import com.orhanobut.logger.Logger;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;

/**
 * Created by shiny_jia
 * on 2016-05-18 11:27.
 * 进阶教程fragment
 */
public class AdvanceVideoFragment extends Fragment {
    public static final String ARG_PAGE = "ADVANCE_PAGE";
    @Bind(R.id.advance_recyclerView_list)
    PullLoadMoreRecyclerView advanceList;
    @Bind(R.id.empty_view)
    TextView emptyView;
    private AdvanceListAdapter adapter;
    private List<AdvanceListBean.DataEntity.CoursesEntity.ListEntity> mList = new ArrayList<>();

    private int mPage;

    public static AdvanceVideoFragment newInstance(int page) {
        Bundle args = new Bundle();
        args.putInt(ARG_PAGE, page);
        AdvanceVideoFragment fragment = new AdvanceVideoFragment();
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
        View view = inflater.inflate(R.layout.advance_fragment_page, container, false);
        ButterKnife.bind(this, view);
        advanceList.setGridLayout(2);
        initDate();
        return view;
    }

    private void initDate() {
        VideoListInterface service = VideoListRest.getClient();
        Call<AdvanceListBean> call = service.getAdvanceList("2.4.5", "android", "1tai", "1", "0", "0", "zh_CN");
        call.enqueue(new Callback<AdvanceListBean>() {
            @Override
            public void onResponse(Response<AdvanceListBean> response) {
                if (response.isSuccess()) {
                    advanceList.setPullLoadMoreCompleted();
                    AdvanceListBean result = response.body();
                    if (mList != null) {
                        mList.clear();
                    }
                    mList = result.getData().getCourses().getList();
                    adapter = new AdvanceListAdapter(getActivity(), mList);
                    advanceList.setAdapter(adapter);
                    adapter.setOnItemClickListener(new AdvanceListAdapter.OnRecyclerViewItemClickListener() {
                        @Override
                        public void onItemClick(View view, int position) {
                            Intent intent = new Intent(getActivity(), AdvanceContentActivity.class);
                            intent.putExtra("active_detail_url",mList.get(position).getPic());
                            intent.putExtra("active_detail_name",mList.get(position).getName());
                            intent.putExtra("active_detail_desc",mList.get(position).getDesc());
                            intent.putExtra("active_detail_id",mList.get(position).getId());
                            ActivityOptionsCompat options =
                                    ActivityOptionsCompat.makeSceneTransitionAnimation(getActivity(),
                                            view.findViewById(R.id.ic_list_pic), "哈哈");//getString(R.string.transition_book_img)
                            ActivityCompat.startActivity(getActivity(),intent,options.toBundle());
                        }
                    });
                    Logger.json(response.toString());
                } else {
                    Toast.makeText(getActivity(), "没有更多的数据", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Throwable t) {
                Toast.makeText(getActivity(), "接口请求失败2,错误信息：" + t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
        advanceList.setPullLoadMoreCompleted();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
