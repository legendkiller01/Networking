import java.io.*;
import java.net.*;
public class http {
    public static void main(String[] args) throws Exception {
        URL url=new URL("https://www.google.com//");
        URLConnection conn= url.openConnection();
        conn.connect();
        InputStreamReader ip=new InputStreamReader(conn.getInputStream());
        FileWriter f=new FileWriter("google.html");
        for (int i=0;i!=-1;i= ip.read()){
            f.write((char)i);
        }
    }
}
