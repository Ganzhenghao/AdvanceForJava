package homework;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.nio.charset.StandardCharsets;

/**
 * @ClassName MayThreeClient
 * @Description TODO
 * @Author Ganzhenghao
 * @Date 2021/3/9 19:01
 * @Version 1.0
 */
public class MayThreeClient {
    public static void main(String[] args) {
//        使用UDP协议的发送端给接收端发送一句话：“服务端你好啊！”；然后接收端给发送端返回一句话，内容随意。

        try (DatagramSocket datagramSocket = new DatagramSocket();
             final DatagramSocket socket = new DatagramSocket(7777)) {

            final DatagramPacket packet = new DatagramPacket("服务端你好啊！".getBytes(StandardCharsets.UTF_8), "服务端你好啊！".getBytes(StandardCharsets.UTF_8).length, InetAddress.getByName("127.0.0.1"), 8888);
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
