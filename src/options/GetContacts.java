package options;

import constants.StringConst;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class GetContacts extends CommonClass{
    String fileName;
    public GetContacts(String fileName){
        this.fileName = fileName;
    }
    public void getContacts() throws IOException {
        if(noContacts(fileName)) return;
        try {
            BufferedReader in = new BufferedReader(
                    new FileReader(fileName));

            String mystring;
            while ((mystring = in.readLine()) != null) {
                System.out.println(mystring);
            }
            in.close();
        }
        catch (IOException e) {
            System.out.println(StringConst.NOFILE);
        }
    }
}
