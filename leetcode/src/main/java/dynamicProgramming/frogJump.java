package dynamicProgramming;

/**
 * 青蛙一次可以跳上1级台阶，也可以跳上2级台阶.求该青蛙跳上N级的台阶总共有多少种跳法。
 * <p>
 * f(n - 1) + 1
 * f(n) = f(n-2) + 2
 * f(n) = f(n-1) + f(n-2)
 */
public class frogJump {

    public static void main(String[] args) {
        Integer[] arr = new Integer[10];
        int result = getNmethod(10, arr);
        System.out.println(result);
    }

    private static int getNmethod(int n, Integer[] arr) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }

        if(arr[n] != null){
            return arr[n];
        }

        arr[n] = getNmethod(n - 1, arr) + getNmethod(n - 2, arr);
        return arr[n];
    }
}
