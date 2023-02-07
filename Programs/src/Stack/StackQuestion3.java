package Stack;

import java.util.Stack;


// Delete Middle element from Stack
public class StackQuestion3 {

    Stack<Integer> stackOfElements = new Stack<>();

    void deleteMiddleElement(int counter, int size){
        if( counter == size/2){
            stackOfElements.pop();
            return;
        }
        int element = stackOfElements.pop();
        deleteMiddleElement(++counter,size);
        stackOfElements.push(element);

    }
    public static void main(String[] args) {
       StackQuestion3 st = new StackQuestion3();
        st.stackOfElements.push(10);
        st.stackOfElements.push(20);
        st.stackOfElements.push(30);
        st.stackOfElements.push(40);
        st.stackOfElements.push(50);
        st.stackOfElements.push(60);
        st.stackOfElements.push(70);
        System.out.println("stack before delete " + st.stackOfElements);
        st.deleteMiddleElement(0,st.stackOfElements.size());
        System.out.println("stack after delete " + st.stackOfElements);



    }
}
