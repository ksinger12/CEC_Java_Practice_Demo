
public class IllegalBlock extends Exception{
    public IllegalBlock(){
        super("Block component is not valid");
    }

    public IllegalBlock(String e){
        super(e);
    }
}
