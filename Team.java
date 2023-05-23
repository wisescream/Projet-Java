package Project_java;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;


public class Team {
    protected String name;
    protected String homePitch;
    protected List<String> playerNames;
    protected String coachName;
    protected String captain;

    public String toString() {
        return name;
    }

    protected String getName() {
        return name;
    }

    protected void setName(String newName) {
        this.name = newName;
    }

    protected void setHomePitch(String homePitch) {
        this.homePitch = homePitch;
    }

    protected void setPlayerNames(List<String> playerNames) {
        this.playerNames = playerNames;
    }

    protected void setCoachName(String coachName) {
        this.coachName = coachName;
    }

    protected void setCaptainName(String captain) {
        this.captain = captain;
    }

    protected static List<Team> teamList = new ArrayList<>();

    public static void createTeam() {
        Scanner scanner = new Scanner(System.in);
        Team newTeam = new Team();

        System.out.println("Enter team name:");
        newTeam.name = scanner.nextLine();

        System.out.println("Enter home pitch:");
        newTeam.homePitch = scanner.nextLine();

        newTeam.playerNames = new ArrayList<>();
        System.out.println("Enter player names (up to 11 names, enter 'done' to finish):");
        int playerCount = 0;
        String playerName = scanner.nextLine();
        while (!playerName.equalsIgnoreCase("done") && playerCount < 11) {
            newTeam.playerNames.add(playerName);
            playerCount++;
            if (playerCount < 11) {
                System.out.println("Enter player name (" + (11 - playerCount) + " names remaining, enter 'done' to finish):");
                playerName = scanner.nextLine();
            }
        }

        System.out.println("Enter coach name:");
        newTeam.coachName = scanner.nextLine();

        System.out.println("Enter captain name:");
        newTeam.captain = scanner.nextLine();

        teamList.add(newTeam);

        System.out.println("Team created successfully!");
    }

    public static void editTeam() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the name of the team to edit:");
        String teamName = scanner.nextLine();

        Team team = getTeamByName(teamName);
        if (team == null) {
            System.out.println("Team not found.");
            return;
        }

        System.out.println("Enter new team name (leave blank to keep current name):");
        String newName = scanner.nextLine();
        if (!newName.isEmpty()) {
            team.name = newName;
        }

        System.out.println("Enter new home pitch (leave blank to keep current home pitch):");
        String newHomePitch = scanner.nextLine();
        if (!newHomePitch.isEmpty()) {
            team.homePitch = newHomePitch;
        }

        System.out.println("Enter new coach name (leave blank to keep current coach name):");
        String newCoachName = scanner.nextLine();
        if (!newCoachName.isEmpty()) {
            team.coachName = newCoachName;
        }

        System.out.println("Enter new captain name (leave blank to keep current captain name):");
        String newCaptainName = scanner.nextLine();
        if (!newCaptainName.isEmpty()) {
            team.captain = newCaptainName;
        }

        System.out.println("Team details updated successfully!");
    }

    public static void deleteTeam() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the name of the team to delete:");
        String teamName = scanner.nextLine();

        Team team = getTeamByName(teamName);
        if (team == null) {
            System.out.println("Team not found.");
            return;
        }

        teamList.remove(team);

        System.out.println("Team deleted successfully!");
    }

    public static void playMatch() {
        Random random = new Random();

        if (teamList.size() < 2) {
            System.out.println("Insufficient teams to play a match. Please create at least 2 teams.");
            return;
        }

        Team team1 = teamList.get(random.nextInt(teamList.size()));
        Team team2 = teamList.get(random.nextInt(teamList.size()));

        while (team2 == team1) {
            team2 = teamList.get(random.nextInt(teamList.size()));
        }

        System.out.println("Match Details:");
        System.out.println("Team 1: " + team1.getName());
        System.out.println("Team 2: " + team2.getName());
        System.out.println("Venue: " + team1.homePitch);
    }

    public static void playCompetition() {
        Random random = new Random();

        if (teamList.size() < 2) {
            System.out.println("Insufficient teams to play a competition. Please create at least 2 teams.");
            return;
        }

        List<Team> competitionTeams = new ArrayList<>(teamList);

        System.out.println("Competition Teams:");
        for (Team team : competitionTeams) {
            System.out.println(team.getName());
        }

        while (competitionTeams.size() > 1) {
            Team team1 = competitionTeams.get(random.nextInt(competitionTeams.size()));
            competitionTeams.remove(team1);

            Team team2 = competitionTeams.get(random.nextInt(competitionTeams.size()));
            competitionTeams.remove(team2);

            System.out.println();
            System.out.println("Match Details:");
            System.out.println("Team 1: " + team1.getName());
            System.out.println("Team 2: " + team2.getName());
            System.out.println("Venue: " + team1.homePitch);
        }

        if (!competitionTeams.isEmpty()) {
            System.out.println("No opponent available for team " + competitionTeams.get(0).getName());
        }
    }

    public static Team getTeamByName(String teamName) {
        for (Team team : teamList) {
            if (team.getName().equalsIgnoreCase(teamName)) {
                return team;
            }
        }
        return null;
    }
}
