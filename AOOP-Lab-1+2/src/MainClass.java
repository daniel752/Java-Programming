import java.util.Iterator;
import java.util.Stack;

public class MainClass
{
    public static void main(String[] args)
    {
        Stack<Integer> stack = new Stack<Integer>();
        Stack1 stack1 = new Stack1();
        stack.push(1);
        stack.push(3);
        stack.push(9);
        stack.push(6);
        stack.push(4);
        stack.push(5);
        stack1.Push(1);
        stack1.Push(3);
        stack1.Push(9);
        stack1.Push(6);
        stack1.Push(4);
        stack1.Push(5);
        stack1.Push(10);
        stack1.Push(7);
        stack1.Push(1);
        stack1.Push(2);
        System.out.println(stack);
        stack1.ShowStack();
        System.out.println(getReverseStack(stack));
        getReverseStack(stack1).ShowStack();
        //System.out.println(getMaxStack(stack));
        //getMaxStack(stack1).ShowStack();
        //System.out.println(getEvenStack(stack));
        //getEvenStack(stack1).ShowStack();
    }

    //reversing the stack
    public static Stack<Integer> getReverseStack(Stack<Integer> s)
    {
        Stack<Integer> reverse_s = new Stack();
        while(!(s.isEmpty()))
            reverse_s.push(s.pop());
        return reverse_s;
    }

    //reversing the stack1
    public static Stack1 getReverseStack(Stack1 s)
    {
        Stack1 reverse_s = new Stack1();
        while(!(s.isEmpty()))
            reverse_s.Push(s.Pop());
        return reverse_s;
    }

    //putting the max element at top if stack
    public static Stack<Integer> getMaxStack(Stack<Integer> s)
    {
        int max = s.pop(),temp_elem;
        Stack<Integer> temp_s = new Stack();
        while(!(s.isEmpty()))
        {
            temp_elem = s.pop();
            if(temp_elem >= max)
            {
                temp_s.push(max);
                max = temp_elem;
            }
            else
                temp_s.push(temp_elem);
        }
        temp_s.push(max);
        return temp_s;
    }

    //putting the max element at top if stack1
    public static Stack1 getMaxStack(Stack1 s)
    {
        int max = s.Pop(),temp_elem;
        Stack1 temp_s = new Stack1();
        while(!(s.isEmpty()))
        {
            temp_elem = s.Pop();
            if(temp_elem >= max)
            {
                temp_s.Push(max);
                max = temp_elem;
            }
            else
                temp_s.Push(temp_elem);
        }
        temp_s.Push(max);
        return temp_s;
    }

    //returns a stack with even numbers only
    public static Stack<Integer> getEvenStack(Stack<Integer> s)
    {
        int temp;
        Stack<Integer> temp_s = new Stack<Integer>();
        while(!(s.isEmpty()))
        {
            temp = s.pop();
            if(temp % 2 == 0)
                temp_s.push(temp);
        }
        return temp_s;
    }

    //returns a stack1 with even numbers only
    public static Stack1 getEvenStack(Stack1 s)
    {
        int temp;
        Stack1 temp_s = new Stack1();
        while(!(s.isEmpty()))
        {
            temp = s.Pop();
            if(temp % 2 == 0)
                temp_s.Push(temp);
        }
        return temp_s;
    }
}
