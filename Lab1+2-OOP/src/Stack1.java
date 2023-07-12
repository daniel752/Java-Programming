public class Stack1
{
    private int top; //contains head of stack (the last element that was added to the array)
    private int[] data; //stores all elements of stack in array

    public Stack1()
    {
        top = -1;
        data = new int[10];
    }

    //pushing an element to the top of the stack
    public void Push(int element)
    {
        if(top == data.length)
        {
            int[] temp_data = new int[data.length + 5];
            for(int i=0;i< temp_data.length;i++)
                temp_data[i] = data[i];
            data = temp_data;
        }
        top++;
        data[top] = element;
    }

    //popping the top element from the stack
    int Pop()
    {
        return data[top--];
    }

    //returns the value of the stack's top
    int Top()
    {
        return this.data[top];
    }

    //returns true if stack isn't empty
    boolean isEmpty()
    {
        return top == -1;
    }

    //method to print stack1
    void ShowStack()
    {
        System.out.print("[");
        for(int i : this.data)
        {
            System.out.print(i+",");
        }
        System.out.println("\b]");
    }
}
