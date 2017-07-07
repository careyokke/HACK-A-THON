import org.junit.*;
import static org.junit.Assert.*;

public class TeamTest {

  @Before
  public void tearDown() {
    Team.clear();
  }


  @Test
  public void Team_instantiatesCorrectly_true() {
    Team testTeam = new Team("DREAM TEAM");
    assertEquals(true, testTeam instanceof Team);
  }

  @Test
public void getTeamName_teamInstantiatesWithName_ITCrowd() {
  Team testTeam = new Team("DREAM TEAM");
  assertEquals("DREAM TEAMd", testTeam.getTeamName());
}

@Test
public void all_returnsAllInstancesOfTeam_true() {
  Team firstTeam = new Team("DREAM TEAM");
  Team secondTeam = new Team("Wanna BE TEAM");
  assertEquals(true, Team.all().contains(firstTeam));
  assertEquals(true, Team.all().contains(secondTeam));
}
