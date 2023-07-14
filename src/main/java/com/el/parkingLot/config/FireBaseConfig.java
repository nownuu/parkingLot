package com.el.parkingLot.config;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.io.FileInputStream;

@Configuration
public class FireBaseConfig {
    @PostConstruct
    public void init(){
        try{
            FileInputStream serviceAccount =
                    new FileInputStream("src/main/resources/parkingService.json");

            FirebaseOptions options = new FirebaseOptions.Builder()
                    .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                    .setDatabaseUrl("https://parking-4b1cd-default-rtdb.firebaseio.com")
                    .build();

            FirebaseApp.initializeApp(options);

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
