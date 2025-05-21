# 🎬 MovieBookingJNI

A **terminal-based Movie Ticket Booking System** combining the power of **C++ backend processing** with a **Java interface** via **JNI (Java Native Interface)**. This project demonstrates seamless interoperability between two languages to provide a modular, efficient, and user-friendly movie booking experience.

---

## 📌 Project Overview

**MovieBookingJNI** streamlines the process of booking movie tickets through a command-line interface. It handles movie listings, seat selection, user authentication, and booking confirmation — all while showcasing C++ and Java integration using JNI.

---

## 🚀 Features

### ✅ Core Functionality
- 🎞️ Display available movies and showtimes  
- 👤 User registration and authentication  
- 🎟️ Seat selection and ticket booking  
- 🧾 Generate and display booking receipts  

### 🔧 Technology Integration
- 🧠 **C++** for backend logic (performance-critical operations)  
- 💻 **Java** for UI and program control  
- 🔗 **JNI (Java Native Interface)** for seamless communication  

---

## 🧭 Future Enhancements

- 🌐 GUI-based interface for better UX  
- 💳 Integration with payment systems (UPI/e-wallets)  
- ☁️ Cloud storage and multi-user concurrency  
- 🧠 Personalized movie recommendations  
- 🧩 Modular expansion for advanced ticketing

---

## 🎯 Project Objectives

- ✔️ Streamline ticket booking with modular code structure  
- ✔️ Demonstrate cross-language development via JNI  
- ✔️ Emphasize system efficiency using a terminal UI  
- ✔️ Apply real-world OOP, file handling, and JNI integration

---

## 🛠️ System Overview

### 🧑‍💻 Languages and Technologies
| Component        | Language     |
|------------------|--------------|
| User Interface   | Java         |
| Backend Logic    | C++          |
| Integration      | JNI          |

### 📥 Input
- Movie selection, theatre, date, seat number  
- User credentials (email, password)  
- Admin inputs: movie and theatre updates  

### 📤 Output
- List of movies and showtimes  
- Seat layout and availability  
- Booking confirmation  
- Admin logs and reports  

---

## 🔄 Detailed Use Cases

### 👥 User Management
- Registration, login, and profile management  
- View and manage booking history  

### 🎞️ Movie Management
- Browse and filter movies by genre/language  
- Admin: Add/remove/update movie details  

### 🎟️ Booking System
- Real-time seat availability and selection  
- Booking confirmation and cancellation  

### ⚙️ Error Handling
- Input validation  
- Prevent duplicate bookings  

---

## 📂 File Structure
<pre lang="markdown"> ```bash MoviebookingJNI/ ├── .vscode/ # VS Code configuration ├── BookYourShow.java # Java logic ├── BookYourShow.h # JNI header ├── core.cpp # Native C++ code ├── Customers.txt # Customer data ├── movies.txt # Movie data ├── Theatres.txt # Theatre data ``` </pre>

---

## 🧪 Testing & Logging

- 🧪 Unit tests for core classes (`Movie`, `Seat`, `Booking`, etc.)  
- 🧾 Log booking failures, invalid inputs, and exceptions  

---

## 🔁 Workflow Summary

**[User]**  
⬇️ Login / Register  
⬇️ View Movies  
⬇️ Select Show & Seats  
⬇️ Confirm Booking  
⬇️ View Ticket / Cancel  

**[Admin]**  
⬇️ Login  
⬇️ Manage Movies / Theatres  
⬇️ Monitor Logs  


---

## 🧰 Development Setup

### 1. Compile C++ Code to Shared Library

Linux:
```bash
g++ -fPIC -I${JAVA_HOME}/include -I${JAVA_HOME}/include/linux -shared -o core.so core.cpp
```

Windows:
```
g++ -I"%JAVA_HOME%/include" -I"%JAVA_HOME%/include/win32" -shared -o BookYourShow.dll core.cpp
```

🧾 License
----------
This project is for educational and demonstration purposes. No license applied.



## 🌟 Show your support!

If you like this project:

- ⭐ Star this repo  
- 🛠️ Fork it to contribute  
- 📢 Share with fellow developers  







