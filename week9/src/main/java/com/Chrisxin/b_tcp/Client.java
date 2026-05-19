package com.Chrisxin.b_tcp;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.UUID;

public class Client {
    public static void main(String[] args) throws Exception {
//        1. **创建 `Socket` 对象,指定服务端的ip与端口**
        Socket socket=new Socket("127.0.0.1", 6666);
//        2. **调用 `Socket` 对象中的 `getOutputStream()` 方法获取网络输出流,往服务端发送请求**
        OutputStream os=socket.getOutputStream();
        //UUID可以生成随机数，用于接收多个文件时命名区分开，从而不会因为重名而覆盖,例如网上下载图片时名字就是这个格式
        String uuid= UUID.randomUUID().toString();
        os.write(uuid.getBytes());
//        3. **调用`Socket`对象中的 `getInputStream()` 方法获取网络输入流,读取服务端响应的数据**
        InputStream is = socket.getInputStream();
        byte[] bytes = new byte[1024];
        int len=is.read(bytes);
        System.out.println(new String(bytes,0,len));
//        4. **关流**
        is.close();
        os.close();
        socket.close();
    }
}
