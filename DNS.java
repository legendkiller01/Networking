import java.io.*;
import java.net.*;

public class DNS {
    public static void main(String[] args) {
        int n;
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Menu : /n 1: DNS 2: Reverse DNS 3: Exit");
        System.out.println("Enter your choice : ");
        n=Integer.parseInt(System.console().readLine());
        if(n==1){
            try {
                System.out.println("Enter Host Name : ");
                String hname= br.readLine();
                InetAddress ia=InetAddress.getByName(hname);
                System.out.println("Host Name : " + ia.getHostName());
                System.out.println("IP : "+ia.getHostAddress());

            }
            catch (IOException e){
                e.printStackTrace();
            }

        }
        if (n==2){
            try{
                System.out.println("Enter Host Name : ");
                String str= br.readLine();
                InetAddress ia=InetAddress.getByName(str);
                System.out.println("Host Name : " + ia.getHostName());
                System.out.println("IP : "+str);

        }
            catch (IOException h ){
                h.printStackTrace();
        }


    }
        while(!(n==3));
    }
}
