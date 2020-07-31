package options;

import constants.StringConst;

import java.io.*;

public class CommonClass {

    protected int getLastIndex(String fileName) {
        int nextIndex = 1;
        try {
            BufferedReader in = new BufferedReader(
                    new FileReader(fileName));

            String mystring = new String();
            while ((mystring = in.readLine()) != null) {
                nextIndex += 1;
            }
            in.close();
        }
        catch (IOException e) {
            System.out.println(e.getStackTrace());
        }
        if(nextIndex > 2) nextIndex = (nextIndex/2) + 1;
        return nextIndex;
    }

    protected Boolean noContacts(String fileName) throws IOException {
        File contactsFile = new File(fileName);
        if(contactsFile.exists()) {
            BufferedReader in;
            try {
                in = new BufferedReader(
                        new FileReader(fileName));
                String string;
                if((string = in.readLine()) == null || !contactsFile.exists()) {
                    System.out.println(StringConst.NOCONTACTS);
                    return true;
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

}
