package com.Chrisxin.b_tcp;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws Exception {
//        1. 创建 `ServerSocket` 对象，设置端口号
        ServerSocket serverSocket = new ServerSocket(6666);
//        2. 调用 `ServerSocket` 中的 `accept()` 方法，等待客户端连接，返回 `Socket` 对象
        Socket socket = serverSocket.accept();
//        3. 调用 `Socket` 中的 `getInputStream()`，用于读取客户端发送过来的数据
        InputStream is = socket.getInputStream();
        byte[] bytes = new byte[1024];
        int read = is.read(bytes);
        System.out.println(new String(bytes,0,read));
//        4. 调用 `Socket` 中的 `getOutputStream()`，用于给客户端响应数据
        OutputStream os = socket.getOutputStream();
        os.write("服务端收到".getBytes());
//        5. 关闭资源
        is.close();
        os.close();
        socket.close();
    }
}
