package com.nt.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.entity.Company;
import com.nt.entity.TechnicalJob;
import com.nt.repository.ICompanyRepository;
import com.nt.repository.ITechnicalJobRepository;

@Service
public class CompanyMgmtSErviceImpl implements ICompanyMgmtService {
	@Autowired
	private ICompanyRepository companyRepo;
	@Autowired
	private ITechnicalJobRepository techJobRepo;

	@Override
	public String saveDataUsingParent() {
		// prepare parent obj
		Company company = new Company("HCL", "hyd", 500566L);
		// prepare child objs
		TechnicalJob job1 = new TechnicalJob("developer", 20000.0, 200000.0, 2);
		TechnicalJob job2 = new TechnicalJob("analyst", 30000.0, 300000.0, 4);
		// set parent to childs
		job1.setCompany(company);
		job2.setCompany(company);
		// set childs to parent
		company.setOpenings(Set.of(job1, job2));
		// save the objs (parent to child)
		companyRepo.save(company);
		return " Parent  obj and its associated child objs are saved";

	}

	@Override
	public String saveDataUsingChild() {
		// prepare parent obj
		Company comp1 = new Company("Wiport", "blore", 515566L);
		// prepare child objs
		TechnicalJob developer = new TechnicalJob("developer", 20000.0, 200000.0, 2);
		TechnicalJob analyst = new TechnicalJob("analyst", 30000.0, 300000.0, 4);
		// set parent to childs
		developer.setCompany(comp1);
		analyst.setCompany(comp1);
		// set childs to parent
		comp1.setOpenings(Set.of(developer, analyst));
		// save data using childs
		techJobRepo.save(developer);
		techJobRepo.save(analyst);

		return "childs objs  and their associated parent obj are saved";
	}

	@Override
	public void loadDataUsingParent() {
		List<Company> list = companyRepo.findAll();
		// to get all parents
		list.forEach(comp -> {
			System.out.println("parent::" + comp);
			// get childs of each parent
			Set<TechnicalJob> jobsSet = comp.getOpenings();
			jobsSet.forEach(job -> {
				System.out.println("child::" + job);
			});
			System.out.println("________________");
		});

	}// method

	@Override
	public void loadDataUsingChild() {
		List<TechnicalJob> list = techJobRepo.findAll();
		list.forEach(job -> {
			System.out.println("child::" + job);
			// get Associated parent of the child(s)
			Company company = job.getCompany();
			System.out.println("parent::" + company);
			System.out.println("____________________");
		});

	}// method

	@Override
	public String deleteDataUsingParent(Integer parentId) {
		// Load parent
		Optional<Company> companyRepoById = companyRepo.findById(parentId);
		if (companyRepoById.isPresent()) {
			companyRepo.delete(companyRepoById.get());
			return "Parent  and its associated child objs are deleted";
		}
		return "Parent obj is not found for deletion";
	}

	@Override
	public String deleteDataUsingChild(int childId) {
		// Load child object
		Optional<TechnicalJob> techJobRepoById = techJobRepo.findById(childId);
		if (techJobRepoById.isPresent()) {
			techJobRepo.delete(techJobRepoById.get());
			return "  childs  and its associated parent is deleted";
		}
		return "child is not found for deletion";
	}

	@Override
	public String addNewChildTotheExistingChildsOfAParent(int parentId) {
		// get PArent obj
		Optional<Company> companyRepoById = companyRepo.findById(parentId);
		if (companyRepoById.isPresent()) {
			Company company = companyRepoById.get();
			// get existing childs of a parent
			Set<TechnicalJob> childsSet = company.getOpenings();
			// create new Child
			TechnicalJob job = new TechnicalJob("tester", 50000.0, 150000.0, 3);
			// add parent to child
			job.setCompany(company);
			// add child to existing childs
			childsSet.add(job);
			// set childs to parent
			company.setOpenings(childsSet);
			// save parent
			companyRepo.save(company);
			return " new  child is added to the existing childs of  a  Parent";
		}
		return "parent not found";
	}// method

}// class
