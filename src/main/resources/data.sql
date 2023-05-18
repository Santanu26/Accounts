DROP TABLE IF EXISTS customer;
DROP TABLE IF EXISTS account;

CREATE TABLE customer (
  customer_id INT PRIMARY KEY AUTO_INCREMENT,
  name VARCHAR(255) NOT NULL,
  email VARCHAR(255),
  mobile_number VARCHAR(255) NOT NULL,
  create_dt DATE
);

CREATE TABLE account (
  account_number BIGINT PRIMARY KEY,
  customer_id INT NOT NULL,
  account_type VARCHAR(255) NOT NULL,
  branch_address VARCHAR(255) NOT NULL,
  create_dt DATE
);

INSERT INTO customer (name, email, mobile_number, create_dt)
VALUES ('John Doe', 'johndoe@example.com', '1234567890', '2023-05-18');

INSERT INTO account (account_number, customer_id, account_type, branch_address, create_dt)
VALUES (1234567890, 1001, 'Savings', '123 Main Street', '2023-05-18');
