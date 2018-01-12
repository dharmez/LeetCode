package org.dharmesh.leet;

public class Sum {
	

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
		Sum s = new Sum();
		int nums[] = {6,1,3,2,4,7};
		int result[] = s.twoSum(nums, 11);
		System.out.println(result[0]);
		System.out.println(result[1]);

	}

}