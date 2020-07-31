package options;

import constants.StringConst;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class GetSpecificCharacter extends CommonClass{
    private Scanner stringsScanner;
    private String fileName;
    public GetSpecificCharacter(Scanner stringsScanner, String fileName){
        this.stringsScanner = stringsScanner;
        this.fileName = fileName;
    }
    public void getSpecificCharacter() throws IOException {
        if(noContacts(fileName)) return;
        System.out.println(StringConst.SEARCHNAME);
        String identifier = stringsScanner.nextLine().trim();
        while(identifier.isEmpty()) {
            System.out.println(StringConst.SEARCHPATT);
            identifier = stringsScanner.nextLine();
        }
        boolean hasContact = false;
        try {
            BufferedReader in = new BufferedReader(
                    new FileReader(fileName));

            String mystring;
            while ((mystring = in.readLine()) != null) {
                if(mystring.split(",")[0].toLowerCase().contains(identifier.toLowerCase())) {
                    System.out.println(mystring);
                    hasContact = true;
                }
            }
            in.close();
        } catch (IOException e) {
            System.out.println(StringConst.NOFILE);
        }
        if(!hasContact) {
            System.out.println(StringConst.NOMATCH);
        }
    }
}
