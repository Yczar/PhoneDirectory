import constants.StringConst;
import options.*;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneDirectory {
	private Scanner sc = new Scanner(System.in);
	private Scanner stringsScanner = new Scanner(System.in);
	private String fileName = StringConst.FILENAME;

	//Calling each classes
	private SaveContact saveContact = new SaveContact(stringsScanner, fileName);
	private RetrieveAtIndex retrieveAtIndex = new RetrieveAtIndex(sc, fileName);
	private ReturnContactsAtIndex returnContactsAtIndex = new ReturnContactsAtIndex(sc, fileName);
	private GetContacts getContacts = new GetContacts(fileName);
	private GetSpecificCharacter getSpecificCharacter = new GetSpecificCharacter(stringsScanner, fileName);

	public Boolean getUserInput() throws IOException {
		System.out.println(StringConst.OPT_ONE);
		System.out.println(StringConst.OPT_TWO);
		System.out.println(StringConst.OPT_THREE);
		System.out.println(StringConst.OPT_FOUR);
		System.out.println(StringConst.OPT_FIVE);
		System.out.println(StringConst.OPT_SIX);
		System.out.println(StringConst.OPT_SEVEN);
		System.out.println(StringConst.OPERATIONTXT);
		int userInput = sc.nextInt();
		while(userInput > 7 || userInput < 1) {
			System.out.println(StringConst.OPERATIONTXT);
			userInput = sc.nextInt();
		}
		if(userInput == 7) { 
			System.out.println(StringConst.OPRTER);
			return false;
		}
		getMethods(userInput);
		return true;
	}



	private void getMethods(int choice) throws IOException {
		switch(choice) {
		case 1:
			saveContact.saveContact();
			break;
		case 2:
			retrieveAtIndex.retrieveAtIndex();
			break;
		case 3:
			returnContactsAtIndex.returnContactAtIndex();
			break;
		case 4:
			getContacts.getContacts();
			break;
		case 5:
			getSpecificCharacter.getSpecificCharacter();
			break;
		case 6:
			break;
		}
	}
}
