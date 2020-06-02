package search;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

public class FindMultipleRectangleInMatrix {
    @Data
    class Point{
        Integer x;
        Integer y;
    }
    public List<List<Point>> findMultipleRectangle(int[][] matrix) {
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
                {1, 1, 0, 0, 1},
                {1, 1, 0, 0, 1},
                {1, 1, 1, 1, 1}
        };
        FindMultipleRectangleInMatrix search = new FindMultipleRectangleInMatrix();
        List<List<Point>> lists = search.findMultipleRectangle(matrix);
        for(List<Point> list:lists){
            for(Point p:list){
                System.out.print(p.getX() + " "+ p.getY() + " #### ");
            }
            System.out.println();
        }
    }
}
