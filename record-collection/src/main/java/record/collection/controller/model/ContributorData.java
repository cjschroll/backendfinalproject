package record.collection.controller.model;

import java.util.HashSet;
import java.util.Set;

import lombok.Data;
import lombok.Value;
import record.collection.entity.Artist;

@Data
public class ContributorData {
	private Long contributorId;
	private String contributorName;
	private String contributorUsername;
	private Set<AlbumAddition> album = new HashSet <>();

@Value
static class AlbumAddition {
	private int albumId;
	private String title;
	private int yearReleased;
	private Artist artist;
	private Set<String> genres = new HashSet<>();
		}
}