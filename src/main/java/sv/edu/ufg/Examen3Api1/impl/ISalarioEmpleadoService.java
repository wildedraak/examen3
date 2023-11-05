package sv.edu.ufg.Examen3Api1.impl;

import sv.edu.ufg.Examen3Api1.model.SalarioEmplado;

public interface ISalarioEmpleadoService extends ICRUD<SalarioEmplado, Integer>{

    public default Double calcularRetencion(Double salario) {
        final Double desdeTramo1 = 0.01;
        final Double desdeTramo2 = 472.01;
        final Double desdeTramo3 = 895.25;
        final Double desdeTramo4 = 2038.11;
        final Double porcentajeAFP = 0.0725; // Valor del AFP es 7.25% para el trabajador
        final Double porcentajeISSS = 0.03; // Valor de retención ISSS 3% para el trabajador

        Double renta = 0.0;
        Double salarioNeto = -1000.0;

        if (salario >= desdeTramo1 && salario < desdeTramo2) {
            renta = salario * porcentajeAFP + salario * porcentajeISSS;
            salarioNeto = salario - renta;
        } else if (salario >= desdeTramo2 && salario < desdeTramo3) {
            renta = salario * porcentajeAFP + salario * porcentajeISSS;
            salarioNeto = salario - renta;
        } else if (salario >= desdeTramo3 && salario < desdeTramo4) {
            renta = salario * porcentajeAFP + salario * porcentajeISSS;
            salarioNeto = salario - renta;
        } else if (salario >= desdeTramo4) {
            renta = salario * porcentajeAFP + salario * porcentajeISSS;
            salarioNeto = salario - renta;
        }

        return salarioNeto;
    }
}
