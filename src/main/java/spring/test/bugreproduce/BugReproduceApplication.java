package spring.test.bugreproduce;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import spring.test.bugreproduce.model.Trunk;
import spring.test.bugreproduce.model.Branch;
import spring.test.bugreproduce.repository.BranchRepository;
import spring.test.bugreproduce.repository.TrunkRepository;

@SpringBootApplication
public class BugReproduceApplication
{

	@Autowired
	private TrunkRepository trunkRepo;
	
	@Autowired
	private BranchRepository branchRepo;
	
	public static void main(String[] args)
	{
		SpringApplication.run(BugReproduceApplication.class, args);
	}

	@EventListener
    public void handleContextRefresh(ContextRefreshedEvent event) {
		System.out.println("branches");
		Iterable<Branch> branches = branchRepo.findAll();
		
		//System.out.println("trunks");
		//Iterable<Trunk> trunks = trunkRepo.findAll();
    }
}
