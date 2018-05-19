/* Implements 1.Men Proposing Victor to Zeus and 2. Women proposing Amy to Erika
 * Reference http://www.sanfoundry.com/java-program-gale-shapley-algorithm */

import java.io.*;
public class ProposalRejectNetraBhadkamkar1 {
	int Count = 0;
	String[] man = 	{"Victor", "Wyatt", "Xavier", "Yancey", "Zeus"};
	String[] woman = 	{"Amy", "Bertha", "Claire", "Diane", "Erika"};
	String[][] husband  = {{"Bertha","Amy","Diane","Erika","Claire"}, 
	                  {"Diane","Bertha","Amy","Claire","Erika"}, 
	                  {"Bertha","Erika","Claire","Diane","Amy"}, 
	                  {"Amy","Diane","Claire","Bertha","Erika"},
	                  {"Bertha","Diane","Amy","Erika","Claire"}};
	String[][] wife = {{"Zeus","Victor","Wyatt","Yancey","Xavier"}, 
	                  {"Xavier","Wyatt","Yancey","Victor","Zeus"},
	                  {"Wyatt","Xavier","Yancey","Zeus","Victor"},
	                  {"Victor","Zeus","Yancey","Xavier","Wyatt"}, 
	                  {"Yancey","Wyatt","Zeus","Xavier","Victor"}};
	
		int N = husband.length;
	    int M = wife.length;
	  	boolean[] mEngage = new boolean[N];
	    String[] wPartner = new String[N];
	    String[] mPartner = new String[M];
	    boolean[]wEngaged = new boolean[M];
	    
	    public void vtoz()
	    {
	        while (Count < N)
	        {
	            int empty;
	            for (empty = 0; empty< N;empty++)
	                if (!mEngage[empty])
	                    break;
	 
	            for (int i = 0; i <N && !mEngage[empty]; i++)
	            {
	                int index = wIndex(husband[empty][i]);
	                if (wPartner[index] == null)
	                {
	                    wPartner[index] = man[empty];
	                    mEngage[empty] = true;
	                    Count++;
	                }
	                else
	                {
	                    String currentPartner = wPartner[index];
	                    if (priority(currentPartner, man[empty], index))
	                    {
	                        wPartner[index] = man[empty];
	                        mEngage[empty] = true;
	                        mEngage[mIndex(currentPartner)] = false;
	                    }
	                }
	            }            
	        }
	        result();
	    }

	   
	    boolean priority(String old, String neew, int index)
	    {
	        for (int i = 0; i < N; i++)
	        {
	            if (wife[index][i].equals(neew))
	                return true;
	            if (wife[index][i].equals(old))
	                return false;
	        }
	        return false;
	    }

	    public void atoe()
	    {
	        while (Count < M)
	        {
	            int empty;
	            for (empty = 0; empty< M; empty++)
	                if (!wEngaged[empty])
	                    break;
	 
	            for (int j = 0; j <M && !wEngaged[empty]; j++)
	            {
	                int index = mIndex(wife[empty][j]);
	                if (mPartner[index] == null)
	                {
	                    mPartner[index] = woman[empty];
	                    wEngaged[empty] = true;
	                    Count++;
	                }
	                else
	                {
	                    String Partner = mPartner[index];
	                    if (womenpriority(Partner, woman[empty], index))
	                    {
	                        mPartner[index] = woman[empty];
	                        wEngaged[empty] = true;
	                        wEngaged[wIndex(Partner)] = false;
	                    }
	                }
	            }            
	        }
	        result1();
	    }
	  boolean womenpriority(String old, String neew, int index)
	    {
	        for (int j = 0; j < M; j++)
	        {
	            if (husband[index][j].equals(neew))
	                return true;
	            if (husband[index][j].equals(old))
	                return false;
	        }
	        return false;
	    }
	    int mIndex(String str)
	    {
	        for (int i = 0; i < N; i++)
	            if (man[i].equals(str))
	                return i;
	        return -1;
	    }

	    int wIndex(String str)
	    {
	        for (int i = 0; i < N; i++)
	            if (woman[i].equals(str))
	                return i;
	        return -1;
	    }

	    void result()
	    {
	        System.out.println("\nMen to Women Pairing: \n");
	        for (int i = 0; i < N; i++)
	        {
	            System.out.println(wPartner[i] +" is engaged to "+ woman[i]);
	        }
	    }
	    void result1()
	    {
	        System.out.println("Women to Men :");
	        for(int j=0; j<M; j++)
	        {
	        	System.out.println(mPartner[j]+" is engaged to "+ man[j]);
	        }
	        
	    }

	    public static void main(String[] args) 
	    {
	    	try{
	    	
	    	int ch;
	    	String choice;
	    	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	    	do
	    	{
	    		System.out.println("\n1.Men Prefernce: Victor to Zeus");
	    		System.out.println("2.Women Prefernce: Amy to Erika");
	    		System.out.println("\nEnter your choice:");
	    		String s=br.readLine();
	    		ch=Integer.parseInt(s);
	    	
	    	switch(ch){
	    	
	    	case 1:ProposalRejectNetraBhadkamkar1 gale = new ProposalRejectNetraBhadkamkar1();
		      		gale.vtoz();
	      	break;
	    		
	    	case 2: ProposalRejectNetraBhadkamkar1 gs1 = new ProposalRejectNetraBhadkamkar1();
	      		gs1.atoe();
	      		
	    	
	    	}
	    	System.out.println("Do u want to continue?(y/n)");
			choice=br.readLine();
	    	
	    	
	 
	    	}while (choice.equals("y"));
	        System.out.println("\n Exit !");
	 
	        
	    	}
	    	catch(Exception e)
	    	{
	    		System.out.println(e);
	    	}
	      	
	      	
	    }
}