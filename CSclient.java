import java.io.*;
import java.net.*;
import java.util.zip.*;
public class CSclient {
    public static void main(String[] args) throws Exception {
        Socket socket = new Socket("localhost", 1234);
        System.out.println("Connected to server");
        OutputStream outputStream = socket.getOutputStream();
        CheckedOutputStream checkedOutputStream = new CheckedOutputStream(outputStream, new
                CRC32());
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(checkedOutputStream);
        DataOutputStream dataOutputStream = new DataOutputStream(bufferedOutputStream);
        File file = new File("C:\\Users\\91866\\IdeaProjects\\Networking\\src\\bro.txt");
        byte[] data = new byte[(int) file.length()];
        FileInputStream fileInputStream = new FileInputStream(file);
        fileInputStream.read(data);
        fileInputStream.close();
        dataOutputStream.writeInt(data.length);
        dataOutputStream.write(data);
        dataOutputStream.flush();
        long crcValue = checkedOutputStream.getChecksum().getValue();
        System.out.println("CRC value of sent file: " + crcValue);
        socket.close();
    }
}