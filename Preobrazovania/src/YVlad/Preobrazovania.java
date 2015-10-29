package YVlad;
/**
 * ������� �����, � ������� ���������� �������� ��� �������� ������ ������� ������������������ ��������������<br>
 * ��� ��������:<br>
 * �������� ����� M ����� �� 2 �� ��� ���, ���� � ���������� M ������ N.
 * ���� �/2 ������ N , �� ��������� �������� 2(m=m-2) � ����� M, �� ��� ���, ���� � ���������� M ������ N.<br>
 * ���� �-2 ������ N , �� ��������� �������� 1(m=m-1) � ������� ���������� ��������������, ����������� ��� M.<br>
 * ���� �� ����� - �� �� ����� M=N ,�� ����������� ���������� ��������� � ������� ���������� ��������������, ����������� ��� M
 * @author Vlad
 */
public class Preobrazovania {
	public static void main(String[] args) {
		A method= new A();
		System.out.println("������� n");
		byte[] n = method.readch();
		System.out.println("������� m");
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
