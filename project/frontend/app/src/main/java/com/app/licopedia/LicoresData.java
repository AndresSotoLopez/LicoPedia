package com.app.licopedia;

import org.json.JSONException;
import org.json.JSONObject;

public class LicoresData {
    private String name;
    private String imageURL;

    // Constructor que acepta los tres campos como argumentos individuales
    public LicoresData(String name, String imageURL) {
        this.name = name;
        this.imageURL = imageURL;
    }

    public LicoresData(JSONObject jsonElement) throws JSONException{
        this.name = jsonElement.getString("name");
        this.imageURL = jsonElement.getString("image_url");
    }

    public String getName() { return name; }
    public String getImageUrl() { return imageURL; }
}
