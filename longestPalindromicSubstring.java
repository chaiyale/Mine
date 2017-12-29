import java.util.ArrayList;
import java.util.HashMap;


public class longestPalindromicSubstring 
{
	private static int lo;
	private static int maxLen;
	public static String longestPalindrome1(String s)
	{
		int max=0; 
		String str = "";
		HashMap<Character, ArrayList<Integer>> map = new HashMap<Character, ArrayList<Integer>>();
		for (int i=0; i<s.length(); i++)
        {
            char ch = s.charAt(i);
            ArrayList<Integer> list = new ArrayList<Integer>();
			if (map.containsKey(ch))
			{
				list = map.get(ch);
				for(int j: list)
				{
					String sub = s.substring(j+1, i);
					if(isDuiChen(sub))
					{
						if(sub.length()+2 > max)
						{
							max = sub.length()+2;
							str = ch + sub + ch;
						}
					}
				}
			}
			list.add(i);
			map.put(ch,list);
        }
		if(str.equals("") && s.length()!=0) return s.charAt(0)+"";
		return str;
	}
	
	public static boolean isDuiChen(String s)
	{
		boolean is = true;
		if(s.length() == 1) return is;
		for(int i=0; i<s.length()/2; i++)
		{
			char ch1 = s.charAt(i);
			char ch2 = s.charAt(s.length()-1-i);
			if(ch1 != ch2)
				return false;
		}
		
		return is;
	}
	
	public static String longestPalindrome(String s) 
    {
        int len = s.length();
        if (len < 2)
	        return s;

        for (int i = 0; i < len-1; i++) 
        {
 	        extendPalindrome(s, i, i);  //assume odd length, try to extend Palindrome as possible
 	        extendPalindrome(s, i, i+1); //assume even length.
        }
        return s.substring(lo, lo + maxLen);
    }

    private static void extendPalindrome(String s, int j, int k) 
    {
        while (j >= 0 && k < s.length() && s.charAt(j) == s.charAt(k)) 
        {
	        j--;
	        k++;
        }
        if (maxLen < k - j - 1) 
        {
	        lo = j + 1;
	        maxLen = k - j - 1;
        }
    }
	
	public static void main(String[] args)
	{
		String s = "abcdsfsssssssssssf";
		System.out.println(longestPalindrome(s));
	}
}
