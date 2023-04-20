import java.io.*;
import java.net.*;
class EchoClient{
    public static void main(String args[]) throws Exception
    {
        String s;
        try
        {
            Socket soc = new Socket(InetAddress.getLocalHost(),8020);
            BufferedReader brin = new BufferedReader(new InputStreamReader(System.in));
            BufferedReader br_sock = new BufferedReader(new InputStreamReader(soc.getInputStream()));
            PrintStream ps = new PrintStream(soc.getOutputStream());
            System.out.println("Start echoing... type 'end' to terminate");
            while((s=brin.readLine())!=null)
            {
                ps.println(s);
                if(s.equals("end"))
                    break;
                else
                    System.out.println("echoed from server:"+br_sock.readLine());

            }
        }
        catch(IOException ioe)
        {
            System.out.println(ioe);
        }
    }
}