package ie.claddino.chat.user;


import ie.claddino.chat.friend.Friend;

import java.util.List;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@SuppressWarnings({ "unchecked", "rawtypes" })
public class UserDAO {
	@Autowired
	private SessionFactory sessionFactory;

	/**
	 * @Transactional annotation below will trigger Spring Hibernate transaction
	 *                manager to automatically create a hibernate session. See
	 *                src/main/webapp/WEB-INF/servlet-context.xml
	 */
	@Transactional
	public List<UserBean> findAll() {
		Session session = sessionFactory.getCurrentSession();
		List users = session.createQuery("from UserBean").list();
		return users;
	}
	
	@Transactional
	public void addFriend(Friend friendname) {
		// Session session = sessionFactory.getCurrentSession();
		//sessionFactory.getCurrentSession().save(friendname);
	}

	@Transactional
	public void addUser(UserBean user) {
		// Session session = sessionFactory.getCurrentSession();
		sessionFactory.getCurrentSession().save(user);
	}

	
	
}
