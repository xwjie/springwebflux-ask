package io.github.xwjie;

public class User{
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    private long id;

    public User(long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        return Long.hashCode(this.id);
    }

    @Override
    public boolean equals(Object anObject) {
        if (this == anObject) {
            return true;
        }

        if (anObject instanceof User) {
            User anotherUser = (User)anObject;
            return this.id == anotherUser.id;
        }

        return false;
    }
}