package YVlad;

import java.util.Scanner;
/**
 * ¬ этом классе наход€тс€ методы, нужные нам дл€ решени€ задачи 1 - "“очки"
 * @author Vlad
 *
 */
public class A {
	/**
	 * ƒанный метод считывает координаты точек с клавиатуры и сохран€ет их в массив "kordinats"
	 * @param N -  оличество точек
	 * @param kordinats - массив, в котором хран€тс€ кординаты точек
	 */
		public void read(int N, int[][] kordinats) {
			System.out.println("введите кординаты точек через пробел");
			System.out.println("ѕример:ј(5,4) записываетс€ как 5 4");
			Scanner sc = new Scanner(System.in);
			for (int i = 0; i < N; i++)
				for (int j = 0; j < 2; j++)
					kordinats[i][j] = sc.nextInt();
		}


		/**
		 * ћетод вычисл€ет рассто€ние от точки до точки сохран€ет рассто€ни€ в двумерный массив "distance"
		 * @param kordinats - кординаты точек
		 * @param distance - массив, в котором хран€тс€ рассто€ни€ от точки до точки
		 * @param N - количество точек
		 */
		public void distanses(int[][] kordinats, double[][] distance, int N) {
			double min = Double.MAX_VALUE;
			for (int i = 0; i < N; i++) {
				for (int j = i; j < N; j++) {
					distance[i][j] = Math
							.sqrt(((kordinats[i][0] - kordinats[j][0]) * (kordinats[i][0] - kordinats[j][0]))
									+ ((kordinats[i][1] - kordinats[j][1]) * (kordinats[i][1] - kordinats[j][1])));
					distance[j][i] = distance[i][j];
				}
			}
		}
/**
 * ћетод отпредел€ет радиусы дл€ каждой точки 
 * @param radius - массив в котором хран€тс€ радиусы дл€ точек
 * @param distance - массив ,в котором хран€тс€ рассто€ни€ от точки до точки
 * @param N - количество точек
 */
		public void radiuses(double[] radius, double[][] distance, int N) {
			double min = Double.MAX_VALUE;
			for (int i = 0; i < N; i++) {
				min = Double.MAX_VALUE;
				for (int j = 0; j < N; j++) {
					if (distance[i][j] > 0 && distance[i][j] < min)
						min = distance[i][j];
				}
				radius[i] = min;
			}
		}
/**
 * ћетод находит ближайших соседей 
 * @param radius - массив в котором хран€тс€ радиусы дл€ точек
 * @param distance - массив ,в котором хран€тс€ рассто€ни€ от точки до точки
 * @param kordinats - массив, в котором хран€тс€ кординаты точек
 * @param N - количество точек
 */
		public void neighbors(double[] radius, double[][] distance,
				int[][] kordinats, int N) {
			for (int i = 0; i < N; i++) {
				System.out.printf("—оседи точки %d,%d с радиусом %.2f \n", kordinats[i][0],kordinats[i][1],radius[i]);
				for (int j = 0; j < N; j++) {
					if (distance[i][j] > 0
							&& distance[i][j] <= radius[i] * 2) {
						System.out.print(kordinats[j][0] + ",");
						System.out.print(kordinats[j][1] + "  ");
					}
				}
				System.out.println();
			}
		}

}
