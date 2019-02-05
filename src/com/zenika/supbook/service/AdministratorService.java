package com.zenika.supbook.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.zenika.supbook.model.Administrator;

public class AdministratorService {
	
	public Administrator create(Administrator administrator) {
		Connection cx = ConnexionManager.getCurrentConnection();
		PreparedStatement ps = null;
		try {

			ps = cx.prepareStatement("INSERT INTO ADMINISTRATOR( LOGIN, PASSWORD ) VALUES ( ?, ? ) ");
			ps.setString(1, administrator.getLogin());
			ps.setString(2, administrator.getPassword());
			ps.executeUpdate();
			ResultSet generatedKeys = ps.getGeneratedKeys();
			generatedKeys.first();
			long generatedId = generatedKeys.getLong(1);

			cx.commit();

			administrator.setId(generatedId);
			return administrator;

		} catch (Exception e) {
			throw new RuntimeException(e);

		} finally {
			ConnexionManager.closeProperly(ps, cx);
		}
	}
	
	public boolean update(Administrator administrator) {
		Connection cx = ConnexionManager.getCurrentConnection();
		PreparedStatement ps = null;
		try {

			ps = cx.prepareStatement("UPDATE ADMINISTRATOR SET LOGIN = ?, PASSWORD = ? WHERE ID = ? ");
			ps.setString(1, administrator.getLogin());
			ps.setString(2, administrator.getPassword());
			ps.setLong(3, administrator.getId());
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

	public List<Administrator> findAll() {
		List<Administrator> result = new ArrayList<Administrator>();

		Connection cx = ConnexionManager.getCurrentConnection();

		PreparedStatement ps = null;
		try {
			ps = cx.prepareStatement("SELECT ID, LOGIN, PASSWORD FROM ADMINISTRATOR");

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

	public Administrator readById(long id) {
		Connection cx = ConnexionManager.getCurrentConnection();

		PreparedStatement ps = null;
		try {
			ps = cx.prepareStatement("SELECT ID, LOGIN, PASSWORD FROM ADMINISTRATOR WHERE ID = ?");
			ps.setLong(1, id);
			ps.execute();
			ResultSet rs = ps.getResultSet();
			Administrator result = null;
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
	
	public Administrator readByLoginAndPassword(String login, String password) {
		Connection cx = ConnexionManager.getCurrentConnection();

		PreparedStatement ps = null;
		try {
			ps = cx.prepareStatement("SELECT ID, LOGIN, PASSWORD FROM ADMINISTRATOR WHERE LOGIN = ? AND PASSWORD = ?");
			ps.setString(1, login);
			ps.setString(2, password);
			ps.execute();
			ResultSet rs = ps.getResultSet();
			Administrator result = null;
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
			ps = cx.prepareStatement("DELETE FROM ADMINISTRATOR WHERE ID = ?");
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
	
	private Administrator buildFromResultSet(ResultSet rs) throws SQLException {
		Administrator result = new Administrator();
		result.setId(rs.getLong("ID"));
		result.setLogin(rs.getString("LOGIN"));
		result.setPassword(rs.getString("PASSWORD"));
		return result;
	}
}
