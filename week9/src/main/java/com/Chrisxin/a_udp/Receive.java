package com.Chrisxin.a_udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Receive {
    public static void main(String[] args) throws Exception {
        //1. **创建 `DatagramSocket` 对象,指定服务端接收端口**
        DatagramSocket socket = new DatagramSocket(6666);
        //2. **接收数据包**
        byte[] bytes = new byte[1024];
        DatagramPacket dp = new DatagramPacket(bytes, bytes.length);
        socket.receive(dp);
        //3. **解析数据包**
        byte[] data =dp.getData();
        int length=dp.getLength();
        InetAddress ip=dp.getAddress();
        int port=dp.getPort();
        System.out.println(new String(data,0,length)+"..."+ip+"..."+port);
        //4. **释放资源**
        socket.close();
    }
}
