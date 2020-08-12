package com.self.serialize;

import lombok.Data;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

@Data
public class User implements Serializable {

    private static final long serialVersionUID = 4442793424424920837L;
    private String name;
    private int age;
    private int color;

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(this);
        objectOutputStream.writeInt(30);
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException,  ClassNotFoundException{
        objectInputStream.defaultReadObject();
        System.out.println("objectInputStream.readFields().get()");
        System.out.println("readObject : ");
    }
}
