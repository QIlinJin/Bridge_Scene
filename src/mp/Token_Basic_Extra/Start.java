package mp.Token_Basic_Extra;
import mp.Token_Basic.Token;
import util.annotations.EditablePropertyNames;
import util.annotations.PropertyNames;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import util.annotations.Tags;
@Tags ({"Start"})
@StructurePattern(StructurePatternNames.BEAN_PATTERN) 
@PropertyNames({"Input"}) 
@EditablePropertyNames({"Input"})
public class Start extends Token implements StartInterface {
	//public String Input="{";
	public Start(String s) {
		super(s);
	}
	

}
