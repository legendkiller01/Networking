// chatserver class

import java.io.*;
import java.net.*;

public class chatserver {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(2000);
        Socket s = ss.accept();
        BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
        PrintStream ps = new PrintStream(s.getOutputStream());
        BufferedReader bo = new BufferedReader(new InputStreamReader(System.in));
        String st;

        while (true) {
            st = br.readLine();
            if (st.equalsIgnoreCase("Bye")) {
                ps.println("BYE");
                break;
            }
            System.out.println("Client : " + st);
            System.out.print("Server : ");
            st = bo.readLine();
            ps.println(st);

        }
        ss.close();
        s.close();
        br.close();
        ps.close();
        bo.close();

    }
}
