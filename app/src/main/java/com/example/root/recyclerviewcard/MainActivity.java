package com.example.root.recyclerviewcard;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.amazonaws.mobileconnectors.amazonmobileanalytics.AnalyticsEvent;
import com.amazonaws.mobileconnectors.amazonmobileanalytics.InitializationException;
import com.amazonaws.mobileconnectors.amazonmobileanalytics.MobileAnalyticsManager;
import com.amazonaws.mobileconnectors.s3.transferutility.TransferListener;
import com.amazonaws.mobileconnectors.s3.transferutility.TransferObserver;
import com.amazonaws.mobileconnectors.s3.transferutility.TransferState;
import com.amazonaws.mobileconnectors.s3.transferutility.TransferUtility;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recycler;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager lManager;
    private static MobileAnalyticsManager analytics;

    private static final int STATE_LOSE = 0;
    private static final int STATE_WIN = 1;
    TransferObserver transferObserver;

    public void onLevelComplete(String levelName, String difficulty, double timeToComplete, int playerState) {

        //Create a Level Complete event with some attributes and metrics(measurements)
        //Attributes and metrics can be added using with statements
        AnalyticsEvent levelCompleteEvent = analytics.getEventClient().createEvent("LevelComplete")
                .withAttribute("LevelName", levelName)
                .withAttribute("Difficulty", difficulty)
                .withMetric("TimeToComplete", timeToComplete);

        //attributes and metrics can also be added using add statements
        if (playerState == STATE_LOSE)
            levelCompleteEvent.addAttribute("EndState", "Lose");
        else if (playerState == STATE_WIN)
            levelCompleteEvent.addAttribute("EndState", "Win");

        //Record the Level Complete event
        analytics.getEventClient().recordEvent(levelCompleteEvent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        java.util.logging.Logger.getLogger("com.amazonaws").setLevel(Level.ALL); //  turn on verbose logging of the AWS Mobile SDK

            // inicializar MobileAnalyticsManager

        try {
            analytics = MobileAnalyticsManager.getOrCreateInstance( // tODo Oconfigurar la aAPI
                    getApplicationContext(),
                    "appId",
                    "identityPoolId"
            );
        } catch(InitializationException ex) {
            Log.e(this.getClass().getName(), "Failed to initialize Amazon Mobile Analytics", ex);
        }



        setContentView(R.layout.activity_main);

        ArrayList<Object> arrayAnimes = new ArrayList<Object>();

        arrayAnimes.add(new Anime("Death Note ", "Descripción .. 1", "Otro dato 1",  1, R.drawable.dark ));
        arrayAnimes.add(new Manga("Tokyo G ", "Descripción .. 1", "Otro dato 1",  1, R.drawable.dark, 2, "1999", "Aventura"  ));
        arrayAnimes.add(new Anime("Death Note ", "Descripción .. 1", "Otro dato 1",  1, R.drawable.dark ));
        arrayAnimes.add(new Manga("Tokyo G ", "Descripción .. 1", "Otro dato 1",  1, R.drawable.dark, 2, "1999", "Aventura"  ));
        arrayAnimes.add(new Anime("Death Note ", "Descripción .. 1", "Otro dato 1",  1, R.drawable.dark ));
        arrayAnimes.add(new Manga("Tokyo G ", "Descripción .. 1", "Otro dato 1",  1, R.drawable.dark, 2, "1999", "Aventura"  ));
        arrayAnimes.add(new Anime("Death Note ", "Descripción .. 1", "Otro dato 1",  1, R.drawable.dark ));
        arrayAnimes.add(new Manga("Tokyo G ", "Descripción .. 1", "Otro dato 1",  1, R.drawable.dark, 2, "1999", "Aventura"  ));
        arrayAnimes.add(new Anime("Death Note ", "Descripción .. 1", "Otro dato 1",  1, R.drawable.dark ));
        arrayAnimes.add(new Manga("Tokyo G ", "Descripción .. 1", "Otro dato 1",  1, R.drawable.dark, 2, "1999", "Aventura"  ));
        arrayAnimes.add(new Anime("Death Note ", "Descripción .. 1", "Otro dato 1",  1, R.drawable.dark ));
        arrayAnimes.add(new Manga("Tokyo G ", "Descripción .. 1", "Otro dato 1",  1, R.drawable.dark, 2, "1999", "Aventura"  ));
        arrayAnimes.add(new Anime("Death Note ", "Descripción .. 1", "Otro dato 1",  1, R.drawable.dark ));
        arrayAnimes.add(new Manga("Tokyo G ", "Descripción .. 1", "Otro dato 1",  1, R.drawable.dark, 2, "1999", "Aventura"  ));
        arrayAnimes.add(new Anime("Death Note ", "Descripción .. 1", "Otro dato 1",  1, R.drawable.dark ));
        arrayAnimes.add(new Manga("Tokyo G ", "Descripción .. 1", "Otro dato 1",  1, R.drawable.dark, 2, "1999", "Aventura"  ));
        arrayAnimes.add(new Anime("Death Note ", "Descripción .. 1", "Otro dato 1",  1, R.drawable.dark ));
        arrayAnimes.add(new Manga("Tokyo G ", "Descripción .. 1", "Otro dato 1",  1, R.drawable.dark, 2, "1999", "Aventura"  ));


        // Obtener el recycler
        recycler = (RecyclerView) findViewById(R.id.recyclerCards);
        recycler.setHasFixedSize(true);

        Log.d("debug7", "SAlio bien "+ recycler.hasFixedSize());

        // Administrador para layout manage
        lManager = new LinearLayoutManager(this);
        recycler.setLayoutManager(lManager); // Setear el layoutmanager para el recycler

        //Crear un nuevo Adaptador
        //adapter = new AnimeAdapter(arrayAnimes);
        //recycler.setAdapter(adapter); // setear Adapter para el recycler

        // Base adapter implementado
        AnimeAdapterBsAd AnimeAd= new AnimeAdapterBsAd(this);
        AnimeAd.addAll(arrayAnimes);
        recycler.setAdapter(AnimeAd);

        this.onLevelComplete("Lower Dungeon", "Very Difficult", 2734, STATE_WIN);
    }

    @Override
    protected void onPause() {
        super.onPause();
        if(analytics != null) {
            analytics.getSessionClient().pauseSession();
            //Attempt to send any events that have been recorded to the Mobile Analytics service.
            analytics.getEventClient().submitEvents();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        if(analytics != null)  {
            analytics.getSessionClient().resumeSession();
        }
    }
}
