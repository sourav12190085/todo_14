package gcit.edu.todo_13;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity implements  AdapterView.OnItemSelectedListener {

    private TextView textview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Intent obj=getIntent();
        String message=obj.getStringExtra(MainActivity.EXTRA_MESSAGE);
        textview=findViewById(R.id.textView5);
        textview.setText(message);

        Spinner spinner =findViewById(R.id.spinner);

        if(spinner!=null){
            spinner.setOnItemSelectedListener(this);
        }

        ArrayAdapter<CharSequence> adapter= ArrayAdapter.createFromResource(this,R.array.labels_array,R.layout.support_simple_spinner_dropdown_item);

        if(spinner!=null){
            spinner.setAdapter(adapter);
            spinner.getDisplay();
        }
    }

    public void all(View view) {
        boolean checked=((RadioButton) view).isChecked();

        switch (view.getId()){
            case R.id.pick:
                displayToast("pickup");
                break;

            case R.id.sameday:
                displayToast("same day around");
                break;
            case R.id.nextday:
                displayToast("nextday");
                break;

            default:
                break;
        }

    }

    private void displayToast(String pickup) {
        Toast.makeText(getApplicationContext(),pickup,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String message=parent.getItemAtPosition(position).toString();
        displayToast(message);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}