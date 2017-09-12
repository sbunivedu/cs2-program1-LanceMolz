public class CharStack
{
    private final int MAX_CAP = 100;
    private int top;
    private char[] s;
    
    public CharStack(){
    s= new char [MAX_CAP];
    top= -1;
    }

    public void push (char element){
    top++;
    s[top] = element;
    }
    
    public char peek(){
    return s[top];
    }
    
    public char pop (){
    char result = s[top];
    top--;
    return result;
    }
    
    public boolean isEmpty()
    {
        if(top>-1){
            return false;
        }else return true;
    }
    
    public boolean isFull()
    {
        if (top == MAX_CAP-1){
            return true;
        }else return false;
    }
    
    public String toString()
    {
        String array = "";
        for (int x=top; x<top +1; x++){
            array +=s[x];
        }
        return array;
    }
}