package Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class ArrayQuestions1 {
    void swapAlternate(int[] numbers, int size){
        int threshold = 0;
        if(size%2==0)
            threshold = size-1;
        else
            threshold = size -2;

        for(int i =0;i<threshold;i=i+2){
            numbers[i]=numbers[i+1]+numbers[i];
            numbers[i+1]=numbers[i]-numbers[i+1];
            numbers[i]=numbers[i]-numbers[i+1];
        }
    }

    //Optimised
    void swapAlternate1(int[] numbers, int size){
        for(int i =0;i<size;i=i+2){
            if(i+1<size){
                numbers[i]=numbers[i+1]+numbers[i];
                numbers[i+1]=numbers[i]-numbers[i+1];
                numbers[i]=numbers[i]-numbers[i+1];
            }
        }
    }

    //- Find Unique element [https://bit.ly/3y01Zdu]
    int findUnique(int[] numbers, int size){
        int num = 0;
        for(int i=0;i<size;++i){
            num = numbers[i]^num;
        }
        return num;
    }

    //https://leetcode.com/problems/unique-number-of-occurrences/
    Boolean uniqueOccurrence(int []numbers,int size){
        HashMap<Integer,Integer> hm = new HashMap<>();

        for(int i=0;i<size;++i){
            Integer count = hm.get(numbers[i]);
            hm.put(numbers[i], (count == null) ? 1: count+1 );
        }
//        for(Map.Entry<Integer,Integer> val : hm.entrySet() ){
//            hs.add(val.getValue());
//        }
        Set<Integer> hs = hm.values().stream().collect(Collectors.toSet());
        return hm.size() == hs.size();
    }

    //- Duplicates in Array [https://bit.ly/3dm6bdZ ]
    Integer findDuplicate(int[]numbers, int size){
        int ans =0;
        //XOR all elements
        for(int i=0;i<size;++i){
           ans = ans^numbers[i];
        }

        //XOR all numbers with 1 to n-1
        for(int i=0;i<size;++i){
            ans = ans^i;
        }
        return ans;
    }

    //https://leetcode.com/problems/find-all-duplicates-in-an-array/
    List findAllDuplicates(int [] numbers,int size){
        List<Integer>list = new ArrayList<>();
        for(int i=0;i<size;i++){
            if(numbers[Math.abs(numbers[i])-1]<0)
                list.add(Math.abs(numbers[i]));
            numbers[Math.abs(numbers[i])-1]=-numbers[Math.abs(numbers[i])-1];
        }
        return list;
    }




    //- Array Intersection [https://bit.ly/3Il0c7n]
    List intersectionOfArrays(int[] numbers1, int size1, int[] numbers2, int size2){
        List<Integer> ans = new ArrayList<>();
        int i=0;
        int j=0;
        while(i<size1 && j<size2){
            if(numbers1[i]==numbers2[j]){
                ans.add(numbers1[i]);
                i++;
                j++;
            }
            else if(numbers1[i]>numbers2[j])
                j++;
             else
                i++;
        }
        return ans;
    }


    //- Pair Sum [https://bit.ly/3EwlU6e]

    List<List> PairSum(int[]numbers, int size, int sum){

        List<List> ans = new ArrayList<>();
        Arrays.sort(numbers);
        int i =0;
        int j = numbers.length -1;
        while(i<j){
            List<Integer>pairs = new ArrayList<>();
            int actualSum = numbers[i]+numbers[j];
            if( actualSum == sum){
                pairs.add(numbers[i++]);
                pairs.add(numbers[j--]);
            } else if (actualSum>sum)
                j--;
            else
                i++;
            if(!pairs.isEmpty()){
                ans.add(pairs);
            }
        }
        return ans;
    }


    //- Triplet sum [https://bit.ly/3GbgVs3]

    List<List> tripletSum(int[]numbers, int size, int sum){
        List<List> ans = new ArrayList<>();
        for(int k= 0; k<numbers.length; ++k){
            Arrays.sort(numbers);
            int i =k+1;
            int j = numbers.length -1;
            while(i<j){
                List<Integer>triplets = new ArrayList<>();
                int actualSum = numbers[i]+numbers[j];
                int expectedSum = sum - numbers[k];
                if( actualSum == expectedSum){
                    triplets.add(numbers[i++]);
                    triplets.add(numbers[j--]);
                    triplets.add(numbers[k]);
                } else if (actualSum>expectedSum)
                    j--;
                else
                    i++;
                if(!triplets.isEmpty()){
                    Collections.sort(triplets);
                    ans.add(triplets);
                }
            }
        }

        return ans;
    }

    //- Sort 0 1
    // Approach1
    int[] sortZeroAndOne(int[] numbers, int size){
        int countZero = 0;
        int countOne = 0;
        int[] ans = new int[size];
        for(int i =0;i<size;++i){
           if(numbers[i]==0)
               ++countZero;
           else
               ++countOne;
        }
        for(int i =0;i<size;++i){
            if(countZero>i){
                ans[i]=0;
            }else {
                ans[i]=1;
            }
        }
        return ans;
    }

    // Approach2
    int[] sortZeroAndOne1(int[] numbers, int size){
         int left = 0;
         int right = size -1;
         while(left<right){
             if(numbers[left] ==0){
                 ++left;
             }
             else if(numbers[right] ==1){
                 --right;
             } else {
                 numbers[left]=numbers[left]+numbers[right];
                 numbers[right]=numbers[left]-numbers[right];
                 numbers[left]=numbers[left]-numbers[right];
                 ++left;
                 --right;
             }
         }

        return numbers;
    }


    //- Sort 0 1 2 [https://bit.ly/3DfQW0s]
    // Important

    int[] sortZeroOneTwo(int []numbers, int size) {
        int left = 0;
        int mid = 0;
        int right = size -1;
        while (mid<=right){
            switch (numbers[mid]) {
                case 0: {
                    numbers[left] = numbers[left] + numbers[mid];
                    numbers[mid] = numbers[left] - numbers[mid];
                    numbers[left] = numbers[left] - numbers[mid];
                    ++left;
                    ++mid;
                    break;
                }

                case 1: {
                    ++mid;
                    break;
                }
                case 2: {
                    numbers[right] = numbers[right] + numbers[mid];
                    numbers[mid] = numbers[right] - numbers[mid];
                    numbers[right] = numbers[right] - numbers[mid];
                    -- right;
                    break;
                }
            }
        }
        return numbers;
    }



    public static void main(String[] args) {
        int[] numbers1 = new int[]{1,2,3,4,5,6,7,8};
        int[] numbers2 = new int[]{1,2,3,4,5,6,7};
        ArrayQuestions1 aq= new ArrayQuestions1();
        aq.swapAlternate(numbers1,numbers1.length);
        aq.swapAlternate(numbers2,numbers2.length);
        System.out.println(Arrays.toString(numbers1));
        System.out.println(Arrays.toString(numbers2));

        aq.swapAlternate1(numbers1,numbers1.length);
        aq.swapAlternate1(numbers2,numbers2.length);
        System.out.println(Arrays.toString(numbers1));
        System.out.println(Arrays.toString(numbers2));

        int[] number3 = new int[]{3,7,2,2,-8,4,3,7,-8,};
        System.out.println(aq.findUnique(number3,number3.length));
        int []numbers4 = new int[]{1,2,2,1,1,3};
        int []numbers5 =  new int[]{1,2,3,4,5,5,4,3,2,1,1,3,5};
        System.out.println(aq.uniqueOccurrence(numbers4,numbers4.length));
        System.out.println(aq.uniqueOccurrence(numbers5,numbers5.length));

        int []numbers6 = new int[]{1,2,3,5,4,3};
        System.out.println(aq.findDuplicate(numbers6, numbers6.length));

        int[] numbers7 = new int[]{4,3,2,7,8,2,3,1};
        System.out.println(aq.findAllDuplicates(numbers7, numbers7.length));

        int[] numbers8 = new int[]{1,2,2,3,4,8,8,10};
        int[] numbers9 = new int[]{2,2,3,3,8,10};
        System.out.println(aq.intersectionOfArrays(numbers8,numbers8.length,numbers9,numbers9.length));

        int[] numbers10 = new int[]{4,-3,2,3,-1,8,2,6,1};
        System.out.println(aq.PairSum(numbers10,numbers10.length,5));

        int numbers11[] = {32, 1, 4,-8, 45, 6, 10, 8,-2 };
        System.out.println(aq.tripletSum(numbers11,numbers11.length,22));

        int numbers12[] ={0,1,1,0,1,0,1,0,0,0,1,1};
        System.out.println(Arrays.toString(aq.sortZeroAndOne(numbers12,numbers12.length)));
        System.out.println(Arrays.toString(aq.sortZeroAndOne1(numbers12,numbers12.length)));

        int numbers13[]={0,1,2,2,2,2,1,0,0,0,1,2,0};
        System.out.println(Arrays.toString(aq.sortZeroOneTwo(numbers13, numbers13.length)));

    }
}
