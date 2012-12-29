package org.kwet.todolist.client.view;

import org.kwet.todolist.shared.UserProxy;

import com.google.gwt.user.client.ui.IsWidget;

public interface ITodoView extends IsWidget{
	
	void setPresenter(Presenter presenter);
	
	void setUser(UserProxy user);

    public interface Presenter {
        void addTodo(String label, int priority);
        
        void removeTodo(long id);
    }

}
