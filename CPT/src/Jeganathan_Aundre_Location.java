/**
 * File Name: Jeganathan_Aundre_Location
 * Name: Aundre Jeganathan
 * Description: creating a location class, that uses row and column as coordinates on a gird, or double array
 */
public class Jeganathan_Aundre_Location{
    private String name = "";
    private int row;
    private int column;

    //Accessor methods
    public String getName(){
        return name;
    }
    public int getRow(){
        return row;
    }
    public int getColumn(){
        return column;
    }

    //Mutator methods
    public void setName(String n){
        this.name = n;
    }
    public void setRow(int r){
        this.row = r;
    }
    public void setColumn(int c){
        this.column = c;
    }
}
