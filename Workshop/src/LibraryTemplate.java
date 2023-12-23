abstract public class LibraryTemplate {
    public abstract void add(Book book);
    public abstract void checkin(Book book, Member member, int due);
    public abstract void checkout(Book book, Member member);
    public abstract int calculateDues(Member member, int today);
}
