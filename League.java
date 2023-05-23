package Project_java;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class League extends Competition {
    private static final List<League> leagueList = new ArrayList<>();
    private String name;
    private String date;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDate() {
        return date;
    }

    public static void createLeague() {
        Scanner scanner = new Scanner(System.in);
        League newLeague = new League();

        System.out.println("Enter league name:");
        newLeague.setName(scanner.nextLine());

        System.out.println("Enter league start date:");
        newLeague.setDate(scanner.nextLine());

        leagueList.add(newLeague);

        System.out.println("League created successfully!");
    }

    public static void editLeague() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the name of the league to edit:");
        String leagueName = scanner.nextLine();

        League league = getLeagueByName(leagueName);
        if (league == null) {
            System.out.println("League not found.");
            return;
        }

        System.out.println("Enter new league name (leave blank to keep current name):");
        String newName = scanner.nextLine();
        if (!newName.isEmpty()) {
            league.setName(newName);
        }

        System.out.println("Enter new league start date (leave blank to keep current date):");
        String newDate = scanner.nextLine();
        if (!newDate.isEmpty()) {
            league.setDate(newDate);
        }

        System.out.println("League details updated successfully!");
    }

    public static void deleteLeague() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the name of the league to delete:");
        String leagueName = scanner.nextLine();

        League league = getLeagueByName(leagueName);
        if (league == null) {
            System.out.println("League not found.");
            return;
        }

        leagueList.remove(league);

        System.out.println("League deleted successfully!");
    }

    public static void startLeague() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the name of the league to start:");
        String leagueName = scanner.nextLine();

        League league = getLeagueByName(leagueName);
        if (league == null) {
            System.out.println("League not found.");
            return;
        }

        System.out.println("League " + league.getName() + " started!");
    }

    public static void endLeague() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the name of the league to end:");
        String leagueName = scanner.nextLine();

        League league = getLeagueByName(leagueName);
        if (league == null) {
            System.out.println("League not found.");
            return;
        }

        System.out.println("League " + league.getName() + " ended!");
    }

    public static void playLeagueMatch() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the name of the league to play a match:");
        String leagueName = scanner.nextLine();

        League league = getLeagueByName(leagueName);
        if (league == null) {
            System.out.println("League not found.");
            return;
        }

        System.out.println("Playing league matches for " + league.getName() + "...");
    }

    public static League getLeagueByName(String leagueName) {
        for (League league : leagueList) {
            if (league.getName().equalsIgnoreCase(leagueName)) {
                return league;
            }
        }
        return null;
    }
}