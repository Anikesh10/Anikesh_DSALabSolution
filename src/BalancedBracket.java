import java.util.*;

public class BalancedBracket {

	static boolean areBracketsBalanced(String expr)
	{
		Deque<Character> stack
			= new ArrayDeque<Character>();

		for (int i = 0; i < expr.length(); i++)
		{
			char currentChar = expr.charAt(i);

			if (currentChar == '(' || currentChar == '[' || currentChar == '{')
			{
				// Push the element in the stack
				stack.push(currentChar);
				continue;
			}


			if (stack.isEmpty())
				return false;
			char check;
			switch (currentChar) {
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

		// Check Empty Stack
		return (stack.isEmpty());
	}

	
	public static void main(String[] args)
	{
		System.out.println("Please enter the strings to check brackets.");
		Scanner scan = new Scanner(System.in);
		String expr= scan.next();
		  

		if (areBracketsBalanced(expr)) {
			System.out.println("The entered String has Balanced Brackets.");
		} else {
			System.out.println("The entered Strings do not contain Balanced Brackets");
		}
		
		scan.close();
	}
}

