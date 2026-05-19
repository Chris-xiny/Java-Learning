package com.Chrisxin.a_udp;

import java.net.*;

public class Send {
    public static void main(String[] args) throws Exception {
        /*创建 DatagramSocket 对象（快递公司）
        a. 空参：端口号从可用的端口号中随机一个使用
        b. 有参：自己指定端口号*/
        DatagramSocket socket = new DatagramSocket();
        /*创建 DatagramPacket 对象，将数据进行打包
        a. 要发送的数据 → byte[]
        b. 指定接收端的 IP 地址
        c. 指定接收端的端口号*/
        byte[] bytes = "你好啊".getBytes();
        InetAddress ip = InetAddress.getByName("127.0.0.1");
        int port=6666;
        DatagramPacket dp=new DatagramPacket(bytes,bytes.length,ip,port);
        //发送数据
        socket.send(dp);
        //关闭资源
        socket.close();
    }
}
