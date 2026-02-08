package com.valentino.views;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.card.Card;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route("")
public class HomeView extends VerticalLayout {

    private Image popupGif;
    private Image valentinesGif;
    private Card card;

    public HomeView() {
        addClassName("home-view");
        setSizeFull();
        setAlignItems(Alignment.CENTER);
        setJustifyContentMode(JustifyContentMode.CENTER);
        
        valentinesGif = createValentineGif();
        
        configurePopupGif();
        
        var title = new H1("Will you be my Valentine? 💕");
    
        configureCard();

        var layout = createButtonLayout();

        add(valentinesGif, title, layout, popupGif, card);
    }

    private void configureCard() {
        card = new Card();
        card.setWidth("300px");
        card.setHeight("200px");
        card.setVisible(false);
        card.add(new H1("Yay! Happy Valentine's Day!"));
        card.getStyle()
            .set("display", "flex")
            .set("flex-direction", "column")
            .set("align-items", "center")
            .set("justify-content", "center");
        card.setMedia(new Image());
    }

    private Image createValentineGif() {
        valentinesGif = new Image("hlg.gif", "Valentine GIF");
        valentinesGif.setWidth("200px");
        return valentinesGif;
    }

    private void configurePopupGif() {
        popupGif = new Image("tgg.gif", "Nope!");
        popupGif.setId("popup-gif");
        popupGif.getStyle()
            .set("position", "fixed")
            .set("width", "150px")
            .set("height", "150px")
            .set("z-index", "10000")
            .set("pointer-events", "none")
            .set("display", "none");
    }

    private HorizontalLayout createButtonLayout() {
        var yesButton = createButton("YES");
        var noButton = createButton("NO");

        yesButton.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        noButton.addThemeVariants(ButtonVariant.LUMO_TERTIARY);

        setReactiveNoButton(noButton);

        yesButton.addClickListener(event -> {
            yesButton.setText("Clicked!");
            card.setVisible(true);
        });
        return new HorizontalLayout(yesButton, noButton);
    }

    private void setReactiveNoButton(Button noButton) {
        noButton.getElement().executeJs(
            "var btn = this;" +
            "btn.addEventListener('mouseenter', function() {" +
            "  var maxX = window.innerWidth - btn.offsetWidth - 20;" +
            "  var maxY = window.innerHeight - btn.offsetHeight - 20;" +
            "  var randomX = Math.floor(Math.random() * maxX);" +
            "  var randomY = Math.floor(Math.random() * maxY);" +
            "  btn.style.position = 'fixed';" +
            "  btn.style.left = randomX + 'px';" +
            "  btn.style.top = randomY + 'px';" +
            "  btn.style.zIndex = '9999';" +
            "  var gif = document.getElementById('popup-gif');" +
            "  if (gif) {" +
            "    gif.style.left = randomX + 'px';" +
            "    gif.style.top = (randomY - 160) + 'px';" +
            "    gif.style.display = 'block';" +
            "    gif.src = 'tgg.gif?' + new Date().getTime();" +
            "    setTimeout(function() { gif.style.display = 'none'; }, 1000);" +
            "  }" +
            "});"
        );
    }

    private Button createButton(String text) {
        return new Button(text);
    }
}
