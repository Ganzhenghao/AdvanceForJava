package internet.UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

/**
 * @ClassName UDPGroupReceive
 * @Description TODO
 * @Author Ganzhenghao
 * @Date 2021/3/8 11:35
 * @Version 1.0
 */
public class UDPGroupReceive {
    public static void main(String[] args) throws IOException {
        final MulticastSocket socket = new MulticastSocket(5555);
        socket.joinGroup(InetAddress.getByName("224.0.1.0"));
        byte[] bytes = new byte[1024];
        final DatagramPacket packet = new DatagramPacket(bytes, bytes.length);
        socket.receive(packet);
        System.out.println(new String(packet.getData(), 0, packet.getLength()));
        socket.close();
    }
}
