/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package populationSurveryDaoImpl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import populationSurvery.entity.Survey;
import populationSurveyDao.PopulationSurveyDao;

/**
 *
 * @author sharmila
 */
public class PopulationSurveyDaoImpl implements PopulationSurveyDao {

    private List<Survey> surveyList;

    public PopulationSurveyDaoImpl() {
    }

    public PopulationSurveyDaoImpl(List<Survey> surveyList) {
        this.surveyList = new ArrayList<>();
    }

    @Override
    public void insert(Survey survey) {
        surveyList.add(survey);

    }

    @Override
    public List<Survey> delete(int areaId) {

        surveyList.remove(areaId);
        return surveyList;
    }

    @Override
    public List<Survey> getAll() {
        System.out.println("-----------------------------------");
        return surveyList;
    }

    @Override
    public List<Survey> search(String param) {
        List<Survey> searchList = new ArrayList<>();
        surveyList.forEach(s -> {
            if (s.getArea().equalsIgnoreCase(param)) {
                searchList.add(s);
            }
        });
        System.out.println("----------------------------------------------------------------------");
        System.out.println(searchList);

        return searchList;
    }

    @Override
    public void importData(String filename) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        String line = "";
        while ((line = reader.readLine()) != null) {
            StringTokenizer token = new StringTokenizer(line, ",");
            Survey survey = new Survey();
            survey.setArea(token.nextToken());
            survey.setAreaId(strToInt(token.nextToken()));
            survey.setTotalChildren(strToInt(token.nextToken()));
            survey.setTotalMale(strToInt(token.nextToken()));
            survey.setTotalFemale(strToInt(token.nextToken()));
            survey.setTotalHouses(strToInt(token.nextToken()));
            survey.setTotalHouseHolds(strToInt(token.nextToken()));

            insert(survey);
        }
        reader.close();

    }

    public Integer strToInt(String string) {
        return Integer.parseInt(string);

    }

    @Override
    public void exportData(String filename, String content) throws IOException {
        FileWriter fileWriter = new FileWriter(new File(filename), true);
        fileWriter.write(content);
        fileWriter.close();
    }

    @Override
    public List<Survey> searchById(int areaId) {
        List<Survey> searchListByID = new ArrayList<>();
        surveyList.forEach(s -> {
            searchListByID.add(s);
            System.out.println(searchListByID);
        });
        return searchListByID;
    }

}
