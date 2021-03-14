package internet.UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

/**
 * @ClassName UDP
 * @Description TODO
 * @Author Ganzhenghao
 * @Date 2021/3/8 10:16
 * @Version 1.0
 */
public class UDPSend {
    public static void main(String[] args) throws IOException {
        final InetAddress address = InetAddress.getByName("192.168.19.37");
        final DatagramSocket socket = new DatagramSocket();
        Scanner sc = new Scanner(System.in);
        while (true){
            System.out.print("Ganzhenghao: ");
            String line = sc.nextLine();
            if ("exit".equals(line)){
                break;
            }
            byte[] bytes = line.getBytes(StandardCharsets.UTF_8);
            DatagramPacket packet = new DatagramPacket(bytes, bytes.length, address, 5555);
            socket.send(packet);
        }

        socket.close();
    }
}
