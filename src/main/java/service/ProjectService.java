package service;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import bl.SessionUtil;
import dao.ProjectDAO;
import entity.Project;

public class ProjectService extends SessionUtil implements ProjectDAO {
	
	@Override
	public void add(Project Project) throws SQLException {
		// open session with a transaction
		openTransactionSession();

		Session session = getSession();
		session.save(Project);

		// close session with a transaction
		closeTransactionSession();

	}

	@Override
	public List<Project> getAll() throws SQLException {
		// open session with a transaction
		openTransactionSession();
		
		String sql = "select * from project";
		
		Session session = getSession();
		Query query = session.createNativeQuery(sql).addEntity(Project.class);
		List<Project> projectList = query.list();
		

		// close session with a transaction
		closeTransactionSession();
		
		return projectList;
	}

	@Override
	public Project getById(Long id) throws SQLException {
		// open session with a transaction
		openTransactionSession();
		
		String sql = "select * from project where id = :id";
		
		Session session = getSession();
		Query query = session.createNativeQuery(sql).addEntity(Project.class);
		query.setParameter("id", id);
		
		Project project = (Project) query.getSingleResult();

		// close session with a transaction
		closeTransactionSession();
		return project;
	}

	@Override
	public void update(Project project) throws SQLException {
		// open session with a transaction
		openTransactionSession();
		
		Session session = getSession();
		session.update(project);
		
		// close session with a transaction
		closeTransactionSession();
	}

	@Override
	public void remove(Project project) throws SQLException {
		// open session with a transaction
		openTransactionSession();
		
		Session session = getSession();
		session.remove(project);
		
		// close session with a transaction
		closeTransactionSession();

	}

}
