package com.luc.phonespecs.service;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.*;
import com.luc.phonespecs.models.phone.PhoneBrand;
import com.luc.phonespecs.models.phone.development.PhoneDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

@Service
public class FirestoreServiceDevelopment {

    @Autowired
    Firestore db;

    public List<PhoneBrand> getAllBrands() throws ExecutionException, InterruptedException {
        ApiFuture<QuerySnapshot> future =
                db.collection("brands").get();
        List<QueryDocumentSnapshot> documents = future.get().getDocuments();
        List<PhoneBrand> phoneBrands = new ArrayList<>();
        for (DocumentSnapshot document : documents) {
            phoneBrands.add(document.toObject(PhoneBrand.class));
        }

        return phoneBrands;
    }

    public void addPhoneDetail(List<PhoneDetails> phoneDetails) {
        CollectionReference colRef = db.collection("phone_details");
        WriteBatch batch = db.batch();
        for (PhoneDetails data : phoneDetails) {
            batch.create(colRef.document(), data);
        }
        batch.commit();
    }

    public void saveBrand(List<PhoneBrand> phoneBrands) throws ExecutionException, InterruptedException {
        CollectionReference colRef = db.collection("brands");
        WriteBatch batch = db.batch();
        for (PhoneBrand data : phoneBrands) {
            batch.create(colRef.document(), data);
        }
        batch.commit();
    }
}
