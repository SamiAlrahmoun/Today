package fr.alma.today;

public class Account {
    String id;
    boolean closed;

    public Account() {
    }

    public Account(String id, boolean closed) {
        this.id = id;
        this.closed = closed;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean isClosed() {
        return closed;
    }

    public void setClosed(boolean closed) {
        this.closed = closed;
    }
}
