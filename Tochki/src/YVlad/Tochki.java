package YVlad;

import java.util.Scanner;
/**
 * ������� ����� ���������, ���������� �������� ������ ������� �����<br>
 * ��� ��������:<br>
 * 1)������ ���������� �����<br>
 * 2)��������� ��������� �� ����� �� ����� � ���������� ��� ������ � ��������� ������, ��� �� �� ������ ��������<br>
 * 3)���������� ������ ��� ������ ����� ��������� ������, ���������� �� ����������� ����<br>
 * 4)���������� � ������� �� ����� ������� ��� ������ �����<br>
 * @author Vlad
 *
 */
public class Tochki {
	public static void main(String[] args) {
		int N = 0;
		A methods = new A();
		Scanner sc = new Scanner(System.in);
		System.out.println("������� ���������� ����� ");
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
