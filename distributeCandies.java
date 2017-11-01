import java.util.ArrayList;

public class distributeCandies 
{
    public static int distributeCandies(int[] candies) 
    {
    	int len = candies.length;
    	int half = len/2;
    	
    	ArrayList<Integer> kinds = new ArrayList<Integer>();
    	for(int candy: candies)
    	{
    		if(!kinds.contains(candy))
    		{
    			kinds.add(candy);
    		}
    	}
    	int category = kinds.size();
    	return (category>half)?half:category;
    }
    
	public static void main(String[] args)
	{
		int[] candies = {1,1,2,3};
		System.out.println(distributeCandies(candies));
	}
}
