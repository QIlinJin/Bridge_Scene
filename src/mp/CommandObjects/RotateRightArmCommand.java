package mp.CommandObjects;

import mp.BridgeScene_Composite_Interfaces.Avatar;
import util.annotations.Tags;
@Tags ({"RotateRightArmCommand"})
public class RotateRightArmCommand implements Runnable {

	Avatar av;
	int rotateNum;
	
	public RotateRightArmCommand(Avatar AV, int rn) {
		av = AV;
		rotateNum = rn;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		av.getArms().getRightLine().rotate(rotateNum);
	}

}
