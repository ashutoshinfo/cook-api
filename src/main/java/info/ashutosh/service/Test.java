package info.ashutosh.service;

import java.io.IOException;

public class Test {
	public static void main(String[] args) {
		try {
			throw new IOException("Hello");
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} catch (Exception e) {
			System.out.println("Caught a general exception: " + e.getMessage());
		}
	}
}
