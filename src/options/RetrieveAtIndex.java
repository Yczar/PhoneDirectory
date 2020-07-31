package options;

import constants.StringConst;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class RetrieveAtIndex extends CommonClass{
    private Scanner sc;
    private String fileName;
    public RetrieveAtIndex(Scanner sc, String fileName){
        this.sc = sc;
        this.fileName = fileName;
    }
    public void retrieveAtIndex() throws IOException {
        if(noContacts(fileName)) return;
        System.out.println("Indexes start from 0");
        System.out.println("What index would you like to a retrieve contact from?");
        int contactIndex = sc.nextInt();
        while(contactIndex < 0 || contactIndex > getLastIndex(fileName)-1) {
            System.out.println("That index is invalid. Enter a valid index");
            contactIndex = sc.nextInt();
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
                if(fileIndex == contactIndex) {
                    System.out.println(mystring);
                }
            }
            in.close();
        }
        catch (IOException e) {
            System.out.println(StringConst.NOFILE);
        }
    }
}
