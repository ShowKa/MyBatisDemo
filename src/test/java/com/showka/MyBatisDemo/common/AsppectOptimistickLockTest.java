package com.showka.MyBatisDemo.common;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.showka.MyBatisDemo.entity.Todo;
import com.showka.MyBatisDemo.mapper.TodoMapper;
import com.showka.MyBatisDemo.system.exception.OptimistickLockException;

public class AsppectOptimistickLockTest extends MapperTestCaseBase {

	@Autowired
	TodoMapper todoMapper;

	/**
	 * test optimistic lock error when update
	 */
	@Test(expected = OptimistickLockException.class)
	public void test_update() {

		Todo newTodo = new Todo();
		newTodo.setTitle("友人との飲み会!");
		newTodo.setDetails("銀座 19:00");
		newTodo.setFinished(false);
		todoMapper.insert(newTodo);

		newTodo.setVersion(-1);
		todoMapper.update(newTodo);
	}

	/**
	 * test optimistic lock error when delete
	 */
	@Test(expected = OptimistickLockException.class)
	public void test_deleteLogically() {

		Todo newTodo = new Todo();
		newTodo.setTitle("友人との飲み会!");
		newTodo.setDetails("銀座 19:00");
		newTodo.setFinished(false);
		todoMapper.insert(newTodo);

		newTodo.setVersion(-1);
		todoMapper.deleteLogically(newTodo);
	}

	/**
	 * test optimistic lock error when delete
	 */
	@Test(expected = OptimistickLockException.class)
	public void test_deletePhysically() {

		Todo newTodo = new Todo();
		newTodo.setTitle("友人との飲み会!");
		newTodo.setDetails("銀座 19:00");
		newTodo.setFinished(false);
		todoMapper.insert(newTodo);

		newTodo.setVersion(-1);
		todoMapper.deletePhysically(newTodo);
	}

	/**
	 * test optimistic lock error when update
	 */
	@Test
	public void test_success() {

		Todo newTodo = new Todo();
		newTodo.setTitle("友人との飲み会!");
		newTodo.setDetails("銀座 19:00");
		newTodo.setFinished(false);
		todoMapper.insert(newTodo);

		newTodo.setVersion(0);
		todoMapper.update(newTodo);
		assertTrue(true);
	}
}
