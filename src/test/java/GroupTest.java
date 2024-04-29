import com.example.familyconnect.Group;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;


import java.util.List;
import java.util.ArrayList;

public class GroupTest {
    private Group group;

    @BeforeEach
    public void setUp() {
        List<String> members = new ArrayList<>();
        members.add("John");
        members.add("Alice");
        group = new Group("Family", members);
    }

    @Test
    public void testGetGroupName() {
        assertEquals("Family", group.getGroupName());
    }

    @Test
    public void testGetMembers() {
        List<String> expectedMembers = new ArrayList<>();
        expectedMembers.add("John");
        expectedMembers.add("Alice");
        assertEquals(expectedMembers, group.getMembers());
    }

    @Test
    public void testAddMember() {
        group.addMember("Bob");
        assertTrue(group.containsMember("Bob"));
    }

    @Test
    public void testRemoveMember() {
        group.removeMember("Alice");
        assertFalse(group.containsMember("Alice"));
    }

    @Test
    public void testContainsMember() {
        assertTrue(group.containsMember("John"));
        assertFalse(group.containsMember("Bob"));
    }
}
