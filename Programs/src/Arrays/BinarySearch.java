package Arrays;


import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.Callable;

public class BinarySearch {

    // First/Last Occurrence of an Element in array: https://bit.ly/3Ioexjh
    int firstOccurrence(int []num, int size, int k){
        int left = 0;
        int right = size -1;
        int mid = 0;
        int ans = -1;
        while(left<=right){
            mid = (left + right)/2;
            if(num[mid]>k){
               right = mid -1;
            }
            else if(num[mid]<k){
                left = mid+1;
            } else {
                ans = mid;
                right = mid -1;
            }
        }
        return ans;

    }

    int lastOccurrence(int []num, int size, int k){
        int left = 0;
        int right = size -1;
        int mid = 0;
        int ans = -1;
        while(left<=right){
            mid = (left + right)/2;
            if(num[mid]>k){
                right = mid -1;
            }
            else if(num[mid]<k){
                left = mid+1;
            } else {
                ans = mid;
               left = mid +1;
            }
        }
        return ans;

    }

    //Total number of occurrence
    int totalOccurrence(int[] num,int size, int k){
        int first = firstOccurrence(num, size, k);
        int last = lastOccurrence(num, size, k);
        return last - first +1;
    }

    // Peak in a Mountain Array: https://leetcode.com/problems/peak-index-in-a-mountain-array/
    // Important
    int peakIndex(int[] num, int size){
        int left = 0;
        int right = size - 1;
        int mid ;
        while(left<=right){
            mid = (left + right)/2;
            if(num[mid]>num[mid+1] && num[mid]>num[mid-1]) {
                return mid;
            } else if(num[mid]>num[mid+1]) {
                right = mid + 1;
            }else if(num[mid]<num[mid+1]){
                left = mid +1;
            }
        }
        return -1 ;
    }

    //approach 2
    int peakIndex1(int[] num, int size){
        int left = 0;
        int right = size - 1;
        int mid ;
        //note we are running it till left<right as for left=right we have already calculated
        while(left<right){
            mid = (left + right)/2;
             if(num[mid]<num[mid+1]) {
                 // note we are updating it as mid not mid-1 because in this case mid can also be peak element
                 left = mid +1;
             }
            else
               right = mid;
            }
        return left ;
    }


    int pivotIndex(int []num, int size){
        int ans = -1;
        int left = 0;
        int right = size -1;
        int lsum = 0;
        int rsum = 0;
       for(int i =0;i<num.length - 1; ++i){
            if(lsum == rsum && right-left ==2){
                ans = i;
                break;
            }else if(lsum<rsum) {
                lsum+=num[left++];
            }else{
                rsum+=num[right--];
            }
        }

        return ans;
    }


    int findPivot(int []nums, int size){
        int left = 0;
        int right = size -1;
        int mid =0;
        while (left<right){
            mid = left + (right -left)/2;
            if(nums[mid]>=nums[0])
                left = mid + 1;
            else
                right = mid;
        }
        return right;
    }


    //  - Search in a rotated & Sorted array:  https://bit.ly/3rEVSK7
    int searchInRotatedArray(int [] nums, int size, int k){
        int pivot = findPivot(nums, size);
        int index = 0;
        if(k>=nums[pivot] && k<=nums[size -1]){
            index = Arrays.binarySearch(nums, pivot, size - 1, k);
        }
        else {
            index = Arrays.binarySearch(nums,0,pivot,k);
        }
        return index;
    }

    //  - Square Root of an Integer: https://bit.ly/3Dm4hEE
    // Important
    Long SquareRoot(int  number){
        int left = 0;
        int right = number -1;
        int mid =0;
        Long ans =0L;
        while (left<=right){
            mid = (left + right)/2;
            Long sq = (long) (mid * mid);
            if(sq == number){
                ans = (long) mid;
                break;
            }
            if(sq>number){
                right = mid -1 ;
            }else {
                ans =(long) mid;
                left = mid +1;
            }
        }
        return ans;
    }

    double squareRootPrecision(int num, int precision , Long tempNum){
     double ans = (double) tempNum;
        double factor = 1;
        for(int  i = 0;i<precision;++i){
            factor = factor/10;
            for(double j=ans; j*j<num;j=j+factor){
                 ans =j;
            }
        }
        return ans;
    }


    //- Book Allocation Problem: https://bit.ly/3GiCqY0
    // very important

    Boolean isPossibleAllocation(int []nums, int k, int totalStudents){
        int booksForOneStudent = 0;
        int numberOfStudents =1;
        for(int i=0;i<nums.length;++i){
            //Important condition when book to allocate is greater than mid that is greater than what max one person is able to hold
            if(nums[i]>k){
                return false;
            }
            booksForOneStudent +=nums[i];
            if(booksForOneStudent>k){
                ++numberOfStudents;
                booksForOneStudent = nums[i];
            }
        }
        return (totalStudents == numberOfStudents);
    }

    int bookAllocation(int []numbers, int size, int totalStudents){
        int left = 0;
        int right = 0;
        int mid = 0;
        int ans =0;
        for(int i =0;i<size;++i ){
           right+=numbers[i];
        }
        while(left<=right){
            mid = left + (right -left)/2;
            if(isPossibleAllocation(numbers, mid, totalStudents)){
                ans = mid;
                right = mid -1;
            }else {
               left = mid +1;

            }
        }
        return ans;
    }
    //- Aggressive Cows: https://bit.ly/3dkuQ2B
    // V Important

    private Boolean isPossibleToPlaceCows(Integer[] nums, int mid, int k) {
        int noOfCows = 1;
        int positionOfLastCow = nums[0];
        for(int x : nums){
            if(x -positionOfLastCow>=mid){
                ++noOfCows;
                positionOfLastCow = x;
            }
        }
        return (noOfCows>=k);
    }


    int maxDistanceForCows(Integer []nums, int k){
        int left = 0;
        int right = Collections.max(Arrays.asList(nums));
        int mid = 0;
        int ans = 0;

        Arrays.sort(nums);

        while(left<=right){
            mid = left + (right - left)/2;
            if(isPossibleToPlaceCows(nums,mid,k)){
                ans = mid;
                left = mid + 1;
            }
            else
                right = mid -1;
        }
        return ans;
    }

    //- Painter’s Partition Problem: https://bit.ly/31v3Jiy
    //- EKO SPOJ: https://www.spoj.com/problems/EKO/


    private boolean isPossibleToCut(Integer[] nums, int mid, int requiredWood) {
        int totalWood =0;
        for (int x :nums){
            if(x>mid)
             totalWood+=x-mid;
        }
      return totalWood>=requiredWood;
    }


    int maxHeightOfSawBlade(Integer []nums, int wood){
        int left = 0;
        int  right =  Collections.max(Arrays.asList(nums));
        int mid =0;
        int ans =0;
        while(left<=right){
             mid = left + (right -left)/2;
            if(isPossibleToCut(nums,mid,wood)){
                ans = mid;
                left = mid +1;
            }else
                right = mid -1;

        }
        return  ans;

    }

    //- PRATA SPOJ: https://bit.ly/3ExHXt5



    public static void main(String[] args) {
        int numbers[] = {0,0,1,1,2,2,2,2};
        int k =2;
        BinarySearch bs = new BinarySearch();
        System.out.println("first occurrence of " + k +" is: " +bs.firstOccurrence(numbers,numbers.length,k) + " and last occurrence is: "+ bs.lastOccurrence(numbers,numbers.length,k));
        System.out.println("total occurrence of " + k + " is: " + bs.totalOccurrence(numbers,numbers.length,k) );

       int numbers1[] = {0,2,1,0};
       int numbers2[] = {3,4,5,1};
        System.out.println("Peak of mountain is: "+ bs.peakIndex(numbers1,numbers1.length));
        System.out.println("Peak of mountain is: "+ bs.peakIndex1(numbers2,numbers2.length));

        int []numbers3 = {1,7,3,6,5,6};
        System.out.println("Pivot index is " + bs.pivotIndex(numbers3,numbers3.length));

        int []numbers4 = {2,1,-1};
        System.out.println("Pivot index is " + bs.pivotIndex(numbers4,numbers4.length));
        int []numbers5 = {8,10,17,1,3};
        System.out.println("Pivot element is  at" + bs.findPivot(numbers5,numbers5.length));
        System.out.println("Element found at " + bs.searchInRotatedArray(numbers5,numbers5.length,17));
        System.out.println("Element found at " + bs.searchInRotatedArray(numbers5,numbers5.length,1));

        int []numbers6 = {2, 2, 2, 2, 2, 2, 2, 2, 0, 2};
        System.out.println("Pivot element is " + bs.findPivot(numbers6,numbers6.length));
        int num = 36;
        System.out.println("Square root of "+ num + " is "+ bs.SquareRoot(num));

        int num1 = 32;
        Long tempSolution =  bs.SquareRoot(num1);
        System.out.println("Square root of "+ num1 + " is "+ bs.squareRootPrecision(num1,3,tempSolution));

        int []numbers7 = {10,20,30,40};
        System.out.println("Ans for book allocation is " + bs.bookAllocation(numbers7,numbers7.length,2) );


       int []numbers8 = {2,2,3,3,4,4,1};
        System.out.println("Ans for book allocation is " + bs.bookAllocation(numbers8,numbers8.length,4) );

        int []numbers9 = {48,90};
        System.out.println("Ans for book allocation is " + bs.bookAllocation(numbers9,numbers9.length,2) );

        Integer[] numbers10 = {4 ,42, 40, 26, 46};
        System.out.println(" Max height of sawblade " + bs.maxHeightOfSawBlade(numbers10,20));


        Integer[] numbers11 = {4, 2, 1, 3, 6};
        System.out.println("Largest distance between cows " +bs.maxDistanceForCows(numbers11,2));


        Integer[] numbers12 = {  0, 3, 4, 7, 10, 9 };
        System.out.println("Largest distance between cows " +bs.maxDistanceForCows(numbers12,4));

        Integer[] numbers13 = { 0, 4, 3, 7, 10, 9};
        System.out.println("Largest distance between cows " +bs.maxDistanceForCows(numbers13,3));

        Integer[] numbers14 = {1,2,3};
        System.out.println("Largest distance between cows " +bs.maxDistanceForCows(numbers14,2));


    }
}
