package org.kwet.todolist.client;

import java.util.ArrayList;

import org.kwet.todolist.shared.Todo;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("todo")
public interface TodoService extends RemoteService{

	ArrayList<Todo> getTodoList();
	
}
