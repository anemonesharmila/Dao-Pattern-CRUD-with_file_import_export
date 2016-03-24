/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package populationSurveryViews;

import java.io.IOException;
import java.util.Scanner;
import populationSurvery.entity.Survey;
import populationSurveyService.PopulationSurveyService;

/**
 *
 * @author sharmila
 */
public class PopSurveyView {

    private Scanner scanner;
    private PopulationSurveyService pSurveyService;
    // Survey survey=new Survey();

    public PopSurveyView() {
    }

    public PopSurveyView(Scanner scanner, PopulationSurveyService pSurveyService) {
        this.scanner = scanner;
        this.pSurveyService = pSurveyService;
    }

    public void menu() {
        System.out.println("====================================");
        System.out.println("1. Add survey records \n");
        System.out.println("2. View all survey records \n ");
        System.out.println("3. Delete survey records \n");
        System.out.println("4. Search survey records \n");
        System.out.println("5. Import survey records \n");
        System.out.println("6. Export survey records \n");
        System.out.println("7. Search records by areaId \n");
        System.out.println("8. Exit \n");
        System.out.println("Enter numbers from 1-8 only");
        System.out.println("====================================");

    }

    public void insertRecords() {
        while (true) {
            Survey survey = new Survey();
            System.out.println("Enter area name");
            survey.setArea(scanner.next());
            System.out.println("Enter areaId");
            survey.setAreaId(scanner.nextInt());
            System.out.println("Enter total number of children");
            survey.setTotalChildren(scanner.nextInt());
            System.out.println("Enter total number of Male");
            survey.setTotalMale(scanner.nextInt());
            System.out.println("Enter total number of Female");
            survey.setTotalFemale(scanner.nextInt());
            System.out.println("Enter total number of houses");
            survey.setTotalHouses(scanner.nextInt());
            System.out.println("Enter total number of house-holds \n");
            survey.setTotalHouseHolds(scanner.nextInt());

            pSurveyService.insert(survey);
            System.out.println("----------------------------------");
            System.out.println("Do you want to continue??[y/n]");
            if (scanner.next().equalsIgnoreCase("n")) {
                break;
            }
        }
    }

    public void viewAll() {

        pSurveyService.getAllRecords().forEach(s -> {
            System.out.println(s.toCsv());
        });

    }

    public void deleteRecords() {
        while (true) {
            System.out.println("Enter the area id to delete from ");
            pSurveyService.delete(scanner.nextInt());

            System.out.println("Do you want to continue??[y/n]");
            if (scanner.next().equalsIgnoreCase("n")) {
                break;
            }
        }

    }

    public void searchRecords() {
        while (true) {
            Survey survey = new Survey();
            System.out.println("Enter the area name to search from");
            pSurveyService.search(scanner.next());
            System.out.println("Search result");

            System.out.println("Do you want to continue??[y/n]");
            if (scanner.next().equalsIgnoreCase("n")) {
                break;
            }
        }

    }

    public void importRecords() {
        while (true) {
            System.out.println("Give file name to import the records? ");
            String filePath = scanner.next();
            try {
                pSurveyService.importData(filePath);
                System.out.println("Imported successfully");

            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
            System.out.println("Do you want to continue??[y/n]");
            if (scanner.next().equalsIgnoreCase("n")) {
                break;
            }
        }
    }

    public void exportRecords() {
        while (true) {
            System.out.println("Where do you want to export the records? ");
            String filename = scanner.next();
            StringBuilder builder = new StringBuilder();
            pSurveyService.getAllRecords().forEach(survey -> {
                builder.append(survey.toCsv());
            });
            try {
                pSurveyService.exportData(filename, builder.toString());
                System.out.println("Export successfull");

            } catch (IOException e) {
                System.out.println(e.getMessage());

            }
            System.out.println("Do you want to continue??[y/n]");
            if (scanner.next().equalsIgnoreCase("n")) {
                break;
            }
        }
    }

    public void searchByID() {
        while (true) {
            System.out.println("Enter the area id to search for records");
            pSurveyService.searchById(scanner.nextInt());

            System.out.println("Do you want to continue??[y/n]");
            if (scanner.next().equalsIgnoreCase("n")) {
                break;
            }
        }
    }
}
