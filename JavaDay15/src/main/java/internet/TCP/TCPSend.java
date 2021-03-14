package internet.TCP;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

/**
 * @ClassName TCPSend
 * @Description TODO
 * @Author Ganzhenghao
 * @Date 2021/3/8 14:09
 * @Version 1.0
 */
public class TCPSend {
    public static void main(String[] args) throws IOException {


        final Socket socket = new Socket("127.0.0.1",5555);

        final OutputStream stream = socket.getOutputStream();

        try(socket; stream; final BufferedOutputStream outputStream = new BufferedOutputStream(stream)) {

            //stream.write("Hello world ! ".getBytes(StandardCharsets.UTF_8));
            outputStream.write("Hello world ! ".getBytes(StandardCharsets.UTF_8));

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
