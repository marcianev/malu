-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Tempo de geração: 01/11/2025 às 13:09
-- Versão do servidor: 10.4.32-MariaDB
-- Versão do PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `malu_modas`
--

-- --------------------------------------------------------

--
-- Estrutura para tabela `produto`
--

CREATE TABLE `produto` (
  `id_produto` bigint(20) NOT NULL,
  `cod_produto` int(11) NOT NULL,
  `nome` varchar(20) NOT NULL,
  `descricao` varchar(50) NOT NULL,
  `qtd` int(11) NOT NULL,
  `tamanho` varchar(2) NOT NULL,
  `compra` decimal(10,2) NOT NULL,
  `venda` decimal(10,2) NOT NULL,
  `fornecedor` varchar(50) NOT NULL,
  `max_desc` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Despejando dados para a tabela `produto`
--

INSERT INTO `produto` (`id_produto`, `cod_produto`, `nome`, `descricao`, `qtd`, `tamanho`, `compra`, `venda`, `fornecedor`, `max_desc`) VALUES
(1, 101, 'Camiseta', 'Camiseta algodão branca', 50, 'M', 15.90, 29.90, 'Têxtil Silva', 10),
(2, 102, 'Calça', 'Calça jeans azul', 35, 'G', 45.00, 89.90, 'Moda Center', 15),
(3, 103, 'Boné', 'Boné esportivo preto', 15, 'U', 12.50, 25.00, 'Acessórios Lima', 5),
(4, 104, 'Jaqueta', 'Jaqueta corta-vento', 15, 'M', 60.00, 119.90, 'Têxtil Silva', 20),
(5, 105, 'Vestido', 'Vestido floral verão', 25, 'P', 35.00, 69.90, 'Confecções Rosa', 12),
(7, 107, 'Meias', 'meias esportivas', 100, 'U', 3.50, 7.90, 'Acessórios Lima', 5),
(8, 108, 'Blusa', 'Blusa manga longa', 35, 'G', 22.00, 49.90, 'Têxtil Silva', 8),
(10, 110, 'Cinto', 'Cinto de couro marrom', 20, 'U', 18.00, 39.90, 'Acessórios Lima', 7),
(12, 112, 'Echarpe', 'echarpe de crepe', 30, 'U', 16.00, 24.00, 'Confecções Rosa', 5),
(13, 113, 'Blusa linho', 'Blusa feminina de linho', 45, 'G', 45.50, 98.00, 'Moda Center', 10);

-- --------------------------------------------------------

--
-- Estrutura para tabela `usuario`
--

CREATE TABLE `usuario` (
  `id_user` bigint(20) NOT NULL,
  `codigo_user` int(11) NOT NULL,
  `senha` varchar(32) NOT NULL,
  `acesso` varchar(20) NOT NULL,
  `nome` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Despejando dados para a tabela `usuario`
--

INSERT INTO `usuario` (`id_user`, `codigo_user`, `senha`, `acesso`, `nome`) VALUES
(1, 2378, '25d55ad283aa400af464c76d713c07ad', 'gerente', 'Maria');

--
-- Índices para tabelas despejadas
--

--
-- Índices de tabela `produto`
--
ALTER TABLE `produto`
  ADD PRIMARY KEY (`id_produto`);

--
-- Índices de tabela `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`id_user`);

--
-- AUTO_INCREMENT para tabelas despejadas
--

--
-- AUTO_INCREMENT de tabela `produto`
--
ALTER TABLE `produto`
  MODIFY `id_produto` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- AUTO_INCREMENT de tabela `usuario`
--
ALTER TABLE `usuario`
  MODIFY `id_user` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
