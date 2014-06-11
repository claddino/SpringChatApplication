package ie.claddino.chat.friend;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name="FRIEND")
public class Friend {
               
                
                @Column(name="USERID")
     
                private int userid;
                @Id
               
                @Column(name="FRIENDID")
                private FriendID friendid;

				public int getUserid() {
					return userid;
				}

				public void setUserid(int userid) {
					this.userid = userid;
				}

				public FriendID getFriendid() {
					return friendid;
				}
				
				

				public void setFriendid(FriendID friendid) {
					this.friendid = friendid;
				}

               
               
               
               
                
            
               
}
