package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

public class MainModel {

	public enum EntityType {
		NA("Not Applicable"), Type1("Type 1");

		private final String name;

		private EntityType(String s) {
			name = s;
		}

		public boolean equalsName(String otherName) {
			return name.equals(otherName);
		}

		public String toString() {
			return name;
		}

		public static Collection<EntityType> getAll() {
			Collection<EntityType> result = new ArrayList<EntityType>();
			result.add(EntityType.NA);
			result.add(EntityType.Type1);
			return result;
		}
	}

	public MainModel() {
		type = EntityType.NA;
		setupDb();
	}

	private EntityType type;
	private Connection connection;

	public Collection<EntityType> getAll() {
		return EntityType.getAll();
	}

	public EntityType getType() {
		return type;
	}

	public void setType(EntityType t) {
		if (t != null) {
			type = t;
		}
	}

	public Connection getConnection() {
		return connection;
	}

	private void setupDb() {
		try {
			Class.forName("org.sqlite.JDBC");
			String db = System.getProperty("user.home") + System.getProperty("file.separator") + "testjavafx.sqlite";
			connection = DriverManager.getConnection("jdbc:sqlite:" + db);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
}
