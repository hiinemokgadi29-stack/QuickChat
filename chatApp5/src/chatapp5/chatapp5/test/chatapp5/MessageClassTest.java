package chatapp5;
   
import chatapp5.MessageClass;
import static org.junit.Assert.*; 
 import org.junit.Test;
import java.util.ArrayList;
import java.util.List;

public class MessageClassTest {

    // 1. Test standard Setter and Getter methods
    @Test
    public void testGettersAndSetters() {
        MessageClass msg = new MessageClass();
        
        // Use your class setter fields
        msg.getsender("John Doe");
        msg.setRecipient("0821112222");
        msg.setMessageText("Testing QuickChat application system.");
        
        // JUnit 4 checks
        assertEquals("John Doe", msg.getSender());
        assertEquals("0821112222", msg.getRecipient());
        assertEquals("Testing QuickChat application system.", msg.getMessageText());
    }

    // 2. Test the core Search Algorithm logic
    @Test
    public void testSearchByID() {
        List<MessageClass> testingList = new ArrayList<>();
        MessageClass testMsg = new MessageClass();
        
        // Provide matching structural mock values
        testMsg.setSender("System Developer");
        testMsg.setRecipient("0719998888");
        testMsg.setMessageText("Confidential ID Match Test");
        
        testingList.add(testMsg);
        
        // Grab the auto-generated or assigned ID
        String expectedID = testMsg.getMessageID();
        assertNotNull("Message ID should not be null", expectedID);
        
        // Simulate search matching loop structure
        boolean matchFound = false;
        for (MessageClass current : testingList) {
            if (current.getMessageID().equalsIgnoreCase(expectedID)) {
                matchFound = true;
                break;
            }
        }
        
        assertTrue("The search algorithm should locate the message by ID", matchFound);
    }

    // 3. Test list management array element deletion
    @Test
    public void testDeleteByHashMechanism() {
        List<MessageClass> list = new ArrayList<>();
        MessageClass targetMsg = new MessageClass();
        
        targetMsg.setMessageText("Target item to be deleted.");
        // Generate hashing values using your blueprint method
        targetMsg.createMessageHash(); 
        
        list.add(targetMsg);
        String targetHash = targetMsg.getMessageHash();
        
        // Ensure item is registered
        assertEquals(1, list.size());
        
        // Run look-up and removal
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getMessageHash().equals(targetHash)) {
                list.remove(i);
                break;
            }
        }
        
        // Ensure array list shrinks safely
        assertEquals("List should be empty after element removal", 0, list.size());
    }



 
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
            


