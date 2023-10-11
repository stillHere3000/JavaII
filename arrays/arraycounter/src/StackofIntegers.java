

public class StackofIntegers {
    private int[] elements;
    private int size;
    private static final int DEFAULT_CAPACITY = 0;

    /** Construct a stack with the default capacity 16 */
    public StackofIntegers() {
        //this(1);
        size= 0;
        //elements[0]= 0; 
    }

    /** Construct a stack with the specified maximum capacity */
    public StackofIntegers(int capacity) {
        elements = new int[capacity];
    }

    /** Push a new integer into the top of the stack */
    public void push(int value) {
        if( this.empty()){
            elements = new int[1];
            elements[0]= value;
            size++;
            return;
        }
        else {
            if (size >= elements.length) {
                int[] temp = new int[elements.length * 2];
                System.arraycopy(elements, 0, temp, 0, elements.length);
                elements = temp;
                elements[size++] = value;
            }
        }        
    }

    /** Return and remove the top element from the stack */
    public int pop() {
        if( !this.empty()){
            return elements[--size];
        }
        return 0;
            //return elements[0];
        //}
        //else{
        
        //}
    }

    /** Return the top element from the stack */
    public int peek() {
        return elements[size - 1];
    }

    
    /** Test whether the stack is empty */
    public boolean empty() {
        return size == 0;
    }

    /** Return the number of elements in the stack */
    public int getSize() {
        return size;
    }
}
