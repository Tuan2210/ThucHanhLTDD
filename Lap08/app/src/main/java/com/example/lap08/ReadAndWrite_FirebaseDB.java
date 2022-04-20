//package com.example.lap08;
//
//import android.content.Context;
//import android.util.Log;
//
//import androidx.annotation.NonNull;
//
//import com.google.android.gms.tasks.OnCompleteListener;
//import com.google.android.gms.tasks.OnFailureListener;
//import com.google.android.gms.tasks.OnSuccessListener;
//import com.google.android.gms.tasks.Task;
//import com.google.firebase.database.DataSnapshot;
//import com.google.firebase.database.DatabaseError;
//import com.google.firebase.database.DatabaseReference;
//import com.google.firebase.database.FirebaseDatabase;
//import com.google.firebase.database.MutableData;
//import com.google.firebase.database.ServerValue;
//import com.google.firebase.database.Transaction;
//import com.google.firebase.database.ValueEventListener;
//
//import java.util.HashMap;
//import java.util.Map;
//
//public class ReadAndWrite_FirebaseDB {
//    private static final String TAG = "ReadAndWrite_FirebaseDB";
//
//    private DatabaseReference reference;
//
//    public ReadAndWrite_FirebaseDB(Context context, DatabaseReference reference) {
//        reference = FirebaseDatabase.getInstance().getReference();
//    }
//
//    //ghi dữ liệu
//    public void writeNewAcc(String accId, String name, String email, String passWord){
//        Account account = new Account(name, email, passWord);
//
//        reference.child("accounts").child(accId).child(name).child(email).child(passWord).setValue(account);
//    }
//
//    //đọc dữ liệu
//    public void addPostEventListener(DatabaseReference reference){
//        ValueEventListener postListener = new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot snapshot) {
//                Account account = snapshot.getValue(Account.class);
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError error) {
//                Log.w(TAG, "loadPost:onCancelled", error.toException());
//            }
//        };
//
//        //lấy data nhanh bằng id
////        reference.child("accounts").child(accId).get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
////            @Override
////            public void onComplete(@NonNull Task<DataSnapshot> task) {
////                if (!task.isSuccessful()) {
////                    Log.e("firebase", "Error getting data", task.getException());
////                }
////                else {
////                    Log.d("firebase", String.valueOf(task.getResult().getValue()));
////                }
////            }
////        });
//
//        reference.addValueEventListener(postListener);
//    }
//
//    //cập nhật db
//    public void writeNewPost(int accId, String name, String email, String passWord) {
//        String key = reference.child("posts").push().getKey();
//        Account account = new Account(accId, name, email, passWord);
//        Map<String, Object> postValues = account.toMap();
//
//        Map<String, Object> childUpdates = new HashMap<>();
//        childUpdates.put("/posts/" + key, postValues);
//        childUpdates.put("/user-posts/" + accId + "/" + key, postValues);
//
//        reference.updateChildren(childUpdates);
//    }
//
//    //Add a Completion Callback
//    public void writeNewUserWithTaskListeners(int accId, String name, String email, String passWord) {
//        Account account = new Account(accId, name, email, passWord);
//
//        // [START rtdb_write_new_user_task]
//        reference.child("accounts").child(String.valueOf(accId)).setValue(account)
//                .addOnSuccessListener(new OnSuccessListener<Void>() {
//                    @Override
//                    public void onSuccess(Void aVoid) {
//                        // Write was successful!
//                        // ...
//                    }
//                })
//                .addOnFailureListener(new OnFailureListener() {
//                    @Override
//                    public void onFailure(@NonNull Exception e) {
//                        // Write failed
//                        // ...
//                    }
//                });
//        // [END rtdb_write_new_user_task]
//    }
//
//    //lưu data as transactions
//    public void onStarClicked(DatabaseReference postRef) {
//        postRef.runTransaction(new Transaction.Handler() {
//            @Override
//            public Transaction.Result doTransaction(MutableData mutableData) {
//                Account acc = mutableData.getValue(Account.class);
//                if (acc == null) {
//                    return Transaction.success(mutableData);
//                }
//
//                if (acc.stars.containsKey(acc.getId())) {
//                    // Unstar the post and remove self from stars
//                    acc.stars.remove(acc.getId());
//                } else {
//                    // Star the post and add self to stars
//                    acc.stars.put(String.valueOf(acc.getId()), true);
//                }
//
//                // Set value and report transaction success
//                mutableData.setValue(acc);
//                return Transaction.success(mutableData);
//            }
//
//            @Override
//            public void onComplete(DatabaseError databaseError, boolean committed,
//                                   DataSnapshot currentData) {
//                // Transaction completed
//                Log.d(TAG, "postTransaction:onComplete:" + databaseError);
//            }
//        });
//    }
//
//    //Atomic server-side increments
//    private void onStarClicked(String uid, String key) {
//        Map<String, Object> updates = new HashMap<>();
//        updates.put("posts/"+key+"/stars/"+uid, true);
//        updates.put("posts/"+key+"/starCount", ServerValue.increment(1));
//        updates.put("user-posts/"+uid+"/"+key+"/stars/"+uid, true);
//        updates.put("user-posts/"+uid+"/"+key+"/starCount", ServerValue.increment(1));
//        reference.updateChildren(updates);
//    }
//}
