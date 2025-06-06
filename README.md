# 📱 Phonebook Java Application

A simple phonebook application built with **Java** and **JavaFX**, allowing you to manage contacts with a user-friendly graphical interface.

---

## ✨ Features

- **Add New Contacts** – Input name and phone number to add a contact.
- **Search by Name** – Search for a contact by typing their name.
- **List All Contacts** – View a list of all stored contacts.
- **Save/Load Contacts** – Contacts are saved in a `contacts.csv` file and can be reloaded when the app is restarted.

---

## ✅ Requirements

- **Java 11 or higher**
- **JavaFX SDK** (required separately for Java 11+)

---

## 🛠️ Installation Steps

### 1. Clone or Download the Project

```bash
git clone https://github.com/your-repo/phonebook-java.git
cd phonebook-java
```

### 2. Verify Java Installation

```bash
java -version
```

### 3. Download and Setup JavaFX

- Download JavaFX SDK from [Gluon](https://gluonhq.com/products/javafx/).
- Extract it (e.g., `C:\javafx-sdk-17.0.15`).

---

## 🚀 Running the Application

### Compile

```bash
javac --module-path "C:\Program Files\Java\javafx-sdk-17.0.15\lib" --add-modules javafx.controls,javafx.fxml *.java
```

### Run

```bash
java --module-path "C:\Program Files\Java\javafx-sdk-17.0.15\lib" --add-modules javafx.controls,javafx.fxml PhonebookGUI
```

---

## 📂 Code Structure

| File Name             | Description                                        |
| --------------------- | -------------------------------------------------- |
| `Contact.java`        | Represents a contact with name and phone number.   |
| `Phonebook.java`      | Contains logic for adding, searching, and listing. |
| `PhonebookGUI.java`   | JavaFX UI to interact with the phonebook.          |
| `ContactManager.java` | Handles saving/loading contacts from/to CSV.       |

---

## 🧪 Example Usage

### ➕ Add Contact

- Enter a name and phone number.
- Click **“Add Contact”**.

### 🔍 Search Contact

- Enter a name.
- Click **“Search by Name”**.

### 📋 List All Contacts

- Click **“List All Contacts”** to view all saved entries.

---

## 🛠️ Troubleshooting

| Issue                             | Solution                                                                              |
| --------------------------------- | ------------------------------------------------------------------------------------- |
| `Contact class not found`         | Ensure `Contact.java` is in the same directory and compiled.                          |
| `No module path found for JavaFX` | Verify that the JavaFX SDK is correctly installed and the `--module-path` is correct. |

---

## 🤝 Contributing

1. Fork the repository.
2. Make your changes.
3. Submit a Pull Request.

---
#   p h o n e B o o k  
 