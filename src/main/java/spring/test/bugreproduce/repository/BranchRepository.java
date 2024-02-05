/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package spring.test.bugreproduce.repository;

import org.springframework.data.repository.CrudRepository;
import spring.test.bugreproduce.model.Branch;

/**
 *
 * @author James Amoore
 */
public interface BranchRepository extends CrudRepository<Branch, Integer>
{
	
}
