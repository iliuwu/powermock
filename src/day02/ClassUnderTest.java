package day02;

import java.io.File;

public class ClassUnderTest {
	public boolean callInternalInstance(String path) {
		File file = new File(path);
	
		return file.exists();
	}

}
