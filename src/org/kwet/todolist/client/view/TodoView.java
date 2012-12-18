package org.kwet.todolist.client.view;

import java.util.List;

import org.kwet.todolist.shared.Todo;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.SpanElement;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.UIObject;

public class TodoView extends UIObject implements ITodoView{

	private static TodoViewUiBinder uiBinder = GWT.create(TodoViewUiBinder.class);

	interface TodoViewUiBinder extends UiBinder<Element, TodoView> {
	}

	@UiField
	SpanElement nameSpan;
	
	String username;
	
	List<Todo> todoList;

	private Presenter presenter;
	
	
	public TodoView() {
		setElement(uiBinder.createAndBindUi(this));
		
	}

	@Override
	public void setPresenter(Presenter presenter) {
		this.presenter = presenter;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setTodoList(List<Todo> todoList) {
		this.todoList = todoList;
	}
	
	

}
