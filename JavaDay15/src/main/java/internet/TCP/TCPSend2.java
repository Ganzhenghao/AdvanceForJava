package internet.TCP;

import java.io.*;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

/**
 * @ClassName TCPClient
 * @Description TODO
 * @Author Ganzhenghao
 * @Date 2021/3/8 14:54
 * @Version 1.0
 */
public class TCPSend2 {
    public static void main(String[] args) {

        final Scanner sc = new Scanner(System.in);
        String username = "Ganzhenghao";
        try {
            while (true){
                Socket socket = new Socket("127.0.0.1", 5555);
                final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream(), StandardCharsets.UTF_8));
                final BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream(), StandardCharsets.UTF_8));

                System.out.print(username+":");
                String line = sc.nextLine();
                if ("exit".equals(line)){break;}
                line = username + ":" + line;

                writer.write(line);
                writer.flush();
                socket.shutdownOutput();

                while ((line = reader.readLine()) != null) {
                    System.out.println(line);
                }

                writer.close();
                reader.close();
                socket.close();

            }



        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
