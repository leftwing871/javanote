package javaexample;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Network01 {
    public static void main(String[] args)
    {
        try
        {
            URL url = new URL("https://uz20xxi3pg.execute-api.ap-northeast-2.amazonaws.com/LIVE/");
            HttpURLConnection httpcon = (HttpURLConnection) url.openConnection();
            httpcon.setRequestMethod("GET");
            httpcon.setConnectTimeout(5000);
            int status = httpcon.getResponseCode();

            BufferedReader inbr = new BufferedReader(new InputStreamReader(httpcon.getInputStream()));
            String inputLine;
            StringBuffer content = new StringBuffer();
            while ((inputLine = inbr.readLine()) != null) {
                System.out.println("inputLine: " + inputLine);
                content.append(inputLine);
            }
            inbr.close();
            httpcon.disconnect();

            System.out.println("status: " + status);
            System.out.println("content: " + content.toString());
        } catch(Exception ex) {
            System.out.println("inputLine 에러발생: " + ex.toString());
        }
    }
}
