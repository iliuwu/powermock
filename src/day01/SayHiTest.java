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
		// mock出一个模拟的对象，用于代替真实的adder。
		Adder adder = mock(Adder.class);
		// Stub虚拟对象的行为，即当调用模拟对象的add方法时，抛出异常。到这里使用的都是Mockito的功能。

		// 这里powerMock开始发挥作用：当Add.class被实例化的时候，强制使用模拟对象adder代替代码中被实例化出来的对象。

		when(adder.add(anyString(), anyString())).thenThrow(new Exception());

		PowerMockito.whenNew(Adder.class).withNoArguments().thenReturn(adder);
		SayHi sh = new SayHi();

		// 这里我们看到了希望的效果：异常处理中的语句result
		assertTrue(sh.sayHi("abc", "def").equalsIgnoreCase("failed"));
		// =
		// "Failed";被执行了
	}

}
