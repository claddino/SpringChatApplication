package ie.claddino.chat.service;
import ie.claddino.chat.user.UserBean;

import java.util.List;

import javax.servlet.http.HttpServletRequest;


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
                public UserBean loginByUsernameAndPassword(String username, String password);
                /**
                * This is the method to be used to get all users list.
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
                
}