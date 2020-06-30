//Block structure for each component.

public class Block {

    private int dimension;
    private String colour;
    private int colourInt;
    private int positionZ;
    private int positionX;
    private int positionY;

    public Block(String col, int posZ, int posX, int posY) throws IllegalBlock{
        setColour(col);
        setPositionZ(posZ);
        setPositionX(posX);
        setPositionY(posY);
    }

    public Block(int col, int posZ, int posX, int posY) throws IllegalBlock{
        setColourInt(col);
        setPositionZ(posZ);
    }

    private void setColour(String c) throws IllegalBlock{
        if(c.isEmpty()|| c.isBlank()){
            throw new IllegalBlock("Illegal Colour");
        }else{
            colour = c;
        }
    }

    private void setPositionZ(int z) throws IllegalBlock{
        if(z>=0){
            positionZ = z;
        }else{
            throw new IllegalBlock("Illegal Z value");
        }
    }

    private void setPositionX(int x) throws IllegalBlock{
        if(x>=0){
            positionX = x;
        }else{
            throw new IllegalBlock("Illegal Z value");
        }
    }

    private void setPositionY(int y) throws IllegalBlock{
        if(y>=0){
            positionY = y;
        }else{
            throw new IllegalBlock("Illegal Z value");
        }
    }

    private void setColourInt(int co) throws IllegalBlock{
        if(co>0){
            colourInt = co;
        }else{
            throw new IllegalBlock("Illegal numerical colour");
        }
    }

    public int getPositionZ(){
        return positionZ;
    }

    public String getColour(){
        return colour;
    }

    public void setEmpty(){
        colour = "empty";
    }

    public int getColourInt(){
        return colourInt;
    }

    public int getPositionX(){
        return positionX;
    }

    public int getPositionY(){
        return positionY;
    }


}
