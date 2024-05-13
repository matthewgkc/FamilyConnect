import com.example.familyconnect.model.UserGroup;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserGroupTest {

    public UserGroup usergroup;

    @BeforeEach
    void setUp() {
        usergroup = new UserGroup("John's Group", "John");
    }
    @Test
    public void testGetId() {
        usergroup.setGroupId(100);
        assertEquals(100, usergroup.getGroupId());
    }
    @Test
    public void testGetGroupName() {
        assertEquals("John's Group", usergroup.getGroupName());
    }
    @Test
    public void testSetGroupName() {
        usergroup.setGroupName("Jane's Group");
        assertEquals("Jane's Group", usergroup.getGroupName());
    }

    @Test
    public void testGetGroupAdmin() {
        assertEquals("John", usergroup.getGroupAdmin());
    }
    @Test
    public void testSetGroupAdmin() {
        usergroup.setGroupAdmin("Jane");
        assertEquals("Jane", usergroup.getGroupAdmin());
    }

}