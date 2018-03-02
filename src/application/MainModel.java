package application;

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
	}

	private EntityType type;

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
}
