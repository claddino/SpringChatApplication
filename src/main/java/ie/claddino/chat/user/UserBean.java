package ie.claddino.chat.user;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="Tbl_USERS")
public class UserBean {
               
                @Id
                @Column(name="ID")
                @GeneratedValue
                
                private Integer id;
                
                
                @NotEmpty
                @Column(name="USERNAME")
                private String userName ;
                @NotEmpty
                @Column(name="PASSWORD")
                private String passWord ;
                

           /*     @Column(name="ENABLED")
                private int enabled ;
               
                public int getEnabled() {
					return enabled;
				}

				public void setEnabled(int enabled) {
					this.enabled = enabled;
				}*/

				public int getid() {
                    return id;
    }
                //TODO not sure if get id needed
   
                public String getUserName() {
                                return userName;
                }
                public void setUserName(String userName) {
                                this.userName = userName;
                }
                public String getPassWord() {
                                return passWord;
                }
                public void setPassWord(String passWord) {
                                this.passWord = passWord;
                }
}