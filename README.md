# Parking Lot System (LLD)

This repository implements a Low-Level Design (LLD) of a parking lot system in Java. It includes various design patterns and principles to manage parking lots efficiently.

## Features
- Vehicle entry and exit management
- Multiple parking spot types (compact, large, etc.)
- Dynamic allocation of spots using a parking strategy
- Ticket generation and pricing based on parking duration
- Observer pattern for event tracking

## Prerequisites
- Java 8+
- Maven

## Installation
1. Clone the repository:
   ```bash
   git clone https://github.com/FazeelUsmani/LLD_ParkingLot.git
   cd LLD_ParkingLot
   ```

2. Build the project using Maven:
   ```bash
   mvn clean install
   ```

## Usage
Run the application by executing the main class:
```bash
java -jar target/parking-lot.jar
```

## Design Patterns Used
- **Singleton**: For the parking lot instance
- **Observer**: To notify observers on parking events
- **Strategy**: For flexible parking allocation strategies

## License
This project is licensed under the MIT License.
