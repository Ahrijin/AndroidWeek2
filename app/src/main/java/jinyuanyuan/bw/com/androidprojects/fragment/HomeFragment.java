package jinyuanyuan.bw.com.androidprojects.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import jinyuanyuan.bw.com.androidprojects.R;
import jinyuanyuan.bw.com.androidprojects.view.IView;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment{
    Unbinder unbinder;
    @BindView(R.id.home_search)
    EditText homeSearch;
    @BindView(R.id.home_imags)
    ImageView homeImags;
    @BindView(R.id.frames)
    FrameLayout frames;
    private View v;
    private FragmentManager manager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_home, container, false);
        unbinder = ButterKnife.bind(this, v);

        manager = getChildFragmentManager();
        manager.beginTransaction().replace(R.id.frames,new ContentFragment()).commit();

        return v;
    }



    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick(R.id.home_imags)
    public void onViewClicked(View view) {
        switch (view.getId()){
            case R.id.home_imags:
                String home = homeSearch.getText().toString().trim();
                EventBus.getDefault().postSticky(home);
                manager = getChildFragmentManager();
                manager.beginTransaction().replace(R.id.frames,new SearchFragment()).commit();
                break;
        }
    }
}
