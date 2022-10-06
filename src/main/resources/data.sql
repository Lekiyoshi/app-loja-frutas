INSERT INTO empresa (nome, cnpj, responsavel, telefone, email) VALUES 
('Loja de Uvas', '00.000.000/0001-01', 'Levi', '9999-GOLD', 'uva@lojas.com'), 
('Loja de Bananas', '00.000.000/0001-02', 'Delomar', '(95) 91234-1234', 'banana@lojas.com'), 
('Loja de Mangas', '00.000.000/0001-03', 'João', '(95) 91234-1235', 'manga@lojas.com'), 
('Loja de Maçãs', '00.000.000/0001-04', 'Maria', '(95) 91234-1236', 'maca@lojas.com'), 
('Loja de Laranjas', '00.000.000/0001-05', 'Alice', '(95) 91234-1237', 'laranja@lojas.com'), 
('Loja de Pêras', '00.000.000/0001-06', 'Bob', '(95) 91234-1238', 'pera@lojas.com'), 
('Loja de Pêssegos', '00.000.000/0001-07', 'Momotarou', '(95) 91234-1239', 'pessego@lojas.com');

INSERT INTO nivel_acesso (nome) VALUES 
('Administrador'), 
('Nível 2'), 
('Nível 3'), 
('Nível 4'), 
('Nível 5');

INSERT INTO usuario (nome, empresa_id, nivel_acesso_id, conta, rg, cpf, data_nascimento, telefone, email) VALUES 
('Levi', 1, 1, 'Lekiyoshi', '00.000.001-0', '000.000.001-00', '2000-01-01', '9999-GOLD', 'levi@email.com'), 
('Alexandre', 1, 2, 'Alexandre', '00.000.002-0', '000.000.002-00', '2000-01-02', '(95) 91234-2345', 'alexandre@email.com');

INSERT INTO fornecedor (nome, cnpj, responsavel, telefone, email) VALUES 
('Assaí', '00.000.000/0002-01', 'May', '(95) 91234-3456', 'assai@lojas.com'), 
('Atacadão', '00.000.000/0002-02', 'Brendan', '(95) 91234-3457', 'atacadao@lojas.com');

INSERT INTO produto (empresa_id, fornecedor_id, nome, unidade, quantidade, preco) VALUES 
(1, 1, 'Açaí', 'Kg', 300, '29.50'),
(1, 2, 'Pitomba', 'Kg', 400, '14.50');

INSERT INTO compra (fornecedor_id, produto_id, quantidade, valor_unitario, forma_pagamento, data_compra) VALUES 
(1, 1, 100, '19.50', 1, '2022-01-01'),
(2, 2, 100, '8.50', 1, '2022-02-02');

INSERT INTO cliente (nome, telefone, email, tipo_cliente) VALUES 
('Marcia', '(95) 91234-4567', 'marcia@email.com', 1), 
('Frutas e Cia', '(95) 91234-4568', 'frutas@lojas.com', 2);

INSERT INTO cliente_pessoa_fisica (cliente_id, rg, cpf, data_nascimento) VALUES 
(1, '00.001.001-0', '000.001.001-00', '1990-12-12');

INSERT INTO cliente_pessoa_juridica (cliente_id, cnpj, proprietario, representante) VALUES 
(2, '00.000.000/0003-01', 'Pedro', 'Pedro');

INSERT INTO venda (cliente_id, produto_id, quantidade, valor_unitario, forma_pagamento, data_venda) VALUES 
(1, 1, 50, '29.50', 1, '2022-03-03'), 
(2, 2, 250, '14.50', 1, '2022-04-04');
