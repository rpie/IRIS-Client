package zeroday.command;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class mainCommands {

	public String name, discription, syntax;
	public List<String> aliases = new ArrayList<String>();
	
	public mainCommands(String name, String discription, String syntax, String... aliases) {
		this.name = name;
		this.discription = discription;
		this.syntax = syntax;
		this.aliases = Arrays.asList(aliases);
	}
	
	public abstract void onCommand(String[] args, String command);

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDiscription() {
		return discription;
	}

	public void setDiscription(String discription) {
		this.discription = discription;
	}

	public String getSyntax() {
		return syntax;
	}

	public void setSyntax(String syntax) {
		this.syntax = syntax;
	}

	public List<String> getAliases() {
		return aliases;
	}

	public void setAliases(List<String> aliases) {
		this.aliases = aliases;
	}
	
}
