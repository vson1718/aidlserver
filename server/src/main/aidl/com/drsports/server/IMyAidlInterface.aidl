// IMyAidlInterface.aidl
package com.drsports.server;

// Declare any non-default types here with import statements



import com.drsports.server.Person;

interface IMyAidlInterface {
   void addPerson(in Person person);
   List<Person> getPersonList();
}
