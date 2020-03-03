public class ProgrammingBook extends Book {
    public String language = "Java";
    public String framework = null;

    public ProgrammingBook(int bookCode, String name, long price, String author) {
        super(bookCode, name, price, author);
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getFramework() {
        return framework;
    }

    public void setFramework(String framework) {
        this.framework = framework;
    }
}
