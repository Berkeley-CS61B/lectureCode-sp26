package lec9_inheritance1;

public interface List61B<Blorp> {
    public void insert(Blorp item, int position);
    public void addFirst(Blorp x);
    public void addLast(Blorp x);
    public Blorp getFirst();
    public Blorp getLast();
    public Blorp get(int i);
    public int size();
    public Blorp removeLast();
    public default void print() {
        for (int i = 0; i < size(); i += 1) {
            IO.println(get(i));
        }
    }
}