package model;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;

public class HttpClient {
    private String location;
    public final CloseableHttpClient httpClient = HttpClients.createDefault();

    public void placeSearch (String placeName) throws Exception {
        URIBuilder builder = new URIBuilder("https://maps.googleapis.com/maps/api/place/findplacefromtext/json?");
        builder.setParameter("input", placeName)
                .setParameter("inputtype" , "textquery")
                .setParameter("fields", "formatted_address,name,geometry")
                .setParameter("key", "AIzaSyAZg7MZ9kwk47HDaNATzBIsceXCAl4gBKc");
        HttpGet request = new HttpGet(builder.build());
        try (CloseableHttpResponse response = httpClient.execute(request)) {
            //System.out.println(response.getStatusLine().toString());
            HttpEntity entity = response.getEntity();
            Header headers = entity.getContentType();
            if (entity != null) {
                // return it as a String
                String result = EntityUtils.toString(entity);
                parseAddress(result);
                parseLat(result);
                parseLong(result);

            }

        }

    }

    public void parseLat(String string) {
        JSONObject obj = new JSONObject(string);
        JSONArray arr = obj.getJSONArray("candidates");
        obj = arr.getJSONObject(0);
        obj = obj.getJSONObject("geometry");
        obj = obj.getJSONObject("viewport");
        obj = obj.getJSONObject("southwest");
        String latitude = obj.get("lat").toString();
        System.out.println(latitude);

    }

    public void parseLong(String string) {
        JSONObject obj = new JSONObject(string);
        JSONArray arr = obj.getJSONArray("candidates");
        obj = arr.getJSONObject(0);
        obj = obj.getJSONObject("geometry");
        obj = obj.getJSONObject("viewport");
        obj = obj.getJSONObject("southwest");
        String longitude = obj.get("lng").toString();
        System.out.println(longitude);

    }

    public void parseAddress(String string) {
        JSONObject obj = new JSONObject(string);
        JSONArray arr = obj.getJSONArray("candidates");
        obj = arr.getJSONObject(0);
        String address = obj.get("formatted_address").toString();
        System.out.println(address);

    }

  }
