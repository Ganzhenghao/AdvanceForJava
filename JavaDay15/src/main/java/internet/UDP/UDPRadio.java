package internet.UDP;

import java.io.IOException;
import java.net.*;
import java.nio.charset.StandardCharsets;

/**
 * @ClassName UDPRadio
 * @Description TODO
 * @Author Ganzhenghao
 * @Date 2021/3/8 11:49
 * @Version 1.0
 */
public class UDPRadio {
    public static void main(String[] args) throws IOException {

        final DatagramSocket socket = new DatagramSocket();
        final byte[] bytes = "Good Day".getBytes(StandardCharsets.UTF_8);
        final DatagramPacket packet = new DatagramPacket(bytes,
                bytes.length, InetAddress.getByName("255.255.255.255"), 5555);
        socket.send(packet);
        socket.close();

    }
}
