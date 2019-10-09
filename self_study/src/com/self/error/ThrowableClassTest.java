package com.self.error;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ThrowableClassTest {

    //비검사 예외 -> Throwable 호출하는 쪽에서 처리를 하도록 에러를 위임한다.
    public String throwableMethod() throws IOException {
        File file = new File("test.txt");
        FileInputStream fis = new FileInputStream(file);

        int i = fis.read();
        return "";
    }
}
