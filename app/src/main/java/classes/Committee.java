package classes;

import android.util.Log;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Committee {
    int ID;
    String Name;

    // Write a message to the database
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference("committee");

    public int getID() {
        return ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public void addCommittee()
    {
        if(!this.Name.equals(null))
            myRef.push().setValue(this);
    }

    public Committee(int ID) {
        this.ID = ID;
        // Read from the database
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot val : dataSnapshot.getChildren()){
                    Log.v("Key",val.getKey());
                    Log.v("Value",val.getValue().toString());
//                    Committee myCommittee=(Committee) val.getValue();
//                    Log.v("Child","ID: "+myCommittee.getID()+" Name: "+myCommittee.getName());
//                    if(val.getKey().contains("Hotel")){
//                        //Do what you want with the record
//                    }
//                    if(val.child("hotel").getValue(String.class).contains("Hotel")){
//                        //Do what you want with the record
//                    }
                }
//                Committee myCommittee = dataSnapshot.getValue(Committee.class);
//                Log.v("ID", "ID: " + myCommittee.ID);
//                Log.v("Name", "Name: " + myCommittee.Name);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.v("Error", "Failed to read value.", error.toException());
            }
        });
    }

    public Committee(String name) {
        Name = name;
    }

    public Committee() {
    }
}
