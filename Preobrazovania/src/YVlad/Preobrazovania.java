package YVlad;
/**
 * Главный класс, в котором реализован алгоритм для быстрого поиска кратчай последовательности преобразований<br>
 * Сам алгоритм:<br>
 * Исходное число M делим на 2 до тех пор, пока в результате M больше N.
 * Если М/2 меньше N , то применяем операцию 2(m=m-2) к числу M, до тех пор, пока в результате M больше N.<br>
 * Если М-2 меньше N , то применяем операцию 1(m=m-1) и выводим количество преобразований, проведенный над M.<br>
 * Если на каком - то из шагов M=N ,то заканчиваем выполнение программы и выводим количество преобразований, проведенный над M
 * @author Vlad
 */
public class Preobrazovania {
	public static void main(String[] args) {
		A method= new A();
		System.out.println("Введите n");
		byte[] n = method.readch();
		System.out.println("Введите m");
		byte[] m = method.readch();
		int sch = 1;
		while (method.comparison(method.step3(m), n, sch)) {
			if (m[m.length - 1] % 2 == 1) {
				m = method.step1(m);
				sch++;
			}
			m = method.step3(m);
			sch++;
		}
		while (method.comparison(method.step2(m), n, sch)) {
			m = method.step2(m);
			sch++;
		}
		if (method.comparison(m, n, sch)) {
			m = method.step1(m);
			sch++;
		}
		System.out.println( sch);

	}
}
