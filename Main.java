import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    //introductory information and initial user input for square size
    Scanner input = new Scanner(System.in);
    System.out.println("\n"+"Welcome to Magic Square!" + "\n" + "\n"+"The goal is to use the integers (1) through (the number of squares inside your magic square) to make the sums of all the rows, columns, and diagonals equal the same number."+"\n");
    System.out.println("Please enter the side length of your magic square: ");
    int theSize = input.nextInt();
    MagicSquare obj = new MagicSquare(theSize);  
    System.out.println("\n"+"You will now choose numbers 1 - " + theSize*theSize +" ONCE to fill in the magic square");
    System.out.println("\n"+"***As you enter your integers, you will replaces the 0's"+"\n");

    //start timer
    long startTime = System.currentTimeMillis();

    //initiallizes the numbers inside the square using user input
    for(int i = 0; i < obj.square.length; i++) {
      for(int j = 0; j < obj.square[0].length; j++) {
        while(true) {
          System.out.println("\n"+"Enter an integer for row "+ (i + 1) +" / column " + (j + 1));
          int answer = input.nextInt();
          if(!(obj.numUsed(answer)) && answer >= 1 && answer <= theSize*theSize) {
            obj.changeSquare(i, j, answer);
            obj.storedVals.add(answer);
            obj.printSquare();
            break;
          } else if (obj.numUsed(answer)){
              System.out.println("You already used this number. Please choose a different number");
          } else {
              System.out.println("You must choose a number between 1 - " + theSize*theSize);

          }
        }
      }
    }

    //End the timer and store the amount of time taken, in seconds
    long durationInSeconds = (System.currentTimeMillis() - startTime) / 1000;
    int seconds = (int) (durationInSeconds + 0.5);

    //runs the computations
    obj.sumRows();
    obj.sumCols();
    obj.sumDiag();

    //Prints the time it took for the user to finish
    System.out.println("\n" + "This is how long you took: " + seconds + " seconds");
    System.out.println();

    //checks if sqaure is completed properly
    if(obj.checkFin()) {
      System.out.println();
      System.out.println("Congratulations on completing the Magic Square! You're definitely smarter than you were before. Try again, but this time with a different size square or a different solution to become even better at mental math." +"\nYou can try filling in your new square faster as well!");
    } else {
      System.out.println();
      System.out.println("Something seems to be wrong! Try again, this time check your work.");
    }
  }
}