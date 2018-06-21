package permitation;

public class perm {

	static int N = 4;
	static int[] sol = new int[N];
	static int[] perm = new int[N];

	static void processsolution() {
		// 솔루션 동작시 체크

		for (int i = 0; i < N; i++) {
			System.out.print(sol[i]);
		}
		System.out.print("\n");
	}

	static boolean isSolution(int n) {

		return (n == N);
	}

	static void backtrack(int n) {
		if (isSolution(n)) {
			processsolution();
			// 메소드종료 리턴
			return;
		}
		for (int i = 0; i < N; i++) {
			// 현재사용중 숫자가아닌경우
			if (perm[i] == 0) {
				// sol저장
				sol[n] = i + 1;
				// 벡터에 번호 사용중 표시
				perm[i] = 1;
				// 재귀호출
				backtrack(n + 1);

				perm[i] = 0;
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		backtrack(0);
	}

}
