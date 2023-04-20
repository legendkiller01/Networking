import java.io.*;
import java.net.*;

public class chatclient {
    public static void main(String[] args) throws IOException {
        Socket soc = new Socket("127.0.0.1",2000);
        BufferedReader br=new BufferedReader(new InputStreamReader(soc.getInputStream()));
        PrintStream ps=new PrintStream(soc.getOutputStream());
        BufferedReader bo=new BufferedReader(new InputStreamReader(System.in));
        String st;
        while (true) {
            System.out.print("Client : ");
            st = bo.readLine();
            ps.println(st);
            st = br.readLine();
            System.out.println("Server : " + st );
            if (st.equalsIgnoreCase("Bye")) {
                ps.print("BYE");
                break;

            }
        }
            soc.close();
            br.close();
            ps.close();
            bo.close();


    }
}
