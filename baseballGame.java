import java.util.Stack;


public class baseballGame 
{
	public static int calPoints(String[] ops) 
	{
		if(ops.length == 0) return 0; 
	
		int i=0; int sum=0;
		while(i != ops.length)
		{
            String s = ops[i];
			if(s.equals("C") || s.equals("D") || s.equals("+")) //²»ÊÇÊý×Ö
            {
           	    i++;
            }
            else
            {
            	break;
            }
		}
		if(i == ops.length) return 0;
		else
		{
			Stack<Integer> list = new Stack<Integer>();
			for(; i<ops.length; i++)
			{
				String ch = ops[i];
				if(ch.equals("C"))
				{
					if(!list.isEmpty())
					{
						int last = list.pop();
					    sum -= last;
					}			
					//System.out.println(sum);
				}
				else if(ch.equals("D"))
				{
					if(!list.isEmpty())
					{
						int last = list.peek();
					    sum += last*2;
					    list.add(last*2);
					}			
					//System.out.println(sum);
				}
				else if(ch.equals("+"))
				{
					if(list.size()>=2)
					{
						int last = list.pop();
						int Blast = list.peek();
						list.add(last);
					    int tmp = last+Blast;
					    sum += tmp;
					    list.add(tmp);
					}			
					//System.out.println(sum);
				}
				else
				{
					sum += Integer.parseInt(ch);
					list.add(Integer.parseInt(ch));
					//System.out.println(sum);
				}
			}
		}
		return sum;
	}
	
	public static void main(String[] args)
	{
		String[] ops = {"-2","5","2","+","C","D","+"};
		System.out.print(calPoints(ops));
	}
}
