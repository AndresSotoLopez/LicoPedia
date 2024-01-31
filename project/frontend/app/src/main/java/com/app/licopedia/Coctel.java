package com.app.licopedia;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.jar.JarException;

public class Coctel {
    private String image;
    private String name;

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Coctel(String image, String name) {
        this.image = image;
        this.name = name;
    }
    public Coctel (JSONObject jsonObject) throws JSONException {
        this.image = jsonObject.getString("image");
        this.name = jsonObject.getString("name");

    }
}
