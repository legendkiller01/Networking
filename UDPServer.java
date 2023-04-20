import java.io.*;
import java.net.*;

public class UDPServer {
    public static void main(String[] args) throws IOException{
        byte b[]=new byte[2048];
        System.out.println("Server is running...");
        DatagramSocket dsoc=new DatagramSocket(1000);
        FileOutputStream fout=new FileOutputStream("C:\\Users\\91866\\IdeaProjects\\Networking\\src\\hey.txt");
        DatagramPacket dpac=new DatagramPacket(b,b.length);
        dsoc.receive(dpac);
        String str=new String(dpac.getData());
        fout.write(str.getBytes());
        fout.close();

    }
}
