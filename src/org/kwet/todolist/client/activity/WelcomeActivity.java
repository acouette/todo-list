package org.kwet.todolist.client.activity;

import java.util.List;

import org.kwet.todolist.client.ClientFactory;
import org.kwet.todolist.client.UserRequest;
import org.kwet.todolist.client.places.TodoPlace;
import org.kwet.todolist.client.view.IWelcomeView;
import org.kwet.todolist.shared.UserProxy;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.web.bindery.requestfactory.shared.Receiver;

public class WelcomeActivity extends AbstractActivity implements IWelcomeView.Presenter {

	private ClientFactory clientFactory;
	
	public WelcomeActivity(ClientFactory clientFactory) {
		super();
		this.clientFactory = clientFactory;
	}



	@Override
	public void goTo(Place place) {
		clientFactory.getPlaceController().goTo(place);
	}



	@Override
	public void start(AcceptsOneWidget panel, EventBus eventBus) {
		final IWelcomeView welcomeView = clientFactory.getWelcomeView();
		welcomeView.setPresenter(this);
		clientFactory.getClientRequestFactory().userRequest().getUserList().fire(new Receiver<List<UserProxy>>() {
			public void onSuccess(List<UserProxy> response) {
				welcomeView.setUser(response);
			}
		});
		panel.setWidget(welcomeView);
	}




	@Override
	public UserProxy addUser(final String username) {		
		
		UserRequest userRequest = clientFactory.getClientRequestFactory().userRequest();
		
		
		final UserProxy user = userRequest.create(UserProxy.class);
		user.setUsername(username);
		userRequest.addUser(user).fire(new Receiver<UserProxy>() {
			@Override
			public void onSuccess(UserProxy response) {
				goTo(new TodoPlace(response.getId()));
			}
		});
		return user;
	}

}
