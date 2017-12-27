package mp.Table;

import java.util.ArrayList;
import java.util.List;

import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import util.annotations.Tags;
@Tags ({"Table"})
@StructurePattern(StructurePatternNames.MAP_PATTERN)
public class ATable<T> implements Table<T> {
	public ArrayList<String> a1 = new ArrayList<String>();
	ArrayList<Object> a2 = new ArrayList<Object>();
	@Override
	public void put(String key, T val) {
		// TODO Auto-generated method stub
		if(a1.contains(key)) {
			a2.add(a1.indexOf(key), val);
		}
		else {
			a1.add(key);
			a2.add(val);
		}
		
		
	}

	@Override
	public T get(String key) {
		// TODO Auto-generated method stub
		
		if(a1.contains(key)) {
			int index = a1.indexOf(key);
			
			return (T)a2.get(index);
			
		}
		else
			return null;
	}

	public List getList() {
		// TODO Auto-generated method stub
		return a1;
	}

	
	

}
