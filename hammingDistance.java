
public class hammingDistance 
{
	public int hammingDistance(int x, int y) 
	{
	    int xor = x ^ y, count = 0; //“ÏªÚ
	    for (int i=0;i<32;i++)
	    	count += (xor >> i) & 1;
	    return count;
	}
}
