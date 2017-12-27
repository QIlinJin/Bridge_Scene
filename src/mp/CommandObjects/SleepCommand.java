package mp.CommandObjects;

import util.annotations.Tags;
import util.misc.ThreadSupport;
@Tags ({"SleepCommand"})
public class SleepCommand implements Runnable {

	long sleepTime;
	
	public SleepCommand(long sl) {
		sleepTime = sl;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		ThreadSupport.sleep(sleepTime);
	}

}
