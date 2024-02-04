package com.app.licopedia;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class LicorList {
    private List<Licor> licor;

    public List<Licor> getLicor() {
        return licor;
    }

    public void setLicor(List<Licor> licor) {
        this.licor = licor;
    }

    public LicorList(List<Licor> licor) {
        this.licor = licor;
    }
    public  LicorList(JSONArray array){
        licor = new ArrayList<>();
        for(int i=0;i<array.length();i++){
            try {
                JSONObject jsonObject = array.getJSONObject(i);
                Licor aLicor = new Licor(jsonObject);
                licor.add(aLicor);
            }catch (JSONException e){
                throw new RuntimeException(e);
            }
        }
    }
}
