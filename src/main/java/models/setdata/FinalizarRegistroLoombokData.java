package models.setdata;


import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.datatable.DataTable;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Data
public class FinalizarRegistroLoombokData {

    String mensajeExitoso;

    public static List<FinalizarRegistroLoombokData> setData(DataTable dataTable) {
        List<FinalizarRegistroLoombokData> dates = new ArrayList<>();
        List<Map<String, String>> mapInfo = dataTable.asMaps();
        for (Map<String, String> map : mapInfo) {
            dates.add(new ObjectMapper().convertValue(map, FinalizarRegistroLoombokData.class));
        }
        return dates;
    }



}
