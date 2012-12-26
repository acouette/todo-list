package org.kwet.todolist.client.view;

import java.util.List;

import org.kwet.todolist.shared.UserProxy;

import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.ui.IsWidget;

public interface IWelcomeView extends IsWidget{
	
	void setPresenter(Presenter presenter);
	
	void setUser(List<UserProxy> users);

    public interface Presenter {
        
    	void goTo(Place place);
    	
    	UserProxy addUser(String username);
    }

}
