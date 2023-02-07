package Stack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class StackQuestion6 {

    List<Integer> nextGreaterElement(List list){
        List<Integer> answer = new ArrayList<>();

        for(int i =list.size() -1; i>0;--i){
            int value = Integer.parseInt(list.get(i).toString());
            while (!stack.isEmpty() && stack.peek()<value){
                stack.pop();
            }
            if(stack.isEmpty()){
                answer.add(-1);
            }
            else {
                answer.add(stack.peek());
            }
            stack.push(value);
        }
        return answer;

    }

    List<Integer> nextSmallerElement(List list){
        List<Integer> answer = new ArrayList<>();
       stack.clear();
        for(int i = list.size()-1; i>=0;--i){
            int value = Integer.parseInt(list.get(i).toString());
            while (!stack.isEmpty() && stack.peek()>value){
                stack.pop();
            }
            if(stack.isEmpty()){
                answer.add(-1);
            }
            else {
                answer.add(stack.peek());
            }
            stack.push(value);
        }
        Collections.reverse(answer);
        return answer;

    }
    Stack<Integer>stack = new Stack<>();
    public static void main(String[] args) {
        List<Integer> l = new ArrayList<>();
        l.add(2);
        l.add(1);
        l.add(4);
        l.add(3);
        StackQuestion6 sq = new StackQuestion6();
        List<Integer> nextLargerIntegerList = sq.nextGreaterElement(l);
        List<Integer> nextSmallerIntegerList = sq.nextSmallerElement(l);
        System.out.println("Next Larger Integer List" + nextLargerIntegerList);
        System.out.println("Next Smaller Integer List" + nextSmallerIntegerList);

    }
}
