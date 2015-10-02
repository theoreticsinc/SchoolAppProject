package com.theoreticsinc.schoolapp.utils;


/**
 * Created by Angelo on 9/23/2015.
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.theoreticsinc.schoolapp.models.Items;
import com.theoreticsinc.schoolapp.models.Newsletter;
import com.theoreticsinc.schoolapp.models.PageModel;

public class GSONParser {

    final String TAG = "GsonParser.java";

    public List<String> name;
    public List<String> details;

    public GSONParser() {
        List<String> name = new ArrayList<>();
        List<String> details = new ArrayList<>();
    }

    private static String readUrl(String urlString) throws Exception {
        BufferedReader reader = null;
        try {
            URL url = new URL(urlString);
            reader = new BufferedReader(new InputStreamReader(url.openStream()));
            StringBuffer buffer = new StringBuffer();
            int read;
            char[] chars = new char[1024];
            while ((read = reader.read(chars)) != -1)
                buffer.append(chars, 0, read);

            return buffer.toString();
        } finally {
            if (reader != null)
                reader.close();
        }
    }

    public static void main(String[] args) throws Exception {
        //new JSONParser().getJSONFromUrl(urlString);
        String url = readUrl("http://184.95.54.213/schoolapp/newsletters.json");
        //http://184.95.54.213/schoolapp/newsletters.json
        //http://www.javascriptkit.com/dhtmltutors/javascriptkit.json
        Gson gson = new Gson();
        PageModel page = gson.fromJson(url, PageModel.class);
        Newsletter newsletters = page.newsletters;
        //System.out.println(page.newsletters);
        for (Items item : newsletters.items)
            System.out.println("    " + item.name + "    " + item.details);
    }

    public void retrieveGSON() {
        try {
            String url = readUrl("http://184.95.54.213/schoolapp/newsletters.json");
            Gson gson = new Gson();
            PageModel page = gson.fromJson(url, PageModel.class);
            Newsletter newsletters = page.newsletters;
            //System.out.println(page.newsletters);
            for (Items item : newsletters.items) {
                System.out.println("    " + item.name + "    " + item.details);
                name.add(item.name);
                details.add(item.details);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}