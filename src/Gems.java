import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Gems {

    public JButton approve;
    public JButton dismiss;

    Gems(){
        JFrame window = new JFrame("Gems");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        window.setSize(screenSize.width, screenSize.height);
        window.setVisible(true);

        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setPreferredSize(new Dimension(screenSize.width, screenSize.height));
        layeredPane.setBorder(BorderFactory.createTitledBorder(
                "System.Safespeedil.com"));
        layeredPane.setVisible(true);
        window.add(layeredPane);


        JLabel grayRect = new JLabel();
        grayRect.setOpaque(true);
        grayRect.setSize(screenSize);
        grayRect.setVisible(true);
        grayRect.setBackground(Color.gray);
        grayRect.setBounds(layeredPane.getX() + 5, layeredPane.getY() + 15, screenSize.width - 30, screenSize.height - 25);
        layeredPane.add(grayRect, 1);

        JLabel darkGray = new JLabel();
        darkGray.setOpaque(true);
        darkGray.setSize(screenSize);
        darkGray.setVisible(true);
        darkGray.setBackground(Color.darkGray);
        darkGray.setBounds(layeredPane.getX() + 5, layeredPane.getY() + 15, screenSize.width - 30, 150);
        layeredPane.add(darkGray, 0);

        JLabel blackSq = new JLabel();
        blackSq.setOpaque(true);
        blackSq.setSize(screenSize);
        blackSq.setVisible(true);
        blackSq.setBackground(Color.darkGray);
        blackSq.setBounds(layeredPane.getX() + 50, layeredPane.getY() + 250, screenSize.width - (screenSize.width/2) + 100, screenSize.height - (screenSize.height/3));
        layeredPane.add(blackSq, 1);

        String Lane = GenerateInfo.getRandLane();

        JLabel whiteRect = new JLabel();
        whiteRect.setOpaque(true);
        whiteRect.setSize(screenSize);
        whiteRect.setVisible(true);
        whiteRect.setBackground(Lane.contains("Right") ? Color.WHITE : Color.YELLOW);
        whiteRect.setBounds(blackSq.getX() + blackSq.getWidth(), layeredPane.getY() + 200, screenSize.width - (screenSize.width/2) - 300, screenSize.height - (screenSize.height/4));
        layeredPane.add(whiteRect, 1);

        JLabel citation = new JLabel("Citation: " + GenerateInfo.generateCitation() + " -- " + Lane, JLabel.CENTER);
        citation.setFont(citation.getFont().deriveFont(24.0f));
        citation.setOpaque(false);
        citation.setBounds(whiteRect.getX() + 50, whiteRect.getY() - 25, 600, 100);
        layeredPane.add(citation, 0);

        JButton approve = new JButton("Approval");
        approve.setOpaque(true);
        approve.setBounds(whiteRect.getX() + 50, whiteRect.getHeight() + 100, 200, 50);
        approve.setBackground(Color.GREEN);
        layeredPane.add(approve, 0);
        this.approve = approve;

        JButton dismiss = new JButton("Dismiss");
        dismiss.setOpaque(true);
        dismiss.setBounds(whiteRect.getX() + 400, whiteRect.getHeight() + 100, 200, 50);
        dismiss.setBackground(Color.RED);
        layeredPane.add(dismiss, 0);
        this.dismiss = dismiss;

        dismiss.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                window.dispose();
            }
        });

        approve.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                window.dispose();
            }
        });

        Font F1 = new Font("Times New Roman", Font.BOLD,36);
        JTextField LP = new JTextField(20);
        LP.setOpaque(true);
        LP.setFont(F1);
        LP.setBounds(whiteRect.getX() + 50, whiteRect.getHeight() - 50, 200, 100);
        layeredPane.add(LP, 0);


        String[] states = { "IL", "WI", "MN", "MS", "IA"};
        JComboBox<String> menu = new JComboBox<>(states);
        menu.setOpaque(true);
        menu.setBounds(whiteRect.getX() + 400, whiteRect.getHeight() - 50, 200, 50);
        layeredPane.add(menu, 0);

        JButton verify = new JButton("Verify");
        verify.setOpaque(true);
        verify.setBounds(whiteRect.getX() + 400, whiteRect.getHeight() - 150, 200, 50);
        verify.setBackground(Color.white);
        layeredPane.add(verify, 0);

        verify.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String licenseP = LP.getText();
                String state = menu.getSelectedItem().toString();
                System.out.println(licenseP + " - " + state);

                ChromeDriver driver = new ChromeDriver();
                driver.get("http://autocheck.com/");
                driver.manage().window().setPosition(new org.openqa.selenium.Point(darkGray.getX() + (darkGray.getWidth()/2), darkGray.getY()));
                driver.manage().window().setSize(new org.openqa.selenium.Dimension(500, 950));

                WebElement licensePlateEntry = driver.findElement(By.xpath("//*[@id='searchVin']/div[2]/div[2]/form/div[1]/div[1]/div/div/input"));
                licensePlateEntry.sendKeys(licenseP);

                Select stateEntry = new Select(driver.findElement(By.name("plateState")));
                stateEntry.selectByValue(state);

                WebElement button = driver.findElement(By.xpath("//*[@id=\'searchVin\']/div[2]/div[2]/form/div[1]/div[3]/button"));

                button.click();
            }
        });
    }

}
