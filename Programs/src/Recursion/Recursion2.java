package Recursion;

import java.util.Objects;

public class Recursion2 {
    void swap(StringBuilder sb, int i , int j){
        char c = sb.charAt(i);
        sb.insert(i,sb.charAt(j));
        sb.deleteCharAt(i+1);
        sb.insert(j,c);
        sb.deleteCharAt(j+1);
    }

    String reverseString(String s, int i, int j){
        StringBuilder sb = new StringBuilder(s);
        if(i>j)
            return sb.toString();
        else{
            swap(sb,i,j);
           return reverseString(sb.toString(),++i,--j);
        }

        // we can also use single pointer i and handle other part with length-1-i
    }



    Boolean isPalindrome(String s, int i, int j){
        if(i>j)
            return true;
        if(!Objects.equals(s.charAt(i), s.charAt(j)))
            return false;
        else
           return isPalindrome(s,++i,--j);
    }


    Long power(int a, int b){
        if(b==0)
            return 1L;
        Long number = a * power(a,b-1);
        return number;
    }

    Long power1(int a, int b){
        if(b == 0)
            return 1L;
        if(b == 1)
            return (long) a;
        Long number = power(a,b/2);
        if(b%2 == 0)
            return  number*number;
        else
           return  a*number*number;
    }
    public static void main(String[] args) {

        Recursion2 rc = new Recursion2();
        String s = "harsh";
        String s1 = "cab";
        System.out.println(rc.reverseString(s,0,s.length()-1));
        System.out.println(rc.reverseString(s1,0,s1.length()-1));
        System.out.println(rc.isPalindrome(s,0,s.length()-1));
        String s2 = "habbah";
        System.out.println(rc.isPalindrome(s2,0,s2.length()-1));
        System.out.println(rc.power(2,3));
        System.out.println(rc.power1(2,3));

    }
}
