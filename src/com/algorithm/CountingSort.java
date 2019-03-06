package com.algorithm;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 카운팅 정렬
 */
public class CountingSort {

	public static void main(String[] args) {
//		{ 0, 4, 1, 3, 1, 2, 4, 1 }
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();	// 원소 개수
		
		int[] number = new int[N];
		int[] result = new int[N];
		int[] count = new int[10];	// 0~9 범위의 수가 입력된다고 가정
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		
		// Step1: 카운트 세기
		for (int i = 0; i < N; ++i) {
			number[i] = sc.nextInt();
			count[number[i]]++;
			
			if (number[i] < min) min = number[i];
			if (number[i] > max) max = number[i];
		}
		System.out.println("number: " + Arrays.toString(number));
		System.out.println("count: " + Arrays.toString(count));
		
		// Step2: 카운트 누적하기
		for (int i = min + 1; i <= max; ++i) {
			count[i] = count[i - 1] + count[i];
		}
		System.out.println("count: " + Arrays.toString(count));
		
		// Step3: 누적된 카운트를 이용하여 각 원소의 자리를 찾아 삽입
		for (int i = N - 1; i >= 0; --i) {
			result[count[number[i]] - 1] = number[i];
			count[number[i]]--;
		}
		System.out.println("result: " + Arrays.toString(result));
	}

}
