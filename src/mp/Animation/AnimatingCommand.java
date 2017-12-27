package mp.Animation;

import mp.BridgeScene_Composite_Interfaces.Avatar;
import mp.ClearanceManager.BroadcastingClearanceManager;
import util.annotations.Tags;
@Tags ({"AnimatingCommand"})
public class AnimatingCommand implements Runnable{

	Animator ani;
	Avatar av;
	int numberOfInterval;
	int animationPauseTime;
	BroadcastingClearanceManager bcm;
	
	public AnimatingCommand(Animator ANI, Avatar AV, BroadcastingClearanceManager BCM) {
		ani = ANI;
		av = AV;
		bcm = BCM;
	}
	
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		//ani.moveSlowly(av, numberOfInterval,animationPauseTime);
		bcm.waitForProceed();
		ani.animateAvatar(av);
		//bcm.proceed();
	}

}
