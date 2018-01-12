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

public class SumWithArray {
	
    public int[] twoSum(int[] nums, int target) {
    	if(nums != null){
            for(int i=0; i<nums.length; i++){
            	for(int j=0; j<nums.length; j++){
            		if ((i!=j)&(nums[i]+nums[j]==target)){
	                	return new int[] {i,j};
            		}
            	}
            }
        }
    	throw new ArrayIndexOutOfBoundsException("No two sum solution.");
    }

	public static void main(String[] args) {
		SumWithArray s = new SumWithArray();
		int nums[] = {0,1,3,2,4,7};
		long st = System.nanoTime();
		int result[] = s.twoSum(nums, 11);
		long et = System.nanoTime();
		long tt = et-st;
		System.out.println("compute time: "+ tt);
		System.out.println("["+result[0]+", "+result[1]+"]");

	}

}