# 💕 Valentino - Valentine's Day Web App

A fun and interactive Valentine's Day web application built with **Vaadin** and **Spring Boot**.

![Java](https://img.shields.io/badge/Java-25-orange)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-4.0.2-green)
![Vaadin](https://img.shields.io/badge/Vaadin-25.0.4-blue)

## ✨ Features

- 🎀 **Beautiful Valentine's Theme** - Pink gradient background with custom styling
- 🖼️ **Animated GIFs** - Valentine's Day animations
- 🏃 **Runaway "NO" Button** - The NO button escapes the cursor when you try to click it
- 😜 **Popup GIF on Hover** - A GIF appears when the NO button runs away
- 📜 **Contract Overlay** - When they click YES, show them the "Valentine Contract" they can't close
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
│       └── HomeView.java            # Main Valentine's view
└── resources/
    ├── META-INF/resources/
    │   ├── styles.css               # Valentine's theme CSS
    │   ├── hlg.gif                  # Main Valentine GIF
    │   ├── tgg.gif                  # Popup GIF for NO button
    │   └── gpt-contract.png         # Valentine contract image
    └── application.properties
```

## 🎨 Customization

### Adding Your Own Images

Place your images in `src/main/resources/META-INF/resources/`:

- `hlg.gif` - Main GIF displayed on the page
- `tgg.gif` - GIF that appears when NO button runs away
- `placeholder.png` - Contract image shown on YES click

### Modifying the Theme

Edit `src/main/resources/META-INF/resources/styles.css` to customize:

- Background gradients
- Button colors
- Card animations
- Typography

## 🛠️ Technologies Used

- **[Vaadin 25](https://vaadin.com/)** - Java web framework for building modern web apps
- **[Spring Boot 4](https://spring.io/projects/spring-boot)** - Production-ready Spring applications
- **[Lumo Theme](https://vaadin.com/docs/latest/styling/lumo)** - Vaadin's default theme with CSS custom properties
