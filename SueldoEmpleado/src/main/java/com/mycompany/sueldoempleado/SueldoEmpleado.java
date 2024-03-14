/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.sueldoempleado;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import static javafx.application.Application.launch;

public class SueldoEmpleado extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Calculador de Salario");

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));
        //Aqui se te pregunta la cantidad de horas trabajadas
        Label horasTrabajadasLabel = new Label("Horas Trabajadas:");
        grid.add(horasTrabajadasLabel, 0, 0);
        TextField horasTrabajadasField = new TextField();
        grid.add(horasTrabajadasField, 1, 0);
        //Aqui se te pregunta el pago por hora base
        Label pagoPorHoraBaseLabel = new Label("Pago por Hora Base:");
        grid.add(pagoPorHoraBaseLabel, 0, 1);
        TextField pagoPorHoraBaseField = new TextField();
        grid.add(pagoPorHoraBaseField, 1, 1);
        //Aqui se te pregunta la cantidad de horas extra trabajadas
        Label horasExtrasLabel = new Label("Horas Extras Trabajadas:");
        grid.add(horasExtrasLabel, 0, 2);
        TextField horasExtrasField = new TextField();
        grid.add(horasExtrasField, 1, 2);
        //Aqui se te pregunta la cantidad del pago extra por hora.
        Label pagoPorHoraExtraLabel = new Label("Pago por Hora Extra:");
        grid.add(pagoPorHoraExtraLabel, 0, 3);
        TextField pagoPorHoraExtraField = new TextField();
        grid.add(pagoPorHoraExtraField, 1, 3);
        //Aqui se te pregunta la fecha en la que iniciaste a trabajar
        Label fechaInicioLabel = new Label("Incio del trabajo:");
        grid.add(fechaInicioLabel, 0, 4);
        DatePicker fechaInicioPicker = new DatePicker();
        grid.add(fechaInicioPicker, 1, 4);
        //Crea el boton para ejecutar el calculo
        Button calcularButton = new Button("Calcular");
        grid.add(calcularButton, 1, 5);

        Label resultadoLabel = new Label();
        grid.add(resultadoLabel, 1, 6);

        calcularButton.setOnAction(event -> {
            double horasTrabajadas = Double.parseDouble(horasTrabajadasField.getText());
            double pagoPorHoraBase = Double.parseDouble(pagoPorHoraBaseField.getText());
            double horasExtras = Double.parseDouble(horasExtrasField.getText());
            double pagoPorHoraExtra = Double.parseDouble(pagoPorHoraExtraField.getText());
            LocalDate fechaInicio = fechaInicioPicker.getValue();
            LocalDate fechaActual = LocalDate.now();

            long añosTrabajados = ChronoUnit.YEARS.between(fechaInicio, fechaActual);
            double bonoAntiguedad =  añosTrabajados * 0.05;

            double salarioTotal = calcularSalarioTotal(horasTrabajadas, pagoPorHoraBase, horasExtras, pagoPorHoraExtra, bonoAntiguedad);
            resultadoLabel.setText("Salario Total: $" + salarioTotal);
        });

        Scene scene = new Scene(grid, 400, 350);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private double calcularSalarioTotal(double horasTrabajadas, double pagoPorHoraBase, double horasExtras, double pagoPorHoraExtra, double bonoAntiguedad) {
        // Aqui se hace la operacion para sacar el salario total con los datos que ya tenemos
        double salarioTotal = (horasTrabajadas * pagoPorHoraBase) + (horasExtras * pagoPorHoraExtra) + ((horasTrabajadas * pagoPorHoraBase)*bonoAntiguedad);
        return salarioTotal;
    }

    public static void main(String[] args) {
        launch(args);
    }
}


