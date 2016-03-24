/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package populationSurveyDao;

import java.io.IOException;
import java.util.List;
import populationSurvery.entity.Survey;

/**
 *
 * @author sharmila
 */
public interface PopulationSurveyDao {
    void insert(Survey survey);
    List<Survey> searchById(int areaId);
    List<Survey> delete(int areaId);
    List<Survey> getAll();
    List<Survey> search(String param);
    void importData(String filename) throws IOException;
    void exportData(String filename,String content) throws IOException;
}
