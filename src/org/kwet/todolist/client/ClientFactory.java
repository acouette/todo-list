package org.kwet.todolist.client;

import org.kwet.todolist.client.view.ITodoView;
import org.kwet.todolist.client.view.IWelcomeView;

import com.google.gwt.place.shared.PlaceController;
import com.google.web.bindery.event.shared.EventBus;

public interface ClientFactory
{
	EventBus getEventBus();
	PlaceController getPlaceController();
	ITodoView getTodoView();
	IWelcomeView getWelcomeView();
}
