package me.mushen.athena.springdata.es.build;

import me.mushen.athena.springdata.es.document.Person;

/**
 * @Desc
 * @Author Remilia
 * @Create 2016-11-09
 */
public final class PersonBuilder {
    private Person person;

    public PersonBuilder(Integer id){
        person = new Person(id);
    }

    public PersonBuilder setName(String name){
        person.name = name;
        return this;
    }

    public PersonBuilder setVersion(Long version){
        person.version = version;
        return this;
    }

    public PersonBuilder setCar(Person.Car car){
        person.carList.add(car);
        return this;
    }

    public PersonBuilder setCar(String name, String model){
        person.carList.add(new Person.Car(name, model));
        return this;
    }

    public Person build(){
        return person;
    }
}
