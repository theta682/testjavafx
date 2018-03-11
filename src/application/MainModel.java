package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

public class MainModel {

	public enum EntityType {
		NA("Not Applicable", 0), Type1("Type 1", 1), Type2("Type 2", 2);

		private final String name;
		private final int value;
		private static final EntityType mapping[] = {
			NA,
			Type1,
			Type2,
		};

		private EntityType(String s, int v) {
			name = s;
			value = v;
		}

		public boolean equalsName(String otherName) {
			return name.equals(otherName);
		}

		public String toString() {
			return name;
		}

		public int getValue() {
			return value;
		}

		public static EntityType get(int t) {
			if (t > 0 && t < mapping.length)
				return mapping[t];
			return NA;
		}

		public static EntityType[] getAll() {
			return mapping;
		}
	}

	public MainModel() {
		setupDb();
		type = EntityType.NA;
	}

	private static final String newEntityLine = "New Entity...";
	private Connection connection;
	private String username;
	private EntityType type;

	public EntityType[] getAll() {
		return EntityType.getAll();
	}

	public Collection<String> getUsernames() {
		Collection<String> results = new ArrayList<String>();
		results.add(newEntityLine);
		try {
			ResultSet query = connection.prepareStatement("SELECT username FROM entities").executeQuery();
			while (query.next()) {
				results.add(query.getString(1));
			}
		} catch (SQLException e) {
		}
		return null;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String uname) {
		username = uname;
	}

	public void load(String uname) {
		try {
			PreparedStatement statement = connection.prepareStatement("SELECT * FROM entities WHERE username = ?");
			statement.setString(1, uname);
			ResultSet query = statement.executeQuery();
			if (query.next()) {
				setUsername(uname);
				setType(EntityType.get(query.getInt("type")));
			}
		} catch (SQLException e) {
		}
	}

	public EntityType getType() {
		return type;
	}

	public void setType(EntityType t) {
		if (t != null) {
			type = t;
		}
	}

	public void save() {
		// TODO: implement
	}

	public Connection getConnection() {
		return connection;
	}

	private void setupDb() {
		try {
			String db = System.getProperty("user.home") + System.getProperty("file.separator") + "testjavafx.sqlite";
			connection = DriverManager.getConnection("jdbc:sqlite:" + db);
			connection.prepareStatement("CREATE TABLE IF NOT EXISTS entities (" +
				"username TEST PRIMARY KEY," +
				"type INT" +
				")").execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
