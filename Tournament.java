import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import Project_java.Team;


public class Tournament {
    private static final List<Tournament> tournamentList = new ArrayList<>();
    private List<String> participants;
    private String startDate;
    private String endDate;
    private String name;

    public Tournament() {
        participants = new ArrayList<>();
    }

    public static void inviteTeam() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the name of the tournament to invite teams:");
        String tournamentName = scanner.nextLine();

        Tournament tournament = getTournamentByName(tournamentName);
        if (tournament == null) {
            System.out.println("Tournament not found.");
            return;
        }

        System.out.println("Enter the name of the team to invite:");
        String teamName = scanner.nextLine();

        Team team = Team.getTeamByName(teamName);
        if (team == null) {
            System.out.println("Team not found.");
            return;
        }

        if (tournament.getParticipants().contains(teamName)) {
            System.out.println("Team is already invited to the tournament.");
        } else {
            tournament.getParticipants().add(teamName);
            System.out.println("Team invited successfully!");
        }
    }

    public static void removeTeam() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the name of the tournament to remove teams:");
        String tournamentName = scanner.nextLine();

        Tournament tournament = getTournamentByName(tournamentName);
        if (tournament == null) {
            System.out.println("Tournament not found.");
            return;
        }

        System.out.println("Enter the name of the team to remove:");
        String teamName = scanner.nextLine();

        if (tournament.getParticipants().remove(teamName)) {
            System.out.println("Team removed successfully!");
        } else {
            System.out.println("Team is not participating in the tournament.");
        }
    }

    public static void getOneTournamentByID() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the name of the tournament to get details:");
        String tournamentName = scanner.nextLine();

        Tournament tournament = getTournamentByName(tournamentName);
        if (tournament == null) {
            System.out.println("Tournament not found.");
            return;
        }

        System.out.println("Tournament Details:");
        System.out.println("Name: " + tournament.getName());
        System.out.println("Start Date: " + tournament.getStartDate());
        System.out.println("End Date: " + tournament.getEndDate());
        System.out.println("Participants:");
        for (String participant : tournament.getParticipants()) {
            System.out.println(participant);
        }
    }

    public static void getAllTournamentsByID() {
        if (tournamentList.isEmpty()) {
            System.out.println("No tournaments found.");
            return;
        }

        System.out.println("All Tournaments:");
        for (Tournament tournament : tournamentList) {
            System.out.println("Name: " + tournament.getName());
            System.out.println("Start Date: " + tournament.getStartDate());
            System.out.println("End Date: " + tournament.getEndDate());
            System.out.println();
        }
    }

    public static void endTheTournament() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the name of the tournament to end:");
        String tournamentName = scanner.nextLine();

        Tournament tournament = getTournamentByName(tournamentName);
        if (tournament == null) {
            System.out.println("Tournament not found.");
            return;
        }

        tournamentList.remove(tournament);

        System.out.println("Tournament ended successfully!");
    }

    public List<String> getParticipants() {
        return participants;
    }

    public void setParticipants(List<String> participants) {
        this.participants = participants;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static void createTournament() {
        Scanner scanner = new Scanner(System.in);
        Tournament newTournament = new Tournament();

        System.out.println("Enter tournament name:");
        newTournament.setName(scanner.nextLine());

        System.out.println("Enter start date:");
        newTournament.setStartDate(scanner.nextLine());

        System.out.println("Enter end date:");
        newTournament.setEndDate(scanner.nextLine());

        System.out.println("Enter participants (up to 8 participants, one participant per line, enter 'done' to finish):");
        String participant = scanner.nextLine();
        int participantCount = 0;
        while (!participant.equalsIgnoreCase("done") && participantCount < 8) {
            newTournament.getParticipants().add(participant);
            participant = scanner.nextLine();
            participantCount++;
        }

        tournamentList.add(newTournament);
        System.out.println("Tournament created successfully!");
    }

    public static void editTournament() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the name of the tournament to edit:");
        String tournamentName = scanner.nextLine();

        Tournament tournament = getTournamentByName(tournamentName);
        if (tournament == null) {
            System.out.println("Tournament not found.");
            return;
        }

        System.out.println("Enter new tournament name (leave blank to keep current name):");
        String newName = scanner.nextLine();
        if (!newName.isEmpty()) {
            tournament.setName(newName);
        }

        System.out.println("Enter new start date (leave blank to keep current start date):");
        String newStartDate = scanner.nextLine();
        if (!newStartDate.isEmpty()) {
            tournament.setStartDate(newStartDate);
        }

        System.out.println("Enter new end date (leave blank to keep current end date):");
        String newEndDate = scanner.nextLine();
        if (!newEndDate.isEmpty()) {
            tournament.setEndDate(newEndDate);
        }

        System.out.println("Enter participants (one participant per line, enter 'done' to finish, or leave blank to keep current participants):");
        List<String> participants = new ArrayList<>();
        String participant = scanner.nextLine();
        while (!participant.equalsIgnoreCase("done")) {
            if (!participant.isEmpty()) {
                participants.add(participant);
            }
            participant = scanner.nextLine();
        }
        if (!participants.isEmpty()) {
            tournament.setParticipants(participants);
        }

        System.out.println("Tournament details updated successfully!");
    }

    public static void deleteTournament() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the name of the tournament to delete:");
        String tournamentName = scanner.nextLine();

        Tournament tournament = getTournamentByName(tournamentName);
        if (tournament == null) {
            System.out.println("Tournament not found.");
            return;
        }

        tournamentList.remove(tournament);

        System.out.println("Tournament deleted successfully!");
    }

    public static void getAllTournaments() {
        for (Tournament tournament : tournamentList) {
            System.out.println(tournament.getName());
        }
    }

    public static Tournament getTournamentByName(String name) {
        for (Tournament tournament : tournamentList) {
            if (tournament.getName().equalsIgnoreCase(name)) {
                return tournament;
            }
        }
        return null;
    }
}
