package com.app.licopedia;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class LicoresList {
    private List<LicoresData> licoresDataList;

    public List<LicoresData> get_licores_list() {
        return licoresDataList;
    }

    public LicoresList(JSONArray array) {
        licoresDataList = new ArrayList<>();

        for (int i = 0; i < array.length(); i++) {
            try {
                JSONObject jsonElement = array.getJSONObject(i);
                LicoresData aLicor = new LicoresData(jsonElement);
                licoresDataList.add(aLicor);
            } catch (JSONException e) {
                e.printStackTrace(); // Manejar el error de parseo
            }
        }
    }
}
