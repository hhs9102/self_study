package com.self.lambda.point;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@AllArgsConstructor
@Getter
public class Point {
    int x;
    int y;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Point)) return false;
        Point point = (Point) o;
        return x == point.x &&
                y == point.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    public static List<Point> moveAllPointRightBy(List<Point> points, int x){
        return points.stream()
                .map(point -> new Point(point.getX() + x, point.getY()))
                .collect(Collectors.toList());
    }


}