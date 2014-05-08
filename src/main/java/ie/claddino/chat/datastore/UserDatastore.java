package ie.claddino.chat.datastore;

import ie.claddino.chat.service.UserDatastoreService;
import ie.claddino.chat.user.UserBean;
import ie.claddino.chat.user.UsersOnline;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
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
public class UserDatastore implements UserDatastoreService {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void createUserByHibernate(String name, String password) {
		UserBean user = new UserBean();
		user.setUserName(name);
		user.setPassWord(password);
		sessionFactory.getCurrentSession().save(user);
	}

	@Override
	public UserBean loginByUsernameAndPassword(String username, String password) {

		Criteria criteria = sessionFactory.openSession()
				.createCriteria(UserBean.class)
				.add(Restrictions.eq("userName", username))
				.add(Restrictions.eq("passWord", password));
		return (UserBean) criteria.list().get(0);
	}

	@Override
	public List getAllUsers(String loggedUserName) {

		Criteria criteria = sessionFactory.openSession()
				.createCriteria(UserBean.class)
				.add(Restrictions.ne("userName", loggedUserName));
		return criteria.list();

	}

	@Override
	public List getOnlineUsers(String loggedUserName) {

		Criteria criteria = sessionFactory.openSession()
				.createCriteria(UsersOnline.class)
				.add(Restrictions.eq("liveStatus", 1))
				.add(Restrictions.ne("userId", loggedUserName));
		return criteria.list();

	}
	@Transactional
	@Override
	public void changeMyOnlineStatus(String loggedUserName, int status) {
		Criteria criteria = sessionFactory.openSession()
				.createCriteria(UsersOnline.class)
				.add(Restrictions.eq("userId", loggedUserName));
		if (criteria.list().size() == 0) {
			UsersOnline onlineUsers = new UsersOnline();
			onlineUsers.setLiveStatus(status);
			onlineUsers.setUserId(loggedUserName);
			sessionFactory.getCurrentSession().save(onlineUsers);
		} else {
			UsersOnline onlineUsers = (UsersOnline) criteria.list().get(0);
			onlineUsers.setLiveStatus(status);
			sessionFactory.getCurrentSession().update(onlineUsers);
		}
	}
}