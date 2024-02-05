/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/SQLTemplate.sql to edit this template
 */
/**
 * Author:  James Amoore
 * Created: 05 Feb 2024
 */

INSERT INTO trunk(trunk_ref) VALUES(10);
INSERT INTO branch(branch_ref, trunk) VALUES(100, 10);
INSERT INTO branch(branch_ref, trunk) VALUES(101, 10);
INSERT INTO branch(branch_ref, trunk) VALUES(110, 11);
INSERT INTO twig(twig_ref, branch) VALUES(1000, 100);
INSERT INTO twig(twig_ref, branch) VALUES(1100, 110);
INSERT INTO leaf(leaf_ref, twig) VALUES(10000, 1000);
INSERT INTO leaf(leaf_ref, twig) VALUES(11000, 1100);