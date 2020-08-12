package com.self.serialize;

import java.io.*;

public class SerializeTest {
    private final static String filePathAndName = "/Users/hamhosik/Documents/serializeTest";

    public static void main(String[] args) throws IOException, ClassNotFoundException {
//        serializeObject();
        deserializeObject();
    }

    private static void serializeObject() throws IOException {

        User u = new User();
        u.setName("hosik ham");
        u.setAge(40);

        try(
            FileOutputStream fileOutputStream = new FileOutputStream(new File(filePathAndName));
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            ){
            System.out.println("Serialize User name " +u.getName());
            objectOutputStream.writeObject(u);
        }
    }

    private static void deserializeObject() throws IOException, ClassNotFoundException {
        try(
            FileInputStream fileInputStream = new FileInputStream(new File(filePathAndName));
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            ){
            User u = (User)objectInputStream.readObject();
            System.out.println(u);
        }
    }
}
