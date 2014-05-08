package ie.claddino.chat.service;
import java.util.List;

/**
 * @author : Richard Downing
 * @version : 1.0 8-5-2014
 * @since : 1.0
 */
public interface MessageDatastoreService {
/**
* This is the method to be used to send the message
* to a user by passing user's username as receiverName, message and logged-in username as senderName .
*/
public void sendMessageToThisUser(String receiverName, String message, String senderName);
/**
* This is the method to be used to get the messages
* of a logged user by passing user's username as loggedUserName .
*/
public List getMyLatestMessages(String loggedUserName);
/**
* This is the method to be used to get the previous messages
* of a logged user by passing user's username as loggedUserName .
*/
public List getMyPrevMessages(String loggedUserName, String minVal);
/**
* This is the method to be used to get the next messages
* of a logged user by passing user's username as loggedUserName .
*/
public List getMyNextMessages(String loggedUserName, String minVal);
}