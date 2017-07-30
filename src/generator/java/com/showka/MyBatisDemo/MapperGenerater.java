package com.showka.MyBatisDemo;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

import com.showka.MyBatisDemo.entity.MBusho;

import freemarker.template.Configuration;
import freemarker.template.TemplateException;

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

		// configuration
		Configuration fileMarkerConfig = new Configuration(Configuration.VERSION_2_3_23);
		fileMarkerConfig.setClassForTemplateLoading(MapperGenerater.class, "/");

		try {

			// template
			freemarker.template.Template template = fileMarkerConfig.getTemplate(TEMPLATE_FILE);

			// map
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("className", className);
			map.put("tableName", tableName);
			map.put("columns", columns);
			map.put("keys", keys);

			// write
			File file = new File(DESTINATION + className + "Mapper.xml");
			PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(file)));
			template.process(map, writer);

		} catch (IOException | TemplateException e) {
			e.printStackTrace();
			System.out.println("Error!!");
			return;
		}
		System.out.println("Success!!");

	}

}
