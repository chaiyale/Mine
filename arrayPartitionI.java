import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;


public class arrayPartitionI 
{
	public static int arrayPairSum(int[] nums)
	{//solution: 从最小的隔一个找一个
		int sum = 0;
		
		//Arrays.sort(nums);
		ArrayList<Integer> numList = new ArrayList<Integer>();  
		for(int i:nums)
		{
			numList.add(i);
		}
		Collections.sort(numList);
		
		for(int i=0; i<nums.length; i+=2)
		{
			sum += numList.get(i);
		}
		
		return sum;
	}
	
	public static void main(String[] args)
	{
		int[] nums = {1,3,4,2};
		System.out.println(arrayPairSum(nums));
	}
}
