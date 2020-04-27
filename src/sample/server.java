package sample;

import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.Scanner;

public class server {

    public static PrintWriter out1;
    public static PrintWriter out2;



    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        ServerSocket sersock = new ServerSocket(8545);
        System.out.println("Server Started...");
        ArrayList<Receive> users = new ArrayList<Receive>();
        int num = 1;
        while(true){

            Socket sock = sersock.accept( );
            users.add( new Receive(Integer.toString(num), sock));
            if(num == 1){
                out1 = new PrintWriter(sock.getOutputStream(), true);
                out1.println("hahaahha");
                out1.flush();

            }
            else if(num == 2){
                out2 = new PrintWriter(sock.getOutputStream(), true);
                out2.println("hahaahha not 1");
                out2.flush();
            }
            TheThreads t1 = new TheThreads(sock, num, out1, out2);
            if(num<3){
                System.out.println("starte");
                t1.running();
            }
            else{
                PrintWriter pwrite = new PrintWriter(sock.getOutputStream(), true);
                pwrite.println("Sorry this server is full, Create your own server to play with your friends. More information at https://www.romland.space/Hangman/");
                pwrite.flush();
            }
            num++;
        }
    }
}
class Receive{
    public static String user;
    public static Socket sock;

    public Receive(String userin, Socket sockin) {
        user = userin;
        sock = sockin;
    }

    public static BufferedReader read() throws IOException {
        BufferedReader receiveRead = new BufferedReader(new InputStreamReader(sock.getInputStream()));
        return receiveRead;
    }
}

class TheThreads extends Thread{

    public static Socket sock;
    public static int num;
    public static PrintWriter out1;
    public static PrintWriter out2;


    public TheThreads(Socket sockin, int number, PrintWriter out11, PrintWriter out22){
        sock = sockin;
        num = number;
        out1 = out11;
        out2 = out22;
    }

    public void running(){
        Thread t = new Thread(new Runnable(){

            @Override
            public void run() {
                System.out.println("hehehehehe");
                while(true){
                    System.out.println("inside now");
                    try {
                        String receiveMessage;
                        if((receiveMessage = Receive.read().readLine()) != null) {
                            System.out.println("in");
                            if (num == 1){
                                out1.println(receiveMessage);
                                out1.flush();
                                System.out.println(receiveMessage);
                            }
                            else if(num == 2){
                                out2.println(receiveMessage);
                                out2.flush();
                                System.out.println(receiveMessage);
                            }
                            else{
                                System.out.println("haha not wokring");
                            }
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }});
        t.run();

    }
}
