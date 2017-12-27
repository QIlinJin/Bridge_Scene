package mp.Animation;

import mp.BridgeScene_Composite_Interfaces.Avatar;
import mp.ClearanceManager.BroadcastingClearanceManager;
import util.annotations.Tags;

public class CoordinatedAnimator extends Animator{
	int times = 3;
	//int intervalTime = 1;
	//BroadcastingClearanceManager bcm;
	
	@Tags ({"animateAvatar"})
	public synchronized void animateAvatar(Avatar a, BroadcastingClearanceManager bcm)  {
		for(int i = 0;i<times;i++) {
			a.move(100/times, 100/times);
			//Thread.sleep(100);
			bcm.waitForProceed();
			//sleep(intervalTime);
			
		}
	}
}
