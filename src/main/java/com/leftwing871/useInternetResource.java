package com.leftwing871;

import java.net.*;
import java.io.*;


public class useInternetResource {

    public static void main(String[] args) {
        //getInternetImage();
        //getInternetData();
        //useURL();
    }

    public static void useURL() {

    }

    public static void getInternetData() {
        URL url = null;
        BufferedReader input = null;
        String address = "https://www.facebook.com/index.php";
        String line = "";

        try {
            url = new URL(address);

            input = new BufferedReader(new InputStreamReader(url.openStream()));

            while((line = input.readLine()) != null) {
                System.out.println(line);
            }
            input.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void getInternetImage()
    {
        URL url = null;
        InputStream in = null;
        FileOutputStream out = null;
        String address = "https://www.google.co.kr/images/branding/googlelogo/2x/googlelogo_color_272x92dp.png";

        int ch = 0;

        try {
            url = new URL(address);
            in = url.openStream();
            out = new FileOutputStream("googlelogo_color_272x92dp.png");

            while((ch=in.read()) != -1) {
                out.write(ch);
            }
            in.close();
            out.close();

        } catch(Exception e) {
            e.printStackTrace();
        }
    }

}
