package com.shlee.web.exception;

public class NoArticleException extends Exception{

	String bidx;
	
	public NoArticleException(String bidx){
		super("BIDX not matched to an Article");
		this.bidx = bidx;
	}
	
	public String  exceptionInfo(){
		return "There's no such Article that contains board index :   "+bidx+" <br>Please try other board index..";
	}
	
}
