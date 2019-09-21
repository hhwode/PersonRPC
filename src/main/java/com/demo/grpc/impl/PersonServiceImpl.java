package com.demo.grpc.impl;

import com.demo.grpc.PersonServiceGrpc;
import com.demo.grpc.Request;
import com.demo.grpc.Response;
import com.demo.grpc.business.Person;
import com.demo.grpc.util.SerializeUtil;
import com.google.protobuf.ByteString;
import io.grpc.stub.StreamObserver;

/**
 * 具体业务实现
 * @author time
 * @since 2019-09-21
 */
public class PersonServiceImpl extends PersonServiceGrpc.PersonServiceImplBase
{
    /**
     * 重写proto定义的服务接口
     * @param request 请求消息
     * @param responseObserver 响应消息
     */
    @Override
    public void handle(Request request, StreamObserver<Response> responseObserver)
    {
        try
        {
            // 处理请求
            ByteString content = request.getContent();
            Person person = (Person) SerializeUtil.deserialize(content.toByteArray());
            System.out.println(person);

            // 依据person的age来进行同的处理
            String result;
            if (person.getAge() < 18)
            {
                result = "young man";
            }else
            {
                result = "adult man";
            }

            // 构造返回值，可以处理教复杂的操作后返回，这里只是根据
            Response reply = Response.newBuilder()
                    .setMessage("Hello " + request.getName() + ", you are a " + result)
                    .build();

            responseObserver.onNext(reply);
            responseObserver.onCompleted();
        } catch (NullPointerException e)
        {
            System.out.println(e.getMessage());
        }

    }
}
