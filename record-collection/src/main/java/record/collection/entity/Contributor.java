package record.collection.entity;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Entity;
import lombok.Data;

@Entity
@Data
public class Contributor {
	private Long contributorId;
	private String contributorName;
	private String contributorUsername;
	
	private Set<Album> album = new HashSet <>();
}