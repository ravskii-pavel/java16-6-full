/**
 * Created by Pavel on 21.12.2016.
 */
public class TypeDrink {
    String nameDrink;
    int quantityMlLitres;
    TypeDrink(String nameDrink, int quantityMlLitres){
        this.nameDrink = nameDrink;
        this.quantityMlLitres = quantityMlLitres;
    }

    public int getQuantityMlLitres() {
        return quantityMlLitres;
    }

    public String getNameDrink() {
        return nameDrink;
    }

    @Override
    public int hashCode(){
        final int PRIME = 31;
        int result = 37;
        result = PRIME * result + getQuantityMlLitres();
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) { return false; }
        if (obj == this) { return true; }
        if (obj instanceof Waiter) { //если есть унаследованные классы
            TypeDrink typeDrink = (TypeDrink) obj;
            if (this.nameDrink != null && typeDrink.getNameDrink() != null) {
                return typeDrink.getNameDrink().equals(this.nameDrink) &&  typeDrink.getQuantityMlLitres() == this.quantityMlLitres;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "nameDrink: " + nameDrink + "\nquantityMlLitres: " + quantityMlLitres;
    }


}
