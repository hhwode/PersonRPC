package com.demo.grpc.util;

import com.demo.grpc.business.Person;
import com.google.protobuf.ByteString;

import java.io.*;

/**
 * 序列化工具
 * @author time
 * @since 2019-09-21
 */
public class SerializeUtil
{
    /**
     * 私有构造方法
     */
    private SerializeUtil()
    {

    }

    /**
     * 将对象进行序列化，直接一步到位，转成protobuf支持的ByteString
     * @param object 待序列化对象
     * @return 序列化成的ByteString
     */
    public static ByteString serialize(Object object) {
        ObjectOutputStream oos = null;
        ByteArrayOutputStream bos = null;
        try {
            bos = new ByteArrayOutputStream();
            oos = new ObjectOutputStream(bos);
            oos.writeObject(object);
            byte[] b = bos.toByteArray();
            return ByteString.copyFrom(b);
        } catch (IOException e) {
            System.out.println("序列化失败 Exception:" + e.toString());
            return null;
        } finally {
            try {
                if (oos != null) {
                    oos.close();
                }
                if (bos != null) {
                    bos.close();
                }
            } catch (IOException ex) {
                System.out.println("io could not close:" + ex.toString());
            }
        }
    }

    /**
     * 反序列化为Object
     * @param bytes 字节数组
     * @return Object
     */
    public static Object deserialize(byte[] bytes) {
        ByteArrayInputStream bais = null;
        try {
            // 反序列化
            bais = new ByteArrayInputStream(bytes);
            ObjectInputStream ois = new ObjectInputStream(bais);
            return ois.readObject();
        } catch (IOException e) {
            System.out.println("bytes Could not deserialize:" + e.toString());
            return null;
        } catch (ClassNotFoundException e)
        {
            System.out.println("bytes Could not deserialize:" + e.toString());
            return null;
        } finally {
            try {
                if (bais != null) {
                    bais.close();
                }
            } catch (IOException ex) {
                System.out.println("LogManage Could not serialize:" + ex.toString());
            }
        }
    }

    public static void main(String[] args)
    {
        Person person = new Person();
        person.setAge(12);
        person.setName("ds");

        ByteString bs = SerializeUtil.serialize(person);
        System.out.println(bs);

        Person person1 = (Person) SerializeUtil.deserialize(bs.toByteArray());
        System.out.println(person1.toString());
    }
}
