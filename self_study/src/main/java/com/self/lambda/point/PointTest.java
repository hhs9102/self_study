package com.self.lambda.point;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;


public class PointTest {

    @Test
    public void teveMoveAllPointRightBy(){
        List<Point> points = Arrays.asList(new Point(1,5), new Point(2,10));
        List<Point> expectedPoints = Arrays.asList(new Point(11,5), new Point(12,10));

        Assert.assertEquals(expectedPoints, Point.moveAllPointRightBy(points,10));
    }

}