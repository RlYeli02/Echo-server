import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

class MyServer {
    public static void main(String args[]) throws IOException {
        int port = 5000;
        ServerSocket ss = new ServerSocket(port);
        Socket client = ss.accept();
        DataOutputStream output = new DataOutputStream(client.getOutputStream());
        DataInputStream input = new DataInputStream(client.getInputStream());

        String str = "";

        while (!str.equals("stop server")) {
            str = input.readUTF();
            output.writeUTF(str);
            System.out.println(str);

        }
        input.close();
        ss.close();
        client.close();

    }
}