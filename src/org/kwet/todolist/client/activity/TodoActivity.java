package org.kwet.todolist.client.activity;

import java.util.Set;

import org.kwet.todolist.client.ClientFactory;
import org.kwet.todolist.client.UserRequest;
import org.kwet.todolist.client.places.TodoPlace;
import org.kwet.todolist.client.view.ITodoView;
import org.kwet.todolist.shared.TodoProxy;
import org.kwet.todolist.shared.UserProxy;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.web.bindery.requestfactory.shared.Receiver;

public class TodoActivity extends AbstractActivity implements
		ITodoView.Presenter {

	private ClientFactory clientFactory;

	private long userId;
	
	private UserProxy user;
	
	final ITodoView todoView;

	public TodoActivity(ClientFactory clientFactory, TodoPlace place) {
		super();
		this.clientFactory = clientFactory;
		this.userId = place.getUserId();
		todoView = clientFactory.getTodoView();
	}

	@Override
	public void start(AcceptsOneWidget panel, EventBus eventBus) {
		clientFactory.getClientRequestFactory().userRequest().findById(userId).with("todos").fire(new Receiver<UserProxy>() {
			@Override
			public void onSuccess(UserProxy response) {
				user = response;
				todoView.setUser(response);
			}
		});
		todoView.setPresenter(this);
		panel.setWidget(todoView);
	}

	@Override
	public void addTodo(String label, int priority) {
		UserRequest userRequest = clientFactory.getClientRequestFactory().userRequest();
		user = userRequest.edit(user);
		TodoProxy todo = userRequest.create(TodoProxy.class);
		todo.setLabel(label);
		todo.setPriority(priority);
		Set<TodoProxy> todos = user.getTodos();
		todos.add(todo);
		user.setTodos(todos);
		userRequest.updateUser(user).with("todos").fire();
		todoView.addTodoToPanel(todo);
	}

}
