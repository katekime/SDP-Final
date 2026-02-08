# Restaurant Ordering System

A comprehensive Java-based restaurant ordering system that demonstrates the implementation of multiple software design patterns. This project was developed as a final project for Software Design Patterns course.

## 📋 Table of Contents

- [Overview](#overview)
- [Features](#features)
- [Design Patterns Implemented](#design-patterns-implemented)
- [Project Structure](#project-structure)
- [Requirements](#requirements)
- [Installation](#installation)
- [Usage](#usage)
- [How It Works](#how-it-works)

## 🎯 Overview

This restaurant ordering system provides a complete solution for managing restaurant orders, including menu selection, payment processing, and order tracking. The system supports both dine-in and take-away orders, offering Japanese and Kazakh cuisine options with customizable decorations.

## ✨ Features

- **Dual Order Types**: Support for dine-in (inside restaurant) and take-away orders
- **Multi-Cuisine Support**: Japanese and Kazakh cuisine options
- **Customizable Menu Items**: Add decorations and toppings to dishes
- **Multiple Payment Methods**: 
  - Credit Card
  - Cash
  - Kaspi Alaqan
- **Multi-Currency Support**: USD, KZT, JPY, and RUB
- **Service Fee Option**: Optional 10% service fee for dine-in orders
- **Order Tracking**: Real-time order status updates (Preparing → Ready → Served)
- **Interactive Console Interface**: User-friendly command-line interface

## 🏗️ Design Patterns Implemented

This project demonstrates the practical implementation of the following design patterns:

### 1. **Abstract Factory Pattern**
- **Location**: `abstractFactory/`
- **Purpose**: Creates families of related cuisine objects (Japanese and Kazakh)
- **Implementation**: 
  - `CuisineFactory` (abstract)
  - `JapaneseCuisineFactory`
  - `KazakhCuisineFactory`

### 2. **Factory Method Pattern**
- **Location**: `factory/`
- **Purpose**: Creates different types of orders (dine-in vs take-away)
- **Implementation**:
  - `OrderFactory` (abstract)
  - `InsideOrderFactory`
  - `TakeAwayOrderFactory`

### 3. **Decorator Pattern**
- **Location**: `decorator/`
- **Purpose**: Dynamically adds decorations/toppings to menu items
- **Implementation**:
  - `MenuItemDecorator` (abstract)
  - `WasabiDecorator`
  - `LemonDecorator`
  - `SorpaDecorator`

### 4. **Strategy Pattern**
- **Location**: `strategy/`
- **Purpose**: Implements different payment methods
- **Implementation**:
  - `Strategy` (interface)
  - `CardPayment`
  - `CashPayment`
  - `KaspiAlaqanPayment`

### 5. **Adapter Pattern**
- **Location**: `adapter/`
- **Purpose**: Adapts external currency exchange API for payment processing
- **Implementation**:
  - `CurrencyExchangeAdapter`
  - `CurrencyPaymentAdapter`
  - `ExternalExchangeApi`

### 6. **Observer Pattern**
- **Location**: `observer/`
- **Purpose**: Notifies kitchen and customers about order status changes
- **Implementation**:
  - `Observer` (interface)
  - `KitcherObserver`
  - `CustomerObserver`

### 7. **Visitor Pattern**
- **Location**: `visitor/`
- **Purpose**: Calculates service fees for different menu items
- **Implementation**:
  - `MenuItemVisitor` (interface)
  - `ServeFeeVisitor`

### 8. **Facade Pattern**
- **Location**: `facade/`
- **Purpose**: Provides a simplified interface to the complex restaurant system
- **Implementation**:
  - `RestaurantFacade`

## 📁 Project Structure

```
SDP-Final/
├── src/
│   └── main/
│       └── java/
│           └── org/
│               └── example/
│                   ├── Main.java
│                   ├── abstractFactory/
│                   │   ├── CuisineFactory.java
│                   │   ├── JapaneseCuisineFactory.java
│                   │   └── KazakhCuisineFactory.java
│                   ├── adapter/
│                   │   ├── CurrencyConverter.java
│                   │   ├── CurrencyExchangeAdapter.java
│                   │   ├── CurrencyPaymentAdapter.java
│                   │   └── ExternalExchangeApi.java
│                   ├── decorator/
│                   │   ├── LemonDecorator.java
│                   │   ├── MenuItemDecorator.java
│                   │   ├── SorpaDecorator.java
│                   │   └── WasabiDecorator.java
│                   ├── dishes/
│                   │   ├── JapaneseAppetizer.java
│                   │   ├── JapaneseDessert.java
│                   │   ├── JapaneseDrink.java
│                   │   ├── JapaneseMainCourse.java
│                   │   ├── KazakhAppetizer.java
│                   │   ├── KazakhDessert.java
│                   │   ├── KazakhDrink.java
│                   │   └── KazakhMainCourse.java
│                   ├── facade/
│                   │   └── RestaurantFacade.java
│                   ├── factory/
│                   │   ├── InsideOrderFactory.java
│                   │   ├── Order.java
│                   │   ├── OrderFactory.java
│                   │   └── TakeAwayOrderFactory.java
│                   ├── model/
│                   │   ├── Appetizer.java
│                   │   ├── Dessert.java
│                   │   ├── Drink.java
│                   │   ├── MainCourse.java
│                   │   └── MenuItem.java
│                   ├── observer/
│                   │   ├── CustomerObserver.java
│                   │   ├── KitcherObserver.java
│                   │   └── Observer.java
│                   ├── strategy/
│                   │   ├── CardPayment.java
│                   │   ├── CashPayment.java
│                   │   ├── KaspiAlaqanPayment.java
│                   │   └── Strategy.java
│                   └── visitor/
│                       ├── MenuItemVisitor.java
│                       └── ServeFeeVisitor.java
├── pom.xml
└── README.md
```

## 🔧 Requirements

- **Java**: JDK 25 or higher
- **Maven**: 3.6 or higher
- **IDE**: IntelliJ IDEA, Eclipse, or any Java IDE (optional)

## 📦 Installation

1. **Clone the repository**:
   ```bash
   git clone https://github.com/katekime/SDP-Final.git
   cd SDP-Final
   ```

2. **Build the project with Maven**:
   ```bash
   mvn clean install
   ```

3. **Compile the project**:
   ```bash
   mvn compile
   ```

## 🚀 Usage

### Running the Application

You can run the application using Maven:

```bash
mvn exec:java -Dexec.mainClass="org.example.Main"
```

Or, if you're using an IDE:
1. Open the project in your IDE
2. Navigate to `src/main/java/org/example/Main.java`
3. Run the `Main` class

### Using the System

1. **Start the application** - The system will greet you with a welcome message

2. **Select order type**:
   - Option 1: Dine-in (Inside restaurant)
   - Option 2: Take-away

3. **Add items to your order**:
   - Option 1: Add a full cuisine set (includes appetizer, main course, drink, and dessert)
   - Option 2: Add individual items
   - Option 3: Finish adding items

4. **Customize items** (optional):
   - Add decorations like wasabi, lemon, or sorpa
   - Enter custom decorations

5. **Review order summary** - The system displays all items and total cost

6. **Choose service fee** - Decide whether to include a 10% service fee

7. **Select payment method**:
   - Credit Card
   - Cash
   - Kaspi Alaqan

8. **Choose currency**:
   - USD
   - KZT (Kazakhstani Tenge)
   - JPY (Japanese Yen)
   - RUB (Russian Ruble)

9. **Track order status** - Watch your order progress through:
   - Preparing
   - Ready
   - Served

10. **Place another order** (optional) - Continue ordering or exit

## 🔍 How It Works

### Order Flow

1. **Order Creation**: The system uses the Factory Method pattern to create either an inside or take-away order
2. **Menu Selection**: Abstract Factory pattern creates cuisine-specific dishes (Japanese or Kazakh)
3. **Customization**: Decorator pattern adds optional toppings and decorations
4. **Order Summary**: Facade pattern provides a simple interface to display the complete order
5. **Service Fee Calculation**: Visitor pattern calculates applicable service fees
6. **Payment Processing**: 
   - Strategy pattern handles different payment methods
   - Adapter pattern converts currencies if needed
7. **Order Tracking**: Observer pattern notifies kitchen and customers of status changes

### Example Session

```
RESTAURANT ORDERING SYSTEM
Welcome to Our Restaurant

NEW ORDER
1. Dine-in (Inside restaurant)
2. Take-away
Select order type 1-2: 1

ADD ITEMS
1. Add full cuisine set (Appetizer + Main + Drink + Dessert)
2. Add individual item
3. Finish adding items
Select option 1-3: 1

Select Cuisine
1. Japanese Cuisine
2. Kazakh Cuisine
Select cuisine 1-2: 1
Full japanese set added!

[Order summary displayed...]

Include 10% service fee? yes/no: yes

PAYMENT
1. Credit Card
2. Cash
3. Kaspi Alaqan
Select payment method 1-3: 1

Select Currency
1. USD
2. KZT
3. JPY
4. RUB
Select currency 1-4: 1

[Payment processed and order completed...]
```

## 👥 Contributors

This project was developed as part of the Software Design Patterns course final project.

## 📄 License

This project is developed for educational purposes as part of a university course.

---

**Note**: This is an educational project demonstrating software design patterns in a practical application. It is not intended for production use.
