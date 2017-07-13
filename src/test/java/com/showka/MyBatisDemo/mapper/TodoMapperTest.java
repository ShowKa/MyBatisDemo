package com.showka.MyBatisDemo.mapper;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.showka.MyBatisDemo.common.TestCaseBase;
import com.showka.MyBatisDemo.entity.Todo;

public class TodoMapperTest extends TestCaseBase {

	@Autowired
	private TodoMapper todoMapper;

	@Test
	public void test_01() {
		Todo newTodo = new Todo();
		newTodo.setTitle("友人との飲み会!");
		newTodo.setDetails("銀座 19:00");
		newTodo.setFinished(false);
		todoMapper.insert(newTodo);

		newTodo.setDetails("銀座 20:00");
		newTodo.setVersion(1);
		boolean updated = todoMapper.update(newTodo);
		System.out.println(updated);

		Todo result = todoMapper.select(newTodo.getTitle());
		System.out.println(result);
		assertEquals(newTodo.getTitle(), result.getTitle());
	}

}
