// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: person.proto

package com.demo.grpc;

public final class PersonServer {
  private PersonServer() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_com_demo_grpc_Request_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_com_demo_grpc_Request_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_com_demo_grpc_Response_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_com_demo_grpc_Response_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    String[] descriptorData = {
      "\n\014person.proto\022\rcom.demo.grpc\"4\n\007Request" +
      "\022\014\n\004name\030\001 \001(\t\022\n\n\002id\030\002 \001(\005\022\017\n\007content\030\003 " +
      "\001(\014\"\033\n\010Response\022\017\n\007message\030\001 \001(\t2J\n\rPers" +
      "onService\0229\n\006handle\022\026.com.demo.grpc.Requ" +
      "est\032\027.com.demo.grpc.ResponseB\037\n\rcom.demo" +
      ".grpcB\014PersonServerP\001b\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        });
    internal_static_com_demo_grpc_Request_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_com_demo_grpc_Request_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_com_demo_grpc_Request_descriptor,
        new String[] { "Name", "Id", "Content", });
    internal_static_com_demo_grpc_Response_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_com_demo_grpc_Response_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_com_demo_grpc_Response_descriptor,
        new String[] { "Message", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
