package org.kwet.todolist.client.model;

import java.util.ArrayList;
import java.util.List;

import org.kwet.todolist.shared.Todo;

public class TodoChangeNotifier {

	List<TodoChangeListener> changeListeners = new ArrayList<TodoChangeListener>();
	
	public void addChangeListener(TodoChangeListener changeListener){
		changeListeners.add(changeListener);
	}
	
	public void notifyAdd(Todo todo){
		for (TodoChangeListener listener : changeListeners) {
			listener.onAdd(todo);
		}
	}
	
	public void notifyRemove(Todo todo){
		for (TodoChangeListener listener : changeListeners) {
			listener.onRemove(todo);
		}
	}
	
}
