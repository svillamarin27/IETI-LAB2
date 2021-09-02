package org.ada.school.repository;
import org.ada.school.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.ArrayList;

public interface UserRepository extends MongoRepository<UserDocument, String> {
    ArrayList<User> findAll(UserDocument userDocument);
}
