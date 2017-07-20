package com.showka.MyBatisDemo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

import com.showka.MyBatisDemo.entity.MBusho;

public class MapperGenerater {

	private static String TEMPLATE_FILE = "MapperTemplate.ftl";
	private static String DESTINATION = "generated/";

	@SuppressWarnings("rawtypes")
	static Class TARGET_CLASS = MBusho.class;

	public static void main(String[] args) {

		// class
		String className = TARGET_CLASS.getSimpleName();

		// table
		Table table = (Table) TARGET_CLASS.getAnnotation(Table.class);
		String tableName = table.name();

		ArrayList<Map<String, String>> columns = new ArrayList<Map<String, String>>();
		ArrayList<Map<String, String>> keys = new ArrayList<Map<String, String>>();
		for (Field field : TARGET_CLASS.getDeclaredFields()) {
			Column column = field.getAnnotation(Column.class);
			if (column != null) {
				HashMap<String, String> map = new HashMap<String, String>();
				map.put("column", column.name());
				columns.add(map);
			}

			Id id = field.getAnnotation(Id.class);
			if (id != null) {
				HashMap<String, String> map = new HashMap<String, String>();
				map.put("column", column.name());
				keys.add(map);
			}
		}

		System.out.println("Success!!");
	}

}
