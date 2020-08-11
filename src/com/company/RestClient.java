package com.company;

import jdk.nashorn.internal.parser.JSONParser;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;

public class RestClient {

    public static String getLocalTime() throws IOException {
        URL url = new URL("http://worldclockapi.com/api/json/utc/now");
        URLConnection connection = url.openConnection();
        InputStream inputStream = connection.getInputStream();

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));




        return null;
    }
}
