

package chatapp5; 

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException; import java.util.List; import java.util.UUID; 
 
public class MessageClass { 

// 1. PRIVATE FIELDS
private String messageID;  
private int numMessagesSent;   
private String recipient;  
private String messageText;  
private String messageHash; 
 
    // 2. CLASS CONSTRUCTOR 
    public MessageClass(String messageID, int numMessagesSent, String recipient, String messageText, String messageHash) { 
         
        this.numMessagesSent = numMessagesSent;    
         this.recipient = recipient;   
         this.messageText = messageText;       
this.messageHash = messageHash; 
             String randomID = UUID.randomUUID().toString().replaceAll("[^0-9]", 
"");                     if(randomID.length() >=10) {        
                        randomID = randomID.substring(0, 10); 
                    } else{                          while(randomID.length() < 10 ){  
      randomID += (int)(Math.random()*10);                                                  } 
                        
                    }                      this.messageID = randomID; 
    } 
 
    MessageClass() { 
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody 

    } 
 
    // 3. MANDATORY GETTERS 
public String getMessageID()
{ return this.messageID; }   
public String getRecipient()
{ return this.recipient; }  
public String getMessageText()
{ return this.messageText; }   
public String getMessageHash()
{ return this.messageHash; } 
     
     
    public String checkMessageLength(){   
int currentLength = this.getMessageText().length();     
if(currentLength <= 250){ 
            return"Message ready to send."; 
}else{             int excessChars = currentLength - 250;             return "Message exceeds 250 characters by " + excessChars + ";please reduce the size."; 
        } 
    }       
    // 4. VALIDATION METHODS  
public boolean checkMessageID() {    
if (this.messageID == null) return false;     
return this.messageID.length() <= 10; 
    } 
 
    private boolean isValidSouthAfricanNumber(String phoneNumber) {  
String cellRegex = "^(0\\d{9}$|^(\\+27|27)\\d{9})$"; 
        return phoneNumber != null && phoneNumber.matches(cellRegex);     } 
 
    public String checkRecipientCell() {         if (isValidSouthAfricanNumber(this.recipient)) {             return "Cell phone number successfully captured."; 
        } else {             return ("cell phone number incorrectly formatted "                     + "or does not contain international code." 
                    + "Please correct the number or try again"); 
 
        } 
    } 

 
    // 5. STRING PARSER HASH GENERATOR  
public String createMessageHash() {    
if (this.messageID == null || this.messageID.length() < 2 || 
this.messageText == null || this.messageText.isEmpty()) {    
return "00:0:ERROR"; 
        } 
 
        String idPrefix = this.messageID.substring(0, 2); 
        String cleanText = this.messageText.replaceAll("[.,?!/()_+\\-]", "");   
        String[] words = cleanText.split("\\s+"); 
 
         String hashWords = "";         if (words.length > 0) { 
            String firstWord = words[0].toUpperCase(); 
            String lastWord = words[words.length - 1].toUpperCase();
            hashWords = firstWord + lastWord; 
        } 
 
        this.messageHash = idPrefix + ":" + this.numMessagesSent + ":" + hashWords;         return this.messageHash; 
    } 
 
    // 6. CUSTOM CONSOLE DISPLAY LAYOUT    
       public String printMessages() { 
         String details = "MESSAGE DETAILS:\n"+ 
                          "Message ID   : " + this.getMessageID()+ "\n"+ 
                          "Message Hash : " + this.getMessageHash()+ "\n"+ 
                          "Recipient    : " + this.getRecipient()+ "\n"+     
                          "Message Text : " + this.getMessageText();           
                           return details; 
    } 
     
   
    public String SentMessage(int choice) {   
    if (choice == 1) {         return "Message successfully sent"; 
    } else if (choice == 0) {  return "Press 0 to delete the message."; 
    } else if (choice == 2) {  return "Message successfully stored"; 
    } 
    return "Invalid selection"; 
} 
    public int returnTotalMessages(){ 
     return this.numMessagesSent; 
    } 
 
 
 
    // 7. FLAT-FILE JSON BACKUP ENGINE 
    public static void storeMessage(List<MessageClass> messageList) { 
        File targetFile = new File("messages.json");     
            ObjectMapper jsonMapper = new ObjectMapper();         try { 
            jsonMapper.writerWithDefaultPrettyPrinter().writeValue(targetFile, messageList); 
            System.out.println("[SUCCESS] Session records safely backed up to messages.json"); 
        } catch (IOException errorDetails) { 
            System.out.println("[ERROR] Failed to save session records: " + errorDetails.getMessage()); 
        } 
    }
}



 
 
 
 
 
 
 


