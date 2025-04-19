package com.example.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;

import javafx.application.Application;
import javafx.beans.property.SimpleFloatProperty;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class GuiDelete extends Application {
	static MySQLJDBCConnection Conn = new MySQLJDBCConnection();

	private DatePicker datePicker = new DatePicker();
	private Label ItemID = new Label("Item ID: ");
	private Label InvoiceID = new Label("InvoiceID: ");
	private Label OrderNumber = new Label("OrderNumber: ");
	private Label ShipCode = new Label("ShipCode: ");
	private Label CustsomerID = new Label("CustsomerID: ");
	private Label EmployeeID = new Label("EmployeeID: ");
	private Label SoldItemsID = new Label("SoldItems ID: ");
	private Label ManufacturingID = new Label("ManufacturingID: ");
	private Label SupplierID = new Label("SupplierID: ");
	private Label lbResult = new Label("");
	private TextField ItemIDT = new TextField();
	private TextField InvoiceIDT = new TextField();
	private TextField OrderNumberT = new TextField();
	private TextField ShipCodeT = new TextField();
	private TextField CustsomerIDT = new TextField();
	private TextField EmployeeIDT = new TextField();
	private TextField SoldItemsIDT = new TextField();
	private TextField ManufacturingIDT = new TextField();
	private TextField SupplierIDT = new TextField();

	private VBox vb1 = new VBox();
	private HBox hb1 = new HBox();
	private HBox hb5 = new HBox();
	private Button ok = new Button("OK");

	@Override
	public void start(Stage primaryStage) {
		VBox mainLayout = new VBox(10); // VBox with spacing of 10

		Button btnAddRecordInventory = new Button("Add Inventory Item");
//        btnAddRecordInventory.setOnAction(e -> DeleteRecordinventoryItems());

		Button btnAddRecordOrder = new Button("Add Order");
//        btnAddRecordOrder.setOnAction(e -> DeleteRecordOrder());

		Button btnAddRecordFinance = new Button("Add Finance");
//        btnAddRecordFinance.setOnAction(e -> DeleteRecordFinance());

		Button btnAddRecordCustomer = new Button("Add Customer");
//        btnAddRecordCustomer.setOnAction(e -> DeleteRecordCustomer(ObservableList<Customer> customerObservableList));

		Button btnAddRecordShipment = new Button("Add Shipment");

		Button btnAddRecordEmployee = new Button("Add Employee");

		Button btnAddRecordManufacturing = new Button("Add Manufacturing");

		Button btnAddRecordSoldItems = new Button("Add SoldItems");

		Button btnAddRecordSupplier = new Button("Add Supplier");
//        btnAddRecordShipment.setOnAction(e -> DeleteRecordShipment());

		// Add all buttons to VBox
		mainLayout.getChildren().addAll(btnAddRecordInventory, btnAddRecordOrder, btnAddRecordFinance,
				btnAddRecordCustomer, btnAddRecordShipment, btnAddRecordEmployee, btnAddRecordManufacturing,
				btnAddRecordSupplier, btnAddRecordSoldItems);

		Scene scene = new Scene(mainLayout, 300, 250);
		primaryStage.setTitle("Data Management");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

	public ObservableList<InventoryItems> DeleteRecordinventoryItems(ObservableList<InventoryItems> inventoryList) {// a
																													// method
																													// that
																													// adds
																													// a
																													// new
																													// method
																													// to
																													// the
																													// tree
		Stage adding = new Stage();
		VBox vbox = new VBox(10); // VBox with spacing of 10
		vbox.setAlignment(Pos.CENTER); // Align vbox children to center
		vbox.getChildren().clear();
		lbResult.setText("");
		ItemIDT.clear();
		hb1.getChildren().clear();
		hb1.getChildren().addAll(ItemID, ItemIDT);
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
				int id = Integer.parseInt(ItemIDT.getText());

				deletefromInventoryItems(inventoryList, id);
				InventoryItems itemtodelete = null;
				for (InventoryItems inventoryItems : inventoryList) {
					if (inventoryItems.getItemId() == id) {
						itemtodelete = inventoryItems;
					}

				}
				inventoryList.remove(itemtodelete);

				adding.close();
				// Add the record to the ObservableList
				// Update the TableView
				// table.setItems();
			} catch (NumberFormatException ex) {
				lbResult.setText("Invalid input. Please enter valid numeric values.");

			}
		});

		adding.setScene(scene);
		adding.setTitle("DeleteRecordinventoryItems");
		scene.getStylesheets().add(getClass().getResource("styles.css").toExternalForm());
		adding.show();
		return inventoryList;
	}

	public ObservableList<Order> DeleteRecordOrder(ObservableList<Order> orderObservableList) {// a method that adds a
																								// new method to the
																								// tree
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
				int id = Integer.parseInt(OrderNumberT.getText());
				// adds the data inside the tree

				deletefromOrder(orderObservableList, id);

				Order ordertodelete = null;
				for (Order order : orderObservableList) {
					if (order.getOrderNum() == id) {
						ordertodelete = order;
					}

				}
				orderObservableList.remove(ordertodelete);

				adding.close();

				// Add the record to the ObservableList
				// Update the TableView
				// table.setItems();
			} catch (NumberFormatException ex) {
				lbResult.setText("Invalid input. Please enter valid numeric values.");
			}

		});

		adding.setScene(pane);
		adding.setTitle("DeleteRecordOrder");
		pane.getStylesheets().add(getClass().getResource("styles.css").toExternalForm());
		adding.show();
		return orderObservableList;
	}

	public ObservableList<Employee> DeleteRecordEmployee(ObservableList<Employee> EmployeeObservableList) {// a method
																											// that adds
																											// a new
																											// method to
																											// the tree
		Stage adding = new Stage();
		VBox vbox = new VBox(10); // VBox with spacing of 10
		vbox.setAlignment(Pos.CENTER); // Align vbox children to center
		Scene pane = new Scene(vbox, 250, 150);
		lbResult.setText("");
		EmployeeIDT.clear();
		hb1.getChildren().clear();
		hb1.getChildren().addAll(EmployeeID, EmployeeIDT);
		hb1.setAlignment(Pos.CENTER);
		hb5.getChildren().clear();
		hb5.getChildren().addAll(ok, lbResult);
		hb5.setAlignment(Pos.CENTER);
		vbox.getChildren().clear();// clears the gui and inserts new records
		vbox.getChildren().addAll(hb1, hb5);

		vb1.setAlignment(Pos.CENTER);

		ok.setOnAction(e -> {
			try {
				int id = Integer.parseInt(EmployeeIDT.getText());
				// adds the data inside the tree

				deletefromEmployee(EmployeeObservableList, id);

				Employee Employeetodelete = null;
				for (Employee employee : EmployeeObservableList) {
					if (employee.getEmpID() == id) {
						Employeetodelete = employee;
					}

				}
				EmployeeObservableList.remove(Employeetodelete);

				adding.close();

				// Add the record to the ObservableList
				// Update the TableView
				// table.setItems();
			} catch (NumberFormatException ex) {
				lbResult.setText("Invalid input. Please enter valid numeric values.");
			}

		});

		adding.setScene(pane);
		adding.setTitle("DeleteRecordOrder");
		pane.getStylesheets().add(getClass().getResource("styles.css").toExternalForm());
		adding.show();
		return EmployeeObservableList;
	}

	public ObservableList<Finance> DeleteRecordFinance(ObservableList<Finance> financeObservableList) {// a method that
																										// adds a new
																										// method to the
																										// tree
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
				int id = Integer.parseInt(InvoiceIDT.getText());
				// adds the data inside the tree

				deletefromFinance(financeObservableList, id);

				Finance financetodelete = null;
				for (Finance finance : financeObservableList) {
					if (finance.getInvoiceID() == id) {
						financetodelete = finance;
					}

				}
				financeObservableList.remove(financetodelete);

				adding.close();

				// Add the record to the ObservableList
				// Update the TableView
				// table.setItems();
			} catch (NumberFormatException ex) {
				lbResult.setText("Invalid input. Please enter valid numeric values.");
			}

		});

		adding.setScene(pane);
		adding.setTitle("DeleteRecordFinance");
		pane.getStylesheets().add(getClass().getResource("styles.css").toExternalForm());
		adding.show();
		return financeObservableList;
	}
	public ObservableList<Supplier> DeleteRecordSupplier(ObservableList<Supplier> SupplierObservableList) {
		Stage adding = new Stage();
		VBox vbox = new VBox(10); // VBox with spacing of 10
		vbox.setAlignment(Pos.CENTER); // Align vbox children to center
		Scene pane = new Scene(vbox, 250, 150);
		lbResult.setText("");
		SupplierIDT.clear();
		hb1.getChildren().clear();
		hb1.getChildren().addAll(SupplierID, SupplierIDT);
		hb1.setAlignment(Pos.CENTER);
		hb5.getChildren().clear();
		hb5.getChildren().addAll(ok, lbResult);
		hb5.setAlignment(Pos.CENTER);

		vbox.getChildren().clear();// clears the gui and inserts new records
		vbox.getChildren().addAll(hb1, hb5);

		vbox.setAlignment(Pos.CENTER);

		ok.setOnAction(e -> {
			try {
				int id = Integer.parseInt(SupplierIDT.getText());
				//adds the data inside the tree

				deletefromSupplier(SupplierObservableList, id);

				Supplier Suppliertodelete=null;
				for (Supplier supplier : SupplierObservableList) {
					if (supplier.getSupplierId() ==id ) {
						Suppliertodelete= supplier;
					}

				}
				SupplierObservableList.remove(Suppliertodelete);

				adding.close();

				// Add the record to the ObservableList
				// Update the TableView
				//table.setItems();
			} catch (NumberFormatException ex) {
				lbResult.setText("Invalid input. Please enter valid numeric values.");
			}


		});

		adding.setScene(pane);
		adding.setTitle("DeleteRecord Supplier");
		pane.getStylesheets().add(getClass().getResource("styles.css").toExternalForm());
		adding.show();
		return SupplierObservableList;
	}

	public ObservableList<Manufacturing> DeleteRecordManuFactoring(
			ObservableList<Manufacturing> manufacturingObservableList) {// a method that adds a new method to the tree
		Stage adding = new Stage();
		VBox vbox = new VBox(10); // VBox with spacing of 10
		vbox.setAlignment(Pos.CENTER); // Align vbox children to center
		Scene pane = new Scene(vbox, 250, 150);
		lbResult.setText("");
		ManufacturingIDT.clear();
		hb1.getChildren().clear();
		hb1.getChildren().addAll(ManufacturingID, ManufacturingIDT);
		hb1.setAlignment(Pos.CENTER);
		hb5.getChildren().clear();
		hb5.getChildren().addAll(ok, lbResult);
		hb5.setAlignment(Pos.CENTER);

		vbox.getChildren().clear();// clears the gui and inserts new records
		vbox.getChildren().addAll(hb1, hb5);

		vbox.setAlignment(Pos.CENTER);

		ok.setOnAction(e -> {
			try {
				int id = Integer.parseInt(ManufacturingIDT.getText());
				// adds the data inside the tree

				deletefromManuFactoring(manufacturingObservableList, id);

				Manufacturing manufacturingtodelete = null;
				for (Manufacturing manufacturing : manufacturingObservableList) {
					if (manufacturing.getProductId() == id) {
						manufacturingtodelete = manufacturing;
					}

				}
				manufacturingObservableList.remove(manufacturingtodelete);

				adding.close();

				// Add the record to the ObservableList
				// Update the TableView
				// table.setItems();
			} catch (NumberFormatException ex) {
				lbResult.setText("Invalid input. Please enter valid numeric values.");
			}

		});

		adding.setScene(pane);
		adding.setTitle("DeleteRecordManufactoring");
		pane.getStylesheets().add(getClass().getResource("styles.css").toExternalForm());
		adding.show();
		return manufacturingObservableList;
	}

	public ObservableList<Customer> DeleteRecordCustomer(ObservableList<Customer> customerObservableList) {																									// the tree
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
				int id = Integer.parseInt(CustsomerIDT.getText());
				// adds the data inside the tree

				deletefromCustomer(customerObservableList, id);

				Customer customertodelete = null;
				for (Customer customer : customerObservableList) {
					if (customer.getCustomerID() == id) {
						customertodelete = customer;
					}
				}
				customerObservableList.remove(customertodelete);
				adding.close();
			} catch (NumberFormatException ex) {
				lbResult.setText("Invalid input. Please enter valid numeric values.");
			}
		});
		adding.setScene(pane);
		adding.setTitle("DeleteRecordCustomer");
		pane.getStylesheets().add(getClass().getResource("styles.css").toExternalForm());
		adding.show();
		return customerObservableList;

	}

	public ObservableList<Shipment> DeleteRecordShipment(ObservableList<Shipment> shipmentObservableList) {
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
					String id = ShipCodeT.getText();
					deletefromShipment(shipmentObservableList, id);

					Shipment shipmenttodelete = null;
					for (Shipment shipment : shipmentObservableList) {
						if (shipment.getShipmentCode() == id) {
							shipmenttodelete = shipment;
						}

					}
					shipmentObservableList.remove(shipmenttodelete);

					adding.close();

				} catch (NumberFormatException ex) {
					lbResult.setText("Invalid input. Please enter valid numeric values.");
				}

		});

		adding.setScene(pane);
		adding.setTitle("DeleteRecordShipment");
		pane.getStylesheets().add(getClass().getResource("styles.css").toExternalForm());
		adding.show();
		return shipmentObservableList;

	}

	public static void deletefromCustomer(ObservableList<Customer> customerObservableList, int id) {
		String sql = "DELETE FROM customer WHERE CustomerID = ?";

		try (Connection connections = Conn.getConnection();
				PreparedStatement preparedStatement = connections.prepareStatement(sql);) {
			// Set values for each parameter in the SQL query
			preparedStatement.setInt(1, id);

			Customer customertodelete = null;
			for (Customer customer : customerObservableList) {
				if (customer.getCustomerID() == id) {
					customertodelete = customer;
				}

			}
			customerObservableList.remove(customertodelete);

			// Execute the SQL query to insert the data
			int rowsAffected = preparedStatement.executeUpdate();

			// Print the number of rows affected
			System.out.println(rowsAffected + " row(s) inserted successfully.");
		} catch (SQLException e) {
			// Handle any SQL exceptions
			e.printStackTrace();
		}
	}

	public static void deletefromFinance(ObservableList<Finance> financeList, int invoiceID) {
		String sql = "DELETE FROM finance WHERE invoiceID = ?";

		try (Connection connections = Conn.getConnection();
				PreparedStatement preparedStatement = connections.prepareStatement(sql);) {
			// Set values for each parameter in the SQL query
			preparedStatement.setInt(1, invoiceID);

			Finance financetodelete = null;
			for (Finance finance : financeList) {
				if (finance.getInvoiceID() == invoiceID) {
					financetodelete = finance;
				}

			}
			financeList.remove(financetodelete);

			// Execute the SQL query to insert the data
			int rowsAffected = preparedStatement.executeUpdate();

			// Print the number of rows affected
			System.out.println(rowsAffected + " row(s) inserted successfully.");
		} catch (SQLException e) {
			// Handle any SQL exceptions
			e.printStackTrace();
		}
	}

	private void deletefromEmployee(ObservableList<Employee> employeeObservableList, int id) {
		String sql = "DELETE FROM order1 WHERE OrderNum = ?";
		try (Connection connections = Conn.getConnection();
				PreparedStatement preparedStatement = connections.prepareStatement(sql);) {
			// Set values for each parameter in the SQL query
			preparedStatement.setInt(1, id);

			Employee Employeetodelete = null;
			for (Employee employee : employeeObservableList) {
				if (employee.getEmpID() == id) {
					Employeetodelete = employee;
				}

			}
			employeeObservableList.remove(Employeetodelete);

			// Execute the SQL query to insert the data
			int rowsAffected = preparedStatement.executeUpdate();

			// Print the number of rows affected
			System.out.println(rowsAffected + " row(s) inserted successfully.");
		} catch (SQLException e) {
			// Handle any SQL exceptions
			e.printStackTrace();
		}
	}

	public static void deletefromOrder(ObservableList<Order> orderList, int OrderNum) {
		String sql = "DELETE FROM order1 WHERE OrderNum = ?";

		try (Connection connections = Conn.getConnection();
				PreparedStatement preparedStatement = connections.prepareStatement(sql);) {
			// Set values for each parameter in the SQL query
			preparedStatement.setInt(1, OrderNum);

			Order Ordertodelete = null;
			for (Order order : orderList) {
				if (order.getOrderNum() == OrderNum) {
					Ordertodelete = order;
				}

			}
			orderList.remove(Ordertodelete);

			// Execute the SQL query to insert the data
			int rowsAffected = preparedStatement.executeUpdate();

			// Print the number of rows affected
			System.out.println(rowsAffected + " row(s) inserted successfully.");
		} catch (SQLException e) {
			// Handle any SQL exceptions
			e.printStackTrace();
		}
	}

	public static void deletefromManuFactoring(ObservableList<Manufacturing> manufacturingObservableList,
			int manuFactoringNum) {
		String sql = "DELETE FROM order1 WHERE OrderNum = ?";

		try (Connection connections = Conn.getConnection();
				PreparedStatement preparedStatement = connections.prepareStatement(sql);) {
			// Set values for each parameter in the SQL query
			preparedStatement.setInt(1, manuFactoringNum);

			Manufacturing Manufacturingtodelete = null;
			for (Manufacturing manufacturing : manufacturingObservableList) {
				if (manufacturing.getProductId() == manuFactoringNum) {
					Manufacturingtodelete = manufacturing;
				}

			}
			manufacturingObservableList.remove(Manufacturingtodelete);

			// Execute the SQL query to insert the data
			int rowsAffected = preparedStatement.executeUpdate();

			// Print the number of rows affected
			System.out.println(rowsAffected + " row(s) inserted successfully.");
		} catch (SQLException e) {
			// Handle any SQL exceptions
			e.printStackTrace();
		}
	}

	public static void deletefromShipment(ObservableList<Shipment> shipmentList, String shipmentCode) {
		String sql = "DELETE FROM Shipment WHERE ShipmentCode = ?";
		try (Connection connections = Conn.getConnection();
				PreparedStatement preparedStatement = connections.prepareStatement(sql);) {
			preparedStatement.setString(1, shipmentCode);
			Shipment shipmenttodelete = null;
			for (Shipment shipment : shipmentList) {
				if (shipment.getShipmentCode() == shipmentCode) {
					shipmenttodelete = shipment;
				}

			}
			shipmentList.remove(shipmenttodelete);

			// Execute the SQL query to insert the data
			int rowsAffected = preparedStatement.executeUpdate();

			// Print the number of rows affected
			System.out.println(rowsAffected + " row(s) inserted successfully.");
		} catch (SQLException e) {
			// Handle any SQL exceptions
			e.printStackTrace();
		}
	}


	public static void deletefromInventoryItems(ObservableList<InventoryItems> InventoryItemsList, int ItemID) {
		String sql = "DELETE FROM inventoryitems WHERE ItemID = ?";

		try (Connection connections = Conn.getConnection();
				PreparedStatement preparedStatement = connections.prepareStatement(sql);) {
			// Set values for each parameter in the SQL query
			preparedStatement.setInt(1, ItemID);

			InventoryItems inventoryItemtodelete = null;
			for (InventoryItems inventoryItems : InventoryItemsList) {
				if (inventoryItems.getItemId() == ItemID) {
					inventoryItemtodelete = inventoryItems;
				}

			}
			InventoryItemsList.remove(inventoryItemtodelete);

			// Execute the SQL query to insert the data
			int rowsAffected = preparedStatement.executeUpdate();

			// Print the number of rows affected
			System.out.println(rowsAffected + " row(s) inserted successfully.");
		} catch (SQLException e) {
			// Handle any SQL exceptions
			e.printStackTrace();
		}
	}

	public static void deletefromSupplier(ObservableList<Supplier> supplierItemsList , int supplierID ) {
		String sql = "DELETE FROM suplier WHERE SuplierID = ?";


		try ( Connection connections = Conn.getConnection();
			  PreparedStatement preparedStatement = connections.prepareStatement(sql);
		) {
			// Set values for each parameter in the SQL query
			preparedStatement.setInt(1, supplierID);

			Supplier supplierTodelete=null;
			for (Supplier supplier : supplierItemsList) {
				if (supplier.getSupplierId() == supplierID ) {
					supplierTodelete= supplier;
				}

			}
			supplierItemsList.remove(supplierTodelete);


			// Execute the SQL query to insert the data
			int rowsAffected = preparedStatement.executeUpdate();

			// Print the number of rows affected
			System.out.println(rowsAffected + " row(s) inserted successfully.");
		} catch (SQLException e) {
			// Handle any SQL exceptions
			e.printStackTrace();
		}
	}

}