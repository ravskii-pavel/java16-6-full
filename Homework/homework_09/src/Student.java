import java.util.Random;

/**
 * Created by ravskiy on 06.12.2016.
 */
public class Student {

    String firstName;
    String secondName;
    int age;
    Lang typeLang;
    Faculty nameFaculty;

    Student(Lang typeLang, String firstName, String secondName, int age, Faculty nameFaculty){
        this.typeLang = typeLang;
        this.firstName = firstName;
        this.secondName = secondName;
        this.age = age;
        this.nameFaculty = nameFaculty;
    }

    @Override
    public String toString(){
        if(typeLang == Lang.EN){
            return this.firstName + " " + this.secondName + " is " + this.age + " years old " + " and studying at " + nameFaculty.nameEn + " faculty";
        }
        else{
            return this.firstName + " " + this.secondName + " " + this.age + " лет, студент факультета " + nameFaculty.nameRu;
        }
    }

    public String[] randomFaculty(){
        String [] random  = Faculty.toString(Faculty.values());

        return random;
    }
}
