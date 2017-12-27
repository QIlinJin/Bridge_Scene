package mp.Table;

import java.util.ArrayList;
import java.util.List;

import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import util.annotations.Tags;
@Tags ({"Table"})
@StructurePattern(StructurePatternNames.MAP_PATTERN)
public interface Table<T> {
	public List getList() ;
	public void put (String key, T val);
	public T get (String key);
}
