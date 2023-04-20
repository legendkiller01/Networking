import java.io.*;
import java.net.*;

public class ip_server{


    public static void main(String[] args) {
        try {
            while (true) {
                ServerSocket ss = new ServerSocket(8020);
                Socket s = ss.accept();
                DataInputStream dis = new DataInputStream(s.getInputStream());
                String ip = dis.readLine();
                System.out.println("Ip address is : "+ ip);
                s.close();
            }
        }
        catch (Exception e){
            System.out.println(e);

        }

    }
}
