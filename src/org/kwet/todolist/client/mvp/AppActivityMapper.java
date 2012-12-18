package org.kwet.todolist.client.mvp;

import org.kwet.todolist.client.ClientFactory;
import org.kwet.todolist.client.activity.TodoActivity;
import org.kwet.todolist.client.activity.WelcomeActivity;
import org.kwet.todolist.client.places.TodoPlace;
import org.kwet.todolist.client.places.WelcomePlace;

import com.google.gwt.activity.shared.Activity;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.place.shared.Place;

public class AppActivityMapper implements ActivityMapper {

	private ClientFactory clientFactory;

	/**
	 * AppActivityMapper associates each Place with its corresponding
	 * {@link Activity}
	 * 
	 * @param clientFactory
	 *            Factory to be passed to activities
	 */
	public AppActivityMapper(ClientFactory clientFactory) {
		super();
		this.clientFactory = clientFactory;
	}

	/**
	 * Map each Place to its corresponding Activity. This would be a great use
	 * for GIN.
	 */
	@Override
	public Activity getActivity(Place place) {
		// This is begging for GIN
		if (place instanceof WelcomePlace)
			return new WelcomeActivity(clientFactory);
		else if (place instanceof TodoPlace)
			return new TodoActivity(clientFactory, (TodoPlace) place);

		return null;
	}

}
