package internet;

import org.junit.Test;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @ClassName InetAddressStudy
 * @Description TODO
 * @Author Ganzhenghao
 * @Date 2021/3/8 9:45
 * @Version 1.0
 */
public class InternetPrograming {

    @Test
    public void one() throws UnknownHostException {
        final InetAddress name = InetAddress.getByName("127.0.0.1");
        System.out.println(name);
    }



}
