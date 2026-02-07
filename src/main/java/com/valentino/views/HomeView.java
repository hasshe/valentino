package com.valentino.views;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route("")
public class HomeView extends VerticalLayout {

    public HomeView() {
        addClassName("home-view");
        setSizeFull();
        setAlignItems(Alignment.CENTER);
        setJustifyContentMode(JustifyContentMode.CENTER);
        
        var image = new Image("hlg.gif", "Valentine GIF");
        image.setWidth("200px");
        
        var title = new H1("Will you be my Valentine? 💕");
        
        var layout = createButtonLayout();

        add(image, title, layout);
    }

    private HorizontalLayout createButtonLayout() {
        var yesButton = createButton("YES");
        var noButton = createButton("NO");

        yesButton.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        noButton.addThemeVariants(ButtonVariant.LUMO_TERTIARY);

        yesButton.addClickListener(event -> {
            yesButton.setText("Clicked!");
            noButton.setText("NO");
        });
        noButton.addClickListener(event -> {
            noButton.setText("Clicked!");
            yesButton.setText("YES");
        });
        return new HorizontalLayout(yesButton, noButton);
    }

    private Button createButton(String text) {
        return new Button(text);
    }
}
