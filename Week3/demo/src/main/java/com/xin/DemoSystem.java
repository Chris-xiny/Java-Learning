package com.xin;

public class DemoSystem {
    public static void main(String[] args) {
        // 返回以毫秒为单位的当前时间，可以测效率
        long time = System.currentTimeMillis();
        System.out.println(time);
        // 复制粘贴数组内容
        String[] src = { "0", "1", "2", "3", "4", "5" };
        String[] dest = new String[10];
        System.arraycopy(src, 1, dest, 2, 5);
        for (int i = 0; i < dest.length; i++) {
            System.out.println(dest[i]);
        }
        // 终止当前运行的虚拟机
        System.exit(0);

        System.out.println("虚拟机退出，我运行不出来啦");
    }
}
