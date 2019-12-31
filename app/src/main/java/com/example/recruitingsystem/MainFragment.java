package com.example.recruitingsystem;



import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import java.util.ArrayList;
import classes.Form;
import classes.Question;
import classes.User;


public class MainFragment extends Fragment {

    private DatabaseReference myRef;
    FirebaseDatabase database;

    ArrayList<Form> forms;
    private int fragment;
    private static final String TAG  = "MainFragment";


    public MainFragment() {
        // Required empty public constructor
        Log.d(TAG, "MainFragment: 1");
        this.fragment = -1;

    }
//    public MainFragment(int fragment) {
//        // Required empty public constructor
//        Log.d(TAG, "MainFragment: 1");
//        this.fragment = fragment;
//
//    }

    public void setFragment(int fragment ) {
        this.fragment = fragment;
    }
    public int getFragment() {
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        if (getFragment() == -1)
        {
            return inflater.inflate(R.layout.fragment_first_page, container, false);
        }
        if (getFragment() == 0)
        {
            return inflater.inflate(R.layout.fragment_second_page, container, false);
        }
        else if(getFragment() == R.layout.fragment_form)
        {
            View rootView = inflater.inflate(R.layout.fragment_form, container, false);
            RecyclerView recyclerView = rootView.findViewById(R.id.forms_List);
            recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
            FormList(recyclerView);
            return rootView;
        }
        return inflater.inflate(this.fragment, container, false);


    }






    public void FormList(RecyclerView recyclerView )
    {
        // Inflate the layout for this fragment

//        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        String creatorId = "creatorId";
        String departmentId = "departmentId";

        ArrayList<Form> forms = new ArrayList<>();

        Form f1 = new Form("1", "HR form", creatorId, departmentId);
        Form f2 = new Form("2", "PR form", creatorId, departmentId);
        Form f3 = new Form("3", "FR form", creatorId, departmentId);
        Form f4 = new Form("4", "marketing form", creatorId, departmentId);
        Form f5 = new Form("5", "Design form", creatorId, departmentId);
        Form f6 = new Form("6", "AC form", creatorId, departmentId);
        Form f7 = new Form("6", "Media form", creatorId, departmentId);
        Form f8 = new Form("6", "Social Media form", creatorId, departmentId);
        forms.add(f1);
        forms.add(f2);
        forms.add(f3);
        forms.add(f4);
        forms.add(f5);
        forms.add(f6);
        forms.add(f7);
        forms.add(f8);
//        forms.add(new Form(id, name, creatorId, departmentId));
//        forms.add(new Form("2", "second form", creatorId, departmentId));
//        forms.add(new Form("3", "third form", creatorId, departmentId));

        Adapter adapter = new Adapter(forms);
        Log.d(TAG, "FormList: "+ adapter.getItemCount());
        recyclerView.setAdapter(adapter);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

//
//        adapter.setClickListener(getContext());



    }


//    public void readForm()
//    {
//        final String formName = "first form";
//        myRef= database.getReference().child("forms");
//
//        // Read from the database
//        myRef.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(DataSnapshot dataSnapshot) {
//                // This method is called once with the initial value and again
//                // whenever data at this location is updated.
////                String value = dataSnapshot.getKey();
////                String value = dataSnapshot.getRef().push().getKey();
//                String table = "name";
//                String name = dataSnapshot.child(table).getValue().toString();
//                if(name.equals(formName)){
//                    Toast.makeText(MainActivity.this, "hello" , Toast.LENGTH_LONG).show();
//                }
//            }
//
//            @Override
//            public void onCancelled(DatabaseError error) {
//                // Failed to read value
//                Log.w(TAG, "Failed to read value.", error.toException());
//            }
//        });
//    }
//

    public ArrayList<Form> readAllForm()
    {
        Log.d(TAG, "readAllForm: start");
        database = FirebaseDatabase.getInstance();

//        myRef= database.getReference().child("forms").child("name");

        myRef= database.getReference().child("forms");

        // Read from the database
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                for (DataSnapshot myform : dataSnapshot.getChildren()) {
                    User form = myform.getValue(User.class);
                    Log.d(TAG, "onDataChange: "+form);
//                    forms.add(form);
                }
            }

            @Override
            public void onCancelled(DatabaseError error) {
            }
        });
        // Read from the database

//        myRef.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(DataSnapshot dataSnapshot) {
//                Log.d(TAG, "onDataChange: start");
//                for (DataSnapshot postSnapshot: dataSnapshot.getChildren())
//                {
////                    postSnapshot.getValue()
//                    Form form = postSnapshot.getValue(Form.class);
//                    Log.d(TAG, "onDataChange: 1"+ form);
//
//                    String id = myRef.push().getKey();
//                    Log.d(TAG, "onDataChange: id = "+id);
//                    String name = (String) postSnapshot.child("name").getValue();
//                    String creatorId = (String) postSnapshot.child("creatorId").getValue();
//                    String departmentId = (String) postSnapshot.child("departmentId").getValue();
//                    if (postSnapshot.child("questions").exists())
//                    {
//                        Toast.makeText(getContext(), "hello", Toast.LENGTH_SHORT).show();
////                        ArrayList< Question > questions = (ArrayList<Question>) postSnapshot.child("questions").getValue();
////                        Form form = new Form(id , name, creatorId, departmentId , questions);
////
//                    }
//                    else
//                    {
//                        Toast.makeText(getContext(), "bellloooo", Toast.LENGTH_SHORT).show();
////                        Form form = new Form(id , name, creatorId, departmentId );
//
//                    }
//                    forms.add(form);
//
//                }
//                Log.d(TAG, "onDataChange: 1");
//                Toast.makeText(getContext(), "Failed to read value.", Toast.LENGTH_SHORT).show();
//            }
//
//            @Override
//            public void onCancelled(DatabaseError error) {
//                // Failed to read value
//                Toast.makeText(getContext(), "Failed to read value.", Toast.LENGTH_SHORT).show();
//                Log.w(TAG, "Failed to read value.", error.toException());
//            }
//        });
//
        return forms;
    }



}
