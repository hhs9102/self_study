package com.self.lambda.buffered;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class BufferedTestMain {

    /*<textFileForTest.txt>
    This is test file.
    for lambda
    lambda is difficult for me.
    Someday this will be easy for me.
     */
    private static String textFile = "/Users/hamhosik/Documents/textFileForTest.txt";

    public static void main(String[] args) throws IOException {
        System.out.println(processFile());
        System.out.println(processFile((BufferedReader br) -> {
            return br.readLine()+br.readLine();
        }));
    }


    public static String processFile() throws IOException{
        try(BufferedReader br = new BufferedReader(new FileReader(textFile))){
            return br.readLine();
        }
    }

    public static String processFile(BufferedReaderProcessor brp) throws IOException {
        try(BufferedReader br = new BufferedReader(new FileReader(textFile))){
            return brp.process(br);
        }
    }

    public interface BufferedReaderProcessor{
        String process(BufferedReader br) throws IOException;
    }
}
