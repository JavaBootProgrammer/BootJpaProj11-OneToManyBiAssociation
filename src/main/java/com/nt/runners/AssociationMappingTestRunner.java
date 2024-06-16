package com.nt.runners;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.service.ICompanyMgmtService;


@Component
public class AssociationMappingTestRunner implements CommandLineRunner {
	@Autowired
	private  ICompanyMgmtService  compService;

	@Override
	public void run(String... args) throws Exception {
		//save objs (parent to child)
		/*	try {
				String msg=compService.saveDataUsingParent();
				System.out.println(msg);
			}
			catch(Exception e) {
				e.printStackTrace();
			}*/
		
		/*   try {
			   String msg=compService.saveDataUsingChild();
			   System.out.println(msg);
		   }
		   catch(Exception e) {
			   e.printStackTrace();
		   }*/
		
		   //compService.loadDataUsingParent();
		
		    //compService.loadDataUsingChild();
		
		      //compService.deleteDataUsingParent(100);
		
		        // compService.deleteDataUsingChild(102);
		
		       compService.addNewChildTotheExistingChildsOfAParent(101);

	}

}
