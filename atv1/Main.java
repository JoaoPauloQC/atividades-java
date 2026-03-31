import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Scanner;

public class Main {

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        String[] students_name = new String[10];
        Integer[] students_age = new Integer[10];
        do{
            printMenu();
            try{
                int choice = sc.nextInt();
                int index_to_be_added_age = findNextAdd(students_age);
                int index_to_be_added_name = findNextAdd(students_name) ;
                if(choice == 1 ){
                    if(index_to_be_added_age != -1 && index_to_be_added_name != -1){
                        printDoIt("Digite o nome do aluno: ");
                        sc.nextLine();
                        String name = sc.nextLine();
                        int idade = 0;
                        while(true){
                            printDoIt("Digite a idade: ");
                            idade = sc.nextInt();
                            if(idade < 0){
                                System.out.println("Idade inválida.");
                            }
                            else{
                                break;
                            }
                        }
                        students_age[index_to_be_added_age] = idade;
                        students_name[index_to_be_added_name] = name;
                    
                    }else{
                        System.out.println("Limite atingido");
                    }
                    
                }
                else if( choice == 2){
                    System.out.print("Idades: ");
                    list(students_age);
                    System.out.print("Nomes: ");
                    list(students_name);
                    System.out.println("Quantidade de alunos cadastrados: "+ howManyStudents(students_name));
                }
                else if(choice == 3){
                    printDoIt("Digite o nome que deseja buscar: ");
                    sc.nextLine();
                    String name = sc.nextLine();
                    int position = searchStudent(students_name,name);
                    if(position == -1){
                        System.out.println("Nome não encontrado");
                    }
                    else{
                        System.out.println("Nome encontrado na posição: " + position);
                    }
                }
                else if(choice == 4){
                    System.out.println("Média de idade é: " + media(students_age));
                }
                else if(choice == 5){
                    System.out.println("Data atual: " + formmatedData(LocalDateTime.now()));
                }
                else if( choice == 6){
                    break;
                }
                else{
                    System.out.println("Escolha inválida. ");
                }
            }catch(Exception e){
                System.out.println("Escolha inválida. " + e);
                sc = new Scanner(System.in);
            }
        }
        while(true);
    }

    public static void printMenu(){
        System.out.println("Menu \n" + "1 - Cadastrar aluno\n" + //
                        "2 - Listar alunos\n" + //
                        "3 - Buscar aluno por nome\n" + //
                        "4 - Calcular média de idade\n" + //
                        "5 - Exibir data/hora atual\n" + //
                        "6 - Sair");
    }
    public static void printDoIt(String it){
        System.out.println(it);;
    }

    public static void list(String[] list){
        String text = "";
        for(int i = 0; i<list.length;i++){
            if(list[i] != null){
                text += " " + list[i];
            }
        }
        System.out.println(text);
    }
    public static void list(Integer[] list){
        String text = "";
        for(int i = 0; i<list.length;i++){
            if(list[i] != null){
                text += " " + list[i];
            }
        }
        System.out.println(text);
    }

    public static int searchStudent(String[] list, String name){
        for(int i = 0; i<list.length;i++){
            if(list[i] != null){
                if(list[i].equals(name)){
                    return i;
                }
            }
        }
        return -1;
    }
    public static int findNextAdd(String[] list){
        for(int i = 0; i<list.length;i++){
            if(list[i] == null){
                return i;
            }
        }
        return -1;
    }
    public static int findNextAdd(Integer[] list){
        for(int i = 0; i<list.length;i++){
            if(list[i] == null){
                return i;
            }
        }
        return -1;
    }
    public static Double media(Integer[] list){
        double divisor = 0;
        double sum = 0;
        for(int i = 0; i<list.length; i++){
            if(list[i] != null){
                divisor++;
                sum+=(double) list[i];
            }
        }
        return divisor == 0? 0 : sum/divisor;
        

    }
    public static String formmatedData(LocalDateTime localDateTime){
        int day = localDateTime.getDayOfMonth();
        int month = localDateTime.getMonthValue();
        int year = localDateTime.getYear();
        int hours = localDateTime.getHour();
        int minutes = localDateTime.getMinute();
        return " dia " + day + " de " + month + " de " + year + ", no horário " + hours + ":" + minutes;

    }

    public static int howManyStudents(String[] list){
        int count = 0;
        for(int i =0 ; i<list.length;i++){
            if(list[i] != null){
                count++;
            }
        }
        return count;
    }

}