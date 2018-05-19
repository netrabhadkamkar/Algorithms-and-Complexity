/* Implements 1.Men Proposing zeus to victor
 * Reference http://www.sanfoundry.com/java-program-gale-shapley-algorithm */

public class ProposalRejectNetraBhadkamkar {
	int Count = 0;
	String[] reverseman = {"Zeus","Yancey","Xavier","Wyatt","Victor"};
	String[] woman = 	{"Amy", "Bertha", "Claire", "Diane", "Erika"};
	String[][]reversehusband = {{"Bertha","Diane","Amy","Erika","Claire"},
										{"Amy","Diane","Claire","Bertha","Erika"},
										{"Bertha","Erika","Claire","Diane","Amy"},
										{"Diane","Bertha","Amy","Claire","Erika"},
										{"Bertha","Amy","Diane","Erika","Claire"}};
	 String[][] wife = {{"Zeus","Victor","Wyatt","Yancey","Xavier"}, 
	                  				{"Xavier","Wyatt","Yancey","Victor","Zeus"},
	                  				{"Wyatt","Xavier","Yancey","Zeus","Victor"},
	                  				{"Victor","Zeus","Yancey","Xavier","Wyatt"}, 
	                  				{"Yancey","Wyatt","Zeus","Xavier","Victor"}};
	    
	    int N = reversehusband.length;
	  	public boolean[] reverseEngage = new boolean[N];
	    public String[] reversePartner = new String[N];
	    
	    public void ztov()
	    {
	        while (Count < N)
	        {
	            int empty;
	            for (empty = 0; empty< N; empty++)
	                if (!reverseEngage[empty])
	                    break;
	 
	            for (int i = 0; i <N && !reverseEngage[empty]; i++)
	            {
	                int index = wIndex(reversehusband[empty][i]);
	                if (reversePartner[index] == null)
	                {
	                    reversePartner[index] = reverseman[empty];
	                    reverseEngage[empty] = true;
	                    Count++;
	                }
	                else
	                {
	                    String current = reversePartner[index];
	                    if (priority(current, reverseman[empty], index))
	                    {
	                        reversePartner[index] = reverseman[empty];
	                        reverseEngage[empty] = true;
	                        reverseEngage[mIndex(current)] = false;
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

	    int mIndex(String str)
	    {
	        for (int i = 0; i < N; i++)
	            if (reverseman[i].equals(str))
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
	        System.out.println("\nMan Proposing to Woman: Zeus to Victor \n");
	        for (int i = 0; i < N; i++)
	        {
	            System.out.println(reversePartner[i] +" is engaged to "+ woman[i]);
	        }
	    }


	    public static void main(String[] args) 
	    {
	    	 System.out.println("Result:");
	        ProposalRejectNetraBhadkamkar gale = new ProposalRejectNetraBhadkamkar();
	      
	      	gale.ztov();
	    }
}