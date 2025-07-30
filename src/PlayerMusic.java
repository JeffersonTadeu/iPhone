public class PlayerMusic extends IPhone {

    public String playMusic(){
        return "Música tocando";
    };

    public String pauseMusic() {
        return "Música pausada";
    }

    public void selectMusic(String music) {
        System.out.println("Música Selecionada: " + music);
    }

}
