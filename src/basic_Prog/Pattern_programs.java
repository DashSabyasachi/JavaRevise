package basic_Prog;

public class Pattern_programs {
	public static void main(String[] args) {
		int n = 5;

		// 1. Square
		//  * * * * *
		//  * * * * *
		//  * * * * *
		//  * * * * *
		//  * * * * *
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }

        System.out.println("_____________________________");

        // 2. Right Triangle
    	//  *
    	//  * *
    	//  * * *
    	//  * * * *
        //  * * * * *
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }

        System.out.println("_____________________________");

        // 3. Inverted Right Triangle
		//  * * * * *
		//  * * * *
		//  * * *
		//  * *
		//  *
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n - i + 1; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }

        System.out.println("_____________________________");

        // 4. Pyramid Pattern
        //      *
        //     * *
        //    * * *
        //   * * * *
        //  * * * * *
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n - i; j++) {
                System.out.print("  ");
            }
            for (int k = 1; k <= i; k++) {
                System.out.print("* ");
            }
            System.out.println();
        }

        System.out.println("_____________________________");

        // 5. Inverted Pyramid
        //  * * * * *
        //   * * * *
        //    * * *
        //     * *
        //      *
        for (int i = n; i >= 1; i--) {
            for (int j = 1; j <= n - i; j++) {
                System.out.print("  ");
            }
            for (int k = 1; k <= i; k++) {
                System.out.print("* ");
            }
            System.out.println();
        }

        System.out.println("_____________________________");

        // 6. Diamond Pattern (Pyramid + Inverted Pyramid, no repeated middle row)
        //      *
        //     * *
        //    * * *
        //   * * * *
        //  * * * * *
        //   * * * *
        //    * * *
        //     * *
        //      *
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n - i; j++) {
                System.out.print("  ");
            }
            for (int k = 1; k <= i; k++) {
                System.out.print("* ");
            }
            System.out.println();
        }
        for (int i = n - 1; i >= 1; i--) {
            for (int j = 1; j <= n - i; j++) {
                System.out.print("  ");
            }
            for (int k = 1; k <= i; k++) {
                System.out.print("* ");
            }
            System.out.println();
        }

        System.out.println("_____________________________");

        // 7. Number Triangle
        //  1
        //  1 2
        //  1 2 3
        //  1 2 3 4
        //  1 2 3 4 5
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j + " ");
            }
            System.out.println();
        }

        System.out.println("_____________________________");

        // 8. Floyd's Triangle
        //  1
        //  2 3
        //  4 5 6
        //  7 8 9 10
        //  11 12 13 14 15
        int num = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(num + " ");
                num++;
            }
            System.out.println();
        }

        System.out.println("_____________________________");

        // 9. Pascal's Triangle
        //      1
        //     1 1
        //    1 2 1
        //   1 3 3 1
        //  1 4 6 4 1
        for (int i = 0; i < n; i++) {
            for (int s = 0; s < n - i; s++) {
                System.out.print("  ");
            }
            int val = 1;
            for (int j = 0; j <= i; j++) {
                System.out.print(val + " ");
                val = val * (i - j) / (j + 1);
            }
            System.out.println();
        }

        System.out.println("_____________________________");

        // 10. Character Triangle
        //  A
        //  A B
        //  A B C
        //  A B C D
        //  A B C D E
        for (int i = 0; i < n; i++) {
            char ch = 'A';
            for (int j = 0; j <= i; j++) {
                System.out.print(ch + " ");
                ch++;
            }
            System.out.println();
        }

        System.out.println("_____________________________");

        // 11. Hollow Square
        //  * * * * *
        //  *       *
        //  *       *
        //  *       *
        //  * * * * *
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == 1 || i == n || j == 1 || j == n) {
                    System.out.print("* ");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }

        System.out.println("_____________________________");

        // 12. Hollow Pyramid
        //      *
        //     * *
        //    *   *
        //   *     *
        //  * * * * *
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n - i; j++) {
                System.out.print("  ");
            }
            for (int k = 1; k <= i; k++) {
                if (k == 1 || k == i || i == n) {
                    System.out.print("* ");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }

        System.out.println("_____________________________");

        // 13. Butterfly Pattern
        //  *        *
        //  * *    * *
        //  * * *  * * *
        //  * * * ** * * *
        //  * * *  * * *
        //  * *    * *
        //  *        *
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            for (int j = 1; j <= 2 * (n - i); j++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        for (int i = n; i >= 1; i--) {
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            for (int j = 1; j <= 2 * (n - i); j++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

        System.out.println("_____________________________");

	}
}