package chatapp5;
  import java.util.Random;
 import java.util.ArrayList; 
import java.util.List; 
 
import java.util.UUID; 
 
 
//this is where we import our scanner class to be able to read the user input
import java.util.Scanner; 
 
public class Chatapp5 { 
    
    public static void main(String[] args) {          
 /*after importing the scanner class we create a  
 variable called input which reads and stores what the user enters in the variable*/ 
Scanner input = new Scanner(System.in);
  boolean loginSuccessful = false; 
//creating an object allowas us to clink the login classs with the main class 
//here we called the oject = myobject 
       Login myobject = new Login(); 
         
        Random rand = new Random(); 
 
//this is where we promt the user 
//since this is registration part we display to the user that  they are registering 
 
System.out.println("***************** REGISTRATION***************** "); 
 
 
 System.out.print("Enter your firstname:"); 
 String userFirstName = input.nextLine(); //declaration of variable plus storing         
 System.out.print("Enter your Lastname:"); 
 String userLastName =input.nextLine(); 
  

 System.out.print("Create a username:"); 
 String userUsername = input.nextLine(); 
  
  
/*here we called a method from the login class that  checks if the username entered matches the conditions needed*/
boolean usernameCheck = myobject.checkUserName(userUsername); if (usernameCheck == true){ 
    System.out.println("Username successfully captured."); 
   } else{ 
    System.out.println("Username is not correctly formatted;please ensure that "  
            + "your username  contains an underscore and no more that five character in length."); 
     
                 } 
  
         
 System.out.print("Create a password of your choice:");  String userPassword = input.nextLine(); 
  
 /*here we called a method from the login class that  checks if the password entered matches the conditions needed*/ 
  
 boolean passwordCheck = myobject.checkPasswordComplexity(userPassword); 
 if(passwordCheck == true){ 
 System.out.println("Password successfully captured.");           
 } else{ 
 System.out.println("Password is not correctly formatted; please ensure that"             
         + " the password contains at least eight characters, capital letter, a number, and a special character.");  } 
 System.out.print("Enter a SouthAfrican Cellphone Number:"); 
 String userPhoneNumber = input.nextLine(); 
  
  
 /*here we called a method from the login class that  checks if the cellphone entered matches the conditions needed */ 
  
 boolean phonenumberCheck = myobject.checkCellPhoneNumber(userPhoneNumber); 

 if (phonenumberCheck == true){ 
 System.out.println("Cell Phone Number successfully added."); 
 } else{ System.out.println("cell phone number incorrectly formatted " 
                        + "or does not contain international code"); 
} 
            
 String result = myobject.registerUser(userUsername, userPassword); 
  System.out.println(result);  
  if(result.equals("User sucessfully registered")){ 
     //stops everything the user from login if the registration is invaild 
    } 
 
      //if the method above is true the system will output the login feature  
       while(!loginSuccessful) {   
    System.out.println("***********Login************");    
        
               System.out.print("Enter username: "); 
 
     String username = input.nextLine(); 
                     
                System.out.print("Enter password: "); 
     String password = input.nextLine();         
     //this a method that compared input from user entered during registration and login  
     //if conditions met the system will output the messages    
        loginSuccessful = myobject.loginUser(username, password,userUsername,userPassword);  
            if(loginSuccessful){ 
         System.out.println("Login successful!"); 
         System.out.println("WELCOME TO QUICK CHAT"); 
            Scanner keyboard = new Scanner(System.in);   
            
                  int menuChoice = 0; 
        List<MessageClass> sessionMessages = new ArrayList<>(); 
 
        System.out.print("How many messages do you want to enter? ");   
              int maxMessageLimit = keyboard.nextInt();    
             keyboard.nextLine(); // Clear scanner buffer 
 
        int currentMessageCount = 0; 

 
        while (menuChoice != 3 ) { 
            System.out.println("\n========================================="); 
            System.out.println("              QUICKCHAT MENU             "); 
            System.out.println("========================================="); 
            System.out.println("1) Send Messages"); 
            System.out.println("2) Show recently sent messages"); 
            System.out.println("3) Quit"); 
            System.out.print("Enter choice: "); 
             
            if (keyboard.hasNextInt()) {        
                         menuChoice = keyboard.nextInt();  
                                        keyboard.nextLine(); // Clear scanner buffer 
            } else { 
                System.out.println("Invalid input. Please enter a valid number (1-3).");              
 keyboard.nextLine(); 
               continue; 
            } 
 
            switch (menuChoice) { 
                                case 1: 
                     if(currentMessageCount >= maxMessageLimit){ 
                        System.out.print("You have reached your maximum message limit! ");          
                                break;                      } 
                     
                    System.out.print("Enter Recipient Cell Number: "); 
                    String cellInput = keyboard.nextLine();                      
                    System.out.print("Enter Message  (Max 250 chars): ");             
                            String textInput = keyboard.nextLine();          
                                         if(textInput.length()>250){ 
                          int excessChars = textInput.length() - 250; 
                          System.out.println("Message exceeds 250 characters by "
+ excessChars + ":Please reduce the size.");                           break; 
                    } 
                      System.out.println("Massage is ready to send"); 

                    MessageClass singleMessage = new 
MessageClass(String.valueOf(currentMessageCount + 1), currentMessageCount, cellInput, textInput, ""); 
                     
                    String cellValidationStatus = singleMessage.checkRecipientCell(); 
                    System.out.println("Status: " + cellValidationStatus); 
                     
                    if (cellValidationStatus.equals("Cell phone number successfully captured.")) { 
                        System.out.println("Options:" 
                                + " 1) Send" 
                                + " 2) Store"                                 + " 0) Delete");    
                                                     int action = input.nextInt();        
                                                                      input.nextLine(); 
                         
                         
                        if (action == 1) {                             
                            singleMessage.createMessageHash();                       
                               currentMessageCount++; 
                            sessionMessages.add(singleMessage);                               
                            
System.out.println(singleMessage.SentMessage(action)); 
                            System.out.println(singleMessage.printMessages()); 
                            
                        }                        
                        else if (action == 2) {             
                     singleMessage.createMessageHash(); 
                            
System.out.println(singleMessage.SentMessage(action)); 
                             
                            sessionMessages.add(singleMessage);       
                              currentMessageCount++; 
                            System.out.println(singleMessage.printMessages()); 
                        }                        
                         else if (action == 0) { 
                            
System.out.println(singleMessage.SentMessage(action)); 
                        }                     } 
                    break; 
 
                case 2: 
                    System.out.println("Coming Soon.");                     break; 
 
                case 3: 
                    System.out.println("Exiting ");                     break; 
 
                default: 
             System.out.println("Invalid selection option. Please choose options 1, 2, or 3."); 
                break; 
            }         } 
 
        System.out.println("\nTotal number of messages processed: " +   currentMessageCount); 
 
        if (!sessionMessages.isEmpty()) { 
            MessageClass.storeMessage(sessionMessages); 
        } 
 
        System.out.println("Thank you for using QuickChat. Application terminated successfully."); 
        keyboard.close(); 
    } 
} 
 } 
}      
 
 
 

    
