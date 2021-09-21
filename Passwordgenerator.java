import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Passwordgenerator {

    public static void main(String[] args) {
        String password = "";
        Random randomNum = new Random();
        int specialCharacterCount = 1+randomNum.nextInt(3);
        int uppercaseCharacterCount=2 + randomNum.nextInt(4);
        int lowercaseCharacterCount = 1 + randomNum.nextInt(2);
        int lengthOfPassword = 14;
        int numberCount= lengthOfPassword-specialCharacterCount-uppercaseCharacterCount-lowercaseCharacterCount;
        char randomChar =(char)((int)'a'+Math.random()*((int)'z'-(int)'a'+1));
        String specialCharacter = "@#$%&";

        String password1 = generateLower(password,lowercaseCharacterCount);
        String password2 = generateNumber(password1,numberCount);
        String password3 = generateSpecial(password2,specialCharacterCount,specialCharacter);
        String password4 = generateUpper(password3,uppercaseCharacterCount);

        System.out.println(password4);
        System.out.println(shuffleString(password4));


    }

    public static String generateSpecial(String password,int specialCharacterCount,String specialCharacter){
        for (int i=0;i<specialCharacterCount;i++){
            Random randomNum = new Random();
            int number = 0 + randomNum.nextInt(specialCharacter.length());
            password += specialCharacter.charAt(number);
        }return password;
    }

    public static String generateUpper(String password,int uppercaseCharacterCount){
        for (int i = 0;i<uppercaseCharacterCount;i++){
            char randomUpperChar =(char)((int)'A'+Math.random()*((int)'Z'-(int)'A'+1));
            password += randomUpperChar;
        }return password;
    }

    public static String generateLower(String password, int lowercaseCharacterCount){
        for (int i = 0; i < lowercaseCharacterCount;i++){
            char randomLowerChar =(char)((int)'a'+Math.random()*((int)'z'-(int)'a'+1));
            password += randomLowerChar;
        }return password;
    }

    public static String generateNumber(String password, int numberCount){
        Random randomNum = new Random();
        for (int i = 0; i<numberCount;i++){
            int number = 0 + randomNum.nextInt(9);
            //password += "s";
            password += String.valueOf(number);
        }return password;
    }

    public static String shuffleString(String input) {
        List<String> result = Arrays.asList(input.split(""));
        Collections.shuffle(result);

        return result.stream().collect(Collectors.joining());
    }
}
