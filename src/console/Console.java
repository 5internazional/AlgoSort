package console;

import java.util.Scanner;

public class Console {
    Scanner scan = new Scanner(System.in);
    public  int readInt(String text){
        int num;
        System.out.println(text);
        if (scan.hasNextInt()) {
            num = scan.nextInt();
            scan.nextLine();
            return num;
        }else
            return readInt(scan.next() + " is not a number. Try again");
    }

    public String readString(String text){
        String line;
        System.out.println(text);
        if (scan.hasNextLine()){
            line = scan.nextLine();
            return line;
        }else
            return readString(scan.next() + " is not readable. Try again");



    }

}
