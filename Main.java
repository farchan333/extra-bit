
import java.util.*;

public class Main {
    Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
        Integer[] angka = {56,160,208,152,154,174,158,132,234};
        int kolom = 3;
        String[] binner = new String[angka.length];
        List<List<String>> bin = new LinkedList<>();
        int baris = angka.length/kolom;

        System.out.println("Nilai yang di input : \n");
        int start = 0;
        for (int i = 1; i <= baris; i++) {
            for (int j = 1; j <= kolom; j++) {
                System.out.format("%s\t\t",angka[start]);
                start++;
            }
            System.out.println();
        }

        System.out.println();
        System.out.println("konversi ke binner : \n");
        start = 0;
        for (int i = 1; i <= baris; i++) {
            for (int j = 1; j <= kolom; j++) {
                System.out.format("U(%S,%S) =\t%s\t = %08d\n",i,j,angka[start],Integer.valueOf(Integer.toBinaryString(angka[start])));
                binner[start] = Integer.toBinaryString(angka[start]);

                bin.add(new LinkedList<>(List.of(binner[start])));
                start++;
            }
        }


        int lengthTerkecil = 8;
        for (List<String> strings : bin) {
            if (lengthTerkecil > strings.toString().length()-2){
                lengthTerkecil = strings.toString().length()-2;
            }
        }

        System.out.println("\nMenentukan UB : \n");
        for (int i = 1; i <= 8; i++) {
            StringBuilder builder = new StringBuilder();
            System.out.printf("Ub%S = ",i);
            for (List<String> strings : bin) {
                try{
                    for (String string : strings) {
                        System.out.print(string.charAt(strings.toString().length()-2-i));
                    }
                }catch (Exception e){
                    System.out.print(0);
                }
            }
            System.out.println();
        }



        ArrayList<String> nilai = new ArrayList<>();
        System.out.println("\nKali masing-masing nilai binner ub : \n");
        for (int i = 1; i <= 8; i++) {
//            StringBuilder builder = new StringBuilder();
            StringJoiner builder = new StringJoiner("|","[","]");
            System.out.printf("Ub%S = ",i);
            for (List<String> strings : bin) {
                try{
                    for (String string : strings) {
                        String tes = String.valueOf(string.charAt(strings.toString().length()-2-i));
                        builder.add(Integer.valueOf(tes)*255+"");
                        nilai.add(Integer.valueOf(tes)*255+"");
                    }
                }catch (Exception e){
                    builder.add("0");
                    nilai.add("0");
                }
            }
            System.out.println(builder.toString());
        }
        int value = 0;
        for (int i = 1; i <= nilai.size()/(baris*kolom) ; i++) {
            for (int j = 1; j <= baris; j++) {
                for (int k = 1; k <= kolom; k++) {
                    System.out.printf("""
                            ub%s(%s,%s) = %s
                            """,i,j,k,nilai.get(value));
                    value++;
                }
            }
        }
    }
}