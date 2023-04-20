import java.io.*;
import java.net.*;

public class ip_client {
    public static void main(String[] args) {
        try {
            InetAddress ia = InetAddress.getLocalHost();
            Socket soc=new Socket(ia,8020);
            PrintStream ps=new PrintStream(soc.getOutputStream());
            ps.print(ia);
            soc.close();

        } catch (Exception e) {
            System.out.println(e);
        }

    }


    }

