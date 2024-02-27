import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class VentanaPrincipal extends JFrame implements ActionListener {
    private JTextField cajaIngresa, cajaPies, cajaPulgadas, cajaMillas;
    private JRadioButton radioMIllas, radioPies, radioPulgadas;
    private JCheckBox checkTodos;
    private JButton btnOk;
    private JLabel txtIngresa;

    public VentanaPrincipal() {
        getContentPane().setLayout(new FlowLayout());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(200, 300);
        setLocationRelativeTo(null);
        setTitle(" Eventos Combo Conversiones");
        setVisible(true);

        txtIngresa = new JLabel();
        txtIngresa.setText("Ingresa kilometros");
        add(txtIngresa);

        cajaIngresa = new JTextField("50", 10);
        add(cajaIngresa);

        checkTodos = new JCheckBox("<<<----TODOS---->>>");
        checkTodos.addActionListener(this);
        add(checkTodos);

        radioMIllas = new JRadioButton(" Millas ");
        radioMIllas.addActionListener(this);
        add(radioMIllas);
        cajaMillas = new JTextField(5);
        add(cajaMillas);

        radioPies = new JRadioButton(" Pies ");
        radioPies.addActionListener(this);
        add(radioPies);
        cajaPies = new JTextField(5);
        add(cajaPies);

        radioPulgadas = new JRadioButton(" Pulgadas ");
        radioPulgadas.addActionListener(this);
        add(radioPulgadas);
        cajaPulgadas = new JTextField(5);
        add(cajaPulgadas);

        btnOk = new JButton("OK");
        btnOk.addActionListener(this);
        add(btnOk);

        ButtonGroup group = new ButtonGroup();
        group.add(radioMIllas);
        group.add(radioPies);
        group.add(radioPulgadas);
    }

    private void realizarConversiones(double kilom) {
        if (radioMIllas.isSelected()) {
            cajaMillas.setText(String.valueOf(ConversorDistancias.convertirAKilometros(kilom, "Millas")));
            cajaPies.setText("");
            cajaPulgadas.setText("");
        } else if (radioPies.isSelected()) {
            cajaMillas.setText("");
            cajaPies.setText(String.valueOf(ConversorDistancias.convertirAKilometros(kilom, "Pies")));
            cajaPulgadas.setText("");
        } else if (radioPulgadas.isSelected()) {
            cajaMillas.setText("");
            cajaPies.setText("");
            cajaPulgadas.setText(String.valueOf(ConversorDistancias.convertirAKilometros(kilom, "Pulgadas")));
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    	// TODO Auto-generated method stub

        if (e.getSource() == btnOk) {
            double kilom = Double.parseDouble(cajaIngresa.getText());
            realizarConversiones(kilom);
        } else if (e.getSource() == checkTodos) {
            double kilom = Double.parseDouble(cajaIngresa.getText());
            if (checkTodos.isSelected()) {
                cajaMillas.setText(String.valueOf(ConversorDistancias.convertirAKilometros(kilom, "Millas")));
                cajaPies.setText(String.valueOf(ConversorDistancias.convertirAKilometros(kilom, "Pies")));
                cajaPulgadas.setText(String.valueOf(ConversorDistancias.convertirAKilometros(kilom, "Pulgadas")));
            } else {
                cajaMillas.setText("");
                cajaPies.setText("");
                cajaPulgadas.setText("");
            }
        } else if (e.getSource() == radioMIllas) {
            cajaPies.setText("");
            cajaPulgadas.setText("");
        } else if (e.getSource() == radioPies) {
            cajaMillas.setText("");
            cajaPulgadas.setText("");
        } else if (e.getSource() == radioPulgadas) {
            cajaMillas.setText("");
            cajaPies.setText("");
        }
    }
}

public class PruebaEventosRadioCheck {
    public static void main(String[] args) {
    	// TODO Auto-generated method stub

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new VentanaPrincipal();
            }
        });
    }
}
