import java.util.HashSet;


public class firstUniqueCharacterinaString 
{
	public static int firstUniqChar(String s)
	{
		int index=0, i;
		HashSet<Character> has = new HashSet<Character>();
		for(i=0; i<s.length(); i++)
		{
			char ch = s.charAt(i);
			String sub = "";
			if(i+1<s.length())
			    sub = s.substring(i+1);
			if(sub.indexOf(ch)!=-1 || has.contains(ch)==true) index++;
			else break;
			has.add(ch);
		}
		if(index>=s.length()) return -1;
		return index;
	}
	
	public static int firstUniqChar2(String s)
	{
		int freq [] = new int[26];
        for(int i = 0; i < s.length(); i ++)
            freq [s.charAt(i) - 'a'] ++;
        for(int i = 0; i < s.length(); i ++)
            if(freq [s.charAt(i) - 'a'] == 1)
                return i;
        return -1;
	}
	
	public static void main(String[] args)
	{
		String s="loveleetcodevvv";
		System.out.println(firstUniqChar(s));
	}
}
