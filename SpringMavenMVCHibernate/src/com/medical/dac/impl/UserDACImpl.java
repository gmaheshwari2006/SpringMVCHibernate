package com.medical.dac.impl;

import java.sql.SQLException;
import java.util.List;

import javax.persistence.FetchType;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
//import org.springframework.transaction.annotation.Transactional;

import org.springframework.transaction.annotation.Transactional;

import com.medical.dac.UserDac;
import com.medical.entity.UserEntity;

@Repository
@Transactional (readOnly = false, rollbackFor = SQLException.class)
public class UserDACImpl implements UserDac {

	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}

	public UserEntity fetchUser(Long id) {
		Session session = this.sessionFactory.openSession();
		UserEntity user = (UserEntity) session.get(UserEntity.class, id);
		
		Criteria criteria = session.createCriteria(UserEntity.class, "u");
		criteria.add(Restrictions.eq("userId", id));
		criteria.add(Restrictions.eq("userName", "gaurav"));
		criteria.createAlias("company", "u.company");
		criteria.setFetchMode("company", FetchMode.JOIN);
		criteria.addOrder(Order.asc("u.userName"));
		ProjectionList columns = Projections.projectionList()
                .add(Projections.property("name"))
                .add(Projections.property("address.city"));
		criteria.setProjection(columns);
		List<UserEntity> users = criteria.list();
		return user;
	}

	public UserEntity fetchUserByUserName(String userName) {
		Session session = this.sessionFactory.openSession();
		Query query = session
				.createQuery("from UserEntity u where u.userName = :userName orber by u.userId");
		query.setParameter("userName", userName);
		List<?> users = (List<?>) query.list();
		if (!users.isEmpty()) {
			return (UserEntity)users.get(0);
		} else {
			return null;
		}
	}

	@Transactional
	public void saveOrUpdateUser(UserEntity userEntity) {
		Session session = this.sessionFactory.openSession();
		session.persist(userEntity);
		session.flush();
	}
}
