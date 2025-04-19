package com.example.database;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class GuiUpdate extends Application {
	static MySQLJDBCConnection Conn = new MySQLJDBCConnection();

	private DatePicker datePicker = new DatePicker();
	private Label InvoiceID = new Label("InvoiceID: ");
	private TextField InvoiceIDT = new TextField();
	private Label ProductID = new Label("ProductID: ");
	private Label itemID = new Label("Item ID: ");
	private Label SuplierID = new Label("Supplier ID: ");
	private Label ModelType = new Label("ModelType: ");
	private Label ModelPrice = new Label("ModelPrice: ");

	private Label ModelID = new Label("ModelID: ");
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
	private Label lbResult = new Label(null);

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

	private Label ProductCategory = new Label("ProductCategory: ");
	private Label ProductPrice = new Label("ProductPrice: ");
	private Label ManufacturingDateL = new Label("ManufacturingDate: ");
	private DatePicker ManufacturingDate = new DatePicker();
	private Label ItemsNeeded = new Label("ItemsNeeded: ");

	private Label SoldItemsPrice = new Label("SoldItessPrice: ");
	private Label SoldItemsDateL = new Label("SoldItemsDate: ");
	private DatePicker SoldItemsDate = new DatePicker();

	private TextField ProductIDT = new TextField();
	private TextField ModelTypeT = new TextField();
	private TextField ModelPriceT = new TextField();
	private TextField ItemIDT = new TextField();
	private TextField SuplierIDT = new TextField();
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

	private TextField ProductCategoryT = new TextField();
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
	private HBox hb7 = new HBox();
	private HBox hb9 = new HBox();
	private HBox hb8 = new HBox();
	private Button ok = new Button("OK");
	private Button ok2 = new Button("OK");

	@Override
	public void start(Stage primaryStage) {
		VBox mainLayout = new VBox(10); // VBox with spacing of 10

		Button btnAddRecordInventory = new Button("Add Inventory Item");
//		btnAddRecordInventory.setOnAction(e -> updateRecordinventoryItems());

		Button btnAddRecordOrder = new Button("Add Order");
//		btnAddRecordOrder.setOnAction(e -> updateRecordOrder());

		Button btnAddRecordFinance = new Button("Add Finance");
//		btnAddRecordFinance.setOnAction(e -> updateRecordFinance());

		Button btnAddRecordCustomer = new Button("Add Customer");
//		btnAddRecordCustomer.setOnAction(e -> searchRecordCustomer());

		Button btnAddRecordShipment = new Button("Add Shipment");
//		btnAddRecordShipment.setOnAction(e -> searchRecordShipment());

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

//	int productID2 = Integer.parseInt(ProductIDT.getText());
//	String modelType = ModelTypeT.getText();
//	Float modelPrice = Float.parseFloat(ModelPriceT.getText());
//	
//	updateInventoryItem(InventoryItemsList, productID2, modelType, modelPrice);

	public ObservableList<InventoryItems> updateRecordinventoryItems(ObservableList<InventoryItems> inventorylist) { // tree
		Stage search = new Stage();
		VBox vbox = new VBox(10); // VBox with spacing of 10
		vbox.setAlignment(Pos.CENTER); // Align vbox children to center
		Scene pane = new Scene(vbox, 350, 150);
		pane.getStylesheets().add(getClass().getResource("styles.css").toExternalForm());
		lbResult.setText(null);
		OrderNumberT.clear();
		hb1.getChildren().clear();
		hb1.getChildren().addAll(itemID, ItemIDT);
		hb1.setAlignment(Pos.CENTER);
		hb5.getChildren().clear();
		hb5.getChildren().addAll(ok, lbResult);
		hb5.setAlignment(Pos.CENTER);
		vbox.getChildren().clear();// clears the gui and inserts new records
		vbox.getChildren().addAll(hb1, hb5);

		vb1.setAlignment(Pos.CENTER);

		ok.setOnAction(e -> {
			if (ItemIDT.getText() == null) {
				lbResult.setText("Please enter all Required values");
			} else {
				try {
					int ItemID1 = Integer.parseInt(ItemIDT.getText());
					// uses the data we got from the fields to insert new data parameters

					// adds the data inside the tree

					search.close();
					lbResult.setText(null);
					Stage adding = new Stage();
					VBox vbox2 = new VBox(10); // VBox with spacing of 10
					vbox2.setAlignment(Pos.CENTER); // Align vbox children to center
					Scene pane2 = new Scene(vbox2, 600, 350);
					lbResult.setText(null);
					ShipCodeT.clear();
					ProductIDT.clear();
					CustsomerIDT.clear();
					OrderStatusT.clear();
					OrderSumT.clear();
					hb1.getChildren().clear();
					hb1.getChildren().addAll(itemID, ItemIDT);
					hb1.setAlignment(Pos.CENTER);
					hb2.getChildren().clear();
					hb2.getChildren().addAll(ModelType, ModelTypeT);
					hb2.setAlignment(Pos.CENTER);
					hb3.getChildren().clear();
					hb3.getChildren().addAll(ModelPrice, ModelPriceT);
					hb3.setAlignment(Pos.CENTER);
					hb4.getChildren().clear();
					hb4.getChildren().addAll(SuplierID, SuplierIDT);
					hb4.setAlignment(Pos.CENTER);

					hb5.getChildren().clear();
					hb5.getChildren().addAll(ok, lbResult);
					hb5.setAlignment(Pos.CENTER);
					vbox2.getChildren().clear();// clears the gui and inserts new records
					vbox2.getChildren().addAll(hb1, hb2, hb3, hb4, hb5);

					vb1.setAlignment(Pos.CENTER);

					ok.setOnAction(a -> {
						if (ItemIDT.getText().isBlank() || ModelTypeT.getText().isBlank()
								|| ModelPriceT.getText().isBlank()) {
							lbResult.setText("Please enter all Required values");
						} else {
							try {
								int ItemId = Integer.parseInt(ItemIDT.getText());
								String modelType = ModelTypeT.getText();
								Float modelPrice = Float.parseFloat(ModelPriceT.getText());
								int suplierId = Integer.parseInt(SuplierIDT.getText());

								updateInventoryItem(inventorylist, ItemId, modelType, modelPrice, suplierId);
//								 uses the data we got from the fields to insert new data parameters

								// adds the data inside the tree

								adding.close();

								// Add the record to the ObservableList
								// Update the TableView
								// table.setItems();
							} catch (NumberFormatException ex) {
								lbResult.setText("Invalid input. Please enter valid numeric values.");
							}
						}
					});

					adding.setScene(pane2);
					pane2.getStylesheets().add(getClass().getResource("styles.css").toExternalForm());
					adding.setTitle("Adding Data");
					adding.show();
					// Add the record to the ObservableList
					// Update the TableView
					// table.setItems();
				} catch (NumberFormatException ex) {
					lbResult.setText("Invalid input. Please enter valid numeric values.");
				}
			}
		});

		search.setScene(pane);
		search.setTitle("searchRecordOrder");
		search.show();
		return inventorylist;
	}

	public ObservableList<Order> updateRecordOrder(ObservableList<Order> orderlist) {
		Stage search = new Stage();
		VBox vbox = new VBox(10);
		vbox.setAlignment(Pos.CENTER);
		Scene pane = new Scene(vbox, 350, 150);
		pane.getStylesheets().add(getClass().getResource("styles.css").toExternalForm());
		lbResult.setText(null);
		OrderNumberT.clear();
		hb1.getChildren().clear();
		hb1.getChildren().addAll(OrderNumber, OrderNumberT);
		hb1.setAlignment(Pos.CENTER);
		hb5.getChildren().clear();
		hb5.getChildren().addAll(ok, lbResult);
		hb5.setAlignment(Pos.CENTER);
		vbox.getChildren().clear();
		vbox.getChildren().addAll(hb1, hb5);

		vb1.setAlignment(Pos.CENTER);

		ok.setOnAction(e -> {
			if (OrderNumberT.getText().isEmpty()) {
				lbResult.setText("Please enter all Required values");
			} else {
				try {
					int orderNum = Integer.parseInt(OrderNumberT.getText());
					search.close();
					lbResult.setText(null);
					Stage adding = new Stage();
					VBox vbox2 = new VBox(10);
					vbox2.setAlignment(Pos.CENTER);
					Scene pane2 = new Scene(vbox2, 600, 350);
					lbResult.setText(null);
					ShipCodeT.clear();
					CustsomerIDT.clear();
					OrderStatusT.clear();
					OrderSumT.clear();
					hb1.getChildren().clear();
					hb1.getChildren().addAll(ShipCode, ShipCodeT);
					hb1.setAlignment(Pos.CENTER);
					hb3.getChildren().clear();
					hb3.getChildren().addAll(OrderNumber, OrderNumberT);
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
					hb5.getChildren().clear();
					hb5.getChildren().addAll(ok, lbResult);
					hb5.setAlignment(Pos.CENTER);
					vbox2.getChildren().clear();
					vbox2.getChildren().addAll(hb1, hb3, hb4, hb6, hb8, hb7, hb5);

					vb1.setAlignment(Pos.CENTER);

					ok.setOnAction(a -> {
						if (ShipCodeT.getText().isEmpty() || CustsomerIDT.getText().isEmpty()
								|| OrderDate.getValue() == null || OrderSumT.getText().isEmpty()) {
							lbResult.setText("Please enter all Required values");
						} else {
							try {
								String shipCode = ShipCodeT.getText();
								int customerID = Integer.parseInt(CustsomerIDT.getText());
								int EmployeeId = Integer.parseInt(EmployeeIdT.getText());
								LocalDate orderDate = OrderDate.getValue();
								String orderStatus = OrderStatusT.getText();
								float orderSum = Float.parseFloat(OrderSumT.getText());

								// Call the updateOrder method to update the record
								updateOrder(orderlist, orderNum, shipCode, EmployeeId, customerID, orderDate,
										orderStatus, orderSum);
								adding.close();
							} catch (NumberFormatException ex) {
								lbResult.setText("Invalid input. Please enter valid numeric values.");
							}
						}
					});

					adding.setScene(pane2);
					pane2.getStylesheets().add(getClass().getResource("styles.css").toExternalForm());
					adding.setTitle("Adding Data");
					adding.show();
				} catch (NumberFormatException ex) {
					lbResult.setText("Invalid input. Please enter valid numeric values.");
				}
			}
		});

		search.setScene(pane);
		search.setTitle("searchRecordOrder");
		search.show();
		return orderlist;
	}

	public ObservableList<Finance> updateRecordFinance(ObservableList<Finance> financelist) {// a method that adds a new
																								// method to the tree
		Stage search = new Stage();
		VBox vbox = new VBox(10); // VBox with spacing of 10
		vbox.setAlignment(Pos.CENTER); // Align vbox children to center
		Scene pane = new Scene(vbox, 350, 150);
		pane.getStylesheets().add(getClass().getResource("styles.css").toExternalForm());
		lbResult.setText(null);
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
			if (InvoiceIDT.getText().isBlank()) {
				lbResult.setText("Please enter all Required values");
			} else {
				try {
					int invoiceid = Integer.parseInt(InvoiceIDT.getText());

					// uses the data we got from the fields to insert new data parameters

					// adds the data inside the tree

					search.close();
					lbResult.setText(null);
					Stage adding = new Stage();
					VBox vbox2 = new VBox(10); // VBox with spacing of 10
					vbox2.setAlignment(Pos.CENTER); // Align vbox children to center
					Scene pane2 = new Scene(vbox2, 600, 350);
					pane2.getStylesheets().add(getClass().getResource("styles.css").toExternalForm());
					lbResult.setText(null);
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

					vbox2.getChildren().clear();// clears the gui and inserts new records
					vbox2.getChildren().addAll(hb1, hb2, hb3, hb4, hb6, hb5);

					vbox2.setAlignment(Pos.CENTER);

					ok.setOnAction(a -> {
						if (OrderNumberT.getText().isBlank() || InvoiceSumT.getText().isBlank()
								|| InvoiceBillsT.getText().isBlank() || InvoiceStatusT.getText().isBlank()
								|| InvoiceDate.getValue() == null) {
							lbResult.setText("Please enter all Required values");
						} else {
							try {
								int id = Integer.parseInt(ProductID.getText());
								Float invoiceSum = Float.parseFloat(InvoiceSumT.getText());
								;
								Float invoiceBills = Float.parseFloat(InvoiceBillsT.getText());
								;
								String invoiceStatus = InvoiceStatusT.getText();
								LocalDate invoiceDate = InvoiceDate.getValue();
								;
								int orderNum = Integer.parseInt(OrderNumberT.getText());
								// uses the data we got from the fields to insert new data parameters

								updateFinance(financelist, id, orderNum, invoiceSum, invoiceBills, invoiceStatus,
										invoiceDate);
								// adds the data inside the tree

								adding.close();

								// Add the record to the ObservableList
								// Update the TableView
								// table.setItems();
							} catch (NumberFormatException ex) {
								lbResult.setText("Invalid input. Please enter valid numeric values.");
							}
						}
					});

					adding.setScene(pane2);
					adding.setTitle("Adding Data");
					adding.show();
					// Add the record to the ObservableList
					// Update the TableView
					// table.setItems();
				} catch (NumberFormatException ex) {
					lbResult.setText("Invalid input. Please enter valid numeric values.");
				}
			}
		});

		search.setScene(pane);
		search.setTitle("searchRecordFinance");
		search.show();
		return financelist;
	}

	public ObservableList<Customer> searchRecordCustomer(ObservableList<Customer> customerObservableList) {// a method
																											// that adds
																											// a new
																											// method to
																											// the tree
		Stage search = new Stage();
		VBox vbox = new VBox(10); // VBox with spacing of 10
		vbox.setAlignment(Pos.CENTER); // Align vbox children to center
		Scene pane = new Scene(vbox, 350, 150);
		pane.getStylesheets().add(getClass().getResource("styles.css").toExternalForm());
		lbResult.setText(null);
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
			if (CustsomerIDT.getText().isBlank()) {
				lbResult.setText("Please enter all Required values");
			} else {
				try {
					int CustsomerID = Integer.parseInt(CustsomerIDT.getText());
					// uses the data we got from the fields to insert new data parameters

					// adds the data inside the tree

					search.close();
					lbResult.setText(null);
					Stage adding = new Stage();
					VBox vbox2 = new VBox(10); // VBox with spacing of 10
					vbox2.setAlignment(Pos.CENTER); // Align vbox children to center
					Scene pane2 = new Scene(vbox2, 600, 350);
					lbResult.setText(null);
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

					vbox2.getChildren().clear();// clears the gui and inserts new records
					vbox2.getChildren().addAll(hb1, hb2, hb3, hb4, hb5);

					vbox2.setAlignment(Pos.CENTER);

					ok.setOnAction(a -> {
						if (CustomerNameT.getText().isBlank() || CustomerEmailT.getText().isBlank()
								|| CustomerAdrressT.getText().isBlank() || CustomerPhoneT.getText().isBlank()) {
							lbResult.setText("Please enter all Required values");
						} else {
							try {
								String CName = CustomerNameT.getText();
								String CEmail = CustomerEmailT.getText();
								String Caddress = CustomerAdrressT.getText();
								String CPhone = CustomerPhoneT.getText();
								// uses the data we got from the fields to insert new data parameters

								updateCustomerName(customerObservableList, CustsomerID, CName, CEmail, Caddress,
										CPhone);

								// adds the data inside the tree

								adding.close();

								// Add the record to the ObservableList
								// Update the TableView
								// table.setItems();
							} catch (NumberFormatException ex) {
								lbResult.setText("Invalid input. Please enter valid numeric values.");
							}
						}
					});

					adding.setScene(pane2);
					pane2.getStylesheets().add(getClass().getResource("styles.css").toExternalForm());
					adding.setTitle("Adding Data");
					adding.show();
					// Add the record to the ObservableList
					// Update the TableView
					// table.setItems();
				} catch (NumberFormatException ex) {
					lbResult.setText("Invalid input. Please enter valid numeric values.");
				}
			}
		});

		search.setScene(pane);
		search.setTitle("searchRecordCustomer");
		search.show();
		return customerObservableList;

	}

	// uses the data we got from the fields to insert new data parameters

//	
	public ObservableList<Shipment> searchRecordShipment(ObservableList<Shipment> ShipList) {// a method that adds a new
																								// method to the tree
		// a method that adds a new method to the tree
		Stage search = new Stage();
		VBox vbox = new VBox(10); // VBox with spacing of 10
		vbox.setAlignment(Pos.CENTER); // Align vbox children to center
		Scene pane = new Scene(vbox, 350, 150);
		pane.getStylesheets().add(getClass().getResource("styles.css").toExternalForm());
		lbResult.setText(null);
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
			if (ShipCodeT.getText().isBlank()) {
				lbResult.setText("Please enter all Required values");
			} else {
				try {
					String shipmentCode = ShipCodeT.getText();
					// uses the data we got from the fields to insert new data parameters

					// adds the data inside the tree
					search.close();
					lbResult.setText(null);
					Stage adding = new Stage();
					VBox vbox2 = new VBox(10); // VBox with spacing of 10
					vbox2.setAlignment(Pos.CENTER); // Align vbox children to center
					Scene pane2 = new Scene(vbox2, 600, 350);
					lbResult.setText(null);
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

					vbox2.getChildren().clear();// clears the gui and inserts new records
					vbox2.getChildren().addAll(hb1, hb2, hb3, hb4, hb5);

					vbox2.setAlignment(Pos.CENTER);

					ok.setOnAction(a -> {
						if (OrderNumberT.getText().isBlank() || ShipmentDate.getValue() == null
								|| ShipmentSatusT.getText().isBlank() || ShipmentCostT.getText().isBlank()) {
							lbResult.setText("Please enter all Required values");
						} else {
							try {

								// adds the data inside the tree
								String Shipcode = ShipCodeT.getText();
								int orderNum = Integer.parseInt(OrderNumberT.getText());
								LocalDate shipmentDate = ShipmentDate.getValue();
								String shipmentStatus = ShipmentSatusT.getText();
								Float shipmentCost = Float.parseFloat(ShipmentCostT.getText());

								updateShipment(ShipList, Shipcode, orderNum, shipmentDate, shipmentStatus,
										shipmentCost);
								adding.close();

								// Add the record to the ObservableList
								// Update the TableView
								// table.setItems();
							} catch (NumberFormatException ex) {
								lbResult.setText("Invalid input. Please enter valid numeric values.");
							}
						}
					});

					adding.setScene(pane2);
					pane2.getStylesheets().add(getClass().getResource("styles.css").toExternalForm());
					adding.setTitle("Adding Data");
					adding.show();
					// Add the record to the ObservableList
					// Update the TableView
					// table.setItems();
				} catch (NumberFormatException ex) {
					lbResult.setText("Invalid input. Please enter valid numeric values.");
				}
			}
		});

		search.setScene(pane);
		search.setTitle("searchRecordShipment");
		search.show();
		return ShipList;

	}

	public ObservableList<Employee> updateRecordEmployee(ObservableList<Employee> employeeList) {
		Stage search = new Stage();
		VBox vbox = new VBox(10);
		vbox.setAlignment(Pos.CENTER);
		Scene pane = new Scene(vbox, 350, 150);
		pane.getStylesheets().add(getClass().getResource("styles.css").toExternalForm());
		lbResult.setText(null);
		EmployeeIdT.clear();
		HBox hb1 = new HBox(10);
		HBox hb5 = new HBox(10);
		Button ok = new Button("OK");

		hb1.getChildren().clear();
		hb1.getChildren().addAll(EmployeeId, EmployeeIdT);
		hb1.setAlignment(Pos.CENTER);
		hb5.getChildren().clear();
		hb5.getChildren().addAll(ok, lbResult);
		hb5.setAlignment(Pos.CENTER);

		vbox.getChildren().clear();
		vbox.getChildren().addAll(hb1, hb5);
		vbox.setAlignment(Pos.CENTER);

		ok.setOnAction(e -> {
			if (EmployeeIdT.getText().isBlank()) {
				lbResult.setText("Please enter all Required values");
			} else {
				try {
					int employeeId = Integer.parseInt(EmployeeIdT.getText());
					search.close();
					lbResult.setText(null);
					Stage adding = new Stage();
					VBox vbox2 = new VBox(10);
					vbox2.setAlignment(Pos.CENTER);
					Scene pane2 = new Scene(vbox2, 600, 350);
					lbResult.setText(null);
					EmployeeNameT.clear();
					EmployeeEmailT.clear();
					EmployeeRoleT.clear();
					EmployeeSalaryT.clear();
					EmployeeUserNameT.clear();
					EmployeePasswordT.clear();
					HBox hb2 = new HBox(10);
					HBox hb3 = new HBox(10);
					HBox hb4 = new HBox(10);
					HBox hb6 = new HBox(10);

					hb1.getChildren().clear();
					hb1.getChildren().addAll(EmployeeName, EmployeeNameT);
					hb1.setAlignment(Pos.CENTER);
					hb2.getChildren().clear();
					hb2.getChildren().addAll(EmployeeEmail, EmployeeEmailT);
					hb2.setAlignment(Pos.CENTER);
					hb3.getChildren().clear();
					hb3.getChildren().addAll(EmployeeRole, EmployeeRoleT);
					hb3.setAlignment(Pos.CENTER);
					hb4.getChildren().clear();
					hb4.getChildren().addAll(EmployeeSalary, EmployeeSalaryT);
					hb4.setAlignment(Pos.CENTER);
					hb6.getChildren().clear();
					hb6.getChildren().addAll(EmployeeUserName, EmployeeUserNameT);
					hb6.setAlignment(Pos.CENTER);
					HBox hb7 = new HBox(10);
					hb7.getChildren().addAll(EmployeePassword, EmployeePasswordT);
					hb7.setAlignment(Pos.CENTER);
					hb5.getChildren().clear();
					hb5.getChildren().addAll(ok, lbResult);

					vbox2.getChildren().clear();
					vbox2.getChildren().addAll(hb1, hb2, hb3, hb4, hb6, hb7, hb5);
					vbox2.setAlignment(Pos.CENTER);

					ok.setOnAction(a -> {
						if (EmployeeNameT.getText().isBlank() || EmployeeEmailT.getText().isBlank()
								|| EmployeeRoleT.getText().isBlank() || EmployeeSalaryT.getText().isBlank()
								|| EmployeeUserNameT.getText().isBlank() || EmployeePasswordT.getText().isBlank()) {
							lbResult.setText("Please enter all Required values");
						} else {
							try {
								String employeeName = EmployeeNameT.getText();
								String employeeEmail = EmployeeEmailT.getText();
								String employeeRole = EmployeeRoleT.getText();
								Float employeeSalary = Float.parseFloat(EmployeeSalaryT.getText());
								String employeeUserName = EmployeeUserNameT.getText();
								String employeePassword = EmployeePasswordT.getText();
								updateEmployee(employeeList, employeeId, employeeName, employeeEmail, employeeRole,
										employeeSalary, employeeUserName, employeePassword);
								adding.close();
							} catch (NumberFormatException ex) {
								lbResult.setText("Invalid input. Please enter valid numeric values.");
							}
						}
					});

					adding.setScene(pane2);
					adding.setTitle("Update Employee");
					pane2.getStylesheets().add(getClass().getResource("styles.css").toExternalForm());
					adding.show();
				} catch (NumberFormatException ex) {
					lbResult.setText("Invalid input. Please enter valid numeric values.");
				}
			}
		});

		search.setScene(pane);
		search.setTitle("Search Employee");
		search.show();
		return employeeList;
	}

	public ObservableList<Supplier> updateRecordSupplier(ObservableList<Supplier> supplierList) {
		Stage search = new Stage();
		VBox vbox = new VBox(10);
		vbox.setAlignment(Pos.CENTER);
		Scene pane = new Scene(vbox, 350, 150);
		pane.getStylesheets().add(getClass().getResource("styles.css").toExternalForm());
		lbResult.setText(null);
		SupplierIDT.clear();
		hb1.getChildren().clear();
		hb1.getChildren().addAll(SupplierID, SupplierIDT);
		hb1.setAlignment(Pos.CENTER);
		hb5.getChildren().clear();
		hb5.getChildren().addAll(ok, lbResult);
		hb5.setAlignment(Pos.CENTER);

		vbox.getChildren().clear();
		vbox.getChildren().addAll(hb1, hb5);
		vbox.setAlignment(Pos.CENTER);

		ok.setOnAction(e -> {
			if (SupplierIDT.getText().isBlank()) {
				lbResult.setText("Please enter all Required values");
			} else {
				try {
					int supplierId = Integer.parseInt(SupplierIDT.getText());
					search.close();
					lbResult.setText(null);
					Stage adding = new Stage();
					VBox vbox2 = new VBox(10);
					vbox2.setAlignment(Pos.CENTER);
					Scene pane2 = new Scene(vbox2, 600, 350);
					lbResult.setText(null);
					SupplierNameT.clear();
					SupplierDate.setValue(null);
					hb1.getChildren().clear();
					hb1.getChildren().addAll(SupplierName, SupplierNameT);
					hb1.setAlignment(Pos.CENTER);
					hb2.getChildren().clear();
					hb2.getChildren().addAll(SupplierDateL, SupplierDate);
					hb2.setAlignment(Pos.CENTER);
					hb5.getChildren().clear();
					hb5.getChildren().addAll(ok, lbResult);

					vbox2.getChildren().clear();
					vbox2.getChildren().addAll(hb1, hb2, hb5);
					vbox2.setAlignment(Pos.CENTER);

					ok.setOnAction(a -> {
						if (SupplierNameT.getText().isBlank() || SupplierDate.getValue() == null) {
							lbResult.setText("Please enter all Required values");
						} else {
							try {
								String supplierName = SupplierNameT.getText();
								LocalDate supplierDate = SupplierDate.getValue();
								updateSupplier(supplierList, supplierId, supplierName, supplierDate);
								adding.close();
							} catch (NumberFormatException ex) {
								lbResult.setText("Invalid input. Please enter valid numeric values.");
							}
						}
					});

					adding.setScene(pane2);
					adding.setTitle("Update Supplier");
					pane2.getStylesheets().add(getClass().getResource("styles.css").toExternalForm());
					adding.show();
				} catch (NumberFormatException ex) {
					lbResult.setText("Invalid input. Please enter valid numeric values.");
				}
			}
		});

		search.setScene(pane);
		search.setTitle("Search Supplier");
		search.show();
		return supplierList;
	}

	public static void updateSupplier(ObservableList<Supplier> supplierList, int supplierId, String supplierName,
			LocalDate supplierDate) {
		// Correct the SQL statement with the actual column names from your database
		// table
		String sql = "UPDATE Suplier SET suplierName = ?, supplydate = ? WHERE SuplierID = ?";

		try (Connection connections = Conn.getConnection();
				PreparedStatement preparedStatement = connections.prepareStatement(sql)) {

			preparedStatement.setString(1, supplierName);
			preparedStatement.setDate(2, Date.valueOf(supplierDate)); // Convert LocalDate to java.sql.Date
			preparedStatement.setInt(3, supplierId);

			int rowsAffected = preparedStatement.executeUpdate();
			System.out.println(rowsAffected + " row(s) updated successfully.");

			Supplier newsup = new Supplier(supplierId, supplierName, supplierDate);
			Supplier supplierToRemove = null;
			for (Supplier supplier : supplierList) {
				if (supplier.getSupplierId() == supplierId) {
					supplierToRemove = supplier;
				}
			}
			supplierList.remove(supplierToRemove);
			supplierList.add(newsup);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void updateEmployee(ObservableList<Employee> employeeList, int employeeId, String employeeName,
			String employeeEmail, String employeeRole, Float employeeSalary, String employeeUserName,
			String employeePassword) {
		String sql = "UPDATE employee SET EmpName = ?, Email = ?, Role = ?, salary = ?, Username = ?, Password = ? WHERE EmployeeID = ?";

		try (Connection connections = Conn.getConnection();
				PreparedStatement preparedStatement = connections.prepareStatement(sql)) {

			preparedStatement.setString(1, employeeName);
			preparedStatement.setString(2, employeeEmail);
			preparedStatement.setString(3, employeeRole);
			preparedStatement.setFloat(4, employeeSalary);
			preparedStatement.setString(5, employeeUserName);
			preparedStatement.setString(6, employeePassword);
			preparedStatement.setInt(7, employeeId);

			Employee newemployee = new Employee(employeeId, employeeName, employeeEmail, employeeRole, employeeSalary,
					employeeUserName, employeePassword);
			int rowsAffected = preparedStatement.executeUpdate();
			System.out.println(rowsAffected + " row(s) updated successfully.");

			Employee employeeToRemove = null;
			for (Employee employee : employeeList) {
				if (employee.getEmpID() == employeeId) {
					employeeToRemove = employee;
				}
			}
			employeeList.remove(employeeToRemove);
			employeeList.add(newemployee);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public ObservableList<Manufacturing> updateRecordManufacturing(ObservableList<Manufacturing> manufacturingList) {
		Stage search = new Stage();
		VBox vbox = new VBox(10);
		vbox.setAlignment(Pos.CENTER);
		Scene pane = new Scene(vbox, 350, 150);
		lbResult.setText(null);
		ProductIDT.clear();
		hb1.getChildren().clear();
		hb1.getChildren().addAll(ProductID, ProductIDT);
		hb1.setAlignment(Pos.CENTER);
		hb5.getChildren().clear();
		hb5.getChildren().addAll(ok, lbResult);
		hb5.setAlignment(Pos.CENTER);

		vbox.getChildren().clear();
		vbox.getChildren().addAll(hb1, hb5);
		vbox.setAlignment(Pos.CENTER);

		ok.setOnAction(e -> {
			if (ProductIDT.getText().isBlank()) {
				lbResult.setText("Please enter all Required values");
			} else {
				try {
					int productId = Integer.parseInt(ProductIDT.getText());
					search.close();
					lbResult.setText(null);
					Stage adding = new Stage();
					VBox vbox2 = new VBox(10);
					vbox2.setAlignment(Pos.CENTER);
					Scene pane2 = new Scene(vbox2, 600, 350);
					lbResult.setText(null);
					ProductCategoryT.clear();
					ProductPriceT.clear();
					ManufacturingDate.setValue(null);
					ItemsNeededT.clear();
					hb1.getChildren().clear();
					hb1.getChildren().addAll(ProductID, ProductIDT);
					hb1.setAlignment(Pos.CENTER);
					hb2.getChildren().clear();
					hb2.getChildren().addAll(ProductCategory, ProductCategoryT);
					hb2.setAlignment(Pos.CENTER);
					hb3.getChildren().clear();
					hb3.getChildren().addAll(ProductPrice, ProductPriceT);
					hb3.setAlignment(Pos.CENTER);
					hb4.getChildren().clear();
					hb4.getChildren().addAll(ManufacturingDateL, ManufacturingDate);
					hb4.setAlignment(Pos.CENTER);
					hb6.getChildren().clear();
					hb6.getChildren().addAll(ItemsNeeded, ItemsNeededT);
					hb6.setAlignment(Pos.CENTER);
					hb5.getChildren().clear();
					hb5.getChildren().addAll(ok, lbResult);
					hb5.setAlignment(Pos.CENTER);
					vbox2.getChildren().clear();
					vbox2.getChildren().addAll(hb1, hb2, hb3, hb4, hb6, hb5);
					vbox2.setAlignment(Pos.CENTER);

					ok.setOnAction(a -> {
						if (ProductCategoryT.getText().isBlank() || ProductPriceT.getText().isBlank()
								|| ManufacturingDate.getValue() == null || ItemsNeededT.getText().isBlank()) {
							lbResult.setText("Please enter all Required values");
						} else {
							try {
								String productCategory = ProductCategoryT.getText();
								Float productPrice = Float.parseFloat(ProductPriceT.getText());
								LocalDate manufacturingDate = ManufacturingDate.getValue();
								int itemsNeeded = Integer.parseInt(ItemsNeededT.getText());
								updateManufacturing(manufacturingList, productId, productCategory, productPrice,
										manufacturingDate, itemsNeeded);
								adding.close();
							} catch (NumberFormatException ex) {
								lbResult.setText("Invalid input. Please enter valid numeric values.");
							}
						}
					});

					adding.setScene(pane2);
					adding.setTitle("Update Manufacturing");
					adding.show();
				} catch (NumberFormatException ex) {
					lbResult.setText("Invalid input. Please enter valid numeric values.");
				}
			}
		});

		search.setScene(pane);
		search.setTitle("Search Manufacturing");
		search.show();
		return manufacturingList;
	}

	public static void updateManufacturing(ObservableList<Manufacturing> manufacturingList, int productId,
			String productCategory, Float productPrice, LocalDate manufacturingDate, int ItemsNeeded) {
		String sql = "UPDATE Manufacturing SET ProductID = ?, category = ?, Price = ?, ManufacturingDate = ? , ItemsNeededformanufacturing = ? WHERE ProductID = ?";

		try (Connection connections = Conn.getConnection();
				PreparedStatement preparedStatement = connections.prepareStatement(sql)) {

			preparedStatement.setInt(1, productId);
			preparedStatement.setString(2, productCategory);
			preparedStatement.setFloat(3, productPrice);
			preparedStatement.setDate(4, Date.valueOf(manufacturingDate));
			preparedStatement.setInt(5, ItemsNeeded);
			preparedStatement.setInt(6, productId);

			int rowsAffected = preparedStatement.executeUpdate();
			System.out.println(rowsAffected + " row(s) updated successfully.");
			Manufacturing newman = new Manufacturing(productId, productCategory, productPrice, manufacturingDate,
					ItemsNeeded);
			Manufacturing manufacturingToRemove = null;
			for (Manufacturing manufacturing : manufacturingList) {
				if (manufacturing.getProductId() == productId) {
					manufacturingToRemove = manufacturing;
				}
			}
			manufacturingList.remove(manufacturingToRemove);
			manufacturingList.add(newman);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void updateCustomerName(ObservableList<Customer> customerObservableList, int customerId,
			String newCustomerName, String email, String address, String phone) {
		String sql = "UPDATE customer SET CustomerName = ?, CustomerEmail = ?, CustomerAddress = ?, CustomerPhone = ? WHERE CustomerID = ?";

		try (Connection connections = Conn.getConnection();
				PreparedStatement preparedStatement = connections.prepareStatement(sql);) {
			// Set values for each parameter in the SQL query
			preparedStatement.setString(1, newCustomerName);
			preparedStatement.setString(2, email);
			preparedStatement.setString(3, address); // Fixed the parameter order
			preparedStatement.setString(4, phone);
			preparedStatement.setInt(5, customerId);

			Customer newCust = new Customer(customerId, newCustomerName, email, address, phone);

			// Execute the SQL query to update the data
			int rowsAffected = preparedStatement.executeUpdate();

			// Print the number of rows affected
			System.out.println(rowsAffected + " row(s) updated successfully.");

			// Remove the old customer from the observable list and add the updated one
			Customer customerToRemove = null;
			for (Customer customer : customerObservableList) {
				if (customer.getCustomerID() == customerId) {
					customerToRemove = customer;
				}
			}
			customerObservableList.remove(customerToRemove);
			customerObservableList.add(newCust);

		} catch (SQLException e) {
			// Handle any SQL exceptions
			e.printStackTrace();
		}
	}

	public static void updateInventoryItem(ObservableList<InventoryItems> InventoryList, int ItemId, String ModelType,
			Float Price, int suplierId) {
		String sql = "UPDATE inventoryitems SET  ModelType = ?, ModelPrice = ? ,SuplierID = ?  WHERE ItemID = ?";

		try (Connection connections = Conn.getConnection();
				PreparedStatement preparedStatement = connections.prepareStatement(sql);) {
			// Set values for each parameter in the SQL query

			preparedStatement.setString(1, ModelType);
			preparedStatement.setFloat(2, Price); // Fixed the parameter order

			preparedStatement.setInt(4, ItemId);
			preparedStatement.setInt(3, suplierId);
			InventoryItems newItem = new InventoryItems(0, ModelType, Price, 0);

			// Execute the SQL query to update the data
			int rowsAffected = preparedStatement.executeUpdate();

			// Print the number of rows affected
			System.out.println(rowsAffected + " row(s) updated successfully.");

			// Remove the old customer from the observable list and add the updated one
			InventoryItems itemToRemove = null;
			for (InventoryItems inventoryItems : InventoryList) {
				if (inventoryItems.getItemId() == ItemId) {
					itemToRemove = inventoryItems;
				}
			}
			InventoryList.remove(itemToRemove);
			InventoryList.add(newItem);

		} catch (SQLException e) {
			// Handle any SQL exceptions
			e.printStackTrace();
		}
	}

	public static void updateOrder(ObservableList<Order> orderList, int ordernum, String ShipCode, int empIdID,
			int customerId, LocalDate orderDate, String orderStatus, float orderSum) {
		String sql = "UPDATE order1 SET OrderNum = ?, CustomerID = ?, OrderDate = ?, OrderSum = ? , ShipCode = ?, empId = ? WHERE OrderNum = ?";

		try (Connection connections = Conn.getConnection();
				PreparedStatement preparedStatement = connections.prepareStatement(sql)) {

			preparedStatement.setInt(1, ordernum);
			preparedStatement.setInt(2, customerId);
			preparedStatement.setDate(3, Date.valueOf(orderDate)); // Convert LocalDate to java.sql.Date
			preparedStatement.setFloat(4, orderSum);
			preparedStatement.setString(5, ShipCode);
			preparedStatement.setInt(6, empIdID);
			preparedStatement.setInt(7, ordernum);

			int rowsAffected = preparedStatement.executeUpdate();
			System.out.println(rowsAffected + " row(s) updated successfully.");

//	        public Order(int orderNum, String shipCode, int productID, int customerID, LocalDate orderDate,  float orderSum)
			// add EMpID
			Order newItem = new Order(ordernum, ShipCode, customerId, orderDate, orderSum, empIdID);

			Order orderToRemove = null;
			for (Order order : orderList) {
				if (order.getOrderNum() == ordernum) {
					orderToRemove = order;
				}
			}
			orderList.remove(orderToRemove);
			orderList.add(newItem);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void updateFinance(ObservableList<Finance> financeList, int invoiceId, int orderNum, Float invoiceSum,
			Float invoiceBills, String invoiceStatus, LocalDate invoiceDate) {
		String sql = "UPDATE finance SET OrderNum = ?, InvoiceSum = ?, InvoiceBills = ?, InvoiceStatus = ?, InvoiceDate = ? WHERE invoiceID = ?";

		try (Connection connections = Conn.getConnection();
				PreparedStatement preparedStatement = connections.prepareStatement(sql)) {

			preparedStatement.setInt(1, orderNum);
			preparedStatement.setFloat(2, invoiceSum);
			preparedStatement.setFloat(3, invoiceBills);
			preparedStatement.setString(4, invoiceStatus);
			preparedStatement.setDate(5, Date.valueOf(invoiceDate)); // Convert LocalDate to java.sql.Date
			preparedStatement.setInt(6, invoiceId);

			int rowsAffected = preparedStatement.executeUpdate();
			System.out.println(rowsAffected + " row(s) updated successfully.");

//	        public Finance(int invoiceID, int orderNum, Float invoiceSum, Float invoiceBills, String invoiceStatus, LocalDate invoiceDate) {
//	        Finance newItem= new Finance(invoiceId, orderNum, invoiceSum, invoiceBills, invoiceStatus, invoiceDate); 

			Finance financeToRemove = null;
			for (Finance finance : financeList) {
				if (finance.getInvoiceID() == invoiceId) {
					financeToRemove = finance;
				}
			}
			financeList.remove(financeToRemove);
//	        financeList.add(newItem);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void updateShipment(ObservableList<Shipment> shipmentList, String shipmentCode, int orderNum,
			LocalDate shipmentDate, String shipmentStatus, Float shipmentCost) {
		String sql = "UPDATE shipment SET OrderNum = ?, ShipmentDate = ?, ShipmentStatus = ?, ShipmentCost = ? WHERE ShipmentCode = ?";

		try (Connection connections = Conn.getConnection();
				PreparedStatement preparedStatement = connections.prepareStatement(sql)) {

			preparedStatement.setInt(1, orderNum);
			preparedStatement.setDate(2, Date.valueOf(shipmentDate)); // Convert LocalDate to java.sql.Date
			preparedStatement.setString(3, shipmentStatus);
			preparedStatement.setFloat(4, shipmentCost);
			preparedStatement.setString(5, shipmentCode);

			int rowsAffected = preparedStatement.executeUpdate();
			System.out.println(rowsAffected + " row(s) updated successfully.");

			Shipment newItem = new Shipment(shipmentCode, orderNum, shipmentDate, shipmentStatus, shipmentCost);
			Shipment shipmentToRemove = null;
			for (Shipment shipment : shipmentList) {
				if (shipment.getShipmentCode().equals(shipmentCode)) {
					shipmentToRemove = shipment;
				}
			}
			shipmentList.remove(shipmentToRemove);
			shipmentList.add(newItem);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
