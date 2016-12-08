import java.util.Random;

/* 3) Описать объект студента который должен обладать свойствами: имя(строка), фамилия(строка), возраст(число),
      язык(перечисление), факультет(перечисление).*/
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
   /* 4) Переопределить в классе студента метод toString() таким образом, чтобы в результате его вызова для объекта
    студента с выбранным языком EN возвращалась строка вида: "Ron Weasley is 24 years old and studying at Griffindor faculty".
    Либо, если язык был выбран RU возвращалась строка вида: "Ron Weasley 24 лет, студент факультета Гриффиндор".*/
    @Override
    public String toString(){
        if(this.typeLang == typeLang.EN){
            return this.firstName + " " + this.secondName + " is " + this.age + " years old " + " and studying at " + nameFaculty.nameEn + " faculty";
        }
        else{
            return this.firstName + " " + this.secondName + " " + this.age + " лет, студент факультета " + nameFaculty.nameRu;
        }
    }

    /*6) Дан массив из 20 студентов. Определить к какому факультету в школе магии Хогвартс будет зачислен каждый из них.
    Учесть то, что к каждому факультету может быть зачислено не более пяти новых студентов.
    Также факультеты могут быть определены только случайным образом.*/

    public static void choiceFaculty(Student [] students){

        Random random = new Random();
        int i, j;
        i = j = 0;
        int [] mass = new int[Faculty.values().length];
        while (i < students.length){
            students[i].nameFaculty = Faculty.values()[random.nextInt(Faculty.values().length)];
            while (j < mass.length) {
                if (students[i].nameFaculty == Faculty.values()[j]) {
                    if (mass[j] == 5){
                        students[i].nameFaculty = Faculty.values()[random.nextInt(Faculty.values().length)];
                        j=0;
                    }
                    else {
                        mass[j]++;
                        j++;
                        break;
                    }
                }
                else{
                    j++;
                }
            }
            System.out.println(students[i]);
            j=0;
            i++;
        }
    }
}
