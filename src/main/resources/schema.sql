/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/SQLTemplate.sql to edit this template
 */
/**
 * Author:  James Amoore
 * Created: 05 Feb 2024
 */

CREATE TABLE trunk
(
   trunk_ref INTEGER,
   PRIMARY KEY (trunk_ref)
);

CREATE TABLE branch
(
   branch_ref INTEGER,
   trunk INTEGER,
   PRIMARY KEY (branch_ref)
);

CREATE TABLE twig
(
   twig_ref INTEGER,
   branch INTEGER,
   PRIMARY KEY (twig_ref)
);

CREATE TABLE leaf
(
   leaf_ref INTEGER,
   twig INTEGER,
   PRIMARY KEY (leaf_ref)
);