package com.rohit.serviceexample;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class FragmentTab extends Fragment {
RecyclerView mRecyclerView;
    TextView tv_name;
    ArrayList<String> arrayList = new ArrayList<>();
    ProgressDialog pd;

@Nullable
@Override
public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.fragment_tab, container, false);

     tv_name = (TextView) view.findViewById(R.id.tv_name);
    pd =new ProgressDialog(getActivity());
    pd.setMessage("Loading");

    mRecyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
    LinearLayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
    mLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
    mRecyclerView.setLayoutManager(mLayoutManager);
//    RecyclerView.Adapter mAdapter = new AdapterOne();
//    mRecyclerView.setAdapter(mAdapter);
    return view;
}

public void changeName(int pos){
    if(pos==0) {
        pd.show();
        android.os.Handler handler = new android.os.Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                pd.dismiss();
                arrayList.clear();
                arrayList.add("Hi");
                arrayList.add("hello");
                arrayList.add("ok");
                updateUI();
            }
        }, 3000);
    }else if (pos ==1){
        pd.show();
        android.os.Handler handler = new android.os.Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                pd.dismiss();
                arrayList.clear();
                arrayList.add("jay");
                arrayList.add("yes");
                arrayList.add("ohkjo");
                updateUI();
            }
        }, 3000);
    }else{
        pd.show();
        android.os.Handler handler = new android.os.Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                pd.dismiss();
                arrayList.clear();
                arrayList.add("jagay");
                arrayList.add("yeagaews");
                arrayList.add("ohkagtejo");
                updateUI();
            }
        }, 3000);
    }

}

    private void updateUI() {
        StringBuilder sb =new StringBuilder();
        for(int i=0;i<arrayList.size();i++){
            sb.append(arrayList.get(i)+",");
        }

        tv_name.setText(sb.toString());
    }


}