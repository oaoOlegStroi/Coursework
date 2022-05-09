-- phpMyAdmin SQL Dump
-- version 4.9.0.1
-- https://www.phpmyadmin.net/
--
-- Хост: 127.0.0.1
-- Время создания: Май 09 2022 г., 11:08
-- Версия сервера: 10.3.16-MariaDB
-- Версия PHP: 7.3.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- База данных: `batutcenter`
--

-- --------------------------------------------------------

--
-- Структура таблицы `control_user`
--

CREATE TABLE `control_user` (
  `id` bigint(20) NOT NULL,
  `fio` varchar(255) DEFAULT NULL,
  `end_time` datetime DEFAULT NULL,
  `is_time_end` bit(1) NOT NULL,
  `start_time` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `control_user`
--

INSERT INTO `control_user` (`id`, `fio`, `end_time`, `is_time_end`, `start_time`) VALUES
(1, 'Олег Николаев', '2022-05-07 00:35:00', b'0', '2022-05-06 23:35:40'),
(2, 'Ростислав Кравченко', '2022-05-06 23:42:00', b'1', '2022-05-06 23:42:28'),
(3, 'Виктор Корнеплод', '2022-05-08 13:57:00', b'0', '2022-05-06 23:56:16'),
(4, 'Саша Камень', '2022-05-09 11:59:00', b'0', '2022-05-06 23:57:26'),
(5, 'Дарья Два', '2022-05-07 00:02:00', b'1', '2022-05-07 00:00:28');

-- --------------------------------------------------------

--
-- Структура таблицы `hibernate_sequence`
--

CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `hibernate_sequence`
--

INSERT INTO `hibernate_sequence` (`next_val`) VALUES
(6);

--
-- Индексы сохранённых таблиц
--

--
-- Индексы таблицы `control_user`
--
ALTER TABLE `control_user`
  ADD PRIMARY KEY (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
