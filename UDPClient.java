import java.io.*;
import java.net.*;

public class UDPClient {
    public static void main(String[] args) throws IOException {
        byte b[]=new byte[1024];
        FileInputStream file=new FileInputStream("C:\\Users\\91866\\IdeaProjects\\Networking\\src\\hey.txt");
        DatagramSocket dsoc=new DatagramSocket();
        int i=0;
        while (file.available()!=0 ){
            b[i]=(byte)file.read();
            i++;
        }
        file.close();
        dsoc.send(new DatagramPacket(b,i,InetAddress.getLocalHost(),1000));
    }
}
