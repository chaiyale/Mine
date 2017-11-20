import java.util.ArrayList;
import java.util.List;


public class selfDividingNumbers 
{
	public static List<Integer> selfDividingNumbers(int left, int right)
	{
		List<Integer> list = new ArrayList<Integer>();
			
		for(int i=left; i<=right; i++)
		{
			String lstr = i+"";
			int lbit = lstr.length();
			int[] bits = new int[lbit];
			int tmp = i;
			for(int j=lbit-1; j>=0; j--)
			{
				bits[j] = (int) (tmp/Math.pow(10, j));
				tmp -= bits[j]*Math.pow(10, j);
			}
			boolean is = true;
			for(int bit:bits)
			{
				if(bit==0 || i%bit!=0)
				{
					is = false;
					break;
				}
			}
			if(is == true)
				list.add(i);
		}
		return list;
	}
	
	public static void main(String[] args)
	{
		int left = 102, right = 122;
		selfDividingNumbers(left, right);
	}
}
