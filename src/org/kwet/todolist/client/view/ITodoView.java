package org.kwet.todolist.client.view;

import com.google.gwt.place.shared.Place;

public interface ITodoView{
	
	void setPresenter(Presenter presenter);

    public interface Presenter {
        void goTo(Place place);
    }

}
