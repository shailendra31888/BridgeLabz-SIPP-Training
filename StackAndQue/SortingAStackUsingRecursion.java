import java.util.Stack;

public class SortingAStackUsingRecursion {

    // Main recursive function to sort the stack
    public static void sortStack(Stack<Integer> stack) {
        if (!stack.isEmpty()) {
            int top = stack.pop();
            sortStack(stack); // Recursively sort the remaining stack
            insertInSortedOrder(stack, top); // Insert the popped element in sorted order
        }
    }

    // Helper method to insert an element into the sorted stack
    private static void insertInSortedOrder(Stack<Integer> stack, int element) {
        // Base case: insert element if stack is empty or top element is smaller
        if (stack.isEmpty() || stack.peek() <= element) {
            stack.push(element);
        } else {
            int temp = stack.pop();
            insertInSortedOrder(stack, element); // Recursive call
            stack.push(temp); // Push back the removed element
        }
    }

    // Main method to test the sorting
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(30);
        stack.push(10);
        stack.push(50);
        stack.push(20);
        stack.push(40);

        System.out.println("Original Stack: " + stack);
        sortStack(stack);
        System.out.println("Sorted Stack:   " + stack);
    }
}
