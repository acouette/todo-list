package org.kwet.todolist.client.model;

import org.kwet.todolist.shared.Todo;

public interface TodoChangeListener {
	
	void onAdd(Todo todo);
	
	void onRemove(Todo todo);

}
