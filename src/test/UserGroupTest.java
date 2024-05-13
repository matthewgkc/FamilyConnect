import com.example.familyconnect.model.UserAccount;
import com.example.familyconnect.model.UserGroup;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserGroupTest {

    private UserGroup usergroup;

    @BeforeEach
    void setUp() {
        usergroup = new UserGroup("John's Group");
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

}