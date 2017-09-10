package cn.r2r.netty.chapter02.v3;

public class TimeClient {

    public static void main(String[] args) {
        String host = "127.0.0.1";
        int port = 8084;

        if (args != null && args.length > 0) {
            try {
                port = Integer.valueOf(args[0]);
            } catch (NumberFormatException e) {

            }
        }

        new Thread(new AsyncTimeClientHandler(host, port)).start();
    }
}
