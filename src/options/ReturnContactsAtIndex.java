package options;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class ReturnContactsAtIndex extends CommonClass{
    private Scanner sc;
    private String fileName;
    public ReturnContactsAtIndex(Scanner sc, String fileName){
        this.sc = sc;
        this.fileName = fileName;
    }
    public void returnContactAtIndex() throws IOException {
        if(noContacts(fileName)) return;
        System.out.println("Indexes start from 1");
        System.out.println("What index would you like to retrieve contacts from?");
        int startIndex = sc.nextInt();
        while(startIndex < 0) {
            System.out.println("That index is invalid. Enter a valid index");
            startIndex = sc.nextInt();
        }
        System.out.println("What index would you like to stop retrieving contacts from?");
        int endIndex = sc.nextInt();
        while(endIndex > getLastIndex(fileName)-1) {
            System.out.println("That index is invalid. Enter a valid index");
            endIndex = sc.nextInt();
        }
        try {
            BufferedReader in = new BufferedReader(
                    new FileReader(fileName));

            String mystring;
            int count = 0;
            int fileIndex = 0;
            while ((mystring = in.readLine()) != null) {
                count += 1;
                if(count > 2) {
                    fileIndex = (count/2) + 1;
                }else {
                    fileIndex = count;
                }
                if(fileIndex >= startIndex) {
                    System.out.println(mystring);
                    if(fileIndex > endIndex) break;
                }
            }
            in.close();
        }
        catch (IOException e) {
            System.out.println("Your file has not been created");
        }
    }
}
