import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class server {

    public static String string_check(String s){
        String s2 = null;
        if (s.substring(0,5).equals("echo\"")){
            s2 = s.substring(5, s.length()-1);
            // return "aaaa";
        }
        else if (s.substring(0,12).equals("standardize\"")){
            s2 = s.substring(12, s.length()-1).toUpperCase();
        }
        return s2;
    }

    public static void main(String[] args){
        final ServerSocket serverSocket;
        final Socket clientSocket;
        final BufferedReader in;
        final PrintWriter out;
        final Scanner sc = new Scanner(System.in);

        try{
            serverSocket = new ServerSocket(5001);
            clientSocket = serverSocket.accept();




            out = new PrintWriter(clientSocket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            //System.out.println("Hello from server");
            //out.println(clientSocket.getInetAddress().getHostAddress());

            Thread receive = new Thread(new Runnable(){
                String msg;
                @Override
                public void run(){
                    try {
                        msg = in.readLine();
                        while (msg != null){
                            System.out.println("Client said: "+ msg);


                            String result = string_check(msg);


                            out.println(result);
                            out.flush();


                            msg = in.readLine();

                        }
                        System.out.println("Client disconnected");
                        out.close();
                        clientSocket.close();
                        serverSocket.close();

                    }catch (IOException e){
                        e.printStackTrace();

                    }
                }
            });
            receive.start();


/*
            Thread sender = new Thread(new Runnable(){
                String msg;
                @Override
                public void run(){
                    while (true){
                        msg = sc.nextLine();

                        String result = string_check(msg);
                       // String result = string_check(value[0]);

                        out.println(result);
                        out.flush();
                    }
                }
            });
            sender.start();


 */



        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
