package YVlad;

import java.util.Scanner;
/**
 * Главный класс программы, содержащий алгоритм поиска соседей точек<br>
 * Сам алгоритм:<br>
 * 1)Вводим координаты точек<br>
 * 2)Вычисляем растояние от точки до точки и записываем эти данные в двумерный массив, что бы не терять значения<br>
 * 3)Определяем радиус для каждой точки благодаря данным, полученным из предыдущего шага<br>
 * 4)Определяем и выводим на экран соседей для каждой точки<br>
 * @author Vlad
 *
 */
public class Tochki {
	public static void main(String[] args) {
		int N = 0;
		A methods = new A();
		Scanner sc = new Scanner(System.in);
		System.out.println("Введите количестко точек ");
		N = sc.nextInt();
		int[][] kordinats = new int[N][2];
		double[][] distance = new double[N][N];
		double[] radius = new double[N];
		 methods.read(N, kordinats);
		 methods.distanses(kordinats, distance, N);
		 methods.radiuses(radius, distance, N);
		 methods.neighbors(radius, distance, kordinats, N);

	}

}
