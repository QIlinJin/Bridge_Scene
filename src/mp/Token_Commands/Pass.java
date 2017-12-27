package mp.Token_Commands;
import mp.Token_Basic.Word;
import mp.Token_Commands_Interfaces.PassInterface;
import util.annotations.EditablePropertyNames;
import util.annotations.PropertyNames;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import util.annotations.Tags;
@Tags ({"Pass"})
@StructurePattern(StructurePatternNames.BEAN_PATTERN) 
@PropertyNames({"Input", "Value"}) 
@EditablePropertyNames({"Input"})
public class Pass extends Word implements PassInterface {


	public Pass(String s) {
		super(s);
	}
	
}
