package javarush.task.task40.task4006;

import java.io.*;
import java.net.Socket;
import java.net.URL;

/*
Отправка GET-запроса через сокет
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        getSite(new URL("http://javarush.ru/social.html"));
    }

    public static void getSite(URL url) {
        try {
            Socket socket = new Socket(url.getHost(), 80);

            //Instantiates a new PrintWriter passing in the sockets output stream
            PrintWriter wtr = new PrintWriter(socket.getOutputStream());

            //Prints the request string to the output stream
            wtr.println("GET " + url.getFile() + " / HTTP/1.1\r\n");
            wtr.println("Host: " + url.getHost());
            wtr.println("User-Agent: Mozilla/5.0 ");
            wtr.println("\r\n\r\n");
            wtr.flush();

            //Creates a BufferedReader that contains the server response
            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String outStr;

            //Prints each line of the response
            while((outStr = br.readLine()) != null){
                System.out.println(outStr);
            }


            //Closes out buffer and writer
            br.close();
            wtr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}