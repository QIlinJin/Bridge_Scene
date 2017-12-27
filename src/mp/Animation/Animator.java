package mp.Animation;



import mp.BridgeScene_Composite_Interfaces.Avatar;
import util.annotations.Tags;
@Tags ({"Animator"})
public class Animator {
	
	int times = 3;
	int intervalTime = 1;
	
	@Tags ({"animateAvatar"})
	public synchronized void animateAvatar(Avatar a)  {
		for(int i = 0;i<times;i++) {
			a.move(100/times, 100/times);
			//Thread.sleep(100);
			
			sleep(intervalTime);
		}
	}
	
	
	public static void sleep(long interval) {
		try {
			Thread.sleep(interval);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
