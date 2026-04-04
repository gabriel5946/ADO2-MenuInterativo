import java.util.Scanner;

public class Exercicio2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
int opção = 0,
int hp = 100;
int xp = 0;

while (opção != 4 && hp > 0){
    System.out.println("\n===MENU===");
    System.out.println("1 - Instruções");
    System.out.println("2 - jogar");
    System.out.println("3 - Creditos");
    System.out.println("4 Sair");

    opção sc.nextInt();
    if(oção == 1){
        System.out.println("Explore para ganhar pontos e descanse para recuperar HP.");
        System.out.println("Se seu HP a 0, seu personagem morre e o jogo acaba.");
        System.out.printLn();

    }
    else if (opção == 2){
        
        int escolha = 0;

        while (escolha != 3 && hp > 0){
            System.out.printLn("\nHP: " + hp);
            System.out.printLn("XP: " + xp);
            System.out.printLn("1 - Explorar");
            System.out.printLn("2 - descansar " );
            System.out.printLn("3 - voltar");

            escolha = sc.nextInt();
            
            if(escolha == 1){
                hp = hp -10;
                xp = xp +20;
                System.out.println("Voce explorou!");
            }else if (escolha == 2 ){
                hp = hp + 15;
                System.out.println("Voce descansou!");
            }else if (escolha == 3){
                System.out.println("voltando...");
            }else{
                Syetem.out.println("sua opção foi inválida!");
            }
        }
    } else if (opção == 4) {
        System.out.println("voce esta saindo...");
    } else {
        System.out.println("sua opção foi Invalida!");
    }
    System.out.println();
}
if (hp <=0){
    System.out.println("seu personagem morreu!");
}
sc.close();

}

    }
