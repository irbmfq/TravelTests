/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package travelQa;

//import java.lang.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class SimpleHttpRequest {

    /**   * @param args   */
    public static void main(String[] args) throws IOException, InterruptedException {
        File file = new File("C:\\Documents and Settings\\samaitra\\Desktop\\404.txt");

        BufferedReader bufRdr = new BufferedReader(new FileReader(file));
        String csvline = null;
        //read each line of text file
        File count = null;

        int c = 0;
        List<String> urlList = new ArrayList<String>();
        while ((csvline = bufRdr.readLine()) != null) {
            if(c==1500) {
                startProcessing(urlList);
                urlList = new ArrayList<String>();
                c=0;
            }
            urlList.add(csvline);
            c++;
        }
        startProcessing(urlList);
    }

    static void startProcessing(final List<String> urls) throws InterruptedException {
        Thread t = new Thread() {
            @Override
            public void run() {
            	
                for (String next : urls) {
                    HttpURLConnection connection = null;
                    try {
                        URL serverAddress = new URL(next);
                        connection = (HttpURLConnection) serverAddress.openConnection();
                        connection.setRequestMethod("GET");
                        connection.setDoOutput(true);
                        connection.setReadTimeout(10000);
                        connection.connect();
                        int code = connection.getResponseCode();
                        System.out.print(next);
                        System.out.print("   ---   ");
                        System.out.println(code);
                    } catch (MalformedURLException e) {
                        e.printStackTrace();
                    } catch (ProtocolException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    } finally {
                        connection.disconnect();
                        connection = null;
                    }
                }
            }
        };
        t.start();
    }
}
