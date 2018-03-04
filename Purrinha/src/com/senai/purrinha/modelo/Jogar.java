package com.senai.purrinha.modelo;

public class Jogar {

private String voce;
private String voceTotal;


public Jogar(String voce, String voceTotal) {
	super();
	this.voce = voce;
	this.voceTotal = voceTotal;
}

public Jogar() {
	
}

public String getVoce() {
	return voce;
}

public void setVoce(String voce) {
	this.voce = voce;
}

public String getVoceTotal() {
	return voceTotal;
}

public void setVoceTotal(String voceTotal) {
	this.voceTotal = voceTotal;
}

public String toString(){
	return getVoce() + " - " + getVoceTotal();

}




















}

