package models.setdata;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.datatable.DataTable;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Data
public class DatosSesionLoombokData {

    String nombreUsuario;
    String contrasenaRegistro;

    public static List<DatosSesionLoombokData> setData(DataTable dataTable) {
        List<DatosSesionLoombokData> dates = new ArrayList<>();
        List<Map<String, String>> mapInfo = dataTable.asMaps();
        for (Map<String, String> map : mapInfo) {
            dates.add(new ObjectMapper().convertValue(map, DatosSesionLoombokData.class));
        }
        return dates;
    }
}
