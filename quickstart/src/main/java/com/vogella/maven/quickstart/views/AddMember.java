package com.vogella.maven.quickstart.views;

import static com.vogella.maven.quickstart.analytics.RelationshipNames.FEMALE;
import static com.vogella.maven.quickstart.analytics.EventMessages.*;
import com.vogella.maven.quickstart.models.Member;
import com.vogella.maven.quickstart.models.Gender;


public class AddMember {
private Member familyHead;
	
	public void addFamilyHead(String name, String gender) {
		Gender genderFamilyHead = (FEMALE.equals(gender)) ? Gender.FEMALE : Gender.MALE;
		this.familyHead = new Member(name, genderFamilyHead, null, null);
	}
	public void addSpouse(String spouseName, String memberName, String gender) {
		Member member = SearchMember.searchMember(familyHead, memberName);
		if(member != null && member.getSpouse() == null) {
			Gender genderMember = (FEMALE.equals(gender)) ? Gender.FEMALE : Gender.MALE;
			Member spouse = new Member(spouseName, genderMember, null, null);
			spouse.setSpouse(member);
			member.setSpouse(spouse);
		}
	}
	
	public String addChild(String motherName, String childName, String gender) {
		String result;
		Member member = SearchMember.searchMember(familyHead, motherName);
		if(member == null)
			result = PERSON_NOT_FOUND;
		else if(childName == null || gender == null)
			result = CHILD_ADDITION_FAILED;
		else if(member.getGender() == Gender.FEMALE) {
			Gender genderChild = (FEMALE.equals(gender)) ? Gender.FEMALE : Gender.MALE;
			Member child = new Member(childName, genderChild, member.getSpouse(), member);
			member.setChild(child);
			result = CHILD_ADDITION_SUCCEEDED;
		}
		else {
			result = CHILD_ADDITION_FAILED;
		}
		return result;
	}
}
