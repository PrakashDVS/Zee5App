package com.learning.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import javax.persistence.JoinColumn;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString

@Entity
@Table(name = "food")
public class Food implements Comparable<Food> {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long foodId;
	
	@Size(max=50)
	@NotBlank
	private String foodName;
	
	//private EFOODTYPE foodType;
	private String description;
	private String foodPic;

	@Override
	public int compareTo(Food o) {
		// TODO Auto-generated method stub
		return this.foodId.compareTo(o.getFoodId());
	}
	@ManyToMany
	@JoinTable(name = "food_foodtypes", joinColumns = @JoinColumn(name = "foodId"), 
			inverseJoinColumns = @JoinColumn(name = "foodTypeId"))
	private Set<FoodType> foodTypes = new HashSet<>();

}