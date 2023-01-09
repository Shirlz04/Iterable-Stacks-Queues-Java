public class Subset {
    public static void main(String[] args) {
        ResizingArrayRandomQueue q = new ResizingArrayRandomQueue();
        int N = Integer.parseInt(args[0]);
        while (!StdIn.isEmpty()) {
            q.enqueue(StdIn.readString());
        }
        for (int a = 0; a < N; a++) {
            StdOut.println(q.dequeue());
        }
    }
}
