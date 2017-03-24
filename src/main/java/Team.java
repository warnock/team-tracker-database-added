import java.util.ArrayList;
import java.util.List;

public class Team {
  private String mName;
  private List<Team> instances = new ArrayList<Team>();

  public Team(String name){
    mName = name;
    instances.add(this);
  }

  public String getName() {
    return mName;
  }

  public static List<Team> all() {
    return null;
  }
}
