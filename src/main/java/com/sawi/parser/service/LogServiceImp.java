package com.sawi.parser.service;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.sawi.parser.model.Log;

public class LogServiceImp implements LogService{

	private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    
	public void save(Log log) {
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.persist(log);
		tx.commit();
		session.close();
	}

	@SuppressWarnings("unchecked")
	public List<Log> list() {
		Session session = this.sessionFactory.openSession();
		List<Log> logList = session.createQuery("from Log").list();
		session.close();
		return logList;
	}

	@Override
	public Log byId(int id) {
		Session session = this.sessionFactory.openSession();
		Log log = (Log) session.get(Log.class, id);
		session.close();
		return log;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Log> byType(String type) {
		Session session = this.sessionFactory.openSession();
		Criteria criteria = session.createCriteria(Log.class);
		List<Log> list = criteria.add(Restrictions.eq("type", type)).list();
		session.close();
		return list;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Log> byThread(String thread) {
		Session session = this.sessionFactory.openSession();
		Criteria criteria = session.createCriteria(Log.class);
		List<Log> list = criteria.add(Restrictions.eq("threadName", thread)).list();
		session.close();
		return list;
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<Log> byService(String service) {
		Session session = this.sessionFactory.openSession();
		Criteria criteria = session.createCriteria(Log.class);
		List<Log> list = criteria.add(Restrictions.eq("serviceName", service)).list();
		session.close();
		return list;
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<Log> byClass(String className) {
		Session session = this.sessionFactory.openSession();
		Criteria criteria = session.createCriteria(Log.class);
		List<Log> list = criteria.add(Restrictions.eq("className", className)).list();
		session.close();
		return list;
	}
	
	@Override
	public List<Log> byDateFromTo(long from, long to) {
		List<Log> list = new ArrayList<Log>();
		List<Log> logList = list();
		for(int i=0; i<logList.size(); i++){
			if(logList.get(i).getTime().getTime() >= from && logList.get(i).getTime().getTime() <= to)
				list.add(logList.get(i));	
		}
		return list;
	}



}
