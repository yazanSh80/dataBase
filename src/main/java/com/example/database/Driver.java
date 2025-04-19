package com.example.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Driver extends Application {
	static int CustomerIDGenerator = 5;

	static MySQLJDBCConnection connection = new MySQLJDBCConnection();

	static ObservableList<Customer> customerObservableList = FXCollections.observableArrayList();

	static ObservableList<InventoryItems> InventoryItemsList = FXCollections.observableArrayList();
	static ObservableList<Order> orderList = FXCollections.observableArrayList();
	static ObservableList<Shipment> ShipList = FXCollections.observableArrayList();
	static ObservableList<Finance> financelist = FXCollections.observableArrayList();
	static ObservableList<Manufacturing> ManufacturingList = FXCollections.observableArrayList();
	static ObservableList<Supplier> SupplierList = FXCollections.observableArrayList();
	static ObservableList<Employee> EmployeeList = FXCollections.observableArrayList();
	static ObservableList<SoldItems> SoldItemslist = FXCollections.observableArrayList();

	TableView<Customer> customerTable = new TableView<>();
	TableView<InventoryItems> inventoryTable = new TableView<>();
	TableView<Order> orderTable = new TableView<>();
	TableView<Finance> financeTable = new TableView<>();
	TableView<Shipment> shipmentTable = new TableView<>();
	TableView<Employee> employeeTable = new TableView<>();
	TableView<Manufacturing> ManufacturingTable = new TableView<>();
	TableView<Supplier> SupplierTable = new TableView<>();
	TableView<SoldItems> SoldItemsTable = new TableView<>();

	private VBox customerV = new VBox();
	private VBox financeV = new VBox();
	private VBox inventoryItemsV = new VBox();
	private VBox shipmentV = new VBox();
	private VBox orderV = new VBox();
	private VBox employeeV = new VBox();
	private VBox soldItemsV = new VBox();
	private VBox manufacturingV = new VBox();
	private VBox supplierV = new VBox();

	private Button customerI = new Button("Insert");
	private Button customerD = new Button("Delete");
	private Button customerU = new Button("Update");
	private Button customerS = new Button("Search");
	Button CustomerwhoBoughtItem = new Button("Bought Item");

	private Button financeI = new Button("Insert");
	private Button financeD = new Button("Delete");
	private Button financeU = new Button("Update");
	private Button financeS = new Button("Search");
	Button ShowOrderLine = new Button("orderLine");

	private Button inventoryItemsI = new Button("Insert");
	private Button inventoryItemsD = new Button("Delete");
	private Button inventoryItemsU = new Button("Update");
	private Button inventoryItemsS = new Button("Search");

	private Button shipmentI = new Button("Insert");
	private Button shipmentD = new Button("Delete");
	private Button shipmentU = new Button("Update");
	private Button shipmentS = new Button("Search");

	private Button orderI = new Button("Insert");
	private Button orderD = new Button("Delete");
	private Button orderU = new Button("Update");
	private Button orderS = new Button("Search");
	// Employee Buttons
	protected Button employeeI = new Button("Insert");
	protected Button employeeD = new Button("Delete");
	protected Button employeeU = new Button("Update");
	protected Button employeeS = new Button("Search");
	Button EmployeeSoldItem = new Button("Sold Items");

	// SoldItems Buttons
	private Button soldItemsI = new Button("Insert");
	private Button soldItemsS = new Button("Search");

	// Manufacturing Buttons
	private Button manufacturingI = new Button("Insert");
	private Button manufacturingD = new Button("Delete");
	private Button manufacturingU = new Button("Update");
	private Button manufacturingS = new Button("Search");

	// Supplier Buttons
	private Button supplierI = new Button("Insert");
	private Button supplierD = new Button("Delete");
	private Button supplierU = new Button("Update");
	private Button supplierS = new Button("Search");

	private Button ShowItem = new Button("All Data");
	private Button Showorder = new Button("All Data");
	private Button Showfinance = new Button("All Data");
	private Button Showcustomer = new Button("All Data");
	private Button Showshipment = new Button("All Data");
	private Button Showmanufacturing = new Button("All Data");
	private Button Showsupplier = new Button("All Data");
	private Button ShowsoldItems = new Button("All Data");
	private Button Showemployee = new Button("All Data");

	private Button ModelSupplier = new Button("   Model\nSuppllier");

	public void GetDBData() {
		getCustomerFromDb();// done
		getIIFromDb();// done
		getOrderFromDb();// done
		getFinanceFromDb();// done
		getShipmentFromDb();// done
		getManufactingFromDb();// done
		getEmployeeFromDb();// done
		getSupplierFromDb();
		getSoldItemsFromDb();

		// solditems

	}

	public static void main(String[] args) {
		// Creating a MySQLJDBCConnection instance

		launch(args);

	}

	Tab employeeTab = new Tab("Employees");
	TabPane tabPane = new TabPane();

	@Override
	public void start(Stage primaryStage) {
		BorderPane root = new BorderPane();

		// Create a MenuBar with a "Back" menu item
		MenuBar menuBar = new MenuBar();
		Menu fileMenu = new Menu("Program");
		MenuItem backMenuItem = new MenuItem("LogOut");
		backMenuItem.setOnAction(e -> {
			primaryStage.close();
			customerTable.getItems().clear();
			inventoryTable.getItems().clear();
			orderTable.getItems().clear();
			financeTable.getItems().clear();
			shipmentTable.getItems().clear();
			employeeTable.getItems().clear();
			ManufacturingTable.getItems().clear();
			SupplierTable.getItems().clear();
			SoldItemsTable.getItems().clear();
			loginScreen login = new loginScreen();
			login.start(new Stage());
		});

		fileMenu.getItems().add(backMenuItem);
		menuBar.getMenus().add(fileMenu);

		root.setTop(menuBar);

		// 1
		// Customer Tab
		Tab customerTab = new Tab("Customers");

		setupCustomerTable(customerTable);
		BorderPane customerPane = new BorderPane();
		customerPane.setCenter(customerTable);
		customerTab.setContent(customerPane);
		customerI.setMinWidth(130);
		customerD.setMinWidth(130);
		customerU.setMinWidth(130);
		customerS.setMinWidth(130);
		Showcustomer.setMinWidth(130);
		CustomerwhoBoughtItem.setMinWidth(130);
		customerV.getChildren().addAll(customerI, customerD, customerU, customerS, Showcustomer, CustomerwhoBoughtItem);
		customerV.setPadding(new Insets(25, 0, 0, 0));
		customerV.setAlignment(Pos.TOP_CENTER);
		customerPane.setLeft(customerV);
		// 2
		// Finance Tab
		Tab financeTab = new Tab("Finance");

		setupFinanceTable(financeTable);
		BorderPane financePane = new BorderPane();
		financePane.setCenter(financeTable);
		financeTab.setContent(financePane);
		financeI.setMinWidth(110);
		financeD.setMinWidth(110);
		financeU.setMinWidth(110);
		financeS.setMinWidth(110);
		Showfinance.setMinWidth(110);
		ShowOrderLine.setMinWidth(110);
		financeV.getChildren().addAll(financeI, financeD, financeU, financeS, Showfinance, ShowOrderLine);
		financeV.setPadding(new Insets(25, 0, 0, 0));
		financeV.setAlignment(Pos.TOP_CENTER);
		financePane.setLeft(financeV);
		// 3
		// InventoryItems Tab
		Tab inventoryTab = new Tab("Inventory");

		setupInventoryTable(inventoryTable);
		BorderPane inventoryPane = new BorderPane();
		inventoryPane.setCenter(inventoryTable);
		inventoryTab.setContent(inventoryPane);
		inventoryItemsI.setMinWidth(100);
		inventoryItemsD.setMinWidth(100);
		inventoryItemsU.setMinWidth(100);
		inventoryItemsS.setMinWidth(100);
		ShowItem.setMinWidth(100);
		inventoryItemsV.getChildren().addAll(inventoryItemsI, inventoryItemsD, inventoryItemsU, inventoryItemsS,
				ShowItem, ModelSupplier);
		inventoryItemsV.setPadding(new Insets(25, 0, 0, 0));
		inventoryItemsV.setAlignment(Pos.TOP_CENTER);
		inventoryPane.setLeft(inventoryItemsV);
		// 4
		// Shipment Tab
		Tab shipmentTab = new Tab("Shipments");

		setupShipmentTable(shipmentTable);
		BorderPane shipmentPane = new BorderPane();
		shipmentPane.setCenter(shipmentTable);
		shipmentTab.setContent(shipmentPane);
		shipmentI.setMinWidth(100);
		shipmentD.setMinWidth(100);
		shipmentU.setMinWidth(100);
		shipmentS.setMinWidth(100);
		Showshipment.setMinWidth(100);
		shipmentV.getChildren().addAll(shipmentI, shipmentD, shipmentU, shipmentS, Showshipment);
		shipmentV.setPadding(new Insets(25, 0, 0, 0));
		shipmentV.setAlignment(Pos.TOP_CENTER);
		shipmentPane.setLeft(shipmentV);

		// 5
		// Order Tab
		Tab orderTab = new Tab("Orders");

		setupOrderTable(orderTable);
		BorderPane orderPane = new BorderPane();
		orderPane.setCenter(orderTable);
		orderTab.setContent(orderPane);
		orderI.setMinWidth(100);
		orderD.setMinWidth(100);
		orderU.setMinWidth(100);
		orderS.setMinWidth(100);
		Showorder.setMinWidth(100);
		orderV.getChildren().addAll(orderI, orderD, orderU, orderS, Showorder);
		orderV.setPadding(new Insets(25, 0, 0, 0));
		orderV.setAlignment(Pos.TOP_CENTER);
		orderPane.setLeft(orderV);

		Tab manufacturingTab = new Tab("Manufacturing");

		setupManufacturingTable(ManufacturingTable);
		BorderPane manufacturingPane = new BorderPane();
		manufacturingPane.setCenter(ManufacturingTable);
		manufacturingTab.setContent(manufacturingPane);
		manufacturingI.setMinWidth(100);
		manufacturingD.setMinWidth(100);
		manufacturingU.setMinWidth(100);
		manufacturingS.setMinWidth(100);
		Showmanufacturing.setMinWidth(100);
		manufacturingV.getChildren().addAll(manufacturingI, manufacturingD, manufacturingU, manufacturingS,
				Showmanufacturing);
		manufacturingV.setPadding(new Insets(25, 0, 0, 0));
		manufacturingV.setAlignment(Pos.TOP_CENTER);
		manufacturingPane.setLeft(manufacturingV);

		Tab supplierTab = new Tab("Supplier");

		setupSupplierTable(SupplierTable);
		BorderPane supplierPane = new BorderPane();
		supplierPane.setCenter(SupplierTable);
		supplierTab.setContent(supplierPane);
		supplierI.setMinWidth(100);
		supplierD.setMinWidth(100);
		supplierU.setMinWidth(100);
		supplierS.setMinWidth(100);
		Showsupplier.setMinWidth(100);
		supplierV.getChildren().addAll(supplierI, supplierD, supplierU, supplierS, Showsupplier);
		supplierV.setPadding(new Insets(25, 0, 0, 0));
		supplierV.setAlignment(Pos.TOP_CENTER);
		supplierPane.setLeft(supplierV);

		Tab soldItemsTab = new Tab("Sold Items");

		setupSoldItemsTable(SoldItemsTable);
		BorderPane soldItemsPane = new BorderPane();
		soldItemsPane.setCenter(SoldItemsTable);
		soldItemsTab.setContent(soldItemsPane);
		soldItemsI.setMinWidth(100);

		soldItemsS.setMinWidth(100);
		ShowsoldItems.setMinWidth(100);
		soldItemsV.getChildren().addAll(soldItemsI,  soldItemsS, ShowsoldItems);
		soldItemsV.setPadding(new Insets(25, 0, 0, 0));
		soldItemsV.setAlignment(Pos.TOP_CENTER);
		soldItemsPane.setLeft(soldItemsV);

		employeeTab = new Tab("Employees");

		setupEmployeeTable(employeeTable);
		BorderPane employeePane = new BorderPane();
		employeePane.setCenter(employeeTable);
		employeeTab.setContent(employeePane);
		employeeI.setMinWidth(120);
		employeeD.setMinWidth(120);
		employeeU.setMinWidth(120);
		employeeS.setMinWidth(120);
		Showemployee.setMinWidth(120);
		EmployeeSoldItem.setMinWidth(120);
		employeeV.getChildren().addAll(employeeI, employeeD, employeeU, employeeS, Showemployee, EmployeeSoldItem);
		employeeV.setPadding(new Insets(25, 0, 0, 0));
		employeeV.setAlignment(Pos.TOP_CENTER);
		employeePane.setLeft(employeeV);

		loginScreen loginscreen = new loginScreen();
		String role = loginscreen.getRole();
		if (role != null && role.equals("Manager")) {
			tabPane.getTabs().addAll(customerTab, employeeTab, supplierTab, financeTab, inventoryTab, manufacturingTab,
					shipmentTab, orderTab, soldItemsTab);
		} else {
			tabPane.getTabs().addAll(customerTab, supplierTab, financeTab, inventoryTab, manufacturingTab,
					shipmentTab, orderTab, soldItemsTab);
		}

//        tabPane.getTabs().addAll(customerTab, financeTab, inventoryTab, shipmentTab, orderTab);

		root.setCenter(tabPane);
		Scene scene = new Scene(root, 800, 600);
		scene.getStylesheets().add(String.valueOf(getClass().getResource("styles.css")));
		primaryStage.setTitle("Birzeit pharmaceutical company");
		primaryStage.setScene(scene);
		primaryStage.show();

		GUIADD guidadd = new GUIADD();
		GuiDelete delete = new GuiDelete();
		GuiSearch search = new GuiSearch();
		GuiUpdate update = new GuiUpdate();

		shipmentI.setOnAction(e -> {
			shipmentTable.setItems(guidadd.addRecordShipment(ShipList));
		});
		shipmentD.setOnAction(e -> {
			shipmentTable.setItems(delete.DeleteRecordShipment(ShipList));
		});
		shipmentS.setOnAction(e -> {
			search.searchRecordShipment(shipmentTable);
		});
		shipmentU.setOnAction(e -> {
			shipmentTable.setItems(update.searchRecordShipment(ShipList));
//        	shipmentTable.setItems();
		});

		// Finance buttons

		financeI.setOnAction(e -> {
			financeTable.setItems(guidadd.addRecordFinance(financelist));
		});
		financeD.setOnAction(e -> {
			financeTable.setItems(delete.DeleteRecordFinance(financelist));
		});
		financeS.setOnAction(e -> {
			search.searchRecordFinance(financeTable);
		});
		financeU.setOnAction(e -> {
			financeTable.setItems(update.updateRecordFinance(financelist));
		});

		// order buttons
		orderI.setOnAction(e -> {

			orderTable.setItems(guidadd.addRecordOrder(orderList));

		});
		orderD.setOnAction(e -> {
			orderTable.setItems(delete.DeleteRecordOrder(orderList));
		});
		orderS.setOnAction(e -> {
			search.searchRecordOrder(orderTable);
		});
		orderU.setOnAction(e -> {
			orderTable.setItems(update.updateRecordOrder(orderList));
		});

		// inventoryitems buttons
		inventoryItemsI.setOnAction(e -> {
			inventoryTable.setItems(guidadd.addRecordinventoryItems(InventoryItemsList));

		});

		inventoryItemsD.setOnAction(e -> {
			inventoryTable.setItems(delete.DeleteRecordinventoryItems(InventoryItemsList));
		});

		inventoryItemsS.setOnAction(e -> {
			search.searchRecordinventoryItems(inventoryTable);
		});
		inventoryItemsU.setOnAction(e -> {
			;
			inventoryTable.setItems(update.updateRecordinventoryItems(InventoryItemsList));
		});

		ModelSupplier.setOnAction(e -> {
			ModelSuplier();
		});
		// Customer Buttons
		customerI.setOnAction(e -> {
			customerTable.setItems(guidadd.addRecordCustomer(customerObservableList));

		});
		customerD.setOnAction(e -> {
			customerTable.setItems(delete.DeleteRecordCustomer(customerObservableList));

		});
		customerS.setOnAction(e -> {
			search.searchRecordCustomer(customerTable);

		});
		customerU.setOnAction(e -> {
			customerTable.setItems(update.searchRecordCustomer(customerObservableList));
		});

		employeeI.setOnAction(e -> {
			employeeTable.setItems(guidadd.addRecordEmployee(EmployeeList));

		});

		employeeD.setOnAction(e -> {
			employeeTable.setItems(delete.DeleteRecordEmployee(EmployeeList));
		});

		employeeS.setOnAction(e -> {
			search.searchEmployee(employeeTable);
		});
		employeeU.setOnAction(e -> {
			;
			employeeTable.setItems(update.updateRecordEmployee(EmployeeList));
		});

		supplierI.setOnAction(e -> {
			SupplierTable.setItems(guidadd.addRecordSupplier(SupplierList));

		});

		supplierD.setOnAction(e -> {
			SupplierTable.setItems(delete.DeleteRecordSupplier(SupplierList));
		});

		supplierS.setOnAction(e -> {
			search.searchSupplier(SupplierTable);
		});
		supplierU.setOnAction(e -> {
			;
			SupplierTable.setItems(update.updateRecordSupplier(SupplierList));
		});

		manufacturingI.setOnAction(e -> {
			ManufacturingTable.setItems(guidadd.addRecordManufacturing(ManufacturingList));

		});

		manufacturingD.setOnAction(e -> {
			ManufacturingTable.setItems(delete.DeleteRecordManuFactoring(ManufacturingList));
		});

		manufacturingS.setOnAction(e -> {
			search.searchManufacture(ManufacturingTable);
		});
		manufacturingU.setOnAction(e -> {
			;
			ManufacturingTable.setItems(update.updateRecordManufacturing(ManufacturingList));
		});

		soldItemsI.setOnAction(e -> {
			SoldItemsTable.setItems(guidadd.addRecordSoldItems(SoldItemslist, ManufacturingList ));

		});


		soldItemsS.setOnAction(e -> {
			search.searchSoldItems(SoldItemsTable);
		});

		ShowItem.setOnAction(e -> {
			inventoryTable.setItems(InventoryItemsList);
		});

		Showorder.setOnAction(e -> {
			orderTable.setItems(orderList);
		});
		Showfinance.setOnAction(e -> {
			financeTable.setItems(financelist);
		});
		Showcustomer.setOnAction(e -> {
			customerTable.setItems(customerObservableList);
		});

		Showemployee.setOnAction(e -> {
			employeeTable.setItems(EmployeeList);
		});
		ShowsoldItems.setOnAction(e -> {
			SoldItemsTable.setItems(SoldItemslist);

		});
		Showmanufacturing.setOnAction(e -> {
			ManufacturingTable.setItems(ManufacturingList);
		});
		Showfinance.setOnAction(e -> {
			financeTable.setItems(financelist);
		});

		Showshipment.setOnAction(e -> {
			shipmentTable.setItems(ShipList);
		});
		Showsupplier.setOnAction(e -> {
			SupplierTable.setItems(SupplierList);
		});

		EmployeeSoldItem.setOnAction(e -> {
			GetEmployeewhosoldItem();
		});
		CustomerwhoBoughtItem.setOnAction(e -> {
			getCostomerWhoBoughtItemfrom2023();
		});
		ShowOrderLine.setOnAction(e -> {
			GetOrderLine();
		});

	}

	private void setupCustomerTable(TableView<Customer> table) {
//    	ObservableList<Customer> data = FXCollections.observableArrayList();
//    	data.add(new Customer(1, "John Doe", "john@example.com", "123 Street", "555-1234"));
		TableColumn<Customer, Integer> idCol = new TableColumn<>("ID");
		idCol.setCellValueFactory(new PropertyValueFactory<>("customerID"));

		TableColumn<Customer, String> nameCol = new TableColumn<>("Name");
		nameCol.setCellValueFactory(new PropertyValueFactory<>("customerName"));

		TableColumn<Customer, String> emailCol = new TableColumn<>("Email");
		emailCol.setCellValueFactory(new PropertyValueFactory<>("customerEmail"));

		TableColumn<Customer, String> addressCol = new TableColumn<>("Address");
		addressCol.setCellValueFactory(new PropertyValueFactory<>("customerAddress"));

		TableColumn<Customer, String> phoneCol = new TableColumn<>("Phone");
		phoneCol.setCellValueFactory(new PropertyValueFactory<>("customerPhone"));

		table.getColumns().addAll(idCol, nameCol, emailCol, addressCol, phoneCol);
		table.setItems(customerObservableList);

	}

	private void setupFinanceTable(TableView<Finance> table) {
//    	ObservableList<Finance> data = FXCollections.observableArrayList();
//    	data.add(new Finance(1, 1, (float)20.0, (float) 30.0,"Closed", null ));
		TableColumn<Finance, Integer> invoiceIdCol = new TableColumn<>("Invoice ID");
		invoiceIdCol.setCellValueFactory(new PropertyValueFactory<>("invoiceID"));

		TableColumn<Finance, Float> invoiceSumCol = new TableColumn<>("Invoice Sum");
		invoiceSumCol.setCellValueFactory(new PropertyValueFactory<>("invoiceSum"));

		TableColumn<Finance, Float> invoiceBillsCol = new TableColumn<>("Invoice Bills");
		invoiceBillsCol.setCellValueFactory(new PropertyValueFactory<>("invoiceBills"));

		TableColumn<Finance, String> invoiceStatusCol = new TableColumn<>("Invoice Status");
		invoiceStatusCol.setCellValueFactory(new PropertyValueFactory<>("invoiceStatus"));

		TableColumn<Finance, LocalDate> invoiceDateCol = new TableColumn<>("Invoice Date");
		invoiceDateCol.setCellValueFactory(new PropertyValueFactory<>("invoiceDate"));

		table.getColumns().addAll(invoiceIdCol, invoiceSumCol, invoiceBillsCol, invoiceStatusCol, invoiceDateCol);
		table.setItems(financelist);
	}

	private void setupInventoryTable(TableView<InventoryItems> table) {
//    	ObservableList<InventoryItems> data = FXCollections.observableArrayList();
//    	data.add(new InventoryItems("Engine", "10-230", (float) 20000.0));
		TableColumn<InventoryItems, String> ITemIDCol = new TableColumn<>("ItemID");
		ITemIDCol.setCellValueFactory(new PropertyValueFactory<>("ItemId"));

		TableColumn<InventoryItems, String> modelTypeCol = new TableColumn<>("Model Type");
		modelTypeCol.setCellValueFactory(new PropertyValueFactory<>("modelType"));

		TableColumn<InventoryItems, Double> modelPriceCol = new TableColumn<>("Model Price");
		modelPriceCol.setCellValueFactory(new PropertyValueFactory<>("modelPrice"));

		TableColumn<InventoryItems, String> suplierIdCol = new TableColumn<>("Supplier");
		suplierIdCol.setCellValueFactory(new PropertyValueFactory<>("suplierId"));

		table.getColumns().addAll(ITemIDCol, modelTypeCol, modelPriceCol, suplierIdCol);
		table.setItems(InventoryItemsList);
	}

	private void setupShipmentTable(TableView<Shipment> table) {
//    	ObservableList<Shipment> ShipList = FXCollections.observableArrayList();
//    	data.add(new Shipment(1, 2, null, "OutForOrder" ,(float) 20000.0));
		TableColumn<Shipment, Integer> shipmentCodeCol = new TableColumn<>("Shipment Code");
		shipmentCodeCol.setCellValueFactory(new PropertyValueFactory<>("shipmentCode"));

		TableColumn<Shipment, Integer> orderNumCol = new TableColumn<>("Order Number");
		orderNumCol.setCellValueFactory(new PropertyValueFactory<>("orderNum"));

		TableColumn<Shipment, LocalDate> shipmentDateCol = new TableColumn<>("Shipment Date");
		shipmentDateCol.setCellValueFactory(new PropertyValueFactory<>("shipmentDate"));

		TableColumn<Shipment, String> shipmentStatusCol = new TableColumn<>("Shipment Status");
		shipmentStatusCol.setCellValueFactory(new PropertyValueFactory<>("shipmentStatus"));

		TableColumn<Shipment, Float> shipmentCostCol = new TableColumn<>("Shipment Cost");
		shipmentCostCol.setCellValueFactory(new PropertyValueFactory<>("shipmentCost"));

		table.getColumns().addAll(shipmentCodeCol, orderNumCol, shipmentDateCol, shipmentStatusCol, shipmentCostCol);
		table.setItems(ShipList);
	}

	private void setupOrderTable(TableView<Order> table) {
//    	ObservableList<Order> orderList = FXCollections.observableArrayList();
//    	data.add(new Order(1, 2,0, "10-230",30, LocalDate.now(),null, (float) 20000.0));
		TableColumn<Order, Integer> orderNumCol = new TableColumn<>("Order Number");
		orderNumCol.setCellValueFactory(new PropertyValueFactory<>("orderNum"));

		TableColumn<Order, Integer> shipCodeCol = new TableColumn<>("Ship Code");
		shipCodeCol.setCellValueFactory(new PropertyValueFactory<>("shipCode"));

		TableColumn<Order, Integer> customerIdCol = new TableColumn<>("Customer ID");
		customerIdCol.setCellValueFactory(new PropertyValueFactory<>("customerID"));

		TableColumn<Order, LocalDate> orderDateCol = new TableColumn<>("Order Date");
		orderDateCol.setCellValueFactory(new PropertyValueFactory<>("orderDate"));

		TableColumn<Order, Float> orderSumCol = new TableColumn<>("Order Sum");
		orderSumCol.setCellValueFactory(new PropertyValueFactory<>("orderSum"));

		TableColumn<Order, Float> EMPIDCol = new TableColumn<>("Employee ID");
		EMPIDCol.setCellValueFactory(new PropertyValueFactory<>("EmpID"));

		table.getColumns().addAll(orderNumCol, shipCodeCol, customerIdCol, orderDateCol, orderSumCol, EMPIDCol);
		table.setItems(orderList);
	}

	private void setupManufacturingTable(TableView<Manufacturing> table) {
		TableColumn<Manufacturing, Integer> productIdCol = new TableColumn<>("Product ID");
		productIdCol.setCellValueFactory(new PropertyValueFactory<>("productId"));

		TableColumn<Manufacturing, String> categoryCol = new TableColumn<>("Category");
		categoryCol.setCellValueFactory(new PropertyValueFactory<>("category"));

		TableColumn<Manufacturing, Float> priceCol = new TableColumn<>("Price");
		priceCol.setCellValueFactory(new PropertyValueFactory<>("price"));

		TableColumn<Manufacturing, LocalDate> manufacturingDateCol = new TableColumn<>("Manufacturing Date");
		manufacturingDateCol.setCellValueFactory(new PropertyValueFactory<>("manufacturingDate"));
		TableColumn<Manufacturing, Integer> ItemsNeededCol = new TableColumn<>("Items Needed");
		ItemsNeededCol.setCellValueFactory(new PropertyValueFactory<>("itemsneeded"));

		table.getColumns().addAll(productIdCol, categoryCol, priceCol, manufacturingDateCol, ItemsNeededCol);
		table.setItems(ManufacturingList);
	}

	private void setupSupplierTable(TableView<Supplier> table) {
		TableColumn<Supplier, Integer> supplierIdCol = new TableColumn<>("Supplier ID");
		supplierIdCol.setCellValueFactory(new PropertyValueFactory<>("supplierId"));

		TableColumn<Supplier, String> supplierNameCol = new TableColumn<>("Supplier Name");
		supplierNameCol.setCellValueFactory(new PropertyValueFactory<>("supplierName"));

		TableColumn<Supplier, LocalDate> supplierDateCol = new TableColumn<>("Supplier Date");
		supplierDateCol.setCellValueFactory(new PropertyValueFactory<>("supplierDate"));

		table.getColumns().addAll(supplierIdCol, supplierNameCol, supplierDateCol);
		table.setItems(SupplierList);
	}

	private void setupSoldItemsTable(TableView<SoldItems> table) {
		TableColumn<SoldItems, Integer> productIdCol = new TableColumn<>("Product ID");
		productIdCol.setCellValueFactory(new PropertyValueFactory<>("productId"));

		TableColumn<SoldItems, String> categoryCol = new TableColumn<>("Category");
		categoryCol.setCellValueFactory(new PropertyValueFactory<>("category"));

		TableColumn<SoldItems, Double> priceCol = new TableColumn<>("Price");
		priceCol.setCellValueFactory(new PropertyValueFactory<>("price"));

		TableColumn<SoldItems, LocalDate> soldDateCol = new TableColumn<>("Sold Date");
		soldDateCol.setCellValueFactory(new PropertyValueFactory<>("soldDate"));

		table.getColumns().addAll(productIdCol, categoryCol, priceCol, soldDateCol);
		table.setItems(SoldItemslist);
	}

	private void setupEmployeeTable(TableView<Employee> table) {
		TableColumn<Employee, Integer> empIdCol = new TableColumn<>("Employee ID");
		empIdCol.setCellValueFactory(new PropertyValueFactory<>("empID"));

		TableColumn<Employee, String> empNameCol = new TableColumn<>("Employee Name");
		empNameCol.setCellValueFactory(new PropertyValueFactory<>("empName"));

		TableColumn<Employee, String> emailCol = new TableColumn<>("Email");
		emailCol.setCellValueFactory(new PropertyValueFactory<>("email"));

		TableColumn<Employee, String> roleCol = new TableColumn<>("Role");
		roleCol.setCellValueFactory(new PropertyValueFactory<>("role"));

		TableColumn<Employee, Double> salaryCol = new TableColumn<>("Salary");
		salaryCol.setCellValueFactory(new PropertyValueFactory<>("Salary"));

		table.getColumns().addAll(empIdCol, empNameCol, emailCol, roleCol, salaryCol);
		table.setItems(EmployeeList);
	}

	private static void setupCustomerPurchaseTable(TableView<CustomerPurchase> table) {
		TableColumn<CustomerPurchase, Integer> customerIDCol = new TableColumn<>("Customer ID");
		customerIDCol.setCellValueFactory(new PropertyValueFactory<>("customerID"));

		TableColumn<CustomerPurchase, String> categoryCol = new TableColumn<>("Category");
		categoryCol.setCellValueFactory(new PropertyValueFactory<>("category"));

		TableColumn<CustomerPurchase, Integer> orderNumCol = new TableColumn<>("Order Number");
		orderNumCol.setCellValueFactory(new PropertyValueFactory<>("orderNum"));

		TableColumn<CustomerPurchase, Integer> productIDCol = new TableColumn<>("Product ID");
		productIDCol.setCellValueFactory(new PropertyValueFactory<>("productID"));

		TableColumn<CustomerPurchase, Float> priceCol = new TableColumn<>("Price");
		priceCol.setCellValueFactory(new PropertyValueFactory<>("price"));

		TableColumn<CustomerPurchase, LocalDate> dateCol = new TableColumn<>("Date");
		dateCol.setCellValueFactory(new PropertyValueFactory<>("date"));

		table.getColumns().addAll(customerIDCol, categoryCol, orderNumCol, productIDCol, priceCol, dateCol);
	}

	private void setupOrderLineTable(TableView<OrderLine> table) {
		TableColumn<OrderLine, Integer> orderNumCol = new TableColumn<>("Order Number");
		orderNumCol.setCellValueFactory(new PropertyValueFactory<>("orderNum"));

		TableColumn<OrderLine, Integer> productIDCol = new TableColumn<>("Product ID");
		productIDCol.setCellValueFactory(new PropertyValueFactory<>("productID"));

		TableColumn<OrderLine, Integer> invoiceIDCol = new TableColumn<>("Invoice ID");
		invoiceIDCol.setCellValueFactory(new PropertyValueFactory<>("invoiceID"));

		TableColumn<OrderLine, Float> priceCol = new TableColumn<>("Price");
		priceCol.setCellValueFactory(new PropertyValueFactory<>("price"));

		table.getColumns().addAll(orderNumCol, productIDCol, invoiceIDCol, priceCol);
	}

	private void setupEmployeeSoldItemTable(TableView<EmployeeSoldItem> table) {
		TableColumn<EmployeeSoldItem, Integer> productIDCol = new TableColumn<>("Product ID");
		productIDCol.setCellValueFactory(new PropertyValueFactory<>("productID"));

		TableColumn<EmployeeSoldItem, String> categoryCol = new TableColumn<>("Category");
		categoryCol.setCellValueFactory(new PropertyValueFactory<>("category"));

		TableColumn<EmployeeSoldItem, Integer> empIdCol = new TableColumn<>("Employee ID");
		empIdCol.setCellValueFactory(new PropertyValueFactory<>("empId"));

		TableColumn<EmployeeSoldItem, Float> priceCol = new TableColumn<>("Price");
		priceCol.setCellValueFactory(new PropertyValueFactory<>("price"));

		table.getColumns().addAll(productIDCol, categoryCol, empIdCol, priceCol);
	}

	public void setupModelSupplierTable(TableView<ModelSupplier> table, ObservableList<ModelSupplier> data) {
		TableColumn<ModelSupplier, Integer> itemIdCol = new TableColumn<>("ItemID");
		itemIdCol.setCellValueFactory(new PropertyValueFactory<>("itemId"));

		TableColumn<ModelSupplier, String> modelTypeCol = new TableColumn<>("Model Type");
		modelTypeCol.setCellValueFactory(new PropertyValueFactory<>("modelType"));

		TableColumn<ModelSupplier, Integer> supplierIdCol = new TableColumn<>("Supplier ID");
		supplierIdCol.setCellValueFactory(new PropertyValueFactory<>("supplierID"));

		TableColumn<ModelSupplier, String> supplierNameCol = new TableColumn<>("Supplier Name");
		supplierNameCol.setCellValueFactory(new PropertyValueFactory<>("supplierName"));

		table.getColumns().addAll(itemIdCol, supplierIdCol, modelTypeCol, supplierNameCol);
		table.setItems(data);
	}

	public static void getCustomerFromDb() {
		try (Connection con = connection.getConnection()) {
			// Creating a statement
			Statement statement = con.createStatement();

			// Executing the SQL query
			ResultSet resultSet = statement.executeQuery("SELECT * FROM Customer");

			// Processing the result set

			while (resultSet.next()) {
				System.out.println(resultSet.getInt(1) + " " + resultSet.getString(2) + " " + resultSet.getString(3)
						+ " " + resultSet.getString(4) + " " + resultSet.getString(5));
				customerObservableList.add(new Customer(resultSet.getInt(1), resultSet.getString(2),
						resultSet.getString(3), resultSet.getString(4), resultSet.getString(5)));
			}

			// Closing the connection (try-with-resources will handle this)
		} catch (SQLException e) {
			// Handle any SQL-related exceptions
			e.printStackTrace();
		} catch (Exception e) {
			// Handle other exceptions
			e.printStackTrace();
		}
	}

	public static void getIIFromDb() {
		try (Connection con = connection.getConnection()) {
			// Creating a statement
			Statement statement = con.createStatement();

			// Executing the SQL query
			ResultSet resultSet = statement.executeQuery("SELECT * FROM inventoryitems");

			// Processing the result set

			while (resultSet.next()) {
				System.out.println(resultSet.getInt(1) + " " + resultSet.getString(2) + " " + resultSet.getFloat(3)
						+ " " + resultSet.getInt(4));

				InventoryItemsList.add(new InventoryItems(resultSet.getInt(1), resultSet.getString(2),
						resultSet.getFloat(3), resultSet.getInt(4)));

			}

			// Closing the connection (try-with-resources will handle this)
		} catch (SQLException e) {
			// Handle any SQL-related exceptions
			e.printStackTrace();
		} catch (Exception e) {
			// Handle other exceptions
			e.printStackTrace();
		}
	}

	public static void getOrderFromDb() {
		try (Connection con = connection.getConnection()) {
			// Creating a statement
			Statement statement = con.createStatement();

			// Executing the SQL query
			ResultSet resultSet = statement.executeQuery("SELECT * FROM order1");

			// Processing the result set

			while (resultSet.next()) {
//                    System.out.println(resultSet.getInt(1) + " " + resultSet.getInt(2) + " " + resultSet.getInt(3)+ " "  + resultSet.getDate(4)+""+resultSet.getFloat(5)+""+ resultSet.getString(6));
//                    INSERT INTO order1 (OrderNum,  CustomerID, OrderDate, OrderSum, ShipCode, empId)
				LocalDate date = resultSet.getDate(3).toLocalDate();

//                    Order(int orderNum, String shipCode, int customerID, LocalDate orderDate,  float orderSum) {
				int orderNum = resultSet.getInt(1);
				int CustomerID = resultSet.getInt(2);
				float orderSum = resultSet.getFloat(4);
				String Shipcode = resultSet.getString(5);
				int EmpId = resultSet.getInt(6);

				orderList.add(new Order(orderNum, Shipcode, CustomerID, date, orderSum, EmpId));

//                    orderTable.setItems(orderList);

			}

			// Closing the connection (try-with-resources will handle this)
		} catch (SQLException e) {
			// Handle any SQL-related exceptions
			e.printStackTrace();
		} catch (Exception e) {
			// Handle other exceptions
			e.printStackTrace();
		}
	}

	public static void getFinanceFromDb() {

		try (Connection con = connection.getConnection()) {
			// Creating a statement
			Statement statement = con.createStatement();

			// Executing the SQL query
			ResultSet resultSet = statement.executeQuery("SELECT * FROM finance");

			// Processing the result set

			while (resultSet.next()) {
// finance (invoiceID,  InvoiceSum, InvoiceBills, InvoiceStatus, InvoiceDate)                  
				int invoiceID = resultSet.getInt(1);
				float invoicesum = resultSet.getFloat(2);
				float invoicebills = resultSet.getFloat(3);
				String Status = resultSet.getString(4);
				LocalDate date = resultSet.getDate(5).toLocalDate();

				financelist.add(new Finance(invoiceID, invoicesum, invoicebills, Status, date));

//                    orderTable.setItems(orderList);

			}

			// Closing the connection (try-with-resources will handle this)
		} catch (SQLException e) {
			// Handle any SQL-related exceptions
			e.printStackTrace();
		} catch (Exception e) {
			// Handle other exceptions
			e.printStackTrace();
		}
	}

	public static void getShipmentFromDb() {

		try (Connection con = connection.getConnection()) {
			// Creating a statement
			Statement statement = con.createStatement();

			// Executing the SQL query
			ResultSet resultSet = statement.executeQuery("SELECT * FROM shipment");

			// Processing the result set

			while (resultSet.next()) {
				// shipment (ShipmentCode, OrderNum, ShipmentDate, ShipmentStatus, ShipmentCost)
				String shipcode = resultSet.getString(1);
				int ordernum = resultSet.getInt(2);
				LocalDate date = resultSet.getDate(3).toLocalDate();
				String status = resultSet.getString(4);
				float ShipCost = resultSet.getFloat(5);

				System.out.println(shipcode + " " + ordernum + " " + date + " " + status + " " + ShipCost);

				ShipList.add(new Shipment(shipcode, ordernum, date, status, ShipCost));

			}

			// Closing the connection (try-with-resources will handle this)
		} catch (SQLException e) {
			// Handle any SQL-related exceptions
			e.printStackTrace();
		} catch (Exception e) {
			// Handle other exceptions
			e.printStackTrace();
		}
	}

	public static void getManufactingFromDb() {
		try (Connection con = connection.getConnection()) {
			// Creating a statement
			Statement statement = con.createStatement();

			// Executing the SQL query
			ResultSet resultSet = statement.executeQuery("SELECT * FROM Manufacturing");

			// Processing the result set

			while (resultSet.next()) {

				LocalDate date = resultSet.getDate(4).toLocalDate();

				int productID = resultSet.getInt(1);
				String category = resultSet.getString(2);
				float Price = resultSet.getFloat(3);
				int itemsneeded = resultSet.getInt(5);

				System.out.println(productID + " " + category + " " + Price + " " + itemsneeded);

				ManufacturingList.add(new Manufacturing(productID, category, Price, date, itemsneeded));

			}

			// Closing the connection (try-with-resources will handle this)
		} catch (SQLException e) {
			// Handle any SQL-related exceptions
			e.printStackTrace();
		} catch (Exception e) {
			// Handle other exceptions
			e.printStackTrace();
		}

	}

	public static void getEmployeeFromDb() {
		try (Connection con = connection.getConnection()) {
			// Creating a statement
			Statement statement = con.createStatement();

			// Executing the SQL query
			ResultSet resultSet = statement.executeQuery("SELECT * FROM employee");

			// Processing the result set

			while (resultSet.next()) {
//               employee (EmployeeID, EmpName, Email, Role, Password, Username)

				int Empid = resultSet.getInt(1);
				String empname = resultSet.getString(2);
				String Email = resultSet.getString(3);
				String Role = resultSet.getString(4);
				float salary = resultSet.getFloat(7);
				String username = resultSet.getString(5);
				String password = resultSet.getString(6);
				System.out.println(Empid + " " + empname + " " + Email + " " + salary);

				EmployeeList.add(new Employee(Empid, empname, Email, Role, salary, username, password));

			}

			// Closing the connection (try-with-resources will handle this)
		} catch (SQLException e) {
			// Handle any SQL-related exceptions
			e.printStackTrace();
		} catch (Exception e) {
			// Handle other exceptions
			e.printStackTrace();
		}
	}

	public static void getSupplierFromDb() {
		try (Connection con = connection.getConnection()) {
			// Creating a statement
			Statement statement = con.createStatement();

			// Executing the SQL query
			ResultSet resultSet = statement.executeQuery("SELECT * FROM Suplier");

			// Processing the result set

			while (resultSet.next()) {
//        	  Suplier (SuplierID, SuplierName, SupplyDate)

				int SuplierID = resultSet.getInt(1);
				String SuplierName = resultSet.getString(2);
				LocalDate SupplyDate = resultSet.getDate(3).toLocalDate();

				System.out.println(SuplierID + " " + SuplierName + " " + SupplyDate);

				SupplierList.add(new Supplier(SuplierID, SuplierName, SupplyDate));

			}

			// Closing the connection (try-with-resources will handle this)
		} catch (SQLException e) {
			// Handle any SQL-related exceptions
			e.printStackTrace();
		} catch (Exception e) {
			// Handle other exceptions
			e.printStackTrace();
		}
	}

	public static void getSoldItemsFromDb() {

		try (Connection con = connection.getConnection()) {
			// Creating a statement
			Statement statement = con.createStatement();

			String Query = "SELECT * FROM SoldItems";
			System.out.println(Query);
			// Executing the SQL query
			ResultSet resultSet = statement.executeQuery(Query);

			// Processing the result set

			while (resultSet.next()) {
//        	 SoldItems (productID, category, price, SoldDate)

				int productID = resultSet.getInt(1);
				String category = resultSet.getString(2);
				float price = resultSet.getFloat(3);
				LocalDate SoldDate = resultSet.getDate(4).toLocalDate();

				System.out.println(productID + " " + category + " " + price + " " + SoldDate);

				SoldItemslist.add(new SoldItems(productID, category, price, SoldDate));

			}

			// Closing the connection (try-with-resources will handle this)
		} catch (SQLException e) {
			// Handle any SQL-related exceptions
			e.printStackTrace();
		} catch (Exception e) {
			// Handle other exceptions
			e.printStackTrace();
		}

	}

	public void GetEmployeewhosoldItem() {
		try (Connection con = connection.getConnection()) {
			// Creating a statement
			Statement statement = con.createStatement();

			String Query = "SELECT si.productID, si.category, o1.empId,  ol.price FROM     SoldItems si JOIN     Manufacturing m ON si.productID = m.ProductID JOIN orderline ol ON m.ProductID = ol.productID JOIN     order1 o1 ON ol.OrderNum = o1.OrderNum JOIN  employee e ON o1.empId = e.EmployeeID;";
			System.out.println(Query);
			// Executing the SQL query
			ResultSet resultSet = statement.executeQuery(Query);

			// Processing the result set

			ObservableList<EmployeeSoldItem> data = FXCollections.observableArrayList();
			while (resultSet.next()) {
				int productID = resultSet.getInt(1);
				String category = resultSet.getString(2);
				int empId = resultSet.getInt(3);
				float price = resultSet.getFloat(4);

				data.add(new EmployeeSoldItem(productID, category, empId, price));
			}

			TableView<EmployeeSoldItem> tableView = new TableView<>();
			setupEmployeeSoldItemTable(tableView);
			tableView.setItems(data);

			VBox vbox = new VBox(10);
			vbox.getChildren().addAll(tableView);
			Stage stage = new Stage();
			Scene scene = new Scene(vbox, 700, 300);
			scene.getStylesheets().add(getClass().getResource("styles.css").toExternalForm());
			stage.setScene(scene);
			stage.setTitle("Employee Who Sold Item");
			stage.show();

			// Closing the connection (try-with-resources will handle this)
		} catch (SQLException e) {
			// Handle any SQL-related exceptions
			e.printStackTrace();
		} catch (Exception e) {
			// Handle other exceptions
			e.printStackTrace();
		}

	}

	public void getCostomerWhoBoughtItemfrom2023() {
		TableView<CustomerPurchase> tableView = new TableView<>();
		setupCustomerPurchaseTable(tableView);
		ObservableList<CustomerPurchase> data = FXCollections.observableArrayList();
		Label lbResult = new Label();
		Label IDlbl = new Label("Product ID To search ");
		TextField tF = new TextField();
		HBox hb1 = new HBox();
		HBox hb2 = new HBox();
		Button Ok = new Button("OK ");

		Stage adding = new Stage();
		VBox vbox = new VBox(10);
		vbox.setAlignment(Pos.CENTER);
		Scene pane = new Scene(vbox, 400, 150);
		lbResult.setText("");
		tF.clear();
		hb1.getChildren().clear();
		hb1.getChildren().addAll(IDlbl, tF);
		hb1.setAlignment(Pos.CENTER);
		hb2.getChildren().clear();
		hb2.getChildren().addAll(Ok, lbResult);
		hb2.setAlignment(Pos.CENTER);

		vbox.getChildren().clear();// clears the gui and inserts new records
		vbox.getChildren().addAll(hb1, hb2);

		vbox.setAlignment(Pos.CENTER);

		Ok.setOnAction(e -> {

			try {

				int ProductID = Integer.parseInt(tF.getText());

				try (Connection con = connection.getConnection()) {
					// Creating a statement
					Statement statement = con.createStatement();

					int PIDTOsearch = ProductID;

					String Query = "SELECT c.CustomerID, m.category,  o.OrderNum, ol.productID, ol.Price, o.OrderDate FROM customer c INNER JOIN order1 o ON c.CustomerID = o.CustomerID INNER JOIN orderline ol ON o.OrderNum = ol.OrderNum INNER JOIN Manufacturing m ON ol.productID = m.ProductID WHERE YEAR(o.OrderDate) >= 2023 AND m.ProductID = '"
							+ PIDTOsearch + "' ;";
					System.out.println(Query);
					// Executing the SQL query
					ResultSet resultSet = statement.executeQuery(Query);

					while (resultSet.next()) {
//				        	 SoldItems (productID, category, price, SoldDate)

						int customerID = resultSet.getInt(1);
						String category = resultSet.getString(2);
						int OrderNum = resultSet.getInt(3);
						int productID = resultSet.getInt(4);
						float price = resultSet.getFloat(5);
						LocalDate date = resultSet.getDate(6).toLocalDate();

						data.add(new CustomerPurchase(customerID, category, OrderNum, productID, price, date));

//				               System.out.println(productID+ " "+ category + " "+EmpId+ " "+  price );

						// Create a TextArea

					}

					tableView.setItems(data);
				} catch (SQLException ex) {
					// Handle any SQL-related exceptions

				}

				adding.close();

			} catch (NumberFormatException ex) {
				lbResult.setText("Invalid input. Please enter valid numeric values.");

			}

			VBox vbox2 = new VBox(10);
			vbox2.getChildren().addAll(tableView);
			Stage stage = new Stage();
			Scene sceneSmol = new Scene(vbox2, 700, 300);
			sceneSmol.getStylesheets().add(getClass().getResource("styles.css").toExternalForm());
			stage.setScene(sceneSmol);
			stage.setTitle("Employee Who Sold Item");
			stage.show();
		});

		adding.setScene(pane);
		pane.getStylesheets().add(getClass().getResource("styles.css").toExternalForm());
		adding.setTitle("searchRecordCustomer");
		adding.show();

		// Closing the connection (try-with-resources will handle this)

	}

	public void GetOrderLine() {
		try (Connection con = connection.getConnection()) {
			// Creating a statement
			Statement statement = con.createStatement();

			String Query = "Select * from orderline";
			System.out.println(Query);
			// Executing the SQL query
			ResultSet resultSet = statement.executeQuery(Query);

			// Processing the result set

//        	 orderline (OrderNum, productID, invoiceID, Price)

			ObservableList<OrderLine> data = FXCollections.observableArrayList();
			while (resultSet.next()) {
				int orderNum = resultSet.getInt(1);
				int productID = resultSet.getInt(2);
				int invoiceID = resultSet.getInt(3);
				float price = resultSet.getFloat(4);

				data.add(new OrderLine(orderNum, productID, invoiceID, price));
			}
//              EmployeeList.get(EmpId);

			// Create a TextArea

//               LocalDate date =orderList.get(OrderNum).getOrderDate();
//               String Category = ManufacturingList.get(productID).getCategory();
//              String status =financelist.get(invoiceID).getInvoiceStatus();
//               TA.appendText("at "+date+ " the product "+ Category+" has the price of "+ price + " with the invioce status " + status);
//             
			TableView<OrderLine> tableView = new TableView<>();
			setupOrderLineTable(tableView);
			tableView.setItems(data);

			VBox vbox = new VBox(10);
			vbox.getChildren().addAll(tableView);
			Stage stage = new Stage();
			Scene scene = new Scene(vbox, 700, 300);
			scene.getStylesheets().add(getClass().getResource("styles.css").toExternalForm());
			stage.setScene(scene);
			stage.setTitle("Employee Who Sold Item");
			stage.show();

			// Closing the connection (try-with-resources will handle this)
		} catch (SQLException e) {
			// Handle any SQL-related exceptions
			e.printStackTrace();
		} catch (Exception e) {
			// Handle other exceptions
			e.printStackTrace();
		}

	}

	public void ModelSuplier() {

		try (Connection con = connection.getConnection()) {
			// Creating a statement
			Statement statement = con.createStatement();

			String Query = "SELECT ii.ItemID, ii.ModelType, ii.SuplierID, s.SuplierName FROM inventoryitems ii INNER JOIN Suplier s ON ii.SuplierID = s.SuplierID;";
			System.out.println(Query);
			// Executing the SQL query
			ResultSet resultSet = statement.executeQuery(Query);

			// Processing the result set

//             orderline (OrderNum, productID, invoiceID, Price)

			ObservableList<ModelSupplier> data = FXCollections.observableArrayList();
			while (resultSet.next()) {
				int ItemID = resultSet.getInt(1);
				String ModelType = resultSet.getString(2);
				int SupplierID = resultSet.getInt(3);
				String SupplierName = resultSet.getString(4);

				data.add(new ModelSupplier(ItemID, SupplierID, ModelType, SupplierName));
			}

			TableView<ModelSupplier> tableView = new TableView<>();

			setupModelSupplierTable(tableView, data);
			VBox vbox = new VBox(10);
			vbox.getChildren().addAll(tableView);
			Stage stage = new Stage();
			Scene scene = new Scene(vbox, 700, 300);
			scene.getStylesheets().add(getClass().getResource("styles.css").toExternalForm());
			stage.setScene(scene);
			stage.setTitle("Model From Supplier ");
			stage.show();

			// Closing the connection (try-with-resources will handle this)
		} catch (SQLException e) {
			// Handle any SQL-related exceptions
			e.printStackTrace();
		} catch (Exception e) {
			// Handle other exceptions
			e.printStackTrace();
		}
	}

}
