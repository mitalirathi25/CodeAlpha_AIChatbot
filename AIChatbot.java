import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class AIChatbot extends JFrame implements ActionListener {

    private JTextArea chatArea;
    private JTextField inputField;
    private JButton sendButton;

    private HashMap<String, String> responses;

    public AIChatbot() {

        setTitle("AI Chatbot");
        setSize(600, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        chatArea = new JTextArea();
        chatArea.setEditable(false);
        chatArea.setLineWrap(true);

        JScrollPane scrollPane = new JScrollPane(chatArea);

        inputField = new JTextField();

        sendButton = new JButton("Send");
        sendButton.addActionListener(this);

        JPanel bottomPanel = new JPanel(new BorderLayout());
        bottomPanel.add(inputField, BorderLayout.CENTER);
        bottomPanel.add(sendButton, BorderLayout.EAST);

        add(scrollPane, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);

        initializeResponses();

        chatArea.append("Bot: Hello! I am your AI Chatbot.\n");
        chatArea.append("Bot: Ask me anything.\n\n");
    }

    private void initializeResponses() {

        responses = new HashMap<>();

        responses.put("hello", "Hello! How can I help you?");
        responses.put("hi", "Hi there! Nice to meet you.");
        responses.put("how are you", "I'm doing great. Thanks for asking!");
        responses.put("your name", "My name is Java AI Chatbot.");
        responses.put("java", "Java is a powerful object-oriented programming language.");
        responses.put("oop", "OOP stands for Object-Oriented Programming.");
        responses.put("codealpha", "CodeAlpha provides internship opportunities in various domains.");
        responses.put("internship", "An internship helps students gain practical experience.");
        responses.put("bye", "Goodbye! Have a great day.");
        responses.put("thank you", "You're welcome!");
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String userInput = inputField.getText().trim().toLowerCase();

        if (userInput.isEmpty()) {
            return;
        }

        chatArea.append("You: " + userInput + "\n");

        String response = generateResponse(userInput);

        chatArea.append("Bot: " + response + "\n\n");

        inputField.setText("");
    }

    private String generateResponse(String input) {

        for (String keyword : responses.keySet()) {

            if (input.contains(keyword)) {
                return responses.get(keyword);
            }
        }

        return "Sorry, I don't understand that. Please ask another question.";
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            AIChatbot chatbot = new AIChatbot();
            chatbot.setVisible(true);
        });
    }
}