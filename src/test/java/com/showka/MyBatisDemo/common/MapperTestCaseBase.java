package com.showka.MyBatisDemo.common;

import java.sql.Timestamp;

import javax.sql.DataSource;

import org.apache.commons.lang3.ArrayUtils;
import org.junit.After;
import org.junit.Before;
import org.springframework.beans.factory.annotation.Autowired;

import com.ninja_squad.dbsetup.DbSetup;
import com.ninja_squad.dbsetup.Operations;
import com.ninja_squad.dbsetup.destination.DataSourceDestination;
import com.ninja_squad.dbsetup.destination.Destination;
import com.ninja_squad.dbsetup.operation.DeleteAll;
import com.ninja_squad.dbsetup.operation.Insert;
import com.ninja_squad.dbsetup.operation.Insert.Builder;
import com.ninja_squad.dbsetup.operation.Operation;

/**
 * Base Test Case Class for Crud1 Service Class.
 * 
 * @author ShowKa
 *
 */
public abstract class MapperTestCaseBase extends TestCaseBase {

	/**
	 * data source.
	 */
	@Autowired
	protected DataSource dataSource;

	/**
	 * common columns name
	 */
	private static final String[] COMMON_COLUMN = { "create_user_id", "create_timestamp", "update_user_id",
			"update_timestamp", "version", "deleted" };

	/**
	 * common columns value
	 */
	private static final Object[] COMMON_VALUE = { "test_create", new Timestamp(0), "test_update", new Timestamp(0), 0,
			false };

	/**
	 * db setup.
	 * 
	 * @param operations
	 */
	public void dbSetUp(Operation... operations) {
		Destination dest = new DataSourceDestination(dataSource);
		Operation ops = Operations.sequenceOf(operations);
		DbSetup dbSetup = new DbSetup(dest, ops);
		dbSetup.launch();
	}

	/**
	 * delete all records from table.
	 * 
	 * @param tableName
	 */
	public void deleteAll(String... tableName) {
		Destination dest = new DataSourceDestination(dataSource);
		for (String name : tableName) {
			DeleteAll deleteAll = Operations.deleteAllFrom(name);
			Operation ops = Operations.sequenceOf(deleteAll);
			DbSetup dbSetup = new DbSetup(dest, ops);
			dbSetup.launch();

		}
	}

	/**
	 * insert records;
	 * 
	 * @param tableName
	 * @param columns
	 * @param valuses
	 */
	public void insert(String tableName, String[] columns, Object[]... values) {
		Destination dest = new DataSourceDestination(dataSource);

		Builder builder = Operations.insertInto(tableName).columns(ArrayUtils.addAll(columns, COMMON_COLUMN));
		for (Object[] v : values) {
			builder.values(ArrayUtils.addAll(v, ArrayUtils.addAll(COMMON_VALUE)));
		}

		Insert inserts = builder.build();

		Operation ops = Operations.sequenceOf(inserts);
		DbSetup dbSetup = new DbSetup(dest, ops);
		dbSetup.launch();
	}

	@Before
	public void setup() {
		dbSetUp(Operations.sequenceOf(Operations.sql("SET FOREIGN_KEY_CHECKS = 0")));
	}

	@After
	public void cleanup() {
		dbSetUp(Operations.sequenceOf(Operations.sql("SET FOREIGN_KEY_CHECKS = 1")));
	}

}
