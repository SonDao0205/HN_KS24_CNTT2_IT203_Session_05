import java.util.Scanner;

public class Main {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            int[] array;
            int n;
            String input;
            System.out.println("------------------------Menu---------------------------");
            System.out.println("1. [FR1] Tìm cặp số có tổng bằng K (Two Sum)");
            System.out.println("2. [FR2] Dồn số 0 về cuối (Move Zeroes)");
            System.out.println("3. [FR3] Kiểm tra chuỗi đối xứng (Valid Palindrome)");
            System.out.println("4. [FR4] Đảo ngược từ trong câu (Reverse Words)");
            System.out.println("5. [FR5] Số hạnh phúc (Happy Number)");
            System.out.println("0. Thoát");
            System.out.println("-------------------------------------------------------");
            System.out.print("Nhập lựa chọn của bạn : ");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    int target;
                    System.out.print("Nhập số lượng của mảng : ");
                    n = sc.nextInt();
                    array = new int[n];
                    for ( int i = 0; i < n; i++ ) {
                        System.out.printf("Nhập phần tử vị trí thứ %d : ",i);
                        array[i] = sc.nextInt();
                    }
                    System.out.print("Nhập số nguyên target : ");
                    target = sc.nextInt();
                    twoSum(array,target,n);
                    break;
                case 2:
                    System.out.print("Nhập số lượng của mảng : ");
                    n = sc.nextInt();
                    array = new int[n];
                    for ( int i = 0; i < n; i++ ) {
                        System.out.printf("Nhập phần tử vị trí thứ %d : ",i);
                        array[i] = sc.nextInt();
                    }
                    moveZero(array,n);
                    break;
                case 3:
                    sc.nextLine();
                    System.out.print("Nhập một câu bất kỳ : ");
                    input = sc.nextLine();
                    boolean isValid = validPalindrome(input);
                    if (isValid) {
                        System.out.println("Đây là chuỗi đối xứng!");
                    }else{
                        System.out.println("Đây không phải chuỗi đối xứng!");
                    }
                    break;
                case 4:
                    sc.nextLine();
                    System.out.print("Nhập 1 chuỗi : ");
                    input = sc.nextLine();
                    String result = reverseWords(input);
                    System.out.println("Chuỗi đã đảo ngược : " + result);
                    break;
                case 5:
                    System.out.print("Nhập số nguyên dương : ");
                    n = sc.nextInt();
                    happyNumber(n);
                    break;
                case 0:
                    System.out.println("Đã thoát!");
                    break;
                default:
                    System.out.println("Lựa chọn không phù hợp!");
                    break;
            }
        } while (choice != 0);
    }

    static public void twoSum(int[] array, int target,int n){
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(array[i]+array[j] == target){
                    System.out.printf("[%d, %d]\n",i,j);
                    return;
                }
            }
        }
        System.out.println("Không tìm thấy chỉ số!");
    }

    static public void moveZero(int[] array,int n){
        int pos = 0;
        for (int i = 0; i < n; i++) {
            if (array[i] != 0) {
                array[pos] = array[i];
                pos++;
            }
        }
        for (int i = pos; i < n; i++) {
            array[i] = 0;
        }
        printArray(array);
    }

    static public void printArray(int[] array){
        for (int i = 0; i < array.length; i++) {
            System.out.printf("array[%d] = %d\n",i,array[i]);
        }
    }

    static public boolean validPalindrome(String input){
        String regex = "[^a-zA-Z]";
        String cleanString =  input.replaceAll(regex, "").toLowerCase();
        System.out.println("clean string : "+ cleanString);
        int length = cleanString.length();
        for (int i = 0; i < length; i++) {
            if (cleanString.charAt(i) != cleanString.charAt(length - i - 1)) {
                return false;
            }
        }
        return true;
    }

    static public String reverseWords(String input){
        String[] words = input.trim().split("\\s+");
        StringBuilder sb = new StringBuilder();
        for (int i = words.length - 1; i >= 0 ; i--) {
            sb.append(words[i]);
            if(i != 0){
                sb.append(" ");
            }
        }
        return sb.toString();
    }

    static public void happyNumber(int n){
        int temp = n;
        while(n != 1 && n != 4){
            n = sumSquare(n);
        }

        if(n == 1){
            System.out.printf("%d Là số hạnh phúc\n",temp);
        }else{
            System.out.printf("%d không phải số hạnh phúc!\n",temp);
        }
    }

    static public int sumSquare(int n){
        int sum = 0;
        int count = 0;
        while(n > 0){
            count++;
            int digit = n % 10;
            sum += digit*digit;
            n /= 10;
//            System.out.printf("count : %d, digit : %d, sum : %d, n : %d\n",count, digit,sum,n);
        }
        return sum;
    }
}
