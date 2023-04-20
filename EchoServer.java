import java.io.*;
import java.net.*;
class EchoServer{
    public static void main(String args[]) throws Exception
    {
        String s;
        ServerSocket ss;
        Socket soc;
        BufferedReader br;
        try
        {
            ss = new ServerSocket(8020);
            soc = ss.accept();
            br = new BufferedReader (new InputStreamReader(soc.getInputStream()));
            PrintStream ps = new PrintStream(soc.getOutputStream());
            System.out.println("Connected for echo:");
            while((s=br.readLine())!=null)
            {
                if(s.equals("end"))
                {
                    System.out.println("Client disconnected");
                    br.close();
                    break;
                }
                else
                    ps.println(s);
            }
        }

        catch(IOException ioe)
        {
            System.out.println(ioe);
        }
    }
}
