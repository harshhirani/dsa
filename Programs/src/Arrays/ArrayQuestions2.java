package Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayQuestions2 {

    //- Merge 2 sorted arrays:https://leetcode.com/problems/merge-sorted-array/

    void addShift(int[]nums, int element, int position, int size){
        for(int i=size-1;i>position;--i){
            nums[i] = nums[i-1];
        }
        nums[position] = element;
    }
    int[] mergeSorted(int []first, int[]second){
        int size1 = first.length;
        int size2 =second.length;
        int i=0,j=0;
        while(j<size2){
            if(first[i]>=second[j] || first[i] == 0)
                addShift(first,second[j++],i++,size1);
             else
                i++;
        }
        return first;
    }
    //Approach 2
    int[] mergeSorted1(int[]first, int[] second){
        int size1 = first.length;
        int size2 = second.length;
        int i = size1 - size2 -1;
        int j = size2 -1;
        int k  = size1 -1;
        while(i>=0 && j>=0){
            if(second[j]>first[i])
                first[k--] = second[j--];
            else
                first[k--] = first[i--];
        }
        while(j>0){
            first[k--] = second[j--];
        }
        return first;

    }


    //- Move zeroes to end:https://leetcode.com/problems/move-zeroes/

    int[] moveZeros(int []nums){
        int nonZeroElementPointer = 0;
        for(int i =0;i<nums.length;++i){
            if (nums[i] != 0) {
                nums[nonZeroElementPointer++]=nums[i];
            }}
            //after this stage all non zero elements are placed on left and it might have oveeriden 0
            //now we just need to append remaining zeros
            for(int j =nonZeroElementPointer;j<nums.length;++j){
                nums[j]= 0;

            }
            return nums;
    }

    // https://leetcode.com/problems/rotate-array/
    int[] rotateArray(int []nums, int size, int k){
        int []temp = new int[size] ;
        for(int i=0;i<size;++i){
            temp[(i+k)%size] = nums[i];
        }
       return temp;
    }

    //https://leetcode.com/problems/check-if-array-is-sorted-and-rotated/

    Boolean checkSortedRotated(int []nums){
        int size = nums.length;
        int counter = 0;
        for(int i =0;i<size;++i){
            if(nums[(i+1)%size]<nums[i]){
                ++counter;
            }
        }
        return counter<=1;
    }

    int [] sum(int[]nums1,int size1, int[] nums2, int size2){
        int carry = 0;
        int size = Math.max(size2, size1);
        int nums[] = new int[size+1];
        int i = size1 -1 ;
        int j = size2 -1 ;
        int k = size;
        while(i>=0 && j>=0){
           int a =  nums1[i--] + nums2[j--] + carry;
           nums[k--]= a%10;
           carry = a/10;
        }
        while(i>=0){
            int a = nums1[i--]+carry;
            nums[k--]= a%10;
            carry = a/10;
        }
        while(j>=0){
            int a = nums2[j--]+carry;
            nums[k--]= a%10;
            carry = a/10;
        }
        while(carry>0){
            int a = carry;
            nums[k--]= a%10;
            carry = a/10;
        }


        return nums;

    }

    public static void main(String[] args) {
        ArrayQuestions2 aq = new ArrayQuestions2();
        int []numbers1 = {1,2,3,0,0,0};
        int []numbers2 = {2,5,6};
        System.out.println(Arrays.toString(aq.mergeSorted(numbers1,numbers2)));
        int []numbers4 = {1,2,3,0,0,0};
        int []numbers5 = {2,5,6};
        System.out.println(Arrays.toString(aq.mergeSorted1(numbers4,numbers5)));

        int[]numbers3 = {1,2,3,4,5,6,7};

        System.out.println("Rotate array " + Arrays.toString(aq.rotateArray(numbers3,numbers3.length,2)));
        int []numbers6 ={-1,2,0,0,1,2,56,23,0,1,3};
        System.out.println(Arrays.toString(aq.moveZeros(numbers6)));

        int []numbers7 = {3,4,5,1,2};
        System.out.println(aq.checkSortedRotated(numbers7));

        int[]numbers8 = {1,2,3};
        int[]numbers9 = { 4,5,6,7};
        System.out.println(Arrays.toString(aq.sum(numbers8,numbers8.length,numbers9,numbers9.length)));
    }


}
