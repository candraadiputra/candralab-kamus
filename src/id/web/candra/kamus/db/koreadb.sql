-- phpMyAdmin SQL Dump
-- version 2.10.3
-- http://www.phpmyadmin.net
-- 
-- Host: localhost
-- Waktu pembuatan: 28. Maret 2012 jam 20:25
-- Versi Server: 5.0.51
-- Versi PHP: 5.2.6

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";

-- 
-- Database: `koreadb`
-- 

-- --------------------------------------------------------

-- 
-- Struktur dari tabel `korea`
-- 

CREATE TABLE `korea` (
  `no` int(11) NOT NULL auto_increment,
  `korea` varchar(100) NOT NULL,
  `lafal` varchar(100) NOT NULL,
  `indonesia` varchar(100) NOT NULL,
  PRIMARY KEY  (`no`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 AUTO_INCREMENT=8 ;

-- 
-- Dumping data untuk tabel `korea`
-- 

INSERT INTO `korea` VALUES (1, '사랑', 'salang', 'cinta');
INSERT INTO `korea` VALUES (2, '같은', 'gat-eun', 'suka');
INSERT INTO `korea` VALUES (3, '먹다', 'meogda', 'makan');
INSERT INTO `korea` VALUES (4, '이동', 'idong', 'Pergi');
INSERT INTO `korea` VALUES (5, '잠', 'jam', 'tidur');
INSERT INTO `korea` VALUES (6, '홈', 'hom', 'rumah');
INSERT INTO `korea` VALUES (7, '공항', 'gonghang', 'bandara');

-- --------------------------------------------------------

-- 
-- Struktur dari tabel `login`
-- 

CREATE TABLE `login` (
  `id` int(11) default NULL,
  `nama` varchar(20) default NULL,
  `passwd` varchar(20) default NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- 
-- Dumping data untuk tabel `login`
-- 

INSERT INTO `login` VALUES (1, 'admin', 'admin');
