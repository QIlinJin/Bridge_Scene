package mp.CommandList;

import java.util.ArrayList;
import java.util.List;

import util.annotations.Tags;

@Tags ({"CommandList"})
public class CommandList implements Runnable{
	List<Runnable> commands = new ArrayList<Runnable>();
	public void add(Runnable r) {
		commands.add(r);
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(Runnable r : commands) {
			r.run();
		}
	}
	
}
