-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: 02-Nov-2019 às 21:15
-- Versão do servidor: 10.1.36-MariaDB
-- versão do PHP: 7.2.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `bdsulista`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `tbquestao`
--

CREATE TABLE `tbquestao` (
  `idQuestao` int(11) NOT NULL,
  `pergunta` varchar(500) NOT NULL,
  `correta` varchar(100) NOT NULL,
  `errada1` varchar(100) NOT NULL,
  `errada2` varchar(100) NOT NULL,
  `errada3` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `tbquestao`
--

INSERT INTO `tbquestao` (`idQuestao`, `pergunta`, `correta`, `errada1`, `errada2`, `errada3`) VALUES
(1, 'A região sul do Brasil é:', 'A menor região', 'A maior região', 'A mais rica', 'A mais pobre'),
(2, 'Qual oceano banha a região Sul?', 'Atlântico', 'Indico', 'Pacifico', 'Glacial Atlântinco'),
(3, 'Quais os fenômenos climáticos do inverno da região Sul do país?', 'Geada e neve', 'Calor e chuva', 'Frio e calor', 'Efeito estufa e calor'),
(4, 'Qual desses eventos não ocorreu na região sul?', 'Guerra do Confirmado', 'Guerra dos Farrapos', 'Revolução Federalista', 'Cerco da Lapa'),
(5, 'Qual é o tipo de clima da região sul?', 'Subtropical', 'Tropical', 'Temperado', 'Equatorial'),
(6, 'A região sul do Brasil é formada por três unidades de federação:', 'Paraná, Santa Catarina e Rio Grande do Sul', 'Panamá, Santa Catarina e Rio Grande do Sul', 'Paraná, Santa Catarina e Rio Grande do Norte', 'Paraná, Santa Bárbara, Rio Grande do Sul');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `tbquestao`
--
ALTER TABLE `tbquestao`
  ADD PRIMARY KEY (`idQuestao`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `tbquestao`
--
ALTER TABLE `tbquestao`
  MODIFY `idQuestao` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
