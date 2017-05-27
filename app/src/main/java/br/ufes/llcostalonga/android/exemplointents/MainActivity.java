package br.ufes.llcostalonga.android.exemplointents;

import android.content.Intent;
import android.icu.util.Calendar;
import android.net.Uri;
import android.os.Bundle;
import android.provider.AlarmClock;
import android.provider.CalendarContract;
import android.provider.MediaStore;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        final Spinner spinner = (Spinner) findViewById(R.id.spinner);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.cores_array, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
                spinner.setAdapter(adapter);



        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //createAlarm("Acorda!",11,59); //Exemplo 1
                //startTimer("Mensagem", 5); //Exemplo 2

                //todo Exemplo 3
                /*Calendar rightNow = Calendar.getInstance();
                addEvent("Aula", "CEUNES",rightNow,rightNow);*/

                //todo Exemplo 4
               // dispatchTakePictureIntent();

               //todo Exemplo 5
               //String[] destinatarios = {"llcostalonga@hotmail.com"};
               // composeEmail(destinatarios, "Teste Intent", null);

               //todo Exemplo 6
                Uri geoUri = Uri.parse("geo:0,0?q=BR101+SãoMateus+ES");
                showMap(geoUri);

                //todo Chama Explícita
                //chamaAtividade((String)spinner.getSelectedItem());

                /*Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show(); *///Código Default
            }
        });
    }

    //todo Exemplo Intent Explicita
    public void chamaAtividade(String cor){
        Intent intent = new Intent(this, OutraAtividade.class);

        intent.putExtra("cor",cor);

        startActivity(intent);
    }

    // @todo Exemplo 1
    public void createAlarm(String message, int hour, int minutes) {
        Intent intent = new Intent(AlarmClock.ACTION_SET_ALARM)
                .putExtra(AlarmClock.EXTRA_MESSAGE, message)
                .putExtra(AlarmClock.EXTRA_HOUR, hour)
                .putExtra(AlarmClock.EXTRA_MINUTES, minutes);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

   //@todo Exemplo 2
    public void startTimer(String message, int seconds) {
        Intent intent = new Intent(AlarmClock.ACTION_SET_TIMER)
                .putExtra(AlarmClock.EXTRA_MESSAGE, message)
                .putExtra(AlarmClock.EXTRA_LENGTH, seconds)
                .putExtra(AlarmClock.EXTRA_SKIP_UI, true);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

  //todo Exemplo 3
  public void addEvent(String title, String location, Calendar begin, Calendar end) {
      Intent intent = new Intent(Intent.ACTION_INSERT)
              .setData(CalendarContract.Events.CONTENT_URI)
              .putExtra(CalendarContract.Events.TITLE, title)
              .putExtra(CalendarContract.Events.EVENT_LOCATION, location)
              .putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME, begin)
              .putExtra(CalendarContract.EXTRA_EVENT_END_TIME, end);
      if (intent.resolveActivity(getPackageManager()) != null) {
          startActivity(intent);
      }
  }

    //todo Exemplo 4
    static final int REQUEST_IMAGE_CAPTURE = 1;

    private void dispatchTakePictureIntent() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
        }
    }

    //todo Exemplo 5
    public void composeEmail(String[] addresses, String subject, Uri attachment) {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("*/*");
        intent.putExtra(Intent.EXTRA_EMAIL, addresses);
        intent.putExtra(Intent.EXTRA_SUBJECT, subject);
        intent.putExtra(Intent.EXTRA_STREAM, attachment);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

     //todo Exemplo 6
     public void showMap(Uri geoLocation) {
         Intent intent = new Intent(Intent.ACTION_VIEW);
         intent.setData(geoLocation);
         if (intent.resolveActivity(getPackageManager()) != null) {
             startActivity(intent);
         }
     }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
