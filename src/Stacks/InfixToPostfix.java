package src.Stacks;

import java.util.Stack;

public class InfixToPostfix {

    int prec(char ch)
    {
        switch (ch)
        {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;

            case '^':
                return 3;
        }
        return -1;
    }

    String infixToPostfix(String expr)
    {
        String result = "";
        Stack<Character> stack = new Stack<>();
        for(int i=0;i<expr.length();i++)
        {
            char c = expr.charAt(i);
            if(Character.isLetterOrDigit(c)) {
                result = result + c;
            }
            else if(c== '(') {
                stack.push('(');
            }
            else if(c== ')') {
                while (!stack.isEmpty() && stack.peek()!='(')
                    result = result + stack.pop();

                stack.pop();
            }
            else {
                while (!stack.isEmpty() && prec(c) < prec(stack.peek())){
                    result = result + stack.pop();
                }
                stack.push(c);
            }

        }

        // pop all the operators from the stack
        while (!stack.isEmpty()){
            if(stack.peek() == '(')
                return "Invalid Expression";
            result += stack.pop();
        }

        return result;
    }

    public static void main(String[] args) {
        InfixToPostfix obj = new InfixToPostfix();
        String result = obj.infixToPostfix("a+b*(c^d-e)^(f+g*h)-i");
        System.out.println(result);
    }
}
