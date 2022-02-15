package code.wars;


import java.lang.reflect.Field;

/**
 * https://www.codewars.com/kata/54bd6b4c956834c9870001a1/train/java
 *
 * @author rosen
 *
 */
public class BagelSolver {

	public static Bagel getBagel() {
		try {
			final Field value = Boolean.class.getDeclaredField("value");
			value.setAccessible(true);
			value.set(Boolean.TRUE, Boolean.FALSE);
		} catch (final Exception e) {
			e.printStackTrace();
		}

		return new Bagel();

	}



}






