package sample;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

//THIS FILE IS CURRENTLY NOT IN USE!
//THIS FILE IS CURRENTLY NOT IN USE!
//THIS FILE IS CURRENTLY NOT IN USE!
//THIS FILE IS CURRENTLY NOT IN USE!
//THIS FILE IS CURRENTLY NOT IN USE!
//THIS FILE IS CURRENTLY NOT IN USE!
//THIS FILE IS CURRENTLY NOT IN USE!
//THIS FILE IS CURRENTLY NOT IN USE!
//THIS FILE IS CURRENTLY NOT IN USE!
//THIS FILE IS CURRENTLY NOT IN USE!
//THIS FILE IS CURRENTLY NOT IN USE!
//THIS FILE IS CURRENTLY NOT IN USE!
//THIS FILE IS CURRENTLY NOT IN USE!
//THIS FILE IS CURRENTLY NOT IN USE!
//THIS FILE IS CURRENTLY NOT IN USE!
//THIS FILE IS CURRENTLY NOT IN USE!
//THIS FILE IS CURRENTLY NOT IN USE!
//THIS FILE IS CURRENTLY NOT IN USE!
//THIS FILE IS CURRENTLY NOT IN USE!
//THIS FILE IS CURRENTLY NOT IN USE!

public class backendOnlineMP {

    public static Scanner _scanner = new Scanner(System.in);
    public static String _input;
    public static String servername;
    public static Socket sock;

    public static void main(String[] args) throws IOException {
        System.out.println("What ip is your server running at?");
        servername = _scanner.nextLine();
        sock = new Socket(servername, 8545);
        System.out.println("send something idk");
        send(_scanner.nextLine());
    }

    public static void server() throws Exception {
        System.out.println("What your username?");
        String username = _scanner.nextLine();
    }

    public static void send(String send) throws IOException {
        PrintWriter pwrite = new PrintWriter(sock.getOutputStream(), true);
        pwrite.println(send);
        pwrite.flush();

    }

    public static void receive() throws IOException {
        BufferedReader receiveRead = new BufferedReader(new InputStreamReader(sock.getInputStream()));
        Thread t = new Thread(new Runnable(){
            @Override
            public void run() {
                while(true){
                    try {
                        if((_input = receiveRead.readLine()) != null) {
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }});

        t.start();
    }

    public static void myguess(){
        System.out.println("");
    }


    public static void theirguess(){

    }

}
