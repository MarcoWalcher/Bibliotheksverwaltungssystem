CREATE DATABASE library;

CREATE TABLE Addresses (
    AddressID INT NOT NULL,
    City VARCHAR(255),
    PostalCode VARCHAR(255),
    Street VARCHAR(255),
    BuildingNumber VARCHAR(255),
    Deleted BINARY,
    PRIMARY KEY (AdressID)
);

CREATE TABLE Persons (
    PersonID INT NOT NULL,
    LastName VARCHAR(255),
    FirstName VARCHAR(255),
    AddressID INT NOT NULL,
    eMail VARCHAR(255),
    TelephoneNumber VARCHAR(255),
    Deleted BINARY,
    PRIMARY KEY (PersonID),
    FOREIGN KEY (AdressID)
        REFERENCES Adresses (AdressID)
);

CREATE TABLE Authors (
    AuthorID INT NOT NULL,
    FirstName VARCHAR(255),
    LastName VARCHAR(255),
    Birthdate DATE,
    PlaceOfBirth VARCHAR(255),
    Deleted BINARY,
    PRIMARY KEY (AuthorID)
);

CREATE TABLE Genres (
    GenreID INT NOT NULL,
    GenreName VARCHAR(255),
    GeneralTerm VARCHAR(255),
    Deleted BINARY,
    PRIMARY KEY (GenreID)
);

CREATE TABLE Books (
    BookID INT NOT NULL,
    BookName VARCHAR(255),
    GenreID INT NOT NULL,
    AuthorID INT NOT NULL,
    Summary VARCHAR(255),
    Deleted BINARY,
    PRIMARY KEY (BookID),
    FOREIGN KEY (GenreID)
        REFERENCES Genres (GenreID),
    FOREIGN KEY (AuthorID)
        REFERENCES Authors (AuthorID)
);

CREATE TABLE LoanHistory (
    LoanID INT NOT NULL,
    PersonID INT NOT NULL,
    BookID INT NOT NULL,
    LoanStartDate DATE,
    LoanEndDate DATE,
    ReturnDate DATE,
    PRIMARY KEY (LoanID),
    FOREIGN KEY (PersonID)
        REFERENCES Persons (PersonID),
    FOREIGN KEY (BookID)
        REFERENCES Books (BookID)
);