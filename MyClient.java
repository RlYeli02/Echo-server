import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

class MyClient {
    public static void main(String args[]) throws UnknownHostException, IOException {
        int port = 5000;
        Socket client = new Socket("localhost", port);
        DataOutputStream output = new DataOutputStream(client.getOutputStream());
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = "";

        while (!str.equals("stop socket")) {
            str = br.readLine();
            System.out.println(str);
            output.writeUTF(str);
            output.flush();

        }
        output.close();
        client.close();

    }
}
