INSERT INTO book (`id`, `author`, `isbn`, `publisher`, `quantity`, `title`, `img`) VALUES
(1, 'Dante Alighieri', '9788800222372', 'Mondadori Education', 10, 'Divina Commedia - Volume unico. Con Me book e Contenuti Digitali Integrativi online', 'https://www.salernoeditrice.it/wp-content/uploads/2018/09/commedia_sito.jpg'),
(2, 'Antoine de Saint-Exupéry', '9788800222373', 'Newton Compton Editori', 5, 'Il Piccolo Principe', 'https://images-na.ssl-images-amazon.com/images/I/71iQfQYj0cL.jpg'),
(4, 'George Orwell', '3548204562', 'Longman', 4, '1984', 'https://pictures.abebooks.com/isbn/9783548204567-it-300.jpg'),
(5, 'Austen, Jane', '8863113831', 'Liberamente', 8, 'Orgoglio e pregiudizio. Ediz. integrale', 'https://pictures.abebooks.com/inventory/md/md30493868008.jpg'),
(6, 'Brontë, Emily', '8883371291', 'Crescere', 6, 'Cime tempestose', 'https://pictures.abebooks.com/isbn/9788883371295-it-300.jpg'),
(7, 'Macchiavelli, Niccolo', '8863113882', 'Liberamente', 1, 'Il principe', 'https://pictures.abebooks.com/inventory/md/md30543412264.jpg'),
(8, 'Rowling, J. K.', '0747558191', 'Bloomsbury Publishing', 12, 'Harry Potter and the Philosophers Stone', 'https://pictures.abebooks.com/isbn/9780747558194-it-300.jpg'),
(9, 'Kant, Immanuel', '8835032059', 'Laterza', 7, 'Critica della ragion pratica', 'https://pictures.abebooks.com/inventory/md/md30946534357.jpg'),
(10, 'Omero', '881801837X', 'Rusconi Libri', 10, 'Iliade', 'https://pictures.abebooks.com/isbn/9788818018370-it-300.jpg'),
(11, 'Virgilio', '2560731040778', 'Sansoni', 0, 'L Eneide', 'https://pictures.abebooks.com/inventory/md/md17145207022.jpg');

INSERT INTO `activetokens` (`tokenid`, `email`, `tk`) VALUES
(95, 'dario.tintore3@gmail.com', 'eyJhbGciOiJub25lIn0.eyJzdWIiOiJkYXJpby50aW50b3JlM0BnbWFpbC5jb20iLCJhdWQiOiJ0b2tlbi1nZW5lcmF0aW9uIiwiMWQyMCI6MTMsImlhdCI6MTY0NjIyOTk1MiwiZXhwIjoxNjQ2MjMwMDEyfQ.'),
(96, 'test@test.it', 'eyJhbGciOiJub25lIn0.eyJzdWIiOiJ0ZXN0QHRlc3QuaXQiLCJhdWQiOiJ0b2tlbi1nZW5lcmF0aW9uIiwiMWQyMCI6MTEsImlhdCI6MTY0NjI0MTA2MywiZXhwIjoxNjQ2MjQxMTIzfQ.'),
(98, 'prova@test.it',  'eyJhbGciOiJub25lIn0.eyJzdWIiOiJwcm92YUB0ZXN0Lml0IiwiYXVkIjoidG9rZW4tZ2VuZXJhdGlvbiIsIjFkMjAiOjIsImlhdCI6MTY0NjI0MTc1NiwiZXhwIjoxNjQ2MjQxODE2fQ.'),
(109, 'test@test.com',  'eyJhbGciOiJub25lIn0.eyJzdWIiOiJ0ZXN0QHRlc3QuY29tIiwiYXVkIjoidG9rZW4tZ2VuZXJhdGlvbiIsIjFkMjAiOjEwLCJpYXQiOjE2NDYyNDQyNjksImV4cCI6MTY0NjI0NDMyOX0.');

INSERT INTO `orders` (`id`, `email`, `isbn`, `quantity`, `date`,`shipped`) VALUES
(13, 'dario.tintore3@gmail.com', '9788800222372', 1, '2022-03-02 11:39:16', false),
(14, 'dario.tintore3@gmail.com', '9788800222372', 1, '2022-03-02 11:48:27', true),
(15, 'dario.tintore3@gmail.com', '9788800222373', 1, '2022-03-02 11:48:38', true),
(16, 'dario.tintore3@gmail.com', '9788800222373', 1, '2022-03-02 15:05:57', true),
(17, 'test@test.com','9788800222373', 1, '2022-03-02 15:05:57', false);

INSERT INTO `users` (`userid`, `email`, `firstname`, `lastname`, `password`) VALUES
(1000, 'dariotintore2@gmail.com', NULL, NULL, '$2a$10$eKZFn0Ja5kCJSYJqAPMNu.eAWhnSWDSJ80aGbk0nC55cURrF4UTTK'),
(1001, 'test@test.com', NULL, NULL, '$2a$10$n4C83jnDebSPjtLS2NGHZeRBFjg9TuhWPjTGgpJ2.EySYDIFNsWAe'),
(1002, 'dario.tintore2@gmail.com', NULL, NULL, '$2a$10$JUwIr8fqIeJ/7XQH1skCLeKL7NwvLqcGDKLebJ/pS7jUScHAgTnHC'),
(1003, 'dario.tintore3@gmail.com', NULL, NULL, '$2a$10$36dGwEvfEOZOTrLnblnkkOtlFAfEJdoYe/UqJXlmwLWsahOy/QjXu'),
(1004, 'test@test.it', NULL, NULL, '$2a$10$G71eMdiSmSiF1uZCCFw18OnjeD1DBPTnswTczX2DSGqN9rJo1jmWm'),
(1005, 'prova@test.it', NULL, NULL, '$2a$10$ex76FDp3CPEvHxjJFWHiMeGwsjUMJRxLFtmLxaf8ABziVNf1jQbjC');
