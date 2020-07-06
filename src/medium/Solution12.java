package medium;

import java.util.ArrayList;
import java.util.List;

public class Solution12 {
    public static void main(String[] args) {
        MinStack stack = new MinStack();
        stack.push(1);
        System.out.println(stack.pop());
        stack.push(2);
        stack.push(3);
        System.out.println(stack.min());
    }

}
class MinStack {
    List<Integer> stack;
    List<Integer> min;

    public MinStack() {
        stack = new ArrayList<>();
        min = new ArrayList<>();
    }

    /*
     * @param number: An integer
     * @return: nothing
     */
    public void push(int number) {
        stack.add(number);

        if(min.size() == 0 || min.get(min.size()-1) > number){
            min.add(number);
        }else {
            min.add(min.get(min.size()-1));
        }
    }

    /*
     * @return: An integer
     */
    public int pop() {
        int x = stack.get(stack.size()-1);
        stack.remove(stack.size()-1);
        min.remove(min.size()-1);
        return x;
    }

    /*
     * @return: An integer
     */
    public int min() {
        return min.get(min.size()-1);
    }
}