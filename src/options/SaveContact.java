package options;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SaveContact extends CommonClass{
    private Scanner stringsScanner;
    private String fileName;
    public SaveContact(Scanner stringsScanner, String fileName){
        this.stringsScanner = stringsScanner;
        this.fileName = fileName;
    }

    public void saveContact() {
        StringBuffer sb = new StringBuffer();
        String[] input = {"name", "age", "phone number"};
        String[] pattern = {".", "\\A\\d+\\Z", "\\+?\\d+"};
        sb.append(getLastIndex(fileName) + ". ");
        for(int i=0; i < 3; i++) {
            String name = "";
            while(!verifyUserInput(name, pattern[i])) {
                System.out.printf("Enter contact's %s\n", input[i]);
                name = stringsScanner.nextLine();
            }
            sb.append(name.trim());
            if(i != 2) sb.append(", ");
        }
        sb.append("\n");
        appendStrToFile(getLastIndex(fileName), sb.toString());
    }

    private boolean verifyUserInput(String input, String patt) {
        Pattern pattern = Pattern.compile(patt);
        Matcher m = pattern.matcher(input);
        return m.find();
    }
    private void appendStrToFile(int index, String str)
    {
        File contactsFile = new File(fileName);
        if (!contactsFile.exists()) {
            try {
                contactsFile.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            // Open given file in append mode.
            BufferedWriter out = new BufferedWriter(
                    new FileWriter(fileName, true));
            if(index != 1) out.newLine();
            out.write(str.toString());
            out.close();
        }
        catch (IOException e) {
            System.out.println("exception occured" + e);
        }
        System.out.println("Contact saved. The file can be found in this project's root folder.");
    }
}
