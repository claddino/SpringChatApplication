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
                

          

				public int getid() {
                    return id;
    }
             
   
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