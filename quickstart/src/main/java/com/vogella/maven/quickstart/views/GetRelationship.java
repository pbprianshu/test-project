package com.vogella.maven.quickstart.views;

import static com.vogella.maven.quickstart.analytics.EventMessages.*;
import static com.vogella.maven.quickstart.analytics.RelationshipNames.*;

import java.util.ArrayList;
import java.util.List;

import com.vogella.maven.quickstart.models.Gender;

import com.vogella.maven.quickstart.models.Member;
public class GetRelationship {
	
	private Member familyHead;
	
	public List<String> getRelationship(String person, String relationship) {
		List<String> relation  = new ArrayList<>();
		Member member = SearchMember.searchMember(familyHead, person);
		if( member == null)
			relation.add(PERSON_NOT_FOUND);
		else if(relationship == null)
			relation.add(PROVIDE_VALID_RELATION);
		else {
			relation = getRelationship(member,relationship);
		}
			
		return relation;
	}
	
	public List<String> getRelationship(Member member, String relationship) {
		List<String> relation  = new ArrayList<>();
		
		switch(relationship){
			case DAUGHTER:
				relation = member.searchChild(Gender.FEMALE);
				break;
			case SON:
				relation = member.searchChild(Gender.MALE);
				break;
			case SIBLINGS:
				relation = member.searchSibling();
				break;
			case SISTER_IN_LAW:
				relation = SearchMember.searchInLaws(member, Gender.FEMALE);
				break;
			case BROTHER_IN_LAW:
				relation = SearchMember.searchInLaws(member, Gender.MALE);
				break;
			case MATERNAL_AUNT:
				if(member.getMother() != null)
					relation = member.getMother().searchAuntOrUncle(Gender.FEMALE);
				break;
			case PATERNAL_AUNT:
				if(member.getFather() != null)
					relation = member.getFather().searchAuntOrUncle(Gender.FEMALE);
				break;
			case MATERNAL_UNCLE:
				if(member.getMother() != null)
					relation = member.getMother().searchAuntOrUncle(Gender.MALE);
				break;
			case PATERNAL_UNCLE:
				if(member.getFather() != null)
					relation = member.getFather().searchAuntOrUncle(Gender.MALE);
				break;
			default:
				relation.add(NOT_YET_IMPLEMENTED);
				break;
				
		}	
		if(relation.isEmpty())
			relation.add(NONE);
		return relation;
		
	}
}
