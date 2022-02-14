package code.wars;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;


/**
 * https://www.codewars.com/kata/54bd6b4c956834c9870001a1/train/java
 *
 * @author rosen
 *
 */
public class BagelSolver {

	public static Bagel getBagel() {
		final BagelWrapper bagel = new BagelWrapper();

		try {
			System.out.println(bagel.invoke(bagel, null, null));
		} catch (final Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bagel;
	}


}

class BagelWrapper extends Bagel implements InvocationHandler {
	@Override
	public Object invoke(Object proxy, Method m, Object[] args) throws Throwable {
		return 4;
	}

}



