INSERT INTO carrinho(NomeCliente,ValorTotal,QtdProdutos)
	VALUES("Clever",120.00,4);
INSERT INTO produtos(NomeProduto,Valor,Quantidade,Carrinho_idCarrinho)
	VALUES("Carne",30.00,"2 kg",1),
		("Óleo",30.00,"1 unidade",1),
		("Leite",30.00,"1,5 litros",1),
		("Alface",30.00,"1 unidade",1);
UPDATE produtos
	SET Valor = 100.00, Quantidade = "6,6 kg"
	WHERE idProdutos = 1;        
SELECT * FROM carrinho;
SELECT * FROM produtos;   
DELETE FROM produtos WHERE idProdutos = 4;