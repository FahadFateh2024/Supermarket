package Tools;

public  abstract class setPassword {
    public static String mypassword(char[] password){
        String p = "";
        for(char c : password){
            p += c;
        }
        return p;
    }
} // end of class
