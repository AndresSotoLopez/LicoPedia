package com.app.licopedia;


import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.View;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class cocktails_activity extends Fragment {
    private Context context;

    public static cocktails_activity newInstance(){
        return new cocktails_activity();
    }

    public void onAttach(Context newContext){
        super.onAttach(newContext);
        this.context = newContext;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View layout = inflater.inflate(R.layout.activity_cocktails, container, false);


        return layout;
    }
}