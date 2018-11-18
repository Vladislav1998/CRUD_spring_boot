-- phpMyAdmin SQL Dump
-- version 4.7.7
-- https://www.phpmyadmin.net/
--
-- Хост: 127.0.0.1:3306
-- Время создания: Ноя 18 2018 г., 13:45
-- Версия сервера: 5.6.38
-- Версия PHP: 7.2.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- База данных: `test_cd_shop`
--

-- --------------------------------------------------------

--
-- Структура таблицы `Artist`
--

CREATE TABLE `Artist` (
  `Artist_ID` int(11) NOT NULL,
  `Name` varchar(20) NOT NULL,
  `Number_of_albums` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `Artist`
--

INSERT INTO `Artist` (`Artist_ID`, `Name`, `Number_of_albums`) VALUES
(2, 'Panic', 13),
(3, 'Kanye West', 9),
(4, 'Jorja Smith', 11),
(5, 'Nine Inch Nails', 9),
(6, 'Inch Nails', 12),
(7, 'Sub Pop', 7),
(8, 'Florence + the Machi', 16),
(9, 'DDT', 12),
(10, 'The Carters', 12),
(11, 'Milina', 7);

-- --------------------------------------------------------

--
-- Структура таблицы `CD`
--

CREATE TABLE `CD` (
  `CD_ID` int(11) NOT NULL,
  `Album` varchar(50) NOT NULL,
  `Genre` varchar(15) NOT NULL,
  `Artist_ID` int(11) NOT NULL,
  `organization_ID` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `CD`
--

INSERT INTO `CD` (`CD_ID`, `Album`, `Genre`, `Artist_ID`, `organization_ID`) VALUES
(2, 'Warner Music', 'Rock', 2, 3),
(3, 'FAMM', 'R&B', 5, 4),
(4, 'Fueled by Ramen', 'Folk', 3, 8),
(5, 'Dreams', 'Rock', 4, 6),
(6, 'The Null Corporation', 'International', 6, 1),
(7, 'Warner Music', 'Pop', 10, 5),
(8, 'Sub Pop', 'Pop', 8, 9),
(9, 'Universal Music', 'Vocal', 9, 10),
(10, 'Navigator', 'Rap', 11, 11);

-- --------------------------------------------------------

--
-- Структура таблицы `organization`
--

CREATE TABLE `organization` (
  `organization_ID` int(11) NOT NULL,
  `name_of_organization` varchar(30) DEFAULT NULL,
  `phone` varchar(20) DEFAULT NULL,
  `e_mail` varchar(32) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `organization`
--

INSERT INTO `organization` (`organization_ID`, `name_of_organization`, `phone`, `e_mail`) VALUES
(1, 'Acer', '+380999271112', 'acer@gmail.com'),
(2, 'Vinil', '+38094646545', 'vinil@gmail.com'),
(3, 'Sony Prodaction', '+380990244234', 'sony@gmail.com'),
(4, 'Nokia', '+380678751345', 'nokia@gmail.com'),
(5, 'Samsung', '+380689784523', 'samsung@gmail.com'),
(6, 'Lenovo', '+380995741235', 'lenovo@gmail.com'),
(8, 'Panasonic', '+380662354847', 'panasonic@mail.com'),
(9, 'Apple', '+380968713464', 'apple@mail.com'),
(10, 'iAhar', '+380962359243', 'iahar@mail.com'),
(11, 'Music room', '+380968574287', 'musicroom@mail.com');

--
-- Индексы сохранённых таблиц
--

--
-- Индексы таблицы `Artist`
--
ALTER TABLE `Artist`
  ADD PRIMARY KEY (`Artist_ID`);

--
-- Индексы таблицы `CD`
--
ALTER TABLE `CD`
  ADD PRIMARY KEY (`CD_ID`),
  ADD KEY `CD_Artist` (`Artist_ID`),
  ADD KEY `CD_organization` (`organization_ID`);

--
-- Индексы таблицы `organization`
--
ALTER TABLE `organization`
  ADD PRIMARY KEY (`organization_ID`);

--
-- AUTO_INCREMENT для сохранённых таблиц
--

--
-- AUTO_INCREMENT для таблицы `Artist`
--
ALTER TABLE `Artist`
  MODIFY `Artist_ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT для таблицы `CD`
--
ALTER TABLE `CD`
  MODIFY `CD_ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT для таблицы `organization`
--
ALTER TABLE `organization`
  MODIFY `organization_ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- Ограничения внешнего ключа сохраненных таблиц
--

--
-- Ограничения внешнего ключа таблицы `CD`
--
ALTER TABLE `CD`
  ADD CONSTRAINT `CD_organization` FOREIGN KEY (`organization_ID`) REFERENCES `organization` (`organization_ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `Cd_Artist` FOREIGN KEY (`Artist_ID`) REFERENCES `Artist` (`Artist_ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `FK9h0ltj552jugnhsskumg52wtm` FOREIGN KEY (`Artist_ID`) REFERENCES `artist` (`Artist_ID`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
