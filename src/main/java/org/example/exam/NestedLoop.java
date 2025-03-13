package org.example.exam;

public class NestedLoop {
    public static void main(String[] args) {

//        float i1 = oneN(10);
//        System.out.println("res= " + i1);

//        geometric(9);

//        pair(9);
//        pairGeo(9);

//        pairJ(8);

//        count(10);
//        star(15);

//        numStars(5);

//        numStarReverse(6);

//        starsTBU(6);

//        starsTBUReverse(6);
//        numTBU(6);

        numTBUI(5);
    }


    private static float oneN(float a) {
        float sum = 0;
        for (int i = 1; i <= a; i++) {
            sum += (float) 1 / (i);
        }
        return sum;
    }

    private static void geometric(int a) {

        for (int i = 0; i < a; i++) {
            for (int j = 0; j < a; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    private static void pair(int a) {

        for (int i = 0; i < a; i++) {
            for (int j = 0; j < a; j++) {
                System.out.print("(" + i + "," + j + ")");
            }
            System.out.println();
        }
    }

    private static void pairGeo(int a) {
        System.out.println();
        for (int i = 0; i < a; i++) {
            for (int j = 0; j < a; j++) {
                if (j == 0 || i == 0 || i == a - 1) {
                    System.out.print("(" + i + "," + j + ")");
                }
            }
            System.out.println();
        }
    }

    private static void pairJ(int a) {
        System.out.println();
        for (int i = 0; i < a; i++) {
            for (int j = 0; j < a; j++) {
                if (j % 2 == 0 || (i == 0)) {
                    System.out.print("(" + i + "," + j + ")");
                } else {
                    System.out.print("     ");
                }

            }
            System.out.println();
        }
    }

    private static void count(int a) {
        int count = 0;
        for (int i = 0; i < a; i++) {
            for (int j = 0; j < a; j++) {
                System.out.print(count + "       ");
                count++;
            }
            System.out.println();
        }
    }

    private static void star(int a) {
        for (int i = 0; i < a; i++) {
            for (int j = 0; j < a; j++) {
                if (i == j) {
                    System.out.println("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    private static void numStars(int a) {
        for (int i = 0; i <= a; i++) {
            for (int j = 0; j <= a; j++) {
                if (i == j) {
                    System.out.println("(" + i + "," + i + ")");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    private static void numStarReverse(int a) {
        for (int i = 0; i <= a; i++) {
            for (int j = 0; j < a; j++) {
                if (i + j == a) {
                    System.out.println("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }

    }

    private static void starsTBU(int a) {
        for (int i = 0; i < a; i++) {
            for (int j = 0; j < a; j++) {
                if (i == j || i > j) {
                    System.out.print("*");
                }
            }
            System.out.println();
        }
    }

    private static void starsTBUReverse(int a) {
        for (int i = 0; i < a; i++) {
            for (int j = 0; j < a; j++) {
                if (i == j || j > i) {
                    System.out.print("*");
                }
            }
            System.out.println();
        }
    }

    private static void numTBU(int a) {
        for (int i = 1; i < a; i++) {
            for (int j = 1; j < a; j++) {
                if (i == j || j < i) {
                    System.out.print(j);
                }
            }
            System.out.println();
        }
    }

    private static void numTBUI(int a) {
        for (int i = 1; i <= a; i++) {
            for (int j = 1; j <= a; j++) {
                if (i == j || j < i) {
                    System.out.print(i);
                }
            }
            System.out.println();
        }
    }


}
