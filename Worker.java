import java.util.Arrays;
import java.util.Random;

public class Worker {
	boolean swap, hit;
	int reward, finalChoice;
	int[] doors;
	Random r;

	public Worker() {
		init();
		start();
//		startSwitch();
	}

	public void init() {
		hit = false;
		swap = false;
		reward = randomize();
		doors = new int[] { 0, 1, 2 };
		r = new Random();
	}

	public void start() {
			int fp = firstPick();
			System.out.println("init: reward v vratih "+ reward + "  doors = "+ Arrays.toString(doors)+ " pick = "+ fp);
			askAgain(reward, fp);
//			System.out.println(reward + "  " + fp + "  " + i);
			
		if(finalChoice == reward){
			hit = true;
		}
		System.out.println("HIT = "+ hit);
	}

	public int firstPick(){
//		if()
		return randomize();
	}
	public void secondPick(int[] doors){
		if(swap){
			System.out.println("TRUE 2nd pick: " + doors[1] 	);
			finalChoice = doors[1];
		}else{
			System.out.println("FALSE 2nd pick: " + doors[0] 	);
			finalChoice =  doors[0];
		}
	}
	
	public void askAgain(int reward,int choosen){
		int[] newDoor;
		if(choosen == reward){
			newDoor = sameDoor(choosen);
		}else{
			newDoor = differentDoor(choosen);
		}
		
		secondPick(newDoor);
	}
	
	public int[] sameDoor(int choosen){
		int[] tmp;
		if(choosen == 0){
			tmp = new int[] {0, r.nextInt(3)+1};
		}else if(choosen == 1){
			tmp = new int[] {1, 0};
		}else{
			tmp = new int[] {2, r.nextInt(2)};
		}
		System.out.println("Same:: reward = " + reward + " array = "+ Arrays.toString(tmp));
		return tmp;
	}
	public int[] differentDoor(int choosen){
		int[] tmp;
		if(choosen == 0){
			tmp = new int[] {0, reward};
		}else if(choosen == 1){
			tmp = new int[] {1, reward};
		}else{
			tmp = new int[] {2, reward};
		}
		System.out.println("Different:: reward = " + reward + " array = "+ Arrays.toString(tmp));
		return tmp;
	}

	public int randomize() {
		Random ra = new Random();
		int rand = ra.nextInt(3);
		return rand;

	}

}
