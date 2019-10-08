package dynamicProgramming;

public class TestSentenceScreenFitting {
    public static void main(String[] args){
        SentenceScreenFitting fitting = new SentenceScreenFitting();
        String[] arr = {"abc", "de", "f"};
        int rows = 3;
        int cols = 6;
        int result = fitting.wordsTyping(arr, rows, cols);
        System.out.println(result);
        int result1 = fitting.wordsTyping1(arr, rows, cols);
        System.out.println(result1);
    }
}
