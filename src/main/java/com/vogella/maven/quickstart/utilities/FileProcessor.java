package com.vogella.maven.quickstart.utilities;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class FileProcessor {
	
	public List<List<String>> processInputFile(String pathOfInputFile){
		File file = new File(pathOfInputFile);
		List<List<String>> inputData = new ArrayList<>();
		try(BufferedReader br = new BufferedReader(new FileReader(file))){
			String st;
			while((st = br.readLine()) != null ){
				List<String> inputArgs= Arrays.asList(st.split(" "));
				inputData.add(inputArgs);
			}
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		return inputData;
	}
}
