package internet.TCP;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.UUID;
import java.util.concurrent.*;

/**
 * @ClassName TCPFileServer
 * @Description TODO
 * @Author Ganzhenghao
 * @Date 2021/3/8 15:52
 * @Version 1.0
 */
public class TCPFileServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(5555);
        final ExecutorService pool = Executors.newFixedThreadPool(5);
        new ThreadPoolExecutor(2, 5, 60, TimeUnit.SECONDS, new ArrayBlockingQueue<>(5), Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());

        while (true) {
            final Socket socket = serverSocket.accept();
            pool.submit(() -> {
                try (socket;
                     final BufferedInputStream inputStream = new BufferedInputStream(socket.getInputStream());
                     final BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream("JavaDay15/src/main/java/internet/TCP/img/" + UUID.randomUUID().toString().replace("-", "") + "copy.jpeg"));
                     final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream(), StandardCharsets.UTF_8))) {

                    byte[] bytes = new byte[8192];
                    int len;
                    while ((len = inputStream.read(bytes)) != -1) {
                        outputStream.write(bytes, 0, len);
                    }
                    outputStream.flush();
                    writer.write("上传成功!");
                    writer.flush();
                    socket.shutdownOutput();

                } catch (IOException e) {
                    e.printStackTrace();
                }
            });

        }


    }
}
