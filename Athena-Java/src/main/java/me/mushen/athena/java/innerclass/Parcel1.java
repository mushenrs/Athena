package me.mushen.athena.java.innerclass;

/**
 * @Desc
 * @Author Remilia
 * @Create 2016-09-27
 */
public class Parcel1 {

    public void ship(String dest){
        Contents contents = contents();
        Destination destination = to(dest);
        System.out.println(contents.value());
        System.out.println(destination.readLabel());
    }

    public Destination to(String s){
        return new Destination(s);
    }

    public Contents contents(){
        return new Contents();
    }

    public static void main(String[] args){
        Parcel1 parcel1 = new Parcel1();
        parcel1.ship("Tasmania");
    }

    class Contents {
        private int i = 11;

        public int value(){
            return i;
        }
    }

    class Destination {
        private String label;

        Destination(String label) {
            this.label = label;
        }

        String readLabel(){
            return label;
        }
    }
}
