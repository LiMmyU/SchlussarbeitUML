package src;

import java.io.*;
import java.net.*;

public class Main {
    public static void main(String[] args) {
        String getUrlDamage = "http://localhost:9090/dcm/rest/v1/damage";
        String getUrlInsurance = "http://localhost:9090/isc/rest/v1/versicherung";

        try {
            System.out.println("GET Request Response:");
            sendGetRequest(getUrlDamage);
            sendGetRequest(getUrlInsurance);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void sendGetRequest(String getUrl) throws IOException {
        URL url = new URL(getUrl);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");

        int status = con.getResponseCode();
        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer content = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            content.append(inputLine);
        }

        in.close();
        con.disconnect();

        System.out.println("Response Code: " + status);
        System.out.println("Response Body: " + content.toString());
    }
}