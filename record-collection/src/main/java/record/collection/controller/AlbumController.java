package record.collection.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import record.collection.controller.model.ContributorData;
import record.collection.service.RecordService;

@RestController
@RequestMapping("/record_collection")
@Slf4j
public class AlbumController {
	@Autowired
	private RecordService recordService;
	
	@PostMapping("/contributor")
	public ContributorData insertContributor(@RequestBody ContributorData contributorData) {
		log.info("Creating contributor {}", contributorData);
		return recordService.saveContributor(contributorData);
	}
}
