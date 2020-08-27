package programmers.level2;

/**
 * 설명 : N/A
 *
 * @author Minkuk Jo / mingood92@gmail.com / https://velog.io/@mingood
 * @since 2020. 08. 27.
 */
@SuppressWarnings("NonAsciiCharacters")
public class 전화번호_목록 {

    public static boolean solution(String[] phoneBook) {
        for (int i = 0; i < phoneBook.length; ++i) {
            for (int j = 0; j < phoneBook.length; ++j) {
                if (i == j) continue;
                if (phoneBook[i].startsWith(phoneBook[j])) return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(solution(new String[]{"119", "97674223", "1195524421"}));
        System.out.println(solution(new String[]{"123", "456", "789"}));
        System.out.println(solution(new String[]{"12", "123", "1235", "567", "88"}));
    }

}
