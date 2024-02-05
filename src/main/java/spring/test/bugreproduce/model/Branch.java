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
public class Branch
{
	@Id
	private int branchRef;
	
	private Twig twig;

	public int getBranchRef()
	{
		return branchRef;
	}

	public void setBranchRef(int branchRef)
	{
		this.branchRef = branchRef;
	}

	public Twig getLeaf()
	{
		return twig;
	}

	public void setLeaf(Twig twig)
	{
		this.twig = twig;
	}
	
	
}
