import java.util.ArrayList;

public class Drone {

    private static Environment solution;
    private static Environment scrambled;
    private int storageSize;
    public static ArrayList<ArrayList<Block>> matrix;
    public static int[] currentPos = {0,0}; //row index, column index of current position
    public static ArrayList<Block> emptySpace = new ArrayList<>();
    public static ArrayList<Block> correctZ0 = new ArrayList<>();
    public static ArrayList<Block> unknown = new ArrayList<>();
    private static ArrayList<Block> storage;


    public Drone(int storage, Environment sol, Environment scram) throws IllegalBlock{
        setStorageSize(storage);
        setEnvironmentSolution(sol);
        setEnvironmentScrambled(scram);
        matrix = scrambled.getMatrix();
    }

    private void setEnvironmentSolution(Environment s){
        try{
            solution = s;
        }catch(Exception e){ //not sure the type of error I should be expecting here
            e.printStackTrace();
        }
    }

    private void setEnvironmentScrambled(Environment sc){
        try{
            scrambled = sc;
        }catch(Exception e){ //not sure the type of error I should be expecting here
            e.printStackTrace();
        }
    }

    private void setStorageSize(int storage) throws IllegalBlock{
        if(storage > 0){
            storageSize = storage;
        }else{
            throw new IllegalBlock("Illegal Storage Size");
        }
    }

    public void moveRight(){
        if(matrix.size() < currentPos[0]){
            currentPos[0]++;
        }else{
            currentPos[0] = 0;
            moveDown();
        }
    }

    public void moveLeft(){
        if(currentPos[0] > 0){
            currentPos[0]--;
        }else{
            currentPos[0] = matrix.size();
            moveUp();
        }
    }

    public boolean moveUp(){
        if(currentPos[1] > 0){
            currentPos[1]--;
            return true;
        }else{
            return false;
        }
    }

    public boolean moveDown(){
        if(currentPos[1] < matrix.get(0).size()){
            currentPos[1]++;
            return true;
        }else{
            return false;
        }
    }

    public Block getCurrentBlock(){
        return matrix.get(currentPos[0]).get(currentPos[1]);
    }

    public void addEmptySpace(Block b){
        emptySpace.add(b);
    }

    public void addCorrecZ(Block b){
        correctZ0.add(b);
    }

    public void addUnknown(Block b){
        unknown.add(b);
    }

    public boolean store(Block b){
        if(storage.size() < storageSize){
            storage.add(b);
            Block temp = matrix.get(currentPos[0]).get(currentPos[1]);
            temp.setEmpty();
            matrix.get(currentPos[0]).set(currentPos[1],temp);
            return true;
        }
        return false;
    }

    public boolean deploy(String colour){ //the colour of block we want
        Block temp;
        for(int i=0; i<storageSize; i++){
            if(colour == storage.get(i).getColour()){
                temp = storage.get(i);
                storage.remove(i);
                matrix.get(currentPos[0]).set(currentPos[1],temp); //I think this works...
                return true;
            }
        }
        return false;
    }

}
