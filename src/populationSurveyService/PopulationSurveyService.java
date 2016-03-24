/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package populationSurveyService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import populationSurvery.entity.Survey;
import populationSurveryDaoImpl.PopulationSurveyDaoImpl;
import populationSurveyDao.PopulationSurveyDao;

/**
 *
 * @author sharmila
 */
public class PopulationSurveyService {

    private PopulationSurveyDao pDao;

    public PopulationSurveyService() {
        pDao = new PopulationSurveyDaoImpl(new ArrayList<>());
    }

    public PopulationSurveyService(PopulationSurveyDao pDao) {
        this.pDao = pDao;
    }

    public void insert(Survey survey) {
        pDao.insert(survey);

    }
    public List<Survey> searchById(int areaId)
    {
        return pDao.searchById(areaId);
    }

    public List<Survey> delete(int areaId) {
        return pDao.delete(areaId);
       
    }

    public List<Survey> getAllRecords() {
        return pDao.getAll();
    }

    public List<Survey> search(String param) {
        
       return pDao.search(param);
        
    }

    public void importData(String filename) throws IOException {
       pDao.importData(filename);

    }

    public void exportData(String filename, String content) throws IOException {
       pDao.exportData(filename, content);
    }

}
