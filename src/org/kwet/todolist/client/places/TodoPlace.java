package org.kwet.todolist.client.places;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;

public class TodoPlace extends Place{

	private String username;

	public TodoPlace(String username) {
		super();
		this.username = username;
	}
	
	public String getUsername() {
		return username;
	}

	public static class Tokenizer implements PlaceTokenizer<TodoPlace> {
        @Override
        public String getToken(TodoPlace place) {
            return place.getUsername();
        }

        @Override
        public TodoPlace getPlace(String token) {
            return new TodoPlace(token);
        }
    }
	
}
