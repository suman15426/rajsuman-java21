# Java 21/23 Console-Based Backend Application

##  Overview
This is a console-based backend application built using **Java 21 and Java 23**, designed to demonstrate scalable architecture, multithreading, and modern Java features. It simulates real-world backend workflows such as product recommendation, order dispatch, and inventory sync—optimized for performance and concurrency.

---

##  Features

- **Multithreaded Batch Processing**  
  Parallel dispatch of orders using `ExecutorService` and `CompletableFuture` to improve throughput.

- **Asynchronous Supplier Data Fetching**  
  Non-blocking I/O with concurrency utilities to enhance API responsiveness.

- **Thread-Safe Caching**  
  Reduces redundant DB hits using synchronized access and concurrent collections.

- **Invoice & Inventory Sync Workflows**  
  Concurrent task execution with data consistency guarantees.

- **Structured Concurrency (Java 21)**  
  Clean task scoping using `StructuredTaskScope` for better thread lifecycle management.

- **Virtual Threads (Java 23)**  
  Lightweight concurrency model for scalable I/O-bound operations.

---

## Tech Stack

- **Language:** Java 21 / Java 23  
- **Architecture:** Modular CLI-based backend  
- **Concurrency:** Executors, CompletableFuture, Virtual Threads  
- **I/O:** BufferedReader, Scanner, Java NIO  
- **Build Tool:** Maven  
- **Testing:** JUnit 5  
- **Deployment:** Runnable JAR / Native image (optional)
