package org.kwet.todolist.client;

import java.util.ArrayList;

import org.kwet.todolist.shared.Todo;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface TodoServiceAsync {

	void getTodoList(AsyncCallback<ArrayList<Todo>> callback) throws IllegalArgumentException;
	
}
