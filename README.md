# 🎉 Valentino - Holiday Web App

A fun and interactive holiday web application built with **Vaadin** and **Spring Boot**. Supports Valentine's Day, Easter, Halloween, and Christmas themes, with dynamic theme selection based on the current date.

![Java](https://img.shields.io/badge/Java-25-orange)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-4.0.2-green)
![Vaadin](https://img.shields.io/badge/Vaadin-25.0.4-blue)

## ✨ Features

- 🌈 **Multiple Holiday Themes** - Automatically switches between Valentine's, Easter, Halloween, and Christmas based on the date
- 🖼️ **Animated GIFs** - Holiday-specific animations
- 🏃 **Runaway "NO" Button** - The NO button escapes the cursor when you try to click it
- 😜 **Popup GIF on Hover** - A GIF appears when the NO button runs away
- 📜 **Contract Overlay** - Shows a custom contract image for each holiday when YES is clicked
- 💅 **Lumo Theme Integration** - Uses Vaadin's Lumo theme variables for consistent styling

## 🚀 Getting Started

### Prerequisites

- Java 25 or higher
- Maven 3.6+

### Running the Application

1. **Clone the repository**

   ```bash
   git clone <repository-url>
   cd valentino
   ```

2. **Run with Maven**

   ```bash
   ./mvnw spring-boot:run
   ```

3. **Open in browser**
   ```
   http://localhost:8080
   ```

## 📁 Project Structure

```
src/main/
├── java/com/valentino/
│   ├── ValentinoApplication.java    # Spring Boot main class
│   └── views/
│       └── HomeView.java            # Main view (handles all holidays)
└── resources/
   ├── META-INF/resources/
   │   ├── styles.css               # Holiday theme CSS
   │   ├── hlg.gif                  # Valentine GIF
   │   ├── pengu.gif                # Easter GIF
   │   ├── hallo.gif                # Halloween GIF
   │   ├── chrm.gif                 # Christmas GIF
   │   ├── tgg.gif                  # Popup GIF for NO button
   │   ├── valcont.png              # Valentine contract image
   │   ├── eastbny.png              # Easter contract image
   │   ├── hallowcont.png           # Halloween contract image
   │   └── chrmcont.png             # Christmas contract image
   └── application.properties
```

## 🎨 Customization

### Adding Your Own Images

Place your images in `src/main/resources/META-INF/resources/`:

- `hlg.gif` - Valentine GIF
- `pengu.gif` - Easter GIF
- `hallo.gif` - Halloween GIF
- `chrm.gif` - Christmas GIF
- `tgg.gif` - GIF that appears when NO button runs away
- `valcont.png` - Valentine contract image
- `eastbny.png` - Easter contract image
- `hallowcont.png` - Halloween contract image
- `chrmcont.png` - Christmas contract image

### Modifying the Theme

Edit `src/main/resources/META-INF/resources/styles.css` to customize:

- Background gradients for each holiday
- Button colors
- Card animations
- Typography

## 🛠️ Technologies Used

- **[Vaadin 25](https://vaadin.com/)** - Java web framework for building modern web apps
- **[Spring Boot 4](https://spring.io/projects/spring-boot)** - Production-ready Spring applications
- **[Lumo Theme](https://vaadin.com/docs/latest/styling/lumo)** - Vaadin's default theme with CSS custom properties
