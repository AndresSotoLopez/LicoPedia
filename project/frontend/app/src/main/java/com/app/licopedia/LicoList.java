package com.app.licopedia;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class LicoList {
    private List<LicoData> licoData;

    public LicoList(JSONArray array){
        licoData = new ArrayList<>();
        for (int i = 0; i < array.length(); i++){
            try{
                JSONObject jsonElement = array.getJSONObject(i);
                LicoData aLico = new LicoData(jsonElement);
                licoData.add(aLico);
            } catch (JSONException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public List<LicoData> getLicoDataList() {
        return licoData;
    }
}
