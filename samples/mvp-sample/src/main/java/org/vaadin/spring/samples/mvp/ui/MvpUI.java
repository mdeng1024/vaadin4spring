package org.vaadin.spring.samples.mvp.ui;

import javax.inject.Inject;

import org.vaadin.spring.VaadinUI;
import org.vaadin.spring.events.EventBus;
import org.vaadin.spring.events.EventScope;
import org.vaadin.spring.samples.mvp.ui.presenter.Action;
import org.vaadin.spring.samples.mvp.ui.presenter.MainPresenter;

import com.vaadin.annotations.Title;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.UI;

@VaadinUI
@Title("Market User Interface")
public class MvpUI extends UI {

    private static final long serialVersionUID = 1L;

    @Inject
    EventBus eventBus;

    @Inject
    MainPresenter presenter;

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        eventBus.publish(EventScope.SESSION, this, Action.START);
        setContent(presenter.getView());
    }

}
