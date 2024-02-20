package com.app.licopedia;

import org.json.JSONException;
import org.json.JSONObject;


public class cocktails {
    private String description;
    private String name;
    private String image;

    public String getDescription() {
        return description;
    }

    public String getName() {
        return name;
    }

    public String getImage() {
        return image;
    }

    public cocktails(JSONObject json) throws JSONException {
        this.description = json.getString("description");
        this.name = json.getString("name");
        this.image = json.getString("image_url");
    }
}


