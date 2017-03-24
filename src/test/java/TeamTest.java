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

  @Test
  public void clear_emptiesAllTeamsFromArrayList(){
    Team.clear();
    assertEquals(0, Team.all().size());
  }

  @Test
  public void getId_TeamInstantiatesWithId_1() {
    Team.clear();
    Team newTeam = new Team("name");
    assertEquals(1, newTeam.getId());
  }

  @Test
  public void find_returnsTeamWithSameId_secondTeam() {
  Team.clear();
  Team firstTeam = new Team("name");
  Team secondTeam = new Team("name");
  assertEquals(secondTeam, Team.find(secondTeam.getId()));
  }

  @Test
  public void getMembers_initiallyReturnsEmptyList_ArrayList() {
    Team.clear();
    Team newTeam = new Team("name");
    assertEquals(0, newTeam.getMembers().size());
  }

  @Test
  public void addMembers_addMembersToList_true() {
    Team.clear();
    Team newTeam = new Team("name");
    Member newMember = new Member("name");
    newTeam.addMembers(newMember);
    assertTrue(newTeam.getMembers().contains(newMember));
  }
}
