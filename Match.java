package Project_java;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Match extends User {

    private static List<Match> matchList = new ArrayList<>();
    private String referee;
    private String team2;
    private String team1;
    private String date;
    private String number;

    public String toString() {
        return "Match " + number + " | Date: " + date;
    }

    public static void createMatch() {
        Scanner scanner = new Scanner(System.in);
        Match newMatch = new Match();

        System.out.println("Enter match number:");
        newMatch.setNumber(scanner.nextLine());

        System.out.println("Enter match date:");
        newMatch.setDate(scanner.nextLine());

        System.out.println("Enter team 1:");
        newMatch.setTeam1(scanner.nextLine());

        System.out.println("Enter team 2:");
        newMatch.setTeam2(scanner.nextLine());

        System.out.println("Enter referee name:");
        newMatch.setReferee(scanner.nextLine());

        matchList.add(newMatch);

        System.out.println("Match created successfully!");
    }

    public static void editMatch() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of the match to edit:");
        String matchNumber = scanner.nextLine();

        Match match = getMatchByNumber(matchNumber);
        if (match == null) {
            System.out.println("Match not found.");
            return;
        }

        System.out.println("Enter new match date (leave blank to keep current date):");
        String newDate = scanner.nextLine();
        if (!newDate.isEmpty()) {
            match.setDate(newDate);
        }

        System.out.println("Enter new team 1 (leave blank to keep current team):");
        String newTeam1 = scanner.nextLine();
        if (!newTeam1.isEmpty()) {
            match.setTeam1(newTeam1);
        }

        System.out.println("Enter new team 2 (leave blank to keep current team):");
        String newTeam2 = scanner.nextLine();
        if (!newTeam2.isEmpty()) {
            match.setTeam2(newTeam2);
        }

        System.out.println("Enter new referee name (leave blank to keep current referee):");
        String newReferee = scanner.nextLine();
        if (!newReferee.isEmpty()) {
            match.setReferee(newReferee);
        }

        System.out.println("Match details updated successfully!");
    }

    public static void deleteMatch() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of the match to delete:");
        String matchNumber = scanner.nextLine();

        Match match = getMatchByNumber(matchNumber);
        if (match == null) {
            System.out.println("Match not found.");
            return;
        }

        matchList.remove(match);

        System.out.println("Match deleted successfully!");
    }

    public static void inviteUser() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of the match to invite users:");
        String matchNumber = scanner.nextLine();

        Match match = getMatchByNumber(matchNumber);
        if (match == null) {
            System.out.println("Match not found.");
            return;
        }

        System.out.println("Enter the username to invite:");
        String username = scanner.nextLine();

        if (registerList.contains(username)) {
            System.out.println("Invitation sent to user " + username);
        } else {
            System.out.println("User " + username + " not found.");
        }
    }

    public static void removeUser() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of the match to remove users:");
        String matchNumber = scanner.nextLine();

        Match match = getMatchByNumber(matchNumber);


        if (match == null) {
            System.out.println("Match not found.");
            return;
        }

        System.out.println("Enter the username to remove:");
        String username = scanner.nextLine();

        if (registerList.contains(username)) {
            System.out.println("User " + username + " removed from the match.");
        } else {
            System.out.println("User " + username + " not found in the match.");
        }
    }

    public static void addReferee() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of the match to add a referee:");
        String matchNumber = scanner.nextLine();

        Match match = getMatchByNumber(matchNumber);
        if (match == null) {
            System.out.println("Match not found.");
            return;
        }

        System.out.println("Enter the name of the referee:");
        String referee = scanner.nextLine();

        match.setReferee(referee);

        System.out.println("Referee added to the match successfully!");
    }

    public static void getOneMatch() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of the match to get details:");
        String matchNumber = scanner.nextLine();

        Match match = getMatchByNumber(matchNumber);
        if (match == null) {
            System.out.println("Match not found.");
            return;
        }

        System.out.println("Match Number: " + match.getNumber());
        System.out.println("Match Date: " + match.getDate());
        System.out.println("Team 1: " + match.getTeam1());
        System.out.println("Team 2: " + match.getTeam2());
        System.out.println("Referee: " + match.getReferee());
    }

    public static void getAllMatch() {
        for (Match match : matchList) {
            System.out.println(match);
        }
    }

    public static Match getMatchByNumber(String matchNumber) {
        for (Match match : matchList) {
            if (match.getNumber().equals(matchNumber)) {
                return match;
            }
        }
        return null;
    }

    public String getReferee() {
        return referee;
    }

    public void setReferee(String referee) {
        this.referee = referee;
    }

    public String getTeam2() {
        return team2;
    }

    public void setTeam2(String team2) {
        this.team2 = team2;
    }

    public String getTeam1() {
        return team1;
    }

    public void setTeam1(String team1) {
        this.team1 = team1;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}