package mp.CommandObjects;

import mp.BridgeScene_Composite_Interfaces.Avatar;
import util.annotations.Tags;
@Tags ({"RotateLeftArmCommand"})
public class RotateLeftArmCommand implements Runnable {
	Avatar av;
	int rotateNum;
	
	public RotateLeftArmCommand(Avatar AV, int rn) {
		av = AV;
		rotateNum = rn;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		av.getArms().getLeftLine().rotate(rotateNum);
	}

}
