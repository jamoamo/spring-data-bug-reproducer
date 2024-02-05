/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package spring.test.bugreproduce.model;

import java.util.List;
import java.util.Set;
import org.springframework.data.annotation.Id;

/**
 *
 * @author James Amoore
 */
public class Trunk
{
	@Id
	private int trunkRef;
	
	private Set<Branch> branches;

	public int getTrunkRef()
	{
		return trunkRef;
	}

	public void setTrunkRef(int trunkRef)
	{
		this.trunkRef = trunkRef;
	}

	public Set<Branch> getBranches()
	{
		return branches;
	}

	public void setBranches(Set<Branch> branches)
	{
		this.branches = branches;
	}
}
