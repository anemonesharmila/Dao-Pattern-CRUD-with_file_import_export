/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package populationsurveyMain;

import java.util.Scanner;
import populationSurveryViews.PopSurveyView;
import populationSurveyService.PopulationSurveyService;

/**
 *
 * @author sharmila
 */
public class PopulationSurvey {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PopulationSurveyService pSurveyService = new PopulationSurveyService();
        PopSurveyView view = new PopSurveyView(scanner, pSurveyService);

        while (true) {
            System.out.println("Welcome to population survey");
            view.menu();
            int c = scanner.nextInt();
            switch (c) {

                case 1:
                    view.insertRecords();
                    System.out.println("Records inserted successfully");
                    break;
                case 2:
                    view.viewAll();
                    break;
                case 3:
                    view.deleteRecords();
                    System.out.println("Records deleted successfully");
                    break;
                case 4:
                    view.searchRecords();
                    System.out.println("Search completed");
                    break;
                case 5:
                    view.importRecords();
                    break;
                case 6:
                    view.exportRecords();
                    break;
                case 7:
                    view.searchByID();
                    break;
                case 8:
                    System.exit(0);
                    break;
            }

        }
    }

}
