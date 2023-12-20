import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.Iterator;

public class TypedCollectionTest {

    @Test
    public void testSize() {
        TypedCollection collection = new TypedCollection();
        assertEquals(0, collection.size());
    }

    @Test
    public void testAdd() {
        TypedCollection collection = new TypedCollection();
        collection.add(new MusicComposition("Title1", "Artist1", 200, "Style1"));
        assertEquals(1, collection.size());
    }

    @Test
    public void testAddAll() {
        TypedCollection collection = new TypedCollection();

        ArrayList<MusicComposition> compositions = new ArrayList<>(15);
        compositions.add(new MusicComposition("Title1", "Artist1", 200, "Style1"));
        compositions.add(new MusicComposition("Title2", "Artist2", 250, "Style2"));

        collection.addAll(compositions);
        assertEquals(2, collection.size());
    }

    @Test
    public void testContains() {
        TypedCollection collection = new TypedCollection();
        assertFalse(collection.contains(new Object()));
        collection.add(new MusicComposition("Title1", "Artist1", 200, "Style1"));
        assertTrue(collection.contains(new MusicComposition("Title1", "Artist1", 200, "Style1")));
    }

    @Test
    public void testContainsAll() {
        TypedCollection collection = new TypedCollection();
        ArrayList<MusicComposition> compositions = new ArrayList<>(15);
        assertTrue(collection.containsAll(compositions));
        collection.add(new MusicComposition("Title1", "Artist1", 200, "Style1"));
        compositions.add(new MusicComposition("Title1", "Artist1", 200, "Style1"));
        assertTrue(collection.containsAll(compositions));
    }

    @Test
    public void testIterator() {
        TypedCollection collection = new TypedCollection();
        Iterator<MusicComposition> iterator = collection.iterator();
        assertFalse(iterator.hasNext());
        collection.add(new MusicComposition("Title1", "Artist1", 200, "Style1"));
        assertTrue(iterator.hasNext());
        assertEquals(new MusicComposition("Title1", "Artist1", 200, "Style1"), iterator.next());
        assertFalse(iterator.hasNext());
    }

    @Test
    public void testToArray() {
        TypedCollection collection = new TypedCollection();
        assertArrayEquals(new MusicComposition[15], collection.toArray());
        collection.add(new MusicComposition("Title1", "Artist1", 200, "Style1"));
        MusicComposition[] compositions = new MusicComposition[15];
        compositions[0] = new MusicComposition("Title1", "Artist1", 200, "Style1");
        assertArrayEquals(compositions, collection.toArray());
    }

    @Test
    public void testRemove() {
        TypedCollection collection = new TypedCollection();
        collection.add(new MusicComposition("Title1", "Artist1", 200, "Style1"));
        collection.remove(new MusicComposition("Title1", "Artist1", 200, "Style1"));
        assertEquals(0, collection.size());
    }

    @Test
    public void testRemoveAll() {
        TypedCollection collection = new TypedCollection();
        collection.add(new MusicComposition("Title1", "Artist1", 200, "Style1"));
        collection.add(new MusicComposition("Title2", "Artist2", 250, "Style2"));
        collection.add(new MusicComposition("Title3", "Artist3", 300, "Style3"));
        ArrayList<MusicComposition> compositions = new ArrayList<>(15);
        compositions.add(new MusicComposition("Title1", "Artist1", 200, "Style1"));
        compositions.add(new MusicComposition("Title2", "Artist2", 250, "Style2"));
        collection.removeAll(compositions);
        assertEquals(1, collection.size());
    }

    @Test
    public void testRetainAll() {
        TypedCollection collection = new TypedCollection();
        collection.add(new MusicComposition("Title1", "Artist1", 200, "Style1"));
        collection.add(new MusicComposition("Title2", "Artist2", 250, "Style2"));
        ArrayList<MusicComposition> compositions = new ArrayList<>(15);
        compositions.add(new MusicComposition("Title1", "Artist1", 200, "Style1"));
        collection.retainAll(compositions);
        assertEquals(1, collection.size());
    }

    @Test
    public void testClear() {
        TypedCollection collection = new TypedCollection();
        collection.add(new MusicComposition("Title1", "Artist1", 200, "Style1"));
        collection.add(new MusicComposition("Title2", "Artist2", 250, "Style2"));
        collection.clear();
        assertEquals(0, collection.size());
    }
}
