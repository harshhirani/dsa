package Stack;


// Implement 2 stacks using Array
public class StackQuestion1 {
    int sizeOfList = 10;
    int[] list = new int[sizeOfList];
    int top1 =-1;
    int top2 =sizeOfList;
    int size1 = 0;
    int size2 = 0;

    void pushInStack(Integer stackNumber, Integer element ){
        if(top2 -top1 == 1){
            System.out.println("Overflow condition: Element " + element + " cannot be inserted in stack " + stackNumber );
            return;
        }
        if(stackNumber == 1){
            list[++top1] = element;
        } else {
            list[--top2] = element;
        }

    }
    Integer popInStack(Integer stackNumber){
        int popedElement = -1;
        if((top1 == -1 && top2 == sizeOfList)|| (top1 == -1 && stackNumber == 1)||(top2 == sizeOfList && stackNumber == 2)) {
            System.out.println("Underflow condition: Element cannot be popped from Stack " + stackNumber);
            return popedElement ;
        }
        if(stackNumber ==1 ){
          popedElement = list[top1--];

        }else {
            popedElement = list[top2++];
        }
        return  popedElement;
    }
    Integer peekInStack(Integer stackNumber){
        int peekedElement = -1;
        if(top1 == -1 && top2 == sizeOfList){
            System.out.println("Underflow ");
            return peekedElement ;
        }
        if(stackNumber == 1){
            peekedElement = list[top1];
        }else {
            peekedElement = list[top2];
        }
        return  peekedElement;
    }
    public static void main(String[] args) {
        //Implement 2 stacks using one Array



        StackQuestion1 st = new StackQuestion1();
        st.pushInStack(1,10);
        st.pushInStack(1,20);
        st.pushInStack(2,5);
        st.pushInStack(2,10);
        st.pushInStack(1,30);
        st.pushInStack(2,15);
        st.pushInStack(2,20);
        st.pushInStack(1,40);
        st.pushInStack(1,50);
        st.pushInStack(2,25);
        st.pushInStack(2,30);
        st.pushInStack(1,60);
        st.pushInStack(2,35);
        st.pushInStack(2,40);

        System.out.println(st.peekInStack(1));
        System.out.println(st.peekInStack(2));
        System.out.println(st.popInStack(1));
        System.out.println(st.popInStack(1));
        System.out.println(st.popInStack(1));
        System.out.println(st.popInStack(1));
        System.out.println(st.popInStack(1));
        System.out.println(st.popInStack(1));
        System.out.println(st.popInStack(1));
        System.out.println(st.popInStack(1));
        System.out.println(st.popInStack(2));










    }

}
