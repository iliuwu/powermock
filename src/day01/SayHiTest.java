package day01;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.mockito.Mockito.*;



@RunWith(PowerMockRunner.class)
@PrepareForTest({ SayHi.class })

public class SayHiTest {
	@Test
	public void testSayHi() throws Exception {
		// mock��һ��ģ��Ķ������ڴ�����ʵ��adder��
		Adder adder = mock(Adder.class);
		// Stub����������Ϊ����������ģ������add����ʱ���׳��쳣��������ʹ�õĶ���Mockito�Ĺ��ܡ�

		// ����powerMock��ʼ�������ã���Add.class��ʵ������ʱ��ǿ��ʹ��ģ�����adder��������б�ʵ���������Ķ���

		when(adder.add(anyString(), anyString())).thenThrow(new Exception());

		PowerMockito.whenNew(Adder.class).withNoArguments().thenReturn(adder);
		SayHi sh = new SayHi();

		// �������ǿ�����ϣ����Ч�����쳣�����е����result
		assertTrue(sh.sayHi("abc", "def").equalsIgnoreCase("failed"));
		// =
		// "Failed";��ִ����
	}

}
