package com.Spring.DAO.impl;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;

import com.Spring.DAO.GenericDAO;
import com.Spring.Models.Tutor;


public class AbstractDAO<T> implements GenericDAO<T> {


	public Connection getConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/fasttutor";
			String user = "root";
			String password = "Tiendinh2k";
			return DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException | SQLException e) {
			return null;
		}
	}

	@Override
	public <T> List<T> query(String sql, RowMapper<T> rowMapper, Object... parameters) {
		List<T> results = new ArrayList<>();
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			connection = getConnection();
			statement = connection.prepareStatement(sql);
			setParameter(statement, parameters);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				results.add(rowMapper.mapRow(resultSet, 0));
			}
			return results;
		} catch (SQLException e) {
			return null;
		} finally {
			try {
				if (connection != null) {
					connection.close();
				}
				if (statement != null) {
					statement.close();
				}
				if (resultSet != null) {
					resultSet.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
				return null;
			}
		}
	}

	@Override
	public boolean update(String sql, Object parameters) {
		Connection connection = null;
		PreparedStatement statement = null;

		try {
			connection = getConnection();
			statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			setParameterUpdate(statement, parameters);
			System.out.println(statement.toString());
			statement.executeUpdate();

			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean insert(String sql, Object parameters) {
		Connection connection = null;
		PreparedStatement statement = null;

		try {

			connection = getConnection();

			statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			setParameter(statement, parameters);

			System.out.println("vao");

			System.out.println(statement.toString());
			statement.executeUpdate();
			System.out.println("da excute");
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public int count(String sql, Object... parameters) {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			int count = 0;
			connection = getConnection();
			statement = connection.prepareStatement(sql);
			setParameter(statement, parameters);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				count = resultSet.getInt(1);
			}
			return count;
		} catch (SQLException e) {
			return 0;
		} finally {
			try {
				if (connection != null) {
					connection.close();
				}
				if (statement != null) {
					statement.close();
				}
				if (resultSet != null) {
					resultSet.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public boolean delete(String sql, Object parameters) {
		Connection connection = null;
		PreparedStatement statement = null;

		try {

			connection = getConnection();

			statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

			setParameterWithSingleAttribute(statement, parameters);

			System.out.println(statement.toString());
			statement.executeUpdate();

			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public <T> List<T> find(String sql, RowMapper<T> rowMapper, Object parameters) {
		List<T> results = new ArrayList<>();
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			connection = getConnection();
			statement = connection.prepareStatement(sql);
			// setParameter(statement, parameters);
			System.out.println("vo");
			setParameterByOneKey(statement, parameters);
			System.out.println(statement.toString());
			resultSet = statement.executeQuery();
			// System.out.println(resultSet.getString(1));
			while (resultSet.next()) {
				results.add(rowMapper.mapRow(resultSet, 0));
			}
			return results;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	public <T> List<T> findById(String sql, RowMapper<T> rowMapper, Object parameters) {
		List<T> results = new ArrayList<>();
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			connection = getConnection();
			statement = connection.prepareStatement(sql);
			// setParameter(statement, parameters);
			System.out.println("vo");
			setParameterWithSingleAttribute(statement, parameters);
			System.out.println(statement.toString());
			resultSet = statement.executeQuery();
			// System.out.println(resultSet.getString(1));
			while (resultSet.next()) {
				results.add(rowMapper.mapRow(resultSet, 0));
			}
			return results;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	/// Get Field of model
	public List<Field> getAllFields(Object obj) {
		List<Field> fields = new ArrayList<Field>();
		getAllFieldsRecursive(fields, obj.getClass());
		return fields;
	}

	public List<Field> getAllFieldsRecursive(List<Field> fields, Class<?> type) {
		for (Field field : type.getDeclaredFields()) {
			fields.add(field);
		}

		if (type.getSuperclass() != null) {
			fields = getAllFieldsRecursive(fields, type.getSuperclass());
		}

		return fields;
	}

	private void setParameter(PreparedStatement statement, Object parameters) {
		List l = getAllFields(parameters);

		int pos = 1;

		for (int i = 0; i < l.size(); i++) {
			Field x = (Field) l.get(i);
			x.setAccessible(true);
			try {
				System.out.println(x.get(parameters) + ":" + x.getType());
			} catch (IllegalArgumentException | IllegalAccessException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			if (x.getType() == Integer.TYPE) {

				try {
					statement.setInt(pos, (Integer) x.get(parameters));

					pos++;
				} catch (IllegalArgumentException | IllegalAccessException | SQLException e) {
					e.printStackTrace();
				}
			} else if (x.getType().isAssignableFrom(String.class)) {
				try {
					statement.setString(pos, (String) x.get(parameters));
					pos++;
				} catch (IllegalArgumentException | IllegalAccessException | SQLException e) {

					e.printStackTrace();
				}
			}

		}

	}

	private void setParameterWithSingleAttribute(PreparedStatement statement, Object parameters) {

		getAllFields(parameters).forEach(x -> {

			x.setAccessible(true);
			// delete just by id
			if (x.getType() == Integer.TYPE && x.getName().contains("id") == true) {
				try {
					statement.setInt(1, (Integer) x.get(parameters));

				} catch (IllegalArgumentException | IllegalAccessException | SQLException e) {
					e.printStackTrace();
				}
			}

		});

	}

	private void setParameterUpdate(PreparedStatement statement, Object parameters) {
		List l = getAllFields(parameters);
		int pos = 1;
		for (int i = 1; i < l.size(); i++) {
			Field x = (Field) l.get(i);

			x.setAccessible(true);

			if (x.getType() == Integer.TYPE) {

				try {
					statement.setInt(pos, (Integer) x.get(parameters));
					pos++;
				} catch (IllegalArgumentException | IllegalAccessException | SQLException e) {
					e.printStackTrace();
				}
			} else {

				try {
					statement.setString(pos, (String) x.get(parameters));
					pos++;
				} catch (IllegalArgumentException | IllegalAccessException | SQLException e) {

					e.printStackTrace();
				}
			}

		}

		// id is always in the last Field
		Field x = (Field) l.get(0);
		x.setAccessible(true);
		if (x.getType() == Integer.TYPE) {

			try {
				statement.setInt(pos, (Integer) x.get(parameters));
			} catch (IllegalArgumentException | IllegalAccessException | SQLException e) {
				e.printStackTrace();
			}
		}

	}

	public void setParameterByOneKey(PreparedStatement statement, Object parameters) {
		List l = getAllFields(parameters);

		for (int i = 1; i < l.size(); i++) {
			Field x = (Field) l.get(i);

			x.setAccessible(true);

			try {
				System.out.println(x.get(parameters) + " : " + x.getName());
				System.out.println(x.getType() == Integer.TYPE);
			} catch (IllegalArgumentException | IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			try {

				if (x.get(parameters) != null) {
					if (x.getType().isAssignableFrom(String.class)) {
						statement.setString(1, (String) x.get(parameters));
						break;
					} else if (x.getType() == Integer.TYPE) {
						statement.setInt(1, (Integer) x.get(parameters));
						break;
					}
				} else {

				}

			} catch (IllegalArgumentException | IllegalAccessException | SQLException e) {

				e.printStackTrace();
			}

		}
	}

}