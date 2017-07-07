import org.junit.*;
import static org.junit.Assert.*;

public class MemberTest {

  @Before
  public void tearDown() {
    Member.clear();
  }

  @Test
  public void all_returnsAllInstancesofMember_true() {
    Member firstMember = new Member("Yokke");
    Member secondMember = new Member("Anna");
    assertEquals(true, Member.all().contains(firstMember));
    assertEquals(true, Member.all().contains(secondMember));
  }


    @Test
    public void Member_instantiatesWithName_String() {
      Member newMember = new Member("Yokke");
      assertEquals("Yokke", newMember.getMemberName());
    }
