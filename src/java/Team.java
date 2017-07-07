import java.util.List;
import java.util.ArrayList;

public class Team {
  private int mId;
  private String mTeamName;
  private static List<Team> instances = new ArrayList<Team>();
  private String mTeamName;
  private List<Member> mMembers;

  public Team(String teamName) {
      mId = instances.size();
      instances.add(this);
      mTeamName = teamName;
      mMembers = new ArrayList<Member>();
    }

    public void addMember(Member member) {
      mMembers.add(member);
    }
    public String getTeamName() {
    return mTeamName;
    }

    public static List<Team> all() {
      return instances;
    }

    public static void clear() {
      instances.clear();
    }

    public int getId() {
      return mId;
    }

    public static Team find(int id) {
      return instances.get(id -1);
    }

    public List<Member> getMembers() {
      return mMembers;
    }
  }
