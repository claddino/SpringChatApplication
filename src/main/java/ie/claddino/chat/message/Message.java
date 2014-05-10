package ie.claddino.chat.message;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
@Entity
@Table(name="MESSAGE")
public class Message {
                @Id
                @Column(name="ID")
                @GeneratedValue
                private Integer id;
               
                @Column(name="SENDER")
                private String senderName ;
               
                @Column(name="RECEIVER")
                private String receiverName ;

                @Column(name="MESSAGE")
                private String message ;
               
                @Column(name="TIME")
                @Temporal(TemporalType.TIMESTAMP)
                private Date time;
               
                public Integer getId() {
                
                                return id;
                }
                public void setId(Integer id) {
                                this.id = id;
                }
                public String getSenderName() {
                                return senderName;
                }
                public void setSenderName(String senderName) {
                                this.senderName = senderName;
                }
                public String getReceiverName() {
                                return receiverName;
                }
                public void setReceiverName(String receiverName) {
                                this.receiverName = receiverName;
                }
                public String getMessage() {
                                return message;
                }
                public void setMessage(String message) {
                                this.message = message;
                }
                public Date getTime() {
                                return time;
                }
             
				public void setTime(Date date) {
					// TODO Auto-generated method stub
				     this.time = date;
				}
               
}