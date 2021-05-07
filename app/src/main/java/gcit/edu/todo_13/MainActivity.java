package gcit.edu.todo_13;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;
import androidx.appcompat.widget.Toolbar;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE= "gcit.edu.todo_12.extra.MESSAGE";
    private String mOrderMessage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.content_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_order:
                Intent intent =new Intent(this,MainActivity2.class);
                intent.putExtra(EXTRA_MESSAGE,mOrderMessage);
                startActivity(intent);
                return true;

            case R.id.action_contact:
                Toast.makeText(this, "You selected contact", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.search:
                Toast.makeText(this, "You selected Search", Toast.LENGTH_SHORT).show();
                return true;
            default:
                break;
        }


        return false;
    }
    public void donut(View view) {
        Toast.makeText(this, "You Ordered Donut", Toast.LENGTH_SHORT).show();
        String msg="You have ordered donut";
        mOrderMessage=msg;
    }

    public void ice(View view) {
        Toast.makeText(this, "You Ordered Ice Cream", Toast.LENGTH_SHORT).show();
        String msg="You have ordered IceCream";
        mOrderMessage=msg;
    }

    public void froyo(View view) {
        Toast.makeText(this, "You Ordered Froyo", Toast.LENGTH_SHORT).show();
        String msg="You have ordered Froyo";
        mOrderMessage=msg;
    }

    public void call(View view) {
        Intent obj=new Intent(gcit.edu.todo_13.MainActivity.this,gcit.edu.todo_13.MainActivity2.class);
        obj.putExtra(EXTRA_MESSAGE,mOrderMessage);
        startActivity(obj);
    }
}