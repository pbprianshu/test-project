package com.vogella.maven.quickstart.models;

import java.util.*;

public class Member {
	String name;
	Gender gender;
	Member mother;
	Member father;
	Member spouse;
	
	List<Member> children;
	
	public Member(String name, Gender gender, Member father, Member mother) {
		this.name = name;
		this.gender = gender;
		this.mother = mother;
		this.father = father;
		this.spouse = null;
		this.children = new ArrayList<Member>();
	}
	
	public String getName() {
		return this.name;
	}
	
	public Gender getGender() {
		return this.gender;
	}
	
	public Member getMother() {
		return this.mother;
	}
	
	public Member getFather() {
		return this.father;
	}
	
	public void setChild(Member child) {
		this.children.add(child);
	}
	
	public List<Member> getChild(){
		return this.children;
	}
	
	public Member getSpouse() {
		return this.spouse;
	}
	
	public void setSpouse(Member spouse) {
		this.spouse = spouse;
	}
	
	public List<String> searchChild(Gender gender) {
		List<String> child = new ArrayList<String>();
		for(Member member: this.children) {
			if(member.getGender() == gender) {
				child.add(member.getName());
			}
		}
		return child;
	}
	
	public List<String> searchSibling(){
		List<String> siblings = new ArrayList<String>();
		if(this.mother != null) {
			for(Member member: this.mother.getChild()) {
				if(this.name.equals(member.getName())) {
					siblings.add(member.getName());
				}
			}
		}
		return siblings;
	}
	
	public List<String> searchChild(Gender gender, String name){
		List<String> child = new ArrayList<String>();
		for(Member member: this.children) {
			if(!name.equals(member.getName()) && member.getGender() == gender) {
				child.add(member.getName());
			}
		}
		return child;
	}
	
	public List<String> searchAuntOrUncle(Gender gender){
		List<String> relative = new ArrayList<String>();
		if(this.mother != null) {
			for(Member member : this.mother.getChild()) {
				if(!this.name.equals(member.getName()) && member.getGender() == gender) {
					relative.add(member.getName());
				}
			}
		}
		return relative;
	}
	
}
