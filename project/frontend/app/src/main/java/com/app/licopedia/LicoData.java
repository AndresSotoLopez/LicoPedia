package com.app.licopedia;

import org.json.JSONException;
import org.json.JSONObject;

public class LicoData {
    private String name;
    private String imageURL;


    public LicoData(JSONObject json) throws JSONException {
        this.name = json.getString("name");
        this.imageURL = json.getString("image_url");
    }

    public String getName() { return name; }
    public String getImageUrl() { return imageURL; }
}
