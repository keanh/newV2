import java.util.ArrayList;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        ArrayList<Book> bookList = new ArrayList<>();
        ProgrammingBook programmingBook1 = new ProgrammingBook(1, "book1", 5, "Kế Anh");
        ProgrammingBook programmingBook2 = new ProgrammingBook(2, "book2", 10, "Kế Anh");
        ProgrammingBook programmingBook3 = new ProgrammingBook(3, "book3", 20, "Kế Anh");
        FictionBook fictionBook1 = new FictionBook(4, "book4", 30, "Kế Anh", "Trinh thám");
        FictionBook fictionBook2 = new FictionBook(5, "book5", 15, "Kế Anh", "Ngôn lù");
        FictionBook fictionBook3 = new FictionBook(6, "book6", 40, "Kế Anh", "Hành động");

        bookList.add(programmingBook1);
        bookList.add(programmingBook2);
        bookList.add(programmingBook3);
        bookList.add(fictionBook1);
        bookList.add(fictionBook2);
        bookList.add(fictionBook3);
//        long totalOfMoney = 0;
//        for (int i=0;i<Book.index;i++){
//            totalOfMoney += Book.list[i].price;
//        }
//        System.out.println("Tổng số tiền: "+totalOfMoney);
//
//        int count = 0;
//        for (int i=0;i<Book.index;i++){
//            boolean isProgrammingBook = Book.list[i] instanceof  ProgrammingBook;
//            if (isProgrammingBook){
//                boolean isJavaBook = ((ProgrammingBook) Book.list[i]).language.equals("Java");
//                if(isJavaBook){
//                    count++;
//                }
//            }
//        }
//        System.out.println("Số sách Java là: " + count);
        System.out.println(bookList);
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        searchBook(input,bookList);
        bubbleSort(bookList);
        selectionSort(bookList);
        insertionSort(bookList);
        System.out.println("Sắp xếp theo tên:");
        insertionSortByName(bookList);
        long result =  binarySearch(bookList,"book3");
        if (result == -1){
            System.out.println("Không tìm thấy");
        }else{
            System.out.println("Giá của quyển sách là: " + result);
        }
    }

    public static void searchBook(String name,ArrayList<Book> bookList){
        for (Book book : bookList) {
            if (book.name.equals(name)){
                System.out.println("Giá tiền là: " + book.price);
            }
        }
    }

    public static void bubbleSort(ArrayList<Book> bookList){
        boolean needNextPass = true;

        for (int k = 1; k < bookList.size() && needNextPass; k++) {
            needNextPass = false;
            for (int i = 0; i < bookList.size() - k; i++) {
                if (bookList.get(i).price > bookList.get(i+1).price) {
                    Book temp = bookList.get(i);
                    bookList.set(i, bookList.get(i + 1));
                    bookList.set(i+1,temp);

                    needNextPass = true;
                }
            }
        }

        System.out.println("Bubble Sort:");
        for (Book book:bookList){
            System.out.println(book);
        }
    }

    public static void selectionSort(ArrayList<Book> bookList){
        for (int i =0; i<bookList.size() - 1;i++){
            Book currentBook = bookList.get(i);
            long currentMin = bookList.get(i).price;
            int currentMinIndex = i;
            for (int j = i + 1; j<bookList.size();j++){
                if (currentMin > bookList.get(j).price){
                    currentBook = bookList.get(j);
                    currentMin = bookList.get(j).price;
                    currentMinIndex = j;
                }
            }

            if (currentMinIndex != i){
                bookList.set(currentMinIndex,bookList.get(i));
                bookList.set(i,currentBook);
            }
        }

        System.out.println("Selection Sort: ");
        for (Book book:bookList){
            System.out.println(book);
        }
    }

    public static void insertionSort(ArrayList<Book> bookList){
        int n = bookList.size();
        for (int i=0; i< n;i++){
            Book currentBook = bookList.get(i);
            long key = bookList.get(i).price;
            int j = i -1;
            while (j >= 0 && bookList.get(j).price > key){
                bookList.set(j+1,bookList.get(j));
                j--;
            }
            bookList.set(j+1,currentBook);
        }

        System.out.println("Insertion Sort:");
        for (Book book:bookList){
            System.out.println(book);
        }
    }

    public static void insertionSortByName(ArrayList<Book> bookList){
        int n = bookList.size();
        for (int i=0; i< n;i++){
            Book currentBook = bookList.get(i);
            String key = bookList.get(i).name;
            int j = i -1;
            while (j >= 0 && bookList.get(j).name.compareTo(key) > 0){
                bookList.set(j+1,bookList.get(j));
                j--;
            }
            bookList.set(j+1,currentBook);
        }
        for (Book book:bookList){
            System.out.println(book);
        }
    }

    public static long binarySearch(ArrayList<Book> bookList,String name){
        int low = 0;
        int high = bookList.size()-1;
        while (high >= low){
            int mid = (low+high)/2;
            if (bookList.get(mid).name.compareTo(name) > 0){
                high = mid - 1;
            }else if (bookList.get(mid).name.compareTo(name) < 0){
                low = high + 1;
            }else{
                return bookList.get(mid).price;
            }
        }
        return -1;
    }
 }
