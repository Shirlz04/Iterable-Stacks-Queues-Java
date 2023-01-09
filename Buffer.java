// A data type representing a text editor buffer.
public class Buffer {
    private Stack<Character> left;  // chars left of cursor
    private Stack<Character> right; // chars right of cursor
    private StringBuilder b;
    private int cursor;
    
    // Create an empty buffer.
    public Buffer() {
        b = new StringBuilder(100);
        cursor = 0;
        left = new Stack<Character>();
        right = new Stack<Character>();
    }

    // Insert c at the cursor position.
    public void insert(char c) {
        b.insert(cursor, c);
        cursor++;
    }
    
    // Delete and return the character at the cursor.
    public char delete() {
        char item = b.charAt(cursor);
        b.deleteCharAt(cursor);
        return item; 
    }

    // Move the cursor k positions to the left.
    public void left(int k) {
        cursor = cursor - k;
    }

    // Move the cursor k positions to the right.
    public void right(int k) {
        cursor = cursor + k;
    }

    // Return the number of characters in the buffer.
    public int size() {
        return b.length();
    }

    // Return a string representation of the buffer with
    // a "|" character (not part of the buffer) at the
    // cursor position.
    public String toString() {
        StringBuilder sb = new StringBuilder();
        int count;
        // Push chars from left into a temporary stack.
        count = cursor;
        for (int a = 0; a < count; a++) {
            left.push(b.charAt(a));
        }
            
        // Append chars from temporary stack to sb.
        while (!left.isEmpty()) {
            sb.append(left.pop());
        }
           
        // Append "|" to sb.
        sb.append('|');
        
        // Append chars from right to sb.
        
        for (int a = size() - 1; a >= count; a--) {
            right.push(b.charAt(a));
        }
        count = right.size();
        while (!right.isEmpty()) {
            sb.append(right.pop());
        }
            
        // Return the string from sb.
        return sb.toString();
    }
    
    // Test client (DO NOT EDIT).
    public static void main(String[] args) {
        Buffer buf = new Buffer();
        String s = "There is grandeur in this view of life, "
            + "with its several powers, having been originally "
            + "breathed into a few forms or into one; and that, "
            + "whilst this planet has gone cycling on according "
            + "to the fixed law of gravity, from so simple a "
            + "beginning endless forms most beautiful and most " 
            + "wonderful have been, and are being, evolved. ~ " 
            + "Charles Darwin, The Origin of Species";
        for (int i = 0; i < s.length(); i++) {
            buf.insert(s.charAt(i));
        }
        buf.left(buf.size());
        buf.right(97);
        s = "by the Creator ";
        for (int i = 0; i < s.length(); i++) {
            buf.insert(s.charAt(i));
        }
        buf.right(228);
        buf.delete();
        buf.insert('-');
        buf.insert('-');
        buf.left(342);
        StdOut.println(buf);
    }
}
