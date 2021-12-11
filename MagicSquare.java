import java.util.ArrayList;

class MagicSquare {
  private int size; 
  public int[][] square;
  public ArrayList<Integer> storedVals;
  public ArrayList<Integer> theSums; 
   
  //Constructor that makes the magic square
  public MagicSquare(int sizeIn) {
    size = sizeIn;
    square = new int[sizeIn][sizeIn]; 
    //Construct the magic square;
    for(int i = 0; i < square.length; i++) {
      for(int j = 0; j < square[i].length; j++) {
        square[i][j] = 0;
      }
    }
    printSquare();
    storedVals = new ArrayList<Integer>();
    theSums = new ArrayList<Integer>();
  }

  //Prints the magic square for the user
  public void printSquare() {
    System.out.println();
    for(int i = 0; i < square.length; i++) {
      for(int j = 0; j < square[i].length; j++) {
        System.out.print(square[i][j] + " ");
      }
      System.out.println();
    }
  }

  //Checks if the user input was already used
  public boolean numUsed(int num){
      for(Integer theNum: storedVals) {
        if(num == theNum) {
          return true;
        }
      }
    return false;
  }

  //Updates the square using the user's input
  public void changeSquare(int row, int column, int number) {
    square[row][column] = number;
  } 

  //Finds the sum of each row
  public void sumRows(){
    for (int i = 0; i < square.length; i++){
      int sum = 0;
      for(int j = 0; j < square[i].length; j++) {
        sum += square[i][j];
      }
      theSums.add(sum);
    }
  }

  //Finds the sum of each column
  public void sumCols(){
    for (int i = 0; i < square.length; i++){
      int sum = 0;
      for(int j = 0; j < square[i].length; j++) {
        sum += square[j][i];
      }
      theSums.add(sum);
    }
  }

  //finds the sum of each diagonal
  public void sumDiag(){
    int sum_One = 0;
    for(int i=0; i< square.length; i++){
      sum_One += square[i][i];
    }
    theSums.add(sum_One);
    int sum_Two = 0;
    for(int i = square.length-1; i >= 0; i--) {
      sum_Two += square[i][i]; 
    }
    theSums.add(sum_Two);
  }

  //Checks if the square is a magic square
  public boolean checkFin(){
    for(int i=0; i< theSums.size()-1; i++){
      if(theSums.get(i) == theSums.get(i+1)){
        continue;
      } else {
        return false;
      }
    }
    return true;
  }
}