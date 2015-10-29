package YVlad;

import java.util.Scanner;
/**
 * � ���� ������ ��������� ������, ������ ��� ��� ������� ������ 1 - "�����"
 * @author Vlad
 *
 */
public class A {
	/**
	 * ������ ����� ��������� ���������� ����� � ���������� � ��������� �� � ������ "kordinats"
	 * @param N - ���������� �����
	 * @param kordinats - ������, � ������� �������� ��������� �����
	 */
		public void read(int N, int[][] kordinats) {
			System.out.println("������� ��������� ����� ����� ������");
			System.out.println("������:�(5,4) ������������ ��� 5 4");
			Scanner sc = new Scanner(System.in);
			for (int i = 0; i < N; i++)
				for (int j = 0; j < 2; j++)
					kordinats[i][j] = sc.nextInt();
		}


		/**
		 * ����� ��������� ���������� �� ����� �� ����� ��������� ���������� � ��������� ������ "distance"
		 * @param kordinats - ��������� �����
		 * @param distance - ������, � ������� �������� ���������� �� ����� �� �����
		 * @param N - ���������� �����
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
 * ����� ����������� ������� ��� ������ ����� 
 * @param radius - ������ � ������� �������� ������� ��� �����
 * @param distance - ������ ,� ������� �������� ���������� �� ����� �� �����
 * @param N - ���������� �����
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
 * ����� ������� ��������� ������� 
 * @param radius - ������ � ������� �������� ������� ��� �����
 * @param distance - ������ ,� ������� �������� ���������� �� ����� �� �����
 * @param kordinats - ������, � ������� �������� ��������� �����
 * @param N - ���������� �����
 */
		public void neighbors(double[] radius, double[][] distance,
				int[][] kordinats, int N) {
			for (int i = 0; i < N; i++) {
				System.out.printf("������ ����� %d,%d � �������� %.2f \n", kordinats[i][0],kordinats[i][1],radius[i]);
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
