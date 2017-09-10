package hk.ust.cse.comp107x.metertoinches;

import android.graphics.Color;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {
        private EditText EnterMeters;
        private Button BtnConvert;
        private TextView ResultView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EnterMeters = (EditText) findViewById(R.id.editText);
        BtnConvert = (Button) findViewById(R.id.button);

        ResultView = (TextView) findViewById(R.id.ResultID);
        BtnConvert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Double multiplier = 39.37;
                Double result = 0.0;
                if(EnterMeters.getText().toString().equals("")){
                    ResultView.setText(R.string.errMessage);
                    ResultView.setTextColor(Color.RED);
                }else{
                    Double meterValue =Double.parseDouble(EnterMeters.getText().toString());
                    result = meterValue*multiplier;
                    // ResultView.setText(Double.toString(result)+" Inches");
                    ResultView.setText(String.format("%.2f", result) + " Inches");
                    ResultView.setTextColor(Color.BLACK);

                }


            }
        });
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
