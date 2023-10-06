/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package t2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class t2 {
    public static void main(String[] args) {
        Profesor marioPerez = new Profesor("Mario Perez");
        Clase claseManana = new Clase("Clase de la Mañana", "Trigonometría");
        Clase claseTarde = new Clase("Clase de la Tarde", "Geometría");
        Clase claseNoche = new Clase("Clase de la Noche", "Álgebra");

        // Agregar estudiantes a las clases
        Estudiante estudiante1 = new Estudiante(1, "Estudiante 1");
        Estudiante estudiante2 = new Estudiante(2, "Estudiante 2");
        claseManana.agregarEstudiante(estudiante1);
        claseTarde.agregarEstudiante(estudiante2);

        JFrame frame = new JFrame("Registro de Asistencia");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 350); // Aumentamos la altura para dar más espacio

        JPanel panel = new JPanel();
        frame.add(panel);

        panel.setLayout(new GridLayout(7, 2, 5, 5)); // Usamos un GridLayout para organizar los componentes

        JLabel descripcionLabel = new JLabel("En la de la mañana dicta: Trigonometría, en la tarde: Geometría, y en la noche: Álgebra");
        panel.add(descripcionLabel);
        panel.add(new JLabel(" "));

        JLabel claseLabel = new JLabel("Seleccione la clase:");
        panel.add(claseLabel);

        JComboBox<String> claseComboBox = new JComboBox<>();
        claseComboBox.addItem(claseManana.getNombre());
        claseComboBox.addItem(claseTarde.getNombre());
        claseComboBox.addItem(claseNoche.getNombre());
        panel.add(claseComboBox);

        JLabel aulaLabel = new JLabel("Ingrese el aula:");
        panel.add(aulaLabel);

        JTextField aulaTextField = new JTextField(20);
        panel.add(aulaTextField);

        JLabel nombreLabel = new JLabel("Nombre del estudiante:");
        panel.add(nombreLabel);

        JTextField nombreTextField = new JTextField(20);
        panel.add(nombreTextField);

        JButton tomarAsistenciaButton = new JButton("Tomar Asistencia");
        panel.add(tomarAsistenciaButton);
        panel.add(new JLabel(" "));

        JTextArea resultadoTextArea = new JTextArea(10, 30);
        resultadoTextArea.setEditable(false); // Hacemos el área de resultados de solo lectura
        panel.add(new JScrollPane(resultadoTextArea));

        // ArrayList para almacenar los nombres de los estudiantes
        ArrayList<String> nombresEstudiantes = new ArrayList<>();

        tomarAsistenciaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedClase = (String) claseComboBox.getSelectedItem();
                Clase claseSeleccionada = null;

                if (selectedClase.equals(claseManana.getNombre())) {
                    claseSeleccionada = claseManana;
                } else if (selectedClase.equals(claseTarde.getNombre())) {
                    claseSeleccionada = claseTarde;
                } else if (selectedClase.equals(claseNoche.getNombre())) {
                    claseSeleccionada = claseNoche;
                }

                if (claseSeleccionada != null) {
                    String aula = aulaTextField.getText(); // Obtener el aula ingresada
                    resultadoTextArea.append("Asistencia para la " + claseSeleccionada.getNombre() + " en el aula " + aula + " (" + claseSeleccionada.getMateria() + "):\n");

                    String nombreEstudiante = nombreTextField.getText();
                    nombresEstudiantes.add(nombreEstudiante); // Agregar el nombre a la lista

                    // Mostrar los nombres acumulados en la lista
                    for (String nombre : nombresEstudiantes) {
                        resultadoTextArea.append(nombre + " - Asistencia: Presente\n");
                    }
                    resultadoTextArea.append("\n"); // Agregar un espacio en blanco
                }
            }
        });

        // Cambiar de turno borra los nombres acumulados
        claseComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resultadoTextArea.setText(""); // Borra el área de resultados
                nombreTextField.setText(""); // Borra el campo de nombre
                nombresEstudiantes.clear(); // Borra la lista de nombres acumulados
            }
        });

        frame.setVisible(true);
    }
}

class Clase {
    private String nombre;
    private String materia;
    private ArrayList<Estudiante> estudiantes = new ArrayList<>();

    public Clase(String nombre, String materia) {
        this.nombre = nombre;
        this.materia = materia;
    }

    public String getNombre() {
        return nombre;
    }

    public String getMateria() {
        return materia;
    }

    public void agregarEstudiante(Estudiante estudiante) {
        estudiantes.add(estudiante);
    }
}

class Profesor {
    private String nombre;

    public Profesor(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }
}

class Estudiante {
    private int id;
    private String nombre;

    public Estudiante(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }
}