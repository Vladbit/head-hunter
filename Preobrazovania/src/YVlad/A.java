package YVlad;

import java.util.Scanner;
	/**���� ����� �������� ������, ������ ��� ������� ������ 2 - "��������������"
	 * @author Vlad
	 */
	public class A{
		/**
		 * ����� ��������� � ���������� ����� � ���������� �� ����������� � ������ ����  "byte"
		 * @return ������ ���� byte[]
		 */
			public byte[] readch() {
				Scanner sc = new Scanner(System.in);
				String ch1 = sc.next();
				byte[] ch = new byte[15];
				ch = ch1.getBytes();
				for (int i = 0; i < ch.length; i++)
					ch[i] = (byte) (ch[i] - 48);
				return ch;
			}
			/**
			 * ���������� 2 �����, ������� ��������� � �������� ���� byte[].
			 * @param m - byte[] 1 ����� ��� ��������� 
			 * @param n - byte[] 2 ����� ��� ���������
			 * @param sch - ����� ���������� ������������������ ��������������, ������� �� ����� �� ���� ������
			 * @return true - ���� �����1 ������ ����� 2 ,
			 * false - ���� �����1 ������ ����� 2. ���� ��� �����, �� ������� �� ����� 
			 * ����� ���������� ������������������ "sch" � ����������� ������ ���������
			 */
			public boolean comparison(byte[] m, byte[] n, int sch) {
				int count = 0;
				if (m.length == n.length) {
					for (int i = 0; i < n.length; i++) {
						if (m[i] > n[i]) {
							return true;
						} else if (m[i] < n[i]) {
							return false;
						}

					}
					System.out.println(sch);
					System.exit(0);
				} else {
					while (m[count] == 0)
						count++;
					if (m.length - count > n.length) {
						return true;
					} else {
						for (int i = 0; i < n.length; i++, count++) {
							if (m[count] > n[i]) {
								return true;
							}
							if (m[count] < n[i])
								return false;
						}

						System.out.println(sch);
						System.exit(0);

					}
				}

				return true;
			}
/**
 *���������� ��������1 ��� ������: m=m-1
 * @param m  ����� ���� byte[]
 * @return m=m-1
 */
			public byte[] step1(byte[] m) {
				int i;
				for (i = m.length - 1; m[i] == (byte) (0) && i > 0; i--) {
					m[i] = (byte) (9);
				}
				m[i] = (byte) (m[i] - 1);
				return m;
			}
			/**
			 *���������� ��������2 ��� ������: m=m-2
			 * @param m  ����� ���� byte[]
			 * @return m=m-2
			 */
			public byte[] step2(byte[] m) {

				int cf = m.length - 1;

				if (m[cf] <= 1) {
					if (m[cf] == 0) {
						m[cf] = 8;
						cf--;
					}
					if (m[cf] == 1) {
						m[cf] = 9;
						cf--;
					}
					while (m[cf] == 0) {
						m[cf] = 9;
						cf--;
					}
					m[cf] = (byte) (m[cf] - 1);
				} else {
					m[cf] = (byte) (m[cf] - 2);
				}
				return m;

			}
			/**
			 *���������� ��������3 ��� ������: m=m/2
			 * @param m  ����� ���� byte[]
			 * @return m=m/2
			 */
			public byte[] step3(byte[] m) {
				byte[] result = new byte[m.length];
				int cy = 0, count = 0;
				for (int cf = 0; cf < m.length; cf++, count++) {
					if (m[cf] == 0 && cy == 0) {
						result[count] = 0;
						continue;
					}
					if (m[cf] + cy * 10 < 2) {
						cy = 1;
						result[count] = 0;
						continue;
					} else {
						if ((m[cf] + cy * 10) % 2 == 1) {
							result[count] = (byte) ((m[cf] + cy * 10) / 2);
							cy = 1;
						} else {
							result[count] = (byte) ((m[cf] + cy * 10) / 2);
							cy = 0;
						}
					}
				}
				return result;
			}

	}
