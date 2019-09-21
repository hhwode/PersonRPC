package com.demo.grpc;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 * <pre>
 * 定义服务接口
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.23.0)",
    comments = "Source: person.proto")
public final class PersonServiceGrpc {

  private PersonServiceGrpc() {}

  public static final String SERVICE_NAME = "com.demo.grpc.PersonService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.demo.grpc.Request,
      com.demo.grpc.Response> getHandleMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "handle",
      requestType = com.demo.grpc.Request.class,
      responseType = com.demo.grpc.Response.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.demo.grpc.Request,
      com.demo.grpc.Response> getHandleMethod() {
    io.grpc.MethodDescriptor<com.demo.grpc.Request, com.demo.grpc.Response> getHandleMethod;
    if ((getHandleMethod = PersonServiceGrpc.getHandleMethod) == null) {
      synchronized (PersonServiceGrpc.class) {
        if ((getHandleMethod = PersonServiceGrpc.getHandleMethod) == null) {
          PersonServiceGrpc.getHandleMethod = getHandleMethod =
              io.grpc.MethodDescriptor.<com.demo.grpc.Request, com.demo.grpc.Response>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "handle"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.demo.grpc.Request.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.demo.grpc.Response.getDefaultInstance()))
              .setSchemaDescriptor(new PersonServiceMethodDescriptorSupplier("handle"))
              .build();
        }
      }
    }
    return getHandleMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static PersonServiceStub newStub(io.grpc.Channel channel) {
    return new PersonServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static PersonServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new PersonServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static PersonServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new PersonServiceFutureStub(channel);
  }

  /**
   * <pre>
   * 定义服务接口
   * </pre>
   */
  public static abstract class PersonServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void handle(com.demo.grpc.Request request,
        io.grpc.stub.StreamObserver<com.demo.grpc.Response> responseObserver) {
      asyncUnimplementedUnaryCall(getHandleMethod(), responseObserver);
    }

    @Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getHandleMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.demo.grpc.Request,
                com.demo.grpc.Response>(
                  this, METHODID_HANDLE)))
          .build();
    }
  }

  /**
   * <pre>
   * 定义服务接口
   * </pre>
   */
  public static final class PersonServiceStub extends io.grpc.stub.AbstractStub<PersonServiceStub> {
    private PersonServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private PersonServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @Override
    protected PersonServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new PersonServiceStub(channel, callOptions);
    }

    /**
     */
    public void handle(com.demo.grpc.Request request,
        io.grpc.stub.StreamObserver<com.demo.grpc.Response> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getHandleMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   * 定义服务接口
   * </pre>
   */
  public static final class PersonServiceBlockingStub extends io.grpc.stub.AbstractStub<PersonServiceBlockingStub> {
    private PersonServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private PersonServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @Override
    protected PersonServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new PersonServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.demo.grpc.Response handle(com.demo.grpc.Request request) {
      return blockingUnaryCall(
          getChannel(), getHandleMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * 定义服务接口
   * </pre>
   */
  public static final class PersonServiceFutureStub extends io.grpc.stub.AbstractStub<PersonServiceFutureStub> {
    private PersonServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private PersonServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @Override
    protected PersonServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new PersonServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.demo.grpc.Response> handle(
        com.demo.grpc.Request request) {
      return futureUnaryCall(
          getChannel().newCall(getHandleMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_HANDLE = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final PersonServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(PersonServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @Override
    @SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_HANDLE:
          serviceImpl.handle((com.demo.grpc.Request) request,
              (io.grpc.stub.StreamObserver<com.demo.grpc.Response>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @Override
    @SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class PersonServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    PersonServiceBaseDescriptorSupplier() {}

    @Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return PersonServer.getDescriptor();
    }

    @Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("PersonService");
    }
  }

  private static final class PersonServiceFileDescriptorSupplier
      extends PersonServiceBaseDescriptorSupplier {
    PersonServiceFileDescriptorSupplier() {}
  }

  private static final class PersonServiceMethodDescriptorSupplier
      extends PersonServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    PersonServiceMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (PersonServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new PersonServiceFileDescriptorSupplier())
              .addMethod(getHandleMethod())
              .build();
        }
      }
    }
    return result;
  }
}
