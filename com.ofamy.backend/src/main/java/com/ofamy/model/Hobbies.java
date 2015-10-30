package com.ofamy.model;

import java.util.HashSet;
import java.util.Set;

import org.neo4j.graphdb.Direction;
import org.springframework.data.neo4j.annotation.GraphId;
import org.springframework.data.neo4j.annotation.NodeEntity;
import org.springframework.data.neo4j.annotation.RelatedTo;

import com.ofamy.util.RelationShipTypes;

/**
 * Simple JavaBean domain object representing a User's hobbies
 * 
 * @author Haithem
 * 
 */
@NodeEntity
public class Hobbies {

	@GraphId
	private Long hobbiesId;

	private Set<String> music = new HashSet<String>();
	private Set<String> favoriteColors = new HashSet<String>();
	private Set<String> sports = new HashSet<String>();

	@RelatedTo(type = RelationShipTypes.GOT_HOBBIES, direction = Direction.INCOMING)
	private User user;

	public void addFavColor(String color) {

		favoriteColors.add(color);
	}

	public void addMusicGenre(String m) {

		music.add(m);
	}

	public void addSoport(String s) {

		sports.add(s);
	}

	public Long getHobbiesId() {
		return hobbiesId;
	}

	public void setHobbiesId(Long hobbiesId) {
		this.hobbiesId = hobbiesId;
	}

	public Set<String> getMusic() {
		return music;
	}

	public void setMusic(Set<String> music) {
		this.music = music;
	}

	
	public Set<String> getFavoriteColors() {
		return favoriteColors;
	}

	public void setFavoriteColors(Set<String> favoriteColors) {
		this.favoriteColors = favoriteColors;
	}

	public Set<String> getSports() {
		return sports;
	}

	public void setSports(Set<String> sports) {
		this.sports = sports;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((hobbiesId == null) ? 0 : hobbiesId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Hobbies other = (Hobbies) obj;
		if (hobbiesId == null) {
			if (other.hobbiesId != null)
				return false;
		} else if (!hobbiesId.equals(other.hobbiesId))
			return false;
		return true;
	}

	
	
}
