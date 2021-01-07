package com.jfp.datamiddle.test.iotest;

import java.io.*;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class IOTest {

    public static void main(String[] args) throws IOException {
        File file = new File("D:\\tmp\\aaa.txt");
        FileInputStream fileInputStream = new FileInputStream(file);
        FileChannel channel = fileInputStream.getChannel();
        ByteBuffer buf = ByteBuffer.allocate(1024);
        int bytesRead = channel.read(buf);
        System.out.println(bytesRead);
        System.out.println(buf.position());
        while(bytesRead != -1)
        {
            //回绕缓冲区（输出通道会从数据的开头而不是末尾开始）
            buf.flip();
            while(buf.hasRemaining())
            {
                System.out.println((char)buf.get());
            }
            /**
             * 压缩此缓冲区，compact方法会执行两个动作
             * 1.清除之前写好的字符
             * 2.通过标记位置为0
             * 这就为什么要结合filp()使用
             */
            buf.flip();
            //写入数据到Buffer
            bytesRead = channel.read(buf);
        }

    }
}
