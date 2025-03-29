package oreillydatastructure;

public class QuadraticTimeExample {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 2, 4};
        int n = arr.length;
        // 각 요소를 다른 모든 요소와 비교합니다.
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (arr[i] == arr[j]) {
                    System.out.println("중복된 요소 발견: " + arr[i]);
                }
            }
        }
    }
}


