import java.util.Scanner;

public class Session_05_Exam {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;
        String[] array = new String[100];
        int n = 0;
        String regex = "^B\\d{7}$";
        do {
            int index = -1;
            String studentId;
            System.out.println("--------------------Menu------------------");
            System.out.println("1. Hiển thị");
            System.out.println("2. Thêm mới");
            System.out.println("3. Cập nhật");
            System.out.println("4. Xóa");
            System.out.println("5. Tìm kiếm");
            System.out.println("6. Thoát");
            System.out.println("------------------------------------------");
            System.out.print("Nhập lựa chọn : ");
            choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:

                    System.out.println("Danh sách MSSV : ");
                    if(n == 0){
                        System.out.println("Trống");
                    }else{
                        for (int i = 0; i < n; i++){
                            System.out.printf("%d, %s\n",i, array[i]);
                        }
                    }


                    break;
                case 2:
                    do {
                        System.out.print("Nhập MSSV mới : ");
                        studentId = sc.nextLine();
                        if(!studentId.matches(regex)){
                            System.out.println("Mã sinh viên không hợp lệ, Nhập lại!");
                        }
                    }while (!studentId.matches(regex));
                    array[n] = studentId;
                    n++;
                    System.out.println("Thêm mã sinh viên thành công!");
                    break;
                case 3:
                    System.out.print("Nhập vị tri cần sửa : ");
                    index = sc.nextInt();
                    sc.nextLine();
                    if(index < 0 || index >= n){
                        System.out.println("Index không hợp lệ!");
                    }else{
                        System.out.println("Nhập MSSV mới để cập nhật : ");
                        studentId = sc.nextLine();
                        if(!studentId.matches(regex)){
                            System.out.println("Mã sinh viên không hợp lệ!");
                            System.out.println("Cập nhật thất bại!");
                            break;
                        }
                        array[index] = studentId;
                        System.out.println("Cập nhật thành công!");
                    }
                    break;
                case 4:
                    System.out.print("Nhập MSSV muốn xoá : ");
                    studentId = sc.nextLine();
                    for(int i = 0; i < n; i++){
                        if(array[i].equals(studentId)){
                            index = i;
                        }
                    }
                    if(index == -1){
                        System.out.println("Không tìm thấy MSSV!");
                    }else{
                        for (int i = index; i < n - 1; i++){
                            array[i] = array[i + 1];
                        }
                        n--;
                        System.out.println("Xoá MSSV thành công!");
                    }
                    break;
                case 5:
                    String search;
                    System.out.println("Nhập chuỗi ký tự : ");
                    search = sc.nextLine();
                    for(int i = 0; i < n; i++){
                        String temp1 = search.toLowerCase().trim();
                        String temp2 = array[i].toLowerCase().trim();
                        if(temp2.contains(temp1)){
                            System.out.printf("MSSV : %s\n",array[i]);
                        }
                    }
                    break;
                case 6:
                    System.out.println("Đã thoát!");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
                    break;
            }

        } while (choice != 6);
    }
}
