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
      body.addProperty("Plug side:the plug status is: ", isPlugOn? "on" : "off");
       return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(gson.toJson(body));
    }

    @GetMapping("/workshop/plug/change_plug_mode")
    public ResponseEntity<String> ChangeCurrentPlugMode(){
        JsonObject body = new JsonObject();
        body.addProperty("Plug side: the plug status before changing is: ", isPlugOn? "on" : "off");
        isPlugOn = !isPlugOn;
        body.addProperty("Plug side: the plug status after changing is: ", isPlugOn? "on" : "off");

        return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(gson.toJson(body));
    }

    @GetMapping("/workshop/plug/off")
    public ResponseEntity<String> makePlugOff(){
        JsonObject body = new JsonObject();
        isPlugOn = false;
        body.addProperty("Plug side:the plug status is: ","off");

        return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(gson.toJson(body));
    }
}
