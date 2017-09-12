import java.util.Scanner;
public class Program1{
    public static void main (String []args){
        Scanner scan = new Scanner(System.in);
        CharStack stack = new CharStack();
        System.out.println("Input your inxfix expression");
        String line = scan.nextLine();


        for (int x=0; x<line.length();x++){
            char variable = line.charAt(x);
            if (variable == '('){
                stack.push(variable);
            }else if (isOperand(variable)){
                System.out.print(variable);
            }else if (isOperator(variable)){
                while(stack.isEmpty()!=true &&
                      isOperator(stack.peek()) &&
                      precedenceOrder(stack.peek())>=precedenceOrder(variable)){
                    System.out.print(stack.pop());
                }
                stack.push(variable);
            }else if (variable == ')'){
                while (stack.peek() != '('){
                    System.out.print(stack.pop());
                }
                stack.pop();
            }
        }
        while(stack.isEmpty() == false){
            System.out.print(stack.pop());
        }
        System.out.println();
    }
    
    public static boolean isOperand(char c){
        if((c>='a' && c<='z') ||(c>='A' && c<='Z') ||(c>='0' && c<='9')){
            return true;
        }else{
            return false;
        }
    }
    
    public static boolean isOperator(char c){
        return c=='+' || c=='-' || c=='*' || c=='/';
    }

    public static int precedenceOrder(char c){
        if(c == '*' || c == '/' ){
            return 2;
        }else {
            return 1;
        }
    }
}