package com.vogella.maven.quickstart.utilities;
import java.util.*;
import com.vogella.maven.quickstart.views.AddMember;
import static com.vogella.maven.quickstart.analytics.EventNames.*;
import static com.vogella.maven.quickstart.analytics.EventMessages.INVALID_COMMAND;

public class FamilyTreeInitializer {

	public void processInitTree(String filePath)
	{
		FileProcessor fileProcess = new FileProcessor();
		List<List<String>> command = new ArrayList<>();
		command = fileProcess.processInputFile(filePath);
		AddMember family = new AddMember();
		for(int i = 0; i<command.size();i++) {
			switch(command.get(i).get(0)) {
			case ADD_FAMILY_HEAD:
				family.addFamilyHead(command.get(i).get(1), command.get(i).get(2));
				break;
			case ADD_CHILD:
				family.addChild(command.get(i).get(1), command.get(i).get(2), command.get(i).get(3));
				break;
			case ADD_SPOUSE:
				family.addSpouse(command.get(i).get(1), command.get(i).get(2), command.get(i).get(3));
			default:
				System.out.println(INVALID_COMMAND);
			}
		}
	}
	
}
