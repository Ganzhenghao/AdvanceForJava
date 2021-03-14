package internet.UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.nio.charset.StandardCharsets;

/**
 * @ClassName UDPGroupSend
 * @Description TODO
 * @Author Ganzhenghao
 * @Date 2021/3/8 11:31
 * @Version 1.0
 */
public class UDPGroupSend {
    public static void main(String[] args) throws IOException {
        final DatagramSocket socket = new DatagramSocket();
        final byte[] bytes = "Good Day".getBytes(StandardCharsets.UTF_8);
        final DatagramPacket packet = new DatagramPacket(bytes,
                bytes.length, InetAddress.getByName("224.0.1.0"), 5555);
        socket.send(packet);
        socket.close();
    }
}
