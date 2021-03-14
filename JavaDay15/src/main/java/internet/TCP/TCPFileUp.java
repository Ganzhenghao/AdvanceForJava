package internet.TCP;

import java.io.*;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

/**
 * @ClassName TCPFileUp
 * @Description TODO
 * @Author Ganzhenghao
 * @Date 2021/3/8 15:43
 * @Version 1.0
 */
public class TCPFileUp {

    public static void main(String[] args) {

        try (Socket socket = new Socket("127.0.0.1", 5555);
             final BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream("JavaDay15/src/main/java/internet/TCP/img/PIC.jpeg"));
             final BufferedOutputStream outputStream = new BufferedOutputStream(socket.getOutputStream());
             final BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream(), StandardCharsets.UTF_8))) {
            byte[] bytes = new byte[8192];
            int len;
            while ((len = inputStream.read(bytes)) != -1) {
                outputStream.write(bytes, 0, len);
            }
            outputStream.flush();
            socket.shutdownOutput();

            String line;
            while ((line = reader.readLine()) != null){
                System.out.println(line);
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
