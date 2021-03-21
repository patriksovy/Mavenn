package sk.itsovy.kincel.company.Controller;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sk.itsovy.kincel.company.log.Log;
import sk.itsovy.kincel.company.util.Util;

import java.util.HashMap;
import java.util.Map;

@RestController
public class SecretController {
    private final String PASSWORD = "Kosice2021!";
    Map<String, String> map = new HashMap<>();
    Log log = new Log();

    @GetMapping("/secret")
    public String secret(@RequestHeader("token") String header){
        System.out.println(header);
        return "secret";
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody String auth){
        JSONObject object = null;
        try{
            object = (JSONObject) new JSONParser().parse(auth);
            String login = ((String) object.get("login"));
            String password = ((String) object.get("password"));
            System.out.println(login + " " + password);
            if (login == null || password == null){
                log.error("Missing login or password");
                return ResponseEntity.status(400).body("");
            }
            if (password.equals(PASSWORD)){
                String token = new Util().generateToken();
                map.put(login,token);
                log.print("User logged");
                JSONObject obj = new JSONObject();
                obj.put("login", login);
                obj.put("token", "Bearer "+token);
                return ResponseEntity.status(200).body(obj.toJSONString());
            }else {
                log.error("Wrong password");
                return ResponseEntity.status(401).body("");
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
}