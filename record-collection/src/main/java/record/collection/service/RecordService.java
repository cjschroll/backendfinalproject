package record.collection.service;

import java.util.NoSuchElementException;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import record.collection.controller.model.ContributorData;
import record.collection.dao.ContributorDao;
import record.collection.entity.Contributor;

@Service
public class RecordService {
	
	@Autowired
	private ContributorDao contributorDao;
	
	@Transactional(readOnly = false)
	public ContributorData saveContributor(ContributorData contributorData) {
		Long contributorId = contributorData.getContributorId();
		Contributor contributor = findOrCreateContributor(contributorId);
		
		//Pet Park - Create Contributor Operation 28.06
	}

	private Contributor findOrCreateContributor(Long contributorId) {
		Contributor contributor;
		
		if(Objects.isNull(contributorId)) {
			contributor = new Contributor();
		}
		else {
			contributor = findContributorById(contributorId);
			
		}
		
		return contributor;
	}

	private Contributor findContributorById(Long contributorId) {
		return contributorDao.findById(contributorId).orElseThrow(() -> new NoSuchElementException("Contributor with ID= " + contributorId + " was not found."));
	}

}
