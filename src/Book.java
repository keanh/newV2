public class Book {
    public int bookCode;
    public String name;
    public long price;
    public String author;
    //static Book[] list = new Book[10];
    //static int index = 0;

    public Book() {

    }

    public int getBookCode() {
        return bookCode;
    }

    public void setBookCode(int bookCode) {
        this.bookCode = bookCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String toString(){
        return "Tên sách " + this.name + " giá " + this.price;
    }

    public Book(int bookCode, String name, long price, String author) {
        this.bookCode = bookCode;
        this.name = name;
        this.price = price;
        this.author = author;
        //add(this);
    }

//    public void add(Book book) {
//        if (index < list.length) {
//                list[index] = book;
//                index++;
//        }
//    }
}
