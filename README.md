![Screenshot from 2025-03-26 23-49-51](https://github.com/user-attachments/assets/9ea2c025-4abb-4626-bf69-e3fa973cd82a)
![Uploading Screenshot from 2025-03-26 23-44-27.png…]()
![Screenshot from 2025-03-26 23-44-19](https://github.com/user-attachments/assets/b2b4a273-79fa-4fc3-a911-2b4e8a58bae0)
![Screenshot from 2025-03-26 23-44-09](https://github.com/user-attachments/assets/06affda5-2969-42da-8a2b-f74af1843e82)
![Screenshot from 2025-03-26 22-35-14](https://github.com/user-attachments/assets/abdc3984-6dfa-492b-8ac8-c65998ad5afc)
![Screenshot from 2025-03-26 22-34-42](https://github.com/user-attachments/assets/f5fb6e8f-2f39-4a7d-bad4-3bdc6188caf2)
# 📚 Digital Library Book Management System

## 🚀 Deployment
This is a console application. To run it:
```bash
git clone https://github.com/[YOUR_USERNAME]/digital-library.git
cd digital-library
javac *.java
java DigitalLibraryApp

🛠️ Setup Instructions
Requirements:

Java JDK 8+

Git (optional)

Running the App:

Compile: javac *.java

Execute: java DigitalLibraryApp

Features:

Add/View/Search/Update/Delete books

Input validation

Console menu interface

💡 Development Reflections
🧗 Challenges Faced
Input Validation:

Implementing checks for unique IDs and non-empty fields required careful loop structures

Handling user errors without crashing was tricky

Code Organization:

Initially mixed all logic in main class, later separated into proper OOP structure

Edge Cases:

Testing all possible user inputs (empty values, duplicates) took significant time

🔧 Future Improvements
Persistence:

Add database support (SQLite/MySQL) to save data between runs

Implement file storage as fallback


Enhanced Features:

Book borrowing/returning system with due dates

User authentication for librarians

Advanced search (by author/genre/availability)


UI Upgrade:

Convert to JavaFX for graphical interface

Add web interface using Spring Boot

Testing:

Implement https://github.com/Gayathri183/DigitalLibraryManagementSystem/tree/mainunit tests (JUnit)

Add CI/CD pipeline

📜 License
MIT License




