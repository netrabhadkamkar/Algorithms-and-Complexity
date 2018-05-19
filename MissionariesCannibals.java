/* Implements: Missionaries - Cannibals */

import java.util.*;

 public class NetraBhadkamkarMissionariesCannibals { 
	
	static boolean [][][] visited = new boolean [10][10][10];
	static int BreadthFirstSearch()
	{
		Queue<States> q = new LinkedList<States>();
		States initial = new States(3,3,0);
		q.add(initial);
		while(q.peek() != null)
		{
			States next = q.poll();
			if(next.miss == 0 && next.can == 0  && next.boat == 1)
			{
				States x;
				int count = 0;
				for (x = next; x != null; x = x.pred)
				{
					x.display();
					++count;
					
				}
				return count -1;
		}
			int i, j;
			for(i = 0; i<=2; i++)
			for(j=0; i+j<=2; j++)
			{
				if(i==0 && j==0)
					continue;
				States p = next.transition(i,j);
				if(!p.CheckValidState())
					continue;
				if(visited[p.miss][p.can][p.boat])
					continue;
				visited[p.miss][p.can][p.boat] = true;
				q.add(p);
				
			}
		}
		System.out.println("Wrong");
		return -1;
		
	}
	static class States{
		int miss;
		int can;
		int boat;
		States pred;
		
		States()
		{
			miss = 3;
			can = 3;
			boat = 0;
		}
		States (States s)
		{
			miss = s.miss;
			can = s.can;
			boat = s.boat;
			
		}
		States (int M, int C, int B)
		{
			miss = M;
			can = C;
			boat = B;
			
		}
		/*public boolean CheckValidState() {
			if (m >= 0 && m <= 3 && c >= 0 && c <= 3
		               && (m == 0 || m >= c)
		               && (m == 3 || m >= c)) {
				return true;
			}
			return false;
		}*/
		boolean CheckValidState ()
		{
			if (miss < 0 || miss > 3 || can < 0 || can > 3)
				return false;
			if ( 3 - miss < 0 || 3 - miss > 3 || 3 - can < 0 || 3 - can > 3)
				return false;
			if(miss > 0 && can > miss)
				return false;
			if(3 - miss > 0 && 3 - can > 3 - miss)
				return false;
			return true;
		}
		
		States transition(int Missionaries, int Cannibals)
		{
			States solution = new States(this);
			if(boat == 0)
			{
				solution.miss = miss - Missionaries;
				solution.can = can - Cannibals;
				solution.boat = 1;
			}
			else 
			{
				solution.miss = miss +Missionaries;
				solution.can = can + Cannibals;
				solution.boat = 0;
				
			}
			solution.pred = this;
			return solution;
		}


	void display()
	{
		//System.out.println("HI");
		System.out.println(" Missionaries "+ miss + " " +" Cannibals " + can + " " + " ---> "+ (boat == 0 ? 'L' : 'R'));
	}
	}
	
	public static void main(String[] args) {
		int ans = BreadthFirstSearch();
		System.out.println("Total " +ans+ " moves needed");

	}

}
