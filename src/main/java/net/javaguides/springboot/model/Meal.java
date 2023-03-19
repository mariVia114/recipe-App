//Project: < Recipe Database >
//		* Assignment: < assignment 2 >
//		* Author(s): < Marie Pagaduan, Janine Usana, Ellyn Bibon>
//		* Student Number: < 101256979,  101328279, 101329235>
//		* Date: December 4, 2022
//		* Description: <It contains the meal model>
package net.javaguides.springboot.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "meal")
public class Meal {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String mondayBreakfast;
	private String mondayLunch;
	private String mondayDinner;
	private String tuesdayBreakfast;
	private String tuesdayLunch;
	private String tuesdayDinner;
	private String wednesdayBreakfast;
	private String wednesdayLunch;
	private String wednesdayDinner;
	private String thursdayBreakfast;
	private String thursdayLunch;
	private String thursdayDinner;
	private String fridayBreakfast;
	private String fridayLunch;
	private String fridayDinner;
	private String saturdayBreakfast;
	private String saturdayLunch;
	private String saturdayDinner;
	private String sundayBreakfast;
	private String sundayLunch;
	private String sundayDinner;
	private String createdBy;
	private Date createdAt;

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getMondayBreakfast() {
		return mondayBreakfast;
	}
	public void setMondayBreakfast(String mondayBreakfast) {
		this.mondayBreakfast = mondayBreakfast;
	}
	public String getMondayLunch() {
		return mondayLunch;
	}
	public void setMondayLunch(String mondayLunch) {
		this.mondayLunch = mondayLunch;
	}
	public String getMondayDinner() {
		return mondayDinner;
	}
	public void setMondayDinner(String mondayDinner) {
		this.mondayDinner = mondayDinner;
	}
	public String getTuesdayBreakfast() {
		return tuesdayBreakfast;
	}
	public void setTuesdayBreakfast(String tuesdayBreakfast) {
		this.tuesdayBreakfast = tuesdayBreakfast;
	}
	public String getTuesdayLunch() {
		return tuesdayLunch;
	}
	public void setTuesdayLunch(String tuesdayLunch) {
		this.tuesdayLunch = tuesdayLunch;
	}
	public String getTuesdayDinner() {
		return tuesdayDinner;
	}
	public void setTuesdayDinner(String tuesdayDinner) {
		this.tuesdayDinner = tuesdayDinner;
	}
	public String getWednesdayBreakfast() {
		return wednesdayBreakfast;
	}
	public void setWednesdayBreakfast(String wednesdayBreakfast) {
		this.wednesdayBreakfast = wednesdayBreakfast;
	}
	public String getWednesdayLunch() {
		return wednesdayLunch;
	}
	public void setWednesdayLunch(String wednesdayLunch) {
		this.wednesdayLunch = wednesdayLunch;
	}
	public String getWednesdayDinner() {
		return wednesdayDinner;
	}
	public void setWednesdayDinner(String wednesdayDinner) {
		this.wednesdayDinner = wednesdayDinner;
	}
	public String getThursdayBreakfast() {
		return thursdayBreakfast;
	}
	public void setThursdayBreakfast(String thursdayBreakfast) {
		this.thursdayBreakfast = thursdayBreakfast;
	}
	public String getThursdayLunch() {
		return thursdayLunch;
	}
	public void setThursdayLunch(String thursdayLunch) {
		this.thursdayLunch = thursdayLunch;
	}
	public String getThursdayDinner() {
		return thursdayDinner;
	}
	public void setThursdayDinner(String thursdayDinner) {
		this.thursdayDinner = thursdayDinner;
	}
	public String getFridayBreakfast() {
		return fridayBreakfast;
	}
	public void setFridayBreakfast(String fridayBreakfast) {
		this.fridayBreakfast = fridayBreakfast;
	}
	public String getFridayLunch() {
		return fridayLunch;
	}
	public void setFridayLunch(String fridayLunch) {
		this.fridayLunch = fridayLunch;
	}
	public String getFridayDinner() {
		return fridayDinner;
	}
	public void setFridayDinner(String fridayDinner) {
		this.fridayDinner = fridayDinner;
	}
	public String getSaturdayBreakfast() {
		return saturdayBreakfast;
	}
	public void setSaturdayBreakfast(String saturdayBreakfast) {
		this.saturdayBreakfast = saturdayBreakfast;
	}
	public String getSaturdayLunch() {
		return saturdayLunch;
	}
	public void setSaturdayLunch(String saturdayLunch) {
		this.saturdayLunch = saturdayLunch;
	}
	public String getSaturdayDinner() {
		return saturdayDinner;
	}
	public void setSaturdayDinner(String saturdayDinner) {
		this.saturdayDinner = saturdayDinner;
	}
	public String getSundayBreakfast() {
		return sundayBreakfast;
	}
	public void setSundayBreakfast(String sundayBreakfast) {
		this.sundayBreakfast = sundayBreakfast;
	}
	public String getSundayLunch() {
		return sundayLunch;
	}
	public void setSundayLunch(String sundayLunch) {
		this.sundayLunch = sundayLunch;
	}
	public String getSundayDinner() {
		return sundayDinner;
	}
	public void setSundayDinner(String sundayDinner) {
		this.sundayDinner = sundayDinner;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	
	@Override
	public String toString() {
		return "Meal [id=" + id + ", mondayBreakfast=" + mondayBreakfast + ", mondayLunch=" + mondayLunch
				+ ", mondayDinner=" + mondayDinner + ", tuesdayBreakfast=" + tuesdayBreakfast + ", tuesdayLunch="
				+ tuesdayLunch + ", tuesdayDinner=" + tuesdayDinner + ", wednesdayBreakfast=" + wednesdayBreakfast
				+ ", wednesdayLunch=" + wednesdayLunch + ", wednesdayDinner=" + wednesdayDinner + ", thursdayBreakfast="
				+ thursdayBreakfast + ", thursdayLunch=" + thursdayLunch + ", thursdayDinner=" + thursdayDinner
				+ ", fridayBreakfast=" + fridayBreakfast + ", fridayLunch=" + fridayLunch + ", fridayDinner="
				+ fridayDinner + ", saturdayBreakfast=" + saturdayBreakfast + ", saturdayLunch=" + saturdayLunch
				+ ", saturdayDinner=" + saturdayDinner + ", sundayBreakfast=" + sundayBreakfast + ", sundayLunch="
				+ sundayLunch + ", sundayDinner=" + sundayDinner + ", createdBy=" + createdBy + ", createdAt="
				+ createdAt + "]";
	}

}
