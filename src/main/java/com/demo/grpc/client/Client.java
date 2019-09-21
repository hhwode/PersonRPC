package com.demo.grpc.client;

import com.demo.grpc.PersonServiceGrpc;
import com.demo.grpc.Request;
import com.demo.grpc.Response;
import com.demo.grpc.business.Person;
import com.demo.grpc.util.SerializeUtil;
import com.google.protobuf.ByteString;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;

import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 可以从grpc github查到 https://github.com/grpc/grpc-java/blob/v1.23.0/examples
 * @author time
 * @since 2019-09-21
 */
public class Client
{
    /**
     * 日志
     */
    private static final Logger logger = Logger.getLogger(Client.class.getName());

    /**
     * 传输通道
     */
    private final ManagedChannel channel;

    /**
     * 客户端存根，使得调用服务接口跟在本地调用一致
     */
    private final PersonServiceGrpc.PersonServiceBlockingStub blockingStub;

    /**
     *  Construct client connecting to server at {@code host:port}.
     * @param host ip
     * @param port 端口
     */
    public Client(String host, int port) {
        this(ManagedChannelBuilder.forAddress(host, port)
                // Channels are secure by default (via SSL/TLS). For the example we disable TLS to avoid
                // needing certificates.
                .usePlaintext()
                .build());
    }

    /**
     * Construct client for accessing server using the existing channel.
     * @param channel 通道
     */
    private Client(ManagedChannel channel) {
        this.channel = channel;
        blockingStub = PersonServiceGrpc.newBlockingStub(channel);
    }

    /**
     * 关闭通道
     * @throws InterruptedException 异常
     */
    public void shutdown() throws InterruptedException {
        channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
    }

    /**
     * 客户端进行一些业务处理
     * @param person Person对象
     * @param name 名称标识
     * @param id id标识
     */
    public void doSomething(Person person, String name, int id) {
        logger.info("Will try to greet " + name + " ...");
        // 对Person对象进行序列化
        ByteString byteString = SerializeUtil.serialize(person);
        // 构造请求消息结构体
        Request request = Request.newBuilder()
                .setName(name)
                .setId(id)
                .setContent(byteString)
                .build();
        Response response;
        try {
            // 通过存根进行调用服务端的方法，也即服务接口
            response = blockingStub.handle(request);
        } catch (StatusRuntimeException e) {
            logger.log(Level.WARNING, "RPC failed: {0}", e.getStatus());
            return;
        }
        logger.info("Greeting: " + response.getMessage());
    }

    public static void main(String[] args) throws Exception {
        // host 可设置为远程IP
        Client client = new Client("localhost", 50051);
        try {
            // 客户端逻辑实现
            Person person = new Person();
            person.setName("time");
            person.setAge(23);
            client.doSomething(person, "client", 1);

            Person person1 = new Person();
            person1.setName("time1");
            person1.setAge(15);
            client.doSomething(person1, "client1", 2);
        } finally {
            client.shutdown();
        }
    }
}
