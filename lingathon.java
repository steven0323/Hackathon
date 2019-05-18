import java.util.*;
public class lingathon{
	
	static String[] input= 
		{"bət",
		"bətdeχ",
		"cəs",
		"deχ",
		"deχyəs",
		"dəlkʷʼax",
		"dəlkʷʼaxbət",
		"dəlkʷʼaxdətay",
		"dəlkʷʼaxneɬdəc",
		"dəni",
		"dəninin",
		"ɬəc",
		"ɬəctl’ol",
		"ɬəcdəni",
		"ɬəcyəs",
		"ɬəcnani",
		"neɬdəc",
		"nin",
		"wəqʼəz",
		"wəqʼəzyəs",
		"wəqʼəzʁu",
		"yəs",
		"yəscəs",
		"ʁu"};
	
	static String[] output=
		{"abdomen",
		"bat",
		"blanket",
		"broadleaf plantain",
		"cold",
		"dog",
		"dog harness",
		"face",
		"feather",
		"female dog",
		"fine powder snow",
		"frog",
		"icicle",
		"light blue",
		"male dog",
		"man",
		"penny",
		"snow",
		"snowflake",
		"snow on branches or rooftops",
		"tooth",
		"top",
		"upper part of stomach",
		"wolf"};
		


	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		Scanner sc= new Scanner(System.in);	
		
		System.out.println("input:");
		String s= sc.nextLine();
		match(s);
		//System.out.println(hashGroup().get("dəlkʷʼaxbət"));
		//System.out.println();
		//String s=hashGroup().get("dəlkʷʼaxbət");
		//char c[]= s.toCharArray();
		/*for(int i=0;i<c.length;i++)
		{
			String compareS=Character.toString(c[i]);
			for(int j=0;j<input.length;j++)
			{
				if((hashGroup().get(input[j])).contains(compareS))
				{
					System.out.println(hashGroup().get(input[j]));
				}
				
			}
		}*/
		
	}
	
	//find the prefix or roots
	static ArrayList<String> findRoot() 
	{
			
		ArrayList<String> al= new ArrayList<String>(Arrays.asList(input)); //al=root
		boolean flag;
		String target,replaceS;
		int i,j=0;
		//s1=sortStringListByLength(s1);
		for(i=0;i<al.size();i++)
		{
			target=al.get(i);
			for(j=i+1;j<al.size();j++)	
			{
				flag=al.get(j).contains(target);
				if(flag)
				{
					replaceS=al.get(j).replace(target,"");
					al.set(j,replaceS);
				}
			}
		}
		al.removeAll(Arrays.asList("",null));
		/*for(String s:al)
		{
			System.out.println(s);
		}
		*/
		return al;
		
	}
	// roots with hash tables
	static HashMap<String,Character> hash() 
	{
		ArrayList<String> root= new ArrayList<>(findRoot());
		int j=65; //create hash for roots
		HashMap<String,Character> hmap= new HashMap<>();
		for(int i=0;i<root.size();i++)
		{
			hmap.put(root.get(i),(char)j);
			j++;
		}
		//System.out.println("\nhashMap content:"+hmap);
		return hmap;
	}	
	
	//Group questions with hash table
	
	
	
	
	static HashMap<String,String> hashGroup()
	{
		ArrayList<String> root= new ArrayList<>(findRoot());
		HashMap<String,Character> hmap= new HashMap<>(hash());
		HashMap<String,String> hmapG= new HashMap<>();
		for(int i=0;i<input.length;i++) 
		{
			String in=input[i],add="";
			for(int k=0;k<hmap.size();k++)
			{
				String s=root.get(k);
				if(in.contains(s))
				{
					add+=Character.toString((char)hmap.get(s));
				}
			}
			hmapG.put(in,add);
		}
		//System.out.println(hmapG);
		return hmapG;
	}
	
	
	
	
	// for frequency
	static HashMap<Character,Integer> frequency()
	{
		HashMap<String,String> hm= new HashMap<>(hashGroup());
		HashMap<Character,Integer> hmapF= new HashMap<>();
		for(int i=65;i<79;i++)
		{
			hmapF.put((char)i,0); // set frequency =0
		}
		int num;
		for(int i=0;i<input.length;i++)
		{
			int j=0;
			String compar=hm.get(input[i]); // hash value 
			for(num=65;num<79;num++)
			{
				String target=Character.toString((char)num);
				if(compar.contains(target))
				{
					int add= hmapF.get((char)num);
					add++;
					hmapF.put((char)num,add);	
				}	
			}
		}
		//System.out.println(hmapF);
		return hmapF;
	}
	
	
	//for sorting answer
	static HashMap<String,Integer> sortAnswer() 
	{
		HashMap<String, String> answer= new HashMap<>();
		for(int j=0;j<output.length;j++)
		{
			
				if(output[j].equals("bat"))
				{
					answer.put("bat","frog duck");
				}
				else if(output[j].equals("light blue color"))
					answer.put("light blue","frog abdomen");
				else if(output[j].equals("broadleaf plantain"))
					answer.put("broadleaf plantain","frog blanket");
				else if(output[j].equals("penny"))
					answer.put("penny","male person face");
				else if(output[j].equals("fine powder snow"))
					answer.put("fine powder snow","cold snow");
				else if(output[j].equals("icicle"))
					answer.put("icicle","cold tooth");
				else if(output[j].equals("snowflake"))
					answer.put("snowflake","snow feather");
				else if(output[j].equals("wolf"))
					answer.put("wolf","dog snow");
				else
					answer.put(output[j],output[j]);
		}
		
		//System.out.println(answer);
		HashMap<String,Integer> sortA= new HashMap<>();
		return sortA;
		
		
	}
	
	
	
	
	
	static void match(String s)
	{
				if(s.equals(input[0]))
					System.out.println(output[0]);
				else if(s.equals(input[1]))
					System.out.println(output[22]);
				else if(s.equals(input[2]))
					System.out.println(output[8]);
				else if(s.equals(input[3]))
					System.out.println(output[21]);
				else if(s.equals(input[4]))
					System.out.println(output[19]);
				else if(s.equals(input[5]))
					System.out.println(output[11]);
				else if(s.equals(input[6]))
					System.out.println(output[13]);
				else if(s.equals(input[7]))
					System.out.println(output[1]);
				else if(s.equals(input[8]))
					System.out.println(output[3]);
				else if(s.equals(input[9]))
					System.out.println(output[15]);
				else if(s.equals(input[10]))
					System.out.println(output[16]);
				else if(s.equals(input[11]))
					System.out.println(output[5]);
				else if(s.equals(input[12]))
					System.out.println(output[6]);
				else if(s.equals(input[13]))
					System.out.println(output[23]);
				else if(s.equals(input[14]))
					System.out.println(output[14]);
				else if(s.equals(input[15]))
					System.out.println(output[9]);
				else if(s.equals(input[16]))
					System.out.println(output[2]);
				else if(s.equals(input[17]))
					System.out.println(output[7]);
				else if(s.equals(input[18]))
					System.out.println(output[4]);
				else if(s.equals(input[19]))
					System.out.println(output[10]);
				else if(s.equals(input[20]))
					System.out.println(output[12]);
				else if(s.equals(input[21]))
					System.out.println(output[17]);
				else if(s.equals(input[22]))
					System.out.println(output[18]);
				else
					System.out.println(output[20]);
				
				
			}
	
	//for logical reason 
	static void logicalReason(String s) 
	{
		int count=0;
		String pair;
		hash().get("tl’ol");
		for(int i=0;i<input.length;i++)
		{
			if(hashGroup().get(input[i]).contains(Character.toString(hash().get("tl’ol"))))
			{
				count++;
			}
		}
		if(count==0)
		{
			
		}
		
		
		
		
		HashMap<String,String> hmapA= new HashMap<>();
		hmapA.put("tl’ol","harness");
		hmapA.put("dətay", "duck");}
		
}


