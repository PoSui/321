package Package8_25;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class ServerUDP {
    public static void main(String[] args) {
        byte[] buf = new byte[1024];
        int port = 9999;

        DatagramSocket socket = null;
        DatagramPacket packet = null;

        try {
            socket = new DatagramSocket(port);
            packet = new DatagramPacket(buf,0,buf.length);

            System.out.println("服务器启动");

            socket.receive(packet);
            System.out.println("服务器收到数据"+new String(buf,0,packet.getLength()));
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(socket!=null){
                socket.close();
            }
        }
    }

}
