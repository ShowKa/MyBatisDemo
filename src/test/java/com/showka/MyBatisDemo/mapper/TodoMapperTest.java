package com.showka.MyBatisDemo.mapper;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.showka.MyBatisDemo.common.TestCaseBase;
import com.showka.MyBatisDemo.entity.Todo;

public class TodoMapperTest extends TestCaseBase {

	@Autowired
	private TodoMapper todoMapper;

	/**
	 * update
	 */
	@Test
	public void test_01() {
		Todo newTodo = new Todo();
		newTodo.setTitle("友人との飲み会!");
		newTodo.setDetails("銀座 19:00");
		newTodo.setFinished(false);
		todoMapper.insert(newTodo);
		assertEquals(new Integer(0), newTodo.getVersion());

		newTodo.setDetails("銀座 20:00");
		newTodo.setVersion(0);
		todoMapper.update(newTodo);
		assertEquals(new Integer(1), newTodo.getVersion());

		Todo result = todoMapper.selectByPK(newTodo.getTitle());
		assertEquals(newTodo.getTitle(), result.getTitle());
	}

	/**
	 * test delete logically
	 */
	@Test
	public void test_02() {
		Todo newTodo = new Todo();
		newTodo.setTitle("友人との飲み会!");
		newTodo.setDetails("銀座 19:00");
		newTodo.setFinished(false);
		todoMapper.insert(newTodo);
		assertEquals(false, newTodo.isLogicallyDeleted());

		boolean result = todoMapper.deleteLogically(newTodo);
		assertEquals(new Integer(1), newTodo.getVersion());
		assertEquals(true, result);
		assertEquals(true, newTodo.isLogicallyDeleted());
	}

	/**
	 * test delete physically
	 */
	@Test
	public void test_03() {
		Todo newTodo = new Todo();
		newTodo.setTitle("友人との飲み会!");
		newTodo.setDetails("銀座 19:00");
		newTodo.setFinished(false);
		todoMapper.insert(newTodo);

		todoMapper.deletePhysically(newTodo);

		Todo result = todoMapper.selectByPK(newTodo.getTitle());
		assertNull(result);
	}

}
