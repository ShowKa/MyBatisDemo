package com.showka.MyBatisDemo.entity;

import java.lang.reflect.Field;
import java.util.Comparator;

import javax.persistence.Id;

public class EntityComparator implements Comparator<EntityBase> {

	@Override
	public int compare(EntityBase e1, EntityBase e2) {

		Field[] fields1 = e1.getClass().getDeclaredFields();

		for (Field f1 : fields1) {
			Id id = f1.getAnnotation(Id.class);
			if (id == null) {
				continue;
			}

			Field f2;
			try {
				f2 = e2.getClass().getDeclaredField(f1.getName());
			} catch (NoSuchFieldException | SecurityException e) {
				throw new RuntimeException(e);
			}

			try {
				f1.setAccessible(true);
				f2.setAccessible(true);
				Object value1 = f1.get(e1);
				Object value2 = f2.get(e2);

				if (value1.equals(value2)) {
					continue;
				}

				// compare
				int compare = value1.hashCode() - value2.hashCode();
				if (compare == 0) {
					continue;
				}

				return compare;

			} catch (IllegalArgumentException | IllegalAccessException e) {
				throw new RuntimeException(e);
			}

		}

		return 0;
	}

}
