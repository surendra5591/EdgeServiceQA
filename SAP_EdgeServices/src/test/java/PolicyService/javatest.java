package PolicyService;

public class javatest {
	
	public static void main(String args[]) {
		String text= "i have a male cat. the color of male cat is Black";

				int c = 0;
				for (int j = 0; j < text.length(); j++) {
				    if (text.contains("male cat")) {
				        c += 1;
				    }
				    System.out.println(c);
				}
	}

}
