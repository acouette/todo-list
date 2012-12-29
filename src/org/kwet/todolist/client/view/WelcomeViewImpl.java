package org.kwet.todolist.client.view;

import java.util.Iterator;
import java.util.List;

import org.kwet.todolist.client.places.TodoPlace;
import org.kwet.todolist.shared.UserProxy;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

public class WelcomeViewImpl extends Composite implements IWelcomeView {

	private static WelcomeViewImplUiBinder uiBinder = GWT
			.create(WelcomeViewImplUiBinder.class);

	interface WelcomeViewImplUiBinder extends UiBinder<Widget, WelcomeViewImpl> {
	}

	public WelcomeViewImpl() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	@UiField
	Button button;

	@UiField
	TextBox name;

	@UiField
	VerticalPanel userlist;

	private Presenter presenter;

	@Override
	public void setPresenter(Presenter presenter) {
		this.presenter = presenter;
	}

	@UiHandler("button")
	void onClick(ClickEvent e) {
		presenter.addUser(name.getText());
	}
	
	@UiHandler("name")
	void onKeyUp(KeyUpEvent e) {
		if(e.getNativeKeyCode() == 13){
			presenter.addUser(name.getText());
		}
	}

	@Override
	public void setUser(List<UserProxy> users) {
		final Presenter presenterF = presenter;
		if (users.isEmpty()) {
			userlist.add(new Label("No user registered"));
		} else {
			Iterator<UserProxy> it = users.iterator();
			while (it.hasNext()) {
				final UserProxy user = (UserProxy) it.next();
				Anchor anchor = new Anchor(user.getUsername());
				anchor.addClickHandler(new ClickHandler() {
					@Override
					public void onClick(ClickEvent event) {
						presenterF.goTo(new TodoPlace(user.getId()));
					}
				});
				userlist.add(anchor);
			}
		}

	}

}
