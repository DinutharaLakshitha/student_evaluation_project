
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
    
}
