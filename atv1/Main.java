import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        String[] students_name = new String[10];
        // int é um tipo primitivo (mais leve e rápido)
        // Integer é um objeto (wrapper), permite usar null e métodos
        Integer[] students_age = new Integer[10];
        // while: verifica a condição antes de executar
        // do-while: executa pelo menos uma vez antes de verificar
        do{
            printMenu();
            System.out.println("Quantidade de alunos cadastrados: "+ howManyStudents(students_name));
            try{
                int choice = sc.nextInt();
                int index_to_be_added = findNextAdd(students_name);
                if(choice == 1 ){
                    if(index_to_be_added != -1){
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
                        students_age[index_to_be_added] = idade;
                        students_name[index_to_be_added] = name;
                    
                    }else{
                        System.out.println("Limite atingido");
                    }
                    
                }
                else if( choice == 2){
                    list(students_name, students_age);
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
                        System.out.println("Nome encontrado na posição: " + (position + 1) + " e com a idade: " + students_age[position]);
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

    public static void list(String[] name_list,Integer[] age_list){
        for(int i = 0; i<name_list.length;i++){
            if(name_list[i] != null){
                System.out.println("Nome: " + name_list[i] + " | Idade: " + age_list[i] );
            }
        }
    }
    

    public static int searchStudent(String[] list, String name){
        for(int i = 0; i<list.length;i++){
            if(list[i] != null){
                if(list[i].equalsIgnoreCase(name)){
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
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        return localDateTime.format(formatter);
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