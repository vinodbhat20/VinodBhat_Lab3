package com.gl.balancetest;

import java.util.*;

public class BalancedBrackets {

	public static void main(String[] args) {

		String s1 = "([[{}]])";
		System.out.println("The sample string 1 is " + s1);

		evalueteBrackets(s1);

		s1 = "([[{}]]))";
		System.out.println("The sample string 2 is " + s1);

		evalueteBrackets(s1);
	}

	private static void evalueteBrackets(String s1) {
		if (checkBalancedBrackets(s1))
			System.out.println("The entered String has Balanced Brackets ");
		else
			System.out.println("The entered Strings do not contain Balanced Brackets ");
	}

	static boolean checkBalancedBrackets(String str) {
		Stack<Character> stack = new Stack<Character>();
		for (int i = 0; i < str.length(); i++) {
			char x = str.charAt(i);
			
			if (x == '(' || x == '[' || x == '{') {
				stack.push(x);
				continue;
			}

			//nothing added,then no proper brackets
			if (stack.isEmpty())
				return false;

			//recent pop should be closing for innermost.
			char check;
			switch (x) {
			case ')':
				check = stack.pop();
				if (check == '{' || check == '[')
					return false;
				break;

			case '}':
				check = stack.pop();
				if (check == '(' || check == '[')
					return false;
				break;

			case ']':
				check = stack.pop();
				if (check == '(' || check == '{')
					return false;
				break;
			}
		}

		return (stack.isEmpty());
	}

}
