package jinyuanyuan.bw.com.androidprojects.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.jcodecraeer.xrecyclerview.XRecyclerView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import jinyuanyuan.bw.com.androidprojects.R;
import jinyuanyuan.bw.com.androidprojects.adapter.SearchAdapter;
import jinyuanyuan.bw.com.androidprojects.bean.SearchBean;
import jinyuanyuan.bw.com.androidprojects.connector.Contacts;
import jinyuanyuan.bw.com.androidprojects.presenter.PresenterImpls;
import jinyuanyuan.bw.com.androidprojects.view.IView;

/**
 * A simple {@link Fragment} subclass.
 */
public class SearchFragment extends Fragment implements IView {

    @BindView(R.id.search_recy)
    XRecyclerView searchRecy;
    Unbinder unbinder;
    private View v;
    private int index =1;
    private String dataes;
    private int pages = 1;
    private PresenterImpls presenterImpls;
    private SearchAdapter searchAdapter;

    private List<SearchBean.ResultBean> searchList = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_search, container, false);
        //eventbus注册
        EventBus.getDefault().register(this);
        unbinder = ButterKnife.bind(this, v);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(),2);
        searchRecy.setLayoutManager(gridLayoutManager);

        searchAdapter = new SearchAdapter(searchList,getActivity());
        searchRecy.setAdapter(searchAdapter);

        Map<String,String> map = new HashMap<>();
        map.put("keyword",dataes);
        map.put("page",(++pages)+"");
        map.put("count",5+"");
        presenterImpls = new PresenterImpls(this);
        presenterImpls.getRequest(Contacts.FINDCOMMODITYBYKEYWORD,map,SearchBean.class);
        return v;
    }

    @Subscribe(threadMode = ThreadMode.MAIN,sticky = true)
    public void getData(String data) {
        dataes = data;
        Toast.makeText(getActivity(), dataes+"", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setSuccess(Object datas) {
        Log.d("zzz","成功了");
        SearchBean searchBean = (SearchBean) datas;
        searchList.addAll(searchBean.getResult());
        Log.e("zzz",searchBean.getMessage()+"++++");
        searchAdapter.notifyDataSetChanged();
    }

    @Override
    public void setError(Object errors) {
        Log.d("zzz","失败了");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
