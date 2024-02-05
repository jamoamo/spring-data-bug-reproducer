/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package spring.test.bugreproduce.repository;

import org.springframework.data.repository.CrudRepository;
import spring.test.bugreproduce.model.Trunk;

/**
 *
 * @author James Amoore
 */
public interface TrunkRepository extends CrudRepository<Trunk, Integer>
{
	
}
