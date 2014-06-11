package ie.claddino.chat.service;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.HibernateException;


/**
  * @author : Richard Downing
 * @version : 1.0 8-5-2014
 * @since : 1.0
 */

public interface UserDatastoreService {
                /**
                * This is the method to be used to create the User  corresponding
                * to a passed user's username and password.
                */
                /**
                 * @param name
                 * @param password
                 */
                public void createUserByHibernate(String name, String password);
                /**
                * This is the method to be used to logged in
                * by a passed user's username and password.
                */
                /**
                 * @param username
                 * @param password
                 * @return
                 */
                public List getUserID(String name);
                /**
                * This is the method to be used to get the current user's user ID.
                */
                /**
                 * @param loggedUserName
                 * @return
                 */
                public List getAllUsers(String loggedUserName);
                /**
                * This is the method to be used to get all online users list.
                */
                /**
                 * @param loggedUserName
                 * @return
                 */
                public List getOnlineUsers(String loggedUserName);
                /**
                * This is the method to be used to change users live status as user in logged in or not.
                */
                /**
                 * @param loggedUserName
                 * @param status
                 */
                public void changeMyOnlineStatus(String loggedUserName,int status);
                
                /**
            	 * Called when user is logging in or logging out.
            	 * if user logs in online status will be changed to 1 and to 0 when user is logging out
            	 */
            	
                /**
                 * @param request
                 */
                public void changeOnlineStatus(HttpServletRequest request);
                
                /**
                 * This is the method to be used to get Friends object 
                 */
                 /**
                  * @param loggedUserName
                  * @return
                 * @throws HibernateException 
                 * @throws Exception 
                  */
                public void addFriend(String friendsname, String loggedUserName) throws  Exception;
                
                /**
                 * This is the method returns a users friends list 
                 */
                /**
                 * @param loggedUserName
                 * @return
                 */
                public void getFriendList(String loggedUserName, HttpServletResponse response);
                
}