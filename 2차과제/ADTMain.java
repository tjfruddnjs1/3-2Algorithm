package Week_2_assignment;

import Counter.*;
import StdRandom.*;

public class ADTMain {
	//Flips
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int T = Integer.parseInt(args[0]);
		Counter heads = new Counter("heads");
		Counter tails = new Counter("tails");
		
		for(int i=0;i<T;i++) {
			if(StdRandom.bernoulli(0.5)) heads.increment();
			else tails.increment();
		}
		
		System.out.println(heads);
		System.out.println(tails);
		
		int d = heads.tally() - tails.tally();
		System.out.println("delta: " + Math.abs(d));
		
	}

}
