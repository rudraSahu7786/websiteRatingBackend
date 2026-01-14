
# Website Rating Database Schema

This document describes the database schema and initial data setup for the **Website Rating Application**.

---

## Database Creation

```sql
CREATE DATABASE websiteRatingDb;
USE websiteRatingDb;
````

---

## Table: `user`

Stores user profile and authentication details.

### Schema

```sql
CREATE TABLE user (
    UserID INT PRIMARY KEY,
    FirstName VARCHAR(50) NOT NULL,
    LastName VARCHAR(50),
    MobileNumber VARCHAR(15),
    Email VARCHAR(100) UNIQUE NOT NULL,
    Password VARCHAR(255) NOT NULL,
    Gender VARCHAR(10),
    DateOfBirth DATE,
    Address VARCHAR(255),
    CreatedAt TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
```

### Column Description

| Column Name  | Type         | Description            |
| ------------ | ------------ | ---------------------- |
| UserID       | INT (PK)     | Unique user identifier |
| FirstName    | VARCHAR(50)  | User first name        |
| LastName     | VARCHAR(50)  | User last name         |
| MobileNumber | VARCHAR(15)  | Contact number         |
| Email        | VARCHAR(100) | Unique email address   |
| Password     | VARCHAR(255) | Encrypted password     |
| Gender       | VARCHAR(10)  | Gender                 |
| DateOfBirth  | DATE         | DOB                    |
| Address      | VARCHAR(255) | Residential address    |
| CreatedAt    | TIMESTAMP    | Record creation time   |

---

## Table: `website`

Stores websites that can be rated.

### Schema

```sql
CREATE TABLE website (
    WebsiteId INT PRIMARY KEY AUTO_INCREMENT,
    url VARCHAR(255) NOT NULL,
    addedDate DATE,
    companyName VARCHAR(100)
);
```

### Column Description

| Column Name | Type         | Description               |
| ----------- | ------------ | ------------------------- |
| WebsiteId   | INT (PK)     | Auto-generated website ID |
| url         | VARCHAR(255) | Website URL               |
| addedDate   | DATE         | Date added                |
| companyName | VARCHAR(100) | Associated company        |

---

## Sample Data

### Insert Users

```sql
INSERT INTO user (
    UserID, FirstName, LastName, MobileNumber, Email, Password, Gender, DateOfBirth, Address
) VALUES
(1, 'Rishav', 'Saw', '9508320681', 'qwerty@gmail.com', 'qwerty', 'Male', '2002-07-09', 'JP Nagar'),
(2, 'Abhi', 'Sahu', '7319858135', 'abhi@gmail.com', 'abhi', 'Male', '2000-10-08', 'London');
```

---

## Notes

* Passwords should be **hashed** before storing (e.g., BCrypt).
* `Email` field is unique to avoid duplicate accounts.
* `WebsiteId` is auto-incremented for scalability.

---

## Environment

* Database: MySQL / MariaDB
* Charset: UTF-8 recommended

---

## Author

Website Rating Project

```

---

If you want:
- **ER diagram**
- **Foreign key relations (ratings table)**
- **Production-ready schema (indexes, constraints)**

say which one.
```
