package org.kwet.todolist.server;

import java.util.ArrayList;

import org.kwet.todolist.client.TodoService;
import org.kwet.todolist.shared.Todo;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

@SuppressWarnings("serial")
public class TodoServiceImpl extends RemoteServiceServlet implements TodoService {

	private ArrayList<Todo> todoList = new ArrayList<Todo>();
	
	@Override
	public ArrayList<Todo> getTodoList() {
		return todoList;
	}

	public TodoServiceImpl(){
		addTodo("first task", 1);
		addTodo("second task", 2);
	}
	
	public void setTodos(ArrayList<Todo> todos) {
		for (Todo todo : todos) {
			addTodo(todo.getName(), todo.getPriority());
		}
	}

	public void addTodo(String name, int priority){
		Todo todo = new Todo();
		todo.setName(name);
		todo.setPriority(priority);
		todoList.add(todo);
	}

}
