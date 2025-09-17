-- members
INSERT INTO member (name, email, membership_date) VALUES
                                                      ('Alice Carter',  'alice@example.com',  DATE '2024-01-15'),
                                                      ('Ben Novak',     'ben@example.com',    DATE '2024-03-02'),
                                                      ('Clara Jensen',  'clara@example.com',  DATE '2024-05-20');

-- books
INSERT INTO book (title, author, isbn, published_year) VALUES
                                                           ('Clean Code',                 'Robert C. Martin',  '9780132350884', 2008),
                                                           ('Effective Java',             'Joshua Bloch',      '9780134685991', 2018),
                                                           ('Spring in Action',           'Craig Walls',       '9781617294945', 2018),
                                                           ('Domain-Driven Design',       'Eric Evans',        '9780321125217', 2003),
                                                           ('Head First Design Patterns', 'Eric Freeman',      '9780596007126', 2004);

-- loans (some active)
INSERT INTO loan (book_id, member_id, loan_date, return_date) VALUES
                                                                  (1, 1, DATE '2025-09-01', DATE '2025-09-07'),
                                                                  (2, 2, DATE '2025-09-05', NULL),
                                                                  (3, 3, DATE '2025-09-02', DATE '2025-09-10'),
                                                                  (5, 1, DATE '2025-09-12', NULL);
