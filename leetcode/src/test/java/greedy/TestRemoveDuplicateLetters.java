package greedy;

import greedy.RemoveDuplicateLetters;

public class TestRemoveDuplicateLetters {
    public static void main(String[] args){
        RemoveDuplicateLetters removeDuplicateLetters = new RemoveDuplicateLetters();
        String result = removeDuplicateLetters.removeDuplicateLetters("acbabc");
        String result2 = removeDuplicateLetters.removeDuplicateLetters2("acbabc");
        removeDuplicateLetters.removeDuplicateLetters3("acbabc");
        System.out.println(result + "\n"+result2 + "\n");
    }
}
