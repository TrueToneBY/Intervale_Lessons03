package intervale.dz3.springbookdemo.openlibrary.exceptiom;

public class OpenLibraryException extends RuntimeException {
    public OpenLibraryException(String message) {
        super(message);
    }

    @Override
    public String toString() {
        return "Exception in Open Library: " + getMessage();
    }
}
