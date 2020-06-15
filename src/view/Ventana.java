package view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import model.Manejador;
import model.Metodo;
import model.Proceso;

public class Ventana extends JFrame {

    Manejador manejador = new Manejador();
    List<Proceso> lista = new ArrayList();
    Metodo metodo;

    private JPanel jpLUE;
    private JPanel LUE;
    private JPanel jpresultado;
    private JPanel cambio;
    private JPanel jpseleccion;
    private JPanel jpinfoP;
    private JPanel jpInferior;

    private JButton btagregarP;
    private JButton btiniciar;

    private JLabel selecAlgoritmo;
    private JLabel seccProceso;
    private JLabel nombreP;
    private JLabel prioridadP;
    private JLabel duracionP;
    private JLabel tiempoLlP;

    private JTextField tfnombre;
    private JTextField tfprioridadP;
    private JTextField tfduracionP;
    private JTextField tftiempoLlP;

    private Choice cAlgoritmo;

    private JTextArea text;
    private JTextArea textLUE;

    JScrollPane scroll;
    JScrollPane scrollLUE;

    public Ventana() {
        initcomponents();
    }

    private void initcomponents() {
        this.setTitle("Planificador de Procesos");
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());
        ImageIcon icon = new ImageIcon("images/icon.png");
        setIconImage(icon.getImage());

        jpLUE = new JPanel(); //Panel en la seccion norte de frame
        jpLUE.setBorder(javax.swing.BorderFactory.createTitledBorder("LUE"));
        LUE = new JPanel(); //Panel que muestra la informacion de la estructura LUE
        jpresultado = new JPanel();//Panel agregado ej jpinferior que contiene jpanel cambio
        jpresultado.setBorder(javax.swing.BorderFactory.createTitledBorder("Resultado"));
        cambio = new JPanel(); //Panel que muestra la informacion de la simulacion
        jpseleccion = new JPanel();//Panel que permite agregar procesos y iniciar simulacion
        jpseleccion.setBorder(javax.swing.BorderFactory.createTitledBorder("Procesos"));
        jpseleccion.setLayout(new BoxLayout(jpseleccion, BoxLayout.Y_AXIS));
        jpinfoP = new JPanel();//Panel que contine los JLabel y JTextField
        jpinfoP.setLayout(new GridLayout(5, 2, 10, 10));

        jpInferior = new JPanel(new FlowLayout());//Paner que se encuentra en la parte sur de frame

        selecAlgoritmo = new JLabel();
        selecAlgoritmo.setText("Selecciona Algoritmo:");
        selecAlgoritmo.setAlignmentX(Component.RIGHT_ALIGNMENT);
        seccProceso = new JLabel();
        seccProceso.setText("Nuevo Proceso");
        seccProceso.setAlignmentX(Component.RIGHT_ALIGNMENT);
        nombreP = new JLabel();
        nombreP.setText("Nombre Proceso: ");
        tiempoLlP = new JLabel();
        tiempoLlP.setText("Tiempo de LLegada: ");
        duracionP = new JLabel();
        duracionP.setText("Duracion de Rafaga: ");
        prioridadP = new JLabel();
        prioridadP.setText("Prioridad: ");

        tfnombre = new JTextField();
        tfprioridadP = new JTextField();
        tfduracionP = new JTextField();
        tftiempoLlP = new JTextField();

        cAlgoritmo = new Choice();
        cAlgoritmo.add("FIFO");
        cAlgoritmo.add("SJF");
        cAlgoritmo.add("SRT");
        cAlgoritmo.add("PRIORIDAD");
        cAlgoritmo.add("RR");

        btagregarP = new JButton();
        btagregarP.setText("Agregar");
        btiniciar = new JButton();
        btiniciar.setText("Iniciar Simulacion");

        jpseleccion.add(selecAlgoritmo);
        jpseleccion.add(cAlgoritmo);
        jpseleccion.add(seccProceso);

        jpinfoP.add(nombreP);
        jpinfoP.add(tfnombre);
        jpinfoP.add(tiempoLlP);
        jpinfoP.add(tftiempoLlP);
        jpinfoP.add(duracionP);
        jpinfoP.add(tfduracionP);
        jpinfoP.add(prioridadP);
        jpinfoP.add(tfprioridadP);
        jpseleccion.add(jpinfoP);
        jpseleccion.add(btagregarP);
        jpseleccion.add(btiniciar);

        textLUE = new JTextArea(" ");
        textLUE.setFont(new Font("Monospaced", Font.PLAIN, 12));
        textLUE.setRows(12); //4
        textLUE.setColumns(90);
        textLUE.setWrapStyleWord(true);
        textLUE.setEditable(false);
        scrollLUE = new JScrollPane(textLUE);
        LUE.add(scrollLUE);

        text = new JTextArea(" ");
        text.setFont(new Font("Monospaced", Font.PLAIN, 12));
        text.setRows(17);   //10
        text.setColumns(130); //50
        text.setWrapStyleWord(true);
        text.setEditable(false);
        scroll = new JScrollPane(text);
        cambio.add(scroll);

        jpresultado.add(cambio);

        jpLUE.add(LUE);

        //jpInferior.add(jpresultado); ahorita modifique
        jpInferior.add(jpLUE);
        jpInferior.add(jpseleccion);

        btagregarP.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre, algoritmo;
                int duracion, tLlegada, prioridad, quantum;
                nombre = tfnombre.getText();
                duracion = Integer.parseInt(tfduracionP.getText());
                tLlegada = Integer.parseInt(tftiempoLlP.getText());

                algoritmo = cAlgoritmo.getSelectedItem();
                System.out.println("Algoritmo:" + algoritmo);
                switch (algoritmo) {
                    case "FIFO":
                        lista.add(new Proceso(nombre, tLlegada, duracion));

                        break;
                    case "SJF":
                        lista.add(new Proceso(nombre, tLlegada, duracion));

                        break;
                    case "SRT":
                        lista.add(new Proceso(nombre, tLlegada, duracion));

                        break;
                    case "PRIORIDAD":
                        //necesidad de prioridad
                        prioridad = Integer.parseInt(tfprioridadP.getText());
                        lista.add(new Proceso(nombre, tLlegada, duracion, prioridad));

                        break;
                    case "RR":
                        //necesidad de prioridad y quamtum
                        ///quantum = Integer.parseInt(tfquantum.getText());
                        prioridad = Integer.parseInt(tfprioridadP.getText());
                        lista.add(new Proceso(nombre, tLlegada, duracion, prioridad));

                        break;
                    default:
                        System.out.println("Error");
                        break;
                }

            }
        });

        btiniciar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String algoritmo = cAlgoritmo.getSelectedItem();

                switch (algoritmo) {
                    case "FIFO":
                        metodo = manejador.firstComeFirtServed(lista);
                        System.out.println(metodo);

                        //Muestra en LUE
                        jpLUE.remove(LUE);
                        LUE = new JPanel();
                        textLUE = new JTextArea(metodo.resultadoLUE());
                        textLUE.setFont(new Font("Monospaced", Font.PLAIN, 12));
                        textLUE.setRows(12);
                        textLUE.setColumns(90);
                        textLUE.setWrapStyleWord(true);
                        textLUE.setEditable(false);
                        scrollLUE = new JScrollPane(textLUE);
                        LUE.add(scrollLUE);
                        jpLUE.add(LUE);
                        jpLUE.updateUI();

                        //Muestra en Resultados
                        jpresultado.remove(cambio);
                        cambio = new JPanel();
                        text = new JTextArea(metodo.resultado());
                        text.setFont(new Font("Monospaced", Font.PLAIN, 12));
                        text.setRows(17);
                        text.setColumns(130);
                        text.setWrapStyleWord(true);
                        text.setEditable(false);
                        scroll = new JScrollPane(text);
                        cambio.add(scroll);
                        jpresultado.add(cambio);

                        jpresultado.updateUI();
                        break;
                    case "SJF":
                        metodo = manejador.shortestJobFirst(lista);
                        System.out.println(metodo);

                        jpLUE.remove(LUE);
                        LUE = new JPanel();
                        textLUE = new JTextArea(metodo.resultadoLUE());
                        textLUE.setFont(new Font("Monospaced", Font.PLAIN, 12));
                        textLUE.setRows(12);
                        textLUE.setColumns(90);
                        textLUE.setWrapStyleWord(true);
                        textLUE.setEditable(false);
                        scrollLUE = new JScrollPane(textLUE);
                        LUE.add(scrollLUE);
                        jpLUE.add(LUE);
                        jpLUE.updateUI();

                        jpresultado.remove(cambio);
                        cambio = new JPanel();
                        text = new JTextArea(metodo.resultado());
                        text.setFont(new Font("Monospaced", Font.PLAIN, 12));
                        text.setRows(17);
                        text.setColumns(130);
                        text.setWrapStyleWord(true);
                        text.setEditable(false);
                        scroll = new JScrollPane(text);
                        cambio.add(scroll);
                        jpresultado.add(cambio);

                        jpresultado.updateUI();

                        break;
                    case "SRT":
                        metodo = manejador.SRT(lista);
                        System.out.println(metodo);

                        jpLUE.remove(LUE);
                        LUE = new JPanel();
                        textLUE = new JTextArea(metodo.resultadoLUE());
                        textLUE.setFont(new Font("Monospaced", Font.PLAIN, 12));
                        textLUE.setRows(12);
                        textLUE.setColumns(90);
                        textLUE.setWrapStyleWord(true);
                        textLUE.setEditable(false);
                        scrollLUE = new JScrollPane(textLUE);
                        LUE.add(scrollLUE);
                        jpLUE.add(LUE);
                        jpLUE.updateUI();

                        jpresultado.remove(cambio);
                        cambio = new JPanel();
                        text = new JTextArea(metodo.resultado());
                        text.setFont(new Font("Monospaced", Font.PLAIN, 12));
                        text.setRows(17);
                        text.setColumns(130);
                        text.setWrapStyleWord(true);
                        text.setEditable(false);
                        scroll = new JScrollPane(text);
                        cambio.add(scroll);
                        jpresultado.add(cambio);
                        jpresultado.updateUI();
                        break;
                    case "PRIORIDAD":
                        metodo = manejador.priority(lista);
                        System.out.println(metodo);

                        jpLUE.remove(LUE);
                        LUE = new JPanel();
                        textLUE = new JTextArea(metodo.resultadoLUE());
                        textLUE.setFont(new Font("Monospaced", Font.PLAIN, 12));
                        textLUE.setRows(12);
                        textLUE.setColumns(90);
                        textLUE.setWrapStyleWord(true);
                        textLUE.setEditable(false);
                        scrollLUE = new JScrollPane(textLUE);
                        LUE.add(scrollLUE);
                        jpLUE.add(LUE);
                        jpLUE.updateUI();

                        jpresultado.remove(cambio);
                        cambio = new JPanel();
                        text = new JTextArea(metodo.resultadoconPriori());
                        text.setFont(new Font("Monospaced", Font.PLAIN, 12));
                        text.setRows(17);
                        text.setColumns(130);
                        text.setWrapStyleWord(true);
                        text.setEditable(false);
                        scroll = new JScrollPane(text);
                        cambio.add(scroll);
                        jpresultado.add(cambio);
                        jpresultado.updateUI();
                        break;
                    case "RR":
                        String quantumString = JOptionPane.showInputDialog("Ingresa el quatum:");
                        int quantum;

                        try {
                            quantum = Integer.parseInt(quantumString);
                        } catch (Exception ex) {
                            System.out.println("error: " + ex);
                            quantum = -1;
                        }

                        if (quantum > 0) {
                            System.out.println("quantum: " + quantum);

                            metodo = manejador.roundRobin(lista, quantum);
                            System.out.println(metodo);

                            jpLUE.remove(LUE);
                            LUE = new JPanel();
                            textLUE = new JTextArea(metodo.resultadoLUE());
                            textLUE.setFont(new Font("Monospaced", Font.PLAIN, 12));
                            textLUE.setRows(12);
                            textLUE.setColumns(90);
                            textLUE.setWrapStyleWord(true);
                            textLUE.setEditable(false);
                            scrollLUE = new JScrollPane(textLUE);
                            LUE.add(scrollLUE);
                            jpLUE.add(LUE);
                            jpLUE.updateUI();

                            jpresultado.remove(cambio);
                            cambio = new JPanel();
                            text = new JTextArea(metodo.resultadoconPriori());
                            text.setFont(new Font("Monospaced", Font.PLAIN, 12));
                            text.setRows(17);
                            text.setColumns(130);
                            text.setWrapStyleWord(true);
                            text.setEditable(false);
                            scroll = new JScrollPane(text);
                            cambio.add(scroll);
                            jpresultado.add(cambio);
                            jpresultado.updateUI();
                        } else {
                            JOptionPane.showMessageDialog(null, "Quantum no valido");
                        }

                        break;
                    default:
                        System.out.println("Error");
                        break;
                }
                lista = new ArrayList();
            }
        });

        //this.add(jpLUE, BorderLayout.NORTH); //ahorita modifco
        this.add(jpresultado, BorderLayout.CENTER); //AHORITA
        this.add(jpInferior, BorderLayout.SOUTH);
        this.setSize(1000, 640); //700 440
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

}
