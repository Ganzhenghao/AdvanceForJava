package internet.UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @ClassName UDPReceive
 * @Description TODO
 * @Author Ganzhenghao
 * @Date 2021/3/8 10:21
 * @Version 1.0
 */
public class UDPReceive {
    public static void main(String[] args) throws IOException {
        //创建接收端的Socket对象(DatagramSocket)
        DatagramSocket ds = new DatagramSocket(10000);
        //创建一个数据包，用于接收数据
        byte[] bytes = new byte[1024];
        DatagramPacket dp = new DatagramPacket(bytes, bytes.length);
        while (true) {
            //调用DatagramSocket对象的方法接收数据
            ds.receive(dp);
            //解析数据包，并把数据在控制台显示
            final SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
            System.out.println( format.format(new Date())+" ：" + new String(dp.getData(), 0, dp.getLength()));
        }
    }
}
