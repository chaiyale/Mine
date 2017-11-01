import java.util.ArrayList;


public class singleNumber 
{  
	public static void main(String[] args)
	{
		ArrayList<Integer> nums = new ArrayList<Integer>();
		for(int i=0; i<100; i++)
		{
			if(i==4 || i==52)
			{
				continue;
			}
			nums.add(i);
		}
		
		int minus = 0;
		int sum = 0;
        for (int i = 0; i<nums.size(); i++)
        {
        	minus^=nums.get(i);
        	sum += nums.get(i);
        } 
        int plus = (99*100)/2 - sum;
        int x = (plus-minus)/2;
        int y = plus - x;
        System.out.println(x+", "+y);
	}
}
