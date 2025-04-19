package com.example.database;

import java.sql.Connection;
import java.sql.Date;
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

public class GUIADD extends Application {

	static MySQLJDBCConnection Conn = new MySQLJDBCConnection();
	int CID = 9;
	int FID = 2;
	private Label ProductID = new Label("ProductID: ");
	private Label ModelID = new Label("ModelID: ");
	private Label ModelType = new Label("ModelType: ");
	private Label ModelPrice = new Label("ModelPrice: ");

	private Label OrderNumber = new Label("OrderNumber: ");
	private Label ShipCode = new Label("ShipCode: ");
	private Label CustsomerID = new Label("CustsomerID: ");
	private Label OrderDateL = new Label("OrderDate: ");
	private DatePicker OrderDate = new DatePicker();
	private Label OrderSum = new Label("OrderSum: ");

	private Label InvoiceSum = new Label("InvoiceSum: ");
	private Label InvoiceBills = new Label("InvoiceBills: ");
	private Label InvoiceStatus = new Label("InvoiceStatus: ");
	private Label InvoiceDateL = new Label("InvoiceDate: ");
	private DatePicker InvoiceDate = new DatePicker();

	private Label CustomerName = new Label("CustomerName: ");
	private Label CustomerEmail = new Label("CustomerEmail: ");
	private Label CustomerAdrress = new Label("CustomerAdrress: ");
	private Label CustomerPhone = new Label("CustomerPhone: ");

	private DatePicker ShipmentDate = new DatePicker();
	private Label ShipmentDateL = new Label("ShipmentDateL");
	private Label ShipmentSatus = new Label("ShipmentSatus: ");
	private Label ShipmentCost = new Label("ShipmentCost: ");

	private Label lbResult = new Label("");

	private Label EmployeeId = new Label("EmployeeId: ");
	private Label EmployeeName = new Label("EmployeeName: ");
	private Label EmployeeEmail = new Label("Email: ");
	private Label EmployeeRole = new Label("Role: ");
	private Label EmployeeSalary = new Label("Salary: ");
	private Label EmployeeUserName = new Label("EmployeeUserName: ");
	private Label EmployeePassword = new Label("EmployeePassword: ");

	private Label SupplierID = new Label("SupplierID: ");
	private Label SupplierName = new Label("SupplierName: ");
	private Label SupplierDateL = new Label("SupplierDate: ");
	private DatePicker SupplierDate = new DatePicker();

	private Label ProductCatagory = new Label("ProductCatagory: ");
	private Label ProductPrice = new Label("ProductPrice: ");
	private Label ManufacuringDateL = new Label("ManufacuringDate: ");
	private DatePicker ManufacuringDate = new DatePicker();
	private Label ItemsNeeded = new Label("ItemsNeeded: ");

	private Label SoldItmesPrice = new Label("SoldItmesPrice: ");
	private Label CustomerID = new Label("Customer Id: ");
	private Label SoldItmesDateL = new Label("SoldItmesDate: ");
	private DatePicker SoldItmesDate = new DatePicker();

	private TextField ProductIDT = new TextField();
	private TextField CustomerIDT = new TextField();
	private TextField ModelIDT = new TextField();
	private TextField ModelTypeT = new TextField();
	private TextField ModelPriceT = new TextField();

	private TextField OrderNumberT = new TextField();
	private TextField ShipCodeT = new TextField();
	private TextField CustsomerIDT = new TextField();
	private TextField OrderStatusT = new TextField();
	private TextField OrderSumT = new TextField();
	private TextField InvoiceSumT = new TextField();
	private TextField InvoiceBillsT = new TextField();
	private TextField InvoiceStatusT = new TextField();

	private TextField CustomerNameT = new TextField();
	private TextField CustomerEmailT = new TextField();
	private TextField CustomerAdrressT = new TextField();
	private TextField CustomerPhoneT = new TextField();
	private TextField ShipmentSatusT = new TextField();
	private TextField ShipmentCostT = new TextField();

	private TextField EmployeeIdT = new TextField();
	private TextField EmployeeNameT = new TextField();
	private TextField EmployeeEmailT = new TextField();
	private TextField EmployeeRoleT = new TextField();
	private TextField EmployeeSalaryT = new TextField();
	private TextField EmployeeUserNameT = new TextField();
	private TextField EmployeePasswordT = new TextField();

	private TextField SupplierIDT = new TextField();
	private TextField SupplierNameT = new TextField();

	private TextField ProductCatagoryT = new TextField();
	private TextField ProductPriceT = new TextField();
	private TextField ItemsNeededT = new TextField();

	private TextField SoldItmesPriceT = new TextField();

	private VBox vb1 = new VBox();
	private HBox hb1 = new HBox();
	private HBox hb2 = new HBox();
	private HBox hb3 = new HBox();
	private HBox hb4 = new HBox();
	private HBox hb5 = new HBox();
	private HBox hb6 = new HBox();
	private HBox hb8 = new HBox();
	private HBox hb9 = new HBox();
	private HBox hb7 = new HBox();
	private Button ok = new Button("OK");

	@Override
	public void start(Stage primaryStage) {
		VBox mainLayout = new VBox(10); // VBox with spacing of 10

		Button btnAddRecordInventory = new Button("Add Inventory Item");
//        btnAddRecordInventory.setOnAction(e -> addRecordinventoryItems());

		Button btnAddRecordOrder = new Button("Add Order");
//        btnAddRecordOrder.setOnAction(e -> addRecordOrder());

		Button btnAddRecordFinance = new Button("Add Finance");
		// btnAddRecordFinance.setOnAction(e -> addRecordFinance());

		Button btnAddRecordCustomer = new Button("Add Customer");
		btnAddRecordCustomer.setOnAction(e -> addRecordCustomer(null));

		Button btnAddRecordShipment = new Button("Add Shipment");
		// btnAddRecordShipment.setOnAction(e -> addRecordShipment());

		// Add all buttons to VBox
		mainLayout.getChildren().addAll(btnAddRecordInventory, btnAddRecordOrder, btnAddRecordFinance,
				btnAddRecordCustomer, btnAddRecordShipment);

		Scene scene = new Scene(mainLayout, 300, 250);
		primaryStage.setTitle("Data Management");
		primaryStage.setScene(scene);
		scene.getStylesheets().add(getClass().getResource("styles.css").toExternalForm());
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

	public ObservableList<InventoryItems> addRecordinventoryItems(ObservableList<InventoryItems> InventoryItemsList) {// a
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
		ModelIDT.clear();
		ModelTypeT.clear();
		ModelPriceT.clear();
		SupplierIDT.clear();
		// Clear and setup each HBox
		hb1.getChildren().clear();
		hb1.getChildren().addAll(ModelID, ModelIDT);
		hb1.setAlignment(Pos.CENTER);

		hb2.getChildren().clear();
		hb2.getChildren().addAll(ModelType, ModelTypeT);
		hb2.setAlignment(Pos.CENTER);

		hb3.getChildren().clear();
		hb3.getChildren().addAll(ModelPrice, ModelPriceT);
		hb3.setAlignment(Pos.CENTER);

		hb4.getChildren().clear();
		hb4.getChildren().addAll(SupplierID, SupplierIDT);
		hb4.setAlignment(Pos.CENTER);

		hb5.getChildren().clear();
		hb5.getChildren().addAll(ok, lbResult);
		hb5.setAlignment(Pos.CENTER);

		// Add all HBoxes to VBox
		vbox.getChildren().addAll(hb1, hb2, hb3, hb4, hb5);

		// Add vbox to the scene
		Scene scene = new Scene(vbox, 600, 350);

		ok.setOnAction(e -> {

			try {
				// uses the data we got from the fields to insert new data parameters
				// adds the data inside the tree
				int ModelID = Integer.parseInt(ModelIDT.getText());
				String modeltype = ModelTypeT.getText();
				Float modelPrice = Float.parseFloat(ModelPriceT.getText());
				int SupplierID = Integer.parseInt(SupplierIDT.getText());
				insertintoInventoryItems(InventoryItemsList, ModelID, modeltype, modelPrice, SupplierID);
				InventoryItemsList.add(new InventoryItems(ModelID, modeltype, modelPrice, SupplierID));
				adding.close();
				// Add the record to the ObservableList
				// Update the TableView
				// table.setItems();
			} catch (NumberFormatException ex) {
				lbResult.setText("Invalid input. Please enter valid numeric values.");
			}

		});

		adding.setScene(scene);
		adding.setTitle("Adding Data");
		scene.getStylesheets().add(getClass().getResource("styles.css").toExternalForm());
		adding.show();
		return InventoryItemsList;
	}

	ObservableList<Order> addRecordOrder(ObservableList<Order> OrderList) {
		Stage adding = new Stage();
		VBox vbox = new VBox(10); // VBox with spacing of 10
		vbox.setAlignment(Pos.CENTER); // Align vbox children to center
		Scene pane = new Scene(vbox, 600, 350);
		lbResult.setText("");
		OrderNumberT.clear();
		ShipCodeT.clear();
		ProductIDT.clear();
		CustsomerIDT.clear();
		OrderStatusT.clear();
		OrderSumT.clear();
		EmployeeIdT.clear();
		hb1.getChildren().clear();
		hb1.getChildren().addAll(ShipCode, ShipCodeT);
		hb1.setAlignment(Pos.CENTER);
		hb3.getChildren().clear();
		hb3.getChildren().addAll(ProductID, ProductIDT);
		hb3.setAlignment(Pos.CENTER);
		hb4.getChildren().clear();
		hb4.getChildren().addAll(CustsomerID, CustsomerIDT);
		hb4.setAlignment(Pos.CENTER);
		hb6.getChildren().clear();
		hb6.getChildren().addAll(OrderDateL, OrderDate);
		hb6.setAlignment(Pos.CENTER);
		hb7.getChildren().clear();
		hb7.getChildren().addAll(EmployeeId, EmployeeIdT);
		hb7.setAlignment(Pos.CENTER);
		hb8.getChildren().clear();
		hb8.getChildren().addAll(OrderSum, OrderSumT);
		hb8.setAlignment(Pos.CENTER);
		hb9.getChildren().clear();
		hb9.getChildren().addAll(OrderNumber, OrderNumberT);
		hb9.setAlignment(Pos.CENTER);
		hb5.getChildren().clear();
		hb5.getChildren().addAll(ok, lbResult);
		hb5.setAlignment(Pos.CENTER);
		vbox.getChildren().clear();// clears the gui and inserts new records
		vbox.getChildren().addAll(hb1, hb3, hb4, hb6, hb8, hb9, hb5);

		vb1.setAlignment(Pos.CENTER);

		ok.setOnAction(e -> {

			try {
				// uses the data we got from the fields to insert new data parameters

//					int orderNum = Integer.parseInt(OrderNumberT.getText());

				String shipCode = ShipCodeT.getText();
				int OrderNumber = Integer.parseInt(OrderNumberT.getText());
				int productID = Integer.parseInt(ProductIDT.getText());
				int customerID = Integer.parseInt(CustsomerIDT.getText());
				int EmployeeId = Integer.parseInt(EmployeeIdT.getText());
				LocalDate orderDate = OrderDate.getValue();
				Float orderSum = Float.parseFloat(OrderSumT.getText());
				// adds the data inside the tree
				insertintoOrder(OrderList, OrderNumber, customerID, orderDate, orderSum, shipCode, EmployeeId);

				// add EMp ID
				OrderList.add(new Order(OrderNumber, shipCode, customerID, orderDate, orderSum, EmployeeId));

				adding.close();

				// Add the record to the ObservableList
				// Update the TableView
				// table.setItems();
			} catch (NumberFormatException ex) {
				lbResult.setText("Invalid input. Please enter valid numeric values.");

			}
		});

		adding.setScene(pane);
		adding.setTitle("Adding Data");
		pane.getStylesheets().add(getClass().getResource("styles.css").toExternalForm());
		adding.show();
		return OrderList;
	}

	ObservableList<Finance> addRecordFinance(ObservableList<Finance> financeList) {// a method that adds a new method to
																					// the tree
		Stage adding = new Stage();
		VBox vbox = new VBox(10); // VBox with spacing of 10
		vbox.setAlignment(Pos.CENTER); // Align vbox children to center
		Scene pane = new Scene(vbox, 600, 350);
		lbResult.setText("");
		OrderNumberT.clear();
		InvoiceSumT.clear();
		InvoiceBillsT.clear();
		InvoiceStatusT.clear();
		hb1.getChildren().clear();
		hb1.getChildren().addAll(OrderNumber, OrderNumberT);
		hb1.setAlignment(Pos.CENTER);
		hb2.getChildren().clear();
		hb2.getChildren().addAll(InvoiceSum, InvoiceSumT);
		hb2.setAlignment(Pos.CENTER);
		hb3.getChildren().clear();
		hb3.getChildren().addAll(InvoiceBills, InvoiceBillsT);
		hb3.setAlignment(Pos.CENTER);
		hb4.getChildren().clear();
		hb4.getChildren().addAll(InvoiceStatus, InvoiceStatusT);
		hb4.setAlignment(Pos.CENTER);
		hb6.getChildren().clear();
		hb6.getChildren().addAll(InvoiceDateL, InvoiceDate);
		hb6.setAlignment(Pos.CENTER);
		hb5.getChildren().clear();
		hb5.getChildren().addAll(ok, lbResult);
		hb5.setAlignment(Pos.CENTER);

		vbox.getChildren().clear();// clears the gui and inserts new records
		vbox.getChildren().addAll(hb1, hb2, hb3, hb4, hb6, hb5);

		vbox.setAlignment(Pos.CENTER);

		ok.setOnAction(e -> {

			try {
				int orderNum = Integer.parseInt(OrderNumberT.getText());
				Float invoiceSum = Float.parseFloat(InvoiceSumT.getText());
				Float invoiceBills = Float.parseFloat(InvoiceBillsT.getText());
				String invoiceStatus = InvoiceStatusT.getText();
				LocalDate invoiceDate = InvoiceDate.getValue();
				// uses the data we got from the fields to insert new data parameters
//	                financeList.add(new Finance(FID,orderNum,invoiceSum,invoiceBills,invoiceStatus,invoiceDate));
				// adds the data inside the tree
				insertintoFinance(financeList, FID, orderNum, invoiceSum, invoiceBills, invoiceStatus, invoiceDate);

				adding.close();
				FID++;
				// Add the record to the ObservableList
				// Update the TableView
				// table.setItems();
			} catch (NumberFormatException ex) {
				lbResult.setText("Invalid input. Please enter valid numeric values.");

			}
		});

		adding.setScene(pane);
		adding.setTitle("Adding Data");
		pane.getStylesheets().add(getClass().getResource("styles.css").toExternalForm());
		adding.show();
		return financeList;
	}

	public ObservableList<Customer> addRecordCustomer(ObservableList<Customer> customerObservableList) {// a method that
																										// adds a new
																										// method to the
																										// tree
		Stage adding = new Stage();
		VBox vbox = new VBox(10); // VBox with spacing of 10
		vbox.setAlignment(Pos.CENTER); // Align vbox children to center
		Scene pane = new Scene(vbox, 600, 350);
		lbResult.setText("");
		CustomerNameT.clear();
		CustomerEmailT.clear();
		CustomerAdrressT.clear();
		CustomerPhoneT.clear();
		hb1.getChildren().clear();
		hb1.getChildren().addAll(CustomerName, CustomerNameT);
		hb1.setAlignment(Pos.CENTER);
		hb2.getChildren().clear();
		hb2.getChildren().addAll(CustomerEmail, CustomerEmailT);
		hb2.setAlignment(Pos.CENTER);
		hb3.getChildren().clear();
		hb3.getChildren().addAll(CustomerAdrress, CustomerAdrressT);
		hb3.setAlignment(Pos.CENTER);
		hb4.getChildren().clear();
		hb4.getChildren().addAll(CustomerPhone, CustomerPhoneT);
		hb4.setAlignment(Pos.CENTER);
		hb5.getChildren().clear();

		hb5.getChildren().addAll(ok, lbResult);
		hb5.setAlignment(Pos.CENTER);

		vbox.getChildren().clear();// clears the gui and inserts new records
		vbox.getChildren().addAll(hb1, hb2, hb3, hb4, hb5);

		vbox.setAlignment(Pos.CENTER);

		ok.setOnAction(e -> {

			try {
				// uses the data we got from the fields to insert new data parameters

				String CName = CustomerNameT.getText();
				String CEmail = CustomerEmailT.getText();
				String Caddress = CustomerAdrressT.getText();
				String CPhone = CustomerPhoneT.getText();

				// adds the data inside the tree
				insertintoCustomer(customerObservableList, CID, CName, CEmail, Caddress, CPhone);
				customerObservableList.add(new Customer(CID, CName, CEmail, Caddress, CPhone));
				adding.close();
				CID++;
				// Add the record to the ObservableList
				// Update the TableView
				// table.setItems();
			} catch (NumberFormatException ex) {
				lbResult.setText("Invalid input. Please enter valid numeric values.");
			}

		});

		adding.setScene(pane);
		adding.setTitle("Adding Data");
		pane.getStylesheets().add(getClass().getResource("styles.css").toExternalForm());
		adding.show();
		return customerObservableList;

	}

	ObservableList<Shipment> addRecordShipment(ObservableList<Shipment> shipmentList) {// a method that adds a new
																						// method to the tree
		Stage adding = new Stage();
		VBox vbox = new VBox(10); // VBox with spacing of 10
		vbox.setAlignment(Pos.CENTER); // Align vbox children to center
		Scene pane = new Scene(vbox, 600, 350);
		lbResult.setText("");
		OrderNumberT.clear();
		ShipmentSatusT.clear();
		ShipmentCostT.clear();

		hb1.getChildren().clear();
		hb1.getChildren().addAll(OrderNumber, OrderNumberT);
		hb1.setAlignment(Pos.CENTER);
		hb2.getChildren().clear();
		hb2.getChildren().addAll(ShipmentDateL, ShipmentDate);
		hb2.setAlignment(Pos.CENTER);
		hb3.getChildren().clear();
		hb3.getChildren().addAll(ShipmentSatus, ShipmentSatusT);
		hb3.setAlignment(Pos.CENTER);
		hb4.getChildren().clear();
		hb4.getChildren().addAll(ShipmentCost, ShipmentCostT);
		hb4.setAlignment(Pos.CENTER);
		hb5.getChildren().clear();
		hb5.getChildren().addAll(ok, lbResult);
		hb5.setAlignment(Pos.CENTER);
		hb6.getChildren().clear();
		hb6.getChildren().addAll(ShipCode, ShipCodeT);
		hb6.setAlignment(Pos.CENTER);
		vbox.getChildren().clear();// clears the gui and inserts new records
		vbox.getChildren().addAll(hb6, hb1, hb2, hb3, hb4, hb5);

		vbox.setAlignment(Pos.CENTER);

		ok.setOnAction(e -> {

			try {
				String shipmentcode = ShipCodeT.getText();
				if (shipmentcode.contains("SC")){
					int orderNum = Integer.parseInt(OrderNumberT.getText());
					LocalDate shipmentDate = ShipmentDate.getValue();
					String shipmentStatus = ShipmentSatusT.getText();
					Float shipmentCost = Float.parseFloat(ShipmentCostT.getText());
					if (shipmentStatus.equals("Shipped") || shipmentStatus.equals("In Transit") || shipmentStatus.equals("Delivered") || shipmentStatus.equals("Pending"))
					// uses the data we got from the fields to insert new data parameters
					{
						shipmentList.add(new Shipment(shipmentcode, orderNum, shipmentDate, shipmentStatus, shipmentCost));
						// adds the data inside the tree
						insertintoShipment(shipmentList, shipmentcode, orderNum, shipmentDate, shipmentStatus, shipmentCost);

						adding.close();
					}else lbResult.setText("Invalid input. Please enter valid numeric values.");


				}else lbResult.setText("Invalid input. Please enter valid numeric values.");


				// Add the record to the ObservableList
				// Update the TableView
				// table.setItems();
			} catch (NumberFormatException ex) {
				lbResult.setText("Invalid input. Please enter valid numeric values.");

			}
		});

		adding.setScene(pane);
		adding.setTitle("Adding Data");
		pane.getStylesheets().add(getClass().getResource("styles.css").toExternalForm());
		adding.show();
		return shipmentList;

	}

	ObservableList<Employee> addRecordEmployee(ObservableList<Employee> employeeList) {// a method that adds a new
																						// method to the tree
		Stage adding = new Stage();
		VBox vbox = new VBox(10); // VBox with spacing of 10
		vbox.setAlignment(Pos.CENTER); // Align vbox children to center
		Scene pane = new Scene(vbox, 600, 350);
		lbResult.setText("");
		EmployeeIdT.clear();
		EmployeeEmailT.clear();
		EmployeeNameT.clear();
		EmployeeRoleT.clear();
		EmployeeSalaryT.clear();
		EmployeePasswordT.clear();
		EmployeeUserNameT.clear();

		hb1.getChildren().clear();
		hb1.getChildren().addAll(EmployeeId, EmployeeIdT);
		hb1.setAlignment(Pos.CENTER);
		hb2.getChildren().clear();
		hb2.getChildren().addAll(EmployeeName, EmployeeNameT);
		hb2.setAlignment(Pos.CENTER);
		hb3.getChildren().clear();
		hb3.getChildren().addAll(EmployeeEmail, EmployeeEmailT);
		hb3.setAlignment(Pos.CENTER);
		hb4.getChildren().clear();
		hb4.getChildren().addAll(EmployeeRole, EmployeeRoleT);
		hb4.setAlignment(Pos.CENTER);
		hb5.getChildren().clear();
		hb5.getChildren().addAll(ok, lbResult);
		hb5.setAlignment(Pos.CENTER);
		hb6.getChildren().clear();
		hb6.getChildren().addAll(EmployeeSalary, EmployeeSalaryT);
		hb6.setAlignment(Pos.CENTER);
		hb7.getChildren().clear();
		hb7.getChildren().addAll(EmployeeUserName, EmployeeUserNameT);
		hb7.setAlignment(Pos.CENTER);
		hb8.getChildren().clear();
		hb8.getChildren().addAll(EmployeePassword, EmployeePasswordT);
		hb8.setAlignment(Pos.CENTER);

		vbox.getChildren().clear();// clears the gui and inserts new records
		vbox.getChildren().addAll(hb1, hb2, hb3, hb4, hb6, hb7, hb8, hb5);

		vbox.setAlignment(Pos.CENTER);

		ok.setOnAction(e -> {
			try {
				int employeeId = Integer.parseInt(EmployeeIdT.getText());
				String employeeName = EmployeeNameT.getText();
				String Email = EmployeeEmailT.getText();

				// Check if the email contains any of the specified domains
				if (!(Email.contains("gmail") || Email.contains("yahoo") || Email.contains("hotmail")
						|| Email.contains("outlook"))) {
					throw new IllegalArgumentException("Invalid email domain.");
				}

				String employeeRole = EmployeeRoleT.getText();
				Float employeeSalary = Float.parseFloat(EmployeeSalaryT.getText());
				String username = EmployeeUserNameT.getText();
				String password = EmployeePasswordT.getText();

				// Uses the data we got from the fields to insert new data parameters
				employeeList.add(new Employee(employeeId, employeeName, Email, employeeRole, employeeSalary, username,
						password));
				// Adds the data inside the tree
				insertintoEmployee(employeeList, employeeId, employeeName, Email, employeeRole, employeeSalary,
						username, password);

				adding.close();

				// Add the record to the ObservableList
				// Update the TableView
				// table.setItems();
			} catch (NumberFormatException ex) {
				lbResult.setText("Invalid input. Please enter valid numeric values.");
			} catch (IllegalArgumentException ex) {
				lbResult.setText(ex.getMessage());
			} catch (Exception ex) {
				lbResult.setText("An unexpected error occurred. Please try again.");
				ex.printStackTrace();
			}
		});

		adding.setScene(pane);
		adding.setTitle("Adding Data");
		pane.getStylesheets().add(getClass().getResource("styles.css").toExternalForm());
		adding.show();
		return employeeList;

	}

	ObservableList<Supplier> addRecordSupplier(ObservableList<Supplier> supplierList) {// a method that adds a new
																						// method to the tree
		Stage adding = new Stage();
		VBox vbox = new VBox(10); // VBox with spacing of 10
		vbox.setAlignment(Pos.CENTER); // Align vbox children to center
		Scene pane = new Scene(vbox, 600, 350);
		lbResult.setText("");
		SupplierNameT.clear();
		SupplierIDT.clear();

		hb1.getChildren().clear();
		hb1.getChildren().addAll(SupplierID, SupplierIDT);
		hb1.setAlignment(Pos.CENTER);
		hb2.getChildren().clear();
		hb2.getChildren().addAll(SupplierName, SupplierNameT);
		hb2.setAlignment(Pos.CENTER);
		hb3.getChildren().clear();
		hb3.getChildren().addAll(SupplierDateL, SupplierDate);
		hb3.setAlignment(Pos.CENTER);
		hb5.getChildren().clear();
		hb5.getChildren().addAll(ok, lbResult);
		hb5.setAlignment(Pos.CENTER);

		vbox.getChildren().clear();// clears the gui and inserts new records
		vbox.getChildren().addAll(hb1, hb2, hb3, hb5);

		vbox.setAlignment(Pos.CENTER);

		ok.setOnAction(e -> {

			try {
				String SupplierName = SupplierNameT.getText();
				int supplierID = Integer.parseInt(SupplierIDT.getText());
				LocalDate supplierDate = SupplierDate.getValue();
				// uses the data we got from the fields to insert new data parameters
				supplierList.add(new Supplier(supplierID, SupplierName, supplierDate));
				// adds the data inside the tree
				insertintoSupplier(supplierList, SupplierName, supplierID, supplierDate);

				adding.close();

				// Add the record to the ObservableList
				// Update the TableView
				// table.setItems();
			} catch (NumberFormatException ex) {
				lbResult.setText("Invalid input. Please enter valid numeric values.");

			}
		});

		adding.setScene(pane);
		adding.setTitle("Adding Data");
		pane.getStylesheets().add(getClass().getResource("styles.css").toExternalForm());
		adding.show();
		return supplierList;

	}

	ObservableList<Manufacturing> addRecordManufacturing(ObservableList<Manufacturing> manufacturingList) {// a method
																											// that adds
																											// a new
																											// method to
																											// the tree
		Stage adding = new Stage();
		VBox vbox = new VBox(10); // VBox with spacing of 10
		vbox.setAlignment(Pos.CENTER); // Align vbox children to center
		Scene pane = new Scene(vbox, 600, 350);
		lbResult.setText("");
		ProductCatagoryT.clear();
		ProductIDT.clear();
		ProductPriceT.clear();

		hb1.getChildren().clear();
		hb1.getChildren().addAll(ProductID, ProductIDT);
		hb1.setAlignment(Pos.CENTER);
		hb2.getChildren().clear();
		hb2.getChildren().addAll(ProductCatagory, ProductCatagoryT);
		hb2.setAlignment(Pos.CENTER);
		hb3.getChildren().clear();
		hb3.getChildren().addAll(ProductPrice, ProductPriceT);
		hb3.setAlignment(Pos.CENTER);
		hb4.getChildren().clear();
		hb4.getChildren().addAll(ManufacuringDateL, ManufacuringDate);
		hb4.setAlignment(Pos.CENTER);
		hb5.getChildren().clear();
		hb5.getChildren().addAll(ok, lbResult);
		hb5.setAlignment(Pos.CENTER);
		hb6.getChildren().clear();
		hb6.getChildren().addAll(ItemsNeeded, ItemsNeededT);
		hb6.setAlignment(Pos.CENTER);
		vbox.getChildren().clear();// clears the gui and inserts new records
		vbox.getChildren().addAll(hb1, hb2, hb3, hb4, hb6, hb5);

		vbox.setAlignment(Pos.CENTER);

		ok.setOnAction(e -> {

			try {
				String ProductCatagory = ProductCatagoryT.getText();
				int ProductID = Integer.parseInt(ProductIDT.getText());
				LocalDate ManufacuringDateL = ManufacuringDate.getValue();
				int ItemsNeeded = Integer.parseInt(ItemsNeededT.getText());
				Float ProductPrice = Float.parseFloat(ProductPriceT.getText());
				// uses the data we got from the fields to insert new data parameters
				manufacturingList.add(
						new Manufacturing(ProductID, ProductCatagory, ProductPrice, ManufacuringDateL, ItemsNeeded));
				// adds the data inside the tree
				insertintoManufacturing(manufacturingList, ProductCatagory, ProductID, ManufacuringDateL, ItemsNeeded,
						ProductPrice);

				adding.close();

				// Add the record to the ObservableList
				// Update the TableView
				// table.setItems();
			} catch (NumberFormatException ex) {
				lbResult.setText("Invalid input. Please enter valid numeric values.");

			}
		});

		adding.setScene(pane);
		adding.setTitle("Adding Data");
		pane.getStylesheets().add(getClass().getResource("styles.css").toExternalForm());
		adding.show();
		return manufacturingList;

	}

	ObservableList<SoldItems> addRecordSoldItems(ObservableList<SoldItems> soldItemsList,
																		 ObservableList<Manufacturing> manufacturingList) {
		Stage adding = new Stage();
		VBox vbox = new VBox(10); // VBox with spacing of 10
		vbox.setAlignment(Pos.CENTER); // Align vbox children to center
		Scene pane = new Scene(vbox, 600, 350);

		lbResult.setText("");
		SoldItmesPriceT.clear();
		ProductIDT.clear();

		hb1.getChildren().clear();
		hb1.getChildren().addAll(ProductID, ProductIDT);
		hb1.setAlignment(Pos.CENTER);
		hb2.getChildren().clear();
		hb2.getChildren().addAll(SoldItmesPrice, SoldItmesPriceT);
		hb2.setAlignment(Pos.CENTER);
		hb3.getChildren().clear();
		hb3.getChildren().addAll(SoldItmesDateL, SoldItmesDate);
		hb3.setAlignment(Pos.CENTER);
		hb5.getChildren().clear();
		hb5.getChildren().addAll(ok, lbResult);
		hb5.setAlignment(Pos.CENTER);

		vbox.getChildren().clear(); // clears the gui and inserts new records
		vbox.getChildren().addAll(hb1, hb2, hb3, hb5);

		vbox.setAlignment(Pos.CENTER);

		ok.setOnAction(e -> {
			try {
				int productID = Integer.parseInt(ProductIDT.getText());
				String solditemsCategory = "";

				// Check the manufacturing list for the product ID
				for (Manufacturing manufacturing : manufacturingList) {
					if (manufacturing.getProductId() == productID) {
						solditemsCategory = manufacturing.getCategory();
						break;
					}
				}

				if (solditemsCategory.isEmpty()) {
					lbResult.setText("Product ID not found in manufacturing list.");
					return;
				}

				float soldItemsPrice = Float.parseFloat(SoldItmesPriceT.getText());
				LocalDate soldItemsDate = SoldItmesDate.getValue();

				// Uses the data we got from the fields to insert new data parameters
				soldItemsList.add(new SoldItems(productID, solditemsCategory, soldItemsPrice, soldItemsDate));

				// Adds the data inside the tree
				insertintoSoldItems(soldItemsList, solditemsCategory, productID, soldItemsDate, soldItemsPrice);

				adding.close();

				// Add the record to the ObservableList
				// Update the TableView
				// table.setItems();
			} catch (NumberFormatException ex) {
				lbResult.setText("Invalid input. Please enter valid numeric values.");
			}
		});

		adding.setScene(pane);
		adding.setTitle("Adding Data");
		pane.getStylesheets().add(getClass().getResource("styles.css").toExternalForm());
		adding.show();
		return soldItemsList;
	}
	public static void insertintoCustomer(ObservableList<Customer> customerObservableList, int id, String name,
			String email, String address, String Phone) {
		String sql = "INSERT INTO customer (CustomerID, CustomerName, CustomerEmail, CustomerAddress, CustomerPhone) VALUES ( ?, ?, ?, ?, ?)";

		try (Connection connections = Conn.getConnection();
				PreparedStatement preparedStatement = connections.prepareStatement(sql);) {
			// Set values for each parameter in the SQL query
			preparedStatement.setInt(1, id);
			preparedStatement.setString(2, name);
			preparedStatement.setString(3, email);
			preparedStatement.setString(4, address);
			preparedStatement.setString(5, Phone);
//	    	            customerObservableList.add(new Customer(id, name, email, address, Phone));

			// Execute the SQL query to insert the data
			int rowsAffected = preparedStatement.executeUpdate();

			// Print the number of rows affected
			System.out.println(rowsAffected + " row(s) inserted successfully.");
		} catch (SQLException e) {
			// Handle any SQL exceptions
			e.printStackTrace();
		}
	}

	public static void insertintoInventoryItems(ObservableList<InventoryItems> customerObservableList, int modelID,
			String modelType, Float Modelprice, int supplierID) {
		String sql = "INSERT INTO inventoryitems (ItemID, ModelType, ModelPrice, SuplierID)VALUES   ( ?, ?, ?, ?)";

		try (Connection connections = Conn.getConnection();
				PreparedStatement preparedStatement = connections.prepareStatement(sql);) {
			// Set values for each parameter in the SQL query
			preparedStatement.setInt(1, modelID);
			preparedStatement.setString(2, modelType);
			preparedStatement.setFloat(3, Modelprice);
			preparedStatement.setInt(4, supplierID);

//	    	            customerObservableList.add(new Customer(id, name, email, address, Phone));

			// Execute the SQL query to insert the data
			int rowsAffected = preparedStatement.executeUpdate();

			// Print the number of rows affected
			System.out.println(rowsAffected + " row(s) inserted successfully.");
		} catch (SQLException e) {
			// Handle any SQL exceptions
			e.printStackTrace();
		}
	}

	public static void insertintoFinance(ObservableList<Finance> FinanceList, int invoiceID, int OrderNum,
			Float InvoiceSum, Float InvoiceBills, String InvoiceStatus, LocalDate InvoiceDate) {
		String sql = "INSERT INTO finance (invoiceID, OrderNum, InvoiceSum,InvoiceBills,InvoiceStatus,InvoiceDate)VALUES   ( ?, ?, ?,?,?,?)";

		try (Connection connections = Conn.getConnection();
				PreparedStatement preparedStatement = connections.prepareStatement(sql);) {
			// Set values for each parameter in the SQL query
			preparedStatement.setInt(1, invoiceID);
			preparedStatement.setInt(2, OrderNum);
			preparedStatement.setFloat(3, InvoiceSum);
			preparedStatement.setFloat(4, InvoiceBills);
			preparedStatement.setString(5, InvoiceStatus);
			Date sqlDate = Date
					.valueOf(LocalDate.of(InvoiceDate.getYear(), InvoiceDate.getMonth(), InvoiceDate.getDayOfMonth()));
			preparedStatement.setDate(6, sqlDate);

//	    	            customerObservableList.add(new Customer(id, name, email, address, Phone));

			// Execute the SQL query to insert the data
			int rowsAffected = preparedStatement.executeUpdate();

			// Print the number of rows affected
			System.out.println(rowsAffected + " row(s) inserted successfully.");
		} catch (SQLException e) {
			// Handle any SQL exceptions
			e.printStackTrace();
		}
	}

	public static void insertintoOrder(ObservableList<Order> customerObservableList, int OrderNum, int CustomerID,
			LocalDate OrderDate, Float ordersum, String shipmentcode, int EmployeeId) {
		String sql = "INSERT INTO order1 (OrderNum, ProductID, CustomerID, OrderDate, OrderSum, ShipCode, empId) VALUES   ( ?, ?, ?, ?, ?, ?, ?)";

		try (Connection connections = Conn.getConnection();
				PreparedStatement preparedStatement = connections.prepareStatement(sql);) {
			// Set values for each parameter in the SQL query
			Date sqlDate = Date
					.valueOf(LocalDate.of(OrderDate.getYear(), OrderDate.getMonth(), OrderDate.getDayOfMonth()));
			preparedStatement.setInt(1, OrderNum);
//	    	            preparedStatement.setInt(2, ProductID);
			preparedStatement.setInt(3, CustomerID);
			preparedStatement.setDate(4, sqlDate);
			preparedStatement.setFloat(5, ordersum);
			preparedStatement.setString(6, shipmentcode);
			preparedStatement.setInt(7, EmployeeId);

			// Execute the SQL query to insert the data
			int rowsAffected = preparedStatement.executeUpdate();

			// Print the number of rows affected
			System.out.println(rowsAffected + " row(s) inserted successfully.");
		} catch (SQLException e) {
			// Handle any SQL exceptions
			e.printStackTrace();
		}
	}

	public static void insertintoShipment(ObservableList<Shipment> ShipmentList, String ShipCode, int orderNum,
			LocalDate ShipmentDate, String ShipmentStatus, Float ShipmentCost) {
		String sql = "INSERT INTO shipment (ShipmentCode, OrderNum, ShipmentDate, ShipmentStatus, ShipmentCost) VALUES   ( ?, ?, ?, ?, ?)";

		try (Connection connections = Conn.getConnection();
				PreparedStatement preparedStatement = connections.prepareStatement(sql);) {
			// Set values for each parameter in the SQL query
			Date sqlDate = Date.valueOf(
					LocalDate.of(ShipmentDate.getYear(), ShipmentDate.getMonth(), ShipmentDate.getDayOfMonth()));
			preparedStatement.setString(1, ShipCode);
			preparedStatement.setInt(2, orderNum);
			preparedStatement.setDate(3, sqlDate);
			preparedStatement.setString(4, ShipmentStatus);
			preparedStatement.setFloat(5, ShipmentCost);

//	    	            customerObservableList.add(new Customer(id, name, email, address, Phone));

			// Execute the SQL query to insert the data
			int rowsAffected = preparedStatement.executeUpdate();

			// Print the number of rows affected
			System.out.println(rowsAffected + " row(s) inserted successfully.");
		} catch (SQLException e) {
			// Handle any SQL exceptions
			e.printStackTrace();
		}
	}

//	  shipment (ShipmentCode, OrderNum, ShipmentDate, ShipmentStatus, ShipmentCost)
	public static void insertintoEmployee(ObservableList<Employee> EmployeeList, int employeeId, String employeeName,
			String employeeEmail, String employeeRole, Float salary, String username, String password) {
		String sql = "INSERT INTO employee (EmployeeID, EmpName, Email, Role, salary, Username, Password) VALUES   ( ?, ?, ?, ?, ?, ?, ?)";

		try (Connection connections = Conn.getConnection();
				PreparedStatement preparedStatement = connections.prepareStatement(sql);) {
			// Set values for each parameter in the SQL query

			preparedStatement.setInt(1, employeeId);
			preparedStatement.setString(2, employeeName);
			preparedStatement.setString(3, employeeEmail);
			preparedStatement.setString(4, employeeRole);
			preparedStatement.setFloat(5, salary);
			preparedStatement.setString(6, username);
			preparedStatement.setString(7, password);

//	    	            customerObservableList.add(new Customer(id, name, email, address, Phone));

			// Execute the SQL query to insert the data
			int rowsAffected = preparedStatement.executeUpdate();

			// Print the number of rows affected
			System.out.println(rowsAffected + " row(s) inserted successfully.");
		} catch (SQLException e) {
			// Handle any SQL exceptions
			e.printStackTrace();
		}
	}

	public static void insertintoSupplier(ObservableList<Supplier> ShipmentList, String SupplierName, int SupplierID,
			LocalDate SupplierDate) {
		String sql = "INSERT INTO Suplier (SuplierID, suplierName, supplydate) VALUES   ( ?, ?, ?)";

		try (Connection connections = Conn.getConnection();
				PreparedStatement preparedStatement = connections.prepareStatement(sql);) {
			// Set values for each parameter in the SQL query
			Date sqlDate = Date.valueOf(
					LocalDate.of(SupplierDate.getYear(), SupplierDate.getMonth(), SupplierDate.getDayOfMonth()));
			preparedStatement.setInt(1, SupplierID);
			preparedStatement.setString(2, SupplierName);
			preparedStatement.setDate(3, sqlDate);

//	    	            customerObservableList.add(new Customer(id, name, email, address, Phone));

			// Execute the SQL query to insert the data
			int rowsAffected = preparedStatement.executeUpdate();

			// Print the number of rows affected
			System.out.println(rowsAffected + " row(s) inserted successfully.");
		} catch (SQLException e) {
			// Handle any SQL exceptions
			e.printStackTrace();
		}
	}

	public static void insertintoManufacturing(ObservableList<Manufacturing> manufacturingList, String category,
			int ProductID, LocalDate ManufacturingDate, int ItemsNeededformanufacturing, Float Price) {
		String sql = "INSERT INTO Manufacturing (ProductID, category, Price, ManufacturingDate, ItemsNeededformanufacturing) VALUES   ( ?, ?, ?, ?, ?)";

		try (Connection connections = Conn.getConnection();
				PreparedStatement preparedStatement = connections.prepareStatement(sql);) {
			// Set values for each parameter in the SQL query
			Date sqlDate = Date.valueOf(LocalDate.of(ManufacturingDate.getYear(), ManufacturingDate.getMonth(),
					ManufacturingDate.getDayOfMonth()));
			preparedStatement.setInt(1, ProductID);
			preparedStatement.setString(2, category);
			preparedStatement.setFloat(3, Price);
			preparedStatement.setDate(4, sqlDate);
			preparedStatement.setFloat(5, ItemsNeededformanufacturing);

//	    	            customerObservableList.add(new Customer(id, name, email, address, Phone));

			// Execute the SQL query to insert the data
			int rowsAffected = preparedStatement.executeUpdate();

			// Print the number of rows affected
			System.out.println(rowsAffected + " row(s) inserted successfully.");
		} catch (SQLException e) {
			// Handle any SQL exceptions
			e.printStackTrace();
		}
	}

	public static void insertintoSoldItems(ObservableList<SoldItems> ShipmentList, String category, int productID, LocalDate SoldDate, Float price) {

		String sql = "INSERT INTO SoldItems (productID, category, price, SoldDate) VALUES   ( ?, ?, ?, ?)";

		try (Connection connections = Conn.getConnection();
			 PreparedStatement preparedStatement = connections.prepareStatement(sql);) {
			// Set values for each parameter in the SQL query
			Date sqlDate = Date
					.valueOf(LocalDate.of(SoldDate.getYear(), SoldDate.getMonth(), SoldDate.getDayOfMonth()));
			preparedStatement.setInt(1, productID);
			preparedStatement.setString(2, category);
			preparedStatement.setFloat(3, price);
			preparedStatement.setDate(4, sqlDate);

//	    	            customerObservableList.add(new Customer(id, name, email, address, Phone));

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