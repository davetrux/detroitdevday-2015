package com.hpe.simpleservice;

import javax.naming.InitialContext;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.naming.Context;
import javax.naming.NamingException;
/**
 * @author truxall
 */
public class NameGenerator {

    private static final String CONTEXT_NAME = "java:comp/env";

    private String mGender;

    public NameGenerator() throws NamingException {
        Context context = (Context) new InitialContext().lookup(CONTEXT_NAME);
        mGender = (String) context.lookup("gender");
    }

    public Person getRandomName() {
            Person result = new Person();
            Random generator = new Random();

            int r = generator.nextInt(Constants.getSurnames().length);

            result.setLastName(Constants.getSurnames()[r]);

            if(mGender.equals(Constants.FEMALE)){
                r =  generator.nextInt(Constants.getFemale().length);
                result.setFirstName(Constants.getFemale()[r]);
                result.setGender("f");
            } else {
                r =  generator.nextInt(Constants.getMale().length);
                result.setFirstName(Constants.getMale()[r]);
                result.setGender("m");
            }

            return result;
        }

        public Person getRandomName(String gender) {
            Person result = new Person();
            Random generator = new Random();

            int r = generator.nextInt(Constants.getSurnames().length);

            result.setLastName(Constants.getSurnames()[r]);

            if(gender.equalsIgnoreCase("f")){
                r =  generator.nextInt(Constants.getFemale().length);
                result.setFirstName(Constants.getFemale()[r]);
                result.setGender("f");
            } else {
                r =  generator.nextInt(Constants.getMale().length);
                result.setFirstName(Constants.getMale()[r]);
                result.setGender("m");
            }

            return result;
        }

        public List<Person> getRandomPersons(int count) {
            List<Person> result = new ArrayList<Person>();

            for(int i = 0; i < count; i++){
                result.add(getRandomName());
            }

            return result;
        }

        private Person getStaticPerson() {
            Person result = new Person();

            result.setFirstName("Dave");
            result.setLastName("Truxall");
            result.setGender("m");
            return result;
        }
}