import java.io.*;
import java.net.*;
import java.util.zip.*;
public class CSserver {
    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(1234);
        System.out.println("Server started");
        while (true) {
            Socket clientSocket = serverSocket.accept();
            System.out.println("Client connected: " + clientSocket.getInetAddress().getHostAddress());
            InputStream inputStream = clientSocket.getInputStream();
            CheckedInputStream checkedInputStream = new CheckedInputStream(inputStream, new CRC32());
            BufferedInputStream bufferedInputStream = new BufferedInputStream(checkedInputStream);
            DataInputStream dataInputStream = new DataInputStream(bufferedInputStream);
            int fileSize = dataInputStream.readInt();
            byte[] data = new byte[fileSize];
            dataInputStream.readFully(data, 0, fileSize);
            long crcValue = checkedInputStream.getChecksum().getValue();
            System.out.println("CRC value of received file: " + crcValue);
            FileOutputStream fileOutputStream = new FileOutputStream("C:\\Users\\91866\\IdeaProjects\\Networking\\src\\bro.txt");
            fileOutputStream.write(data);
            fileOutputStream.close();
            clientSocket.close();
        }
    }
}