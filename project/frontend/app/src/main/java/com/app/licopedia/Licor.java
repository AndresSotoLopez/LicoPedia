package com.app.licopedia;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.jar.JarException;

public class Licor {
    private String urlLicor;

    public String getUrlLicor() {
        return urlLicor;
    }

    public void setUrlLicor(String urlLicor) {
        this.urlLicor = urlLicor;
    }

    public Licor(String urlLicor) {
        this.urlLicor = urlLicor;
    }
    public Licor (JSONObject json) throws JSONException {
        this.urlLicor=json.getString("urlLicor");
    }
}
