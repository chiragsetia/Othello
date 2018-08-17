package othelo;

public class Player {
private String name;
private int Symbol;
Player(String name,int Symbol)
{
	this.setName(name);
	this.setSymbol(Symbol);
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public int getSymbol() {
	return Symbol;
}
public void setSymbol(int symbol) {
	Symbol = symbol;
}
}