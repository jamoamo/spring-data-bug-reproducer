/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package spring.test.bugreproduce.model;

import java.util.Set;
import org.springframework.data.annotation.Id;

/**
 *
 * @author James Amoore
 */
public class Twig
{
	@Id
	private int twigRef;
	
	private Set<Leaf> leaves;

	public int getTwigRef()
	{
		return twigRef;
	}

	public void setTwigRef(int twigRef)
	{
		this.twigRef = twigRef;
	}

	public Set<Leaf> getLeaves()
	{
		return leaves;
	}

	public void setLeaves(Set<Leaf> leaves)
	{
		this.leaves = leaves;
	}
}
