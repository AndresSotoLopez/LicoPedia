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

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

import java.util.List;

public class MainActivity extends Fragment {
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
    public void onAttach(Context newContext){
        super.onAttach(newContext);
        this.context = newContext;
    }

    public CoctelList getCoctelList(){
        return  coctelList;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_main, container, false);
        queue= Volley.newRequestQueue(context);

        JsonObjectRequest request = new JsonObjectRequest(
                Request.Method.GET,
                Server.name + "/conctelsGuardados",
                null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }
        );
        queue.add(request);

        return view;
    }
}
