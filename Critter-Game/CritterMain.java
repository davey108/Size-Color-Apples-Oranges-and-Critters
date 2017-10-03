// Stuart Reges
// 9/6/00
//
// CritterMain provides method main for a simple simulation program.

public class CritterMain {
    public static void main(String[] args) {
        CritterFrame frame = new CritterFrame();

        frame.add(1, Bird.class);
        frame.add(1, Frog.class);
        frame.add(1, Mouse.class);
        frame.add(1, Turtle.class);
        frame.add(1, Wolf.class);

        frame.start();
    }
}
