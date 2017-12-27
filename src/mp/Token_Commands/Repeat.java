package mp.Token_Commands;
import mp.Token_Basic.Word;
import mp.Token_Commands_Interfaces.RepeatInterface;
import util.annotations.EditablePropertyNames;
import util.annotations.PropertyNames;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import util.annotations.Tags;
@Tags ({"Repeat"})
@StructurePattern(StructurePatternNames.BEAN_PATTERN) 
@PropertyNames({"Input", "Value"}) 
@EditablePropertyNames({"Input"})
public class Repeat extends Word implements RepeatInterface {

	
	public Repeat(String s) {
		super(s);
	}
	
}
