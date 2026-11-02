<p align="center">
  <h1 align="center">🏦 Banking Calculator</h1>
  <p align="center">
    <strong>Configurable banking-formula service: EMI, fixed-deposit, simple-interest and maturity calculators driven by Velocity templates.</strong>
  </p>
  <p align="center">
    <img src="https://img.shields.io/badge/Java-8-ed8b00?style=for-the-badge&logo=openjdk&logoColor=white" alt="Java">
    <img src="https://img.shields.io/badge/Spring_Boot-2.1-6db33f?style=for-the-badge&logo=springboot&logoColor=white" alt="Spring_Boot">
    <img src="https://img.shields.io/badge/Swagger-2.6-85ea2d?style=for-the-badge&logo=swagger&logoColor=white" alt="Swagger">
    <img src="https://img.shields.io/badge/H2-embedded-09476b?style=for-the-badge" alt="H2">
    <img src="https://img.shields.io/github/last-commit/pratiks360/bankingcalculator?style=for-the-badge&label=Last+Commit" alt="Last Commit">
  </p>
</p>

---

## ✨ What Is This?

**Banking Calculator** stores a product master (products, their input fields and defaults) and evaluates a chosen formula against user-supplied variables. Formulas are plain Velocity templates (`emi.vm`, `fd.vm`, `si.vm`, `maturityamount.vm`), so new calculators need a template and seed rows, not new code.

## 🔌 Endpoints

| Method | Path | Description |
|---|---|---|
| `POST` | `/compute` | Evaluate a formula (`formulaCode` + variables) → text result |
| `GET` | `/bankingcalc-management/all` | List products |
| `GET` | `/bankingcalc-management/product/{id}` | Fetch one product |
| `POST` | `/bankingcalc-management/add` | Add a product |
| `DELETE` | `/bankingcalc-management/delete/{id}` | Delete a product |

Swagger UI is enabled for interactive testing.

## 🧩 How It Works

```
┌────────┐  /compute   ┌────────────────┐  load product   ┌──────────────┐
│ Client │ ──────────► │ ComputeService │ ──────────────► │ H2 (JPA)     │
│        │ ◄────────── │                │ ◄────────────── │ product/field│
└────────┘   result    └───────┬────────┘                 └──────────────┘
                               │ merge variables
                               ▼
                       Velocity template (emi.vm, fd.vm …)
```

## 🚀 Quick Start

**Prerequisites:** JDK 8+, Maven.

```bash
git clone https://github.com/pratiks360/bankingcalculator.git
cd bankingcalculator/bankingcalculator
mvn spring-boot:run
```

Seed data: `product_master.sql`, `field_master.sql`, `default_fields.sql`.

## 🛠️ Tech Stack

| Layer | Technology |
|---|---|
| **Framework** | Spring Boot 2.1.4 (web, data-jpa) |
| **Formulas** | Apache Velocity |
| **Data** | H2 in-memory |
| **Docs** | Springfox Swagger 2.6.1 |

---

<p align="center">
  <sub>Built with ❤️ for fintech tinkering.</sub>
</p>
