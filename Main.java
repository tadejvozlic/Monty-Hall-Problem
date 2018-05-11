
public class Main {
	public static int hits = 0, hitsSwap = 0;
	
	public static void main(String[] args) {
		for(int i = 0; i< 1000; i++){
			Worker w = new Worker();
			WorkerSwap w2 = new WorkerSwap();
			if(w.hit){
				hits++;
			}
			if(w2.hit){
				hitsSwap++;
			}
		}
		System.out.println("hits = "+ hits );
		System.out.println("hits SWAP = "+ hitsSwap);

	}
	
}
