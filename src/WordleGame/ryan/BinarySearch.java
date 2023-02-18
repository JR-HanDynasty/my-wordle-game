package WordleGame.ryan;

public class BinarySearch {
    public static boolean binarySearch(String[] array, String target) {
        int left = 0;
        int right = array.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            int compare = compareStrings(array[mid], target);

            if (compare == 0) {
                return true;
            } else if (compare < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return false;
    }

    private static int compareStrings(String a, String b) {
        char[] aChars = a.toCharArray();
        char[] bChars = b.toCharArray();

        int i = 0;
        while (i < aChars.length && i < bChars.length) {
            int aVal = (int) aChars[i];
            int bVal = (int) bChars[i];
            if (aVal != bVal) {
                return aVal - bVal;
            }
            i++;
        }

        return aChars.length - bChars.length;
    }
}
