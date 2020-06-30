import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Row;


public class Environment {

    /*
    In order to read the excel doc correctly, I believe that one cell at a time will need to be read in
    recognizing the position we are at at each time and filling up a two dimensional arrayList. We will also need
    some form of a blank block, something that represents an empty space (perhaps a grey block or where the colour is empty).
     */

    private ArrayList<ArrayList<Block>> matrix = new ArrayList<>(); //this will be the 2D arrayList
    //Use .add() to add each component from the excel

    public Environment(String doc) throws IllegalBlock{
        setMatrix(doc);
    }

    private void setMatrix(String d){
        try{
            FileInputStream file = new FileInputStream(new File(d));
            XSSFWorkbook book = new XSSFWorkbook(file); //creating workbook instance
            XSSFSheet sheet = workbook.getSheetAt(0); //desired sheet from workbook
            Iterator<Row> rowIterator = sheet.iterator();

            while(rowIterator.hasNext()){ //iterate through each row one by one
                Row row = rowIterator.next();
                Iterator<Cell> cellIterator = row.cellIterator();

                while(cellIterator.hasNext()){
                    Cell cell = cellIterator.next();

                    String temp = cell.getStringCellValue();
                    String[] t = temp.split(",");
                    //now here I would have to know the format of the cells to know which is colour, position etc.\
                }
            }

            file.close();

        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public ArrayList<ArrayList<Block>> getMatrix(){
        return matrix;
    }

}
