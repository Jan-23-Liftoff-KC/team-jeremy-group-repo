package com.digitalfilingcabinet.demo.models;



import javax.persistence.Entity;
import java.util.ArrayList;


@Entity
public class UserList extends AbstractBaseClass{

    public static ArrayList<User> findByColumnAndValue(String column, String value, Iterable<User> allUsers) {

        ArrayList<User> results = new ArrayList<>();

        if (value.toLowerCase().equals("all")){
            return (ArrayList<User>) allUsers;
        }

        if (column.equals("all")){
            results = findByValue(value, allUsers);
            return results;
        }
        for (User user : allUsers) {

            String aValue = getFieldValue(user, column);

            if (aValue != null && aValue.toLowerCase().contains(value.toLowerCase())) {
                results.add(user);
            }
        }

        return results;
    }

    public static String getFieldValue(User user, String fieldName){
        String theValue;
        if (fieldName.equals("first_name")){
            theValue = user.getFirstName();
        } else if (fieldName.equals("last_name")){
            theValue = user.getLastName();
        } else if (fieldName.equals("phone")){
            theValue = String.valueOf(user.getPhoneNumber());
        } else if (fieldName.equals("email")){
            theValue = user.getEmail();
        } else if (fieldName.equals("role")){
            theValue = user.getRole().toString();
        } else {
            theValue = user.getRelationships().toString();
        }

        return theValue;
    }

    /**
     * Search all User fields for the given term.
     *
     * @param value The search term to look for.
     * @param allUsers The list of users to search.
     * @return      List of all users with at least one field containing the value.
     */
    public static ArrayList<User> findByValue(String value, Iterable<User> allUser) {
        String lower_val = value.toLowerCase();

        ArrayList<User> results = new ArrayList<>();

        for (User user : allUsers) {

            if (user.getFirstName().toLowerCase().contains(lower_val)) {
                results.add(user);
            } else if (user.getLastName().toLowerCase().contains(lower_val)) {
                results.add(user);
            } else if (user.getRole().toString().toLowerCase().contains(lower_val)) {
                results.add(user);
            } else if (user.getRelationships().toString().toLowerCase().contains(lower_val)) {
                results.add(user);
            } else if (user.toString().toLowerCase().contains(lower_val)) {
                results.add(user);
            }

        }

        return results;
    }


}
