package test.example.com.myfirebasetestexample01;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import static com.google.firebase.database.ServerValue.TIMESTAMP;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "메인 테스트";
    private Button mButton;
    private Button mButton2;
    FirebaseDatabase database;
    DatabaseReference myRef;

    private static List<Board> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        database = FirebaseDatabase.getInstance();
        myRef = database.getReference("message");
        mButton = findViewById(R.id.logBtn);

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Board board = new Board("ddd", "sdlfksdlfk", TIMESTAMP);
                myRef.push().child("board").setValue(board);
            }
        });

        mButton2 = findViewById(R.id.logBtn2);
        mButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                fireRead();

            }
        });


    }

    public void fireRead() {
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//                Board board = dataSnapshot.getValue(Board.class);

//                list.add(board);

                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {

                    SimpleDateFormat format = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss:ss");
//                    Log.d("MainActivity", "ValueEventListener : " + format.format(snapshot.getValue()));


                    Board board = snapshot.child("board").getValue(Board.class);
                    Log.e(TAG, "onDataChange: "+ board.toString() );

                    list.add(board);

//                    Log.d("MainActivity", "ValueEventListener : " + snapshot.child("board").child("time").getValue());
                }
                Log.e(TAG, "onDataChange: " + list.toString());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }

}
