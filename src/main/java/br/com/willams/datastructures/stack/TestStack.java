package br.com.willams.datastructures.stack;

public class TestStack {
    public static void main(String[] args) throws Exception {
        String infixExpr = "(A+B)/(C+D)";
        
        boolean ok = isValidSymbolPattern(infixExpr);

        System.out.println("Expression \"" + infixExpr + "\" is OK? " + (ok ? " YES" : " NO"));

        var postfixExpr = infixToPostfix(infixExpr);

        System.out.println("Infix to Postfix: " + postfixExpr);
    }

    // a) cria uma pilha
    // b) para todos os chars faz
    //
    //        1) se char não é um símbolo, ignora
    //        2) se char é um open símbolo, push
    //        3) se char é um close símbolo, então se a pilha é vazia retorna false, senão pop
    //        4) se char popado é não correspondente ao símbolo, returna false
    //
    // c) se no final stack não é vazia, retorna false
    //
    // Time O(n) Space O(n) para stack
    private static boolean isValidSymbolPattern(String s) throws Exception {
        var stack = new LinkedStack<Integer>();
        
        for (int i = 0; i < s.length(); i++) {

            int ch = s.charAt(i);
           
            if(ch == ')') {
               
                if(!stack.isEmpty() && stack.peek() == '(') stack.pop();
               
                else return false;

            } else if (ch == ']') {
                
                if (!stack.isEmpty() && stack.peek() == '[') stack.pop();
                
                else return false;

            } else if (ch == '}') {
                
                if (!stack.isEmpty() && stack.peek() == '{') stack.pop();
                
                else return false;
                
            } else if(ch == '(' || ch == '[' || ch == '{') {
                stack.push(ch);
            }
            
        }

        return stack.isEmpty();
    }

    private static int priorityOf(int ch) {
        switch(ch) {
            case '+':
            case '-': return 1;
            case '*':
            case '/': return 2;
            case '^': return 3;
            default: return 0;
        }
    }

    public static String infixToPostfix(String expr) throws Exception {
        FixedSizeArrayStack stack = new FixedSizeArrayStack(100);
     
        var result = new StringBuilder();

        for (int i = 0; i < expr.length(); i++) {
            int ch = expr.charAt(i);
            
            if((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z')) {
                result.append((char)ch);
            } else if(ch == ')') {
                while(!stack.isEmpty() && stack.top() != '(') {
                    result.append((char)stack.top());
                    stack.pop();
                }

                if(!stack.isEmpty() && stack.top() == '(')
                    stack.pop();
            } else {
                while(!stack.isEmpty() && priorityOf(stack.top()) >= priorityOf(ch) && ch != '(') {
                    result.append((char)stack.top());
                    stack.pop();
                }
                stack.push(ch);
            }
        }

        while(!stack.isEmpty()) {
            result.append((char)stack.top());
            stack.pop();
        }

        return result.toString();
    }
}
