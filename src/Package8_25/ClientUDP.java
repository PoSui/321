package Package8_25;

import java.io.IOException;
import java.net.*;

public class ClientUDP {

    public static void main(String[] args) {
        int port = 9999;
        String ip = "127.0.0.1";

        DatagramSocket socket = null;
        DatagramPacket packet = null;
        try {
            byte[] buf = "hello world 中国".getBytes();
            socket = new DatagramSocket();
            packet = new DatagramPacket(buf,0,buf.length, InetAddress.getByName(ip),port);
            socket.send(packet);
            System.out.println("发送完毕");

        } catch (SocketException e) {
            e.printStackTrace();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
