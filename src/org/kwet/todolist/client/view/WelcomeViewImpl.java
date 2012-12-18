package org.kwet.todolist.client.view;

import org.kwet.todolist.client.places.TodoPlace;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;

public class WelcomeViewImpl extends Composite implements IWelcomeView {

	private static WelcomeViewImplUiBinder uiBinder = GWT.create(WelcomeViewImplUiBinder.class);

	interface WelcomeViewImplUiBinder extends UiBinder<Widget, WelcomeViewImpl> {
	}

	public WelcomeViewImpl() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	@UiField
	Anchor  button;
	
	@UiField
	TextBox name;
	
	private Presenter presenter;	

	@Override
	public void setPresenter(Presenter presenter) {
		this.presenter = presenter;
	}


	@UiHandler("button")
	void onClick(ClickEvent e) {
		presenter.goTo(new TodoPlace(name.getText()));
	}

}
