/**
 * @author:  Jhonnatan Salazar
 * @fecha: 27/06/2025
 * @descripcion: EVALUACIÓN FINAL - Sistema Peaje
 */

import com.google.gson.Gson;
import javax.swing.*;
import java.awt.*;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

public class SistemaPeaje {
    private static final String FILE_NAME = "vehiculos.json";
    private static Map<String, Peaje> peajes = new HashMap<>();

    public static void main(String[] args) {
        JFrame frame = new JFrame("Sistema de Peaje");
        frame.setSize(400, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        String[] nombresPeajes = {
                "Ambuqui", "Cangahua", "Cochasqui", "Machachi", "Oyacoto",
                "Panzaleo", "Pintag", "San Andres", "San Gabriel", "San Roque"
        };

        Map<String, String> cantonPorPeaje = new HashMap<>();
        cantonPorPeaje.put("Ambuqui", "Ibarra");
        cantonPorPeaje.put("Cangahua", "Cayambe");
        cantonPorPeaje.put("Cochasqui", "Pedro Moncayo");
        cantonPorPeaje.put("Machachi", "Mejia");
        cantonPorPeaje.put("Oyacoto", "Quito");
        cantonPorPeaje.put("Panzaleo", "Saquisili");
        cantonPorPeaje.put("Pintag", "Quito");
        cantonPorPeaje.put("San Andres", "Guano");
        cantonPorPeaje.put("San Gabriel", "Montufar");
        cantonPorPeaje.put("San Roque", "Otavalo");

        JComboBox<String> peajeCombo = new JComboBox<>(nombresPeajes);
        JTextField cantonField = new JTextField(); cantonField.setEditable(false);
        JTextField totalField = new JTextField(); totalField.setEditable(false);
        JTextField placaField = new JTextField();
        JTextField ejesField = new JTextField();
        JComboBox<String> tipoVehiculo = new JComboBox<>(new String[]{"Carro", "Moto", "Camion"});
        JTextArea outputArea = new JTextArea(); outputArea.setRows(10);

        JButton guardarBtn = new JButton("GUARDAR");

        int row = 0;
        gbc.gridx = 0; gbc.gridy = row; frame.add(new JLabel("Nombre del Peaje:"), gbc);
        gbc.gridx = 1; frame.add(peajeCombo, gbc); row++;
        gbc.gridx = 0; gbc.gridy = row; frame.add(new JLabel("Cantón:"), gbc);
        gbc.gridx = 1; frame.add(cantonField, gbc); row++;
        gbc.gridx = 0; gbc.gridy = row; frame.add(new JLabel("Total Recolectado:"), gbc);
        gbc.gridx = 1; frame.add(totalField, gbc); row++;

        gbc.gridx = 0; gbc.gridy = row; frame.add(new JLabel("Placa:"), gbc);
        gbc.gridx = 1; frame.add(placaField, gbc); row++;
        gbc.gridx = 0; gbc.gridy = row; frame.add(new JLabel("Tipo de Vehículo:"), gbc);
        gbc.gridx = 1; frame.add(tipoVehiculo, gbc); row++;
        gbc.gridx = 0; gbc.gridy = row; frame.add(new JLabel("Número de Ejes (solo camión):"), gbc);
        gbc.gridx = 1; frame.add(ejesField, gbc); row++;

        gbc.gridx = 0; gbc.gridy = row; gbc.gridwidth = 2; frame.add(guardarBtn, gbc); row++;
        gbc.gridx = 0; gbc.gridy = row; gbc.gridwidth = 2; frame.add(new JScrollPane(outputArea), gbc);

        guardarBtn.addActionListener(e -> {
            String nombre = (String) peajeCombo.getSelectedItem();
            String canton = cantonPorPeaje.get(nombre);
            Peaje p = peajes.get(nombre);
            if (p == null) {
                p = new Peaje(nombre, canton);
                peajes.put(nombre, p);
            }

            String placa = placaField.getText();
            String tipo = (String) tipoVehiculo.getSelectedItem();

            if (tipo.equals("Carro")) {
                p.añadirVehiculo(new Carro(placa));
            } else if (tipo.equals("Moto")) {
                p.añadirVehiculo(new Moto(placa));
            } else if (tipo.equals("Camion")) {
                try {
                    int ejes = Integer.parseInt(ejesField.getText());
                    p.añadirVehiculo(new Camion(placa, ejes));
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Número de ejes inválido");
                    return;
                }
            }

            totalField.setText(String.valueOf(p.getTotalPeaje()));
            placaField.setText("");
            ejesField.setText("");

            try (Writer writer = new FileWriter(FILE_NAME)) {
                new Gson().toJson(peajes, writer);
                JOptionPane.showMessageDialog(frame, "Vehículo guardado y datos actualizados");
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(frame, "Error al guardar");
            }

            mostrarPeajeActual(peajeCombo, cantonPorPeaje, cantonField, totalField, outputArea);
        });

        peajeCombo.addActionListener(e -> {
            mostrarPeajeActual(peajeCombo, cantonPorPeaje, cantonField, totalField, outputArea);
        });

        mostrarPeajeActual(peajeCombo, cantonPorPeaje, cantonField, totalField, outputArea);
        frame.setVisible(true);
    }

    private static void mostrarPeajeActual(JComboBox<String> peajeCombo, Map<String, String> cantonPorPeaje, JTextField cantonField, JTextField totalField, JTextArea outputArea) {
        String seleccionado = (String) peajeCombo.getSelectedItem();
        if (seleccionado != null && cantonPorPeaje.containsKey(seleccionado)) {
            String canton = cantonPorPeaje.get(seleccionado);
            cantonField.setText(canton);

            Peaje p = peajes.get(seleccionado);
            if (p != null) {
                totalField.setText(String.valueOf(p.getTotalPeaje()));

                StringBuilder sb = new StringBuilder();
                sb.append("Peaje: ").append(p.getNombre()).append(" – Cantón: ").append(p.getCanton()).append("\n");
                for (Vehiculo v : p.getVehiculos()) {
                    sb.append(v.getTipo()).append(" – ").append(v.getPlaca())
                            .append(" – $ ").append(v.calcularPeaje()).append("\n");
                }
                sb.append("\nTotal Recolectado: $ ").append(p.getTotalPeaje());
                outputArea.setText(sb.toString());
            } else {
                totalField.setText("0");
                outputArea.setText("");
            }
        }
    }
}