package com.demo.grpc.server;

import com.demo.grpc.impl.PersonServiceImpl;
import io.grpc.ServerBuilder;

import java.io.IOException;
import java.util.logging.Logger;

/**
 * 可以从grpc github查到 https://github.com/grpc/grpc-java/blob/v1.23.0/examples
 * @author time
 * @since 2019-09-21
 */
public class Server
{
    /**
     * 日志
     */
    private static final Logger logger = Logger.getLogger(Server.class.getName());

    /**
     * gRPC服务端
     */
    private io.grpc.Server server;

    /**
     * 启动服务
     * @throws IOException 异常
     */
    private void start() throws IOException
    {
        /* The port on which the server should run */
        int port = 50051;
        server = ServerBuilder.forPort(port)
                .addService(new PersonServiceImpl())
                .build()
                .start();
        logger.info("Server started, listening on " + port);
        Runtime.getRuntime().addShutdownHook(new Thread() {
            @Override
            public void run() {
                // Use stderr here since the logger may have been reset by its JVM shutdown hook.
                System.err.println("*** shutting down gRPC server since JVM is shutting down");
                Server.this.stop();
                System.err.println("*** server shut down");
            }
        });
    }

    /**
     * 关闭服务
     */
    private void stop() {
        if (server != null) {
            server.shutdown();
        }
    }

    /**
     * Await termination on the main thread since the grpc library uses daemon threads.
     * @throws InterruptedException 异常
     */
    private void blockUntilShutdown() throws InterruptedException {
        if (server != null) {
            server.awaitTermination();
        }
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        // 主函数，未详细处理异常
        final Server server = new Server();
        server.start();
        server.blockUntilShutdown();
    }
}
