package Interpeter;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import model.Interpeter.*;

public class Lexer {

	protected Scanner in;
	protected String delimiter;
	
	public Lexer() {
		this.in = new Scanner("");
		this.delimiter = null;
	}
	
	public Lexer(String data, String delimiter) {
		this.delimiter = delimiter;
		this.setData(data);
	}
	
	public Lexer(String data) {
		this.delimiter = null;
		this.setData(data);
	}
	
	public boolean hasNext() {
		return this.in.hasNext();
	}
	
	public void setData(String data) {
		this.in = new Scanner(data);
		if(this.delimiter != null)
			this.in.useDelimiter(data);
	}
	
	public Interpeter.Token next() {
		if(in.hasNextDouble())
			return new Interpeter.Token(in.nextDouble());
		return new Interpeter.Token(in.next());
	}
	
	public List<Interpeter.Token> getAllTokens() {
		List<Interpeter.Token> tokens = new LinkedList<>();
		
		while(this.hasNext()) {
			tokens.add(this.next());
		}
		
		return tokens;
	}
	
}
