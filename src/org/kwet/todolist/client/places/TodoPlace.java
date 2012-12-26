package org.kwet.todolist.client.places;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;

public class TodoPlace extends Place {

	private long userId;

	public TodoPlace(long userId) {
		this.userId = userId;
	}

	public long getUserId() {
		return userId;
	}

	public static class Tokenizer implements PlaceTokenizer<TodoPlace> {

		@Override
		public String getToken(TodoPlace place) {
			return String.valueOf(place.getUserId());
		}

		@Override
		public TodoPlace getPlace(String token) {
			return new TodoPlace(Long.valueOf(token));
		}
	}

}
