package day02;

import java.io.File;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import junit.framework.Assert;

//powerMock方法内部new出来的对象

@RunWith(PowerMockRunner.class)
public class TestClassUnderTest {
	@Test
	@PrepareForTest(ClassUnderTest.class)
	public void testCallInternalInstance() throws Exception{
		File file = PowerMockito.mock(File.class);
		ClassUnderTest underTest = new ClassUnderTest()	;
		PowerMockito.whenNew(File.class).withArguments("bbb").thenReturn(file);
		PowerMockito.when(file.exists()).thenReturn(true);
	//	Assert.assertTrue(underTest.callInternalInstance("bbb"));
//		Assert.assertFalse(underTest.callInternalInstance("bbb"));
		if (underTest.callInternalInstance("bbb") == false)
		{
			System.out.println("liuwu");
		}
	}
}
