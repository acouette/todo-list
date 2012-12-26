package org.kwet.todolist.client;

import org.kwet.todolist.client.view.ITodoView;
import org.kwet.todolist.client.view.IWelcomeView;
import org.kwet.todolist.client.view.TodoViewImpl;
import org.kwet.todolist.client.view.WelcomeViewImpl;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.SimpleEventBus;
import com.google.gwt.place.shared.PlaceController;
import com.google.web.bindery.event.shared.EventBus;

public class ClientFactoryImpl implements ClientFactory {
	private static final EventBus eventBus = new SimpleEventBus();
	private static final PlaceController placeController = new PlaceController(eventBus);

	private static ClientRequestFactory requestFactory = GWT.create(ClientRequestFactory.class);

	static{
		requestFactory.initialize(eventBus);
	}
	
	@Override
	public EventBus getEventBus() {
		return eventBus;
	}

	@Override
	public PlaceController getPlaceController() {
		return placeController;
	}

	@Override
	public ITodoView getTodoView() {
		return new TodoViewImpl();
	}

	@Override
	public IWelcomeView getWelcomeView() {
		return new WelcomeViewImpl();
	}

	@Override
	public ClientRequestFactory getClientRequestFactory() {
		return requestFactory;
	}

}
