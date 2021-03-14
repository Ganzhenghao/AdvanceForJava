package homework;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.nio.charset.StandardCharsets;

/**
 * @ClassName MayThreeServer
 * @Description TODO
 * @Author Ganzhenghao
 * @Date 2021/3/9 19:09
 * @Version 1.0
 */
public class MayThreeServer {
    public static void main(String[] args) {
        try (DatagramSocket datagramSocket = new DatagramSocket();
             final DatagramSocket socket = new DatagramSocket(8888)) {

            final DatagramPacket packet = new DatagramPacket("你也好！".getBytes(StandardCharsets.UTF_8), "你也好！".getBytes(StandardCharsets.UTF_8).length, InetAddress.getByName("127.0.0.1"), 7777);
            datagramSocket.send(packet);
            datagramSocket.close();


            final byte[] bytes = new byte[1024];
            final DatagramPacket pk = new DatagramPacket(bytes, bytes.length);
            socket.receive(pk);
            System.out.println(new String(pk.getData(),0, packet.getData().length));




        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
