package jinyuanyuan.bw.com.androidprojects.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import jinyuanyuan.bw.com.androidprojects.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ListFragment extends Fragment {

 private View v;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_list, container, false);
        return v;
    }

}
