# Bus Seat Reservation System (BSRS)

A Java-based command-line application for managing bus reservations, customer bookings, and seat availability.

## Features

- **Customer Management**
  - Add new customers
  - Update customer details
  - Remove customers
  - View all customers

- **Bus Management**
  - Register new buses
  - Remove buses from the system
  - View all registered buses
  - Track seat availability

- **Reservation System**
  - Make seat reservations
  - Cancel reservations
  - View all reservations
  - Automatic queue management for occupied seats

## Project Structure

- `BSRS.java` - Main system implementation with core functionality
- `Bus.java` - Bus entity class
- `Customer.java` - Customer entity class
- `CustomerSorter.java` - Utility class for sorting customers
- `Main.java` - Command-line interface implementation
- `OldestToNewestCustomerList.java` - Customer list management utility
- `Reservation.java` - Reservation entity class

## Getting Started

### Prerequisites

- Java Development Kit (JDK) 8 or higher
- Java IDE (optional)

### Installation

1. Clone the repository:
```bash
git clone https://github.com/SupunLakshithe/bus-seat-reservation-system.git
```

2. Navigate to the project directory:
```bash
cd bus-seat-reservation-system
```

3. Compile the Java files:
```bash
javac *.java
```

4. Run the application:
```bash
java Main
```

## Usage

The system provides a command-line interface with the following main options:

![image](https://github.com/user-attachments/assets/104bd7a1-150c-4155-bc4b-935c89fc5103)

1. **Manage Customers (Option 1)**
   - Add new customers
   - Update existing customer details
   - Remove customers from the system

2. **Manage Buses (Option 2)**
   - Register new buses
   - Remove buses
   - View bus details

3. **Manage Reservations (Option 3)**
   - Make new reservations
   - List all reservations
   - Cancel reservations
   - View waiting queue for seats

### Key Features

- **Queue Management**: Automatically manages waiting lists for occupied seats
- **Real-time Availability**: Shows current seat availability for each bus
- **Customer Tracking**: Maintains customer history and details
- **Flexible Booking**: Supports multiple reservations per customer

## Technical Details

- Implemented in Java
- Uses data structures like HashMaps and ArrayLists for efficient data management
- Includes sorting algorithms (QuickSort and BubbleSort) for customer management
- Implements queue-based waiting list system

## Contributing

Feel free to fork the project and submit pull requests for any improvements.

1. Fork the Project
2. Create your Feature Branch (`git checkout -b feature/AmazingFeature`)
3. Commit your Changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the Branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

## License

This project is licensed under the MIT License.

## Contact

Supun Lakshithe - [slsomarathna47@gmail.com](mailto:slsomarathna47@gmail.com)

Project Link: [https://github.com/SupunLakshithe/bus-seat-reservation-system](https://github.com/SupunLakshithe/bus-seat-reservation-system)
