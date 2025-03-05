package models.setdata;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.datatable.DataTable;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@Data
public class EmpleadoLoombokData {
    String nombre;
    String segundoNombre ;
    String apellido;
    String idEmpleado;

    public static List<EmpleadoLoombokData> setData(DataTable dataTable) {
        List<EmpleadoLoombokData> dates = new ArrayList<>();
        List<Map<String, String>> mapInfo = dataTable.asMaps();
        for (Map<String, String> map : mapInfo) {
            dates.add(new ObjectMapper().convertValue(map, EmpleadoLoombokData.class));
        }
        return dates;

    }

}
