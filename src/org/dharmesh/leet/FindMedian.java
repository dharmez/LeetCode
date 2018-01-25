/*
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
 * Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
 * 	Example 1:
 * 		nums1 = [1, 3]
 * 		nums2 = [2]
 * 		The median is 2.0
 * 	Example 2:
 * 		nums1 = [1, 2]
 * 		nums2 = [3, 4]
 * 		The median is (2 + 3)/2 = 2.5
 */

package org.dharmesh.leet;

import java.util.Arrays;

public class FindMedian {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    		double median=0.0;
    		int size1 = nums1.length;
    		int size2 = nums2.length;
    		int size = size1+size2;
    		boolean even=false;
    		if(size%2==0)even=true;
    		int[] nums = new int[size];
    		System.arraycopy(nums1, 0, nums, 0, size1);
    		System.arraycopy(nums2, 0, nums, size1, size2);
    		Arrays.sort(nums);
    		if(even){
    			int index = size/2;
    			int a = nums[index-1];
    			int b = nums[index];
    			median = (double)(a+b)/2;
    		}else {
    			int indexOfmedian = (size-1)/2;
    			median = (double)nums[indexOfmedian];
    		}   		
    		return median;
    }
    
	public static void main(String[] args) {
		FindMedian calculator = new FindMedian();
		int nums1[] = { 0,2,9,20000, 20003};
		int nums2[] = { 1,3,5,6,7};
		long st = System.nanoTime();
		double median = calculator.findMedianSortedArrays(nums1, nums2);
		long et = System.nanoTime();
		long tt = et - st;
		System.out.println("compute time in nano seconds: " + tt);
		System.out.println("Median =" + median);

	}
}
