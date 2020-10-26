package com.vogella.maven.quickstart.views;

import com.vogella.maven.quickstart.models.*;
import java.util.ArrayList;
import java.util.List;

public class SearchMember {
	public static List<String> searchInLaws(Member member, Gender gender) {
		List<String> memberList = new ArrayList<String>();
		List<String> childList = new ArrayList<String>();
		if(member.getSpouse() != null && member.getSpouse().getMother() != null) {
			childList = member.getSpouse().getMother().searchChild(gender, member.getSpouse().getName());
		}
		memberList.addAll(childList);
		childList.clear();
		if(member.getMother() != null) {
			childList = member.getMother().searchChild(gender, member.getName());
		}
		memberList.addAll(childList);
		return memberList;
	}
	
	public static Member searchMember(Member head, String memberName) {
		if(memberName == null || head == null)
			return null;
		Member member = null;
		if(memberName.equals(head.getName())) {
			return head;
		}
		else if(head.getSpouse() != null && memberName.equals(head.getSpouse().getName())) {
			return head.getSpouse();
		}
		
		List<Member> childList = new ArrayList<Member>();
		if(head.getGender() == Gender.FEMALE) {
			childList = head.getChild();
		}
		else if(head.getSpouse() != null) {
			childList = head.getSpouse().getChild();
		}
		
		for(Member person : childList) {
			member = searchMember(person, memberName);
			if(member != null) {
				break;
			}
		}
		return member;
	}
}
