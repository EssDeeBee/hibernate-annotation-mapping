package service;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.query.Query;
import org.hibernate.Session;

import bl.SessionUtil;
import dao.AddressDAO;
import entity.Address;

public class AddressService extends SessionUtil implements AddressDAO {

	@Override
	public void add(Address address) throws SQLException {
		// open session with a transaction
		openTransactionSession();

		Session session = getSession();
		session.save(address);

		// close session with a transaction
		closeTransactionSession();

	}

	@Override
	public List<Address> getAll() throws SQLException {
		// open session with a transaction
		openTransactionSession();
		
		String sql = "select * from address";
		
		Session session = getSession();
		Query query = session.createNativeQuery(sql).addEntity(Address.class);
		List<Address> addressList = query.list();
		

		// close session with a transaction
		closeTransactionSession();
		
		return addressList;
	}

	@Override
	public Address getById(Long id) throws SQLException {
		// open session with a transaction
		openTransactionSession();
		
		String sql = "select * from address where id = :id";
		
		Session session = getSession();
		Query query = session.createNativeQuery(sql).addEntity(Address.class);
		query.setParameter("id", id);
		
		Address address = (Address) query.getSingleResult();

		// close session with a transaction
		closeTransactionSession();
		return address;
	}

	@Override
	public void update(Address address) throws SQLException {
		// open session with a transaction
		openTransactionSession();
		
		Session session = getSession();
		session.update(address);
		
		// close session with a transaction
		closeTransactionSession();
	}

	@Override
	public void remove(Address address) throws SQLException {
		// open session with a transaction
		openTransactionSession();
		
		Session session = getSession();
		session.remove(address);
		
		// close session with a transaction
		closeTransactionSession();

	}

}
