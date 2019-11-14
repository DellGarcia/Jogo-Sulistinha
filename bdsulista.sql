-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: 11-Nov-2019 às 10:16
-- Versão do servidor: 10.1.38-MariaDB
-- versão do PHP: 7.3.2

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
-- Estrutura da tabela `tbanimacao`
--

CREATE TABLE `tbanimacao` (
  `codAnimacao` int(11) NOT NULL,
  `nomeAnimacao` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `tbanimacao`
--

INSERT INTO `tbanimacao` (`codAnimacao`, `nomeAnimacao`) VALUES
(17, 'telaInicial'),
(18, 'telaCarregamento'),
(19, 'adventure-attack'),
(20, 'adventure-idle'),
(21, 'adventure-run'),
(22, 'adventure-hit'),
(23, 'adventure-die'),
(24, 'skeleton-attack'),
(25, 'skeleton-idle'),
(26, 'skeleton-run'),
(27, 'skeleton-hit'),
(28, 'skeleton-die');

-- --------------------------------------------------------

--
-- Estrutura da tabela `tbframe`
--

CREATE TABLE `tbframe` (
  `codFrame` int(11) NOT NULL,
  `caminho` varchar(200) NOT NULL,
  `codAnimacao` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `tbframe`
--

INSERT INTO `tbframe` (`codFrame`, `caminho`, `codAnimacao`) VALUES
(204, 'assets/anime/telaInicial/frame-01.png', 17),
(205, 'assets/anime/telaInicial/frame-02.png', 17),
(206, 'assets/anime/telaInicial/frame-03.png', 17),
(207, 'assets/anime/telaInicial/frame-04.png', 17),
(208, 'assets/anime/telaInicial/frame-05.png', 17),
(209, 'assets/anime/telaInicial/frame-06.png', 17),
(210, 'assets/anime/telaInicial/frame-07.png', 17),
(211, 'assets/anime/telaInicial/frame-08.png', 17),
(212, 'assets/anime/telaInicial/frame-09.png', 17),
(213, 'assets/anime/telaInicial/frame-10.png', 17),
(214, 'assets/anime/telaInicial/frame-11.png', 17),
(215, 'assets/anime/telaCarregamento/frame-01.png', 18),
(216, 'assets/anime/telaCarregamento/frame-02.png', 18),
(217, 'assets/anime/telaCarregamento/frame-03.png', 18),
(218, 'assets/anime/telaCarregamento/frame-04.png', 18),
(219, 'assets/anime/telaCarregamento/frame-05.png', 18),
(220, 'assets/anime/telaCarregamento/frame-06.png', 18),
(237, 'assets/anime/personagens/adventure/attack/frame-01.png', 19),
(238, 'assets/anime/personagens/adventure/attack/frame-02.png', 19),
(239, 'assets/anime/personagens/adventure/attack/frame-03.png', 19),
(240, 'assets/anime/personagens/adventure/attack/frame-04.png', 19),
(241, 'assets/anime/personagens/adventure/attack/frame-05.png', 19),
(242, 'assets/anime/personagens/adventure/attack/frame-06.png', 19),
(243, 'assets/anime/personagens/adventure/attack/frame-07.png', 19),
(244, 'assets/anime/personagens/adventure/attack/frame-08.png', 19),
(245, 'assets/anime/personagens/adventure/attack/frame-09.png', 19),
(246, 'assets/anime/personagens/adventure/attack/frame-10.png', 19),
(247, 'assets/anime/personagens/adventure/attack/frame-11.png', 19),
(248, 'assets/anime/personagens/adventure/attack/frame-12.png', 19),
(249, 'assets/anime/personagens/adventure/attack/frame-13.png', 19),
(250, 'assets/anime/personagens/adventure/idle/frame-01.png', 20),
(251, 'assets/anime/personagens/adventure/idle/frame-02.png', 20),
(252, 'assets/anime/personagens/adventure/idle/frame-03.png', 20),
(253, 'assets/anime/personagens/adventure/idle/frame-04.png', 20),
(254, 'assets/anime/personagens/adventure/run/frame-01.png', 21),
(255, 'assets/anime/personagens/adventure/run/frame-02.png', 21),
(256, 'assets/anime/personagens/adventure/run/frame-03.png', 21),
(257, 'assets/anime/personagens/adventure/run/frame-04.png', 21),
(258, 'assets/anime/personagens/adventure/run/frame-05.png', 21),
(259, 'assets/anime/personagens/adventure/run/frame-06.png', 21),
(260, 'assets/anime/personagens/adventure/hit/frame-01.png', 22),
(261, 'assets/anime/personagens/adventure/hit/frame-02.png', 22),
(262, 'assets/anime/personagens/adventure/hit/frame-03.png', 22),
(263, 'assets/anime/personagens/adventure/die/frame-01.png', 23),
(264, 'assets/anime/personagens/adventure/die/frame-02.png', 23),
(265, 'assets/anime/personagens/adventure/die/frame-03.png', 23),
(266, 'assets/anime/personagens/adventure/die/frame-04.png', 23),
(267, 'assets/anime/personagens/adventure/die/frame-05.png', 23),
(268, 'assets/anime/personagens/adventure/die/frame-06.png', 23),
(269, 'assets/anime/personagens/adventure/die/frame-07.png', 23),
(270, 'assets/anime/personagens/skeleton/attack/frame-01.png', 24),
(271, 'assets/anime/personagens/skeleton/attack/frame-02.png', 24),
(272, 'assets/anime/personagens/skeleton/attack/frame-03.png', 24),
(273, 'assets/anime/personagens/skeleton/attack/frame-04.png', 24),
(274, 'assets/anime/personagens/skeleton/attack/frame-05.png', 24),
(275, 'assets/anime/personagens/skeleton/attack/frame-06.png', 24),
(276, 'assets/anime/personagens/skeleton/attack/frame-07.png', 24),
(277, 'assets/anime/personagens/skeleton/attack/frame-08.png', 24),
(278, 'assets/anime/personagens/skeleton/attack/frame-09.png', 24),
(279, 'assets/anime/personagens/skeleton/attack/frame-10.png', 24),
(280, 'assets/anime/personagens/skeleton/attack/frame-11.png', 24),
(281, 'assets/anime/personagens/skeleton/attack/frame-12.png', 24),
(282, 'assets/anime/personagens/skeleton/attack/frame-13.png', 24),
(283, 'assets/anime/personagens/skeleton/attack/frame-14.png', 24),
(284, 'assets/anime/personagens/skeleton/attack/frame-15.png', 24),
(285, 'assets/anime/personagens/skeleton/attack/frame-16.png', 24),
(286, 'assets/anime/personagens/skeleton/attack/frame-17.png', 24),
(287, 'assets/anime/personagens/skeleton/attack/frame-18.png', 24),
(288, 'assets/anime/personagens/skeleton/idle/frame-01.png', 25),
(289, 'assets/anime/personagens/skeleton/idle/frame-02.png', 25),
(290, 'assets/anime/personagens/skeleton/idle/frame-03.png', 25),
(291, 'assets/anime/personagens/skeleton/idle/frame-04.png', 25),
(292, 'assets/anime/personagens/skeleton/idle/frame-05.png', 25),
(293, 'assets/anime/personagens/skeleton/idle/frame-06.png', 25),
(294, 'assets/anime/personagens/skeleton/idle/frame-07.png', 25),
(295, 'assets/anime/personagens/skeleton/idle/frame-08.png', 25),
(296, 'assets/anime/personagens/skeleton/idle/frame-09.png', 25),
(297, 'assets/anime/personagens/skeleton/idle/frame-10.png', 25),
(298, 'assets/anime/personagens/skeleton/idle/frame-11.png', 25),
(299, 'assets/anime/personagens/skeleton/run/frame-01.png', 26),
(300, 'assets/anime/personagens/skeleton/run/frame-02.png', 26),
(301, 'assets/anime/personagens/skeleton/run/frame-03.png', 26),
(302, 'assets/anime/personagens/skeleton/run/frame-04.png', 26),
(303, 'assets/anime/personagens/skeleton/run/frame-05.png', 26),
(304, 'assets/anime/personagens/skeleton/run/frame-06.png', 26),
(305, 'assets/anime/personagens/skeleton/run/frame-07.png', 26),
(306, 'assets/anime/personagens/skeleton/run/frame-08.png', 26),
(307, 'assets/anime/personagens/skeleton/run/frame-09.png', 26),
(308, 'assets/anime/personagens/skeleton/run/frame-10.png', 26),
(309, 'assets/anime/personagens/skeleton/run/frame-11.png', 26),
(310, 'assets/anime/personagens/skeleton/run/frame-12.png', 26),
(311, 'assets/anime/personagens/skeleton/run/frame-13.png', 26),
(312, 'assets/anime/personagens/skeleton/hit/frame-01.png', 27),
(313, 'assets/anime/personagens/skeleton/hit/frame-02.png', 27),
(314, 'assets/anime/personagens/skeleton/hit/frame-03.png', 27),
(315, 'assets/anime/personagens/skeleton/hit/frame-04.png', 27),
(316, 'assets/anime/personagens/skeleton/hit/frame-05.png', 27),
(317, 'assets/anime/personagens/skeleton/hit/frame-06.png', 27),
(318, 'assets/anime/personagens/skeleton/hit/frame-07.png', 27),
(319, 'assets/anime/personagens/skeleton/hit/frame-08.png', 27),
(320, 'assets/anime/personagens/skeleton/die/frame-01.png', 28),
(321, 'assets/anime/personagens/skeleton/die/frame-02.png', 28),
(322, 'assets/anime/personagens/skeleton/die/frame-03.png', 28),
(323, 'assets/anime/personagens/skeleton/die/frame-04.png', 28),
(324, 'assets/anime/personagens/skeleton/die/frame-05.png', 28),
(325, 'assets/anime/personagens/skeleton/die/frame-06.png', 28),
(326, 'assets/anime/personagens/skeleton/die/frame-07.png', 28),
(327, 'assets/anime/personagens/skeleton/die/frame-08.png', 28),
(328, 'assets/anime/personagens/skeleton/die/frame-09.png', 28),
(329, 'assets/anime/personagens/skeleton/die/frame-10.png', 28),
(330, 'assets/anime/personagens/skeleton/die/frame-11.png', 28),
(331, 'assets/anime/personagens/skeleton/die/frame-12.png', 28),
(332, 'assets/anime/personagens/skeleton/die/frame-13.png', 28),
(333, 'assets/anime/personagens/skeleton/die/frame-14.png', 28),
(334, 'assets/anime/personagens/skeleton/die/frame-15.png', 28);

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
(6, 'A região sul do Brasil é formada por três unidades de federação:', 'Paraná, Santa Catarina e Rio Grande do Sul', 'Panamá, Santa Catarina e Rio Grande do Sul', 'Paraná, Santa Catarina e Rio Grande do Norte', 'Paraná, Santa Bárbara, Rio Grande do Sul'),
(7, 'A Região Sul ocupa ______ do território brasileiro.', '6,76%', '10.76%', '20,67%', '15,21%'),
(8, 'O estado de _________ é o maior produtor nacional de ostras e mexilhões cultivados em grandes parques aquícolas.', 'Santa Catarina', 'Curitiba', 'Porto Alegre', 'Caxias do Sul'),
(9, 'A Ferrovia Curitiba - Paranaguá, localizada na Serra do Mar, construída em:', '1808', '1880', '1088', '1888'),
(10, 'A Região Sul apresenta relevo formado pelo:', 'Planaltos', 'Montanhas', 'Planícies', 'Depressões'),
(11, 'A criação de gado bovino de corte, visa abastecer:', 'O mercado interno e à exportação', 'O mercado externo e à importação', 'O mercado interno e à importação', 'O mercado externo e à exportação'),
(12, 'A Região Sul é responsável por ___ da produção nacional em vinícolas.', '85%', '80%', '90%', '75%');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `tbanimacao`
--
ALTER TABLE `tbanimacao`
  ADD PRIMARY KEY (`codAnimacao`);

--
-- Indexes for table `tbframe`
--
ALTER TABLE `tbframe`
  ADD PRIMARY KEY (`codFrame`),
  ADD KEY `codAnimacao` (`codAnimacao`);

--
-- Indexes for table `tbquestao`
--
ALTER TABLE `tbquestao`
  ADD PRIMARY KEY (`idQuestao`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `tbanimacao`
--
ALTER TABLE `tbanimacao`
  MODIFY `codAnimacao` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=29;

--
-- AUTO_INCREMENT for table `tbframe`
--
ALTER TABLE `tbframe`
  MODIFY `codFrame` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=335;

--
-- AUTO_INCREMENT for table `tbquestao`
--
ALTER TABLE `tbquestao`
  MODIFY `idQuestao` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- Constraints for dumped tables
--

--
-- Limitadores para a tabela `tbframe`
--
ALTER TABLE `tbframe`
  ADD CONSTRAINT `tbframe_ibfk_1` FOREIGN KEY (`codAnimacao`) REFERENCES `tbanimacao` (`codAnimacao`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
