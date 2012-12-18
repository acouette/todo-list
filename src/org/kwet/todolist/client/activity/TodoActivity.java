package org.kwet.todolist.client.activity;

import org.kwet.todolist.client.ClientFactory;
import org.kwet.todolist.client.places.TodoPlace;
import org.kwet.todolist.client.view.ITodoView;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.ui.AcceptsOneWidget;

public class TodoActivity extends AbstractActivity implements ITodoView.Presenter{

	private ClientFactory clientFactory;
	
	private String username;
	
	public TodoActivity(ClientFactory clientFactory, TodoPlace place) {
		super();
		this.clientFactory = clientFactory;
		this.username = place.getUsername();
	}

	@Override
	public void start(AcceptsOneWidget panel, EventBus eventBus) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void goTo(Place place) {
		// TODO Auto-generated method stub
		
	}

}
