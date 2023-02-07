package Recursion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Recursion4 {

    //Impt
    //Power set of set
    void subSets(int []nums, int index ,List<Integer> output, List<List<Integer>> ans){
        if(index>=nums.length){
            ans.add(new ArrayList<>(output));
            return;
        }

        // include element
        int element = nums[index];
        output.add(element);
        subSets(nums,index+1, output, ans);
        output.remove(output.size()-1);

        // exclude element
        subSets(nums,index+1, output, ans);

    }

    void subSequence(String s, int index, List<String> output, List<List<String>> ans){
        if(index>=s.length()){
            ans.add(new ArrayList<>(output));
            return;
        }

        //Include character
        output.add(String.valueOf(s.charAt(index)));
        subSequence(s,index+1,output,ans);
        output.remove(output.size()-1);

        //exlude character
        subSequence(s,index+1,output,ans);

    }

    //https://leetcode.com/problems/letter-combinations-of-a-phone-number/
    //Important
    void letterCombinations(String digit, int index, List<String> output, String[]mapping, List<List<String>>ans){
        if(index>=digit.length()){
            ans.add(new ArrayList<>(output));
            return;
        }
        int num = digit.charAt(index) - '0';
        for(int i =0;i<mapping[num].length();++i){
             output.add(String.valueOf(mapping[num].charAt(i)));
             letterCombinations(digit,index+1,output,mapping,ans);
             output.remove(output.size()-1);
        }
    }


    //permutations of a String
    //Very Important
    // https://leetcode.com/problems/permutations/

    void permutations(List<Integer> input, int index, List<List<Integer>> ans){
        if(index>=input.size()){
            ans.add(new ArrayList<>(input));
        }
        for(int j =index; j<input.size();++j ){
           //swap
            Collections.swap(input,index,j);
            permutations(input,index+1,ans);
            //backtrack
            Collections.swap(input,index,j);
        }
    }

    //Rat in  a maze problem


    public static void main(String[] args) {
        int[]nums = {1,2,3};
        Recursion4 rc = new Recursion4();
        List<Integer> output = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        rc.subSets(nums,0,output,ans);
        System.out.println(ans);

        String s = "abc";
        List<List<String>> ans1 = new ArrayList<>();
        rc.subSequence(s,0,new ArrayList<>(),ans1);
        System.out.println(ans1);

        String[]mapping = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        String digit = "23";
        List<List<String>> ans2 = new ArrayList<>();
        rc.letterCombinations(digit,0,new ArrayList<>(),mapping,ans2);
        System.out.println(ans2);

        List<Integer>nums2 = new ArrayList<>();
        nums2.add(1);
        nums2.add(2);
        nums2.add(3);
        List<List<Integer>> ans3 = new ArrayList<>();
        rc.permutations(nums2,0,ans3);
        System.out.println(ans3);

    }

}
