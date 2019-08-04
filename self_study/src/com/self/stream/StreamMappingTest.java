package com.self.stream;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamMappingTest {

    @Test
    public void testFilterMap(){
        List<String> listStr = Arrays.asList("Kynex", "MacPro", "ForMan", "Fan", "Sql", "Oracle", "Radiance", "Airport");
        List<String> filteredStr = listStr.stream()
                .map(String::toUpperCase)
                .filter(str -> str.contains("O"))
                .sorted()
                .collect(Collectors.toList());

        System.out.println(filteredStr);
        Assert.assertEquals("AIRPORT", filteredStr.get(0));
    }
}
