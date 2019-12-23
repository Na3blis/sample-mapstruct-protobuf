package com.example.mapstruct.example.model;

import lombok.Data;

import java.util.List;
import java.util.Set;

@Data
public class User {
    private String id;
    private String idType;
    private String lastName;
    private String firstName;
    private String middleName;
    private Set<String> authorizedResources;
    private List<String> authorizedRoles;
    private Boolean securityAndPrincipalExist = true;

    //
    //
    //public List<String> getAuthorizedRoles() {
    //    if (authorizedRoles == null) {
    //        authorizedRoles = new ArrayList<>();
    //    }
    //    return authorizedRoles;
    //}

    public boolean containsRole(final String role) {
        return authorizedRoles.stream().anyMatch(role::equalsIgnoreCase);
    }
}
