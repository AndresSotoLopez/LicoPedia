package com.app.licopedia;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

import java.util.List;

public class LicoresGuardadosMain extends Fragment {
    private List<Coctel> coctel;
    private CoctelList coctelList;
    private RecyclerView recyclerView;
    private CoctelAdapter coctelAdapter;
    private RequestQueue queue;

    private Button homeButton;
    private Context context;

    public void setNewsList(CoctelList coctelList) {
        this.coctelList = coctelList;
        recyclerView.setAdapter(coctelAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
    }

    @Override
    public void onAttach(Context newContext) {
        super.onAttach(newContext);
        this.context = newContext;
    }

    public CoctelList getCoctelList() {
        return coctelList;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_main, container, false);
        queue = Volley.newRequestQueue(context);
        return view;

    }
    public void ShowData(){
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        coctelAdapter= new CoctelAdapter(coctel,getContext());
        recyclerView.setAdapter(coctelAdapter);
    }

}