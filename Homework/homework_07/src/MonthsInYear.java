/**
 * Created by Pavel on 01.12.2016.
 */
/* 8) Опишите с помощью enum тип данных для хранения месяцев. У каждого месяца должны быть следующие свойства:
    номер месяца, название на английском, название на русском, количество дней. Написать конструктор со
    всеми параметрами, а также геттеры.
*/
public enum MonthsInYear {

        JANUARY(1, "January", "Январь", 31),
        February(2, "February", "Февраль", 28),
        March(3, "March", "Март", 31),
        April(4, "April", "Апрель", 30),
        May(5, "May", "Май", 31),
        June(6, "June", "Июнь", 30),
        July(7, "July", "Июль", 31),
        August(8, "August", "Август", 31),
        September(9, "September", "Сентябрь", 30),
        October(10, "October", "Октябрь", 31),
        November(11, "November", "Ноябрь", 30),
        December(12, "December", "Декабрь", 31);

        int numMonth;
        String enNameMonth;
        String ruNameMonth;
        int countOfDays;

        MonthsInYear(int numMonth, String enNameMonth, String ruNameMonth, int countOfDays){

            this.numMonth = numMonth;
            this.enNameMonth = enNameMonth;
            this.ruNameMonth = ruNameMonth;
            this.countOfDays = countOfDays;
        }

        public int getNumMonth() {
           return numMonth;
        }

        public String getEnNameMonth() {
            return enNameMonth;
        }

        public String getRuNameMonth() {
            return ruNameMonth;
        }

        public int getCountOfDays() {
            return countOfDays;
        }
}
