package search;


import com.sun.tools.javac.util.Pair;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * 矩阵里面有且只有一个长方形，需要找到左上角到右下角的坐标，发现第一个肯定是左上角
 */
public class FindSingleRectangleInMatrix {
    @Data
    class Point{
        Integer x;
        Integer y;
    }
    public List<Point> findSingleRectangle(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return new ArrayList<>(0);
        }
        List<Point> points = new ArrayList<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    Point secondPoint = new Point();
                    searchPoint(matrix, i, j, secondPoint);
                    if(i != secondPoint.getX() && j != secondPoint.getY()){
                        Point firstPoint = new Point();
                        firstPoint.setX(i);
                        firstPoint.setY(j);
                        points.add(firstPoint);
                        points.add(secondPoint);
                    }
                }
            }
        }
        return points;
    }

    private boolean searchPoint(int[][] matrix, int i, int j, Point point) {
        if (i >= matrix.length || j >= matrix[0].length || matrix[i][j] == 1) {
            return false;
        }

        if(matrix[i][j] == 2){
            return true;
        }

        boolean down = searchPoint(matrix, i + 1, j, point);
        boolean right = searchPoint(matrix, i, j + 1, point);
        if(!down && !right){
            point.setX(i);
            point.setY(j);
        }
        matrix[i][j] = 2;
        return true;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {1, 0, 0, 0, 1},
                {1, 0, 0, 0, 1},
                {1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1}
        };
        FindSingleRectangleInMatrix search = new FindSingleRectangleInMatrix();
        List<Point> points = search.findSingleRectangle(matrix);
        for(Point p:points){
            System.out.print(p.getX() + " " + p.getY());
            System.out.println();
        }
    }

}
