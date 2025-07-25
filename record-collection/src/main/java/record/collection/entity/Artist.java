package record.collection.entity;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
public class Artist {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long artistId;

	@EqualsAndHashCode.Exclude
	private String artist;

	private Set<Genre> genres = new HashSet<>();

	@OneToMany(mappedBy = "artist, cascade = CascadeType.ALL", orphanRemoval = true)
	private List<Album> albums;

	private String getArtist() {
		return artist;
	}
}
