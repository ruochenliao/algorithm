package math;

public class Count2LastPerson {
    public static void main(String[] args) {
        int lastPerson = count2LastPerson(3);
        System.out.println(lastPerson);
    }


    private static final int total = 3;

    public static int count2LastPerson(int n) {
        int res = 0;
        for (int i = 2; i <= n; ++i) {
            res = (res + total) % i;
        }
        return res + 1;
    }
}
