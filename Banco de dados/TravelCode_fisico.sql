CREATE DATABASE travelcode;

USE travelcode;

CREATE TABLE Contato (
ID_Contato INTEGER PRIMARY KEY,
Mensagem TEXT,
Email VARCHAR(100),
Nome VARCHAR(100)
);

CREATE TABLE Promocao (
ID_Promocao INTEGER PRIMARY KEY,
Detalhes_Promocao TEXT,
Data_Inicio DATE,
Data_Fim DATE
);

CREATE TABLE Destino (
ID_Destino INTEGER PRIMARY KEY,
Nome_Destino VARCHAR(100),
Descricao TEXT,
ID_Promocao INTEGER,
FOREIGN KEY(ID_Promocao) REFERENCES Promocao(ID_Promocao)
);

CREATE TABLE RecebeContato (
ID_RecebeContato INTEGER AUTO_INCREMENT PRIMARY KEY,
ID_Contato INTEGER,
ID_Destino INTEGER,
FOREIGN KEY(ID_Contato) REFERENCES Contato(ID_Contato),
FOREIGN KEY(ID_Destino) REFERENCES Destino(ID_Destino)
);

-- Inserir dados Contato
INSERT INTO Contato (ID_Contato, Mensagem, Email, Nome)
VALUES (1, 'Olá, gostaria de saber mais sobre os destinos disponíveis.', 'cliente@email.com', 'Cliente');

-- Inserir dados Promocao
INSERT INTO Promocao (ID_Promocao, Detalhes_Promocao, Data_Inicio, Data_Fim) 
VALUES (1, 'Detalhes da Promoção 1', '2023-01-01', '2023-12-31');

-- Inserir dados Destino
INSERT INTO Destino (ID_Destino, Nome_Destino, Descricao, ID_Promocao) 
VALUES (1, 'Capadócia', 'A Capadócia é famosa por suas paisagens lunares únicas, cidades subterrâneas antigas e igrejas esculpidas em rochas. Não se esqueça de mencionar os passeios de balão de ar quente ao amanhecer que são uma das principais atrações.', 1),
       (2, 'Japão', 'O Japão oferece uma mistura fascinante de tradição e modernidade. De templos históricos e belos jardins de cerejeiras a arranha-céus futuristas e tecnologia avançada, há algo para todos.', 1),
       (3, 'Canadá', 'Conhecido por sua natureza deslumbrante, incluindo montanhas majestosas, florestas densas e lagos cristalinos. As cidades do Canadá também são vibrantes e acolhedoras, com uma rica cultura e história.', 1),
       (4, 'São Francisco', 'Esta cidade costeira da Califórnia é famosa pela Ponte Golden Gate, os bondinhos históricos e a vibrante Chinatown. São Francisco também é conhecida por sua cena culinária diversificada e inovadora.', 1);

-- Inserir dados RecebeContato
INSERT INTO RecebeContato (ID_Contato, ID_Destino) 
VALUES (1, 1), (1, 2), (1, 3), (1, 4);

-- Consultar todas as tabelas
SELECT * FROM Contato;
SELECT * FROM Destino;
SELECT * FROM Promocao;
SELECT * FROM RecebeContato;
