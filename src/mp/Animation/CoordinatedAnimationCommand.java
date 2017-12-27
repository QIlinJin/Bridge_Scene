package mp.Animation;

import mp.BridgeScene_Composite_Interfaces.Avatar;
import mp.ClearanceManager.BroadcastingClearanceManager;

public class CoordinatedAnimationCommand extends AnimatingCommand{

	CoordinatedAnimator cAni;
	
	
	
	public CoordinatedAnimationCommand(CoordinatedAnimator ANI, Avatar AV, BroadcastingClearanceManager BCM) {
		//super(ANI, AV, BCM);
		// TODO Auto-generated constructor stub
		super(ANI,AV,BCM);
		av = AV;
		bcm = BCM;
		cAni = ANI;
	}

	public void run() {
		// TODO Auto-generated method stub
		//ani.moveSlowly(av, numberOfInterval,animationPauseTime);
		bcm.waitForProceed();
		//ani.animateAvatar(av);
		cAni.animateAvatar(av, bcm);
		//bcm.proceed();
	}

	
	
	
}
