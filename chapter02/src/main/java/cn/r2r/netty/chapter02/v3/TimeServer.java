package cn.r2r.netty.chapter02.v3;

public class TimeServer {

    public static void main(String[] args) {
        int port = 8084;

        if (args != null && args.length > 0) {
            try {
                port = Integer.valueOf(args[0]);
            } catch (NumberFormatException e) {

            }
        }

        new Thread(new AsyncTimeServerHandler(port), "AIO-AsyncTimeServerHandler-001").start();
    }
}
