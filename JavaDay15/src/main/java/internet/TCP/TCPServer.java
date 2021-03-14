package internet.TCP;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @ClassName TCPServer
 * @Description TODO
 * @Author Ganzhenghao
 * @Date 2021/3/8 14:12
 * @Version 1.0
 */
public class TCPServer {
    public static void main(String[] args) {
        try {
            final ServerSocket serverSocket = new ServerSocket(5555);
            final Socket socket = serverSocket.accept();
            final InputStream stream = socket.getInputStream();
            int ch;
            while ((ch = stream.read()) != -1){
                System.out.print((char) ch);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
