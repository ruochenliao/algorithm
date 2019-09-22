package dynamicProgramming;

import java.util.ArrayList;
import java.util.List;

public class TestTriangle {
    public static void main(String[] args){
        List<List<Integer>> param = new ArrayList<>();
        param.add(new ArrayList<Integer>(){{
            add(2);
        }});
        param.add(new ArrayList<Integer>(){{
            add(3);
            add(4);
        }});
        param.add(new ArrayList<Integer>(){{
            add(6);
            add(5);
            add(7);
        }});
        param.add(new ArrayList<Integer>(){{
            add(4);
            add(1);
            add(8);
            add(3);
        }});
        for(int i = 0; i < param.size(); i++){
            for(int j = 0; j < param.get(i).size(); j++){
                System.out.print(param.get(i).get(j));
            }
            System.out.println();
        }
        Triangle triangle = new Triangle();
        int result = triangle.minimumTotal(param);
        System.out.println(result);
    }
}
