package app.vezba5;

/**
 * TypeInterfaceExample
 */
public class TypeInterfaceExample {

    public static void main(String[] args) {
       
        // ovako koristimo lambdu
        StringLenghtLambda myLambda = (String s) -> s.length();
        // moze jos krace posto se iz interfejsa vidi kog je tipa parametar nemoramo ga navoditi
        StringLenghtLambda myLambda2 = (s) -> s.length();
        // SAMO AKO lambda izraz ima JEDAN parametar nemora ni zagrada - to je najkrace
        StringLenghtLambda myLambda3 = s -> s.length();
        String string = "Baki";
        System.out.println(myLambda.blabla("Balenovic Zeljko"));
        System.out.println(myLambda2.blabla("Balenovic Zeljko Baki"));
        System.out.println(myLambda3.blabla(string));

        printLambda(myLambda2);
        printLambda(s -> s.length());   // ovako se lambda izraz direkt prosledi kao parametar bez promenjive
    }

    public static void printLambda(StringLenghtLambda lambda) {
        System.out.println(lambda.blabla("lambda vezba print"));
    }

    interface StringLenghtLambda {
        int blabla(String s);
    }
}