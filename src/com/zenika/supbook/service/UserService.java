package com.zenika.supbook.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.zenika.supbook.model.User;

public class UserService {
	
	public User create(User user) {
		Connection cx = ConnexionManager.getCurrentConnection();
		PreparedStatement ps = null;
		try {

			ps = cx.prepareStatement("INSERT INTO USER( LOGIN, EMAIL ) VALUES ( ?, ? ) ");
			ps.setString(1, user.getLogin());
			ps.setString(2, user.getEmail());
			ps.executeUpdate();
			ResultSet generatedKeys = ps.getGeneratedKeys();
			generatedKeys.first();
			long generatedId = generatedKeys.getLong(1);

			cx.commit();

			user.setId(generatedId);
			return user;

		} catch (Exception e) {
			throw new RuntimeException(e);

		} finally {
			ConnexionManager.closeProperly(ps, cx);
		}
	}
	
	public boolean update(User user) {
		Connection cx = ConnexionManager.getCurrentConnection();
		PreparedStatement ps = null;
		try {

			ps = cx.prepareStatement("UPDATE USER SET LOGIN = ?, EMAIL = ? WHERE ID = ? ");
			ps.setString(1, user.getLogin());
			ps.setString(2, user.getEmail());
			ps.setLong(3, user.getId());
			ps.executeUpdate();
			boolean result = (ps.getUpdateCount() == 1);
			cx.commit();

			return result;

		} catch (Exception e) {
			throw new RuntimeException(e);

		} finally {
			ConnexionManager.closeProperly(ps, cx);
		}
	}

	public List<User> findAll() {
		List<User> result = new ArrayList<User>();

		Connection cx = ConnexionManager.getCurrentConnection();

		PreparedStatement ps = null;
		try {
			ps = cx.prepareStatement("SELECT ID, LOGIN, EMAIL FROM USER");

			ps.execute();
			ResultSet rs = ps.getResultSet();
			while (rs.next()) {
				result.add(buildFromResultSet(rs));
			}

			return result;

		} catch (SQLException e) {
			throw new RuntimeException(e);

		} finally {
			ConnexionManager.closeProperly(ps, cx);
		}
	}

	public User readById(long id) {
		Connection cx = ConnexionManager.getCurrentConnection();

		PreparedStatement ps = null;
		try {
			ps = cx.prepareStatement("SELECT ID, LOGIN, EMAIL FROM USER WHERE ID = ?");
			ps.setLong(1, id);
			ps.execute();
			ResultSet rs = ps.getResultSet();
			User result = null;
			if (rs.next()) {
				result = buildFromResultSet(rs);
			}

			return result;

		} catch (SQLException e) {
			throw new RuntimeException(e);
			
		} finally {
			ConnexionManager.closeProperly(ps, cx);
		}
	}
	
	public boolean delete(long id) {
		Connection cx = ConnexionManager.getCurrentConnection();

		PreparedStatement ps = null;
		try {
			ps = cx.prepareStatement("DELETE FROM USER WHERE ID = ?");
			ps.setLong(1, id);
			ps.executeUpdate();
			boolean result = (ps.getUpdateCount() == 1);
			
			cx.commit();

			return result;

		} catch (SQLException e) {
			throw new RuntimeException(e);
			
		} finally {
			ConnexionManager.closeProperly(ps, cx);
		}
	}
	
	private User buildFromResultSet(ResultSet rs) throws SQLException {
		User result = new User();
		result.setId(rs.getLong("ID"));
		result.setLogin(rs.getString("LOGIN"));
		result.setEmail(rs.getString("EMAIL"));
		return result;
	}
}
