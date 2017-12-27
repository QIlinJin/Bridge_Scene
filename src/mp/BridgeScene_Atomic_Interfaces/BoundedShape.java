package mp.BridgeScene_Atomic_Interfaces;
import util.annotations.EditablePropertyNames;
import util.annotations.PropertyNames;
import util.annotations.Tags;
@PropertyNames({"x", "y","width","height"}) 
@EditablePropertyNames({"x","y","width","height"})
@Tags ({"BoundedShape"})

public interface BoundedShape extends Locatable{
	 public int getWidth();
	 public void setWidth(int newVal);
	 public int getHeight() ;
	 public void setHeight(int newVal);
}
