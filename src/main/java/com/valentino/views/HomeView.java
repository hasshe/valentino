package com.valentino.views;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.card.Card;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.select.Select;
import com.vaadin.flow.router.Route;

@Route("")
public class HomeView extends VerticalLayout {

    private Image popupGif;
    private Image valentinesGif;
    private Card card;
    private Div contractOverlay;
    private H1 title;
    private HorizontalLayout buttonLayout;
    private Select<String> themeSelector = new Select<>();

    private static final String VALENTINE_THEME_CLASS = "home-view-valentines";
    private static final String EASTER_THEME_CLASS = "home-view-easter";

    public HomeView() {
        themeSelector.setLabel("Theme Selector");
        themeSelector.setItems("Halloween", "Easter", "Valentine", "Christmas");
        themeSelector.setValue("Valentine");
        IO.print(themeSelector.getValue());

        themeSelector.addValueChangeListener(event -> {
            String theme = event.getValue();
                switch (theme) {
                    case "Halloween":
                        getElement().setAttribute("theme", "halloween");
                        break;
                    case "Easter":
                        addClassName(EASTER_THEME_CLASS);
                        break;
                    case "Valentine":
                        removeClassName(EASTER_THEME_CLASS);
                        addClassName(VALENTINE_THEME_CLASS);
                        break;
                    case "Christmas":
                        getElement().setAttribute("theme", "christmas");
                        break;
                    default:
                        addClassName(VALENTINE_THEME_CLASS);
                }
        });

        if (themeSelector.getValue().equals("Valentine")) {
            addClassName(VALENTINE_THEME_CLASS);
        }
        setSizeFull();
        setAlignItems(Alignment.CENTER);
        setJustifyContentMode(JustifyContentMode.CENTER);
        
        createValentineGif();
        
        configurePopupGif();
        
        configureTitle();
    
        configureCard();
        configureContractOverlay();

        createButtonLayout();

        add(themeSelector, valentinesGif, title, buttonLayout, popupGif, card, contractOverlay);
    }

    private void configureTitle() {
        title = new H1("Will you be my Valentine? 💕");
    }

    private void configureContractOverlay() {
        contractOverlay = new Div();
        contractOverlay.setId("contract-overlay");
        contractOverlay.setVisible(false);
        
        Image contractImage = new Image("place.png", "Valentine Contract");
        contractImage.getStyle()
            .set("max-width", "90%")
            .set("max-height", "90%")
            .set("object-fit", "contain");
        
        contractOverlay.add(contractImage);
        
        contractOverlay.getStyle()
            .set("position", "fixed")
            .set("top", "0")
            .set("left", "0")
            .set("width", "100vw")
            .set("height", "100vh")
            .set("background", "rgba(0, 0, 0, 0.9)")
            .set("display", "flex")
            .set("align-items", "center")
            .set("justify-content", "center")
            .set("z-index", "99999");

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

    private void createValentineGif() {
        valentinesGif = new Image("hlg.gif", "Valentine GIF");
        valentinesGif.setWidth("200px");
        valentinesGif.setHeight("200px");
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

    private void createButtonLayout() {
        var yesButton = createButton("YES");
        var noButton = createButton("NO");

        yesButton.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        noButton.addThemeVariants(ButtonVariant.LUMO_TERTIARY);

        setReactiveNoButton(noButton);

        yesButton.addClickListener(event -> {
            contractOverlay.setVisible(true);
        });
        buttonLayout = new HorizontalLayout(yesButton, noButton);
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
