import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Bem-vindo ao seu Iphone!");
        System.out.println("Como gostaria de ser chamado?:");

        IPhone iphone = new IPhone();
        iphone.setName(sc.nextLine());

        var name = iphone.getName();

        System.out.println(name + ", qual é o seu número? (Apenas números)");
        boolean acceptNumber = false;

        while (!acceptNumber) {
            try {
                var phoneNumber = sc.nextInt();
                iphone.setNumber(phoneNumber);
                acceptNumber = true;
            } catch (InputMismatchException e) {
                System.out.println("Por favor, digite apenas números:");
                sc.nextLine();
            }
        }

        var action = 0;
        while (action != 4) {
            try {
                showApps(iphone);
                action = sc.nextInt();
                switch (action) {
                    case 1 -> playerMusic(iphone);
                    case 2 -> phone();
                    case 3 -> safari();
                }
            } catch (InputMismatchException e) {
                System.out.println("===================");
                System.out.println("Por favor, digite apenas números:");
                System.out.println("===================");
                sc.nextLine();
                System.out.println();
            }
        }

        System.out.println("Desligando... Até mais!");
    }

    public static void showApps(IPhone iphone) {
        System.out.println();
        System.out.println("Iphone de " + iphone.getName() + ", Número: " + iphone.getNumber() + "\n" +
                "Escolha qual app você deseja abrir: \n" +
                "1 - Reprodutor Musical \n" +
                "2 - Telefone \n" +
                "3 - Navegador de Internet \n" +
                "4 - Desligar Aparelho"
        );
    }

    public static void playerMusic(IPhone iphone) {
        System.out.println("Nenhuma música selecionada");
        PlayerMusic playerMusic = new PlayerMusic();
        Scanner sc = new Scanner(System.in);

        var action = 0;
        var musicSelected = false;

        while (action != 4) {
            try {
                System.out.println();
                System.out.println(
                        """     
                                Music Player:
                                1 - Pausar Música
                                2 - Tocar Música
                                3 - Selecionar Música
                                4 - Voltar ao menu
                                """);
                action = sc.nextInt();
                sc.nextLine();

                switch (action) {
                    case 1 -> {
                        if (musicSelected) {
                            System.out.println(playerMusic.pauseMusic());
                        } else {
                            System.out.println("Selecione uma música primeiro");
                        }
                    }
                    case 2 -> {
                        if (musicSelected) {
                            System.out.println(playerMusic.playMusic());
                        } else {
                            System.out.println("Selecione uma música primeiro");
                        }
                    }
                    case 3 -> {
                        System.out.println("Digite a música desejada" );
                        var music = sc.nextLine();
                        System.out.println("===================");
                        playerMusic.selectMusic(music);
                        System.out.println("===================");
                        musicSelected = true;
                    }
                }
            } catch (InputMismatchException e) {
                System.out.println("===================");
                System.out.println("Por favor, digite apenas números!");
                System.out.println("===================");
                sc.nextLine();
                System.out.println();
            }
        }
    }

    public static void phone(){
        Phone phone = new Phone();
        Scanner sc = new Scanner(System.in);

        var action = 0;

        while (action != 4) {
            try {
                System.out.println();
                System.out.println(
                        """
                                Telefone:
                                1 - Realizar Ligação
                                2 - Atender
                                3 - Correio de Voz
                                4 - Voltar ao menu
                                """);
                action = sc.nextInt();
                sc.nextLine();

                switch (action) {
                    case 1 -> System.out.println(phone.call());
                    case 2 -> System.out.println(phone.answer());
                    case 3 -> System.out.println(phone.voicemail());
                }
            } catch (InputMismatchException e) {
                System.out.println("===================");
                System.out.println("Por favor, digite apenas números!");
                System.out.println("===================");
                sc.nextLine();
                System.out.println();
            }
        }
    }

    public static void safari(){
        Safari safari = new Safari();
        Scanner sc = new Scanner(System.in);

        var action = 0;

        while (action != 4) {
            try {
                System.out.println();
                System.out.println(
                        """
                                Safari:
                                1 - Acessar Site
                                2 - Abrir nova aba
                                3 - Recarregar página
                                4 - Voltar ao menu
                                """);
                action = sc.nextInt();
                sc.nextLine();

                switch (action) {
                    case 1 -> {
                        System.out.println("Digite ou cole o link do site");
                        var url = sc.next();
                        System.out.println("===================");
                        System.out.println(safari.url(url));
                        System.out.println("===================");
                    }
                    case 2 -> {
                        System.out.println("===================");
                        System.out.println(safari.newTab());
                        System.out.println("===================");
                    }
                    case 3 -> {
                        System.out.println("===================");
                        System.out.println(safari.attPage());
                        System.out.println("===================");
                    }
                }
            } catch (InputMismatchException e) {
                System.out.println("===================");
                System.out.println("Por favor, digite apenas números!");
                System.out.println("===================");
                sc.nextLine();
                System.out.println();
            }
        }
    }
}