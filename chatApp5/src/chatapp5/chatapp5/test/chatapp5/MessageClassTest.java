package chatapp5;
   
import chatapp5.MessageClass;
import static org.junit.Assert.*; 
 import org.junit.Test;




public class MessageClassTest {


 
    public MessageClassTest() { 
    } 
 
    @Test 
    public void testMessageLength_Success() { 
        MessageClass testMessage = new MessageClass("MSG001", 0, "+27718693002", 
"Hi Mike, can you join us for", "",""); 
        String result = testMessage.checkMessageLength();     
        assertEquals("Message ready to send.", result); 
    } 
 
    @Test 
    public void testMessageLength_Failure() { 
        String longText = "a".repeat(255); 
        MessageClass testMessage = new MessageClass("MSG001", 0, "+27718693002", longText, "",""); 
        String result = testMessage.checkMessageLength();  
        assertEquals("Message exceeds 250 characters by 5;please reduce the size.", result); 
    } 
 
    @Test 
    public void testRecipientCell_Successes() { 
        MessageClass testMessage = new MessageClass("MSG001", 1, "+27718693002", 
                "Hello", "Select Send",""); 
        String result = testMessage.checkRecipientCell();   
        assertEquals("Cell phone number successfully captured.", result); 
    } 
 
    @Test 
    public void testRecipientCell_Failure() { 
        MessageClass testMessage = new MessageClass("MSG001", 0, "08575975889", 
                "Hello", "Select Send",""); 
        String result = testMessage.checkRecipientCell();         assertEquals("cell phone number incorrectly formatted or does not contain international code.Please correct the number or try again", result); 

 
    } 
 
    @Test 
    public void testMessagSent_Option1_SendMessage() { 
        MessageClass testMessage = new MessageClass("MSG001", 1, "+27718693002", 
"Hi Mike, can you join us for" 
                + "dinner tonight?", "Select Send","");         String result = testMessage.SentMessage(1);         assertEquals("Message successfully sent", result); 
    } 
 
    @Test 
    public void testMessagSent_Option0_SendMessage() { 
        MessageClass testMessage = new MessageClass("MSG001", 1, "+27718693002", 
"Hi Mike, can you join us for" 
                + "dinner tonight?", "Select Send",""); 
 
        String result = testMessage.SentMessage(0);     
        assertEquals("Press 0 to delete the message.", result);     } 
 
    @Test 
    public void testMessagSent_Option2_SendMessage() { 
        MessageClass testMessage = new MessageClass("MSG001", 1, "+27718693002", 
"Hi Mike, can you join us for" 
                + "dinner tonight?", "Select Send",""); 
 
        String result = testMessage.SentMessage(2); 
        assertEquals("Message successfully stored", result);     } 
 
 
 
    @Test 
    public void testCreateMessageHash() { 
        MessageClass testMessage = new MessageClass("MSG001", 1, "+27718693002", 
"Hi Mike, can you join us for" 
                + "dinner tonight?", "Select Send",""); 
        String hash = testMessage.createMessageHash();         assertNotNull("00:0:HITONIGHT", hash); 
 
    }     @Test 
    public void testReturnTotalMessages_Count() { 
 
        MessageClass testMessage = new MessageClass("MSG001", 2, "+27718693002", 
"Hi Mike, can you join us for " 
                + "dinner tonight?", "Select Send","");         assertEquals(2, testMessage.returnTotalMessages()); 
 
    }
}
            


