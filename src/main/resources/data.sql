-- Sample Members
INSERT INTO MEMBER (NAME, EMAIL, MEMBERSHIP_DATE) VALUES
                                                      ('Alice Carter',  'alice@example.com',  DATE '2024-01-15'),
                                                      ('Ben Novak',     'ben@example.com',    DATE '2024-03-02'),
                                                      ('Clara Jensen',  'clara@example.com',  DATE '2024-05-20');

-- Sample Books
INSERT INTO BOOK (TITLE, AUTHOR, ISBN, PUBLISHED_YEAR) VALUES
                                                           ('Clean Code',                 'Robert C. Martin',  '9780132350884', 2008),
                                                           ('Effective Java',             'Joshua Bloch',      '9780134685991', 2018),
                                                           ('Spring in Action',           'Craig Walls',       '9781617294945', 2018),
                                                           ('Domain-Driven Design',       'Eric Evans',        '9780321125217', 2003),
                                                           ('Head First Design Patterns', 'Eric Freeman',      '9780596007126', 2004);

-- Sample Loans
-- Alice borrows "Clean Code" and returns it
INSERT INTO LOAN (BOOK_ID, MEMBER_ID, LOAN_DATE, RETURN_DATE)
VALUES (1, 1, DATE '2025-09-01', DATE '2025-09-07');

-- Ben borrows "Effective Java" (still active)
INSERT INTO LOAN (BOOK_ID, MEMBER_ID, LOAN_DATE, RETURN_DATE)
VALUES (2, 2, DATE '2025-09-05', NULL);

-- Clara borrows "Spring in Action" and returns it
INSERT INTO LOAN (BOOK_ID, MEMBER_ID, LOAN_DATE, RETURN_DATE)
VALUES (3, 3, DATE '2025-09-02', DATE '2025-09-10');

-- Alice borrows "Head First Design Patterns" (active)
INSERT INTO LOAN (BOOK_ID, MEMBER_ID, LOAN_DATE, RETURN_DATE)
VALUES (5, 1, DATE '2025-09-12', NULL);
