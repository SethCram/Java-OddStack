/* Seth Cram
 * CS210: OddStack.java
 *
 * Create a file called OddStack.Java. in it create a class OddStack.
 * 
 *   OddStack must have 3 methods:
 *    public void push(int e)
 *    public int pop()
 *    @Override  (not required but helps prevent errors)
 *    public String toString()
 *
 * OddStack is like most stacks. It takes in integers. The first integer
 *  pushed in is the last one popped out, but OddStack has one odd feature:
 *  all the odd integers that are pushed (like 5, 37 or 1) get popped before
 *  any even integer get popped even if an even integer is pushed after the
 *  odd ones. Other than that it maintains the order. 
 * The toString method prints out the elements in the form
 *  [e1, e2, ... en], but it prints them in the order they would be popped
 *  (not the order that they were pushed).
 * You are free to implement your OddStack any way you want, as long as
 *  you do not use a Stack library from Java.
 * The stack itself holds 10 elements. If you try to push to a full stack
 *  it must give the error:
 *   Error: OddStack is full
 * If you try to pop form a stack that is empty it must give the error:
 *   Error: OddStack is empty
 * Beyond that they only other thing that it should print is a confirmation
 *  when you push an element. 
 *  For example push(35) should report:
 *   Pushing: 35
 * Remember, you have limited space for compiling and running your program,
 *  so do not make your class too complex.
 *
 *  Compile: javac -J-Xmx10m -J-Xms5m OddStack.java
 *  Run: java -Xmx10m -Xms5m W11Main
 *
 *
 * Running with "Driver" in place of "W11Main" automatically calls main
 *  found in ur class
 */

public class OddStack {
    private int max_depth; // max size of stack
    private int ocurr_depth; //present size of odd array
    private int ecurr_depth; //present size of even array
    private int[] oddArray = new int[11];//use curr_depth to access
                                           // syntax for creating int array
    private int[] evenArray = new int[11];
    
    public OddStack(){
	ocurr_depth = 0; //automatically sets oddstack objs with odd array depth = 0
	ecurr_depth = 0; //automatically sets oddstack objs with even array depth = 0
	max_depth = 10; //automatically sets oddstack objs with max stack depth = 10
    }

    public void push(int num){
	System.out.println("Pushing: " + num); //syntax for print
	                                       //var+string
	if( ecurr_depth + ocurr_depth == 10 ){ 
	    System.out.println("Error: OddStack is full");
	}
	else{
	    
	    if( num % 2 == 1 ){ //if number is odd
		ocurr_depth++; //add 1 to odd depth
		oddArray[ocurr_depth] = num;
	    }else{         //if # is even
		ecurr_depth++; //adds 1 to even depth
		evenArray[ecurr_depth] = num;
	    }
	}
    }

    public int pop(){
	if( ecurr_depth + ocurr_depth == 0 ){
	    System.out.println("Error: OddStack is empty");
	    return 0; //to signify error
	} 
	else{
	    int popped_num; //placeholder to decrement odd and even depth
	    if( ocurr_depth != 0 ){ //if still odd numbers left
		popped_num = ocurr_depth; 
		ocurr_depth--; //decrement odd depth
		return oddArray[popped_num];
	    } else{                 //else, only even numbers left
		popped_num = ecurr_depth;
		ecurr_depth--;
		return evenArray[popped_num];
	    }
	}
    }

    //returns stack from right to left in list[] form, rightmost number is top
    // of stack
    @Override 
    public String toString(){
	// new total array to hold combined even and odd arrays to return 
	int totArraySize = ocurr_depth+ecurr_depth; //needed for the for loop
	int[] totArray = new int[totArraySize];

	//both placeholders
	int oddPH = ocurr_depth; 
	int evenPH = ecurr_depth;

	while( oddPH + evenPH > 0 ){ //even and odd arrays aren't both empty
	    if( oddPH > 0 ){ //odd array not empty
		totArray[oddPH+evenPH-1] = oddArray[oddPH]; //have to subtract
		        // -1 bc if totArray[0] not overwritten, outputs a 0
		oddPH--; //copied over and decremented
	    }else if (evenPH > 0) { //just else works too
		totArray[evenPH-1] = evenArray[evenPH];
		evenPH--;
	    }
	}
	String completeList = "["; //'String' is capitalized
	for(int i = 0; totArraySize > i; i++){
	    completeList = completeList + totArray[i];
	    if( i != totArraySize-1){
		completeList = completeList + ",";
	    }
	}
	completeList = completeList + "]";
	return completeList;
    }
}

//OddStack estack = new OddStack();
