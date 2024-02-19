package com.app.licopedia;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class cocktails_list {
    private List<cocktails> cocktails_list;

    public List<cocktails> get_cocktails_list() {
        return cocktails_list;
    }

    public cocktails_list(JSONArray array) {
        cocktails_list = new ArrayList<>();

        for (int i = 0; i < array.length(); i++) {
            try {
                JSONObject jsonElement = array.getJSONObject(i);
                cocktails aCocktail = new cocktails(jsonElement);
                cocktails_list.add(aCocktail);
            } catch (JSONException e) {
                throw new RuntimeException(e);
            }
        }
    }

}
