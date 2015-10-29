package YVlad;

import java.util.Scanner;
	/**Ётот класс содержит методы, нужные дл€ решени€ задачи 2 - "ѕреобразовани€"
	 * @author Vlad
	 */
	public class A{
		/**
		 * ћетод считывает с клавиатуры число и записывает их посимвольно в массив типа  "byte"
		 * @return массив типа byte[]
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
			 * —равнивает 2 числа, которые наход€тс€ в массивах типа byte[].
			 * @param m - byte[] 1 число дл€ сравнени€ 
			 * @param n - byte[] 2 число дл€ сравнени€
			 * @param sch - ƒлина кратчайшей последовательности преобразований, которую мы нашли на этот момент
			 * @return true - если число1 больше числа 2 ,
			 * false - если число1 меньше числа 2. ≈сли они равны, то выводит на экран 
			 * длину кратчайшей последовательности "sch" и заканчивает работу программы
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
 *ѕроизводит операцию1 над числом: m=m-1
 * @param m  число типа byte[]
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
			 *ѕроизводит операцию2 над числом: m=m-2
			 * @param m  число типа byte[]
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
			 *ѕроизводит операцию3 над числом: m=m/2
			 * @param m  число типа byte[]
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
