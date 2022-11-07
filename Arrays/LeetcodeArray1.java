package Arrays;

import java.util.HashMap;

public class LeetcodeArray1 {
	
	
	    public int[] twoSum(int[] nums, int target) {
	      //Using Hashmap
	       HashMap<Integer,Integer> indexMap=new HashMap<Integer,Integer>();
	        //We are putting required number as key .So ,key is eg.2/7/11/15 and value is index
	        for(int i=0;i<nums.length;i++){
	            Integer requiredNumber=(Integer)target-nums[i];
	            if(indexMap.containsKey(requiredNumber)){
	                int doReturn[]={indexMap.get(requiredNumber),i};
	                return doReturn;
	            }
	            indexMap.put(nums[i],i);
	        }
	        return null;
	             /*int arr[]=new int[2];
	    for(int i=0;i<nums.length;i++){
	        for(int j=i+1;j<nums.length;j++){
	            if(nums[i]+nums[j]==target){
	                arr[0]=i;
	                arr[1]=j;
	             
	            }
	        }
	    }
	        return arr;*/
	      
	}

	public static void main(String[] args) {
		LeetcodeArray1 a1=new LeetcodeArray1();
		int arr[]= {1,2,5,6};
		int a[]=a1.twoSum(arr,11);
		System.out.println(a[0]+" "+a[1]);

	}

}
