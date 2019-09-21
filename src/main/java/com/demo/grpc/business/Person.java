package com.demo.grpc.business;

import java.io.Serializable;

/**
 * @author time
 * @since 2019-09-21
 */
public class Person implements Serializable
{
    /**
     * name
     */
    String name;

    /**
     * age
     */
    int age;

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public int getAge()
    {
        return age;
    }

    public void setAge(int age)
    {
        this.age = age;
    }

    @Override
    public String toString()
    {
        return super.toString() + "\nname: " + this.getName() + "\tage: " + this.getAge();
    }
}
