import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/*
Сначала Вася объявляет, сколько очков нужно набрать, чтобы игра закончилась.
Затем Петя берет карточки, на которых написаны целые неотрицательные числа, и начинает выкладывать
их на стол одну за другой. Если на карточке число, кратное пяти, то Вася получает одно очко.
Если на карточке число, кратное трем, то одно очко получает Петя.
Если на карточке число, не кратное ни трем, ни пяти, или наоборот, кратное им обоим,
то очков не получает никто.
Как только кто-то из участников наберет количество очков, которое назвал в начале игры Вася,
игра прекращается и этот игрок становится победителем.
Если никто из участников не набрал нужного количества очков, но при этом все карточки закончились,
то победителем считается игрок, у которого больше очков. Если все карточки закончились, а очков поровну,
то объявляется ничья.
Петя и Вася иногда очень спешат, поэтому хотят не играть в игру полностью, а сразу узнать, кто выиграл
бы при известных начальных данных. Они попросили вас написать программу, которая поможет
ответить на этот вопрос.
Входные данные
В первой строке через пробел даны два целых положительных числа: количество очков K, которое
объявляет в начале игры Вася, и количество карточек N, которые есть у Пети. В следующей строке даны N
целых неотрицательных чисел, разделенных пробелом, каждое из которых не превосходит 1000.
Выходные данные
В единственной строке выведите Petya, если в игре побеждает Петя, Vasya, если в игре побеждает Вася,
или Draw, если победителя выявить не удалось.
входные данные
3 10
1 2 3 4 5 6 7 8 9 10
выходные данные
Petya
=====
входные данные
4 16
1 2 3 4 5 6 7 8 9 10 15 20 25 24 21 18
выходные данные
Vasya
======
входные данные
3 5
3 5 15 15 15
выходные данные
Draw
 */
public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner=new Scanner(new File("input.txt"));
        String line1= scanner.nextLine();
        String[] s1 =line1.split(" ");
        int k= Integer.parseInt(s1[0]); // количество очков объявляет Вася
        int n= Integer.parseInt(s1[1]); //количество карточек есть у Пети
        String line2= scanner.nextLine();
        String[] s2=line2.split(" ");
        int[] mass=new int[s2.length];
        for (int i = 0; i < s2.length; i++) {
            mass[i]=Integer.parseInt(s2[i]);
        }
        findPoints(mass, k, n);
    }
    public static void findPoints(int[] mass, int k, int n){
        int countVasya =0;
        int countPetya=0;
        for (int i = 0; i < mass.length; i++) {
            if (mass[i] % 5 == 0 && mass[i] % 3 != 0){
                countVasya++;
            }
            if (mass[i] % 3 == 0 && mass[i] % 5 != 0){
                countPetya++;
            }
            if (countVasya==k || countPetya==k){
                if (countVasya == k){
                    System.out.println("Vasya");
                }
                if (countPetya == k){
                    System.out.println("Petya");
                }
                break;
            }
            if (countVasya == countPetya && i==(n-1)){
                System.out.println("Draw");
            }
            if (countVasya > countPetya && i==(n-1)) {
                System.out.println("Vasya");
            }
            if (countPetya > countVasya && i==(n-1)) {
                System.out.println("Petya");
            }
        }
    }

}
