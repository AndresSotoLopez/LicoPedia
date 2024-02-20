package com.app.licopedia;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class CoctelList {
    private List<Coctel> coctels;

    public List<Coctel> getCoctels() {
        return coctels;
    }

    public void setCoctels(List<Coctel> coctels) {
        this.coctels = coctels;
    }

    public CoctelList(List<Coctel> coctels) {
        this.coctels = coctels;
    }

    public CoctelList (JSONArray array){
        coctels = new ArrayList<>();
        try {
        for(int i=0;i<array.length();i++) {
            JSONObject jsonObject =array.getJSONObject(i);
            Coctel aCoctel = new Coctel(jsonObject);
            coctels.add(aCoctel);
        }
        }catch (JSONException e){
            throw new RuntimeException(e);
        }
    }
}
