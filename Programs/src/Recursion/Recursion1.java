package Recursion;

public class Recursion1 {


    //https://www.geeksforgeeks.org/program-check-array-sorted-not-iterative-recursive/
    Boolean isSorted(int []a, int size ){
        if(size == 1|| size == 0)
            return true;

         if(a[size-1]<a[size-2])
            return false;
         else
             return isSorted(a, size-1);

    }

    //Sum of array using recursion
    int sumOfArray(int []a, int size){
        if(size == 1){
            return a[0];
        }
        else {
            int sum = a[size-1] + sumOfArray(a,size-1);
            return sum  ;
        }
    }

    //Linear Search using recursion
    int linearSearch(int[] a, int size, int element){
        if(size == 0)
            return -1;
        if(a[size-1]==element)
            return size-1;
        else
            return  linearSearch(a,size-1,element);
    }

    int binarySearch(int[] a, int left, int right, int element){
        if(left>right)
            return -1;
        int mid = left + (right-left)/2;
        if(a[mid] == element)
            return mid;
        else if(a[mid]>element)
            return binarySearch(a,left,mid-1,element);
        else
            return binarySearch(a,mid+1,right,element);
    }


    public static void main(String[] args) {
        Recursion1 rc = new Recursion1();
        int []a ={2,4,5,7,1,13};
        System.out.println(rc.isSorted(a,a.length));
        System.out.println(rc.sumOfArray(a,a.length));
        System.out.println(rc.linearSearch(a, a.length, 5));
        System.out.println(rc.linearSearch(a, a.length, 3));
        System.out.println(rc.linearSearch(a, a.length, 13));
        System.out.println(rc.binarySearch(a, 0,a.length-1, 5));
        System.out.println(rc.binarySearch(a, 0,a.length-1, 3));
        System.out.println(rc.binarySearch(a, 0,a.length-1, 13));

    }
}
