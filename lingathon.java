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
		
		logicalReason(s);
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
	
	//for logical reason 
	static void logicalReason(String s) 
	{
		findRoot();
		hash();
		HashMap<String,String> hmapA= new HashMap<>();
		for(int i=0;i<findRoot().size();i++)
		{
			switch (i)
			{
			case 0:
				hmapA.put(findRoot().get(0),"abdomen");
			case 1:
				hmapA.put(findRoot().get(1),"top/upper");
			case 2:
				hmapA.put(findRoot().get(2),"feather");
			case 3:
				hmapA.put(findRoot().get(3),"snow");
			case 4:
				hmapA.put(findRoot().get(4),"frog");
			case 5:
				hmapA.put(findRoot().get(5),"duck");
			case 6:
				hmapA.put(findRoot().get(6),"blanket");
			case 7:
				hmapA.put(findRoot().get(7),"man");
			case 8:
				hmapA.put(findRoot().get(8),"face");
			case 9:
				hmapA.put(findRoot().get(9),"dog");
			case 10:
				hmapA.put(findRoot().get(10),"harness");
			case 11:
				hmapA.put(findRoot().get(11),"female");
			case 12:
				hmapA.put(findRoot().get(12),"cold");
			case 13:
				hmapA.put(findRoot().get(13),"tooth");
			default:
			}	
		}
		String answer="";
		int count=0;
		for(int i=0;i<findRoot().size();i++)
		{
			if(s.contains(findRoot().get(i)))
 			{
 				answer+=hmapA.get(findRoot().get(i));
 				answer=answer+" ";
 				count++;
 			}
		}
		System.out.println(answer);
	}
		





}

