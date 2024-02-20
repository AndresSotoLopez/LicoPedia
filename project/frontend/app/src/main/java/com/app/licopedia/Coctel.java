package com.app.licopedia;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.jar.JarException;

public class Coctel {
   // private String image;
    private int image;
    private String name;

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Coctel(int image, String name) {
        this.image = image;
        this.name = name;
    }
    public Coctel (JSONObject jsonObject) throws JSONException {
        this.image = jsonObject.getInt("image");
        this.name = jsonObject.getString("name");

    }
}
