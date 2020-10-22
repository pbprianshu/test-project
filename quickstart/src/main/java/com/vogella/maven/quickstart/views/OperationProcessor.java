package com.vogella.maven.quickstart.views;

import java.util.List;
import com.vogella.maven.quickstart.models.Member;
public interface OperationProcessor {
	
	void processOperation(List<String> args, Member member);
}
