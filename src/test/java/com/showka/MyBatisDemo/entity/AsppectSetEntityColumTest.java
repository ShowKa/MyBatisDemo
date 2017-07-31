package com.showka.MyBatisDemo.entity;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.showka.MyBatisDemo.common.MapperTestCaseBase;
import com.showka.MyBatisDemo.mapper.TodoMapper;

public class AsppectSetEntityColumTest extends MapperTestCaseBase {

	@Autowired
	TodoMapper todoMapper;

	@Test
	public void testAroundInsert() throws Exception {
		Todo newTodo = new Todo();
		newTodo.setTitle("友人との飲み会!");
		newTodo.setDetails("銀座 19:00");
		newTodo.setFinished(false);
		todoMapper.insert(newTodo);

		assertEquals(new Integer(0), newTodo.getVersion());
	}

	@Test
	public void testAroundUpdate() throws Exception {
		Todo newTodo = new Todo();
		newTodo.setTitle("友人との飲み会!");
		newTodo.setDetails("銀座 19:00");
		newTodo.setFinished(false);
		todoMapper.insert(newTodo);
		todoMapper.update(newTodo);

		assertEquals(new Integer(1), newTodo.getVersion());
	}

	@Test
	public void testAroundDeleteLogically() throws Exception {
		Todo newTodo = new Todo();
		newTodo.setTitle("友人との飲み会!");
		newTodo.setDetails("銀座 19:00");
		newTodo.setFinished(false);
		todoMapper.insert(newTodo);
		todoMapper.deleteLogically(newTodo);

		assertEquals(new Integer(1), newTodo.getVersion());
	}

}
