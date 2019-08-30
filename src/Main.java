public class Main {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Latrell\\Desktop\\chromedriver.exe");

        while(true){

            Gems gem = new Gems();

            while (!gem.approve.getModel().isPressed() && !gem.dismiss.getModel().isPressed());

        }
    }
}
