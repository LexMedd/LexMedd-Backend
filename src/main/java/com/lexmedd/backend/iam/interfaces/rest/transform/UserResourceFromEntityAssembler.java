package com.lexmedd.backend.iam.interfaces.rest.transform;

import com.lexmedd.backend.iam.domain.model.aggregates.User;
import com.lexmedd.backend.iam.interfaces.rest.resources.UserResource;

public class UserResourceFromEntityAssembler {
    public static UserResource toResourceFromEntity(User entity) {
        String Fullname = entity.getName() + " " + entity.getSurname();
        return new UserResource(
                Fullname,
                entity.getEmail(),
                entity.getPhone(),
                entity.getCountry(),
                entity.getProfession());
    }
}
