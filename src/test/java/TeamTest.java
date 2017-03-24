import org.junit.*;
import static org.junit.Assert.*;

public class TeamTest {

  @Test
  public void Team_instantiatesCorrectly_true() {
    Team newTeam = new Team("name");
    assertEquals(true, newTeam instanceof Team);
  }

  @Test
  public void getName_getsNameValue_name() {
    Team newTeam = new Team("name");
    assertEquals("name", newTeam.getName());
  }

  @Test
  public void all_getsAllTeams_true() {
    Team firstTeam = new Team("name");
    Team secondTeam = new Team("name");
    assertEquals(true, Team.all().contains(firstTeam));
    assertEquals(true, Team.all().contains(secondTeam));
  }

}
