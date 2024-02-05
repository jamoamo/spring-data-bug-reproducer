/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package spring.test.bugreproduce.model;

import org.springframework.data.annotation.Id;

/**
 *
 * @author James Amoore
 */
public class Leaf
{
	@Id
	private int leafRef;

	public int getLeafRef()
	{
		return leafRef;
	}

	public void setId(int leafRef)
	{
		this.leafRef = leafRef;
	}
	
	
}
