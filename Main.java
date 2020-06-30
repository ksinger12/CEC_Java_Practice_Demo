import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws IllegalBlock{

        Block x = new Block("red",3, 0,0);
        Block p = new Block(345,2,1,1);

        ArrayList<Block> stack = new ArrayList<>();
        stack.add(x);
        stack.add(p);
    }
}
