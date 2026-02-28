-- Authors Table
CREATE TABLE Authors (
    author_id INT PRIMARY KEY,
    author_name VARCHAR(100) NOT NULL,
    state VARCHAR(50)
);

-- Genres Table
CREATE TABLE Genres (
    genre_id INT PRIMARY KEY,
    genre_name VARCHAR(50) NOT NULL UNIQUE
);

-- Users Table
CREATE TABLE Users (
    user_id INT PRIMARY KEY,
    user_name VARCHAR(100) NOT NULL,
    phno VARCHAR(15),
    email VARCHAR(100) UNIQUE
);

-- Books Table
CREATE TABLE Books (
    book_id INT PRIMARY KEY,
    title VARCHAR(200) NOT NULL,
    author_id INT NOT NULL,
    genre_id INT NOT NULL,

    CONSTRAINT fk_author
        FOREIGN KEY (author_id)
        REFERENCES Authors(author_id)
        ON DELETE CASCADE,

    CONSTRAINT fk_genre
        FOREIGN KEY (genre_id)
        REFERENCES Genres(genre_id)
        ON DELETE CASCADE
);

-- Loans Table
CREATE TABLE Loans (
    loan_id INT PRIMARY KEY,
    user_id INT NOT NULL,
    book_id INT NOT NULL,
    borrowed_date DATE NOT NULL DEFAULT CURRENT_DATE,
    returned_date DATE,

    CONSTRAINT fk_user
        FOREIGN KEY (user_id)
        REFERENCES Users(user_id)
        ON DELETE CASCADE,

    CONSTRAINT fk_book
        FOREIGN KEY (book_id)
        REFERENCES Books(book_id)
        ON DELETE CASCADE
);

INSERT INTO Authors VALUES
(1, 'J.K. Rowling', 'UK'),
(2, 'George R.R. Martin', 'USA'),
(3, 'Chetan Bhagat', 'India'),
(4, 'Agatha Christie', 'UK'),
(5, 'Dan Brown', 'USA'),
(6, 'Paulo Coelho', 'Brazil'),
(7, 'Stephen King', 'USA'),
(8, 'Ruskin Bond', 'India'),
(9, 'Jane Austen', 'UK'),      -- No books
(10, 'R.K. Narayan', 'India'); -- No books

INSERT INTO Genres VALUES
(1, 'Fantasy'),
(2, 'Fiction'),
(3, 'Mystery'),
(4, 'Thriller'),
(5, 'Romance'),
(6, 'Horror'),
(7, 'Adventure'),
(8, 'Drama'),
(9, 'Biography'),
(10, 'Science Fiction');


INSERT INTO Users VALUES
(1, 'Rahul Sharma', '9876543210', 'rahul@gmail.com'),
(2, 'Anita Verma', '9876501234', 'anita@gmail.com'),
(3, 'Karan Mehta', '9123456780', 'karan@gmail.com'),
(4, 'Sneha Patel', '9988776655', 'sneha@gmail.com'),
(5, 'Amit Singh', '9090909090', 'amit@gmail.com'),
(6, 'Neha Gupta', '8888888888', 'neha@gmail.com'),
(7, 'Rohit Jain', '7777777777', 'rohit@gmail.com'),
(8, 'Priya Kapoor', '6666666666', 'priya@gmail.com'),
(9, 'Arjun Das', '9555555555', 'arjun@gmail.com'),   -- No loans
(10, 'Meera Iyer', '9444444444', 'meera@gmail.com'); -- No loans

INSERT INTO Books VALUES
(1, 'Harry Potter 1', 1, 1),
(2, 'Harry Potter 2', 1, 1),
(3, 'Game of Thrones', 2, 1),
(4, 'Clash of Kings', 2, 1),
(5, 'The Alchemist', 6, 2),
(6, 'The Shining', 7, 6),
(7, 'Murder on the Orient Express', 4, 3),
(8, 'Da Vinci Code', 5, 4),
(9, '2 States', 3, 5),
(10, 'It', 7, 6);

INSERT INTO Loans VALUES
(1, 1, 1, '2026-01-01', '2026-01-10'),
(2, 1, 2, '2026-01-15', NULL),
(3, 2, 3, '2026-01-05', '2026-01-12'),
(4, 2, 4, '2026-01-20', NULL),
(5, 3, 5, '2026-01-03', '2026-01-09'),
(6, 3, 6, '2026-01-25', NULL),
(7, 4, 7, '2026-01-07', '2026-01-14'),
(8, 5, 8, '2026-01-11', NULL),
(9, 6, 9, '2026-01-02', '2026-01-08'),
(10, 7, 10, '2026-01-18', NULL);

-- WAQTD no of books borrowed by each user with user name.
SELECT u.user_name, COUNT(l.book_id) AS total_books_borrowed
FROM users u
INNER JOIN loans l 
    ON u.user_id = l.user_id
INNER JOIN books b 
    ON b.book_id = l.book_id
GROUP BY u.user_name;

-- WAQTD title of the book and the authors name from the books and authors table
SELECT b.title, a.author_name
FROM books b
INNER JOIN authors a
On a.author_id = b.author_id;

-- WAQTD books titles and their genres , filtering by the genre "Science Fiction"?
SELECT b.title, g.genre_name
FROM books b
INNER JOIN genres g
ON b.genre_id = g.genre_id
WHERE g.genre_name = 'Science Fiction';

