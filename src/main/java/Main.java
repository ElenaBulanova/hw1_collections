import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Main {
    static final int numberOfAttempts = 5; // количество попыток для одной коллекции
    static final int numberOfMethods = 7; //количество методов
    static int typeOfCollection = 1; //тип коллекции: 1 - ArrayList, 2 - LinkedList, 3 - Stack
    static ArrayList<Long> tempArr;

    public static void main(String[] args) throws IOException {

        int typeOfCollection = 1;

        startCountCol(100, "Collection ArrayList ", 1);
        startCountCol(2000, "Collection ArrayList ", 1);       //System.out.println(new AlImpl(2000).start());
        startCountCol(50000, "Collection ArrayList ", 1);
        System.out.println("=====================================================================");

        startCountCol(100, "Collection LinkedList ", 2);
        startCountCol(2000, "Collection LinkedList ", 2);
        startCountCol(50000, "Collection LinkedList ", 2);
        System.out.println("=====================================================================");

        startCountCol(100, "Collection Stack ", 3);
        startCountCol(2000, "Collection Stack ", 3);
        startCountCol(50000, "Collection Stack ", 3);
        System.out.println("=====================================================================");

    }

    private static void startCountCol(int num, String nameOfColl, int typeOfCollection) {
        System.out.println("**********\n" + nameOfColl + " for " + num + " elements. \n**********");
        long[][] arrForCount = new long[numberOfAttempts][numberOfMethods];  //матрица для подсчета ср.арифм.
        for (int i = 0; i <= (numberOfAttempts - 1); i++) {
            switch (typeOfCollection) {
                case (1):
                    tempArr = new AlImpl(num).start(); break;
                case (2):
                    tempArr = new LinkList(num).start(); break;
                case (3):
                    tempArr = new StackList(num).start(); break;
            }
            for (int j = 0; j <= (numberOfMethods - 1); j++) {
                arrForCount[i][j] = tempArr.get(j);
            }
            System.out.println("Attempt: " + (i + 1) + ":" + tempArr);
        }
        System.out.println();

//        for (int i = 0; i <= arrForCount.length - 1; i++) {  //вывод матрицы для подсчета ср.арифм.
//            for (int j = 0; j <= arrForCount[i].length - 1; j++) {
//                System.out.print(arrForCount[i][j] + " ");
//            }
//            System.out.println();
//        }

        for (int j = 0; j <= (numberOfMethods - 1); j++) {
            long sumForNextMeth = 0, avgForNextMeth = 0;
            for (int i = 0; i <= (numberOfAttempts - 1); i++) {sumForNextMeth += arrForCount[i][j];}
            avgForNextMeth = sumForNextMeth / numberOfAttempts;
            System.out.println("Average for " + (j + 1) + " method = " + avgForNextMeth);
        }
    }
}
