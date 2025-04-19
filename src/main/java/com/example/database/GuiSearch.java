package com.example.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class GuiSearch extends Application {
	static MySQLJDBCConnection Conn = new MySQLJDBCConnection();

	private DatePicker datePicker = new DatePicker();
	private Label ProductID = new Label("ProductID: ");
	private Label InvoiceID = new Label("InvoiceID: ");
	private Label OrderNumber = new Label("OrderNumber: ");
	private Label ShipCode = new Label("ShipCode: ");
	private Label CustsomerID = new Label("CustsomerID: ");
	private Label EmployeeID = new Label("EmployeeID: ");
	private Label SupplierID = new Label("SupplierID: ");
	private Label ManufacturerID = new Label("ProductID: ");
	private Label lbResult = new Label("");
	private TextField ProductIDT = new TextField();
	private TextField InvoiceIDT = new TextField();
	private TextField OrderNumberT = new TextField();
	private TextField EmployeeIDT = new TextField();
	private TextField SupplierIDT = new TextField();
	private TextField ManufacturerIDT = new TextField();
	private TextField ShipCodeT = new TextField();
	private TextField CustsomerIDT = new TextField();

	private VBox vb1 = new VBox();
	private HBox hb1 = new HBox();
	private HBox hb5 = new HBox();
	private Button ok = new Button("OK");

	@Override
	public void start(Stage primaryStage) {
		VBox mainLayout = new VBox(10); // VBox with spacing of 10

		Button btnAddRecordInventory = new Button("Add Inventory Item");
//        btnAddRecordInventory.setOnAction(e -> searchRecordinventoryItems());

		Button btnAddRecordOrder = new Button("Add Order");
//        btnAddRecordOrder.setOnAction(e -> searchRecordOrder());

		Button btnAddRecordFinance = new Button("Add Finance");
//        btnAddRecordFinance.setOnAction(e -> searchRecordFinance());

		Button btnAddRecordCustomer = new Button("Add Customer");
//        btnAddRecordCustomer.setOnAction(e -> searchRecordCustomer(TableView<Customer> customerTable));

		Button btnAddRecordShipment = new Button("Add Shipment");
//        btnAddRecordShipment.setOnAction(e -> searchRecordShipment());

		// Add all buttons to VBox
		mainLayout.getChildren().addAll(btnAddRecordInventory, btnAddRecordOrder, btnAddRecordFinance,
				btnAddRecordCustomer, btnAddRecordShipment);

		Scene scene = new Scene(mainLayout, 300, 250);
		primaryStage.setTitle("Data Management");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

	public void searchRecordinventoryItems(TableView<InventoryItems> inventoryTable) {// a method that adds a new method
																						// to the tree
		Stage adding = new Stage();
		VBox vbox = new VBox(10); // VBox with spacing of 10
		vbox.setAlignment(Pos.CENTER); // Align vbox children to center
		vbox.getChildren().clear();
		lbResult.setText("");
		ProductIDT.clear();
		hb1.getChildren().clear();
		hb1.getChildren().addAll(ProductID, ProductIDT);
		hb1.setAlignment(Pos.CENTER);
		hb5.getChildren().clear();
		hb5.getChildren().addAll(ok, lbResult);
		hb5.setAlignment(Pos.CENTER);

		// Add all HBoxes to VBox
		vbox.getChildren().addAll(hb1, hb5);

		// Add vbox to the scene
		Scene scene = new Scene(vbox, 250, 150);

		ok.setOnAction(e -> {

			try {
				// uses the data we got from the fields to insert new data parameters
				// adds the data inside the tree

				int id = Integer.parseInt(ProductIDT.getText());
				Searchinventory(inventoryTable, id);

				adding.close();
				// Add the record to the ObservableList
				// Update the TableView
				// table.setItems();
			} catch (NumberFormatException ex) {
				lbResult.setText("Invalid input. Please enter valid numeric values.");

			}
		});

		adding.setScene(scene);
		adding.setTitle("searchRecordinventoryItems");
		scene.getStylesheets().add(getClass().getResource("styles.css").toExternalForm());
		adding.show();
	}

	public void searchRecordOrder(TableView<Order> OrderTable) {// a method that adds a new method to the tree
		Stage adding = new Stage();
		VBox vbox = new VBox(10); // VBox with spacing of 10
		vbox.setAlignment(Pos.CENTER); // Align vbox children to center
		Scene pane = new Scene(vbox, 250, 150);
		lbResult.setText("");
		OrderNumberT.clear();
		hb1.getChildren().clear();
		hb1.getChildren().addAll(OrderNumber, OrderNumberT);
		hb1.setAlignment(Pos.CENTER);
		hb5.getChildren().clear();
		hb5.getChildren().addAll(ok, lbResult);
		hb5.setAlignment(Pos.CENTER);
		vbox.getChildren().clear();// clears the gui and inserts new records
		vbox.getChildren().addAll(hb1, hb5);

		vb1.setAlignment(Pos.CENTER);

		ok.setOnAction(e -> {

			try {
				// uses the data we got from the fields to insert new data parameters
				int ordernum = Integer.parseInt(OrderNumberT.getText());
				// adds the data inside the tree
				searchOreder(OrderTable, ordernum);

				adding.close();

				// Add the record to the ObservableList
				// Update the TableView
				// table.setItems();
			} catch (NumberFormatException ex) {
				lbResult.setText("Invalid input. Please enter valid numeric values.");

			}
		});

		adding.setScene(pane);
		adding.setTitle("searchRecordOrder");
		pane.getStylesheets().add(getClass().getResource("styles.css").toExternalForm());
		adding.show();
	}

	public void searchRecordFinance(TableView<Finance> FianaceTable) {// a method that adds a new method to the tree
		Stage adding = new Stage();
		VBox vbox = new VBox(10); // VBox with spacing of 10
		vbox.setAlignment(Pos.CENTER); // Align vbox children to center
		Scene pane = new Scene(vbox, 250, 150);
		lbResult.setText("");
		InvoiceIDT.clear();
		hb1.getChildren().clear();
		hb1.getChildren().addAll(InvoiceID, InvoiceIDT);
		hb1.setAlignment(Pos.CENTER);
		hb5.getChildren().clear();
		hb5.getChildren().addAll(ok, lbResult);
		hb5.setAlignment(Pos.CENTER);

		vbox.getChildren().clear();// clears the gui and inserts new records
		vbox.getChildren().addAll(hb1, hb5);

		vbox.setAlignment(Pos.CENTER);

		ok.setOnAction(e -> {

			try {
				// uses the data we got from the fields to insert new data parameters
				int id = Integer.parseInt(InvoiceIDT.getText());

				SearchFinance(FianaceTable, id);
				// adds the data inside the tree

				adding.close();

				// Add the record to the ObservableList
				// Update the TableView
				// table.setItems();
			} catch (NumberFormatException ex) {
				lbResult.setText("Invalid input. Please enter valid numeric values.");

			}
		});

		adding.setScene(pane);
		adding.setTitle("searchRecordFinance");
		pane.getStylesheets().add(getClass().getResource("styles.css").toExternalForm());
		adding.show();
	}

	public void searchRecordCustomer(TableView<Customer> customerTable) {// a method that adds a new method to the tree
		Stage adding = new Stage();
		VBox vbox = new VBox(10); // VBox with spacing of 10
		vbox.setAlignment(Pos.CENTER); // Align vbox children to center
		Scene pane = new Scene(vbox, 250, 150);
		lbResult.setText("");
		CustsomerIDT.clear();
		hb1.getChildren().clear();
		hb1.getChildren().addAll(CustsomerID, CustsomerIDT);
		hb1.setAlignment(Pos.CENTER);
		hb5.getChildren().clear();
		hb5.getChildren().addAll(ok, lbResult);
		hb5.setAlignment(Pos.CENTER);

		vbox.getChildren().clear();// clears the gui and inserts new records
		vbox.getChildren().addAll(hb1, hb5);

		vbox.setAlignment(Pos.CENTER);

		ok.setOnAction(e -> {

			try {
				// uses the data we got from the fields to insert new data parameters
				int cid = Integer.parseInt(CustsomerIDT.getText());
				// adds the data inside the tree

				SearchCustomer(customerTable, cid);

				adding.close();

				// Add the record to the ObservableList
				// Update the TableView
				// table.setItems();
			} catch (NumberFormatException ex) {
				lbResult.setText("Invalid input. Please enter valid numeric values.");

			}
		});

		adding.setScene(pane);
		adding.setTitle("searchRecordCustomer");
		pane.getStylesheets().add(getClass().getResource("styles.css").toExternalForm());
		adding.show();

	}

	public void searchRecordShipment(TableView<Shipment> ShipmentTable) {// a method that adds a new method to the tree
		Stage adding = new Stage();
		VBox vbox = new VBox(10); // VBox with spacing of 10
		vbox.setAlignment(Pos.CENTER); // Align vbox children to center
		Scene pane = new Scene(vbox, 250, 150);
		lbResult.setText("");
		ShipCodeT.clear();
		hb1.getChildren().clear();
		hb1.getChildren().addAll(ShipCode, ShipCodeT);
		hb1.setAlignment(Pos.CENTER);
		hb5.getChildren().clear();
		hb5.getChildren().addAll(ok, lbResult);
		hb5.setAlignment(Pos.CENTER);

		vbox.getChildren().clear();// clears the gui and inserts new records
		vbox.getChildren().addAll(hb1, hb5);
		vbox.setAlignment(Pos.CENTER);

		ok.setOnAction(e -> {

			try {
				// uses the data we got from the fields to insert new data parameters
				String Shipcode = ShipCodeT.getText();

				searchShipment(ShipmentTable, Shipcode);

				// adds the data inside the tree

				adding.close();

				// Add the record to the ObservableList
				// Update the TableView
				// table.setItems();
			} catch (NumberFormatException ex) {
				lbResult.setText("Invalid input. Please enter valid numeric values.");
			}
		});

		adding.setScene(pane);
		adding.setTitle("searchRecordShipment");
		pane.getStylesheets().add(getClass().getResource("styles.css").toExternalForm());
		adding.show();

	}

	public void searchSoldItems(TableView<SoldItems> SoldItemstable) {// a method that adds a new method to the tree
		Stage adding = new Stage();
		VBox vbox = new VBox(10); // VBox with spacing of 10
		vbox.setAlignment(Pos.CENTER); // Align vbox children to center
		vbox.getChildren().clear();
		lbResult.setText("");
		ProductIDT.clear();
		hb1.getChildren().clear();
		hb1.getChildren().addAll(ProductID, ProductIDT);
		hb1.setAlignment(Pos.CENTER);
		hb5.getChildren().clear();
		hb5.getChildren().addAll(ok, lbResult);
		hb5.setAlignment(Pos.CENTER);

		// Add all HBoxes to VBox
		vbox.getChildren().addAll(hb1, hb5);

		// Add vbox to the scene
		Scene scene = new Scene(vbox, 250, 150);

		ok.setOnAction(e -> {

			try {
				// uses the data we got from the fields to insert new data parameters
				// adds the data inside the tree

				int id = Integer.parseInt(ProductIDT.getText());
				SearchSoldItems(SoldItemstable, id);

				adding.close();
				// Add the record to the ObservableList
				// Update the TableView
				// table.setItems();
			} catch (NumberFormatException ex) {
				lbResult.setText("Invalid input. Please enter valid numeric values.");

			}
		});

		adding.setScene(scene);
		adding.setTitle("searchRecordSoldItems");
		scene.getStylesheets().add(getClass().getResource("styles.css").toExternalForm());
		adding.show();
	}

	public void searchManufacture(TableView<Manufacturing> SoldItemstable) {// a method that adds a new method to the
																			// tree
		Stage adding = new Stage();
		VBox vbox = new VBox(10); // VBox with spacing of 10
		vbox.setAlignment(Pos.CENTER); // Align vbox children to center
		vbox.getChildren().clear();
		lbResult.setText("");
		ManufacturerIDT.clear();
		hb1.getChildren().clear();
		hb1.getChildren().addAll(ManufacturerID, ManufacturerIDT);
		hb1.setAlignment(Pos.CENTER);
		hb5.getChildren().clear();
		hb5.getChildren().addAll(ok, lbResult);
		hb5.setAlignment(Pos.CENTER);

		// Add all HBoxes to VBox
		vbox.getChildren().addAll(hb1, hb5);

		// Add vbox to the scene
		Scene scene = new Scene(vbox, 250, 150);

		ok.setOnAction(e -> {

			try {
				// uses the data we got from the fields to insert new data parameters
				// adds the data inside the tree

				int id = Integer.parseInt(ManufacturerIDT.getText());
				SearchManufacture(SoldItemstable, id);

				adding.close();
				// Add the record to the ObservableList
				// Update the TableView
				// table.setItems();
			} catch (NumberFormatException ex) {
				lbResult.setText("Invalid input. Please enter valid numeric values.");

			}
		});

		adding.setScene(scene);
		adding.setTitle("searchRecordManufacture");
		scene.getStylesheets().add(getClass().getResource("styles.css").toExternalForm());
		adding.show();
	}

	public void searchSupplier(TableView<Supplier> Suppliertable) {// a method that adds a new method to the tree
		Stage adding = new Stage();
		VBox vbox = new VBox(10); // VBox with spacing of 10
		vbox.setAlignment(Pos.CENTER); // Align vbox children to center
		vbox.getChildren().clear();
		lbResult.setText("");
		SupplierIDT.clear();
		hb1.getChildren().clear();
		hb1.getChildren().addAll(SupplierID, SupplierIDT);
		hb1.setAlignment(Pos.CENTER);
		hb5.getChildren().clear();
		hb5.getChildren().addAll(ok, lbResult);
		hb5.setAlignment(Pos.CENTER);

		// Add all HBoxes to VBox
		vbox.getChildren().addAll(hb1, hb5);

		// Add vbox to the scene
		Scene scene = new Scene(vbox, 250, 150);

		ok.setOnAction(e -> {

			try {
				// uses the data we got from the fields to insert new data parameters
				// adds the data inside the tree

				int id = Integer.parseInt(SupplierIDT.getText());
				SearchSupplier(Suppliertable, id);

				adding.close();
				// Add the record to the ObservableList
				// Update the TableView
				// table.setItems();
			} catch (NumberFormatException ex) {
				lbResult.setText("Invalid input. Please enter valid numeric values.");

			}
		});

		adding.setScene(scene);
		adding.setTitle("searchRecordSupplier");
		scene.getStylesheets().add(getClass().getResource("styles.css").toExternalForm());
		adding.show();
	}

	public void searchEmployee(TableView<Employee> EmpTable) {// a method that adds a new method to the tree
		Stage adding = new Stage();
		VBox vbox = new VBox(10); // VBox with spacing of 10
		vbox.setAlignment(Pos.CENTER); // Align vbox children to center
		vbox.getChildren().clear();
		lbResult.setText("");
		EmployeeIDT.clear();
		hb1.getChildren().clear();
		hb1.getChildren().addAll(EmployeeID, EmployeeIDT);
		hb1.setAlignment(Pos.CENTER);
		hb5.getChildren().clear();
		hb5.getChildren().addAll(ok, lbResult);
		hb5.setAlignment(Pos.CENTER);

		// Add all HBoxes to VBox
		vbox.getChildren().addAll(hb1, hb5);

		// Add vbox to the scene
		Scene scene = new Scene(vbox, 250, 150);

		ok.setOnAction(e -> {

			try {
				// uses the data we got from the fields to insert new data parameters
				// adds the data inside the tree

				int id = Integer.parseInt(EmployeeIDT.getText());
				SearchEmployee(EmpTable, id);

				adding.close();
				// Add the record to the ObservableList
				// Update the TableView
				// table.setItems();
			} catch (NumberFormatException ex) {
				lbResult.setText("Invalid input. Please enter valid numeric values.");

			}
		});

		adding.setScene(scene);
		adding.setTitle("searchRecordEmployee");
		scene.getStylesheets().add(getClass().getResource("styles.css").toExternalForm());
		adding.show();
	}

	public static void SearchCustomer(TableView<Customer> customerTable, int ID) {
		String sql = "SELECT * FROM customer WHERE CustomerID = ?";
//		customerTable	customerTable

		try (Connection connections = Conn.getConnection();
				PreparedStatement preparedStatement = connections.prepareStatement(sql);) {
			// Set values for each parameter in the SQL query
			preparedStatement.setInt(1, ID);
			ObservableList<Customer> data = FXCollections.observableArrayList();

			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				// Retrieve values from the result set
				int id = resultSet.getInt("CustomerID"); // Replace "id" with the actual column name
				String CustomerName = resultSet.getString("CustomerName");
				String CustomerEmail = resultSet.getString("CustomerEmail");
				String CustomerAddress = resultSet.getString("CustomerAddress");
				String CustomerPhone = resultSet.getString("CustomerPhone");
				data.add(new Customer(id, CustomerName, CustomerEmail, CustomerAddress, CustomerPhone));

			}
			customerTable.setItems(data);

			// Execute the SQL query to insert the data

			// Print the number of rows affected

		} catch (SQLException e) {
			// Handle any SQL exceptions
			e.printStackTrace();
		}

	}

	public static void Searchinventory(TableView<InventoryItems> inventoryTable, int ItemId) {
		String sql = "SELECT * FROM inventoryitems WHERE ItemID = ?";
//		customerTable	customerTable

		try (Connection connections = Conn.getConnection();
				PreparedStatement preparedStatement = connections.prepareStatement(sql);) {
			// Set values for each parameter in the SQL query
			preparedStatement.setInt(1, ItemId);
			ObservableList<InventoryItems> data = FXCollections.observableArrayList();

			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				// Retrieve values from the result set
				int itemID = resultSet.getInt("ItemID"); // Replace "id" with the actual column name
				String modelType = resultSet.getString("ModelType");
				Float ModelPrice = resultSet.getFloat("ModelPrice");
				int suplierID = resultSet.getInt("SuplierID");

				data.add(new InventoryItems(itemID, modelType, ModelPrice, suplierID));

			}

			inventoryTable.setItems(data);

			// Execute the SQL query to insert the data

			// Print the number of rows affected

		} catch (SQLException e) {
			// Handle any SQL exceptions
			e.printStackTrace();
		}

	}

	public static void searchShipment(TableView<Shipment> ShipTable, String ShipCode) {
		String sql = "SELECT * FROM Shipment WHERE ShipmentCode = ?";
//		customerTable	customerTable

		try (Connection connections = Conn.getConnection();
				PreparedStatement preparedStatement = connections.prepareStatement(sql);) {
			// Set values for each parameter in the SQL query
			preparedStatement.setString(1, ShipCode);
			ObservableList<Shipment> data = FXCollections.observableArrayList();

			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				// Retrieve values from the result set
				String Shipcode = resultSet.getString("ShipmentCode"); // Replace "id" with the actual column name
				int OrderNum = resultSet.getInt("OrderNum");
				LocalDate date = resultSet.getDate("ShipmentDate").toLocalDate();
				String ShipmentStatus = resultSet.getString("ShipmentStatus");
				Float ShipmentCost = resultSet.getFloat("ShipmentCost");

				data.add(new Shipment(Shipcode, OrderNum, date, ShipmentStatus, ShipmentCost));

			}
			ShipTable.setItems(data);

			// Execute the SQL query to insert the data

			// Print the number of rows affected

		} catch (SQLException e) {
			// Handle any SQL exceptions
			e.printStackTrace();
		}
	}

	public static void searchOreder(TableView<Order> orderTable, int orderNum) {
		String sql = "SELECT * FROM order1 WHERE OrderNum = ?";
//		customerTable	customerTable

		try (Connection connections = Conn.getConnection();
				PreparedStatement preparedStatement = connections.prepareStatement(sql);) {
			// Set values for each parameter in the SQL query
			preparedStatement.setInt(1, orderNum);

			ObservableList<Order> data = FXCollections.observableArrayList();

			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				// Retrieve values from the result set

//	                int OrderNum = resultSet.getInt("OrderNum");
				int CustomerID = resultSet.getInt("CustomerID");
				LocalDate date = resultSet.getDate("OrderDate").toLocalDate();
				Float OrderSum = resultSet.getFloat("OrderSum");
				String ShipCode = resultSet.getString("ShipCode");

				// add EMpID
				data.add(new Order(orderNum, ShipCode, CustomerID, date, OrderSum, 0));

			}
			orderTable.setItems(data);

			// Execute the SQL query to insert the data

			// Print the number of rows affected

		} catch (SQLException e) {
			// Handle any SQL exceptions
			e.printStackTrace();
		}

	}

	public static void SearchFinance(TableView<Finance> financeTable, int ID) {
		String sql = "SELECT * FROM finance WHERE invoiceID = ?"; // Modify the SQL query as per your database schema

		try (Connection connections = Conn.getConnection();
				PreparedStatement preparedStatement = connections.prepareStatement(sql)) {
			preparedStatement.setInt(1, ID);
			ObservableList<Finance> data = FXCollections.observableArrayList();

			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				int invoiceID = resultSet.getInt("invoiceID");
				float InvoiceSum = resultSet.getFloat("InvoiceSum");
				float InvoiceBills = resultSet.getFloat("InvoiceBills");
				String InvoiceStatus = resultSet.getString("InvoiceStatus");
				LocalDate InvoiceDate = resultSet.getDate("InvoiceDate").toLocalDate();

				data.add(new Finance(invoiceID, InvoiceSum, InvoiceBills, InvoiceStatus, InvoiceDate));
			}
			financeTable.setItems(data);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void SearchSoldItems(TableView<SoldItems> SoldItemsTable, int ItemId) {
		String sql = "SELECT * FROM SoldItems WHERE productID = ?";
//		customerTable	customerTable

		try (Connection connections = Conn.getConnection();
				PreparedStatement preparedStatement = connections.prepareStatement(sql);) {
			// Set values for each parameter in the SQL query
			preparedStatement.setInt(1, ItemId);
			ObservableList<SoldItems> data = FXCollections.observableArrayList();

			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				// Retrieve values from the result set
				int productID = resultSet.getInt("productID"); // Replace "id" with the actual column name
				String Category = resultSet.getString("category");
				Float ModelPrice = resultSet.getFloat("price");
				LocalDate date = resultSet.getDate("SoldDate").toLocalDate();

				data.add(new SoldItems(productID, Category, ModelPrice, date));

			}

			SoldItemsTable.setItems(data);

			// Execute the SQL query to insert the data

			// Print the number of rows affected

		} catch (SQLException e) {
			// Handle any SQL exceptions
			e.printStackTrace();
		}

	}

	public static void SearchSupplier(TableView<Supplier> SuplierTable, int suplierId) {
		String sql = "SELECT * FROM Suplier WHERE SuplierID = ?";
//		customerTable	customerTable

		try (Connection connections = Conn.getConnection();
				PreparedStatement preparedStatement = connections.prepareStatement(sql);) {
			// Set values for each parameter in the SQL query
			preparedStatement.setInt(1, suplierId);
			ObservableList<Supplier> data = FXCollections.observableArrayList();

			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				// Retrieve values from the result set
				int suplierID = resultSet.getInt("suplierID"); // Replace "id" with the actual column name
				String suplierName = resultSet.getString("suplierName");
				LocalDate date = resultSet.getDate("supplydate").toLocalDate();

				data.add(new Supplier(suplierID, suplierName, date));

			}

			SuplierTable.setItems(data);

			// Execute the SQL query to insert the data

			// Print the number of rows affected

		} catch (SQLException e) {
			// Handle any SQL exceptions
			e.printStackTrace();
		}

	}

	public static void SearchManufacture(TableView<Manufacturing> ManTable, int ProductID) {
		String sql = "SELECT * FROM Manufacturing WHERE ProductID = ?";
//		customerTable	customerTable

		try (Connection connections = Conn.getConnection();
				PreparedStatement preparedStatement = connections.prepareStatement(sql);) {
			// Set values for each parameter in the SQL query
			preparedStatement.setInt(1, ProductID);
			ObservableList<Manufacturing> data = FXCollections.observableArrayList();

			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				// Retrieve values from the result set
				int ProductId = resultSet.getInt("ProductID"); // Replace "id" with the actual column name
				String category = resultSet.getString("category");
				LocalDate date = resultSet.getDate("ManufacturingDate").toLocalDate();
				Float price = resultSet.getFloat("Price");
				int itemsneeded = resultSet.getInt("ItemsNeededformanufacturing");

				data.add(new Manufacturing(ProductId, category, price, date, itemsneeded));

			}

			ManTable.setItems(data);

			// Execute the SQL query to insert the data

			// Print the number of rows affected

		} catch (SQLException e) {
			// Handle any SQL exceptions
			e.printStackTrace();
		}

	}

	public static void SearchEmployee(TableView<Employee> employeeTable, int EmployeeId) {
		String sql = "SELECT * FROM employee WHERE EmployeeID = ?";
//		customerTable	customerTable

		try (Connection connections = Conn.getConnection();
				PreparedStatement preparedStatement = connections.prepareStatement(sql);) {
			// Set values for each parameter in the SQL query
			preparedStatement.setInt(1, EmployeeId);
			ObservableList<Employee> data = FXCollections.observableArrayList();

			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				// Retrieve values from the result set
				int EmployeeID = resultSet.getInt("EmployeeID"); // Replace "id" with the actual column name
				String EmpName = resultSet.getString("EmpName");
				String Email = resultSet.getString("Email");
				String Role = resultSet.getString("Role");
				float salary = resultSet.getFloat("salary");

				data.add(new Employee(EmployeeId, EmpName, Email, Role, salary));

			}

			employeeTable.setItems(data);

			// Execute the SQL query to insert the data

			// Print the number of rows affected

		} catch (SQLException e) {
			// Handle any SQL exceptions
			e.printStackTrace();
		}

	}

}
