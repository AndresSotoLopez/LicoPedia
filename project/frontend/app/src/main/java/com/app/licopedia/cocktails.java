package com.app.licopedia;

import org.json.JSONException;
import org.json.JSONObject;


public class cocktails {
    private int id;
    private String name;
    private String image;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getImage() {
        return image;
    }

    public cocktails(JSONObject json) throws JSONException {
        this.id = json.getInt("id");
        this.name = json.getString("name");
        this.image = json.getString("image");
    }
}


