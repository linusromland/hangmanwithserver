package sample;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class backendOnlineMP {
    public static void main(String[] args) throws Exception

            String _input;

    {
        Scanner input = new Scanner(System.in);
        System.out.println("What ip is your server running at?");
        String servername = input.nextLine();
        System.out.println("What your username?");
        String username = input.nextLine();
        Socket sock = new Socket(servername, 8545);
        BufferedReader keyRead = new BufferedReader(new InputStreamReader(System.in));
        OutputStream ostream = sock.getOutputStream();
        PrintWriter pwrite = new PrintWriter(ostream, true);

        InputStream istream = sock.getInputStream();
        BufferedReader receiveRead = new BufferedReader(new InputStreamReader(istream));

        System.out.println("Connected to " + servername + "...");

        String receiveMessage, sendMessage;

        Thread t = new Thread(new Runnable(){
            @Override
            public void run() {
                while(true){
                    try {
                        String receiveMessage;
                        if((receiveMessage = receiveRead.readLine()) != null) {
                            _input = receiveMessage;
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }});

        t.start();

        while (true) {
            if ((sendMessage = keyRead.readLine()) != null) {
                pwrite.println("From " + username + ": " +sendMessage);
                pwrite.flush();
            }
        }
    }
}
