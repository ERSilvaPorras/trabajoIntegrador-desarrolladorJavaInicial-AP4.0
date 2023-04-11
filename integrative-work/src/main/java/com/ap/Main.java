package com.ap;

import java.io.IOException;
import java.nio.file.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Main 
{
    public static void main( String[] args ) throws Exception {
        String resultsFile = "integrative-work/resources/results.csv";
        String predictionsFile = "integrative-work/resources/predictions.csv";
        String predictions2File = "integrative-work/resources/predictions2.csv";
        String predictions3File = "integrative-work/resources/predictions3.csv";
        pointsOfPredictionFile(resultsFile, predictionsFile);
        pointsOfPredictionFile(resultsFile, predictions2File);
        pointsOfPredictionFile(resultsFile, predictions3File);

        //getConnection();
        
    }

    public static void pointsOfPredictionFile(String resultsFile, String predictionsFile) throws Exception {
        String separator = ",";
        Team team1, team2, team;
        int team1Goals, team2Goals;
        Game game;
        List<Game> games = new ArrayList<Game>();
        String selectedPrediction = "x";
        ResultEnum result;
        List<Prediction> predictions = new ArrayList<Prediction>();
        int totalPoints = 0;
        List<String> lines = new ArrayList<String>();
        try {
            lines = Files.readAllLines(Paths.get(resultsFile));
        } catch (IOException e) {
            System.out.println("Error al leer el archivo de resultados de partidos.");
        }
        for(String line : lines) {
            String[] data = line.split(separator);
            team1 = new Team(data[0], "__");
            team1Goals = Integer.parseInt(data[1]);
            team2Goals = Integer.parseInt(data[2]);
            team2 = new Team(data[3], "___");
            game = new Game(team1, team2, team1Goals, team2Goals);
            games.add(game);
        }

        //for(Game g: games)
        //    System.out.println(g);

        try {
            lines = Files.readAllLines(Paths.get(predictionsFile));
        } catch (IOException e) {
            System.out.println("Error al leer el archivo de predicciones.");
        }
        for(int i = 0; i < lines.size(); i++) {
            String[] data = lines.get(i).split(separator);
            game = games.get(i);
            team = game.getTeam1();
            if(data[1].equals(selectedPrediction)) {
                result = ResultEnum.WINNER;
            } else if(data[2].equals(selectedPrediction)) {
                result = ResultEnum.TIE;
            } else {
                result = ResultEnum.LOSER;
            }
            Prediction prediction = new Prediction(game, team, result);
            predictions.add(prediction);
            //System.out.println(game + " " + result);
            totalPoints += prediction.points();
        }
        System.out.println("Puntos: " + totalPoints);;
    }

    public static void getConnection() {
        try (Connection conn = ConnectionJDBC.getConnection()) {
            if (conn != null) {
                System.out.println("Conexión exitosa");
            } else {
                System.out.println("Conexión fallida");
            }
        } catch (SQLException e) {
            System.out.println("Ocurrio un error en la conexion.");
        }
    }
}
