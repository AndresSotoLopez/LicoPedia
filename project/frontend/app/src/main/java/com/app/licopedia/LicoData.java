package com.app.licopedia;

import org.json.JSONException;
import org.json.JSONObject;

public class LicoData {
    private int id;
    private String name;
    private String imageURL;


    public LicoData(JSONObject json) throws JSONException {
        this.id = json.getInt("id");
        this.name = json.getString("name");
        this.imageURL = json.getString("image");
    }


    public int getId() { return id; }
    public String getName() { return name; }
    public String getImageUrl() { return imageURL; }
}
