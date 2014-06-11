package ie.claddino.chat.friend;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class FriendID implements Serializable {
  /**
	 * 
	 */
	private static final long serialVersionUID = -5429169729993320812L;
private int friendID;

public FriendID() {
	
}
 
public FriendID(int friendID) {
	super();
	this.friendID = friendID;
}

public boolean equals(Object other) {
	return false;
	//implement a equals that the PP can use to determine 
    //how the CategoryPK object can be identified.
}

public int hashCode(){
	return super.hashCode();
}

public Integer getfriendID() {
	// TODO Auto-generated method stub
	return friendID;
}
public void setFriendid(int friendid) {
	this.friendID = friendid;
}
}