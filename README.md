Create database websiteRatingDb;
use websiteRatingDb;
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


CREATE TABLE website (
    WebsiteId INT PRIMARY KEY AUTO_INCREMENT,
    url VARCHAR(255) NOT NULL,
    addedDate DATE,
    companyName VARCHAR(100)
);

INSERT INTO user
(UserID, FirstName, LastName, MobileNumber, Email, Password, Gender, DateOfBirth, Address)
VALUES
(1,'Rishav', 'Saw', '9508320681', 'qwerty@gmail.com', 'qwerty', 'Male', '2002-07-09', 'JP Nagar');

INSERT INTO user
(UserID, FirstName, LastName, MobileNumber, Email, Password, Gender, DateOfBirth, Address)
VALUES
(2,'Abhi', 'Sahu', '7319858135', 'abhi@gmail.com', 'abhi', 'Male', '2000-10-08', 'London');
