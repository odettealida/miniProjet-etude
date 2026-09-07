package com.example.demo.Exception;

public class ProduitNotFoundException extends RuntimeException {
	public ProduitNotFoundException (String message) {
		super(message);
	}

}
