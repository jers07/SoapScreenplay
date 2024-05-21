package co.com.sofka.hooks;

import co.com.sofka.models.Fecha;
import io.cucumber.java.DataTableType;

import java.util.Map;

public class TablaConfig {
    @DataTableType
    public Fecha datos(Map<String,String> info){
        return new Fecha(
                info.get("date"),
                info.get("month"),
                info.get("year"),
                info.get("hour")
        );
    }
}
