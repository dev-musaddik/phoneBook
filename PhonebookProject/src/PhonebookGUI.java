/**
 * Phonebook JavaFX GUI Application
 *
 * Developed by: Md. Musaddik Hossain
 * Phone Number: 01757346415
 * Board Roll: 731286
 * Department: Computer Science and Technology
 * Semester: 5th
 * Shift: Morning
 * Institute: Faridpur Polytechnic Institute
 */

 import javafx.application.Application;
 import javafx.geometry.Insets;
 import javafx.geometry.Pos;
 import javafx.scene.Scene;
 import javafx.scene.control.*;
 import javafx.scene.layout.*;
 import javafx.scene.text.Font;
 import javafx.scene.text.FontWeight;
 import javafx.stage.Stage;
 
 public class PhonebookGUI extends Application {
     private final Phonebook phonebook = new Phonebook();
 
     public static void main(String[] args) {
         launch(args);
     }
 
     @Override
     public void start(Stage primaryStage) {
         primaryStage.setTitle("📱 Phonebook Application");
 
         BorderPane root = new BorderPane();
         root.setPadding(new Insets(20));
 
         Label title = new Label("📖 Phonebook Directory");
         title.setFont(Font.font("Arial", FontWeight.BOLD, 22));
         title.setStyle("-fx-text-fill: #2c3e50;");
         title.setAlignment(Pos.CENTER);
 
         GridPane formLayout = new GridPane();
         formLayout.setHgap(10);
         formLayout.setVgap(10);
         formLayout.setPadding(new Insets(10));
 
         Label nameLabel = new Label("Name:");
         TextField nameField = new TextField();
         nameField.setPromptText("Enter full name");
 
         Label phoneLabel = new Label("Phone Number:");
         TextField phoneField = new TextField();
         phoneField.setPromptText("Enter phone number");
 
         formLayout.add(nameLabel, 0, 0);
         formLayout.add(nameField, 1, 0);
         formLayout.add(phoneLabel, 0, 1);
         formLayout.add(phoneField, 1, 1);
 
         HBox buttonBox = new HBox(10);
         Button addButton = new Button("➕ Add Contact");
         Button searchButton = new Button("🔍 Search");
         Button listButton = new Button("📋 Show All");
         Button deleteButton = new Button("🗑️ Delete");
         Button updateButton = new Button("✏️ Update");
 
         buttonBox.getChildren().addAll(addButton, searchButton, listButton, deleteButton, updateButton);
         buttonBox.setAlignment(Pos.CENTER);
         buttonBox.setPadding(new Insets(10, 0, 10, 0));
 
         TextArea outputArea = new TextArea();
         outputArea.setEditable(false);
         outputArea.setWrapText(true);
         outputArea.setPrefHeight(200);
 
         VBox centerBox = new VBox(10, formLayout, buttonBox, outputArea);
         centerBox.setPadding(new Insets(10, 0, 0, 0));
         root.setTop(title);
         BorderPane.setAlignment(title, Pos.CENTER);
         root.setCenter(centerBox);
 
         Label devInfo = new Label(
             "Developed by: Md. Musaddik Hossain | Roll: 731286\n" +
             "Dept: Computer Science & Tech | 5th Semester, Morning Shift\n" +
             "Institute: Faridpur Polytechnic Institute | Contact: 01757346415"
         );
         devInfo.setFont(Font.font("Consolas", 11));
         devInfo.setStyle("-fx-background-color: #ecf0f1; -fx-text-fill: #34495e; -fx-padding: 10px;");
         devInfo.setAlignment(Pos.CENTER);
         devInfo.setMaxWidth(Double.MAX_VALUE);
         root.setBottom(devInfo);
 
         // Add Contact
         addButton.setOnAction(e -> {
             String name = nameField.getText().trim();
             String phone = phoneField.getText().trim();
             if (!name.isEmpty() && phone.matches("\\d+")) {
                 phonebook.addContact(new Contact(name, phone));
                 nameField.clear();
                 phoneField.clear();
                 outputArea.setText("✅ Contact added: " + name + " - " + phone);
             } else {
                 outputArea.setText("⚠️ Please enter a valid name and numeric phone number.");
             }
         });
 
         // Search Contact
         searchButton.setOnAction(e -> {
             String name = nameField.getText().trim();
             if (!name.isEmpty()) {
                 Contact found = phonebook.searchByName(name);
                 outputArea.setText(found != null ?
                     "🔎 Contact Found:\n" + found :
                     "❌ No contact found with the name: " + name);
             } else {
                 outputArea.setText("⚠️ Please enter a name to search.");
             }
         });
 
         // List All Contacts
         listButton.setOnAction(e -> {
             StringBuilder all = new StringBuilder("📇 All Contacts:\n");
             if (phonebook.getContacts().isEmpty()) {
                 all.append("📭 No contacts saved yet.");
             } else {
                 for (Contact c : phonebook.getContacts()) {
                     all.append("- ").append(c).append("\n");
                 }
             }
             outputArea.setText(all.toString());
         });
 
         // Delete Contact
         deleteButton.setOnAction(e -> {
             String name = nameField.getText().trim();
             if (!name.isEmpty()) {
                 boolean removed = phonebook.deleteContact(name);
                 outputArea.setText(removed ?
                     "🗑️ Contact deleted: " + name :
                     "❌ Contact not found.");
             } else {
                 outputArea.setText("⚠️ Please enter a name to delete.");
             }
         });
 
         // Update Contact
         updateButton.setOnAction(e -> {
             String name = nameField.getText().trim();
             String phone = phoneField.getText().trim();
             if (!name.isEmpty() && phone.matches("\\d+")) {
                 boolean updated = phonebook.updateContact(name, phone);
                 outputArea.setText(updated ?
                     "✏️ Contact updated!" :
                     "❌ Contact not found.");
             } else {
                 outputArea.setText("⚠️ Enter both name and valid phone number to update.");
             }
         });
 
         Scene scene = new Scene(root, 520, 540);
         primaryStage.setScene(scene);
         primaryStage.show();
     }
 }
 