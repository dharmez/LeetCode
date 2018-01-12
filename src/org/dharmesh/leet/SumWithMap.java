/**
 * Given an array of integers, return indices of the two 
 * numbers such that they add up to a specific target.
 * 
 * You may assume that each input would have exactly one solution, 
 * and you may not use the same element twice.
 * 
 * 
 */

package org.dharmesh.leet;
import java.util.HashMap;
import java.util.Map;

public class SumWithMap {
	
    public int[] twoSum(int[] nums, int target) {
    	if(nums != null){
            Map<Integer, Integer> map = new HashMap<>();
            for(int i=0; i<nums.length; i++){
            	int complement = target - nums[i];
            	if(map.containsKey(complement)){
            		return new int[]{map.get(complement), i};
            	}
            	map.put(nums[i],i);
            }
        }
    	throw new ArrayIndexOutOfBoundsException("No two sum solution.");
    }

	public static void main(String[] args) {
		SumWithMap s = new SumWithMap();
		int nums[] = {0,1,3,2,4,7};
		long st = System.nanoTime();
		int result[] = s.twoSum(nums, 11);
		long et = System.nanoTime();
		long tt = et-st;
		System.out.println("compute time: "+ tt);
		System.out.println("["+result[0]+", "+result[1]+"]");

	}

}