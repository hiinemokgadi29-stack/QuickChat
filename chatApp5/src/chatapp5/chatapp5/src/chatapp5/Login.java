
 package chatapp5; 
 
public class Login { 
     
    //declaration of variables 
    //this variables are declared private meaning no one can access or make chhanges 
     
  String userPassword;  
String userUsername; 

private String firstName;
private String lastName;
private String username; 
private String password; 
 private String cellNumber; 
 
 Login() { 
      
 }     
  
 //this is the constructer which helps store 
public Login(String username, String password, String firstName, String lastName){  
this.userUsername = username;   
this.firstName = firstName;   
this.lastName = lastName;    
this.password  = password;  } 
 
     
  
  
     
     
     
     
public boolean checkUserName(String username) { 

// Logic for underscore and length <= 5   
return username != null && username.contains("_") && username.length() <= 5; 
      
}       public boolean checkPasswordComplexity(String password) { 
     
       return //password length     
               password.length() >=8 && 
            //check capital letter in the password         
               password.matches(".*[A-Z].*") &&             //password must contain a number     
               password.matches(".*[0-9].*") && 
            //password must have a speacial character           
               password.matches(".*[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?].*"); 
 //this is adpted from google I usedthe regex method cause I got it from goolge 
 //from this webtsite 
}     
//i got this method from goosgle 
public boolean checkCellPhoneNumber(String cellNumber){     //this methods checks if the number starts with +27 
    //and it also check if that after the number ther is a 6 ,7 or 8      
    String cellphoneCheck = "^(\\+27)[6-8][0-9]{1}[- ]?[0-9]{3}[- ]?[0-9]{4}$"; 
    //The regular expression as used to validated  
return cellNumber.matches(cellphoneCheck); 
 
  
} 
 
//this is the registration method 
//where if the methods abouve are met it returns certain messages 
public String registerUser(String username, String password){ 
         if(!checkUserName(username)){ 
        System.out.println("Username is not correctly formatted."); 
} 
     
  if(!checkPasswordComplexity(password)){ 

         System.out.println("Password does not meet complexity requirements."); 
        System.exit(0); 
  }   else{ 
 System.out.println ("the two above conditions have met , and the user have been registered successfully"); 
     
} 
     return""; 
   }      
     
 
//this method compare username and password entered during registration and during login 
public boolean loginUser(String username, String password,String userUsername,String userPassword){ 
    return userUsername.equals(username)&& userPassword.equals(password); 
} 
     
    public String firstName(){         return firstName; 
    }      
    public String lastName(){         return lastName; 
    } 
     
     
} 
 
 
 
 
         
      
      
      
      
     
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
