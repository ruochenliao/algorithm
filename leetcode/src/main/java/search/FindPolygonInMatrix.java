package search;

import lombok.Data;

import java.util.*;

/**
 * 还是这个矩阵，有可能有多个长方形，需要给出每个长方形的左上角右下角坐标。
 * 这个就需要在每次找右下角坐标的时候，要把走过的所有0标记成1，避免重复count
 */
public class FindPolygonInMatrix {
    @Data
    class Point{
        Integer x;
        Integer y;
    }
    public List<List<Point>> findPolygon(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return new ArrayList<>(0);
        }
        List<List<Point>> lists = new ArrayList<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    Point secondPoint = new Point();
                    searchPoint(matrix, i, j, secondPoint);
                    List<Point> list = new ArrayList<>();
                    if(i != secondPoint.getX() && j != secondPoint.getY()){
                        Point firstPoint = new Point();
                        firstPoint.setX(i);
                        firstPoint.setY(j);
                        list.add(firstPoint);
                        list.add(secondPoint);
                        lists.add(list);
                    }

                }
            }
        }
        return lists;
    }

    private boolean searchPoint(int[][] matrix, int i, int j, Point point) {
        if (i >= matrix.length || j >= matrix[0].length || matrix[i][j] == 1) {
            return false;
        }

        if(matrix[i][j] == 2){
            return true;
        }
        boolean up = searchPoint(matrix, i - 1, j, point);
        boolean down = searchPoint(matrix, i + 1, j, point);
        boolean left = searchPoint(matrix, i, j - 1, point);
        boolean right = searchPoint(matrix, i, j + 1, point);
        if(!down && !right){
            point.setX(i);
            point.setY(j);
        }
        matrix[i][j] = 2;
        return true;
    }
}
