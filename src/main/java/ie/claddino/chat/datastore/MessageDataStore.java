package ie.claddino.chat.datastore;

import ie.claddino.chat.message.Message;
import ie.claddino.chat.service.MessageDatastoreService;


import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author : Richard Downing
 * @version : 1.0 8-5-2014
 * @since : 1.0
 */
@Service
public class MessageDataStore implements MessageDatastoreService {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	@Transactional
	public void sendMessageToThisUser(String receiverName, String message,
			String senderName) {
		Message message2 = new Message();
		message2.setMessage(message);
		message2.setReceiverName(receiverName);
		message2.setSenderName(senderName);
		Date date = new Date();
		
		
		message2.setTime(date);
	
		sessionFactory.getCurrentSession().save(message2);
	}

	@Override
	public List<Message> getMyLatestMessages(String loggedUserName) {
		Criteria criteria = sessionFactory.openSession()
				.createCriteria(Message.class)
				.add(Restrictions.like("receiverName", loggedUserName))
				.addOrder(Order.desc("id")).setMaxResults(5);
		
		System.out.println("Get my message critera" + criteria.toString());
		  @SuppressWarnings("unchecked")
		List<Message> messageList = criteria.list();
	
		return messageList;
	}

	@Override
	public List<Message> getMyPrevMessages(String loggedUserName, String minVal) {
		Criteria criteria = sessionFactory.openSession()
				.createCriteria(Message.class)
				.add(Restrictions.like("receiverName", loggedUserName))
				.add(Restrictions.lt("id", Integer.parseInt(minVal)))
				.addOrder(Order.desc("id")).setMaxResults(5);
		  @SuppressWarnings("unchecked")
		List<Message> messageList = criteria.list();
		
		return messageList;
	}

	@Override
	public List<Message> getMyNextMessages(String loggedUserName, String maxVal) {
		System.out.println("maxVal " + maxVal);
		Criteria criteria = sessionFactory.openSession()
				.createCriteria(Message.class)
				.add(Restrictions.like("receiverName", loggedUserName))
				.add(Restrictions.gt("id", Integer.parseInt(maxVal)))
				.addOrder(Order.desc("id")).setMaxResults(5);
		  @SuppressWarnings("unchecked")
		List<Message> messageList = criteria.list();
		return messageList;
	}

}