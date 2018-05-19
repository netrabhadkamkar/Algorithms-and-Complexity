/*Implements 6. Competition scheduling problem*/
import java.util.Scanner;


public class NetraBhadkamkarScheduling {

  int n = 5;
  int swimming[]={11,7,10,15,6};
  int biking[]={4,5,9,2,3};
  int running[]={8,6,4,7,3};
  static int totaltime;

  void sort()
  {
	 int cswim, cbike, crun;
	 for (int i=0;i<n;i++)
	 {
		 for(int j=i;j<n;j++)
	     {
	       if((biking[i] + running[i]) < (biking[j] + running[j]))
	        {
	          cswim   = swimming[j];
	          swimming[j] = swimming[i];
	          swimming[i] = cswim;

	          cbike   = biking[j];
	          biking[j] = biking[i];
	          biking[i] = cbike;

	          crun   = running[j];
	          running[j] = running[i];
	          running[i] = crun;
	        }
	      }
	    } 
  }

  int totalswimmingtime(int i)
  {
	 int total=0;
	 for (int j=0;j<=i;j++)
	 {
	   total = total + swimming[j];
	 }
	 	return total;
  }

	void time()
	
	   {
	    for (int i=n-1;i>0;i--)
	    {
	      if ( (biking[i-1] + running[i-1]) < (swimming[i] + biking[i] + running[i]) )
	      {
	        totaltime = totalswimmingtime(i) + biking[i] + running[i];
	    		break;
	      }
	      else
	      {
	        totaltime = totalswimmingtime(i-1) + biking[i-1] + running[i-1];
	      }
	    }
	  }

	  void result()
	  {
	  for (int i=0;i<n;i++)
	    {
	      System.out.println("Contestant : " + (i+1));
	      System.out.println("Swimming" + " : "+ swimming[i] + "; Biking " + " : "+ biking[i]+ "; Running" + " : "+ running[i]);
	    }
	    System.out.println("\nTime required for the mini - triathalon : " + totaltime);
	  }

	  public static void main(String[] args) 
	  {
		  NetraBhadkamkarScheduling nb = new NetraBhadkamkarScheduling();
		  nb.sort();
		  nb.time();
		  nb.result();
	  }
}
	
