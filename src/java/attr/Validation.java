
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attr;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Dinuthara
 */
public class Validation {
    
    public boolean onlyLettersSpaces(String s){
  for(int i=0;i<s.length();i++){
    char ch = s.charAt(i);
    if (Character.isLetter(ch) || ch == ' ') {
      continue;
    }
    return false;
  }
  return true;
}
    
 public  boolean addressValidation(String address) {
String regex;
regex = "^[a-zA-Z0-9.-/s]+$";
String pattern = null;
Pattern r = Pattern.compile(pattern); 
Matcher m = r.matcher(address);
 
if(m.find()) {
 return true;
} else {
 return false;
}
}
 
     public boolean onlyLettersSpacesdot(String s){
  for(int i=0;i<s.length();i++){
    char ch = s.charAt(i);
    if (Character.isLetter(ch) || ch == ' ' || ch =='.') {
      continue;
    }
    return false;
  }
  return true;
}
     
          public boolean onlyInitials(String s){
  for(int i=0;i<s.length();i++){
    char ch = s.charAt(i);
    if (Character.isUpperCase(ch) || ch =='.') {
      continue;
    }
    return false;
  }
  return true;
}
              public boolean onlyLetters(String s){
  for(int i=0;i<s.length();i++){
    char ch = s.charAt(i);
    if (Character.isLetter(ch)) {
      continue;
    }
    return false;
  }
  return true;
}
              public  boolean isNumeric(String str)
{
    for (char c : str.toCharArray())
    {
        if (!Character.isDigit(c)) return false;
    }
    return true;
}
                public boolean onlyLettersSpacesslash(String s){
  for(int i=0;i<s.length();i++){
    char ch = s.charAt(i);
    if (Character.isLetter(ch) || ch == '/' || Character.isDigit(ch)) {
      continue;
    }
    return false;
  }
  return true;
}
 
                private Pattern pattern;
    private Matcher matcher;
    private static final String PASSWORD_PATTERN = "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,20})";
    /**
     * Validate password with regular expression
     * @param password password for validation
     * @return true valid password, false invalid password
     */
    public boolean validatePasswordStrong(final String password){
            pattern = Pattern.compile(PASSWORD_PATTERN);
            matcher = pattern.matcher(password);
            return matcher.matches();

    }
}
