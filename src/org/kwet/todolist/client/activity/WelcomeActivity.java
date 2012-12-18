package org.kwet.todolist.client.activity;

import org.kwet.todolist.client.ClientFactory;
import org.kwet.todolist.client.view.IWelcomeView;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.ui.AcceptsOneWidget;

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
		IWelcomeView welcomeView = clientFactory.getWelcomeView();
		welcomeView.setPresenter(this);
		panel.setWidget(welcomeView);
	}


}
