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

    private Image popupGif;

    public HomeView() {
        addClassName("home-view");
        setSizeFull();
        setAlignItems(Alignment.CENTER);
        setJustifyContentMode(JustifyContentMode.CENTER);
        
        var image = new Image("hlg.gif", "Valentine GIF");
        image.setWidth("200px");
        
        // Create a popup GIF that appears when button moves
        popupGif = new Image("hlg.gif", "Nope!");
        popupGif.setId("popup-gif");
        popupGif.getStyle()
            .set("position", "fixed")
            .set("width", "150px")
            .set("height", "150px")
            .set("z-index", "10000")
            .set("pointer-events", "none")
            .set("display", "none");
        
        var title = new H1("Will you be my Valentine? 💕");
        
        var layout = createButtonLayout();

        add(image, title, layout, popupGif);
    }

    private HorizontalLayout createButtonLayout() {
        var yesButton = createButton("YES");
        var noButton = createButton("NO");

        yesButton.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        noButton.addThemeVariants(ButtonVariant.LUMO_TERTIARY);

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
            "    gif.src = 'hlg.gif?' + new Date().getTime();" +
            "    setTimeout(function() { gif.style.display = 'none'; }, 1000);" +
            "  }" +
            "});"
        );

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
