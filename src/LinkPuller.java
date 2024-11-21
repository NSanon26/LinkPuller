import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LinkPuller implements ActionListener {
    private JFrame frame;
    private JPanel panel;
    private JPanel panel2;
    private JPanel panel3;
    private JButton goButton;
    private JTextField url;
    private JTextField search;
    private JTextArea results;



    public static void main(String[] args) {
        LinkPuller html = new LinkPuller();
    }

    public LinkPuller() {

        //construct variables
        frame = new JFrame("Test");
        panel = new JPanel(new BorderLayout());
        panel2 = new JPanel(new BorderLayout());
        panel3 = new JPanel(new GridLayout(2, 1));
        goButton = new JButton("GO");
        url = new JTextField("Type your url");
        search = new JTextField("Search");
        results = new JTextArea("Your results will print here:");
        //organize the layout
        panel.add(results, BorderLayout.CENTER);
        panel.add(panel2, BorderLayout.NORTH);
        panel2.add(panel3, BorderLayout.CENTER);
        panel3.add(url);
        panel3.add(search);
        panel2.add(goButton, BorderLayout.EAST);

        frame.add(panel);

        //actually make stuff here
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 300);
        //frame.pack();
        frame.setVisible(true);
    }

        public void actionPerformed(ActionEvent e) {
            System.out.println("Button clicked");
            results.setText(url.getText());
        }
            public void search(){
        try{
                    System.out.println();
                    System.out.print("hello \n");
                    URL url = new URL("https://en.wikipedia.org/wiki/Los_Angeles_Lakers");
                    BufferedReader reader = new BufferedReader(
                            new InputStreamReader(url.openStream())
                    );
                    String line;
                    int c = 0;
                    while ((line = reader.readLine()) != null) {
                        // only print the basketball part of each line
                        // only the 10 characters before and after hockey
                        if (line.contains("basketball")) {
                            int start = line.indexOf("basketball") - 10;
                            while (start != -1) {
                                int end = start + 30;
                                String miniLine = line.substring(start, end);
                                System.out.println(c + ". " + miniLine);
                                c++;
                                start = line.indexOf("basketball", start + 11);
                            }
                        }

                    }
                    reader.close();
                }catch(Exception ex){
                    System.out.println(ex);
                }
            }

    }


