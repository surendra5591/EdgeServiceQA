package POC_TestCases;

import java.util.Stack;

public class javatest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Stack<String> stack = new Stack<String>();
		 

	}
	
	public boolean checkIfBalanced(String input){
		 boolean flag = true;
		 int len = input.length();
		 if(len/2==0)
		 flag = true;
		 else
			 flag = false;
		 return flag ;
		 
	 }

}
