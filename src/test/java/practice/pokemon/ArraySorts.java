package practice.pokemon;

import java.lang.reflect.Array;
import java.util.Arrays;

public class ArraySorts {

    public static void main(String[] args) {


        int nums [] = {7,6,6,4,3,2,1};

        for (int i = 0; i < nums.length; i++) {

            int temp = 0;

            for (int j = i+1; j < nums.length; j++) {

                if (nums[i] > nums[j]){

                    temp  = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;

                }

            }

        }

        System.out.println(Arrays.toString(nums));

    }

}
