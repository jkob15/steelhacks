
// Import necessary classes for creating a GUI application
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Game {

    JFrame window;// main window to start the game
    JPanel titleNamePanel, startButtonPanel, mainTextPanel, choiceButtonPanel; // different pannel sections of GUI
    JLabel titleNameLabel; // Label for the game's title
    Font titleFont = new Font("Times New Roman", Font.PLAIN, 68);
    Font normalFont = new Font("Times New Roman", Font.PLAIN, 18);
    Font smallFont = new Font("Times New Roman", Font.PLAIN, 15);
    JButton startButton; // button to start game
    JTextArea mainTextArea; // text area to display the text
    Container con; // to hold panels and components

    TitleScreenHandler tsHandler = new TitleScreenHandler();

    public static void main(String[] args) {
        new Game();
    }

    // creates the tab for the game
    public Game() {
        // Create JFrame
        window = new JFrame();
        window.setSize(800, 600);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().setBackground(Color.black);
        window.setLayout(null);
        window.setLocationRelativeTo(null);

        con = window.getContentPane(); // get concent pane to add compents

        // Title panel
        titleNamePanel = new JPanel();
        titleNamePanel.setBounds(100, 100, 600, 150);
        titleNamePanel.setBackground(Color.black);
        titleNamePanel.setLayout(null);

        titleNameLabel = new JLabel("MentalActive");
        titleNameLabel.setForeground(Color.white);
        titleNameLabel.setBounds(0, 0, 600, 150);
        titleNameLabel.setFont(titleFont);
        titleNameLabel.setHorizontalAlignment(JLabel.CENTER);
        titleNameLabel.setVerticalAlignment(JLabel.CENTER);

        startButtonPanel = new JPanel();
        startButtonPanel.setBounds(300, 400, 200, 100);
        startButtonPanel.setBackground(Color.blue);
        startButtonPanel.setLayout(null);

        startButton = new JButton("START");
        startButton.setBackground(Color.black);
        startButton.setForeground(Color.white);
        startButton.setFont(normalFont);
        startButton.setBounds(0, 0, 200, 100);
        startButton.addActionListener(tsHandler);

        titleNamePanel.add(titleNameLabel);
        startButtonPanel.add(startButton);

        con.add(titleNamePanel);
        con.add(startButtonPanel);

        window.setVisible(true);
    }

    // game starts here
    public void createGameScreen() {
        titleNamePanel.setVisible(false);
        startButtonPanel.setVisible(false);

        mainTextPanel = new JPanel();
        mainTextPanel.setBounds(100, 100, 600, 250);
        mainTextPanel.setBackground(Color.black);
        con.add(mainTextPanel);

        mainTextArea = new JTextArea(
                "The car disappears down the long road, your parents waving until they're just a distant blur. This is it—you're officially on your own. The campus that felt so full of possibility when you visited months ago now feels overwhelming, even a little frightening. You can still see your mom's proud smile and hear your dad's reassuring words, but now that they're gone, all that comfort seems to fade with them. You're a first-year student embarking on this new journey. This was supposed to be the start of something great, yet as you stand here, the silence fills the space they left behind. You never thought you'd feel so… lost. —The choices are yours. What you do next could shape your semester, your relationships, and—most importantly—your mental health.");
        mainTextArea.setBounds(0, 0, 600, 250);
        mainTextArea.setBackground(Color.black);
        mainTextArea.setForeground(Color.white);
        mainTextArea.setFont(normalFont);
        mainTextArea.setLineWrap(true);
        mainTextArea.setWrapStyleWord(true);
        mainTextArea.setEditable(false);

        mainTextPanel.add(mainTextArea);
        mainTextPanel.setLayout(null);

        createChoiceButtons();
    }

    // creates the choices for each options (starts off the game with 3 paths)
    private void createChoiceButtons() {
        choiceButtonPanel = new JPanel();
        choiceButtonPanel.setBounds(250, 350, 300, 300);
        choiceButtonPanel.setBackground(Color.black);
        choiceButtonPanel.setLayout(null);
        con.add(choiceButtonPanel);

        addChoiceButton("Find your new roommate.", e -> outcomeFindRoommate(), 20); // 1st path
        addChoiceButton("Call your parents.", e -> outcomeCallParents(), 80); // 2nd path
        addChoiceButton("Explore the campus.", e -> outcomeExploreCampus(), 140); // 3rd path
    }

    // adds more buttons to continue on the game
    private void addChoiceButton(String text, ActionListener action, int yPos) {
        JButton choiceButton = new JButton(text);
        choiceButton.setBounds(50, yPos, 200, 50);
        choiceButton.setBackground(Color.black);
        choiceButton.setForeground(Color.white);
        choiceButton.setFont(smallFont);
        choiceButton.addActionListener(action);
        choiceButtonPanel.add(choiceButton);
    }

    // outcomes
    private void outcomeFindRoommate() { // outcome 1
        showOutcome(
                "You stand outside your dorm, staring at the door. The hallway hums with distant chatter, but the silence around you feels heavier. After a pause, you walk down to Roc's room and knock. The door opens, revealing Roc, casually dressed with a welcoming smile. 'Hey, you must be Cathy. 'Yeah, just wanted to say hi,' you reply, feeling more at ease.'It's been a lot, right? After my parents left, it hit me how real this is,' Roc says.'Same. I didn't think I'd feel this lonely.' Roc nods. 'It's harder than I thought. Wanna grab dinner later?' For the first time, you feel a little less alone.");
        showFollowUpChoices();
    }

    private void outcomeCallParents() { // outcome 2
        showOutcome(
                "You sit on your bed, staring at your phone. After a moment, you hit 'call.' It rings twice. 'Cathy? Everything okay?' your mom asks. 'Yeah... I didn't think I'd feel this lost.' Your dad chimes in, 'Remember champ? You were nervous but ended up loving it. 'We're so proud of you,' your mom says. 'Take it slow. You've got this.' You breathe, feeling lighter. 'Thanks, I needed that. Love you.' 'We love you too. Call anytime.' The room feels less lonely now. You're still nervous, but not alone.");
        showFollowUpChoicesAfterCall();
    }

    private void outcomeExploreCampus() { // outcome 3
        showOutcome(
                "The campus buzzes around you, but you find a quiet bench under some trees. Sitting down, you let out a breath, closing your eyes. The emotions you've been pushing down—fear, doubt, homesickness—rise to the surface. You let yourself feel it all. A cool breeze calms you, and for the first time today, you feel like you can breathe. It's okay to take a moment. You don't have to figure everything out right now.");
    }

    // shows the follow up choices after first 3 outcomes
    private void showFollowUpChoices() {
        choiceButtonPanel.setVisible(false);
        choiceButtonPanel = new JPanel();
        choiceButtonPanel.setBounds(250, 350, 300, 300);
        choiceButtonPanel.setBackground(Color.black);
        choiceButtonPanel.setLayout(null);
        con.add(choiceButtonPanel);

        // New choices after meeting the roommate
        addChoiceButton( // path 4
                "Agree to go to the dining hall with Roc. It could be a good way to keep the conversation going and start feeling more comfortable in this new environment.",
                e -> outcomeDiningHall(), 20);
        addChoiceButton( // path 5
                "Suggest exploring the campus together instead. Maybe walking around and getting a sense of the place will help you both feel more at home.",
                e -> outcomeExplore(), 80);
        addChoiceButton( // path 6
                "Offer to help Roc finish unpacking. Spending more time together in the room might help solidify your bond before facing the rest of the campus.",
                e -> outcomeUnpack(), 140);

        // Repaint to show the new choices
        con.revalidate();
        con.repaint();
    }

    // shows the follow up choices after calling parents (path 2 - options 1, 3, or
    // 3)
    private void showFollowUpChoicesAfterCall() {
        choiceButtonPanel.setVisible(false);
        choiceButtonPanel = new JPanel();
        choiceButtonPanel.setBounds(250, 350, 300, 300);
        choiceButtonPanel.setBackground(Color.black);
        choiceButtonPanel.setLayout(null);
        con.add(choiceButtonPanel);

        // new choices after calling parents
        addChoiceButton( // loops back to path 1
                "Meet your roommate, Roc. Maybe connecting with them will make this transition easier.",
                e -> outcomeFindRoommate(), 20);
        addChoiceButton( // loops back to path 3
                "Explore campus. A walk might help settle your nerves.",
                e -> outcomeExploreCampus(), 80);
        addChoiceButton( // loops back to path 3
                "Take a moment to relax. Give yourself some time to adjust before doing anything else.",
                e -> showOutcome(
                        "You take a deep breath and sit in silence for a moment, letting the reality of your new life wash over you. It's okay to take it slow."),
                140);

        // Repaint to show the new choices
        con.revalidate();
        con.repaint();
    }

    private void outcomeDiningHall() { // option 4 **good ending**
        showOutcome(
                "You smile and nod at Roc. 'Yeah, let's go to the dining hall. I could use a break.' Walking together, the conversation flows easily, and the weight of earlier nerves starts to lift. By the time you reach the busy dining hall, it feels less overwhelming. As you sit down with your food, Roc smiles. 'This isn't so bad, right?' You nod, feeling the same. 'Yeah, it's starting to feel okay.'");
    }

    private void outcomeExplore() { // option 5 **either accepts - good ending, declines - meh ending**
        showOutcome(
                "You stand outside your dorm, nerves buzzing, then walk to Roc's door. Roc greets you with a smile. 'Hey, you must be Cathy. 'Yeah, it's been kind of lonely, 'you admit. 'Same,' Roc nods. 'It's harder than I thought. 'After a pause, Roc offers, 'Want to explore campus together? Might help us feel more at home.");
    }

    private void outcomeUnpack() { // option 6 **good ending**
        showOutcome(
                "The campus buzzes, but you find a quiet bench and sit, letting out a deep breath. Fear and homesickness wash over you, but a cool breeze brings calm. It's okay to take it slow. Back at the dorm, you see Roc unpacking. 'Need help?'' you ask. Roc smiles. 'Yeah, that'd be great. 'You unpack together, sharing an easy conversation. By the time you're done, the room feels more like home. 'Thanks, I needed this,'' Roc says. 'Me too,'' you reply.");
    }

    // endings
    private void option4ending() { // when they choose option 4
        showOutcome(
                "You smile and nod at Roc. ‘Yeah, let’s go to the dining hall. I could use a break.’ Walking together, the conversation flows easily, and the weight of earlier nerves starts to lift. By the time you reach the busy dining hall, it feels less overwhelming. As you sit down with your food, Roc smiles. ‘This isn’t so bad, right?’ You nod, feeling the same. ‘Yeah, it's starting to feel okay.’");
    }

    private void option5ending() { // when they choose option 5 **accepts**
        showOutcome(
                "You stand outside your dorm, nerves buzzing, then walk to Roc's door. Roc greets you with a smile. ‘Hey, you must be [input name].’’Yeah, it’s been kind of lonely,’ you admit. ‘Same,’ Roc nods. ‘It’s harder than I thought.’ After a pause, Roc offers, ‘Want to explore campus together? Might help us feel more at home.’");
    }

    private void option52ndending() { // when they choose option 5 **declines**
        showOutcome(
                "");
    }

    private void option6ending() { // when they choose option 6
        showOutcome(
                "");
    }

    private void showOutcome(String outcomeText) {
        mainTextPanel.setVisible(false);
        choiceButtonPanel.setVisible(false);

        mainTextPanel = new JPanel();
        mainTextPanel.setBounds(100, 100, 600, 250);
        mainTextPanel.setBackground(Color.black);
        con.add(mainTextPanel);

        mainTextArea = new JTextArea(outcomeText);
        mainTextArea.setBounds(0, 0, 600, 250);
        mainTextArea.setBackground(Color.black);
        mainTextArea.setForeground(Color.white);
        mainTextArea.setFont(normalFont);
        mainTextArea.setLineWrap(true);
        mainTextArea.setWrapStyleWord(true);
        mainTextArea.setEditable(false);

        mainTextPanel.add(mainTextArea);
        mainTextPanel.setLayout(null);
        con.revalidate();
        con.repaint();
    }

    class TitleScreenHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            createGameScreen();
        }
    }
}
