package it.micra.testgit;

public class Test1 {
	
	public static void main(String[] args) {
		
		for (int i = 0; i < Utility.getCount(); i++) {
			System.out.println(Utility.getTitle()+" - " + i + "!");
		}
		System.out.println("terminato");
		
	}

}
