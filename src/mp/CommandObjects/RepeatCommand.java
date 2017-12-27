package mp.CommandObjects;

import util.annotations.Tags;

@Tags ({"RepeatCommand"})
public class RepeatCommand implements Runnable {
	
	int times;
	Runnable R;
	
	public RepeatCommand(int t, Runnable r) {
		this.times = t;
		this.R = r;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i = 0;i<times;i++) {
			R.run();
		}
	}

}
