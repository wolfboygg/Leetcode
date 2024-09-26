package stacksequences;

import java.util.Stack;

public class StackSequences {

    public boolean validateStackSequence(int[] seq1, int[] seq2) {
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        for (int num : seq1) {
            stack.push(num);
            while (!stack.isEmpty() && stack.peek() == seq2[i]) {
                stack.pop();
                i++;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        int[] seq1 = {1, 2, 3, 4, 5};
        int[] seq2 = {4, 3, 5, 1, 2};
        System.out.println(new StackSequences().validateStackSequence(seq1, seq2));
    }
}
