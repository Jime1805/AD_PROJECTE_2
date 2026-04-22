-- -----------------------------------------------
-- Eliminem les taules en ordre invers per evitar
-- errors de claus foranes
-- -----------------------------------------------
DROP TABLE IF EXISTS user_role;
DROP TABLE IF EXISTS order_item;
DROP TABLE IF EXISTS invoice;
DROP TABLE IF EXISTS `order`;
DROP TABLE IF EXISTS address;
DROP TABLE IF EXISTS customer;
DROP TABLE IF EXISTS `user`;
DROP TABLE IF EXISTS role;
DROP TABLE IF EXISTS producte;

-- -----------------------------------------------
-- Taula: role
-- -----------------------------------------------
CREATE TABLE role (
    id      BIGINT AUTO_INCREMENT PRIMARY KEY,
    name    ENUM('ADMIN', 'USER', 'MANAGER') NOT NULL
);

-- -----------------------------------------------
-- Taula: user
-- -----------------------------------------------
CREATE TABLE `user` (
    id           BIGINT AUTO_INCREMENT PRIMARY KEY,
    email        VARCHAR(100) NOT NULL UNIQUE,
    password     VARCHAR(255) NOT NULL,
    status       BOOLEAN NOT NULL DEFAULT TRUE,
    dataCreated  TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    dataUpdated  TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

-- -----------------------------------------------
-- Taula pivot: user_role (N:M entre user i role)
-- -----------------------------------------------
CREATE TABLE user_role (
    userId  BIGINT NOT NULL,
    roleId  BIGINT NOT NULL,
    PRIMARY KEY (userId, roleId),
    FOREIGN KEY (userId) REFERENCES `user`(id),
    FOREIGN KEY (roleId) REFERENCES role(id)
);

-- -----------------------------------------------
-- Taula: customer (1:1 amb user)
-- -----------------------------------------------
CREATE TABLE customer (
    id           BIGINT AUTO_INCREMENT PRIMARY KEY,
    userId       BIGINT NOT NULL UNIQUE,
    firstName    VARCHAR(50) NOT NULL,
    lastName     VARCHAR(50) NOT NULL,
    phone        VARCHAR(20),
    status       BOOLEAN NOT NULL DEFAULT TRUE,
    dataCreated  TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    dataUpdated  TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    FOREIGN KEY (userId) REFERENCES `user`(id)
);

-- -----------------------------------------------
-- Taula: address (1:N amb customer)
-- -----------------------------------------------
CREATE TABLE address (
    id          BIGINT AUTO_INCREMENT PRIMARY KEY,
    customerId  BIGINT NOT NULL,
    address     VARCHAR(150) NOT NULL,
    city        VARCHAR(50) NOT NULL,
    postalCode  VARCHAR(10) NOT NULL,
    country     VARCHAR(50) NOT NULL,
    isDefault   BOOLEAN NOT NULL DEFAULT FALSE,
    FOREIGN KEY (customerId) REFERENCES customer(id)
);

-- -----------------------------------------------
-- Taula: producte
-- -----------------------------------------------
CREATE TABLE producte (
    id           BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre       VARCHAR(100) NOT NULL,
    descripcion  VARCHAR(255),
    stock        INT NOT NULL DEFAULT 0,
    price        DECIMAL(10, 2) NOT NULL,
    rating       DECIMAL(2, 1),
    `condition`  ENUM('NOU', 'ANTIC', 'POC_USAT', 'MOLT_USAT'),
    status       BOOLEAN NOT NULL DEFAULT TRUE,
    data_created TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    data_updated TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

-- -----------------------------------------------
-- Taula: order (1:N amb customer)
-- -----------------------------------------------
CREATE TABLE `order` (
    id           BIGINT AUTO_INCREMENT PRIMARY KEY,
    customerId   BIGINT NOT NULL,
    orderDate    TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    totalAmount  DECIMAL(10, 2) NOT NULL DEFAULT 0,
    orderStatus  ENUM('PENDENT', 'PROCESSAT', 'CANCELAT') NOT NULL DEFAULT 'PENDENT',
    status       BOOLEAN NOT NULL DEFAULT TRUE,
    dataCreated  TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    dataUpdated  TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    FOREIGN KEY (customerId) REFERENCES customer(id)
);

-- -----------------------------------------------
-- Taula: order_item (1:N amb order, N:1 amb producte)
-- -----------------------------------------------
CREATE TABLE order_item (
    id          BIGINT AUTO_INCREMENT PRIMARY KEY,
    orderId     BIGINT NOT NULL,
    producteId  BIGINT NOT NULL,
    quantity    INT NOT NULL DEFAULT 1,
    untilPrice  DECIMAL(10, 2) NOT NULL,
    FOREIGN KEY (orderId)    REFERENCES `order`(id),
    FOREIGN KEY (producteId) REFERENCES producte(id)
);

-- -----------------------------------------------
-- Taula: invoice (1:1 amb order)
-- -----------------------------------------------
CREATE TABLE invoice (
    id             BIGINT AUTO_INCREMENT PRIMARY KEY,
    orderId        BIGINT NOT NULL UNIQUE,
    invoiceNumber  VARCHAR(50) NOT NULL,
    issueDate      TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    textAmount     DECIMAL(10, 2) NOT NULL DEFAULT 0,
    totalWithTax   DECIMAL(10, 2) NOT NULL DEFAULT 0,
    FOREIGN KEY (orderId) REFERENCES `order`(id)
);

-- -----------------------------------------------
-- Dades inicials: rols (ja han d'existir prèviament
-- segons l'enunciat)
-- -----------------------------------------------
INSERT INTO role (name) VALUES ('ADMIN');
INSERT INTO role (name) VALUES ('USER');
INSERT INTO role (name) VALUES ('MANAGER');