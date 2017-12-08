import java.util.ArrayList;
import java.util.List;


public class binaryWatch 
{
    public static List<String> readBinaryWatch(int num) 
    {    
    	List<String> array = new ArrayList<String>();
    	int[] nums1 = new int[]{8, 4, 2, 1}, nums2 = new int[]{32, 16, 8, 4, 2, 1};
    	int hoursMaxTime = num>4? 4:num;
    	for(int i=0; i<=hoursMaxTime; i++)  //时针、分针数组分配的可能性
    	{
    		int hoursTime = i;
    		int minsTime = num-i;
    		List<Integer> hours = getCombination(nums1, hoursTime);  //根据分配的数字，可能得到的结果组合
    		List<Integer> mins = getCombination(nums2, minsTime); 
    		for(int h: hours)
    		{
    			if(h>=12) continue;
    			for(int m: mins)
    			{
    				if(m>=60) continue;
    				String min = m<10? "0"+m:""+m;
    				String fi = h+":"+min;
    				array.add(fi);
    			}
    		}
    	}
    	return array;
    }
    
    public static List<Integer> getCombination(int[] nums, int bits)
    {
    	List<Integer> list = new ArrayList<Integer>();
    	reverse(nums, 0, 0, bits, list);
    	return list;
    }
    
    public static void reverse(int[] nums, int pos, int sum, int bits, List<Integer> list)
    {
    	if(bits==0)
    	{
    		list.add(sum);
    		return;
    	}
    	
    	for(int i=pos; i<nums.length; i++)
    	{
    		reverse(nums, i+1, sum+nums[i], bits-1, list);
    	}
    }
    
	public static void main(String[] args)
	{
		int n=2;
		System.out.println(readBinaryWatch(n));
	}
}
