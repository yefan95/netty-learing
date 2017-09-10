package cn.r2r.netty.chapter02.v1;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class TimeServer {

    public static void main(String[] args) throws IOException {

        int port = 8084;

        if (args != null && args.length > 0) {
            try {
                port = Integer.valueOf(args[0]);
            } catch (NumberFormatException e) {

            }
        }

        ServerSocket serverSocket = null;

        try {
            serverSocket = new ServerSocket(port);
            System.out.printf("The timer server is start in port:" + port);
            Socket socket = null;

            //伪异步操作
            TimeServerHandlerExecutePool executePool = new TimeServerHandlerExecutePool(50, 10000);

            while (true) {
                socket = serverSocket.accept();
                executePool.execute(new TimeServerHandler(socket));
//                new Thread(new TimeServerHandler(socket)).start();
            }
        } finally {
            if (serverSocket != null) {
                System.out.printf("The timer server close");
                serverSocket.close();
                serverSocket = null;
            }
        }
    }

}
