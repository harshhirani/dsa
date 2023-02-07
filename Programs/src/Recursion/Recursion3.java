package Recursion;

import java.util.Arrays;

public class Recursion3 {

    void merge(int []nums, int s, int m, int e){
        int len1 = m - s + 1;
        int len2 = e - m;
        int []first = new int[len1];
        int []second = new int[len2];
        int k = s;
        for(int i= 0;i<len1;++i){
            first[i]=nums[k++];
        }
        k =m+1;
        for(int i=0;i<len2;++i){
            second[i]=nums[k++];
        }
        int a =0;
        int b =0 ;
        k =s;
        while(a<len1 && b<len2){
            if(first[a]>second[b])
                nums[k++]= second[b++];
            else
                nums[k++]= first[a++];
        }
        while(a<len1){
            nums[k++]= first[a++];
        }
        while(b<len2){
            nums[k++]= second[b++];
        }

    }
    //Applications of Merge Sort


    //Inversion Count Problem



    void mergeSort(int []nums, int s, int e){
        if(s>=e)
            return;
        int mid = (s + e)/2;
        mergeSort(nums,0,mid);
        mergeSort(nums,mid+1,e);
        merge(nums,s,mid,e);
    }
    public static void main(String[] args) {
        Recursion3 rc = new Recursion3();
        int[]arr = {12,1,3,10,5,2,7,1};
        rc.mergeSort(arr,0,arr.length -1);
        System.out.println(Arrays.toString(arr));

    }
}
