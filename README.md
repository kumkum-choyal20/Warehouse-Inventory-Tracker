#  Warehouse Event-Based Inventory Tracker<br>

A **Java-based event-driven inventory tracking system** that simulates warehouse operations such as product management, shipment receipt, and order fulfillment — while automatically triggering alerts when stock levels fall below predefined thresholds.

---
## Table of Contents
- <a href="#overview">Overview</a>
- <a href="#tools--technologies">Tools & Technologies</a>
- <a href="#project-structure">Project Structure</a>
- <a href="#file-descriptions">File Descriptions</a>
- <a href="#example-workflow">Example Workflow</a>
- <a href="#author--contact">Author & Contact</a>
---

<h2><a class="anchor" id="overview"></a>Overview</h2><br>
The **Warehouse Event-Based Inventory Tracker** is a Java application designed to manage a warehouse’s inventory using **event-driven principles** and the **Observer Design Pattern**.  

It demonstrates core **Object-Oriented Programming (OOP)** principles such as **Encapsulation, Abstraction, and Loose Coupling**, while efficiently tracking product quantities and generating automatic “Restock Alerts” when levels drop below thresholds.

###  Key Features <br>
- Add and manage products dynamically.<br>
- Receive shipments (increase stock).<br>
- Fulfill customer orders (decrease stock).<br>
- Automatically trigger **low-stock alerts**.<br>
- Handle invalid product IDs and insufficient stock gracefully.<br>
- Optional: Persist data to a text file between runs.<br>
- (Bonus) Support multithreading and multiple warehouses.<br>

---

<h2><a class="anchor" id="tools--technologies"></a> Tools & Technologies</h2><br>
| Category | Tools / Technologies Used |<br>
|-----------|----------------------------|<br>
| **Programming Language** | Java (JDK 8+) |<br>
| **Design Pattern** | Observer Pattern |<br>
| **Data Structures** | HashMap, List |<br>
| **Concepts Used** | OOP (Encapsulation, Abstraction, Inheritance, Polymorphism) |<br>
| **File Handling** | Java I/O for optional persistence |<br>
| **Version Control** | Git, GitHub |<br>
| **IDE (Recommended)** | IntelliJ IDEA / Eclipse / VS Code (Java Extension Pack) |<br>

---

<h2><a class="anchor" id="project-structure"></a>Project Structure</h2><br>
warehouse-event-tracker/<br>
│
├── src/<br>
│ └── com/warehouse/<br>
│ ├── model/<br>
│ │ └── Product.java # Defines the Product class<br>
│ │<br>
│ ├── observer/<br>
│ │ ├── StockObserver.java # Observer interface for stock alerts<br>
│ │ └── AlertService.java # Concrete observer that prints alerts<br>
│ │<br>
│ ├── service/<br>
│ │ └── Warehouse.java # Core warehouse logic (add, receive, fulfill)<br>
│ │<br>
│ └── Main.java # Main driver program<br>
│<br>
└── inventory.txt # (Optional) File persistence for inventory state<br>

---

<h2><a class="anchor" id="file-descriptions"></a> File Descriptions</h2><br>
| File | Description |<br>
|------|--------------|<br>
| **Product.java** | Represents individual products (ID, name, quantity, threshold). |<br>
| **Warehouse.java** | Manages stock updates and triggers alerts. |<br>
| **StockObserver.java** | Interface defining the alert mechanism. |<br>
| **AlertService.java** | Implementation of the observer for restock notifications. |<br>
| **Main.java** | Entry point for the application demonstrating workflow. |<br>
| **inventory.txt** | Optional storage file for saving product data between runs. |<br>

---


<h2><a class="anchor" id="example-workflow"></a> Example Workflow</h2><br>
1. Add new product: `Laptop` with reorder threshold = 5<br>  
2. Receive shipment of 10 units → Total stock = 10  <br>
3. Fulfill 6 orders → Remaining = 4  <br>
4. System automatically triggers alert: <br> 


  

<h2><a class="anchor" id="author--contact"></a>Author & Contact</h2><br>

**Author:** [Kumkum Choyal]<br>
**Project:** Warehouse Event-Based Inventory Tracker <br> 
**Email:** [Kumkumchoyal@gmail.com]  <br>
**GitHub:** [GittHub](https://github.com/kumkum-choyal20)  <br>
**LinkedIn:** [LinkedIn](https://linkedin.com/in/kumkumchoyal-5662572a4) <br>

---
