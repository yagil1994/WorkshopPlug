package com.workshop.workshop.plug;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Plug {
    private boolean isPlugOn;
    private Gson gson ;
    public Plug()
    {
        isPlugOn = false;
        gson = new Gson();
    }

    @GetMapping("/workshop/plug/is_on")
    public ResponseEntity<String> PlugStatus(){
        JsonObject body = new JsonObject();
      body.addProperty("plug status: ", isPlugOn? "on" : "off");
       return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(gson.toJson(body));
    }

    @GetMapping("/workshop/plug/change_plug_mode")
    public ResponseEntity<String> ChangeCurrentPlugMode(){
        JsonObject body = new JsonObject();
        body.addProperty("plug status before changing: ", isPlugOn? "on" : "off");
        isPlugOn = !isPlugOn;
        body.addProperty("plug status after changing: ", isPlugOn? "on" : "off");

        return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(gson.toJson(body));
    }
}
